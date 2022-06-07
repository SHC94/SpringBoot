package com.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.discount.DiscountPolicy;
import com.springboot.discount.FixDiscountPolicy;
import com.springboot.discount.RateDiscountPolicy;
import com.springboot.member.MemberRepository;
import com.springboot.member.MemberService;
import com.springboot.member.MemberServiceImpl;
import com.springboot.member.MemoryMemberRepository;
import com.springboot.order.OrderService;
import com.springboot.order.OrderServiceImpl;

//@Configuration, 애플리케이션의 설정정보 
@Configuration
public class AppConfig {
	
	//@Bean 스프링 컨테이너에 등록.
	@Bean
	public MemberService memberService() {
		System.out.println("call AppConig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
