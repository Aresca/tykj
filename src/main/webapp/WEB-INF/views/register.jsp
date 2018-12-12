<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户注册页面</title>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/bootstrap-4.1.3-dist/css/bootstrap.css">
<script type="text/javascript">
	$(function(){
		$("#registerBut").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/login/register.do",
				type :"post",
				dataType:"json",
				data:$("#myForm").serialize(),
				async:false,
				success:function(data){
					if(data.flag){
						alert("注册成功！");
					}else{
						alert("注册失败："+data.message);
					}
				},
				error:function(data){
					alert("连接服务器失败");
				}
			});
		});
	});

</script>
</head>
<body>
	<div class="container">
		<h1>表单</h1>
		<form class="form-horizontal" id="myForm">
			<div class="form-inline">
				<label for="userName" class="col-md-2 control-label">用户名</label>
				<div class="col-md-8">
					<input type="text" class="form-control" id="userName" name="userName"
						placeholder="用户名">
				</div>
			</div>
			<div class="form-inline">
				<label for="password" class="col-md-2 control-label">密码</label>
				<div class="col-md-8">
					<input type="password" class="form-control" id="password" name="password"
						placeholder="密码">
				</div>
			</div>
			<div class="form-inline">
				<label for="className" class="col-md-2 control-label">班级</label>
				<div class="col-md-8">
					<input type="text" class="form-control" id="className" name="className"
						placeholder="班级">
				</div>
			</div>
			<div class="form-inline">
				<label for="phone" class="col-md-2 control-label">联系方式</label>
				<div class="col-md-8">
					<input type="text" class="form-control" id="phone" name="phone"
						placeholder="联系方式">
				</div>
			</div>
			<div class="form-inline">
				<label for="teamName" class="col-md-2 control-label">所在小组名称</label>
				<div class="col-md-8">
					<input type="text" class="form-control" id="teamName" name="teamName"
						placeholder="所在小组名称">
				</div>
			</div>
			<div class="form-inline">
			<a  class="col-md-2" href="${pageContext.request.contextPath}/login/signin.do">返回登陆页面</a>
			<button class="btn btn-primary btn-default col-md-2" id="registerBut" type="submit">注册</button>
			</div>
		</form>
	</div>
</body>
</html>
