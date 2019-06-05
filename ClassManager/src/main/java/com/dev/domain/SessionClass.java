package com.dev.domain;

import java.util.Date;

public class SessionClass{
	private String startClassTime;
	private String endClassTime;
	private String subject;
	
//	public ClassDate(Date startClassTime, Date endClassTime, String subject) {
//		this.startClassTime = startClassTime;
//		this.endClassTime = endClassTime;
//		this.subject = subject;
//	}

	

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStartClassTime() {
		return startClassTime;
	}

	public void setStartClassTime(String startClassTime) {
		this.startClassTime = startClassTime;
	}

	public String getEndClassTime() {
		return endClassTime;
	}

	public void setEndClassTime(String endClassTime) {
		this.endClassTime = endClassTime;
	}

	public String getSubject() {
		return subject;
	}
	
	
}
 
