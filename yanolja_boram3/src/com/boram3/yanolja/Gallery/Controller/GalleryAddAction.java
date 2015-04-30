package com.boram3.yanolja.Gallery.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.GalleryBean;
import com.boram3.yanolja.DAO.GalleryDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class GalleryAddAction implements Action {

		 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
		 throws Exception{
			GalleryDAO gallerydao=new GalleryDAO();
			GalleryBean gallerydata=new GalleryBean();
		   	ActionForward forward=new ActionForward();
		   	
			String realFolder="";
	   		String saveFolder="gallery_upload";
	   		
	   		int fileSize=5*1024*1024;
	   		
	   		realFolder=request.getRealPath(saveFolder);
	   		
	   		boolean result=false;
	   		
	   		try{
	   			MultipartRequest multi=null;
	   			
	   			multi=new MultipartRequest(request,
	   					realFolder,
	   					fileSize,
	   					"utf-8",
	   					new DefaultFileRenamePolicy());

	   			
	   			gallerydata.setUserid_fk(multi.getParameter("userid_fk"));
	   			gallerydata.setGal_content(multi.getParameter("gal_content"));
	   			gallerydata.setGal_filename(multi.getFilesystemName(
   						(String)multi.getFileNames().nextElement()));
	   			gallerydata.setGal_filesize(0);
		   		
		   		result=gallerydao.galleryInsert(gallerydata);
		   		
		   		if(result==false){
		   			System.out.println("사진 등록 실패");
		   			return null;
		   		}
		   		System.out.println("사진 등록 완료");
		   		
		   		forward.setRedirect(true);
		   		forward.setPath("./GalleryList.ga");
		   		return forward;
		   		
	  		}catch(Exception ex){
	   			ex.printStackTrace();
	   		}
	  		return null;
		}  	
	}
	
	
	

