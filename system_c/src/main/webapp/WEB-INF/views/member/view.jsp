<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>

<style type="text/css">

	.container {
		margin-top:100px;	
	}
</style>
<script type="text/javascript">
	
</script>
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
					<a href="update?id=${vo.id }" class="btn btn-default">정보수정</a>
					<a href="delete" class="btn btn-danger" id="delete_btn">회원탈퇴</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>

</body>
</html>