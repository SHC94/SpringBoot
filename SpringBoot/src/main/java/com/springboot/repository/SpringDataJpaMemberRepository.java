package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vo.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	Optional<Member> findByName(String name);
}