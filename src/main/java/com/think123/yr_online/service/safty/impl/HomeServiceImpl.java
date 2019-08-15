package com.think123.yr_online.service.safty.impl;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dao.safty.HomeDao;
import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dto.MenuDto;
import com.think123.yr_online.service.safty.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeDao homeDao;

	@Override
	public List<MenuDto> getAllMenus() {
		
		List<Module> moduleList = homeDao.findAllModules();
		
		List<MenuDto> mainMenuList = new ArrayList<MenuDto>();
		
		MenuDto currMainMenu = null;
		for(Module module : moduleList) {
			if(currMainMenu==null || !module.getP_id().equals(currMainMenu.getMenuId())) {
				currMainMenu = new MenuDto();
				mainMenuList.add(currMainMenu);
				
				currMainMenu.setMenuId(module.getP_id());
				currMainMenu.setMenuName(module.getP_name());
				currMainMenu.setSubMenuList( new ArrayList<MenuDto>() );
			}
			
			MenuDto subMenu = new MenuDto();
			subMenu.setMenuId(module.getM_id());
			subMenu.setMenuName(module.getM_name());
			subMenu.setMenuUrl(module.getM_url());
			
			currMainMenu.getSubMenuList().add(subMenu);
			
		}
		
		return mainMenuList;
	}

	@Override
	public List<MenuDto> getMenusByCurrUser(CurrUser currUser) {
		String userId = currUser.getUserId();

		List<Module> moduleList = homeDao.findModulesByCurrUserId(userId);

		List<MenuDto> mainMenuList = new ArrayList<MenuDto>();

		MenuDto currMainMenu = null;
		for(Module module : moduleList) {
			if(currMainMenu==null || !module.getP_id().equals(currMainMenu.getMenuId())) {
				currMainMenu = new MenuDto();
				mainMenuList.add(currMainMenu);

				currMainMenu.setMenuId(module.getP_id());
				currMainMenu.setMenuName(module.getP_name());
				currMainMenu.setSubMenuList( new ArrayList<MenuDto>() );
			}

			MenuDto subMenu = new MenuDto();
			subMenu.setMenuId(module.getM_id());
			subMenu.setMenuName(module.getM_name());
			subMenu.setMenuUrl(module.getM_url());

			currMainMenu.getSubMenuList().add(subMenu);

		}

		return mainMenuList;
	}

	@Override
	public List<MenuDto> getMobileMenusByCurrUser(CurrUser currUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
