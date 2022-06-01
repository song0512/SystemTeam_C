<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>


.container{
width:30% !important;

}

.container > h2 {
text-align: center;
margin-top:100px;

}


</style>

<script type="text/javascript">
	$(function() {
		
		//아이디 중복체크 뱐수, 비밀번호, 비밀번호 재확인 같은지 체크하는 변수
		var idCheck = false;
		var pwCheck = false;
		
		//아이디 실시간 중복 체크 
		$("#id").keyup(function(){
			idCheck = false;
			var id = $("#id").val();
			id = $.trim(id)
			$("#id").val(id)
			//4글자 미만
			if(id.length < 4) {
				$("#idCheckDiv").removeClass("alert-success");
				$("#idCheckDiv").addClass("alert-danger");
				$("#idCheckDiv").text("아이디는 4자 이상 입력하셔야 합니다.");
				return;
				
			}
			//20글자 초과
			if(id.length > 20) {				
				$("#idCheckDiv").removeClass("alert-success");
				$("#idCheckDiv").addClass("alert-danger");
				$("#idCheckDiv").text("아이디는 20자 이내로 입력하셔야 합니다.");
				return;
				
			}
			
			//아이디 중복 체크(Ajax)
			//가져온 데이터(id)가 null이면 ㅇㅋ, 아니면 ㄴㄴ
			$("#idCheckDiv").load("/member/idCheck?id="+id,function(result){
				$("#idCheckDiv").removeClass("alert-success alert-danger");
				if(result.indexOf("가능한") == -1) {
					//중복된 경우
					$("#idCheckDiv").addClass("alert-danger");
					idCheck = false;
				} else {
					//사용 가능한 경우
					$("#idCheckDiv").addClass("alert-success");
				
					idCheck = true;
				}
			});
		});
		
		//비밀번호 처리 이벤트
		$("#pw").keyup(function(){
			pwCheck = false;
			var pw = $(this).val();
			//alert(pw.length);
			//6이상
			if(pw.length < 6) {
				$("#pwCheckDiv").removeClass("alert-success");
				
				$("#pwCheckDiv").addClass("alert-danger");
				$("#pwCheckDiv").text("비밀번호는 6자 이상이여야 합니다.");
				return;
			}
			//20 초과
			if(pw.length > 20) {
				$("#pwCheckDiv").removeClass("alert-success");
				$("#pwCheckDiv").addClass("alert-danger");
				$("#pwCheckDiv").text("비밀번호는 20자 이하여야 합니다.");
				return;
			}
			
			//비밀번호가 재확인과 같은지 체크
			var pw2 = $("#pw2").val();
			
			if(pw === pw2){ 

				console.log("pw same");
				//같은 경우
				$("#pwCheckDiv, #pw2CheckDiv").removeClass("alert-danger");
				
				$("#pwCheckDiv, #pw2CheckDiv").addClass("alert-success");
				$("#pwCheckDiv, #pw2CheckDiv").text("비밀번호가 일치합니다.");
				pwCheck = true;
			} else {
				//다른경우
				
				console.log("not same");
				$("#pwCheckDiv, #pw2CheckDiv").removeClass("alert-success");
				$("#pwCheckDiv, #pw2CheckDiv").addClass("alert-danger");
				$("#pwCheckDiv").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
				if(pw2.length < 6) 
					$("#pw2CheckDiv").text("비밀번호 재확인은 6자 이상이여야 합니다.");
				else if(pw2.length > 20)
					$("#pw2CheckDiv").text("비밀번호 재확인은 20자 이하여야 합니다.");
				else 
					$("#pw2CheckDiv").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
			}
		});
		
		//비밀번호 확인 처리 이벤트
		$("#pw2").keyup(function() {
			pwCheck = false;
			var pw2 = $(this).val();
						//6이상
			if(pw2.length < 6) {
				$("#pw2CheckDiv").removeClass("alert-success");
				$("#pw2CheckDiv").addClass("alert-danger");
				$("#pw2CheckDiv").text("비밀번호 재확인은 6자 이상이여야 합니다.");
				return;
			}
						
			//20 초과
			if(pw2.length > 20) {
				$("#pw2CheckDiv").removeClass("alert-success");
				$("#pw2CheckDiv").addClass("alert-danger");
				$("#pw2CheckDiv").text("비밀번호 재확인은 20자 이하여야 합니다.");
				return;
			}
			//비밀번호가 재확인과 같은지 체크
			var pw = $("#pw").val();
			
			if(pw == pw2){
				//같은 경우
				$("#pw2CheckDiv, #pwCheckDiv").removeClass("alert-danger");
				$("#pw2CheckDiv, #pwCheckDiv").addClass("alert-success");
				$("#pw2CheckDiv, #pwCheckDiv").text("비밀번호가 일치합니다.");
				pwCheck = true;			
			} else {
				//다른경우
				$("#pwCheckDiv, #pw2CheckDiv").removeClass("alert-success");
				$("#pwCheckDiv, #pw2CheckDiv").addClass("alert-danger");
				$("#pw2CheckDiv").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
				if(pw.length < 6) 
					$("#pwCheckDiv").text("비밀번호 재확인은 6자 이상이여야 합니다.");
				else if(pw2.length > 20)
					$("#pwCheckDiv").text("비밀번호 재확인은 20자 이하여야 합니다.");
				else 
					$("#pwCheckDiv").text("비밀번호가 일치하지 않습니다. 다시 확인해주세요");
			}
		});
		
		//회원가입 이벤트 
		$("#writeForm").submit(function() {
			//alert("id check : "+idCheck + "\npw check : " + pwCheck);
			// 아이디 중복 체크 - 사용 가능한 아이디 인지 확인
			if(!idCheck) {
				alert("중복이 되지 않은 아이디를 사용하셔야만 합니다.");
				$("#id").focus();
				
				return false;
			}
			// 비밀번호, 비밀번호 재확인 확인
			if(!pwCheck) {
				alert("비밀번호와 비밀번호 재확인이 동일해야만 합니다.");
				$("#pw").focus();
				
				return false;
			}
		});	
	});
