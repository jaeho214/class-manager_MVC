package com.dev.mapper;

import org.apache.ibatis.annotations.Insert;

import com.dev.domain.Member;


public interface MemberMapper {
	
	
	//회원가입
	@Insert("INSERT INTO member(id,password,name,email, univ, major, phone) VALUES (#{id}, #{password}, #{name}, #{email}, #{univ}, #{major}, #{phone})")
	public void insert(Member member);
	
	

	
}
