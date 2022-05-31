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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

	<style type="text/css">
		.container {
		margin-top:100px;
		}
		
		.dataRow:hover {
			background : #eee;
			cursor : pointer;
		}
	</style>
  <script type="text/javascript" src="/js/reply.js"></script>
  <script type="text/javascript" src="/js/util.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$(".dataRow").click(function() {
  			var no = $(this).find(".no").text();
  			location = "view?no=" + no + "&inc=1";
  		});
  		
  		showList();
  		var no = '${vo.no}';
  		var replyUL = $(".chat");
  		
  		//댓글 리스트 
  		function showList() {
  			replyService.list({no : ${vo.no}},
  				function(list) {
  				var str = "";
  				if(list == null || list.length == 0)
  					str += "<li class='list-group-item'>댓글이 존재하지 않습니다.</li>";
  					
  				else{
  					for(var i = 0; i< list.length; i++) {
  						str += "<li class='left clearfix list-group-item dataRow' data-rno='"+ list[i].rno+"'>";
  						
  						str += "<div>";
  						str += "<div class='header'>";
  						str += "<strong class='writer'>" + list[i].writer + "</strong>";
  						str += "<small class='pull-right text-muted'>" + displayDateTime(list[i].writeDate) + "</small>";
  						str += "</div>";
  						str += "<p class='content'>" + list[i].content + "</p>";
  						str += "</div>";
  						str += "</li>";
  					}
  						
  				}
  				replyUL.html(str);
  			});
  		}
  		
  		//댓글 등록폼
  		$("#writeReplyBtn").click(function(){
  			$("#myModal .modal-title").text("댓글 등록");

  			$("#rno-modal, #modalDeleteReplyBtn, #modalUpdateReplyBtn").hide();
  			$("#modalWriteReplyBtn").show();
  			
  			$("#content").val("");
  			$("#writer").val("");
  			$("#myModal").modal("show");
  		});
  		
  		// 댓글 등록
  		$("#modalWriteReplyBtn").click(function(){
  			var content = $("#content").val();
  			var writer = $("#writer").val();
  			
  			if(!content || !writer) {
  				alert("내용과 작성자 모두 작성해야 합니다.");
  				return;
  			}
  			
  			
  			replyService.write(
  	  				{content : content, writer : writer, no : no},
  	  				function(result){
  	  					showList();
  	  					
  	  					$("#myModal").modal("hide");
  	  				}
  	  			);
  		});
  		
  		// 댓글 수정폼
  		$(".chat").on("click", ".dataRow", function(){
  			
  			
  			$("#myModal .modal-title").text("댓글 - 수정 / 삭제");
  			
  			var rno = $(this).data("rno");
  			var content = $(this).find(".content").text();
  			var writer = $(this).find(".writer").text();

  			$("#rno").val(rno);
  			$("#content").val(content);
  			$("#writer").val(writer);
  			
  			$("#modalUpdateReplyBtn, #modalDeleteReplyBtn, #rno-modal").show();
  			$("#modalWriteReplyBtn").hide();
  			$("#myModal").modal("show");
  		});
  		
  		// 댓글 수정 
  		$("#modalUpdateReplyBtn").click(function(){
  			var rno = $("#rno").val();
  			var content = $("#content").val();
  			var writer = $("#writer").val();
  			
  			var reply = {
  					rno : rno,
  					content : content,
  					writer : writer
  			}
  			
  			replyService.update(reply, function(result){
  				showList();
  				$("#myModal").modal("hide");
  			});
  		});
  		
  		//댓글 삭제 
  		$("#modalDeleteReplyBtn").click(function(){
  			var rno = $("#rno").val();
  			
  			replyService.delete(rno, function(result){
  				showList();
  				$("#myModal").modal("hide");
  			});
  		});
  	
  	});
  </script>
  
</head>
<body>
<div class="container">
<h2>${vo.title}</h2>
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

 <!--  댓글 부분  -->
	<div class="row" style="margin-top:15px;">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> 댓글
					<c:if test="${!empty login }">
						<button id="writeReplyBtn" class="btn btn-primary btn-xs pull-right">등록</button>
					</c:if>
				</div>
				<div class="panel-body">
					<div><strong>* 댓글을 클릭하면 수정 / 삭제를 할 수 있습니다.</strong></div>
					<ul class="chat list-group">
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<c:if test="${!empty login }">
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">댓글 등록</h4>
	      </div>
	      <div class="modal-body">
	      	<div class="form-group" id="rno-modal">
	    		<label for="rno">댓글 번호</label>
	    		<input type="text" class="form-control" id="rno" readonly = "readonly">
	  		</div>
	      
	     	 <div class="form-group">
			  	<label for="content">댓글 내용</label>
			  	<textarea class="form-control" rows="5" id="content"></textarea>
			</div>
			
	        <div class="form-group">
	    		<label for="writer">작성자</label>
	    		<input type="text" class="form-control" id="writer">
	  		</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success" id="modalWriteReplyBtn">등록</button>
	        <button type="button" class="btn btn-success" id="modalUpdateReplyBtn">수정</button>
	        <button type="button" class="btn btn-warning" id="modalDeleteReplyBtn">삭제</button>
	        <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
</c:if>
</body>
</html>