<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>

<style type="text/css">
	.dataRow:hover {
		background: #eee;
		cursor: pointer;
	}
	.container {
	margin-top : 100px;}

</style>
<script type="text/javascript">
$(function() {
	$(".dataRow").click(function(){
		var id = $(this).find(".id").text();
		location = "view?id="+id+"&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
});
</script>
</head>
<body>
<div class="container">
	<h2>회원 리스트</h2>
	<table class="table">
		<tr>
			<th>닉네임</th>
			<th>아이디</th>
			<th>상태</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td>${vo.name }</td>
				<td class="id">${vo.id }</td>
				<td>${vo.status }</td>
				<td><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		<tr><td colspan="9" style="text-align:center"><pageNav:pageNav listURI="list" pageObject="${pageObject }"></pageNav:pageNav></tr>
	</table>
</div>

</body>
</html>