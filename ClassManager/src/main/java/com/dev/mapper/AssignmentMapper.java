package com.dev.mapper;

import org.apache.ibatis.annotations.Insert;

import com.dev.domain.Assignment;

public interface AssignmentMapper {
	// 과제 추가
    @Insert("Insert into assignment (title,content,deadline,user_id) values(#{title},#{content},#{deadline},#{user_id})")
    public void InsertNewAssignement(Assignment assignment);
}
