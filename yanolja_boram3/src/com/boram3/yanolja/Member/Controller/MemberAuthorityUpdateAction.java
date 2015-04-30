package com.boram3.yanolja.Member.Controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.DTO.MemberBean;
import com.boram3.yanolja.DAO.MemberDAO;
import com.boram3.yanolja.Controller.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberAuthorityUpdateAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("utf-8");
		 	
		 	ActionForward forward = new ActionForward();
		 	
			MemberDAO memberdao=new MemberDAO();
	   		MemberBean member=new MemberBean();
	   		
	   		String realFolder="";
	   		String saveFolder="memberpic";
	   		
	   		realFolder = request.getRealPath(saveFolder);
	   		
	   		int pic_size = 10*1024*1024; //10M (Byte)


	   		boolean result=false;
	   		try{
	   			MultipartRequest multi =  new MultipartRequest(
	  	   		      request, //jsp가지는 request(요청객체) 얻어오기 
	  	   		      realFolder , // 저장경로 (물리적 경로)
	  	   		      pic_size , //파일크기(한번에 업로드 할수 있는 파일의 크기)10M 
	  	   		      "utf-8", //인코딩 처리 (한글)
	  	   		      new DefaultFileRenamePolicy() //파일명 중복처리 객체 사용
	  	   		);
	   			/*System.out.println("user이름"+multi.getParameter("userid"));*/
	   			
	   			member.setUserid(multi.getParameter("userid"));
	   			//member.setProfile_pic(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
	   			member.setGrade(Integer.parseInt(multi.getParameter("grade")));
		   		

		   		result=memberdao.authochMember(member);
		   		
		   		if(result==false){
		   			System.out.println("수정 실패");
			   		return null;
			   	}
		   		
		   		//수정 성공.
		   		forward.setRedirect(true);
		   		forward.setPath("./MemberViewAction.me");
		   		return forward;
	   		}catch(Exception ex){
	               ex.printStackTrace();
	            }
	           return null;
	   		
	}
}