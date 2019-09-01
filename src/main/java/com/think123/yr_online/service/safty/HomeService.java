package com.think123.yr_online.service.safty;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.MenuDto;

import java.util.List;

public interface HomeService {

    public List<MenuDto> getAllMenus();

    public List<MenuDto> getMenusByCurrUser(CurrUser currUser);

    public List<MenuDto> getMobileMenusByCurrUser(CurrUser currUser);

}