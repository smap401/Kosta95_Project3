package com.boram3.yanolja.DTO;

import java.sql.Date;



public class MemberBean {
	
	private String userid;
	private String profile_pic;
	private String name;
	private String pwd;
	private int phone;
	private String email;
	private Date joindate;
	private int team_no_fk;
	
	///////////////////////////////////////
	private String team_name;
	private String authority;
	private int grade;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	///////////////////////////////////////////////
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getTeam_no_fk() {
		return team_no_fk;
	}
	public void setTeam_no_fk(int team_no_fk) {
		this.team_no_fk = team_no_fk;
	}
	
	

	
	/**
	 * @uml.property  name="mEMBER_ID"
	 *//*
	private String MEMBER_ID;
	*//**
	 * @uml.property  name="mEMBER_PW"
	 *//*
	private String MEMBER_PW;
	*//**
	 * @uml.property  name="mEMBER_NAME"
	 *//*
	private String MEMBER_NAME;
	*//**
	 * @uml.property  name="mEMBER_AGE"
	 *//*
	private int MEMBER_AGE;
	*//**
	 * @uml.property  name="mEMBER_GENDER"
	 *//*
	private String MEMBER_GENDER;
	*//**
	 * @uml.property  name="mEMBER_EMAIL"
	 *//*
	private String MEMBER_EMAIL;
	
	*//**
	 * @return
	 * @uml.property  name="mEMBER_ID"
	 *//*
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	*//**
	 * @param member_id
	 * @uml.property  name="mEMBER_ID"
	 *//*
	public void setMEMBER_ID(String member_id) {
		MEMBER_ID = member_id;
	}
	*//**
	 * @return
	 * @uml.property  name="mEMBER_PW"
	 *//*
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	*//**
	 * @param member_pw
	 * @uml.property  name="mEMBER_PW"
	 *//*
	public void setMEMBER_PW(String member_pw) {
		MEMBER_PW = member_pw;
	}
	*//**
	 * @return
	 * @uml.property  name="mEMBER_NAME"
	 *//*
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	*//**
	 * @param member_name
	 * @uml.property  name="mEMBER_NAME"
	 *//*
	public void setMEMBER_NAME(String member_name) {
		MEMBER_NAME = member_name;
	}
	*//**
	 * @return
	 * @uml.property  name="mEMBER_AGE"
	 *//*
	public int getMEMBER_AGE() {
		return MEMBER_AGE;
	}
	*//**
	 * @param member_age
	 * @uml.property  name="mEMBER_AGE"
	 *//*
	public void setMEMBER_AGE(int member_age) {
		MEMBER_AGE = member_age;
	}
	*//**
	 * @return
	 * @uml.property  name="mEMBER_GENDER"
	 *//*
	public String getMEMBER_GENDER() {
		return MEMBER_GENDER;
	}
	*//**
	 * @param member_gender
	 * @uml.property  name="mEMBER_GENDER"
	 *//*
	public void setMEMBER_GENDER(String member_gender) {
		MEMBER_GENDER = member_gender;
	}
	*//**
	 * @return
	 * @uml.property  name="mEMBER_EMAIL"
	 *//*
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	*//**
	 * @param member_email
	 * @uml.property  name="mEMBER_EMAIL"
	 *//*
	public void setMEMBER_EMAIL(String member_email) {
		MEMBER_EMAIL = member_email;
	}*/
}
