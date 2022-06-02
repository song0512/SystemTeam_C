<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style type="text/css">
.container {
	margin-top:100px;
}
</style>
</head>
<body>
<div class="container">
	<h2>게시글 작성</h2>
	<form action="write" method="post" enctype="multipart/form-data">
		<input name="perPageNum" value="${param.perPageNum }" type="hidden">
		<div class="form-group">
			<label>제목</label>
			<input name="title" class="form-control">
		</div>
		<div class="form-group">
			<label>카테고리</label>
			<div>
				<label class="radio-inline"><input type="radio" name="category" checked value="카페, 디저트">카페, 디저트</label>
				<label class="radio-inline"><input type="radio" name="category"  value="중식">중식</label>
				<label class="radio-inline"><input type="radio" name="category" value="패스트푸드">패스트푸드</label>
				<label class="radio-inline"><input type="radio" name="category"  value="분식">분식</label>			
			</div>
		</div>
		
		
		<div class="form-group">
			<label>내용 </label>
			<textarea rows="7" name="content" class="form-control"></textarea>
		</div>
		
		<div class="form-group">
			<label>이미지 파일</label>
			<input name="image" type="file" class="form-control">
		</div>

		<button class="btn btn-success">등록</button>
		<button type="reset" class="btn btn-default">새로입력</button>
		<button type="button" onclick="history.back()" class="btn btn-danger">취소</button>
	</form>
</div>
</body>
</html>