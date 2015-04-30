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
import com.boram3.yanolja.DTO.GalleryBean;

public class GalleryDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public GalleryDAO() {
		try{
			Context init = new InitialContext();
	  	ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  	
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	
	//Gallery 등록.
	public boolean galleryInsert(GalleryBean gallery){
		int num =0;
		String sql="";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(
					"select max(gal_idx) from gallery");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
	
			sql="insert into gallery (gal_idx,gal_writedate,"+
			     "gal_content,gal_filename,gal_filesize,userid_fk) values(?,sysdate,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, gallery.getGal_content());
			pstmt.setString(3, gallery.getGal_filename());
			pstmt.setInt(4, gallery.getGal_filesize());
			pstmt.setString(5, gallery.getUserid_fk());
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("galleryInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//Gallery 목록
	
	public List getGalleryList(){
		String gallery_list_sql="select * from gallery order by gal_writedate asc";
		
		List list = new ArrayList();
				
		try{
			con=ds.getConnection();
			pstmt = con.prepareStatement(gallery_list_sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				GalleryBean gallery = new GalleryBean();
				gallery.setGal_idx(rs.getInt("gal_idx"));
				gallery.setGal_content(rs.getString("gal_content"));
				gallery.setGal_filename(rs.getString("gal_filename"));
				gallery.setGal_writedate(rs.getDate("gal_writedate"));
				gallery.setUserid_fk(rs.getString("userid_fk"));
				gallery.setGal_filesize(rs.getInt("gal_filesize"));
				
				list.add(gallery);
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
	
	//Gallery Detail
	public GalleryBean getDetail(int num) throws Exception{
		GalleryBean gallery = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					"select * from gallery where gal_idx = ?");
			pstmt.setInt(1, num);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				gallery = new GalleryBean();
				
				gallery.setGal_idx(rs.getInt("gal_idx"));
				gallery.setGal_content(rs.getString("gal_content"));
				gallery.setGal_filename(rs.getString("gal_filename"));
				gallery.setGal_writedate(rs.getDate("gal_writedate"));
				gallery.setUserid_fk(rs.getString("userid_fk"));
				gallery.setGal_filesize(rs.getInt("gal_filesize"));

			}
			return gallery;
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
			if(con !=null)try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//Gallery 수정.
	public boolean galleryModify(GalleryBean modifygallery) throws Exception{
		String sql="update GALLERY set gal_content=?";
		sql+="where gal_idx=?";
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifygallery.getGal_content());
			pstmt.setInt(2, modifygallery.getGal_idx());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("galleryModify 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
			}
		return false;
	}
	
	//Gallery 삭제.
		public boolean galleryDelete(int num){
			String gallery_delete_sql=
				"delete from GALLERY where gal_idx=?";
			
			int result=0;
			
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(gallery_delete_sql);
				pstmt.setInt(1, num);
				result=pstmt.executeUpdate();
				if(result==0)return false;
				
				return true;
			}catch(Exception ex){
				System.out.println("gallery Delete 에러 : "+ex);
			}finally{
				try{
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			
			return false;
		}
	
	
	//글쓴이인지 확인.
	public boolean isGalleryWriter(int num,String userid){
		System.out.println("id="+userid);
		String gallery_sql=
			"select * from GALLERY where gal_idx=?";
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(gallery_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("userid_fk"));
			if(userid.equals(rs.getString("userid_fk"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isGalleryWriter 에러 : "+ex);
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
