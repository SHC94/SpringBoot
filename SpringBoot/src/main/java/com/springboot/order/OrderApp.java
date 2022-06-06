package com.springboot.order;

import com.springboot.member.Grade;
import com.springboot.member.Member;
import com.springboot.member.MemberService;
import com.springboot.member.MemberServiceImpl;

public class OrderApp {

	//main method test
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		
		//회원 가입
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order.toString());
		//System.out.println("calculatePrice = " + order.calculatePrice());
		
	}
}
