package com.think123.yr_online.config;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.service.ShiroService;
import com.think123.yr_online.service.safty.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-13 09:21
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private ShiroService shiroService;

    /**
     * 认证授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /*
         * 获取登录用户帐号
         */
        CurrUser currUser = (CurrUser) principalCollection.getPrimaryPrincipal();// 获取首要（第一）当事人

        /*
         * 创建授权信息对象
         */
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        /*
         * 查询用户权限，并将权限放入授权信息对象中
         */
        List<Module> moduleList = shiroService.getModulesOfUser(currUser.getUserId());
        for (Module module : moduleList) {
            simpleAuthorizationInfo.addStringPermission(String.valueOf(module.getM_id()));
        }

        // System.out.println(currUser.getUserId()+"->"+simpleAuthorizationInfo.getStringPermissions());

        /*
         * 返回授权信息
         */
        return simpleAuthorizationInfo;

    }

    /**
     * 认证登陆
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userId = (String) authenticationToken.getPrincipal();// 获得当事人（当前用户账号）

        User user = shiroService.getUser(userId);

                /*
              		如果不存在前用户信息，返回null
                */
        if (user == null) {
            return null;
        }

                /*
                	创建当前用户
                */
        CurrUser currUser = new CurrUser(user.getU_id(),user.getU_name());


                /*
                	创建认证信息，三个构造参数含义依次如下：
                	参数1：principal当前用户
               		参数2：credentials认证凭证（如：口令、密码等）
         			参数3：realm名称
                */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(currUser, user.getU_pwd(), this.getName());

                /*
                	返回认证信息
                */
        return info;
    }
}