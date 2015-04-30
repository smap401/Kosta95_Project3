<%@page import="com.boram3.yanolja.DTO.GalleryBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	GalleryBean gallery = (GalleryBean)request.getAttribute("gallerydata");
	String userid=(String)session.getAttribute("userid"); 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	function modifygallery(){
		modifyform.submit();
	}
	</script>
</head>
<body>
<h3>사진 수정하기</h3>

	<form action="./GalleryModifyAction.ga" method="post" name="modifyform">
	<input type="hidden" name="userid_fk" value="<%=userid %>">
	<input type="hidden" name="gal_idx" value="<%=gallery.getGal_idx()%>">
	<input type="hidden" name="gal_filname" value="<%=gallery.getGal_filename()%>">
	<a href="./GalleryList.ga">X</a>
	<hr>
	
	<img alt="#" src="gallery_upload/<%=gallery.getGal_filename()%>" width="400" height="400">
	<br/>
	ID : <%=userid %> <br/>
	content :
	<input name="gal_content" size="50" maxlength="100" value="<%=gallery.getGal_content()%>">
	<br/>
	write_date : <%=gallery.getGal_writedate() %>
	<hr>
		
	<a href="javascript:modifygallery()">[수정]</a>
		
	</form>
	
	
</body>
</html>