package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//index.html 만들었는디?
	//관련 컨트롤러..부터 찾고 없으면 정적 페이지 찾기.
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
