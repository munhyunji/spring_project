<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Title</title>
</head>
<body>
<h3>게시판 수정</h3>
	<form role="form" id="writeForm" method="post" action="${path}/userupdate_ok.do">
		
		<!-- action페이지에서 사용할 WHERE 조건값을 hidden필드로 숨겨서 사용 -->	
		<input type="hidden" name="id" value="${board.id}">
		<input type="hidden" name="userid" value="${board.userid}">
		
		
		<div class="form-group">
			<label for="title">제목</label>
			 <input class="form-control" id="title" name="title" value="${board.title}" />
		</div>
			<p>작성자 ID "${board.userid}"</p>			
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea rows="10" id="content" name="content" >${board.content }</textarea>
		</div>
		
		<input width="20" type="text" name="postpw" id="postpw" value="${board.postpw }" placeholder="글 비밀번호"><br>	
		<input type="checkbox" value="1" name="lockpost">비밀글입니다 <br>
		
		<button type="submit">수정</button>
		<button type="reset" onclick="location.href='/.do'">취소</button>
	</form>
</body>
</html>