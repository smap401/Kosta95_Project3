package com.boram3.yanolja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.boram3.yanolja.DTO.MemberBean;
import com.boram3.yanolja.DTO.TeamBean;

public class MemberDAO {
	/**
	 * @uml.property  name="con"
	 */
	Connection con;
	/**
	 * @uml.property  name="pstmt"
	 */
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	
	Statement stmt;
	/**
	 * @uml.property  name="rs"
	 */
	ResultSet rs;
	/**
	 * @uml.property  name="ds"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DataSource ds;
	public MemberDAO() {
		try{
			Context init = new InitialContext();
	  		ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	
	public int isMember(MemberBean member){
		String sql="SELECT pwd FROM MEMBER WHERE userid=?";
		int result=-1;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("pwd").equals(
									member.getPwd())){
					result=1;//일치.
				}else{
					result=0;//불일치.
				}
			}else{
				result=-1;//아이디 존재하지 않음.
			}
		}catch(Exception ex){
			System.out.println("isMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	public boolean joinMember(MemberBean member){
		String sql1="INSERT INTO MEMBER(userid,profile_pic,name,pwd,phone,email,team_no_fk) VALUES (?,?,?,?,?,?,?)";
		String sql2="INSERT INTO AUTHORITIES values(?,1)";
		int result=0;
		int result2=0;
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql1);
			pstmt2=con.prepareStatement(sql2);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getProfile_pic());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPwd());
			pstmt.setInt(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setInt(7, member.getTeam_no_fk());
			pstmt2.setString(1, member.getUserid());
			
			result=pstmt.executeUpdate();
			result2=pstmt2.executeUpdate();
			
			
			if(result!=0){
				if(result2!=0){
					return true;
				}
			}
		}catch(Exception ex){
			System.out.println("joinMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	public boolean UpdateMember(MemberBean member){
		String sql1="UPDATE MEMBER SET pwd=?, phone=?,team_no_fk=? where userid=?";
		int result=0;
		try{
			System.out.println("update1");
			con = ds.getConnection();
			//stmt=con.createStatement();
			System.out.println("프로필사진이름"+member.getProfile_pic());
			pstmt=con.prepareStatement(sql1);
			//pstmt.setString(1, member.getProfile_pic());
			pstmt.setString(1, member.getPwd());
			pstmt.setInt(2, member.getPhone());
			pstmt.setInt(3, member.getTeam_no_fk());
			pstmt.setString(4, member.getUserid());
			
			result=pstmt.executeUpdate();
			//result=stmt.executeUpdate(sql1);
			System.out.println(member.getPwd() + member.getUserid());
			System.out.println("update2");
			System.out.println(result+"rrr");
			if(result!=0){
					return true;
			}
		}catch(Exception ex){
			System.out.println("updateMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	public boolean UpdateMemberPic(MemberBean member){
		String sql1="UPDATE MEMBER SET profile_pic=? where userid=?";
		int result=0;
		try{
			System.out.println("update1");
			con = ds.getConnection();
			//stmt=con.createStatement();
			System.out.println("프로필사진이름"+member.getProfile_pic());
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, member.getProfile_pic());

			pstmt.setString(2, member.getUserid());
			
			result=pstmt.executeUpdate();
			//result=stmt.executeUpdate(sql1);
			if(result!=0){
					return true;
			}
		}catch(Exception ex){
			System.out.println("updateMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	public boolean authochMember(MemberBean member){ // 권한변경
		String sql1="update (select m.userid, a.grade from member m join authorities a on m.userid = a.userid) autho set autho.grade=? where autho.userid=?";
		int result=0;
		try{
			System.out.println("update1");
			con = ds.getConnection();
			
			
			pstmt=con.prepareStatement(sql1);
				
			pstmt.setInt(1, member.getGrade());
			pstmt.setString(2, member.getUserid());
			
				
			result=pstmt.executeUpdate();

			System.out.println( member.getUserid());
			System.out.println("update2");
			System.out.println(result+"rrr");
			if(result!=0){
				return true;
			}
			}catch(Exception ex){
				System.out.println("updateAuthorityMember 에러: " + ex);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			
		return false;
	}
	
	public List getMemberList(){
		String sql="SELECT * FROM MEMBER order by userid asc";
		List memberlist=new ArrayList();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				MemberBean mb=new MemberBean();
				mb.setUserid(rs.getString("userid"));
				mb.setProfile_pic(rs.getString("profile_pic"));
				mb.setName(rs.getString("name"));
				mb.setPwd(rs.getString("pwd"));
				mb.setPhone(rs.getInt("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setJoindate(rs.getDate("joindate"));
				mb.setTeam_no_fk(rs.getInt("team_no_fk"));
				memberlist.add(mb);
			}
			
			return memberlist;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public List getSearchMember(String searchid){
		String sql="SELECT * FROM MEMBER where userid like '%"+searchid+"%' order by userid asc";
		List memberlist=new ArrayList();
		
		try{
			System.out.println("search1");
			System.out.println(searchid);
			con=ds.getConnection();
			stmt=con.createStatement();
			//pstmt=con.prepareStatement(sql);
			//pstmt.setString(1,searchid);
			//rs=pstmt.executeQuery();
			rs=stmt.executeQuery(sql);
			System.out.println("search2");
			while(rs.next()){
				MemberBean mb=new MemberBean();
				mb.setUserid(rs.getString("userid"));
				mb.setProfile_pic(rs.getString("profile_pic"));
				mb.setName(rs.getString("name"));
				mb.setPwd(rs.getString("pwd"));
				mb.setPhone(rs.getInt("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setJoindate(rs.getDate("joindate"));
				mb.setTeam_no_fk(rs.getInt("team_no_fk"));
				memberlist.add(mb);
			}
		/*String sql="SELECT * FROM MEMBER where userid like ? order by userid asc";
		List memberlist=new ArrayList();
		
		try{
			System.out.println("search1");
			System.out.println(searchid);
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,searchid);
			rs=pstmt.executeQuery();
			System.out.println("search2");
			while(rs.next()){
				MemberBean mb=new MemberBean();
				mb.setUserid(rs.getString("userid"));
				mb.setProfile_pic(rs.getString("profile_pic"));
				mb.setName(rs.getString("name"));
				mb.setPwd(rs.getString("pwd"));
				mb.setPhone(rs.getInt("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setJoindate(rs.getDate("joindate"));
				mb.setTeam_no_fk(rs.getInt("team_no_fk"));
				memberlist.add(mb);
			}*/
			
