package com.dev.domain;

public class SessionClass{
	private long tableNo;
	private String startClassTime;
	private String endClassTime;
	private String subject;
	

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public long getTableNo() {
		return tableNo;
	}


	public void setTableNo(long tableNo) {
		this.tableNo = tableNo;
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
 
