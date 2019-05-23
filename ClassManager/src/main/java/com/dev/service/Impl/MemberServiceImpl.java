package com.dev.service.Impl;

import java.util.List;

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
	public List<Member> select(String id) {
		return memberMapper.select(id);
	}
	
	// INSERT
	@Override
	public void insert(Member member) {
		memberMapper.insert(member);
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
