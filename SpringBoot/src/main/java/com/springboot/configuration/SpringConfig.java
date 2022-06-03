package com.springboot.configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.repository.JdbcMemberRepository;
import com.springboot.repository.JdbcTemplateMemberRepository;
import com.springboot.repository.JpaMemberRepository;
import com.springboot.repository.MemberRepository;
import com.springboot.service.MemberService;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {
	private final MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}