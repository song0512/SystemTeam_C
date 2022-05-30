<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<style type="text/css">

		.container {
		margin-top:100px;
		}
	</style>
  
  <script type="text/javascript">
  	$(function(){
  		$(".dataRow").click(function() {
  			var no = $(this).find(".no").text();
  			location = "view?no=" + no + "&inc=1";
  		});
  		
  	});
  </script>
  
</head>
<body>
<div class="container">
<h2>게시판 글보기</h2>
<table class="table">
	<tr>
		<th>번호</th>
		<th>${vo.no }</th>
	</tr>
	<tr>
		<th>제목</th>
		<th>${vo.title }</th>
	</tr>
	
	<tr>
		<th>내용</th>
		<th>${vo.content }</th>
	</tr>
	
	<tr>
		<th>작성자</th>
		<th>${vo.writer }</th>
	</tr>
	
	<tr>
		<th>작성일</th>
		<td><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/></td>
	</tr>
	
	<tr>
		<th>조회수</th>
		<th>${vo.hit }</th>
	</tr>
	

	<tr>
		<td colspan="2">
			<c:if test="${!empty login }">
				<a href="update?no=${vo.no }&inc=0&page=${param.page }&perPageNum=${param.perPageNum}" class="btn btn-success">수정</a>
				<a href="delete?no=${vo.no }&perPageNum=${param.perPageNum}" class="btn btn-danger" id="deleteBtn">삭제</a>
			</c:if>
			<a href="list?page=${param.page }&perPageNum=${param.perPageNum}" class="btn btn-default">리스트</a>
		</td>
	</tr>	
</table>
</div>
</body>
</html>