</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class="container" >
		<h2>회원가입</h2>
		<form action="write" method="post"  id="writeForm">
		
			<div class="form-group">
					<label for="name">닉네임</label>
					<input id="name" name="name" required="required" pattern="[가-힣-A-Za-z0-9]{4,20}" placeholder="닉네임 입력"
					class="form-control" autocomplete="off">
			</div>
			<div class="form-group" id="form-group-id">
				<label for="id">아이디</label>
				<input id="id" name="id" required="required" pattern="[A-Za-z0-9]{4,20}" placeholder="아이디 입력"
				class="form-control" autocomplete="off">
				<div class="alert alert-danger" id="idCheckDiv">아이디는 4자 이상 입력하셔야 합니다.</div>
			</div>
			
			<div class="form-group">
				<label for="pw">비밀번호</label>
				<input id="pw" name="pw" required="required" pattern="[A-Za-z0-9]{6,20}" placeholder="비밀번호 입력"
				class="form-control" type="password">
				<div id="pwCheckDiv" class="alert alert-danger">비밀번호는 6자 이상이여야 합니다.</div>
			</div>
			
			<div class="form-group">
				<label for="pw2">비밀번호 재확인</label>
				<input id="pw2" name="pw2" required="required" pattern="[A-Za-z0-9]{6,20}" placeholder="비밀번호 재확인"
				class="form-control" type="password">
				<div id="pw2CheckDiv" class="alert alert-danger">비밀번호는 6자리 이상이여야 합니다.</div>
			</div>
				
			<button class="btn btn-success">가입하기</button>
			<button class="btn btn-default" type="reset">새로입력</button>
			<button type="button" class="btn btn-danger" onclick="history.back()">취소</button>
		</form>
	</div>

</body>
</html>