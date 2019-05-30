package com.dev.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Member;


public interface MemberMapper {
	
	
	//로그인시 아이디 찾기
	@Select("SELECT * FROM member WHERE id = #{id}")
	public Member selectAll(@Param("id") String id);
	
	//회원가입
	@Insert("INSERT INTO member(id,password,name,email, univ, major, phone) VALUES (#{id}, #{password}, #{name}, #{email}, #{univ}, #{major}, #{phone})")
	public void insertNewMember(Member member);
	

	@Update("UPDATE member SET password = #{password}, name = #{name}, email = #{email}, univ = #{univ}, major=#{major}, phone=#{phone} WHERE id=#{id}")
	public void update(Member member);
	
	@Delete("DELETE FROM member WHERE id = #{id}")
	public void delete(@Param("id") String id);

	
	
	
}
