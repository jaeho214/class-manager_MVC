package com.dev.service;

import java.util.List;

import com.dev.domain.Assignment;

public interface AssignmentService {
	public List<Assignment> selectAssignment(String id);
	public Assignment selectFno(long ano);
	public Assignment selectAnoAssignment(Long ano);
	public void InsertNewAssignementIncludeFile(Assignment assignment);
	public void InsertNewAssignment(Assignment assignment);
	public void AssignmentUpdate(Assignment assignment);
	public void deleteAssignment(Long ano);
}
