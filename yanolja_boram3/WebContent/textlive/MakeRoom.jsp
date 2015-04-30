<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./TextliveMakeRoomAction.te" method="post" name="makeroomform">
		<label> AWAY : HOME</label>
		<br>
		<select name="awayteam">
			<option>선택</option>
			<option value="1">삼성</option>
			<option value="2">넥센</option>
			<option value="3">NC</option>
			<option value="4">LG</option>
			<option value="5">SK</option>
			<option value="6">두산</option>
			<option value="7">롯데</option>
			<option value="8">KIA</option>
			<option value="9">한화</option>
			<option value="10">kt</option>
		</select>	
		
		<select name="hometeam">
			<option>선택</option>
			<option value="1">삼성</option>
			<option value="2">넥센</option>
			<option value="3">NC</option>
			<option value="4">LG</option>
			<option value="5">SK</option>
			<option value="6">두산</option>
			<option value="7">롯데</option>
			<option value="8">KIA</option>
			<option value="9">한화</option>
			<option value="10">kt</option>
		</select>
		
		<select name="bangnum">
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