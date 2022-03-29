<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>Home</title>
<meta charset="utf-8" />

</head>
<body>
	<h1>게시판</h1>

	<c:if test="${userVO != null }">
		<div>
			<p>${userVO.userid}님
				환영 합니다.
				<button id="logoutBtn" type="button"
					onclick="location.href='/logout.do'">로그아웃</button>
				<button id="userinfo" type="button"
					onclick="location.href='/userinfo.do'">마이페이지</button>
			</p>

		</div>
	</c:if>
	<c:if test="${userVO == null}">
		<a href="login.do">로그인하기</a>
		<br>
		<br>
	</c:if>

	
		

	<c:if test="${msg == false}">
		<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
	</c:if>

	<form action="${path }/.do" method="get">
		<label for="keyword">검색어</label> 
		<select name="search_option">
			<option value="title" <c:if test="${search_option eq 'title' }">selected</c:if>>제목</option>
			<option value="content"<c:if test="${search_option eq 'content' }">selected</c:if>>내용</option>
			<option value="userid"<c:if test="${search_option eq 'userid' }">selected</c:if>>아이디</option>
			<option value="all"<c:if test="${search_option eq 'all' }">selected</c:if>>제목+내용+아이디</option>

		</select> <input type="search" name="keyword" id="keyword" value="${keyword}"
			placeholder="제목을 검색하세요" />
		<button type="submit">검색하세용</button>
	</form>

	<c:choose>
		<c:when test="${paging.totalCount == 0 }">
			<h6>조회결과가 없습니다.</h6>
		</c:when>
		<c:otherwise>
			<h6>${paging.totalCount }개의결과가있습니다.</h6>
		</c:otherwise>
	</c:choose>

	<a href="${path}/add.do" onclick="service()" text-align="right;">글 작성하기</a>
	<table border=1>
		<thead>
			<tr>
				<th>글번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>조회수</th>

			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${board == null || fn:length(board) == 0 }">

				</c:when>
				<c:otherwise>
					<!--현재 게시판 레코드의 토탈 갯수 - ((현재 페이지-1) * 한 화면에 보여질 레코드의 갯수  -->
					<c:set var="num"
						value="${paging.totalCount - ((paging.pageNo-1) * paging.pagesize) }" />
					<c:forEach items="${board}" var="board">
						<tr>
							<td>${num}</td>
							<td>${board.userid}</td>
							<td>
							<c:if test="${board.lockpost == '1' }">
								<c:choose>
									<c:when test="${board.userid == userVO.getUserid() }">
										<a href="view.do?id=${board.id}">${board.title}</a>
										
									</c:when>
									<c:otherwise>
										비밀글은 작성자와 관리자만 볼 수 있습니다.
									</c:otherwise>
								</c:choose>


							</c:if>
							<c:if test="${board.lockpost == '0'}">
								<a href="view.do?id=${board.id}">${board.title}</a>
								
							</c:if>
							</td>
							<td width="400">${board.content }</td>
							<td>${board.viewcount }</td>

						</tr>
						<c:set var="num" value="${num-1 }"></c:set>

					</c:forEach>

				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	총 페이지수 ${paging.totalPage } , 총페이지수, limit ${paging.offset } ,  ${paging.pagesize }
	<c:choose>
		<c:when test="${paging.startPage > 1}">
			<a href="/.do?pageNo=${prevNo}&search_option=${search_option}&keyword=${keyword}">이전</a>
		</c:when>
		<c:otherwise>
		[이전]
		</c:otherwise>

	</c:choose>


	<c:forEach var="pageNo" begin="${paging.startPage }"
		end="${paging.endPage }">
		<c:choose>
			<c:when test="${pageNo == paging.pageNo}">
				<span style="font-weight: bold;"> <a href="/.do?pageNo=${pageNo}&search_option=${search_option}&keyword=${keyword}">${pageNo }</a>
				</span>
			</c:when>
			<c:otherwise>
				<a href="/.do?pageNo=${pageNo}&search_option=${search_option}&keyword=${keyword}">${pageNo }</a>
			</c:otherwise>
		</c:choose>

	</c:forEach>

	<c:choose>
		<c:when test="${paging.endPage == paging.totalPage}">
		[다음]
		</c:when>
		<c:otherwise>
			<a
				href="/.do?pageNo=${paging.nextNo}&search_option=${search_option}&keyword=${keyword}">다음</a>
		</c:otherwise>
	</c:choose>

</body>

<script type="text/javascript">
function service() {
	var signIn = "${userVO.userid}";
	if ( signIn == "" ) {
		alert("로그인한뒤 이용하세요 ");
		location.href="${path}/login.do";
	} 
}

</script>
</html>