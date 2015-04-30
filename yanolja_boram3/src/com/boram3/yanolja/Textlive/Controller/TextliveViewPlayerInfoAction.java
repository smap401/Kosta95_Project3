package com.boram3.yanolja.Textlive.Controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.TextlivePlayerDAO;

public class TextliveViewPlayerInfoAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward= new ActionForward();
		HttpSession session=request.getSession();
		
		/*String id=(String)session.getAttribute("id");
   		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
   		}*/
   		
   		TextlivePlayerDAO playerdao=new TextlivePlayerDAO();
		List playerlist=new ArrayList();
		   		  		
   		/*request.setAttribute("page", page);  //현재 페이지 수
   		request.setAttribute("maxpage", maxpage);  //최대 페이지 수
   		request.setAttribute("startpage", startpage);  //현재 페이지에 표시할 첫 페이지 수
   		request.setAttribute("endpage", endpage);  //현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount",listcount);  //글 수
		request.setAttribute("boardlist", boardlist);*/
		
	   	forward.setRedirect(false);
   		forward.setPath("./player/ViewPlayerInfo.jsp");
   		return forward;
	 }
 }