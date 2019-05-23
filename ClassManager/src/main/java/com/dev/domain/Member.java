package com.dev.domain;

public class Member {
	private String id;
	private String password;
	private String name;
	private String univ;
	private String major;
	private String email;
	private String phone;
	
	public Member(String id, String password, String name, String univ, String major, String email, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.univ = univ;
		this.major = major;
		this.email = email;
		this.phone = phone;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getName() { return name;}
	public void setName(String name) { this.name = name;}
	public String getUniv() { return univ; }
	public void setUniv(String univ) { this.univ = univ;}
	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major;}
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
	
	
}
