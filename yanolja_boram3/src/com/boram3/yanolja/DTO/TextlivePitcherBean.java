package com.boram3.yanolja.DTO;

public class TextlivePitcherBean {
	private int p_backnumber;
	private int team_no_fk;
	private String p_name;
	private int win;
	private int lose;
	private int save;
	private float inning;
	private float era;
	
	public int getP_backnumber() {
		return p_backnumber;
	}
	public void setP_backnumber(int p_backnumber) {
		this.p_backnumber = p_backnumber;
	}
	public int getTeam_no_fk() {
		return team_no_fk;
	}
	public void setTeam_no_fk(int team_no_fk) {
		this.team_no_fk = team_no_fk;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	public float getInning() {
		return inning;
	}
	public void setInning(float inning) {
		this.inning = inning;
	}
	public float getEra() {
		return era;
	}
	public void setEra(float era) {
		this.era = era;
	}
}
