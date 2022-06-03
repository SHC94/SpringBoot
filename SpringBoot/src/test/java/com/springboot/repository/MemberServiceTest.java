package com.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.springboot.service.MemberServiceImpl;
import com.springboot.vo.Member;

public class MemberServiceTest {
	
	MemberServiceImpl memberService = new MemberServiceImpl();
	
	@AfterEach
	public void afterEach() {
		memberService.clearStore();
	}//end afterEach()
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		memberService.save(member);
		
		Member result = memberService.findById(member.getId()).get();
		
		System.out.println("result = " + (result == member));
		
		//Assertions.assertEquals(member, result);
		Assertions.assertThat(member).isEqualTo(result);
	}//end save()
	
	@Test
	public void findByName() {
	
		Member member1 = new Member();
		member1.setName("spring1");
		memberService.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberService.save(member2);
		
		Member result = memberService.findByName("spring1").get();
		
		assertThat(result).isEqualTo(member1);
	}//end findByName()
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		memberService.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberService.save(member2);
		
		List<Member> result = memberService.findAll();
		assertThat(result.size()).isEqualTo(2);
	}//end findAll()
}//end class()
