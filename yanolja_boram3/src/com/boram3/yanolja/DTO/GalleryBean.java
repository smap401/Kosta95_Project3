package com.boram3.yanolja.DTO;

import java.sql.Date;

public class GalleryBean {
	private int gal_idx;
	private Date gal_writedate;
	private String gal_content;
	private String gal_filename;
	private int gal_filesize;
	private String userid_fk;
	public int getGal_idx() {
		return gal_idx;
	}
	public void setGal_idx(int gal_idx) {
		this.gal_idx = gal_idx;
	}
	public Date getGal_writedate() {
		return gal_writedate;
	}
	public void setGal_writedate(Date gal_writedate) {
		this.gal_writedate = gal_writedate;
	}
	public String getGal_content() {
		return gal_content;
	}
	public void setGal_content(String gal_content) {
		this.gal_content = gal_content;
	}
	public String getGal_filename() {
		return gal_filename;
	}
	public void setGal_filename(String gal_filename) {
		this.gal_filename = gal_filename;
	}
	public int getGal_filesize() {
		return gal_filesize;
	}
	public void setGal_filesize(int gal_filesize) {
		this.gal_filesize = gal_filesize;
	}
	public String getUserid_fk() {
		return userid_fk;
	}
	public void setUserid_fk(String userid_fk) {
		this.userid_fk = userid_fk;
	}
	
}
