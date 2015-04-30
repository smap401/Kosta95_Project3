package com.boram3.yanolja.DAO;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.boram3.yanolja.DTO.Gal_CommentBean;

public class Gal_CommentDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public Gal_CommentDAO() {
		try{
			Context init = new InitialContext();
	  	ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	////COMMENT WRITE//////////
	public ArrayList<Gal_CommentBean> galcowrite(Gal_CommentBean galcobean){
		int num =0;
		String sql="";
		int result=0;
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(
					"select max(gal_co_idx) from G_COMMENT");
			rs = pstmt.executeQuery();
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
     sql ="insert into G_COMMENT(gal_co_idx,gal_co_content, gal_co_writedate, userid_fk ,gal_idx_fk) values ("+
                 "?,?,sysdate,?,?)";
     pstmt = con.prepareStatement(sql);
     pstmt.setInt(1,num);
     pstmt.setString(2,galcobean.getGal_co_content());
     pstmt.setString(3,galcobean.getUserid_fk());
     pstmt.setInt(4,galcobean.getIdx_fk());
     result = pstmt.executeUpdate();
     String gal_co_list_sql="select * from g_comment where gal_idx_fk = ? order by gal_co_idx asc";
     ArrayList<Gal_CommentBean> list = new ArrayList<Gal_CommentBean>();
     pstmt = con.prepareStatement(gal_co_list_sql);
 	 pstmt.setInt(1,galcobean.getIdx_fk());
	 rs = pstmt.executeQuery();
	 while(rs.next()){
			galcobean = new Gal_CommentBean();
			galcobean.setIdx_fk(rs.getInt("gal_idx_fk"));
			galcobean.setGal_co_content(rs.getString("gal_co_content"));
			galcobean.setGal_co_idx(rs.getInt("gal_co_idx"));
			galcobean.setUserid_fk(rs.getString("userid_fk"));
			list.add(galcobean);
		}
		return list;
  }catch(Exception ex){
		System.out.println("galleryInsert 에러 : "+ex);
	}finally{
		if(rs!=null) try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		if(con!=null) try{con.close();}catch(SQLException ex){}
	}
	return null;
}
	
	/////COMMENT LIST////////////
	
	public ArrayList<Gal_CommentBean> getGalCoList(Gal_CommentBean galcobean){
		String gal_co_list_sql="select * from g_comment where gal_idx_fk = ? order by gal_co_idx asc";
		ArrayList<Gal_CommentBean> list = new ArrayList<Gal_CommentBean>();
		try{
			con=ds.getConnection();
			pstmt = con.prepareStatement(gal_co_list_sql);
			pstmt.setInt(1,galcobean.getIdx_fk());
			rs = pstmt.executeQuery();
			System.out.println("DAO");
			while(rs.next()){
				galcobean = new Gal_CommentBean();
				galcobean.setIdx_fk(rs.getInt("gal_idx_fk"));
				galcobean.setGal_co_content(rs.getString("gal_co_content"));
				galcobean.setGal_co_idx(rs.getInt("gal_co_idx"));
				galcobean.setUserid_fk(rs.getString("userid_fk"));
				list.add(galcobean);
			}
			return list;
		}catch(Exception ex){
			System.out.println("getGalleryList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	
}
