package com.boram3.yanolja.Gallery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.Gal_CommentDAO;
import com.boram3.yanolja.DTO.Gal_CommentBean;



public class GalleryFrontController 
extends javax.servlet.http.HttpServlet 
implements javax.servlet.Servlet  {

		 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
			 String RequestURI=request.getRequestURI();
			 String contextPath=request.getContextPath();
			 String command=RequestURI.substring(contextPath.length());
			 ActionForward forward=null;
			 Action action=null;
			 
			 System.out.println(RequestURI);
			 System.out.println(contextPath);
			 System.out.println(command);
			 
			   if(command.equals("/Gallerywrite.ga")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("./gallery/gallery_FileUpload.jsp");
			   }

			   else if(command.equals("/GalleryModify.ga")){
				   action = new GalleryModifyView();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
				   
		 	   }
		 	   
		 	   else if(command.equals("/GalleryAddAction.ga")){
				   action  = new GalleryAddAction();
				   try {
					   forward=action.execute(request, response);
				   } catch (Exception e) {
					   e.printStackTrace();
				   }
			   }
			   
			   else if(command.equals("/GalleryModifyAction.ga")){
				   action = new GalleryModifyAction();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
			   }
			   
			   else if(command.equals("/GalleryDeleteAction.ga")){
				   action = new GalleryDeleteAction();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
			   }
			   
		 	   else if(command.equals("/GalleryList.ga")){
				   action = new GalleryListAction();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
			   }
		 	   else if(command.equals("/GalleryDetailAction.ga")){
				   action = new GalleryDetailAction();
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
			System.out.println("gallery");
			doProcess(request,response);
		}  	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			doProcess(request,response);
		}   	  	    
	}
	
	

