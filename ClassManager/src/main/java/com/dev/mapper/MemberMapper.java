package com.dev.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Member;


public interface MemberMapper {
	
	
	//회원가입
	@Select("SELECT * FROM member WHERE id = #{id}")
	public Member selectAll(@Param("id") String id);
	
	@Insert("INSERT INTO member(id,password,name,email, univ, major, phone) VALUES (#{id}, #{password}, #{name}, #{email}, #{univ}, #{major}, #{phone})")
	public void insertNewMember(Member member);
	
	// 미완성
	@Update("UPDATE member SET id = #{id}, password = #{password}, name = #{name}, email = #{email}, univ = #{univ}, major=#{major}, phone=#{phone}) WHERE id=#{id}")
	public void update(@Param("id") String id);
	
	@Delete("DELETE FROM member WHERE id = #{id}")
	public void delete(@Param("id") String id);

	
	
	
}
