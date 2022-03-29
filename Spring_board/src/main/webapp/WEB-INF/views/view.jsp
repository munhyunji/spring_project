<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Title</title>
</head>
<body>

<h3>상세정보</h3>
<p>글번호 : ${output.id}</p>
<p>사용자 ID : ${output.userid}</p>
<p>글제목 : ${output.title}</p>
<p>글 내용 : ${output.content}</p>

<a href="${path}/.do">목록가기</a>

<c:if test="${userVO.getUserid() != null && userVO.getUserid().equals(output.userid) }">
<a href="${path}/update.do?id=${output.id}">수정하기</a>
<a href="${path}/delete.do?id=${output.id}">삭제하기</a>
</c:if>

</body>
</html>