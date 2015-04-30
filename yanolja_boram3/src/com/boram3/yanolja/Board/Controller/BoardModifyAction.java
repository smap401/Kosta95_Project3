package com.boram3.yanolja.Board.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.BoardBean;
import com.boram3.yanolja.DAO.BoardDAO;

 public class BoardModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("utf-8");
		 ActionForward forward = new ActionForward();
		 boolean result = false;
		 
		 int num=Integer.parseInt(request.getParameter("idx"));
		 
		 BoardDAO boarddao=new BoardDAO();
		 BoardBean boarddata=new BoardBean();
		 
		 boolean usercheck=boarddao.isBoardWriter(
				 				num, request.getParameter("userid_fk"));
		 if(usercheck==false){
		   		response.setContentType("text/html;charset=utf-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('수정할 권한이 없습니다.');");
		   		out.println("location.href='./BoardList.bo';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		 }
		 
		 try{
			 boarddata.setIdx(num);
			 boarddata.setSubject(
					 			request.getParameter("subject"));
			 boarddata.setContent(
					 			request.getParameter("content"));
			 
			 result = boarddao.boardModify(boarddata);
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath(
		   			 	"./BoardDetailAction.bo?num="+boarddata.getIdx());
		   	 //return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 
		 return forward;
	 }
}