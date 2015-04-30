<%@page import="com.boram3.yanolja.DTO.TextliveRoomBean"%>
<%@page import="java.util.List"%>
<%@page import="com.boram3.yanolja.DTO.TextliveBatterBean"%>
<%@page import="com.boram3.yanolja.DTO.TextlivePitcherBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List roomlist = (List)request.getAttribute("roomlist");
	int bangnum = Integer.parseInt(request.getParameter("bangnum"));
	
	//List batterList=(List)request.getAttribute("batterlist");

%>
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
	<%
		//for(int i=0;i<batterList.size();i++){
			//TextliveBatterBean bl=(TextliveBatterBean)batterList.get(i);
	%>
		<a href="./TextliveViewPlayerInfoAction.te?team_no_fk=4&b_backnumber=16">정성훈</a>
		<a href="./TextliveViewPlayerInfoAction.te?team_no_fk=8&p_backnumber=54">양현종</a>
	<%
		//}
	%>
	</div>
	<div>
		<table>
		<%
			for(int i=0; i<roomlist.size(); i++){
				TextliveRoomBean rl = (TextliveRoomBean)roomlist.get(i);
		%>
			<tr>
				<th>겜넘</th>
				<th>방넘</th>
				<th>어웨이팀</th>
				<th>홈팀</th>
			</tr>
			<tr>
				<td><%= rl.getGamenum()%></td>
				<td><%= rl.getBangnum()%></td>
				<td><%= rl.getAwayteam_no()%></td>
				<td><%= rl.getHometeam_no()%></td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
	<div>
		<a href = "./TextliveViewRecordAction.te?bangnum1=<%=bangnum%>">문자중계보기</a>
		<a href = "./TextliveMakeRecord.te?bangnum=<%=bangnum%>">기록원페이지</a>
	</div>
</body>
</html>