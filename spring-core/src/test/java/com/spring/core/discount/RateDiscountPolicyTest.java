package com.spring.core.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.spring.core.AppConfig;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;

//import�� *�� �������� ����.
//import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RateDiscountPolicyTest {

	DiscountPolicy discountPolicy;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		discountPolicy = appConfig.discountPolicy();
	}
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		//Assertions.assertThat(discount).isEqualTo(1000);
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
	void vip_x() {
		//given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		//Assertions.assertThat(discount).isEqualTo(1000);
		assertThat(discount).isEqualTo(0);
	}
}
