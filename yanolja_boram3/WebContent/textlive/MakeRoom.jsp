<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MakeRoom_ok.jsp" method="post">
		<label>HOME : AWAY</label>
		<br>
		<input type="text" size="2" name="hometeam">&nbsp;
		<input type="text" size="2" name="awayteam">
		<select name="roomnumber">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>		
		<br>
		
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</body>
</html>