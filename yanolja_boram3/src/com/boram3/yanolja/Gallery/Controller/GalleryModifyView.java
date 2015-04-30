package com.boram3.yanolja.Gallery.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.GalleryBean;
import com.boram3.yanolja.DAO.GalleryDAO;

public class GalleryModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 	ActionForward forward = new ActionForward();
		 	request.setCharacterEncoding("utf-8");
	   		
		GalleryDAO gallerydao=new GalleryDAO();
		GalleryBean gallerydata=new GalleryBean();
		   	
		int num=Integer.parseInt(request.getParameter("num"));
			
		boolean usercheck=gallerydao.isGalleryWriter(
		 				num, request.getParameter("userid"));
		if(usercheck==false){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('수정할 권한이 없습니다.');");
		out.println("location.href='./GalleryList.ga';");
		out.println("</script>");
		out.close();
		return null;
}
			gallerydata=gallerydao.getDetail(num);

		   	if(gallerydata==null){
		   		System.out.println("(수정)상세보기 실패");
		   		return null;
		   	}
		   	System.out.println("(수정)상세보기 성공");
		   	
		   	request.setAttribute("gallerydata", gallerydata);
		   	forward.setRedirect(false);
	   		forward.setPath("./gallery/gallery_modify.jsp");
	   		return forward;
	 }
}