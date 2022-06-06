package com.springboot;

import com.springboot.discount.DiscountPolicy;
import com.springboot.discount.FixDiscountPolicy;
import com.springboot.discount.RateDiscountPolicy;
import com.springboot.member.MemberRepository;
import com.springboot.member.MemberService;
import com.springboot.member.MemberServiceImpl;
import com.springboot.member.MemoryMemberRepository;
import com.springboot.order.OrderService;
import com.springboot.order.OrderServiceImpl;

public class AppConfig {
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
