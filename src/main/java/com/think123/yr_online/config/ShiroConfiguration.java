package com.think123.yr_online.config;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author plzthink123
 * 2019-08-13 09:48
 */
@Configuration
@Slf4j
public class ShiroConfiguration {
    private static final String CACHE_KEY = "shiro:cache:";
    private static final String SESSION_KEY = "shiro:session:";
    private static final String NAME = "name";
    private static final String VALUE = "/";

    /**
     * 配置跨域
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();

        // 允许cookies跨域
        config.setAllowCredentials(true);

        // 允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedOrigin("*");

        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");

        // 预检请求（options请求）的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(1L);

        // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod("*");
        /*
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        */

        //设置允许跨域的路径
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));

        // 设过滤器的优先级
        bean.setOrder(0);

        return bean;
    }

    @Bean
    @Autowired
    public ShiroFilterChainDefinition shiroFilterChainDefinition(ShiroService shiroService) {

        DefaultShiroFilterChainDefinition chainDefinition =
                new DefaultShiroFilterChainDefinition();


        /*
            可匿名访问资源
        */
        chainDefinition.addPathDefinition("/css/**", "anon");
        chainDefinition.addPathDefinition("/elementui/**", "anon");
        chainDefinition.addPathDefinition("/js/**", "anon");
        chainDefinition.addPathDefinition("/safty/login/**", "anon");

        //加载动态权限
        List<Module> moduleList = shiroService.getAllSubModules();

        String PREMISSION_FORMAT = "authc,perms[{0}]";
        String ROLE_FORMAT = "authc,perms[{0}]";

        //动态权限设置
        for (Module module : moduleList) {

            if (StringUtils.isEmpty(module.getM_url())) {
                continue;
            }

            chainDefinition.addPathDefinition(module.getM_url().replace("index.html", "**"), MessageFormat.format(PREMISSION_FORMAT, String.valueOf(module.getM_id())));

        }

        //其它资源必须经过认证
        chainDefinition.addPathDefinition("/**", "authc");

        log.debug("=====Shiro安全规则=======================================================================");
        log.debug(chainDefinition.getFilterChainMap().toString());
        log.debug("=====Shiro安全规则=======================================================================");

        return chainDefinition;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/loginTo");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //filterChainDefinitionMap.put("/index","authc");
        filterChainDefinitionMap.put("/safty/login/**", "anon");
        filterChainDefinitionMap.put("/**", "user");

        /* *//* 需要认证 *//*
        filterChainDefinitionMap.put("/*", "authc");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*.*", "authc");*/
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        log.info("###################shiro开始加载##################");
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    //自定义密码比较器
    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        return new CredentialMatcher();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * Cookie格式化
     *
     * @return
     */
    @Bean
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(NAME);
        simpleCookie.setValue(VALUE);
        return simpleCookie;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}