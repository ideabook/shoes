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
<link
	href="${ pageContext.request.contextPath}/vendor/datetime/bootstrap-datetimepicker.min.css"
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
				<h3 class="page-header">更新公司信息</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<form role="form" action="company_update" method="post">
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<s:hidden name="comid" value="%{model.comid}"></s:hidden>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">公司名称</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="comname"
											value="%{model.comname}" placeholder="请输入公司名称"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">公司地址</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="comaddress"
											value="%{model.comaddress}" placeholder="请输入地址"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="form-group">
										<label for="lastname" class="col-sm-4 control-label">开户银行</label>
										<div class="col-sm-8">
											<select class="form-control" id="pstype" name="pstype">
												<option value="-1">=请选择=</option>
												<option value="1">中国银行</option>
												<option value="2">中国农业银行</option>
												<option value="3">中国建设银行</option>
												<option value="4">中国工商银行</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">银行卡号</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="combank"
											 value="%{model.combank}" placeholder="请输入银行卡号"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">联系人</label>

									</div>
									<div class="col-lg-8">
										<s:textfield  type="text" class="form-control" name="comcontacts"
											value="%{model.comcontacts}" placeholder="请输入联系人"></s:textfield>
									</div>

								</div>
								<div class="col-lg-4">
									<div class="form-group">
										<label for="lastname" class="col-sm-4 control-label">联系电话</label>
										<div class="col-sm-8">
											<s:textfield type="text" class="form-control"  
											value="%{model.comtel}"	name="comtel" placeholder="请输入联系电话"></s:textfield>
										</div>
									</div>
								</div>

							</div>

							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="form-group">
										<label for="lastname" class="col-sm-4 control-label">更多</label>
										<div class="col-sm-8">
											<s:textfield type="text" class="form-control"  
												value="%{model.commore}" name="commore" placeholder="请输入备注"></s:textfield>
										</div>
									</div>
								</div>
								
							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">

								<div class="col-lg-12">
									<center>
										<!-- /.row -->
										<button class="btn btn-primary">更新公司信息</button>
									</center>
								</div>


							</div>
							<!-- /.table-responsive -->
						</form>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>

	</div>

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="${ pageContext.request.contextPath}/vendor/jquery/jquery.js"></script>

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
			format : "yyyy-mm-dd hh:ii",
			autoclose : true,
			todayBtn : true,
			pickerPosition : "bottom-center"
		});
	</script>
</body>

</html>
