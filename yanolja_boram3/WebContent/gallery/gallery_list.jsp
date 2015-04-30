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

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="style/ico/favicon.ico">

    <title>야놀자</title>

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/style.css" rel="stylesheet">
    <link href="style/css/font-awesome.min.css" rel="stylesheet">
    <link href="style/js/fancybox/jquery.fancybox.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="menu" id="theMenu">
		<div class="menu-wrap">
			<h1 class="logo"><a href="MemberLogin.me">LOGIN</a></h1>
			<i class="fa fa-times menu-close"></i>
			<a href="BoardList.bo" class="smoothScroll">Board</a>
			<a href="GalleryList.ga" class="smoothScroll">Gallery</a>
			<a href="#portfolio" class="smoothScroll">M</a>
			<a href="#services" class="smoothScroll">Services</a>
			<a href="MemberMyPage.me" class="smoothScroll">Mypage</a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-dribbble"></i></a>
			<a href="#"><i class="fa fa-envelope"></i></a>
		</div>
		
		<!-- Menu button -->
		<div id="menuToggle"><i class="fa fa-bars"></i></div>
	</nav>

	<section id="portfolio" name="portfolio"></section>
	<div id="portfoliowrap">
		<div class="container">
			<div class="row">
				<h1>LIVE GALLERY</h1>
				
<%
	for(int i=0;i<galleryList.size();i++){
		GalleryBean g1=(GalleryBean)galleryList.get(i);
%>				
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
					<div class="project-wrapper">
	                    <div class="project">
	                        <div class="photo-wrapper">
	                            <div class="photo">
	                            	<a class="fancybox" href="./GalleryDetailAction.ga?num=<%=g1.getGal_idx()%>"><img class="img-responsive" src="gallery_upload/<%=g1.getGal_filename()%>" alt=""></a>
	                            </div>
	                            <div class="overlay"></div>
	                        </div>
	                    </div>
	                </div>
					</div><!-- col-lg-4 -->
					<%
		}
%>	   	
		
				</div>
			</div>
		</div>
	</section>
<%-- 	
	<a href ="./GalleryDetailAction.ga?num=<%=g1.getGal_idx()%>">
	<img alt="" src="gallery_upload/<%=g1.getGal_filename()%>" width="200" height="200">
	</a>
	
 --%>
<a href="./Gallerywrite.ga">[갤러리쓰기]</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="style/js/classie.js"></script>
    <script src="style/js/bootstrap.min.js"></script>
    <script src="style/js/smoothscroll.js"></script>
	<script src="style/js/jquery.stellar.min.js"></script>
	<script src="style/js/fancybox/jquery.fancybox.js"></script>    
	<script src="style/js/main.js"></script>	
</body>
</html>