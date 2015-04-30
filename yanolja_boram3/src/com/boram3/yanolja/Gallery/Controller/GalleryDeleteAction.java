package com.boram3.yanolja.Gallery.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.GalleryBean;
import com.boram3.yanolja.DAO.GalleryDAO;

public class GalleryDeleteAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
	   	boolean result=false;
	   	boolean usercheck=false;
	   	int num=Integer.parseInt(request.getParameter("num"));
	   	
	   	GalleryDAO gallerydao=new GalleryDAO();
	   	usercheck=gallerydao.isGalleryWriter(num, id);
	   	
	   	if(usercheck==false){
	   		response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('삭제할 권한이 없습니다.');");
	   		out.println("location.href='./GalleryList.ga';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
	   	}
	   	
	   	result=gallerydao.galleryDelete(num);
	   	if(result==false){
	   		System.out.println("Gallery 삭제 실패");
	   		return null;
	   	}
	   	
	   	System.out.println("Gallery 삭제 성공");
	   	forward.setRedirect(true);
   		forward.setPath("./GalleryList.ga");
   		return forward;
	 }
}