<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.boram3.yanolja.DAO.*" %>
<%@ page import="com.boram3.yanolja.DTO.*" %>
<%
	String userid=(String)session.getAttribute("userid");
	BoardBean board=(BoardBean)request.getAttribute("boarddata"); 
%>

<html>
<head>
	<title>MVC 게시판</title>
	<script language="javascript">
	function replyboard(){
		boardform.submit();
	}
	</script>
</head>
<body>
<!-- 게시판 답변 -->
<form action="./BoardReplyView.bo" method="post" name="boardform">
<input type="hidden" name="idx" value="<%=board.getIdx()%>">
<input type="hidden" name="refer" value="<%=board.getRefer() %>">
<input type="hidden" name="depth" value="<%=board.getDepth()%>">
<input type="hidden" name="step" value="<%=board.getStep()%>">
<input type="hidden" name="userid_fk" value="<%=userid%>">

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">MVC 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<%=userid %>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="subject" type="text" size="50" 
				maxlength="100" value="Re: <%=board.getSubject() %>"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="content" cols="67" rows="15"></textarea>
		</td>
	</tr>

	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
		<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
<!-- 게시판 답변 -->
</body>
</html>