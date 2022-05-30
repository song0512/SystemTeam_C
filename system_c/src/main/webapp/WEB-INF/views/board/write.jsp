<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  
  <script type="text/javascript">
  	$(function(){
  		$("#cancleBtn").click(function() {
  			history.back();
  		});
  		
  	});
  </script>
  
  <style type="text/css">

	.container {
	margin-top:100px;
	}
	</style>
</head>
<body>
	<div class="container">
		<h2>게시글 작성</h2>
		<form action="write" method="post">
			<input type="hidden" value="${param.perPageNum }" name="perPageNum">
			<div class="form-group">
				<label>제목</label>
				<input name="title" id="title" class="form-control">
			</div>	
			
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" id="content" class="form-control" rows="7"></textarea>
			</div>	
			
			<div class="form-group">
				<label>작성자</label>
				<input name="writer" id="writer" class="form-control" value="${vo.id }">
			</div>	
			
			<button class="btn btn-success">등록</button>
			<button type="reset" class="btn btn-default">새로입력</button>
			<button type="button" id="cancleBtn" class="btn btn-danger">취소</button>
		</form>
	</div>

</body>
</html>