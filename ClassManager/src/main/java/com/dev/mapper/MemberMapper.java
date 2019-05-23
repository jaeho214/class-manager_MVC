package com.dev.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface MemberMapper {
	
	@Select("select now()")
	public String getTime();
	
	@Select("select name from member where id='aa'")
	public String getName();
	
	@Insert("insert into member values('yhy24', '2014301052', '영훈', '서경대학교', '소프트웨어공학과', 'spawnnim@naver.com')")
	public void insertMember();
	
}
