package com.boram3.yanolja.Gallery.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.GalleryBean;
import com.boram3.yanolja.DAO.GalleryDAO;

public class GalleryDetailAction  implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{ 
		request.setCharacterEncoding("utf-8");

		GalleryDAO gallerydao=new GalleryDAO();
	   GalleryBean gallerydata=new GalleryBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		gallerydata = gallerydao.getDetail(num);
	   	
	   	if(gallerydata==null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("gallerydata", gallerydata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./gallery/gallery_view.jsp");
   		return forward;

	 }
	
	
}
