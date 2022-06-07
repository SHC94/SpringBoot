package com.springboot.singletion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.AppConfig;
import com.springboot.member.MemberRepository;
import com.springboot.member.MemberService;
import com.springboot.member.MemberServiceImpl;
import com.springboot.order.OrderService;
import com.springboot.order.OrderServiceImpl;

public class ConfigurationSingletionTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService =  ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		System.out.println("memberService > memberRepository = " + memberRepository1);
		System.out.println("orderService > memberRepository = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);
		
		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}
}
