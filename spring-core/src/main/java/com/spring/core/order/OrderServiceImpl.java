package com.spring.core.order;

import com.spring.core.discount.DiscountPolicy;
import org.springframework.stereotype.Component;

import com.spring.core.member.Member;
import com.spring.core.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
