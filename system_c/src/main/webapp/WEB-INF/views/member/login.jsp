<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.container{
width:30%;
}

.container > h2 {
text-align: center;
margin-bottom : 30px;
margin-top:100px;
}


</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		<form action="login" method="post">
		
	
			<div class="form-group">
				<label for="id">아이디</label>
				<input name="id" id="id" class="form-control" placeholder="아이디를 입력해주세요."> 
			</div>
			
			 <div class="form-group">
				<label for="pw">비밀번호</label>
				<input name="pw" id="pw" class="form-control" type="password" placeholder="비밀번호를 입력해주세요."> 
			</div>
			
			<button class="btn btn-success">로그인</button>
			<button type="button" class="btn btn-danger" onclick="history.back()">취소</button>
		</form>	
	</div>

</body>
</html>