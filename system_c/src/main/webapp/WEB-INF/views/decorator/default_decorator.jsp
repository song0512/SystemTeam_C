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

<style type="text/css">

pre {
	background: white;
	border: 0px;
}

.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.carousel-inner img {
	width: 100%;  /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

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


/*category dropdown*/
.dropdown {
	margin-top : 8px;
}
.dropdown-button {
			background-color: #009B94;
			color : white;
			padding: 8px;
			font-size: 15px;
			border: none;
		}
	
		.dropdown-content {
			display: none;
			position: absolute;
			background-color: white;
			min-width: 130px;
			padding: 5px;
			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		}
		.dropdown-content a {
			color: black;
			padding: 8px;
			text-decoration: none;
			display: block;
		}
		.dropdown-content a:hover { background-color: #2D3F50; color: white;  }
		.dropdown:hover .dropdown-content { display: block; }
		.dropdown:hover .dropdown-button { background-color: #2D3F50; }

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
						<li>
							<div class="dropdown">
								<button class="dropdown-button">카테고리</button>
								<div class="dropdown-content">
									<a href="/image/list">전체</a>
									<a href="/image/soup_category">카페, 디저트</a>
									<a href="/image/chinesefood_category">중식</a>
									<a href="/image/fastfood_category">패스트푸드</a>
									<a href="/image/snackbar_category">분식</a>
								</div>
							</div>						
						</li>
					
						<li><a href="/board/list" style="color:white">자유게시판</a></li>
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
	
	</header>
	<article>
		<decorator:body />
	</article>
</body>
</html>