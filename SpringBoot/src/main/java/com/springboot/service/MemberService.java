package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.repository.MemberRepository;
import com.springboot.vo.Member;

@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/**
	 * 회원 가입
	 */
	public Long join(Member member) {
		
		validationDuplicateName(member);	//중복 회원 검증
		
		memberRepository.save(member);
		
		return member.getId();
	}//end join()
	
	private void validationDuplicateName(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}//end validationDuplicateName()
	
	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}//end findMembers()
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}//end findOne()
	
}//end class()
