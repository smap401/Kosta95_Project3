package com.boram3.yanolja.DTO;

import java.sql.Date;

public class Gal_CommentBean {
	private int gal_co_idx;
	private String gal_co_content;
	private Date gal_co_writedate;
	private String userid_fk;
	private int idx_fk;
	public int getGal_co_idx() {
		return gal_co_idx;
	}
	public void setGal_co_idx(int gal_co_idx) {
		this.gal_co_idx = gal_co_idx;
	}
	public String getGal_co_content() {
		return gal_co_content;
	}
	public void setGal_co_content(String gal_co_content) {
		this.gal_co_content = gal_co_content;
	}
	public Date getGal_co_writedate() {
		return gal_co_writedate;
	}
	public void setGal_co_writedate(Date gal_co_writedate) {
		this.gal_co_writedate = gal_co_writedate;
	}
	public String getUserid_fk() {
		return userid_fk;
	}
	public void setUserid_fk(String userid_fk) {
		this.userid_fk = userid_fk;
	}
	public int getIdx_fk() {
		return idx_fk;
	}
	public void setIdx_fk(int idx_fk) {
		this.idx_fk = idx_fk;
	}
	
	
	
	
	
	
	
}
