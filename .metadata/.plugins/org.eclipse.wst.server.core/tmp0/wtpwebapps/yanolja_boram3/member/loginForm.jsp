<%-- <%@ page language="java" contentType="text/html; charset=utf-8"%>--%>
 
<!DOCTYPE html>
<html lang="en">
  <head>
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
    
    
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="http://bootstrapk.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://bootstrapk.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://bootstrapk.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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

	

    <div class="container">

      <form class="form-signin" role="form" name="loginform" action="<%= request.getContextPath()%>/MemberLoginAction.me" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="InputID">Your ID</label>
				<input type="text" class="form-control" id="InputID" placeholder="Enter id" name="userid">
				<label for="InputPwd">Password</label>
				<input type="password" class="form-control" id="InputPwd" placeholder="Enter pwd" name="pwd">
        
			<!-- <a href="MemberJoin.me">회원가입</a> -->
        
        <button class="btn btn-lg btn-danger btn-block" type="submit">Sign in</button>
        
      </form>

    </div>


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://bootstrapk.com/assets/js/ie10-viewport-bug-workaround.js"></script>
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
 