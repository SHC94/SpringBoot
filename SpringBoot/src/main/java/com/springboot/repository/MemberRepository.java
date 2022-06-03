package com.springboot.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.vo.Member;

public interface MemberRepository {
	
	Member save(Member member);
	
	Optional<Member> findById(Long id);
	
	Optional<Member> findByName(String name);
	
	List<Member> findAll();
	
	void clearStore();
}//end interface()
