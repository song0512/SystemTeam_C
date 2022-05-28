<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
</head>
<body>
<div class="container">
	<h2>이미지 등록</h2>
	<form action="write" method="post" enctype="multipart/form-data">
		<input name="perPageNum" value="${param.perPageNum }" type="hidden">
		<div class="form-group">
			<label>제목</label>
			<input name="title" class="form-control">
		</div>
		
		<div class="form-group">
			<label>내용 </label>
			<textarea rows="7" name="content" class="form-control"></textarea>
		</div>
		
		<div class="form-group">
			<label>이미지 파일</label>
			<input name="image" type="file" class="form-control">
		</div>

		<button class="btn btn-default">등록</button>
		<button type="reset" class="btn btn-default">새로입력</button>
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
	</form>
</div>
</body>
</html>