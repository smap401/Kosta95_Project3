package com.boram3.yanolja.DTO;

public class TextliveBatterBean {
	private int b_backnumber;
	private int team_no_fk;
	private String b_name;
	private int atbat;
	private int hit;
	private int homerun;
	private float battingavg;
	///////////join data///////////
	private String team_name;
	
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	/////////////////////////////////////////
	public int getB_backnumber() {
		return b_backnumber;
	}
	public void setB_backnumber(int b_backnumber) {
		this.b_backnumber = b_backnumber;
	}
	public int getTeam_no_fk() {
		return team_no_fk;
	}
	public void setTeam_no_fk(int team_no_fk) {
		this.team_no_fk = team_no_fk;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getAtbat() {
		return atbat;
	}
	public void setAtbat(int atbat) {
		this.atbat = atbat;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getHomerun() {
		return homerun;
	}
	public void setHomerun(int homerun) {
		this.homerun = homerun;
	}
	public float getBattingavg() {
		return battingavg;
	}
	public void setBattingavg(float battingavg) {
		this.battingavg = battingavg;
	}
}
