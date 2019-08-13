package com.think123.yr_online.controller.safty;

import com.think123.yr_online.dto.MenuDto;
import com.think123.yr_online.service.safty.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/safty/home")
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	@GetMapping("/menu")
	public List<MenuDto> allMenus(){
		
		return homeService.getAllMenus();
	}
	
	
}
