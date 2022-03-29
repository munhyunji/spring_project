<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>회원상세정보</h3>
<p>유저번호 : ${userVO.id}</p>
<p>사용자 ID : ${userVO.userid}</p>
<p>비밀번호 : ${userVO.userpassword}</p>
<p>가입 날짜 : ${userVO.regdate}</p>

<a href="${path}/.do">목록가기</a>

<a href="${path}/userupdate.do?userid=${userVO.userid}">수정하기</a>


</body>
</html>