package com.dev.service;

import java.util.List;

import com.dev.domain.Classes;

public interface ClassesService {
	public List<Classes> selectAllClasses(long no);
	public Classes selectSubjectInfo(long table_no, String subject);
	public void insertClass(Classes classes);
}
