<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid=(String)session.getAttribute("userid"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>UI</title>

</head>
<body>
<h3>사진 올리기</h3>

	<form action="./GalleryAddAction.ga" method="post" enctype="multipart/form-data" name="galleryform">
	<input type="hidden" name="userid_fk" value="<%=userid %>">
		ID : <%=userid %> <br/>
		comment   : <input type="text" name="gal_content" /><br/>
		FILE이름 : <input type="file" name="gal_filename" /><br/>
		<a href="#" onclick="javascript:galleryform.submit();">[등록]</a>
		
	</form>
	
	
	
</body>

</html>