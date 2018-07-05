<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="/top.jsp" />
<html lang="en">

<head>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>合同管理系统</title>

<!-- Bootstrap Core CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.css"
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


	<div id="page-wrapper">


		<!-- /.row -->

		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">修改合同来源</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">


					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<s:form role="form" action="confrom_update" method="post">

							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">编号</label>

									</div>
									<div class="col-lg-9">
										<s:textfield type="text" class="form-control" name="cfid"
											id="lastname" readonly="true"></s:textfield>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">合同来源</label>

									</div>
									<div class="col-lg-9">
										<s:textfield type="text" class="form-control" name="cffrom"
											id="lastname" value="%{model.cffrom}"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">备注</label>

									</div>
									<div class="col-lg-9">
										<s:textfield type="text" class="form-control" name="cfmore"
											id="lastname" value="%{model.cfmore}" placeholder="请输入编号"></s:textfield>
									</div>
								</div>
							</div>


							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">

							</div>
							<div class="row" style="margin-top:20px; margin-bottom:10px">

								<div class="col-lg-12">
									<center>
										<!-- /.row -->
										<button type="submit" class="btn btn-primary">修改合同类型</button>
									</center>
								</div>

							</div>
						</s:form>
					</div>
					<!-- 第二行 -->

				</div>

				<!-- /.table-responsive -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->




	<!-- /#wrapper -->

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
	<!-- DataTables JavaScript -->
	<script
		src="${ pageContext.request.contextPath}/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${ pageContext.request.contextPath}/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${ pageContext.request.contextPath}/vendor/datatables-responsive/dataTables.responsive.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>

</html>
