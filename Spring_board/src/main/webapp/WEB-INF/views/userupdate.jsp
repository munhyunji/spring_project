<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 수정</h3>
	<form role="form" id="writeForm" method="post"
		action="${path}/userupdate_ok.do">

		<!-- action페이지에서 사용할 WHERE 조건값을 hidden필드로 숨겨서 사용 -->
		 <input type="hidden" name="id" value="${board.id}">
		<input type="hidden" name="userid" value="${userVO.getUserid()}">
		
		
		<p>유저번호 : ${userVO.id}</p>
		<p>사용자 ID : ${userVO.userid}</p>
		
		<div class="form-group">
			<label for="title">비밀번호</label>
			 <input class="form-control" id="userpassword" name="userpassword" value="${userVO.getUserpassword()}" />
		</div>
		<p>가입 날짜 : ${userVO.regdate}</p>

		<button type="submit">수정</button>
		<button type="reset" onclick="location.href='/.do'">취소</button>


	</form>
	<a href="${path}/userdelete.do?id=${userVO.id}">회원탈퇴하기</a>
</body>
</html>