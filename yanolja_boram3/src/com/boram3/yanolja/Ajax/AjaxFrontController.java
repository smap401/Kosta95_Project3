package com.boram3.yanolja.Ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.Gal_CommentDAO;
import com.boram3.yanolja.DAO.Gal_ThumpsupDAO;
import com.boram3.yanolja.DTO.Gal_CommentBean;
import com.boram3.yanolja.DTO.Gal_ThumbsupBean;

//@WebServlet("/DateController")
public class AjaxFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public AjaxFrontController() {
        super();
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Process(request,response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Process(request,response);
   }
   private void Process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{   
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
 	 String RequestURI=request.getRequestURI();
	 String contextPath=request.getContextPath();
	 String command=RequestURI.substring(contextPath.length());
	   
	 /////////GAl_Comment_List Ajax START/////
	  if(command.equals("/Gal_Comment_List.aj")){
		   try{
			   PrintWriter out = response.getWriter();
			   Gal_CommentDAO galcodao= new Gal_CommentDAO();
			   Gal_CommentBean galcobean = new Gal_CommentBean();
			   ArrayList<Gal_CommentBean> galcolist = new ArrayList<Gal_CommentBean>();
			   galcobean.setIdx_fk(Integer.parseInt(request.getParameter("gal_idx")));
			   galcolist = galcodao.getGalCoList(galcobean);
			   JSONArray galcommentlist = JSONArray.fromObject(galcolist);
			   response.getWriter().print(galcommentlist);
		   }catch(Exception e){
			   e.printStackTrace();}}
	  /////////GAl_Comment_List Ajax END/////	  
	  
	  
	  /////////GAl_Thumbs UP Ajax START/////
	  else if(command.equals("/Gal_Thumb.aj")){
		   try{
			   PrintWriter out = response.getWriter();
			   Gal_ThumpsupDAO galthumbdao = new Gal_ThumpsupDAO();
			   int gal_idx = Integer.parseInt(request.getParameter("gal_idx"));
			   String userid = request.getParameter("userid");
			   int thumbsup=0;
			   thumbsup = galthumbdao.galthumbInsert(gal_idx, userid);
			   System.out.println(thumbsup);
			   
			   JSONArray thumbsupnum = JSONArray.fromObject(thumbsup);
			   response.getWriter().print(thumbsupnum);
		   }catch(Exception e){
			   e.printStackTrace();}}
	  /////////GAl_Thumbs UP Ajax END/////
	  
	  
	  /////////GAl_COMMENT WRITE&LIST START/////
	  else if(command.equals("/Gal_Co_Write.aj")){
		   try{
			   PrintWriter out = response.getWriter();
			   Gal_CommentDAO galcodao = new Gal_CommentDAO();
			   Gal_CommentBean galcobean = new Gal_CommentBean();
			   ArrayList<Gal_CommentBean> galcolist = new ArrayList<Gal_CommentBean>();
			   galcobean.setIdx_fk(Integer.parseInt(request.getParameter("gal_idx")));
			   galcobean.setUserid_fk(request.getParameter("userid"));
			   galcobean.setGal_co_content(request.getParameter("gal_co_content"));
			   
			   galcolist = galcodao.galcowrite(galcobean);
			   
			   JSONArray galcolists= JSONArray.fromObject(galcolist);
			   response.getWriter().print(galcolists);
		   }catch(Exception e){
			   e.printStackTrace();}}
	  /////////GAl_COMMENT WRITE&LIST END/////
      
	  
	  
	  
	  
   }
}