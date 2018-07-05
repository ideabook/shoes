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

<link href="${ pageContext.request.contextPath}/vendor/css/tab.css"
	rel="stylesheet">
<!-- Bootstrap Core CSS -->
<link
	href="${ pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${ pageContext.request.contextPath}/vendor/datetime/bootstrap-datetimepicker.min.css"
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
			
			<form role="form" action="contractinfo_add.action" method="post">
				<div class="row" style="margin-top:20px; margin-bottom:10px">

					<section>
				<div class="wizard">
					<div class="wizard-inner">
						<div class="connecting-line"></div>
						<ul class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#step1"
								data-toggle="tab" aria-controls="step1" role="tab" title="第一步">
									<span class="round-tab"> <i
										class="glyphicon glyphicon-folder-open"></i> </span> </a>
							</li>

							<li role="presentation" class="disabled"><a href="#step2"
								data-toggle="tab" aria-controls="step2" role="tab" title="第二步">
									<span class="round-tab"> <i
										class="glyphicon glyphicon-pencil"></i> </span> </a>
							</li>
							<li role="presentation" class="disabled"><a href="#step3"
								data-toggle="tab" aria-controls="step3" role="tab" title="第三步">
									<span class="round-tab"> <i
										class="glyphicon glyphicon-picture"></i> </span> </a>
							</li>

							<li role="presentation" class="disabled"><a href="#complete"
								data-toggle="tab" aria-controls="complete" role="tab" title="完成">
									<span class="round-tab"> <i
										class="glyphicon glyphicon-ok"></i> </span> </a>
							</li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" role="tabpanel" id="step1">
							<div class="step1">
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

											<div class="panel-heading">&nbsp;</div>
											<!-- /.panel-heading -->
											<div class="panel-body">

												<div class="row" style="margin-top:30px; margin-bottom:10px">
													<div class="col-lg-4">
														<div class="col-lg-3">
															<label class="control-label">编号</label>

														</div>
														<div class="col-lg-6">
															<input type="text" class="form-control" name="cno"
																id="cno" placeholder="请输入编号">
														</div>
														<div class="col-lg-3">
															<a href="javascript:void(0);" onclick="myFunction()">
																生成 </a>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="col-lg-4">
															<label class="control-label">名称</label>

														</div>
														<div class="col-lg-8">
															<input type="text" class="form-control" name="cname"
																placeholder="请输入名称">
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label for="lastname" class="col-sm-4 control-label">合同来源</label>
															<div class="col-sm-8">
																<div id="sel">
																	<select class="form-control" id="pstype" name="select">

																	</select>
																</div>
															</div>
														</div>
													</div>
												</div>

												<!-- 第二行 -->
												<div class="row" style="margin-top:20px; margin-bottom:10px">
													<div class="col-lg-4">
														<div class="col-lg-4">
															<label class="control-label">合同类型</label>

														</div>
														<div class="col-lg-8">
															<div id="sel">
																<select class="form-control" id="contype" name="contype">


																</select>

															</div>
														</div>
													</div>

													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">甲方</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" name="ca"
																	placeholder="请输入备注">
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="col-lg-4">
															<label class="control-label">乙方</label>

														</div>
														<div class="col-lg-8">
															<div id="sel">
																<select class="form-control" id="cb" name="company">


																</select>
															</div>
														</div>
													</div>
												</div>

												<!-- 第二行 -->
												<div class="row" style="margin-top:20px; margin-bottom:10px">
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">合同金额</label>
															<div class="col-sm-8">
																<input type="number" class="form-control" name="ccount"
																	placeholder="请输入金额">
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">签约日期</label>
															<div class="col-sm-8">
																<div class=" input-append date form_datetime">
																	<input class="form-control" size="16" type="text"
																		name="ctime" value="" readonly> <span
																		class="add-on"><i class="icon-remove"></i> </span> <span
																		class="add-on"><i class="icon-calendar"></i> </span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">开工日期</label>
															<div class="col-sm-8">
																<div class=" input-append date form_datetime">
																	<input class="form-control" size="16" type="text"
																		name="cworktime" value="" readonly> <span
																		class="add-on"><i class="icon-remove"></i> </span> <span
																		class="add-on"><i class="icon-calendar"></i> </span>
																</div>
															</div>
														</div>
													</div>

												</div>
												<!-- 第二行 -->
												<div class="row" style="margin-top:20px; margin-bottom:10px">
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">截止日期</label>
															<div class="col-sm-8">
																<div class=" input-append date form_datetime">
																	<input class="form-control" size="16" type="text"
																		name="cfinishtime" value="" readonly> <span
																		class="add-on"><i class="icon-remove"></i> </span> <span
																		class="add-on"><i class="icon-calendar"></i> </span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="col-lg-4">
															<label class="control-label">资金来源</label>
														</div>
														<div class="col-lg-8">
															<div id="sel">
																<select class="form-control" id="fundtype"
																	name="fundtype">


																</select>

															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-sm-4 control-label">经办人</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" name="coperator"
																	placeholder="请输入经办人">
															</div>
														</div>
													</div>


												</div>
												<div class="row">
													<div class="col-lg-6">
														<div class="form-group">
															<label class="col-sm-4 control-label">备注</label>
															<div class="col-sm-12">
																<textarea class="form-control" name="cmore" rows="3"
																	placeholder="请输入备注"></textarea>
															</div>
														</div>
													</div>
													<div class="col-lg-6">
														<div class="form-group">
															<label class="col-sm-4 control-label">付款说明</label>
															<div class="col-sm-12">
																<textarea class="form-control" name="cpayinfo" rows="3"
																	placeholder="请输入付款说明"></textarea>
															</div>
														</div>
													</div>

												</div>
												<!-- 第二行 -->
												<div class="row" style="margin-top:20px; margin-bottom:10px">

													<div class="col-lg-12">
														<center>
															<!-- /.row -->

														</center>
													</div>

												</div>
												<!-- /.table-responsive -->

											</div>
											<!-- /.panel-body -->
										</div>
										<!-- /.panel -->
									</div>
									<!-- /.col-lg-12 -->
								</div>
							</div>
							<ul class="list-inline pull-right">
								<li><button type="button" class="btn btn-primary next-step">Save
										and continue</button>
								</li>
							</ul>
						</div>
						<div class="tab-pane" role="tabpanel" id="step2">
							<div class="step2">
								<div class="step_21">
									<div class="row"></div>
								</div>
								<div class="step-22"></div>
							</div>
							<ul class="list-inline pull-right">
								<li><button type="button" class="btn btn-default prev-step">Previous</button>
								</li>
								<li><button type="button" class="btn btn-primary next-step">Save
										and continue</button>
								</li>
							</ul>
						</div>
						<div class="tab-pane" role="tabpanel" id="step3">
							<div class="step3">
								
							<ul class="list-inline pull-right">
								<li><button type="button" class="btn btn-default prev-step">Previous</button>
								</li>
								<li><button type="button" class="btn btn-default next-step">Skip</button>
								</li>
								<li><button type="button"
										class="btn btn-primary btn-info-full next-step">Save
										and continue</button></li>
							</ul>
							</div>
						</div>
						<div class="tab-pane" role="tabpanel" id="complete">
							<div class="step4" style="margin-left: 20px;margin-right: 40">

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">科室</label>

									</div>
									<div class="col-lg-8">
										<input type="text" class="form-control" name="csuboffice"
											placeholder="请输入科室">
									</div>
								</div>
								<div class="row">
									<button class="btn btn-primary">添加合同</button>
								</div>

							</div>
						</div>
					</div>

				</div>
				</section>
			
				</div>
			</form>
		</div>


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
		<script
			src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
		<script src="${ pageContext.request.contextPath}/js/tab.js"></script>
		<script
			src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
		<script
			src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>

		<script>
			$(document)
					.ready(
							function() {
								$
										.ajax({
											url : "confrom_toJson.action", //后台处理程序  
											type : "post", //数据发送方式  
											async : false,
											dataType : "json", //接受数据格式             
											error : function() {
											},

											success : function(data) {
												var json = eval(data.confrom);
												var da = "<option value='-1'>=请选择=</option>";
												for ( var i = 0; i < json.length; i++) {
													da += "<option value='" + json[i].cfid + "'>"
															+ json[i].cffrom
															+ "</option>";

												}
												document
														.getElementById("pstype").innerHTML = da;

											}
										});
							});
		</script>
		<script>
			$(document)
					.ready(
							function() {
								$
										.ajax({
											url : "contype_toJson.action", //后台处理程序  
											type : "post", //数据发送方式  
											async : false,
											dataType : "json", //接受数据格式             
											error : function() {
											},

											success : function(data) {
												var json = eval(data.contype);
												var da = "<option value='-1'>=请选择=</option>";
												for ( var i = 0; i < json.length; i++) {
													da += "<option value='" + json[i].ctid + "'>"
															+ json[i].cttype
															+ "</option>";

												}
												document
														.getElementById("contype").innerHTML = da;

											}
										});
							});
		</script>
		<script>
			$(document)
					.ready(
							function() {
								$
										.ajax({
											url : "company_toJson.action", //后台处理程序  
											type : "post", //数据发送方式  
											async : false,
											dataType : "json", //接受数据格式             
											error : function() {
											},

											success : function(data) {
												var json = eval(data.cb);
												var da = "<option value='-1'>=请选择=</option>";
												for ( var i = 0; i < json.length; i++) {
													da += "<option value='" + json[i].comid + "'>"
															+ json[i].comname
															+ "</option>";

												}
												document.getElementById("cb").innerHTML = da;

											}
										});
							});
		</script>
		<script>
			$(document)
					.ready(
							function() {
								$
										.ajax({
											url : "fundtype_toJson.action", //后台处理程序  
											type : "post", //数据发送方式  
											async : false,
											dataType : "json", //接受数据格式             
											error : function() {
											},

											success : function(data) {
												var json = eval(data.fundtype);
												var da = "<option value='-1'>=请选择=</option>";
												for ( var i = 0; i < json.length; i++) {
													da += "<option value='" + json[i].fid + "'>"
															+ json[i].ftype
															+ "</option>";

												}
												document
														.getElementById("fundtype").innerHTML = da;

											}
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

		<script>
			function myFunction() {
				$.ajax({
					url : "contractinfo_generCno.action", //后台处理程序  
					type : "get", //数据发送方式  
					async : false,
					dataType : "text", //接受数据格式             
					error : function() {

					},

					success : function(data) {
						$("#cno").val(data);
					}
				});
			}
		</script>
</body>

</html>
