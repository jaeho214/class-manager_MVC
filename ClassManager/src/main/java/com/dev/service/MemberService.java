package com.dev.service;

import java.util.List;

import com.dev.domain.Member;

public interface MemberService {
	public List<Member> select(String id);
	public void insert(Member member);
	public void update(String id);
	public void delete(String id);
}
