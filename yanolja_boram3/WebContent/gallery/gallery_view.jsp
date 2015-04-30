<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.boram3.yanolja.DAO.GalleryDAO" %>
<%@ page import="com.boram3.yanolja.DTO.GalleryBean" %>
<%
	GalleryBean gallery = (GalleryBean)request.getAttribute("gallerydata");
	String userid=(String)session.getAttribute("userid");
%>
<html>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(function(){
	////COMMENT LIST 출력 비동기 START//////////////////
		var galcodata= {
				gal_idx : $('#gal_idx').val(),
	};
	$.ajax({
		type:"POST",
		url:"Gal_Comment_List.aj",
		data: galcodata,
		dataType:"html",
		success: function(responseData){
            var output = "";
            var galcodata = JSON.parse(responseData);
            $.each(galcodata,function(index,items){
            	output+="<tr><td>작성자</td><td>내용</td></tr>"+
            		"<tr><td>"+items.userid_fk+"</td><td>"+items.gal_co_content+"</td></tr>"
            });
            $("#gal_co_list").html(output);
		},
		error: function(Data){alert("error발생");}
		});
	return false;
});
	////COMMENT LIST 출력 비동기 END//////////
	
	
	////THUMB INSERT와 THUMBSNUM 출력 비동기 START//////////////////
$(function(){
	$('#thumbs').click(function(){
        var thumb= {
        		gal_idx : $('#gal_idx').val(),
        		userid : $('#userid').val()
        };
        $.ajax({
    		type:"POST",
    		url:"Gal_Thumb.aj",
    		data: thumb,
    		dataType:"html",
    		success: function(responseData){
                var output = "";
                var galcodata = JSON.parse(responseData);
                $.each(galcodata,function(index,items){
                	output+="추천수"+items
                });
                $("#thumbsc").html(output);
    		},
    		error: function(Data){alert("error발생");}
    		});
    	return false;
	});
});	
	////THUMB INSERT와 THUMBSNUM 출력 비동기 END//////////////////
	
	
	
	////GAL_COMMENT 생성 비동기 START///////////////////
$(function(){	
	$('#gal_co_submit').click(function(){
		
        var galcowrite= {
        		gal_co_content : $('#gal_co_content').val(),
        		userid : $('#userid').val(),
        		gal_idx : $('#gal_idx').val()
        };
        $.ajax({
    		type:"POST",
    		url:"Gal_Co_Write.aj",
    		data: galcowrite,
    		dataType:"html",
    		success: function(responseData){
                var output = "";
                var galcodata = JSON.parse(responseData);
                $.each(galcodata,function(index,items){
                	output+="<tr><td>작성자</td><td>내용</td></tr>"+
                		"<tr><td>"+items.userid_fk+"</td><td>"+items.gal_co_content+"</td></tr>"
                });
                $("#gal_co_list").html(output);
    			}
    		});
    	return false;
	});
});
////GAL_COMMENT 생성 비동기 END///////////////////


</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="./GalleryList.ga">X</a>
	<hr>
	<img alt="#" src="gallery_upload/<%=gallery.getGal_filename()%>" width="400" height="400">
	<br>
	content : <%=gallery.getGal_content()%>
	<br>
	write_date : <%=gallery.getGal_writedate() %>
	<hr>
	  <input type="hidden" name="gal_idx" id="gal_idx" value="<%=gallery.getGal_idx()%>">
	  <input type="hidden" name="userid" id="userid" value="<%=userid%>">
 
 
 
 <!--  COMMENT 생성 테이블 START --> 
 
 
     작성자 : <%=userid%><br/>
     내&nbsp;용 : <textarea name="gal_co_content" id="gal_co_content" rows="1" cols="40"></textarea>
    <input type="button" id="gal_co_submit" name="gal_co_submit" value="등록">
    
         
 <!--  COMMENT 생성 테이블 END --> 
 

<!-- 좋아요 출력단 START -->

	<div id="thumbsc">
	좋아요
	<input type="button" name="thumbs" id="thumbs">
	<img onclick="" name="thumbs" id="thumbs" alt="" src="images/heart.JPG" width="20" height="20">
	</div>
	
<!-- 좋아요 출력단 END -->	



<!-- COMMENT LIST 출력단 START-->
	
	<table id="gal_co_list" border="1">
	<tr><td colspan="2">COMMENT</td></tr>
	<tr><td>작성자</td><td>내용</td></tr>
	</table>
	
<!-- COMMENT LIST 출력단 END-->	

	<a href="./GalleryModify.ga?num=<%=gallery.getGal_idx() %>">수정</a>
	
	<a href="./GalleryDeleteAction.ga?num=<%=gallery.getGal_idx() %>">삭제</a>
	<hr>
	<a href="./GalleryDetailAction.ga?num=<%=gallery.getGal_idx()-1%>">이전</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="./GalleryDetailAction.ga?num=<%=gallery.getGal_idx()+1%>">다음</a>

</body>
</html>