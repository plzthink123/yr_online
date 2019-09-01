package com.think123.yr_online.dto;

public class PageParam {

    private Integer pageSize = 10;//每页记录数
    private Integer pageNum = 1;//页码

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
