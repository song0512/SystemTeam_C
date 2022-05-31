/**
 * 
 */

 var replyService = (function(){
 
	function list(param, callback, error){
		var no = param.no;
		$.getJSON(
			"/reply/list?no=" + no,
			function(data){
				if(callback){
					callback(data);
				}
			}
		).fail(
			function(xhr, status,err){
				if(error) error();
				else alert("데이터 가져오기를 실패하셨습니다.");
			}
		);
	}
	
	//댓글 등록
	function write(reply, callback, error) {
		//alert("댓글 등록 실행 : " + JSON.stringify(reply));
		$.ajax({
			url : "/reply/write",
			type : "post",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback) callback(result);
				else 
					alert("댓글 등록이 되었습니다.");
			},
			error : function(xhr, status, er) {
				if(error) error(er);
				else 
					alert("댓글 등록에 실패 하셨습니다.");
			}
		
		});
	}
	
	//댓글 수정
	function update(reply, callback, error){
		alert("replyService.update - reply : " + JSON.stringify(reply));
		$.ajax({
			url : "/reply/update",
			type : "patch",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback) callback(result);
				else 
					alert("댓글 수정이 되었습니다.");
			},
			error : function(xhr, status, er) {
				if(error) error(er);
				else 
					alert("댓글 수정에 실패 하셨습니다.");
			}
		
		});
	
	}
	
	//댓글 삭제
	function deleteReply(rno, callback, error){
		alert("replyService.delete - reply : " + rno);
		$.ajax({
			url : "/reply/delete?rno="+rno,
			type : "delete",
			success : function(result, status, xhr){
				if(callback) callback(result);
				else 
					alert("댓글 삭제가 되었습니다.");
			},
			error : function(xhr, status, er) {
				if(error) error(er);
				else 
					alert("댓글 삭제에 하셨습니다.");
			}
		
		});
	
	}
	
	return {
		list : list,
		write : write,
		update : update,
		delete : deleteReply
	}
})();