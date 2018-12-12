<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>资料管理页面</title>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/js/bootstrap-4.1.3-dist/css/bootstrap.css">
<script type="text/javascript">
	$(function() {
		$("#registerBut").click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/login/register.do",
				type : "post",
				dataType : "json",
				data : $("#myForm").serialize(),
				async : false,
				success : function(data) {
					if (data.flag) {
						alert("注册成功！");
					} else {
						alert("注册失败：" + data.message);
					}
				},
				error : function(data) {
					alert("连接服务器失败");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div style="position: absolute; left: 84%; top: 4%;">欢迎您，${loginUser.fullName }[${loginUser.userName }]</div>
		<h2 style="margin-top: 10%; color: blue;" align="center">分享会资源管理平台</h2>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: 2%">
			<thead style="background-color: blue;color: white;">
				<td>小组名称</td>
				<td>资料名称</td>
				<td>IP</td>
				<td>上传人</td>
				<td>创建时间</td>
				<td>更新时间</td>
				<td>浏览数</td>
			</thead>
			<tr class="success">
				<td>小组名称</td>
				<td>资料名称</td>
				<td>IP</td>
				<td>上传人</td>
				<td>创建时间</td>
				<td>更新时间</td>
				<td>浏览数</td>
			</tr>
		</table>

	</div>
	</ body>
</html>