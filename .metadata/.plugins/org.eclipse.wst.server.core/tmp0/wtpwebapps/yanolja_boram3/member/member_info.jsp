<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.boram3.yanolja.DAO.*" %>
<%@ page import="com.boram3.yanolja.DTO.*" %>
<%
	MemberBean member=(MemberBean)request.getAttribute("member");
%>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
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
function authochange(){
	var autho= document.updateform.grade.value;
	if(autho==""){
		alert("권한을 선택해주십시오.");
		return;
	}
	
	document.authoritychange.submit();
}
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
<table border=1 width=300>
	<tr align=center>
		<td>아이디 : </td>
		<td><%=member.getUserid() %></td>
	</tr>
	<tr align=center>
		<td>프로필 사진 : </td>
		<td><img alt="" src="memberpic/<%=member.getProfile_pic()%>" width="100" height="100"></td>
	</tr>
	
	<tr align=center>
		<td>이름 : </td>
		<td><%=member.getName() %></td>
	</tr>
	
	<tr align=center>
		<td>전화번호 : </td>
		<td><%=member.getPhone() %></td>
	</tr>
	<tr align=center>
		<td>이메일 주소 : </td>
		<td><%=member.getEmail() %></td>
	</tr>
	<tr align=center>
		<td>응원팀 : </td>
		<td><%=member.getTeam_name() %></td>
	</tr>
	<tr align=center>
		<td>가입일 : </td>
		<td><%=member.getJoindate() %></td>
	</tr>
	<tr align=center>
		<td>권한 : </td>
		<form name="authoritychange" action="./MemberAuthorityUpdateAction.me" method="post">
		<td><%=member.getAuthority() %><br>
			<input type="hidden" name="userid" value=<%=member.getUserid() %> />
			<input type="radio" name="grade" value="1"/>서포터
			<input type="radio" name="grade" value="2"/>기록원
			<input type="radio" name="grade" value="3"/>매니저
			<input type="radio" name="grade" value="4"/>관리자
		</td>	
		<td><input type="button" name="authochbutton" value="권한 수정하기" onclick="authochange()"></td>
		</form>
	</tr>
	<tr align=center>
		<td colspan=2>
			<a href="MemberListAction.me">회원리스트로 돌아가기</a>
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