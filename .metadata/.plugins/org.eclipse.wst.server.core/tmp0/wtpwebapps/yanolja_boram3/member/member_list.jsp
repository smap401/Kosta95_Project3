<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.boram3.yanolja.DAO.*" %>
<%@ page import="com.boram3.yanolja.DTO.*" %>
<%
	List memberlist = (List)request.getAttribute("memberlist");
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="style/ico/favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/style.css" rel="stylesheet">
    <link href="style/css/font-awesome.min.css" rel="stylesheet">
    <link href="style/js/fancybox/jquery.fancybox.css" rel="stylesheet" />
<script>
function CallConfirm() {//사용자 정의 함수
	if(window.confirm("삭제할까요")){ 
		document.deleteok.submit();
	
	}else{
		
	}
}
/* <form action="./MemberDeleteAction.me" method="post" name="deleteok">
<td>
<input type="button" value="삭제" onclick="CallConfirm()" >
</td>
</form> */
</script>
</head>
<body data-spy="scroll" data-offset="0" data-target="#theMenu">
<!-- Menu -->
	<nav class="menu" id="theMenu">
		<div class="menu-wrap">
			<h1 class="logo"><a href="index.html#home">DSGN NYC</a></h1>
			<i class="fa fa-times menu-close"></i>
			<a href="#home" class="smoothScroll">Home</a>
			<a href="#about" class="smoothScroll">About</a>
			<a href="#portfolio" class="smoothScroll">Portfolio</a>
			<a href="#services" class="smoothScroll">Services</a>
			<a href="#contact" class="smoothScroll">Contact</a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-dribbble"></i></a>
			<a href="#"><i class="fa fa-envelope"></i></a>
		</div>
		
		<!-- Menu button -->
		<div id="menuToggle"><i class="fa fa-bars"></i></div>
	</nav>

	
<center>

<%-- <table border=1 width=300>
	<tr align=center>
		<td colspan=2>회원 목록</td>
	</tr>
	<%
	for(int i=0;i<memberlist.size();i++){ 
	MemberBean member=(MemberBean)memberlist.get(i);
	%>
	<tr align=center>
		<td>
			<a href="MemberViewAction.me?userid=<%=member.getUserid() %>">
				<%=member.getUserid() %>
			</a>
		</td>
		<td>
		<a href="MemberDeleteAction.me?userid=<%=member.getUserid() %>">삭제</a>
		</td>
	</tr>
	<%} %>
	<form action="./MemberSearchAction.me" method="post">
	<tr align=center>
		<td colspan=2>
			<input type="text" name="searchMember" />
			<input type="submit" value="검색" />
		</td>
	</tr>
	</form>
	<tr align=center>
		<td colspan=2>
			<a href="./BoardList.bo">[게시판 이동]</a>
		</td>
	</tr>
</table> --%>

<table border=1 width=300>
	<tr align=center>
		<td colspan=2>회원 목록</td>
	</tr>
	<%
	for(int i=0;i<memberlist.size();i++){ 
	MemberBean member=(MemberBean)memberlist.get(i);
	%>
	<tr align=center>
		<td>
			<a href="MemberViewAction.me?userid=<%=member.getUserid() %>">
				<%=member.getUserid() %>
			</a>
		</td>
		<form action="./MemberDeleteAction.me" method="post" name="deleteok">
		<td>
		<input type="button" value="삭제" onclick="CallConfirm()" >
		</td>
		</form>
	</tr>
	<%} %>
	<form action="./MemberSearchAction.me" method="post">
	<tr align=center>
		<td colspan=2>
			<input type="text" name="searchMember" />
			<input type="submit" value="검색" />
		</td>
	</tr>
	</form>
	<tr align=center>
		<td colspan=2>
			<a href="./BoardList.bo">[게시판 이동]</a>
		</td>
	</tr>
</table>

</center>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="style/js/classie.js"></script>
    <script src="style/js/bootstrap.min.js"></script>
    <script src="style/js/smoothscroll.js"></script>
	<script src="style/js/jquery.stellar.min.js"></script>
	<script src="style/js/fancybox/jquery.fancybox.js"></script>    
	<script src="style/js/main.js"></script>
		<script>
		$(function(){
			$.stellar({
				horizontalScrolling: false,
				verticalOffset: 40
			});
		});
		</script>
		
		<script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });
	   </script>
</body>
</html>