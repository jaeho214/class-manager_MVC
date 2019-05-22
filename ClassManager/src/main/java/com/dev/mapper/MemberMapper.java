package com.dev.mapper;

import org.apache.ibatis.annotations.Select;


public interface MemberMapper {
	
	@Select("select now()")
	public String getTime();
	
	public String getTimeXml();
	
}
