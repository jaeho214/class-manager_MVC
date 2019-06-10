package com.dev.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.domain.Assignment;
import com.dev.mapper.AssignmentMapper;
import com.dev.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	private AssignmentMapper assignmentMapper;

    public AssignmentServiceImpl(AssignmentMapper assignmentMapper){
        this.assignmentMapper = assignmentMapper;
    }

 // 과제 등록한거 찾아주는거
    @Override
    public List<Assignment> selectAssignment(String id) {
    	List<Assignment> list = assignmentMapper.selectAssignment(id);
    	return list;
    }
    
    // 새로운 과제 등록
    @Override
    public void InsertNewAssignment(Assignment assignment) {
        assignmentMapper.InsertNewAssignement(assignment);
    }
    
    // 과제 업데이트
    @Override
    public void AssignmentUpdate(Assignment assignment) {
    	assignmentMapper.assignmentUpdate(assignment);
    }
    
    // 과제 삭제
    @Override
    public void deleteAssignment(Long ano) {
    	assignmentMapper.deleteAssignment(ano);
    }
    
    // 업데이트할 게시글 찾기
    @Override
    public Assignment selectAnoAssignment(Long ano) {
    	Assignment assignment = assignmentMapper.selectAnoAssignment(ano);
    	return assignment;
    }
    
    @Override
    public void InsertNewAssignementIncludeFile(Assignment assignment) {
    	assignmentMapper.InsertNewAssignementIncludeFile(assignment);
    }
    
    @Override
    public Assignment selectFno(long ano) {
    	Assignment assignment = assignmentMapper.selectFno(ano);
    	return assignment;
    }
}
