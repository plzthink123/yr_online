package com.think123.yr_online.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dto.PageParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static <T> PageInfo<T> createPageInfo(PageParam pageParam, QueryAction<T> action) {
        PageHelper.startPage(pageParam);
        List<T> list = action.execute();
        PageInfo<T> page = new PageInfo<T>(list);
        return page;
    }

    /**
     * 将PageInfo转化为页面需要的分页数据格式
     *
     * @param page
     * @return
     */
    public static Map<String, Object> convert2PageData(PageInfo<?> page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());//总记录数
        map.put("rows", page.getList());//当前页数据
        map.put("pageNum", page.getPageNum());//当前页码
        map.put("pageSize", page.getPageSize());//每页记录数
        map.put("currPageSize", page.getList().size());//当前页实际记录数
        map.put("pageTotal", page.getPages());    //总页数
        map.put("next", page.getNextPage());//下页码
        map.put("previous", page.getPrePage());    //上页码
        return map;
    }

}
