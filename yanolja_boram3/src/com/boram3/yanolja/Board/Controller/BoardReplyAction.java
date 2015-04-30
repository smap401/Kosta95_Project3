package com.boram3.yanolja.Board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.BoardBean;
import com.boram3.yanolja.DAO.BoardDAO;

public class BoardReplyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 	request.setCharacterEncoding("utf-8");
		 	ActionForward forward = new ActionForward();
		 	
			BoardDAO boarddao=new BoardDAO();
	   		BoardBean boarddata=new BoardBean();
	   		int result=0;
	   		
	   		boarddata.setIdx(Integer.parseInt(request.getParameter("idx")));
	   		boarddata.setUserid_fk(request.getParameter("userid_fk"));
	   		boarddata.setSubject(request.getParameter("subject"));
	   		boarddata.setContent(request.getParameter("content"));
	   		boarddata.setRefer(Integer.parseInt(request.getParameter("refer")));
	   		boarddata.setDepth(Integer.parseInt(request.getParameter("depth")));
	   		boarddata.setStep(Integer.parseInt(request.getParameter("step")));
	   		
	   		result=boarddao.boardReply(boarddata);
	   		if(result==0){
	   			System.out.println("답장 실패");
	   			return null;
	   		}
	   		System.out.println("답장 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./BoardDetailAction.bo?num="+result);
	   		return forward;
	}  	
}