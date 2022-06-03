package com.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.springboot.vo.Member;

public class MemberServiceImpl implements MemberService {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}//end save()

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}//end findById()

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
			.filter(member -> member.getName().equals(name))
			.findAny();
	}//end findByName()

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}//end findAll()

	@Override
	public void clearStore() {
		store.clear();
	}//end clearStroe();

}//end class()
