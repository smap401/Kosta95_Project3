package com.boram3.yanolja.Textlive.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;

 public class TextliveFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 static final long serialVersionUID = 1L;
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 System.out.println("textliveController");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		   
		   if(command.equals("/TextliveMakeRoom.te")){
			   forward=new ActionForward();
			   ////////////////////////////////////////
			   forward.setRedirect(false); //
			   //////////////////////////////////////
			   forward.setPath("./textlive/MakeRoom.jsp");
			   
		   }else if(command.equals("/TextliveRoom.te")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./textlive/EnterRoom.jsp");
			   
		   }else if(command.equals("/TextliveMakeRoomAction.te")){
			   action = new TextliveMakeRoomAction();
			   try{
				   //System.out.println(request.getParameter("user_id_fk"));
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/TextliveEnterRoom.te")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./textlive/EnterRoom.jsp");
			   
		   }else if(command.equals("/TextliveEnterRoomAction.te")){
			   action = new TextliveEnterRoomAction();
			   try{
				   System.out.println(request.getParameter("bangnum"));
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/TextliveViewPlayerInfoAction.te")){
			   action = new TextliveViewPlayerInfoAction();
			   try{
				   System.out.println(request.getParameter("teamnumber"));
				   System.out.println(request.getParameter("backnumber"));
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/TextliveViewRecordAction.te")){
			   action = new TextliveViewRecordAction();
			   try{
				   //System.out.println(request.getParameter("bangnum"));
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/TextliveMakeRecord.te")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./textlive/Recoder.jsp");
			   
		   }else if(command.equals("/TextliveMakeRecordAction.te")){
			   action = new TextliveMakeRecordAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }
		   if(forward != null){
		   if(forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
		   }else{
			   RequestDispatcher dispatcher=
				   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
		   }
		   }
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("get");
		doProcess(request,response);
		
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}   	  	      	    
}