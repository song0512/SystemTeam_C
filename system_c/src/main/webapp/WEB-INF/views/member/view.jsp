<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
<div class="container">
	<h2>${title }</h2>
	<table class="table">
		<tr>
			<th>닉네임</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${vo.status }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${empty param.id }">
				<!-- 개인메뉴 -->
					<a href="update" class="btn btn-default">정보수정</a>
					<a href="changePassword" class="btn btn-default">비밀번호 변경</a>
					<a href="delete" class="btn btn-danger">회원탈퇴</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>

</body>
</html>