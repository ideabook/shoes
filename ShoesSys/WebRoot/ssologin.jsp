<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>智能鞋管理系统</title>

<!-- Bootstrap Core CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${ pageContext.request.contextPath}/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${ pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">

		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">登陆</h3>
						
					</div>
					<div class="panel-body">
						<form role="form" action="login_login3.action" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="用户名" name="uloginname"
										type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="密码"
										sytle="paddingleft:30dp" name="upassword" type="password">
								</div>
								
								<div class="form-group">
									<label>验证码：</label><input type="text" name="verifycode" /> <img
										src="getVerify.action" onclick="getVerify(this);" class="s1"
										title="点击更换" />
								</div>
								<br>
								${msg}
								<br>
								<!-- Change this to a button or input when using this as a form -->
								<button type="submit" class="btn btn-success btn-lg btn-block">登陆</button>
							</fieldset>
						</form>
						<a href="shoes_toadduser.action"> <button type="text"  class="btn btn-success btn-lg btn-block">注册</button></a>
					</div>


				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${ pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${ pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${ pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
	<script type="text/javascript">
		function getVerify(obj) {
			obj.src = "getVerify.action?s=" + new Date().getTime();
		}
	</script>
</body>

</html>
