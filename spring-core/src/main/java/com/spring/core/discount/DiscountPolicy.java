package com.spring.core.discount;

import com.spring.core.member.Member;

public interface DiscountPolicy {
	
	int discount(Member member, int price);
}
