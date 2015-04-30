package com.boram3.yanolja.Gallery.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.GalleryBean;
import com.boram3.yanolja.DAO.GalleryDAO;

 public class GalleryModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("utf-8");
		 ActionForward forward = new ActionForward();
		 boolean result = false;
		 int num=Integer.parseInt(request.getParameter("gal_idx"));
		 GalleryDAO gallerydao=new GalleryDAO();
		 GalleryBean gallerydata=new GalleryBean();
		 System.out.println(request.getParameter("userid"));
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
		 
		 try{
			 gallerydata.setGal_idx(num);
			 gallerydata.setGal_content(
					 			request.getParameter("gal_content"));
			 
			 result = gallerydao.galleryModify(gallerydata);
			 if(result==false){
		   		System.out.println("Gallery 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("Gallery 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath(
		   			 	"./GalleryDetailAction.ga?num="+gallerydata.getGal_idx());
		   	 //return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 
		 return forward;
	 }
}