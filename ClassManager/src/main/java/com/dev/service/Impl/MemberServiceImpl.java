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
	
	// SELECT
	@Override
	public Member selectAll(String id) {
		return memberMapper.selectAll(id);
	}
	
	// INSERT
	@Override
	public void insertNewMember(Member member) {
		memberMapper.insertNewMember(member);
	}
	
	// UPDATE
	@Override
	public void update(String id) {
		memberMapper.update(id);
	}
	
	// DELETE
	@Override
	public void delete(String id) {
		memberMapper.delete(id);
	}
}
