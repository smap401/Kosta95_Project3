
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>야구야 놀자 !!</title>
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

</head>
<body data-spy="scroll" data-offset="0" data-target="#theMenu">
	<!-- Menu -->
	<nav class="menu" id="theMenu">
		<div class="menu-wrap">
			<h1 class="logo"><a href="index.jsp#home">DSGN NYC</a></h1>
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
	
	<section id="home" name="home"></section>
	<div id="headerwrap">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<h1>야구야 놀자!</h1>
					<a href="MemberLogin.me">로그인</a>
	<a href="MemberJoin.me">회원가입</a>
				</div>
			</div><! --/row -->
		</div><! --/container -->
	</div><! --/headerwrap -->
	
	
	
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