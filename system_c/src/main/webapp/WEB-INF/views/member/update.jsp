<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style type="text/css">
.container {
	width:30% !important;

	
}

.container > h2 {
	margin-top:150px;	
	text-align: center;
}

</style>
</head>
<body>
	<div class="container">
		<h2>회원정보 수정</h2>
		<form action="update" method="post">
			<div class="form-group">
				<label>아이디</label>
				<input name="name" id="name" class="form-control" value="${vo.name }" readonly="readonly">
			</div>	
			
			<div class="form-group">
				<label>닉네임 변경</label>
				<input name="id" id="id" class="form-control" value="${vo.id }">
			</div>	
			
			<div class="form-group">
				<label>비밀번호 변경</label>
				<input name="pw" id="pw" class="form-control" type="password">
			</div>	
			
			<button class="btn btn-success">수정</button>
			<button type="button" class="btn btn-danger"  onclick="history.back()">취소</button>
		</form>
	</div>
</body>
</html>