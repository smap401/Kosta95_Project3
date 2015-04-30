package com.boram3.yanolja.Member.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.DTO.MemberBean;
import com.boram3.yanolja.DAO.MemberDAO;
import com.boram3.yanolja.Controller.ActionForward;

public class MemberViewAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
	   		MemberBean member=new MemberBean();
	   		
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
	   		
	   		String viewId=request.getParameter("userid");
	   		member=memberdao.getDetailMember(viewId);
	   		//member=memberdao.getDetailMember(userid);
	   		
	   		if(member==null){
	   			System.out.println("회원 정보 보기 실패");
		   		return null;
		   	}
	   		
	   		request.setAttribute("member", member);
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("./member/member_info.jsp");
	   		return forward;
	}
}