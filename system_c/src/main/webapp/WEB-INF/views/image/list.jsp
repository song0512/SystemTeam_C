<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>이미지 리스트</title>
	
<style type="text/css">
.dataRow:hover {
	cursor:pointer;
	background: #eee;
}
</style>

<script type="text/javascript">
$(function() {
  	$("#perPageNumSelect").change(function(){
  		$("#perPageNumForm").submit();
  	});
});
</script>
</head>
<body>
	<div class="container">
		<h2>이미지 리스트</h2>
		
		<div class="row" style="margin-bottom: 5px;">
	<!-- 검색 form -->
	<div class="col-md-8">
		<form class="form-inline">
		<input type="hidden" name="perPageNum" value="${pageObject.perPageNum }">
			<div class="input-group">
				<select name="key" class="form-control">
					<option value="tcf" ${(pageObject.key == "tcf")?"selected":"" }>전체</option>
					<option value="t" ${(pageObject.key == "t")?"selected":"" }>제목</option>
					<option value="c" ${(pageObject.key == "c")?"selected":"" }>내용</option>
					<option value="f" ${(pageObject.key == "f")?"selected":"" }>파일명</option>
					<option value="tc" ${(pageObject.key == "tc")?"selected":"" }>제목/내용</option>
					<option value="tf" ${(pageObject.key == "tf")?"selected":"" }>제목/파일명</option>
					<option value="cf" ${(pageObject.key == "cf")?"selected":"" }>내용/파일명</option>
				</select>
			</div>
		  <div class="input-group">
		    	<input type="text" class="form-control" placeholder="Search" name="word" value="${pageObject.word }">
		    	<div class="input-group-btn">
		      		<button class="btn btn-default" type="submit">
		        		<i class="glyphicon glyphicon-search"></i>
		     		 </button>
		    	</div>
		  </div>
		</form>
	</div>
	<!-- 한페이지에 보여주는 데이터 개수 -->	
	<div class="col-md-4 text-right">
		<form action="list" class="form-inline" id="perPageNumForm">
			<input type="hidden" name="page" value="1">
			<input type="hidden" name="key" value="${pageObject.key }">
			<input type="hidden" name="word" value="${pageObject.word }">
			<div class="form-group">
				<select name="perPageNum" class="form-control" id="perPageNumSelect">
					<option label="4개씩" ${(pageObject.perPageNum == 4)?"selected":"" }>4</option>
					<option label="8개씩" ${(pageObject.perPageNum == 8)?"selected":"" }>8</option>
					<option label="12개씩" ${(pageObject.perPageNum == 12)?"selected":"" }>12</option>
					<option label="16개씩" ${(pageObject.perPageNum == 16)?"selected":"" }>16</option>
				</select>
			</div>
		</form>
	
	</div>
</div>
		
		
		
		<div class="row">
			<c:forEach items="${list }" var="vo" varStatus="vs">
				<div class="col-md-3">
					<div class="thumbnail dataRow" 
					onclick="location='view?no=${vo.no}&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}'">
						<img src="${vo.fileName }" alt="Photo Lists" style="width:100%;height:300px;">
						<div class="caption">
							<p>[${vo.no }] ${vo.title }</p>
							${vo.name }(${vo.id }) - 
							<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd" />
						</div>
					</div>
				</div>
				<c:if test="${vs.count % 4 == 0 && vs.count != list.size() }">
					${"</div>"}
					${"</div class='row'>" }
				</c:if>
			</c:forEach>
		</div>
		<div>
			<pageNav:pageNav listURI="list" pageObject="${pageObject }" query="&key=${pageObject.key }&word=${pageObject.word }"/>
		</div>
		<c:if test="${!empty login }">
			<a href="write?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
		</c:if>
		<a href="list?&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}" class="btn btn-default">새로고침</a>
	</div>
</body>
</html>