package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.dev.domain.Classes;

public interface ClassesMapper {
	
	@Select("Select * from classes where table_no = #{no}")
	public List<Classes> selectAllClasses(long no);
	
	@Insert("Insert into classes (number,subject,time,date,professor,room,credit,kinds,user_id,table_no) "
			+ "values(#{number},#{subject},#{time},#{date},#{professor},#{room},#{credit},#{kinds},#{user_id},#{table_no})")
	public void insertClass(Classes classes);
	
}
