package com.springboot.order;

import com.springboot.discount.DiscountPolicy;
import com.springboot.member.Member;
import com.springboot.member.MemberRepository;
import com.springboot.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//	private final MemberRepository memberRepository = new MemoryMemberRepository();
//	private final DiscountPolicy discountPolicy 	= new FixDiscountPolicy();	//인터페이스 + 구현체 의존
//	private final DiscountPolicy discountPolicy 	= new RateDiscountPolicy();	//인터페이스 + 구현체 의존
	
	//인터페이스 의존 (OrderServiceImpl 내에 DiscountPolicy 구현체를 대신 생성하고 주입해줘야 함..)
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy; 
	
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}



	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		//가입 회원 조회
		Member member 		= memberRepository.findById(memberId);
		
		//회원에 따른 할인 적용
		int discountPrice 	= discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
