package com.dev.domain;

public class Classes {
	 //private long tno; 
	 private String number;
     private String subject;
     private String time;
     private String professor;
     private String date;
     private String room;
     private int credit;
     private String kinds;
     private String user_id;
     private long table_no;
     
     public Classes(String number, String subject, String time, String professor, String date, String room,
           int credit, String kinds, String user_id, long table_no) {
        //this.tno = tno;
    	this.number = number;
        this.subject = subject;
        this.time = time;
        this.professor = professor;
        this.date = date;
        this.room = room;
        this.credit = credit;
        this.kinds = kinds;
        this.user_id = user_id;
        this.table_no = table_no;
     }
     
     
     
     @Override
    public String toString() {
    	return "과목명 : " + subject;
    }
     
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public long getTable_no() {
		return table_no;
	}

	public void setTable_no(long table_no) {
		this.table_no = table_no;
	}
     
     
    

}
