package com.boram3.yanolja.Board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DTO.BoardBean;
import com.boram3.yanolja.DAO.BoardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardAddAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		BoardDAO boarddao=new BoardDAO();
	   	BoardBean boarddata=new BoardBean();
	   	ActionForward forward=new ActionForward();
	   	
		String realFolder="";
   		String saveFolder="boardupload";
   		
   		int fileSize=5*1024*1024;
   		
   		realFolder=request.getRealPath(saveFolder);
   		
   		boolean result=false;
   		
   		try{
   			MultipartRequest multi=null;
   			
   			multi=new MultipartRequest(request,
   					realFolder,
   					fileSize,
   					"utf-8",
   					new DefaultFileRenamePolicy());
   			
   			boarddata.setUserid_fk(multi.getParameter("userid_fk"));
	   		boarddata.setSubject(multi.getParameter("subject"));
	   		boarddata.setContent(multi.getParameter("content"));
	   		boarddata.setFilename(
	   				multi.getFilesystemName(
	   						(String)multi.getFileNames().nextElement()));
	   		
	   		result=boarddao.boardInsert(boarddata);
	   		
	   		if(result==false){
	   			System.out.println("게시판 등록 실패!");
	   			return null;
	   		}
	   		System.out.println("게시판 등록 완료!");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./BoardList.bo");
	   		return forward;
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
  		return null;
	}  	
}