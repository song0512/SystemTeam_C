<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판 보기</title>
<script type="text/javascript">
	$(function(){
		var imageWidth = $("#image").width();
		var imageDivWidth = $("#imageDiv").innerWidth();
		
		if(imageDivWidth < imageWidth) $("#image").width("100%");
	});
</script>
</head>
<body>
<div class="container">
	<h2>이미지 보기</h2>
	<div class="well row">
		<div class="col-sm-3">번호</div>
		<div class="col-sm-9">${vo.no }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">제목</div>
		<div class="col-sm-9">${vo.title }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">이미지</div>
		<div class="col-sm-9" id="imageDiv"><img src="${vo.fileName }" class="thumbnail" id="image"></div>
	</div>
	<div class="well row">
		<div class="col-sm-3">내용</div>
		<div class="col-sm-9">${vo.content }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">작성자</div>
		<div class="col-sm-9">${vo.name}(${vo.id })</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">작성일</div>
		<div class="col-sm-9"><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd" /></div>
	</div>
</div>
</body>
</html>