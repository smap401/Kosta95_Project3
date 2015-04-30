package com.boram3.yanolja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.boram3.yanolja.DTO.*;

public class TextlivePlayerDAO { 
	
	/**
	 * @uml.property  name="con"
	 */
	Connection con;
	/**
	 * @uml.property  name="pstmt"
	 */
	PreparedStatement pstmt;
	/**
	 * @uml.property  name="rs"
	 */
	ResultSet rs;
	/**
	 * @uml.property  name="ds"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DataSource ds;
	public TextlivePlayerDAO() {
		try{
			Context init = new InitialContext();
	  	ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  	
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//타자정보보기
	public TextliveBatterBean getDetail(int teamnumber, int backnumber) throws Exception{
		TextliveBatterBean batter = null;
		try{
			con = ds.getConnection();
		
			pstmt = con.prepareStatement(
					"select  t.team_name, b.b_name, b.b_backnumber, b.atbat, b.hit, b.homerun, b.battingavg" +
					"from batter b join team t" +
					"on b.team_no_fk = t.team_no" +
					"where t.team_no=? and b.b_backnumber=?");
			pstmt.setInt(1, teamnumber);
			pstmt.setInt(2, backnumber);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				batter = new TextliveBatterBean();
				batter.setB_backnumber(rs.getInt("b_backnumber"));
				batter.setB_name(rs.getString("B_name"));
				batter.setAtbat(rs.getInt("Atbat"));
				batter.setBattingavg(rs.getInt("Battingavg"));
				batter.setHit(rs.getInt("Hit"));
				batter.setHomerun(rs.getInt("Homerun"));
				batter.setTeam_no_fk(rs.getInt("Team_no_fk"));
			}
			return batter;
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
			if(con !=null)try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	
}