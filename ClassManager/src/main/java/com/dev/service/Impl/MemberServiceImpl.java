package com.dev.service.Impl;

import org.springframework.stereotype.Service;

import com.dev.domain.Member;
import com.dev.mapper.MemberMapper;
import com.dev.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	@Override
	public void insert(Member member) {
		memberMapper.insert(member);
	}
}
