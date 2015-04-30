package com.boram3.yanolja.DTO;

import java.util.Date;

public class TextliveRecordBean {
	private int gamenum;
	private Date writedate;
	private int inning;
	private int goo;
	private String goocontent;
	private int ball;
	private int strike;
	private int out;
	private int onbase;
	private int homescore;
	private int awayscore;
	private int b_playerid;
	private int p_playerid;
	////////join data/////////////////////
	private int bangnum;
		
	public int getBangnum() {
		return bangnum;
	}
	public void setBangnum(int bangnum) {
		this.bangnum = bangnum;
	}
	/////////////////////////////////////
	public int getGamenum() {
		return gamenum;
	}
	public void setGamenum(int gamenum) {
		this.gamenum = gamenum;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public int getGoo() {
		return goo;
	}
	public void setGoo(int goo) {
		this.goo = goo;
	}
	public String getGoocontent() {
		return goocontent;
	}
	public void setGoocontent(String goocontent) {
		this.goocontent = goocontent;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getStrike() {
		return strike;
	}
	public void setStrike(int strike) {
		this.strike = strike;
	}
	public int getOut() {
		return out;
	}
	public void setOut(int out) {
		this.out = out;
	}
	public int getOnbase() {
		return onbase;
	}
	public void setOnbase(int onbase) {
		this.onbase = onbase;
	}
	public int getHomescore() {
		return homescore;
	}
	public void setHomescore(int homescore) {
		this.homescore = homescore;
	}
	public int getAwayscore() {
		return awayscore;
	}
	public void setAwayscore(int awayscore) {
		this.awayscore = awayscore;
	}
	public int getB_playerid() {
		return b_playerid;
	}
	public void setB_playerid(int b_playerid) {
		this.b_playerid = b_playerid;
	}
	public int getP_playerid() {
		return p_playerid;
	}
	public void setP_playerid(int p_playerid) {
		this.p_playerid = p_playerid;
	}
}
