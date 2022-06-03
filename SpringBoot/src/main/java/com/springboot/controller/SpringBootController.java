package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.service.SpringBootService;
import com.springboot.vo.SpringBootVO;

@Controller
public class SpringBootController {

	@Autowired
	private SpringBootService springBootService;
	
	@GetMapping(value = "/springboot/list.do")
	public String springBootList(Model model) {
		
		SpringBootVO result = springBootService.selectSpringBootList();
		
		model.addAttribute("result", result);
		 
		return "list"; 
	}//end springBootList()
	
	
}//end class()
