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

import com.boram3.yanolja.DTO.BoardBean;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public BoardDAO() {
		try{
			Context init = new InitialContext();
	  	ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  	
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//글의 개수 구하기.
	public int getListCount() {
		int x= 0;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	//글 목록 보기.	
	public List getBoardList(int page,int limit){
		String board_list_sql="select * from "+
		"(select ROWNUM rnum,idx,userid_fk,subject,"+
		"content,filename,filesize,refer,depth,"+
		"step,count,writedate from "+
		"(select * from board order by "+
		"refer desc,step asc)) "+
		"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호.
		int endrow=startrow+limit-1; //읽을 마지막 row 번호.		
		try{
			con=ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardBean board = new BoardBean();
				board.setIdx(rs.getInt("idx"));
				board.setSubject(rs.getString("subject"));
				board.setCount(rs.getInt("count"));
				board.setContent(rs.getString("content"));
				board.setWritedate(rs.getDate("writedate"));
				board.setFilename(rs.getString("filename"));
				board.setFilesize(rs.getInt("filesize"));
				board.setRefer(rs.getInt("refer"));
				board.setDepth(rs.getInt("depth"));
				board.setStep(rs.getInt("step"));
				board.setUserid_fk(rs.getString("userid_fk"));
				list.add(board);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getBoardList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 내용 보기.

	public BoardBean getDetail(int num) throws Exception{
		BoardBean board = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					"select * from board where idx = ?");
			pstmt.setInt(1, num);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				board = new BoardBean();
				board.setIdx(rs.getInt("idx"));
				board.setUserid_fk(rs.getString("userid_fk"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setFilename(rs.getString("filename"));
				board.setRefer(rs.getInt("refer"));
				board.setDepth(rs.getInt("depth"));
				board.setStep(rs.getInt("step"));
				board.setCount(rs.getInt("count"));
				board.setWritedate(rs.getDate("writedate"));
			}
			return board;
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
			if(con !=null)try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	
	//글 등록.
	public boolean boardInsert(BoardBean board){
		int num =0;
		String sql="";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(
					"select max(idx) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			sql="insert into board(idx,userid_fk,subject,content, filename,refer,depth,step,count) values(?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getUserid_fk());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFilename());
			pstmt.setInt(6, num);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("boardInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//글 답변.

	public int boardReply(BoardBean board){
		String board_max_sql="select max(idx) from BOARD";
		String sql="";
		int num=0;
		int result=0;
		
		int refer=board.getRefer();
		int depth=board.getDepth();
		int step=board.getStep();
		
		System.out.println("refer"+refer);
		System.out.println("stet"+step);
		System.out.println("dept"+depth);
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				num =rs.getInt(1)+1;
				}else{ 
					num=1;
				}
			
			sql="update BOARD set step=step+1 ";
			sql+="where refer=? AND step > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,refer);
			pstmt.setInt(2,step);
			
			result=pstmt.executeUpdate();
			
			step = step + 1;
			depth = depth + 1;
			
			System.out.println("refer"+refer);
			System.out.println("stet"+step);
			System.out.println("dept"+depth);
			
			sql="insert into BOARD (idx,subject,count,";
			sql+="content,writedate,filename,filesize,";
			sql+="refer,depth,step,userid_fk) ";
			sql+="values(?,?,?,?,sysdate,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setString(2,board.getSubject());
			pstmt.setInt(3, board.getCount());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFilename());
			pstmt.setInt(6, board.getFilesize());
			pstmt.setInt(7, refer);
			pstmt.setInt(8, depth);
			pstmt.setInt(9, step);
			pstmt.setString(10, board.getUserid_fk());
			pstmt.executeUpdate();
			return num;
		}catch(SQLException ex){
			System.out.println("boardReply 에러 : "+ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return 0;
	}
	
	
	//글 수정.
	
	public boolean boardModify(BoardBean modifyboard) throws Exception{
		String sql="update BOARD set subject=?,";
		sql+="content=? where idx=?";
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getSubject());
			pstmt.setString(2, modifyboard.getContent());
			pstmt.setInt(3, modifyboard.getIdx());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
			}
		return false;
	}
	
	
	//글 삭제.
	
	public boolean boardDelete(int num){
		String board_delete_sql=
			"delete from BOARD where idx=?";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("boardDelete 에러 : "+ex);
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return false;
	}
	
	
	//조회수 업데이트.
	
	public void setReadCountUpdate(int num) throws Exception{
		String sql="update BOARD set count = "+
			"count+1 where idx = "+num;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
	}
	
	
	//글쓴이인지 확인.
	public boolean isBoardWriter(int num,String userid){
		System.out.println("userid="+userid);
		String board_sql=
			"select * from BOARD where idx=?";
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(userid.equals(rs.getString("userid_fk"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isBoardWriter 에러 : "+ex);
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return false;
	}
	
}
	