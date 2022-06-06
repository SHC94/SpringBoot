package com.springboot.order;

import com.springboot.discount.DiscountPolicy;
import com.springboot.discount.FixDiscountPolicy;
import com.springboot.member.Member;
import com.springboot.member.MemberRepository;
import com.springboot.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy 	= new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		//가입 회원 조회
		Member member 		= memberRepository.findById(memberId);
		
		//회원에 따른 할인 적용
		int discountPrice 	= discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
