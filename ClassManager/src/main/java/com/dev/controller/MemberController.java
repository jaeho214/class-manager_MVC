package com.dev.controller;

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
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	//로그인 성공
	@PostMapping("/login.do")
	public String loginComplete(Member member, HttpSession session) {
		Member mem = memberService.selectAll(member.getId());
		if(mem == null) {
			return "idfail";
		}if(!mem.getPassword().equals(member.getPassword())) {
			return "pwfail";
		}
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
	
	//회원 탈퇴
	@PostMapping("/remove")
	public String memberRemove(Member member, HttpSession session) {
		Member mem = memberService.selectAll(member.getId());
		if(mem.getPassword().equals(member.getPassword())) {
			memberService.delete(member.getId());
			session.invalidate();
			return "removeComplete";
		}
		else {
			return "pwCheckFail";
		}
	}
	
	//회원 탈퇴를 위한 비밀번호 확인
	@PostMapping("pwCheck")
	public String pwCheck() {
		return "pwCheck";
	}
	
	@GetMapping("repwCheck")
	public String pwCheck2() {
		return "pwCheck";
	}
	
	@GetMapping("/memberInfo")
	public String memberInfo() {
		return "memberInfo";
	}
	
	
	//회원정보 수정 페이지
	@GetMapping("/modify")
	public String memberModify(Member member) {
		return "modify";
	}
	
	@PostMapping("modify.do")
	public String modifyComplete(Member member, HttpSession session) {
		if(member.getPassword().equals("")) {
			return "inputCheck";
		}
		else {
			memberService.update(member);
			session.setAttribute("member", member);
			return "main";
		}
	}
	
	
	
	
}
