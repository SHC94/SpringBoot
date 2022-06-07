package com.springboot.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.AppConfig;
import com.springboot.member.MemberService;
import com.springboot.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("이름 없이 타입으로만 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회 x")
	void findBeanByNameX() {
		//MemberService memberService = ac.getBean("xxx", MemberServiceImpl.class);
		//org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'xxx' available
		
		//오른쪽꺼 실행했을 때, 왼쪽 예외가 터져야 성공
		assertThrows(NoSuchBeanDefinitionException.class
							, () -> ac.getBean("xxx", MemberServiceImpl.class));
	}
	


	
}
