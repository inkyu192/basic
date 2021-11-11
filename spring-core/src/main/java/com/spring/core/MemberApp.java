package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(member.getId());
		System.out.println("new Member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}
}
