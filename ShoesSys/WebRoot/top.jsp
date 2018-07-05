<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
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

<!-- Morris Charts CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${ pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<head>

</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${ pageContext.request.contextPath}/user/contractinfo_findAll.action"><i
					class="fa fa-briefcase fa-fw"></i> **管理系统</a>
			</div>
			<!-- /.navbar-header -->
			<div
				style=" margin-top:15px; margin-right:30px ; float: right; text-align: center;">


				<!-- /.dropdown -->
				<ul class="nav navbar-top-links navbar-right">
					<!-- /.dropdown -->
					<a href="${ pageContext.request.contextPath}/login_logout.action"> 退出&nbsp;&nbsp;<i
						class="glyphicon glyphicon-log-out "></i> </a>
				</ul>
				<!-- /.dropdown -->

				<!-- /.dropdown -->

			</div>
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a
							href="${ pageContext.request.contextPath}/user/contractinfo_findAll.action"><i
								class="fa fa-briefcase fa-fw"></i>&nbsp&nbsp合同概况</a></li>

						<li><a
							href="${ pageContext.request.contextPath}/contractinfo_toadd.action"><i
								class="fa fa-file-word-o fa-fw"></i>&nbsp&nbsp添加合同</a>
						</li>
						<li><a
							href="${ pageContext.request.contextPath}/pay_toadd.action"><i
								class="fa fa-edit fa-fw"></i>&nbsp&nbsp付款登记</a></li>
						<li><a
							href="${ pageContext.request.contextPath}/pay_findAll.action"><i
								class="fa  fa-rmb  fa-fw"></i>&nbsp&nbsp付款明细</a></li>
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>&nbsp&nbsp数据管理<span
								class="fa arrow"></span> </a>
							<ul class="nav nav-second-level">
								<li><a
									href="${ pageContext.request.contextPath}/company_findAll.action"><i
										class="fa fa-edit fa-fw"></i>公司信息维护</a></li>
								<li><a
									href="${ pageContext.request.contextPath}/confrom_findAll.action"><i
										class="fa fa-edit fa-fw"></i>合同来源维护</a></li>
								<li><a
									href="${ pageContext.request.contextPath}/contype_findAll.action"><i
										class="fa fa-edit fa-fw"></i>合同类型维护</a></li>
								<li><a
									href="${ pageContext.request.contextPath}/fundtype_findAll.action"><i
										class="fa fa-edit fa-fw"></i>资金来源维护</a></li>
										<shiro:hasAnyRoles name="admin">
								<li><a
									href="${ pageContext.request.contextPath}/paymode_findAll.action"><i
										class="fa fa-edit fa-fw"></i>合同付款进度维护</a></li>
										</shiro:hasAnyRoles>
							</ul> <!-- /.nav-second-level -->
						</li>
						<shiro:hasAnyRoles name="admin">
						<li><a href="${ pageContext.request.contextPath}/showmore.jsp"><i
								class="fa fa-table fa-fw"></i> 数据展示</a>
						</li>
						</shiro:hasAnyRoles>
						<shiro:hasAnyRoles name="manage,admin">
						<li><a href="login_find.action"><i
								class="fa fa-user fa-fw"></i> 个人中心</a>
						</li>
						</shiro:hasAnyRoles>
						
						<shiro:hasAnyRoles name="manage,admin,custom">
						<li><a href="shoes_update.action"><i
								class="fa fa-user fa-fw"></i> 个人轨迹</a>
						</li>
						</shiro:hasAnyRoles>
						<li><a href="shoes_toadd.action"><i
								class="fa fa-user fa-fw"></i> 更新轨迹</a>
						</li>
						<li><a href="shoes_toadduser.action"><i
								class="fa fa-user fa-fw"></i> 用户注册</a>
						</li>
						<li><a href="shoes_togps.action"><i
								class="fa fa-user fa-fw"></i> 用户轨迹</a>
						</li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
		</nav>
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

	<!-- Morris Charts JavaScript -->
	<script
		src="${ pageContext.request.contextPath}/vendor/raphael/raphael.min.js"></script>
	<script
		src="${ pageContext.request.contextPath}/vendor/morrisjs/morris.min.js"></script>
	<script src="${ pageContext.request.contextPath}/data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
</body>
</html>
