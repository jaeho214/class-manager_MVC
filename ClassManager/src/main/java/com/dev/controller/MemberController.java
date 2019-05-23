package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.domain.Member;
import com.dev.service.Impl.MemberServiceImpl;

@Controller
public class MemberController {
	
	MemberServiceImpl memberService;
	
	public MemberController(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	//회원가입 페이지
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}
	
	//로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//메인 화면 페이지
	@PostMapping("/main")
	public String main() {
		return "main";
	}
	
	//회원가입 완료
	@PostMapping("/signup.do")
	public String siguUpComplete(Member member) {
		member.getPassword();
		memberService.insert(member);
		return "login";
	}
	
	
}
