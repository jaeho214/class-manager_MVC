package com.dev.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Member;


/* MYSQL로 할 수 있는 조회, 생성, 갱신 ,삭제를 할 수 있는 코드 
 * 각각의 함수마다 어떤 쿼리를 수행하는지를 작성하는것이 끝*/
@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO member(id,password,name,email) VALUES(#{id},#{password},#{name},{email})")
	public void insert(Member member);
	
	
}
