package com.springboot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.repository.MemberRepository;
import com.springboot.repository.MemoryMemberRepository;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}
//	
//	@Bean
//	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//	}
}
