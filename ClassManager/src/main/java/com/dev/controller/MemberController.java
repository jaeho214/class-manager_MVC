package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.domain.Member;
import com.dev.domain.TimeTable;
import com.dev.service.Impl.MemberServiceImpl;
import com.dev.service.Impl.TimeTableServiceImpl;

@Controller
public class MemberController {

	private MemberServiceImpl memberService;
	private TimeTableServiceImpl timeTableServiceImpl;

	public MemberController(MemberServiceImpl memberService, TimeTableServiceImpl timeTableServiceImpl) {
		this.memberService = memberService;
		this.timeTableServiceImpl = timeTableServiceImpl;
	}

	// 회원가입 페이지
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}

	// 회원가입 완료
	@PostMapping("/signup.do")
	public String siguUpComplete(Member member) {
		Member mem = memberService.selectAll(member.getId());
		if (mem == null) {
			if (member.getPassword().equals("")) {
				return "inputCheck";
			} else {
				member.getPassword();
				memberService.insertNewMember(member);
				return "login";
			}

		} else {
			return "alreayExist";
		}
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@GetMapping("/main")
	public String main(HttpSession session) {
		List<TimeTable> list = new ArrayList<TimeTable>();
		// timetable리스트 가져오기
		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
		Member nowMember = (Member) session.getAttribute("member");
		timetableList.forEach((item) -> {
			if (item.getUser_id().equals(nowMember.getId())) {
				list.add(item);
			}
		});
		session.setAttribute("timetableList", list);
		return "main";
	}

	// 로그인 성공
	@PostMapping("/login.do")
	public String loginComplete(Member member, HttpSession session) {
		Member mem = memberService.selectAll(member.getId());
		if (mem == null) {
			return "idfail";
		}
		if (!mem.getPassword().equals(member.getPassword())) {
			return "pwfail";
		}
		session.setAttribute("member", mem);

		List<TimeTable> list = new ArrayList<TimeTable>();
		// timetable리스트 가져오기
		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
		Member nowMember = (Member) session.getAttribute("member");
		timetableList.forEach((item) -> {
			if (item.getUser_id().equals(nowMember.getId())) {
				list.add(item);
			}
		});
		session.setAttribute("timetableList", list);

		return "main";
	}

	// 로그아웃 완료
	@GetMapping("/logout")
	public String logout(Member member, HttpSession session) {
		session.removeAttribute("member");
		return "login";
	}

	// 회원 탈퇴
	@PostMapping("/remove")
	public String memberRemove(Member member, HttpSession session) {
		Member mem = memberService.selectAll(member.getId());
		if (mem.getPassword().equals(member.getPassword())) {
			memberService.delete(member.getId());
			session.removeAttribute("member");
			return "removeComplete";
		} else {
			return "pwCheckFail";
		}
	}

	// 회원 탈퇴를 위한 비밀번호 확인
	@PostMapping("/pwCheck")
	public String pwCheck() {
		return "pwCheck";
	}

	// 비밀번호 확인에 실패했을 때 다시 입력
	@GetMapping("/repwCheck")
	public String pwCheck2() {
		return "pwCheck";
	}

	// 회원정보 확인
	@GetMapping("/memberInfo")
	public String memberInfo() {
		return "memberInfo";
	}

	// 회원정보 수정 페이지
	@GetMapping("/modify")
	public String memberModify() {
		return "modify";
	}

	// 회원정보 수정 완료
	@PostMapping("modify.do")
	public String modifyComplete(Member member, HttpSession session) {
		if (member.getPassword().equals("")) {
			return "inputCheck";
		} else {
			memberService.update(member);
			session.setAttribute("member", member);
			return "main";
		}
	}

}
