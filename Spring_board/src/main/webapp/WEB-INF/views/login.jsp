<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
 
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="/login_ok.do" method="POST">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="아이디" name="userid"
										id="userid" type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="비밀번호"
										name="userpassword" id="userpassword" type="password" value="">
								</div>
								<div class="form-group">
									<button type="button" class="btn btn-outline btn-info"
										onclick="location.href='signup.do'">회원가입</button>
									<button type="button" style="float: right;"
										class="btn btn-outline btn-warning">비밀번호 찾기</button>
								</div>
								<!-- <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div> -->
								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block" onclick="loginOk()">Login</button>
								<!-- <a href="userSignIn.do" class="btn btn-lg btn-success btn-block">Login</a> -->
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>