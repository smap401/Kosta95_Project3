<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문자중계방</title>
</head>

	
<body>
	<%-- <h2><%=hometeam%> vs <%=awayteam%> 문자중계방</h2> --%>
	<h2>문자중계방</h2>
	<div>
		<img alt="중계창" src="<%=request.getContextPath()%>/images/scoreboard.jpg">
	</div>
	
	<div>
		<a href="<%=request.getContextPath()%>/player/ViewPlayerInfo.jsp" >정성훈</a>
		<a href="<%=request.getContextPath()%>/player/ViewPlayerInfo.jsp" >양현종</a>
	</div>
	
	
</body>
</html>