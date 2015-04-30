<%@page import="com.boram3.yanolja.Controller.ActionForward"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ActionForward forward=null;	
	session.invalidate();
	
%>
<script>
location.href='member/loginForm.jsp';
</script>