<%@page import="com.boram3.yanolja.DAO.MemberDAO"%>
<%@page import="com.boram3.yanolja.DTO.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String idcheck = (String)request.getParameter("userid");
 	MemberDAO memberdao=new MemberDAO();
 	int result=0;
 	result=memberdao.getIdCheck(idcheck);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>
<%
if(result==1){
	%>
	중복된 아이디 입니다.
<%
}else if(result==0){
	%>
	사용가능한 아이디 입니다.
<%	
}

%>
</body>
</html>