<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.boram3.yanolja.DAO.GalleryDAO" %>
<%@ page import="com.boram3.yanolja.DTO.GalleryBean" %>    


<%
	String userid=null;
	if(session.getAttribute("userid")!=null){
		
		userid=(String)session.getAttribute("userid");
	}
	
	List galleryList=(List)request.getAttribute("gallerylist");

	for(int i=0;i<galleryList.size();i++){
		GalleryBean g1=(GalleryBean)galleryList.get(i);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href ="./GalleryDetailAction.ga?num=<%=g1.getGal_idx()%>">
	<img alt="" src="gallery_upload/<%=g1.getGal_filename()%>" width="200" height="200">
	</a>
<%

		}
%>	   	
		
<a href="./Gallerywrite.ga">[갤러리쓰기]</a>

</body>
</html>