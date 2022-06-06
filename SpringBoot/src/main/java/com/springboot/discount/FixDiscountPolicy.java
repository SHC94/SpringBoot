package com.springboot.discount;

import com.springboot.member.Grade;
import com.springboot.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000;	//1000원 할인
	
	//회원 등급에 따른 할인 적용
	@Override
	public int discount(Member member, int price) {
		
		if(member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
		
	}

}