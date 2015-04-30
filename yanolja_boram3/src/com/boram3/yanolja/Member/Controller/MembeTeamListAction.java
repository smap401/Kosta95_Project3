/*package com.boram3.yanolja.Member.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.DAO.MemberDAO;
import com.boram3.yanolja.Controller.ActionForward;

public class MembeTeamListAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
	   		
	   		List teamlist=new ArrayList();
	   		
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
	   		
	   		teamlist=memberdao.getTeamList();
	   		if(teamlist==null){
	   			System.out.println("회원 목록 읽기 실패");
	   			return null;
	   		}
	   		
	   		request.setAttribute("teamlist", teamlist);
	   		forward.setRedirect(false);
	   		forward.setPath("./member/member_list.jsp");
	   		return forward;
	}
}*/