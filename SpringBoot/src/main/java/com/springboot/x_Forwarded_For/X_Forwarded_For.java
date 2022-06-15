package com.springboot.x_Forwarded_For;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fowarded")
public class X_Forwarded_For {

	@GetMapping("/get/ipTest")
	@ResponseBody
	public String httpServletRequest(HttpServletRequest request) {
		String ip = getClientIP(request);
		return ip;
	}
	
	public static String getClientIP(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    System.out.println("> X-FORWARDED-FOR : " + ip);
	    
	    if (ip == null) {
	        ip = request.getHeader("Proxy-Client-IP");
	        System.out.println("> Proxy-Client-IP : " + ip);
	    }
	    if (ip == null) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	        System.out.println(">  WL-Proxy-Client-IP : " + ip);
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	        System.out.println("> HTTP_CLIENT_IP : " + ip);
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        System.out.println("> HTTP_X_FORWARDED_FOR : " + ip);
	    }
	    if (ip == null) {
	        ip = request.getRemoteAddr();
	        System.out.println("> getRemoteAddr : "+ip);
	    }
	    System.out.println("> Result : IP Address : "+ip);

	    return ip;
	}
	
}
