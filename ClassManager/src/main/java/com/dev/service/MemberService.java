package com.dev.service;

import com.dev.domain.Member;

public interface MemberService {
	public Member selectAll(String id);
	public void insertNewMember(Member member);
	public void update(String id);
	public void delete(String id);
}
