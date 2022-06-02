<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스트푸드 카테고리</title>

<style type="text/css">
	.dataRow:hover {
		cursor:pointer;
		background: #eee;
	}
	
	.container {
		margin-top:100px;
	}
	.container-footer {
		margin-bottom : 120px;
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
<body>
	<div class="container">
		<h2>패스트푸드 카테고리</h2>
		
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
		<form action="fastfood_category" class="form-inline" id="perPageNumForm">
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

		<div class="row" >
			<c:forEach items="${fastfood_category }" var="vo" varStatus="vs">
				<c:if test="${vo.category == '패스트푸드' }">
					<div class="col-md-3">
						<div class="thumbnail dataRow" 
						onclick="location='view?no=${vo.no}&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}'">
							<img src="${vo.fileName }" alt="이미지가 없습니다." style="width:100%; height:300px;">
							<div class="caption">
								<p>[${vo.no }] ${vo.title }</p>
								<p style="color : blue">#${vo.category }</p>
								${vo.name }<br>  
								<fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd" />
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>

	
	</div>
	<div class="container-footer">
		<div style="text-align:right; margin-right:12.5%;" >
			<c:if test="${!empty login }">
				<a href="write?perPageNum=${pageObject.perPageNum }" class="btn btn-success">글쓰기</a>
			</c:if>
			<a href="fastfood_category?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}" class="btn btn-default">새로고침</a>
		</div>	

		<div style="text-align:center;">
			<pageNav:pageNav listURI="fastfood_category" pageObject="${pageObject }" query="&key=${pageObject.key }&word=${pageObject.word }"/>
		</div>
	
	</div>
</body>

</body>
</html>