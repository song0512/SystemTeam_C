<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판 보기</title>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	#updateMsgDiv {
		display:none;
	}
	#changeImageDiv {
		display:none;
	}
	.container {
		margin-top:100px;
		margin-bottom:120px;
	}

</style>
<script type="text/javascript">
	$(function(){
		var imageWidth = $("#image").width();
		var imageDivWidth = $("#imageDiv").innerWidth();
		
		if(imageDivWidth < imageWidth) $("#image").width("100%");
		
		$("#updateBtn")
		.mouseover(function(){
			$("#updateMsgDiv").slideDown();
		})
		.mouseout(function(){
			$("#updateMsgDiv").slideUp();
		});
		
		$("#changeImageBtn").click(function() {
			$("#changeImageDiv").slideToggle();
		});
		
		$("#deleteBtn").click(function() {
			if(!confirm("이미지를 삭제하시겠습니까?")) return false;
		});
	});
</script>
</head>
<body>
<div class="container">
	<h2>${vo.title }</h2>
	<div class="well row">
		<div class="col-sm-3">번호</div>
		<div class="col-sm-9">${vo.no }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">제목</div>
		<div class="col-sm-9">${vo.title }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">
			<c:if test="${empty login }">
			<div>이미지</div>
			</c:if>
			<c:if test="${!empty login }">
				<div>
					이미지<button class="btn btn-warning btn-sm" id="changeImageBtn">바꾸기</button>
				</div>
				<div id="changeImageDiv">
					<form action="changeImage" method="post" enctype="multipart/form-data">
						<input name="no" type="hidden" value="${vo.no }">
						<input name="deleteImage"  value="${vo.fileName }" type="hidden">
						<input type="file" name="image" class="form-control">	
						<button class="btn btn-default">바꾸기</button>		
					</form>
				</div>
			</c:if>
		</div>
		<div class="col-sm-9" id="imageDiv"><img src="${vo.fileName }" class="thumbnail" id="image"></div>
	</div>
	<div class="well row">
		<div class="col-sm-3">내용</div>
		<div class="col-sm-9">${vo.content }</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">작성자</div>
		<div class="col-sm-9">${vo.name}</div>
	</div>
	<div class="well row">
		<div class="col-sm-3">작성일</div>
		<div class="col-sm-9"><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd" /></div>
	</div>
	<c:if test="${!empty login }">
		<a href="update?no=${vo.no }&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"
		class = "btn btn-success" id="updateBtn" data-toggle="tooltip" data-placement="top">수정</a>
		<a href="delete?no=${vo.no }&deleteImage=${vo.fileName}"
		class = "btn btn-danger" id="deleteBtn">삭제</a>
		<div class="alert alert-info" id="updateMsgDiv">이미지 바꾸기는 이미지 제목 오른쪽의 바꾸기 버튼을 이용하세요.</div>
	</c:if>
		
	<a href="list?page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"
	class = "btn btn-default">리스트</a>
</div>
</body>
</html>