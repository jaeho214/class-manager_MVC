package com.dev.service.Impl;

import org.springframework.stereotype.Service;

import com.dev.domain.Assignment;
import com.dev.mapper.AssignmentMapper;
import com.dev.service.AssingmentService;

@Service
public class AssignmentServiceImpl implements AssingmentService {
	private AssignmentMapper assignmentMapper;

    public AssignmentServiceImpl(AssignmentMapper assignmentMapper){
        this.assignmentMapper = assignmentMapper;
    }

    @Override
    public void InsertNewAssignment(Assignment assignment) {
        assignmentMapper.InsertNewAssignement(assignment);
    }

}
