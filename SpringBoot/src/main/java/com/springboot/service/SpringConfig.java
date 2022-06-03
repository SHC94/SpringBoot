package com.springboot.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.repository.JdbcMemberRepository;
import com.springboot.repository.MemberRepository;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {
	private final DataSource dataSource;

	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}

	@Bean
	public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}
