<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.boram3.yanolja.DAO.Gal_CommentDAO" %>
<%@ page import="com.boram3.yanolja.DTO.Gal_CommentBean" %>    

<%
	String userid=null;

	if(session.getAttribute("userid")!=null){
		userid=(String)session.getAttribute("userid");
	}
	List galcolist =(List)request.getAttribute("galcolist");
	
	for(int i=0;i<galcolist.size();i++){
		Gal_CommentBean gc1=(Gal_CommentBean)galcolist.get(i);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border= "1" >
	<tr>
	<td>작성자 :</td><td><%=gc1.getUserid_fk()%></td>
	</tr>
	<tr>
    <td>내&nbsp;용 :</td><td><%=gc1.getGal_co_content() %></td>
    </table>       
<%
	
		}
%>	   	
		

</body>
</html>