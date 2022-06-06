package com.springboot.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.AppConfig;
import com.springboot.member.Grade;
import com.springboot.member.Member;
import com.springboot.member.MemberService;

public class OrderApp {

	//main method test
	public static void main(String[] args) {
		
//		MemberService memberService = new MemberServiceImpl(null);
//		OrderService orderService = new OrderServiceImpl(null, null);
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService 	= applicationContext.getBean("orderService", OrderService.class);
		
		//회원 가입
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		System.out.println("order = " + order.toString());
		//System.out.println("calculatePrice = " + order.calculatePrice());
		
	}
}
