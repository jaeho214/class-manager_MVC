package com.dev.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.domain.Member;
import com.dev.mapper.MemberMapper;
import com.dev.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	public void insert(Member member) {
		memberMapper.insert(member);
	}

}
