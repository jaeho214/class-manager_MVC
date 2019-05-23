package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	//로그인 성공
	@PostMapping("/login.do")
	public String loginComplete(Member member, HttpSession session) {
		Member mem = memberService.selectAll(member.getId());
//		if(mem == null) {
//			System.out.println("없는 아이디!!");
//			return "login";
//		}if(mem.getPassword() != member.getPassword()) {
//			System.out.println("비밀번호 틀림!!");
//			return "login";
//		}
		session.setAttribute("member", mem);
		return "main";
	}
	
	//회원가입 완료
	@PostMapping("/signup.do")
	public String siguUpComplete(Member member) {
		member.getPassword();
		memberService.insertNewMember(member);
		return "login";
	}
	
	//로그아웃 완료
	@GetMapping("/logout")
	public String logout(Member member, HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	//회원 탈퇴 페이지
	public String memberRemove(Member member, HttpSession session) {
		
		return "login";
	}
	
	
	//회원정보 수정 페이지
	@PostMapping("/modify")
	public String memberModify(Member member, HttpSession session) {
		return "modify";
	}
	
	
	
}
