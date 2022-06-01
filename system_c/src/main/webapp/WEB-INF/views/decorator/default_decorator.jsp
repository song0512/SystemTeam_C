<%@page import="org.mnu.domain.LoginVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%LoginVO loginVO = (LoginVO) session.getAttribute("login"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목포대학교 음식점 커뮤니티<decorator:title /></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<!-- 

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/resources/common/css/common.css'/>" >
  -->

<style type="text/css">

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */


.carousel-inner img {
	width: 100%;  /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}
.navbar,
.container-fluid {
	background-color : #009B94;
}

#welcome {
	color: grey;
	margin: 0 auto;	
}


</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		
  		$("#deleteBtn").click(function(){
  			return confirm("정말 삭제 하시겠습니까?");
  		});

  		$(".cancelBtn").click(function(){
			history.back();
		});
	});
</script>

<c:if test="${!empty msg }">
<script type="text/javascript">
$(function(){
	var msgShow = true;
	if (msgShow) {
		setTimeout(
			function(){
				alert("${msg}")
			}, 200
		);
		msgShow = false;
	}
});
</script>
</c:if>
<decorator:head/>
</head>
<body>
	<header>

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="http://localhost:8080/image/list" style="color:white">목포대학교 음식점 커뮤니티</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="#" style="color:white">카테고리</a></li>
						<li><a href="/image/list" style="color:white">커뮤니티 게시판</a></li>
						<li><a href="/board/list" style="color:white">자유게시판</a></li>
						<% if(loginVO != null) {%>
							<li><a href="/member/list" style="color:white">회원관리</a></li>
						<%} %>
					</ul>
					<ul class="nav navbar-nav navbar-right">
					
						<% if(loginVO == null) { %>
							<li><a href="/member/write" style="color:white">회원가입</a></li>
							<li><a href="/member/login" style="color:white">로그인</a></li>
						<%} else { %>
							<li><a href="/member/view">
									<%= loginVO.getName() %> 
								</a></li>
							<li><a href="/member/logout">로그아웃</a></li>
						<% } %>
						
					</ul>
				</div>
			</div>
		</nav> 
		
	<!-- 
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="#">Expand at lg</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarsExample05">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Link</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="#">Disabled</a>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">카테고리</a>
		        <div class="dropdown-menu" aria-labelledby="dropdown05">
		          <a class="dropdown-item" href="#">Action</a>
		          <a class="dropdown-item" href="#">Another action</a>
		          <a class="dropdown-item" href="#">Something else here</a>
		        </div>
		      </li>
		    </ul>
		  </div>
		</nav>
		 -->
	
	</header>
	<article>
		<decorator:body />
	</article>
</body>
</html>