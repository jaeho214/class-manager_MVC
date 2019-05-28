package com.dev.domain;

public class TimeTable {
	 private String number;
	   private String subject;
	   private String time;
	   private String professor;
	   private String room;
	   private int credit;
	   private String kinds;
	   private Member member;
	   
	   public TimeTable(String number, String subject, String time, String professor, String room,
	         int credit, String kinds, Member member) {
	      this.number = number;
	      this.subject = subject;
	      this.time = time;
	      this.professor = professor;
	      this.room = room;
	      this.credit = credit;
	      this.kinds = kinds;
	      this.member = member;
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

	   public String getTime() {
	      return time;
	   }

	   public void setTime(String time) {
	      this.time = time;
	   }

	   public Member getMember() {
	      return member;
	   }

	   public void setMember(Member member) {
	      this.member = member;
	   }


}
