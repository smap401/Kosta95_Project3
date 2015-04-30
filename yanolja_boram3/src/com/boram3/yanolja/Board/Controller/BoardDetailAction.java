package com.boram3.yanolja.Board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.BoardBean;
import com.boram3.yanolja.DAO.BoardDAO;

 public class BoardDetailAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{ 
		request.setCharacterEncoding("utf-8");
   		
		BoardDAO boarddao=new BoardDAO();
	   	BoardBean boarddata=new BoardBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		boarddao.setReadCountUpdate(num);
	   	boarddata=boarddao.getDetail(num);
	   	
	   	if(boarddata==null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("boarddata", boarddata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./board/qna_board_view.jsp");
   		return forward;

	 }
}