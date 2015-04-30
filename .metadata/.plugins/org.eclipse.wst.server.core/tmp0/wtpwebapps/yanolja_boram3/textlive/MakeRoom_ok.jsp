<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String hometeam = request.getParameter("hometeam");
	String awayteam = request.getParameter("awayteam");
	
	String msg = hometeam;
	request.setAttribute("board_msg", msg);
%>
<script>
	alert('<%=hometeam%>:<%=awayteam%>의 문자중계방이 개설되었습니다');
	location.href='Room.jsp';
</script>
	
