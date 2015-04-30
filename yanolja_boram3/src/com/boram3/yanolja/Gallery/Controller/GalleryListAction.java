package com.boram3.yanolja.Gallery.Controller;

	import java.util.*;

	import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.GalleryDAO;

	public class GalleryListAction implements Action {
		 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
			ActionForward forward= new ActionForward();
			HttpSession session=request.getSession();
			
			String userid=(String)session.getAttribute("userid");
	   		if(userid==null){
				forward.setRedirect(true);
				forward.setPath("./MemberLogin.me");
				return forward;
			
	   		}
	   		System.out.println("gallery_list_action");
	   		
	   		GalleryDAO gallerydao = new GalleryDAO();
	   		List gallerylist = new ArrayList();
	   		
	   		gallerylist = gallerydao.getGalleryList();
			request.setAttribute("gallerylist", gallerylist);
		   	forward.setRedirect(false);
	   		forward.setPath("./gallery/gallery_list.jsp");
	   		return forward;
		
	   		
		 }
	 }
	
	
	

