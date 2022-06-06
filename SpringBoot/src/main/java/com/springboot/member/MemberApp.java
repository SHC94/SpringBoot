package com.springboot.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.AppConfig;

public class MemberApp {

	public static void main(String[] args) {

//		MemberService memberService = new MemberServiceImpl();
//		AppConfig appConfig 		= new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		//ApplicationContext, 스프링 컨테이너
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//param1 난 이 객체를 찾을거야.
		//param2 타입 
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member =  new Member(1L, "memberA", Grade.VIP);
		
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
		
	}
}