			return memberlist;
		}catch(Exception ex){
			System.out.println("getSearchMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public int getIdCheck(String idcheck){
		System.out.print(idcheck);
		String sql="select userid from member where userid = '"+idcheck+"'";
		int result=0;
		try{
			
			System.out.println("search1");
			con=ds.getConnection();
			stmt=con.createStatement();
			System.out.println(idcheck);
			rs=stmt.executeQuery(sql);
			System.out.println("search2");
			if(rs.next()){
				if(rs.getString("userid").equals(idcheck)){
					result=1;//중복
				}else{
					result=0;//중복x
				}
				
			}
		
			return result;
		}catch(Exception ex){
			System.out.println("getSearchMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return result;
	}
	
	public MemberBean getDetailMember(String userid){
		//String sql="SELECT * FROM MEMBER WHERE userid=?";
		String sql="select m.USERID,m.PROFILE_PIC,m.NAME,m.PHONE,m.EMAIL,te.TEAM_NAME,m.JOINDATE,m.authority from team te join (select me.USERID,me.PROFILE_PIC,me.NAME,me.PHONE,me.EMAIL,me.TEAM_NO_FK,me.JOINDATE,auro.authority from member me join (select au.USERID,ro.AUTHORITY from authorities au join roles ro on au.grade = ro.grade) auro on me.USERID=auro.userid) m on te.team_no=m.team_no_fk where m.USERID=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			System.out.println("detail check 1");
			
			if(rs.next()){
			
			MemberBean mb=new MemberBean();
			mb.setUserid(rs.getString("userid"));
			mb.setProfile_pic(rs.getString("profile_pic"));
			mb.setName(rs.getString("name"));
			mb.setPhone(rs.getInt("phone"));
			mb.setEmail(rs.getString("email"));
			mb.setTeam_name(rs.getString("team_name"));
			mb.setJoindate(rs.getDate("joindate"));
			mb.setAuthority(rs.getString("authority"));
			
			System.out.println("detail check 2");
			return mb;
			}
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	public MemberBean getMyDetail(String userid){
		System.out.println("getMyDetail1");
		//String sql="SELECT * FROM MEMBER WHERE userid=?";
		String sql="select m.USERID,m.PROFILE_PIC,m.pwd,m.NAME,m.PHONE,m.EMAIL,t.TEAM_NAME,m.JOINDATE from team t join member m on t.team_no=m.team_no_fk where m.USERID=?";
		
		try{
			
			System.out.println("getMyDetail2"+userid);
			
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				
				System.out.println("getMyDetail3");
				
				MemberBean mb=new MemberBean();
				mb.setUserid(rs.getString("userid"));
				mb.setProfile_pic(rs.getString("profile_pic"));
				mb.setName(rs.getString("name"));
				mb.setPwd(rs.getString("pwd"));
				mb.setPhone(rs.getInt("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setJoindate(rs.getDate("joindate"));
				mb.setTeam_name(rs.getString("team_name"));
				
				System.out.println("getMyDetail4");
				return mb;
			}
		}catch(Exception ex){
			System.out.println("getMyDeatil 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	
	public boolean deleteMember(String userid){
	 //String sql ="delete from authorities where userid=?; delete from board where userid_fk=?; delete from member where userid=?";
		String sql1="delete from authorities where userid=?";
		String sql2="delete from g_comment where userid_fk=?";
		String sql3="delete from b_comment where userid_fk=?";
		String sql4="delete from gallery where userid_fk=?";
		String sql5="delete from board where userid_fk=?";
		String sql6="delete from member where userid=?";

		int result1=0;
		int result2=0;
		int result3=0;
		int result4=0;
		int result5=0;
		int result6=0;
		boolean result =false;
		System.out.println("deleteId="+userid);
		try{
			con=ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, userid);
			result1=pstmt.executeUpdate();

			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1, userid);
			result2=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement(sql3);
			pstmt.setString(1, userid);
			result3=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement(sql4);
			pstmt.setString(1, userid);
			result4=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement(sql5);
			pstmt.setString(1, userid);
			result5=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement(sql6);
			pstmt.setString(1, userid);
			result6=pstmt.executeUpdate();
			
			if(result6>0){
				result = true;
			}
			
		}catch(Exception ex){
			System.out.println("deleteMember 에러: " + ex);	
		}finally{
			try{
			if(result){
				con.commit();
			}
			else{
				con.rollback();
			}
			}
			catch(Exception e){};
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	/*
	public List getTeamList(){
		String sql="SELECT * FROM TEAM order by team_no asc";
		List teamlist=new ArrayList();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				TeamBean tb=new TeamBean();
				tb.setTeam_no(rs.getInt("team_no"));
				tb.setTeam_name(rs.getString("team_name"));
				
				teamlist.add(tb);
			}
			
			return teamlist;
		}catch(Exception ex){
			System.out.println("getTeamList 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	*/
	
	/*public boolean deleteMember(String userid){
		String sql1 = "DELETE FROM BOARD WHERE userid_fk=?";
		String sql2="DELETE FROM MEMBER WHERE userid=?";
		boolean isSuccess = false;
		int result1=0;
		int result2=0;
		boolean result =false;
		System.out.println("deleteId="+userid);
		try{
			con=ds.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, userid);
			result1=pstmt.executeUpdate();

			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1, userid);
			result2=pstmt.executeUpdate();
			if(result1>0 && result2>0){
				result = true;
			}
			isSuccess=true;
		}catch(Exception ex){
			System.out.println("deleteMember 에러: " + ex);	
		}finally{
			try{
			if(isSuccess){
				con.commit();
			}
			else{
				con.rollback();
			}
			}
			catch(Exception e){};
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}*/
}