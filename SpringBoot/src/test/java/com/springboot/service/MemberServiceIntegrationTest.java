package com.springboot.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.repository.MemberRepository;
import com.springboot.vo.Member;

@SpringBootTest
@Transactional 
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	@Commit
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("spring4");
		
		
		//when
		Long saveId = memberService.join(member);
		
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		
		//when
		memberService.join(member1);
		
		//then
	}
	
}//end class()
