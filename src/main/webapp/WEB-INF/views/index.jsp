<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>登录页面</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/bootstrap-4.1.3-dist/css/bootstrap.css">
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/signin.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
		<form class="form-signin"
			action="${pageContext.request.contextPath}/login/login.do">
			<h2 class="form-signin-heading">登录首页</h2>
			<label for="username">用户名</label> <input type="text" id="username"
				name="username" class="form-control" placeholder="用户名" required
				autofocus> <label for="inputPassword">密码</label> <input
				type="password" id="inputPassword" name="password"
				class="form-control" placeholder="密码" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			<div style="color: red;">${message }</div>
			<a href="${pageContext.request.contextPath}/login/goRegister.do">立即注册</a>
			<a href="${pageContext.request.contextPath}/login/goManagerLogin.do">管理员登陆</a>
		</form>
	</div>
</body>
</html>
