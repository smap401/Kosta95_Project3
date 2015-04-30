package com.boram3.yanolja.Member.Controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.DTO.MemberBean;
import com.boram3.yanolja.DAO.MemberDAO;
import com.boram3.yanolja.Controller.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberJoinAction implements Action{
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
	   			if(request.getParameter("pwd")!=request.getParameter("pwd1")){
		   			response.setContentType("text/html;charset=utf-8");
			   		PrintWriter out=response.getWriter();
			   		out.println("<script>");
			   		out.println("alert('비밀번호 확인에 비밀번호와 동일하게 작성해주시기 바랍니다.');");
			   		out.println("location.href='./MemberJoin.me';");
			   		out.println("</script>");
			   		out.close();
		   		}else{
	   			MultipartRequest multi =  new MultipartRequest(
	  	   		      request, //jsp가지는 request(요청객체) 얻어오기 
	  	   		      realFolder , // 저장경로 (물리적 경로)
	  	   		      pic_size , //파일크기(한번에 업로드 할수 있는 파일의 크기)10M 
	  	   		      "utf-8", //인코딩 처리 (한글)
	  	   		      new DefaultFileRenamePolicy() //파일명 중복처리 객체 사용
	  	   		);
	   			member.setUserid(multi.getParameter("userid"));
	   			member.setProfile_pic(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		   		//member.setProfile_pic(request.getParameter("profile_pic"));
		   		member.setName(multi.getParameter("name"));
		   		member.setPwd(multi.getParameter("pwd"));
		   		//member.setPhone(0);
		   		member.setPhone(Integer.parseInt(multi.getParameter("phone")));
		   		member.setEmail(multi.getParameter("email"));
		   		//member.setTeam_no_fk(0);
		   		member.setTeam_no_fk(Integer.parseInt(multi.getParameter("team_no_fk")));
		   		
		   		
		   		result=memberdao.joinMember(member);
		   		
		   		if(result==false){
		   			System.out.println("회원가입 실패");
			   		return null;
			   	}
		   		
		   		//회원가입 성공.
		   		forward.setRedirect(true);
		   		forward.setPath("./MemberLogin.me");
		   		return forward;
		   		}
	   		}catch(Exception ex){
	               ex.printStackTrace();
	            }
	           return null;
	   		
	}
}