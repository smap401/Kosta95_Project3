package com.boram3.yanolja.Member.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.DAO.MemberDAO;
import com.boram3.yanolja.Controller.ActionForward;

public class MemberDeleteAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
	   		
			boolean result=false;
			
	   		String userid=(String)session.getAttribute("userid");
	   		if(userid==null){
				forward.setRedirect(true);
				forward.setPath("./MemberLogin.me");
				return forward;
	   		}else if(!userid.equals("admin")){
	   			response.setContentType("text/html;charset=utf-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('관리자가 아닙니다.');");
		   		out.println("location.href='./BoardList.bo';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
	   		}
	   		
	   		String deleteId=request.getParameter("userid");
	   		result=memberdao.deleteMember(deleteId);
	   		
	   		if(result==false){
	   			System.out.println("회원 삭제 실패");
		   		return null;
		   	}
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./MemberListAction.me");
	   		return forward;
	}
}