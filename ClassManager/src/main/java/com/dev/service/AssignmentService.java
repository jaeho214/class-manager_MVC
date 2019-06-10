package com.dev.service;

import java.util.List;

import com.dev.domain.Assignment;

public interface AssignmentService {
	public List<Assignment> selectAssignment(String id);
	public void InsertNewAssignment(Assignment assignment);
	public void deleteAssignment(Long ano);
	public void AssignmentUpdate(Assignment assignment);
	public Assignment selectAnoAssignment(Long ano);
	public void InsertNewAssignementIncludeFile(Assignment assignment);
	public Assignment selectFno(long ano);
}
