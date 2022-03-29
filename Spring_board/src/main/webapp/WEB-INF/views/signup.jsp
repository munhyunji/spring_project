<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>




</head>
<body>
	<h3>회원가입</h3>

	<div class="panel-heading">
		<h3 class="panel-title">Please Sign Up</h3>
	</div>
	<div class="panel-body">
		<form role="form" action="/signup_ok.do" method="post">
			<!-- <form role="form"> -->
			<fieldset>
				<div class="form-group" id="divInputId">
					<label>사용자이름</label> <input class="form-control"
						style="margin-bottom: 5px;" placeholder="이름" name="username"
						id="username" type="text" value="${UserVO.username}" />

					<spring:hasBindErrors name="UserVO">
						<c:if test="${errors.hasFieldErrors('username')}">
                            		${errors.getFieldError('username').defaultMessage}                           
                            		</c:if>
					</spring:hasBindErrors>


				</div>
				<div class="form-group" id="divInputId">
					<label>아이디</label> <input class="form-control"
						style="margin-bottom: 5px;" placeholder="아이디" name="userid"
						id="userid" type="text" />

					<spring:hasBindErrors name="UserVO">
						<c:if test="${errors.hasFieldErrors('userid')}">
                            		${errors.getFieldError('userid').defaultMessage}                        
                            		</c:if>
					</spring:hasBindErrors>
					<button type="button" id="idck">중복확인</button>
					<div id="_rgetid"></div>

				</div>
				
				
				<div class="form-group">
					<label>비밀번호</label> <input class="form-control" placeholder="비밀번호"
						name="userpassword" id="userpassword" type="password" />

					<spring:hasBindErrors name="UserVO">
						<c:if test="${errors.hasFieldErrors('userpassword')}">
                            		${errors.getFieldError('userpassword').defaultMessage}                           
                            		</c:if>
					</spring:hasBindErrors>

				</div>

				<div class="form-group">
					<label>비밀번호 확인</label> <input class="form-control"
						placeholder="비밀번호" name="userpassword2" id="userpassword2"
						type="password" />
						<font id="checkPw" size="2"></font>
				</div>


				<button type="submit" class="btn" id="PwCheck" onclick="isCheck()" >회원가입</button>

			</fieldset>
		</form>
	</div>

</body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() { //jQuery를 이용해서 Ajax로 데이터를 보내고 결과를 JSON으로 받음..
		//idck버튼을 눌럿을떄
		$("#idck").click(function() {
			var id = $("#userid").val(); //사용자가 입력한 값을 가져온다 
			if (id == "") {
				alert("아이디를 입력해주세요 "); //아이디가 비어있으면 alert
			} else {
				idCheckFunc(id);
				// checkFunc함수로 id값을 보냄 
			}
		});

		function idCheckFunc(id) { // userid값을 받는다
			$.ajax({
				type : "post",
				url : "checkID.do", // checkID 맵핑한곳으로 userid 전송
				async : true, //비동기식으로 처리할것인지 
				data : {
					userid : id
				}, //전달할 조건값은 입력값을 활용하여 JSON방식으로 구성
				success : function(map) {	// ajax성공시 controller에서 리턴한값을 파라미터로 받아와서 아이디 중복여부 check			
					idCheckMsg(map);
				},
				error : function() {
					alert("ajax error");
				}
			})
		}
		

		function idCheckMsg(map) {
			if (map.count > 0) {
				$("#_rgetid").html("사용하실 수 없습니다");
				$("#_rgetid").css("color", "#ff0000");
				$("#_userid").val($("#_id").val());
				return false ;
			} else {
				$("#_rgetid").html("사용하실 수 있습니다");
				$("#_rgetid").css("color", "#0000ff");
				$("#_userid").val($("#_id").val());
				return true;
			}
		}
		
		function isCheck() {
			if(document.getElementByid("idCheckMsg").value() ==false) {
				alert("아이디중복확인을 다시해주세용")
			}
		}
		
		
		
			
		});
 	//비밀번호 일치확인
	$('#userpassword2').keyup(function(){
		var pass1 = $('#userpassword').val();
		var pass2 = $('#userpassword2').val();
		
		if(pass1 != "" | pass2 != "") {
			if(pass1 != pass2) {
				$("#checkPw").html('비밀번호가 불일치합니다');
				$("#checkPw").css('color', "#ff0000");
				
			} else {
				$("#checkPw").html('비밀번호가 일치합니다');
				$("#checkPw").css('color', "#0000ff");
			}
		}
	});
			
	
	
	
</script>
</html>