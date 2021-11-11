package com.spring.core.discount;

import org.springframework.stereotype.Component;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
