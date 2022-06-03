package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping(value = "hello")
	public String hello(Model model) {
	
		model.addAttribute("data", "Spring!!");
		
		return "hello";
	}//end hello()
	
	@GetMapping(value = "hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
		// required 
		// default = true
		// 파라미터 필수 여부 체크
		model.addAttribute("name", name);
		
		return "hello-template";
	}//end helloMvc()
	
	@GetMapping(value = "hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		//@ResponseBody 를 사용
		//HTTP의 BODY에 문자 내용을 직접 반환
		//viewResolver 대신에 HttpMessageConverter 가 동작
		//기본 문자처리: StringHttpMessageConverter
		//기본 객체처리: MappingJackson2HttpMessageConverter
		//byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
		
		//객체를 Json으로 바꿔주는 라이브러리 
		//1. Jackson (Spring default)
		//2. Gson
		
		return "hello" + name;
	}//end helloString()
	
	@GetMapping(value = "hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		
		return hello;
	}//end 
	
	static class Hello {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}//end class()
	
}//end class()