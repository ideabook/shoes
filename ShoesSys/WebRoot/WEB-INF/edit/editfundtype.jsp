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
<link
	href="${ pageContext.request.contextPath}/vendor/datetime/bootstrap-datetimepicker.min.css"
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
				<h3 class="page-header">修改资金来源类型</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">


					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<s:form role="form" action="fundtype_update" method="post">

							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<s:hidden name="fid" value="%{model.fid}"></s:hidden>
									<div class="col-lg-4">
										<label class="control-label">编号</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="fno"
											value="%{model.fno}"></s:textfield>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">资金来源类型</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="ftype"
											value="%{model.ftype}"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">总额</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="number" class="form-control" name="fcount"
											value="%{model.fcount}"></s:textfield>
									</div>
								</div>
							</div>
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">开始时间</label>

									</div>
									<div class="col-lg-8">
										<div class=" input-append date form_datetime">
											<input class="form-control" size="16" type="text"
												name="fstart"
												value=<s:date
											name="%{model.fstart}" format="yyyy年MM月dd日" />
												readonly> <span class="add-on"><i
												class="icon-remove"></i> </span> <span class="add-on"><i
												class="icon-calendar"></i> </span>

										</div>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">截止时间</label>

									</div>
									<div class="col-lg-8">

										<div class=" input-append date form_datetime2">
											<input class="form-control" size="16" type="text" name="fend"
												value=<s:date
											name="%{model.fend}" format="yyyy-MM-dd HH:mm:ss" />
												readonly> <span class="add-on"><i
												class="icon-remove"></i> </span> <span class="add-on"><i
												class="icon-calendar"></i> </span>

										</div>

									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">备注</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="fmore"></s:textfield>
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
										<button type="submit" class="btn btn-primary">修改资金来源类型</button>
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
	<script
		src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="${ pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			startDate: new Date(),
			pickerPosition : "bottom-center"
		});
		$(".form_datetime2").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			
			
			pickerPosition : "bottom-center"
		});
	</script>
</body>

</html>
