package com.boram3.yanolja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.boram3.yanolja.DTO.Gal_CommentBean;
import com.boram3.yanolja.DTO.Gal_ThumbsupBean;

public class Gal_ThumpsupDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSet rs1;
	ResultSet rs2;
	DataSource ds;
	public Gal_ThumpsupDAO() {
		try{
			Context init = new InitialContext();
	  	ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//GalthumbInsert  
	public int galthumbInsert(int gal_idx, String userid){
		int result=0;
		int num=0;
		String is_thumb_sql="select thumb from thumbsup where gal_idx= ? AND userid=?";
		try{
			con=ds.getConnection();
			pstmt = con.prepareStatement(is_thumb_sql);
			pstmt.setInt(1,gal_idx);
			pstmt.setString(2,userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
				
				String gal_thumbs_sql="select sum(thumb) from thumbsup where gal_idx = ?";
				pstmt = con.prepareStatement(gal_thumbs_sql);
				pstmt.setInt(1,gal_idx);
				rs = pstmt.executeQuery();
				while(rs.next()){
					num=rs.getInt(1);}
			return num;	
			}else{
			String gal_thumb_sql=" insert into THUMBSUP(gal_idx,thumb,userid) values ("+
                "?,?,?)";
			pstmt = con.prepareStatement(gal_thumb_sql);
			pstmt.setInt(1,gal_idx);
			pstmt.setInt(2,1);
			pstmt.setString(3,userid);
			pstmt.executeUpdate();

			String gal_thumbs_sql="select sum(thumb) from thumbsup where gal_idx = ?";
			pstmt = con.prepareStatement(gal_thumbs_sql);
			pstmt.setInt(1,gal_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				num=rs.getInt(1);
			}
		return num;
		}}
			catch(Exception ex){
			System.out.println("galtumbInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return num;
	}
	
	
	
	
	
}
