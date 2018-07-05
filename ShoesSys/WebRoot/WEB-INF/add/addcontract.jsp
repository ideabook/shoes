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
<link
	href="${ pageContext.request.contextPath}/vendor/datetime/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="${ pageContext.request.contextPath}/vendor/css/tab.css"
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
			<form action="${pageContext.request.contextPath}/add/contractinfo_add.action" method="post">
				<section>
				<div class="wizard">
					<div class="wizard-inner">
						<div class="connecting-line"></div>
						<ul class="nav nav-tabs" role="tablist">

							<li role="presentation" class="active"><a href="#step1"
								data-toggle="tab" aria-controls="step1" role="tab"
								title="Step 1"> <span class="round-tab"> <i
										class="glyphicon glyphicon-folder-open"></i> </span> </a></li>

							<li role="presentation" class="disabled"><a href="#step2"
								data-toggle="tab" aria-controls="step2" role="tab" title="第二步">
									<span class="round-tab"> <i
										class="glyphicon glyphicon-pencil"></i> </span> </a></li>

							<li role="presentation" class="disabled"><a href="#step3"
								data-toggle="tab" aria-controls="step3" role="tab"
								title="Step 3"> <span class="round-tab"> <i
										class="glyphicon glyphicon-picture"></i> </span> </a></li>

							<li role="presentation" class="disabled"><a href="#complete"
								data-toggle="tab" aria-controls="complete" role="tab"
								title="Complete"> <span class="round-tab"> <i
										class="glyphicon glyphicon-ok"></i> </span> </a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane active" role="tabpanel" id="step1">
							<div class="step1">
								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-default">
											<div class="panel-heading">&nbsp;</div>
											<!-- /.panel-heading -->
											<div class="panel-body">

												<div class="row"
													style="margin-top:10px; margin-bottom:10px; text-align: center;">
													<div class="col-lg-4">
														<div class="col-lg-3" style=" text-align: right ;">
															<label class="control-label">编号</label>
														</div>
														<div class="col-lg-6" style="  ">
															<input type="text" class="form-control" name="cno"
																id="gencno" placeholder="请输入编号">
														</div>
														<div class="col-lg-3" style="text-align: center;">
															<a href="javascript:void(0);" onclick="myFunction()">
																<label class="control-label">生成</label> </a>

														</div>
													</div>
													<div class="col-lg-4">

														<div class="col-lg-4">
															<label class="control-label">合同名称</label>
														</div>
														<div class="col-lg-8">
															<input type="text" class="form-control" name="cname"
																placeholder="请输入名称">
														</div>

													</div>
													<div class="col-lg-4">

														<div class="col-lg-4">
															<label class="control-label">合同总额</label>
														</div>
														<div class="col-lg-8">
															<input type="number" class="form-control" name="ccount"
															id="ccount"	placeholder="请输入金额">
														</div>

													</div>

												</div>

												<!-- 第二行 -->
												<div class="row"
													style="margin-top:20px; margin-bottom:10px;text-align: center;">
													<div class="col-lg-4">
														<div class="form-group">
															<div class="col-lg-4">
																<label class="control-label">甲方</label>
															</div>
															<div class="col-lg-8">
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
																<select class="form-control" id="cb" name="scb">


																</select>
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="col-lg-4">
															<label class="control-label">合同类型</label>

														</div>
														<div class="col-lg-8">
															<div id="sel">
																<select class="form-control" id="contype" name="sctype">


																</select>

															</div>
														</div>
													</div>
												</div>

												<!-- 第三行 -->
												<div class="row"
													style="margin-top:20px; margin-bottom:10px;text-align: center;">

													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-lg-4 control-label">签订时间</label>
															<div class="col-lg-8">
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
															<label class="col-lg-4 control-label">开工时间</label>
															<div class="col-lg-8">
																<div class=" input-append date form_datetime">
																	<input class="form-control" size="16" type="text"
																		name="cworktime" value="" readonly> <span
																		class="add-on"><i class="icon-remove"></i> </span> <span
																		class="add-on"><i class="icon-calendar"></i> </span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-lg-4 control-label">截止时间</label>
															<div class="col-lg-8">
																<div class=" input-append date form_datetime">
																	<input class="form-control" size="16" type="text"
																		name="cfinishtime" value="" readonly> <span
																		class="add-on"><i class="icon-remove"></i> </span> <span
																		class="add-on"><i class="icon-calendar"></i> </span>
																</div>
															</div>
														</div>
													</div>

												</div>
												<!-- 第四行 -->
												<div class="row"
													style="margin-top:20px; margin-bottom:10px;text-align: center;">
													<div class="col-lg-4">
														<div class="form-group">
															<label for="lastname" class="col-lg-4 control-label">合同来源</label>
															<div class="col-lg-8">
																<div id="sel">
																	<select class="form-control" id="pstype" name="select">


																	</select>

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
																	name="sfundtype" onchange='btnChange(this[selectedIndex].value);' >


																</select>

															</div>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="col-lg-4 control-label">经办人</label>
															<div class="col-lg-8">
																<input type="text" class="form-control" name="coperator"
																	placeholder="请输入经办人">
															</div>
														</div>
													</div>


												</div>
												<!-- 第二行 -->
												<div class="row" style="margin-top:20px; margin-bottom:10px">
													<div class="col-lg-12">
														<div class="col-lg-6">

															<div class="form-group">
																<label class="col-lg-4 control-label">备注</label>
																<div class="col-lg-12">
																	<textarea class="form-control" name="cmore" rows="3"
																		placeholder="请输入备注"></textarea>
																</div>
															</div>
														</div>
														<div class="col-lg-6">

															<div class="form-group">
																<label class="col-lg-4 control-label">付款说明</label>
																<div class="col-lg-12">
																	<textarea class="form-control" name="cpayinfo" rows="3"
																		placeholder="请输入付款说明"></textarea>
																</div>
															</div>
														</div>
													</div>

												</div>
												<!-- 第二行 -->

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
								<li><button type="button" class="btn btn-primary next-step">下一步</button>
								</li>
							</ul>
						</div>
						<div class="tab-pane" role="tabpanel" id="step2">
							<div class="step2"></div>
							<ul class="list-inline pull-right">
								<li><button type="button" class="btn btn-default prev-step">上一步</button>
								</li>
								<li><button type="button" class="btn btn-primary next-step">下一步</button>
								</li>
							</ul>
						</div>
						<div class="tab-pane" role="tabpanel" id="step3">
							<div class="step3"></div>

							<ul class="list-inline pull-right">
								<li><button type="button" class="btn btn-default prev-step">上一步</button>
								</li>
								<li><button type="button" class="btn btn-default next-step">跳过</button>
								</li>
								<li><button type="button"
										class="btn btn-primary btn-info-full next-step">下一步</button>
								</li>
							</ul>
						</div>
						<div class="tab-pane" role="tabpanel" id="complete">
							<div class="step4">
								<h5>完成</h5>
								<div class="row" style="margin-top:20px; margin-bottom:10px">

									<div class="col-lg-12">
										<center>
											<!-- /.row -->
											<button class="btn btn-primary">添加合同</button>
										</center>
									</div>

								</div>

							</div>
						</div>

					</div>
				</div>
				</section>
			</form>
		</div>
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
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
	<script src="${ pageContext.request.contextPath}/js/tab.js"></script>
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
		$(document).ready(
				function() {
					$.ajax({
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
										+ json[i].cffrom + "</option>";

							}
							document.getElementById("pstype").innerHTML = da;

						}
					});
				});
	</script>
	<script>
		$(document).ready(
				function() {
					$.ajax({
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
										+ json[i].cttype + "</option>";

							}
							document.getElementById("contype").innerHTML = da;

						}
					});
				});
	</script>
	<script>
		$(document).ready(
				function() {
					$.ajax({
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
										+ json[i].comname + "</option>";

							}
							document.getElementById("cb").innerHTML = da;

						}
					});
				});
	</script>
	<script>
		$(document).ready(
				function() {
					$.ajax({
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
										+ json[i].ftype + "</option>";

							}
							document.getElementById("fundtype").innerHTML = da;

						}
					});
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
					$("#gencno").val(data);

				}
			});
		}
	</script>

	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			minView: "month", 
			autoclose: true,//选择后自动关闭
			pickerPosition : "bottom-left"
		});
	</script>
	<script type="text/javascript">
	function btnChange(values) {
		 
			$.ajax({
				url : "fundtype_toJson.action", //后台处理程序  
				type : "post", //数据发送方式  
				async : false,
				dataType : "json", //接受数据格式             
				error : function() {
				},
				success : function(data) {
					var json = eval(data.fundtype);
					var ccount=$("#ccount").val();
					if(json[values-1].fcount<ccount){
						alert("合同总额大于资金总额");	
					}
				}
			});
	}
	
	</script>
</body>

</html>
