package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
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
	public String siguUpComplete() {
		return "login";
	}
	
	
}
