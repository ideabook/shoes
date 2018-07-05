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
<link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<script type="text/javascript"
	src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<!-- Bootstrap Core CSS -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script
	src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>

<link rel="stylesheet" type="text/css" media="screen"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
</head>

<body>


	<div id="page-wrapper">


		<!-- /.row -->

		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">付款</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<!--<select class="form-control" id="pstype" name="pstype">
							<option value="-1">=请选择=</option>
							<s:iterator value="list" var="d">
								<option>
									<s:property value="#d.cmore"></s:property>
								</option>

							</s:iterator>
						</select>
						-->

					<div class="panel-heading">DataTables Advanced Tables</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<form role="form" action="company_add" method="post">
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">合同编号</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="cid"
											id="lastname" placeholder="合同编号">
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">付款日期</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="pdate"
											id="lastname" placeholder="付款日期">
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">累计付款</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="ptotal"
											id="lastname" placeholder="请输入累计付款">
									</div>
								</div>
							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">银行卡号</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="pbankno"
											id="lastname" placeholder="请输入银行卡号">
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">操作员</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="poperator"
											id="lastname" placeholder="请输入联系人">
									</div>
								</div>
							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class='col-sm-6'>
									<div class="form-group">
										<div class='input-group date' id='datetimepicker1'>
											<input type='text' class="form-control" /> <span
												class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span> </span>
										</div>
									</div>
								</div>
								<script type="text/javascript">
									$(function() {
										$('#datetimepicker1').datetimepicker();
									});
								</script>
								<div class="col-lg-4">
									<div class="col-lg-3">
										<label class="control-label">操作员</label>

									</div>
									<div class="col-lg-9">
										<input type="text" class="form-control" name="poperator"
											id="lastname" placeholder="请输入联系人">
									</div>
								</div>
							</div>



							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">

								<div class="col-lg-12">
									<center>
										<!-- /.row -->
										<button class="btn btn-primary">添加合同</button>
									</center>
								</div>
							</div>
						</form>
						<!-- /.table-responsive -->
					</div>

				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>



	<!-- /#wrapper -->


</body>

</html>
