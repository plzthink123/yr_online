package com.think123.yr_online.dto;

import java.util.List;

public class MenuDto {

    private Integer menuId;
    private String menuName;

    private String menuUrl;

    private List<MenuDto> subMenuList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public List<MenuDto> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuDto> subMenuList) {
        this.subMenuList = subMenuList;
    }

}