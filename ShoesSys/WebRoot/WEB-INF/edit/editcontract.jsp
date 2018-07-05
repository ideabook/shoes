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
<link
	href="${ pageContext.request.contextPath}/vendor/datetime/bootstrap-datetimepicker.min.css"
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
				<h3 class="page-header">修改合同</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<s:form role="form" action="contractinfo_update" method="post">

							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<s:hidden name="cid" value="%{model.cid}"></s:hidden>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">编号</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="cno"
											value="%{model.cno}" placeholder="请输入合同编号"></s:textfield>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同名称</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="cname"
											value="%{model.cname}" placeholder="请输入合同名称"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同总额</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="number" class="form-control" name="ccount"
											id="ccount" value="%{model.ccount}" placeholder="请输入合同金额"></s:textfield>
									</div>
								</div>


							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">甲方</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="ca"
											value="%{model.ca}" placeholder="请输入甲方"></s:textfield>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">乙方</label>

									</div>
									<div class="col-lg-8">

										<select class="form-control" id="cb" name="scompany">
											<option></option>
										</select>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同类型</label>

									</div>
									<div class="col-lg-8">

										<select class="form-control" id="contype" name="scontype">

										</select>
									</div>
								</div>


							</div>


							<!-- 第三行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">签订时间</label>

									</div>
									<div class="col-lg-8">
										<div class=" input-append date form_datetime">
											<input class="form-control" size="16" type="text"
												name="ctime"
												value=<s:date
											name="%{model.ctime}" format="yyyy年MM月dd日" />
												readonly> <span class="add-on"><i
												class="icon-remove"></i> </span> <span class="add-on"><i
												class="icon-calendar"></i> </span>

										</div>
									</div>
								</div>


								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">开工时间</label>

									</div>
									<div class="col-lg-8">
										<div class=" input-append date form_datetime">
											<input class="form-control" size="16" type="text"
												name="cworktime"
												value=<s:date
											name="%{model.cworktime}" format="yyyy年MM月dd日" />
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
										<div class=" input-append date form_datetime">
											<input class="form-control" size="16" type="text"
												name="cfinishtime"
												value=<s:date
											name="%{model.cfinishtime}" format="yyyy年MM月dd日" />
												readonly> <span class="add-on"><i
												class="icon-remove"></i> </span> <span class="add-on"><i
												class="icon-calendar"></i> </span>

										</div>
									</div>
								</div>


							</div>
							<!-- 第四行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">资金来源</label>

									</div>
									<div class="col-lg-8">
										<select class="form-control" id="fundtype" name="sfundtype"
											onchange='btnChange(this[selectedIndex].value);'>
											<option>
												<s:property value="%{model.cpayfrom}" />
											</option>
										</select>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同来源</label>

									</div>
									<div class="col-lg-8">

										<select class="form-control" id="confrom" name="sselect">
											<option>
												<s:property value="%{model.cfrom}" />
											</option>
										</select>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">经办人</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="coperator"
											value="%{model.coperator}" placeholder="请输入经办人"></s:textfield>
									</div>
								</div>

							</div>
							<!-- 第四行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
					

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">科室</label>

									</div>
									<div class="col-lg-8">
										<s:textfield type="text" class="form-control" name="csuboffice"
											value="%{model.csuboffice}" placeholder="请输入科室"></s:textfield>
									</div>
								</div>

							</div>

							<!-- 第六行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px" >
								<div class="col-lg-6">
									<div class="form-group">
										<label class="col-sm-4 control-label">备注</label>
										<div class="col-sm-12">
											<s:textarea value="%{model.cmore}" class="form-control"
												name="cmore" rows="3" placeholder="请输入备注"></s:textarea>
										</div>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="col-sm-4 control-label">付款说明</label>
										<div class="col-sm-12">
											<s:textarea value="%{model.cpayinfo}" class="form-control"
												name="cpayinfo" rows="3" placeholder="请输入付款说明"></s:textarea>
										</div>
									</div>
								</div>

							</div>
					</div>



					<div class="row" style="margin-top:40px; margin-bottom:10px">

						<div class="col-lg-12">
							<center>
								<!-- /.row -->
								<button type="submit" class="btn btn-primary">修改合同</button>
							</center>
						</div>


					</div>
					<!-- /.table-responsive -->
					</s:form>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
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
		src="${ pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>

	<script
		src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
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
											var da = "";
											var k = '<s:property value="%{model.cfrom}" />';
											for ( var i = 0; i < json.length; i++) {
												if (k == json[i].cfid) {
													da += "<option selected='selected' value='" + json[i].cfid + "'>"
															+ json[i].cffrom
															+ "</option>";
												} else {
													da += "<option value='" + json[i].cfid + "'>"
															+ json[i].cffrom
															+ "</option>";
												}

											}
											document.getElementById("confrom").innerHTML = da;

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
											var da = "";
											var k = '<s:property value="%{model.ctype}" />';
											for ( var i = 0; i < json.length; i++) {
												if (k == json[i].ctid) {
													da += "<option selected='selected' value='" + json[i].ctid + "'>"
															+ json[i].cttype
															+ "</option>";
												} else {
													da += "<option value='" + json[i].ctid + "'>"
															+ json[i].cttype
															+ "</option>";
												}

											}
											document.getElementById("contype").innerHTML = da;

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
											var da = "";
											var k = '<s:property value="%{model.cb}" />';
											for ( var i = 0; i < json.length; i++) {

												if (json[i].comid == k) {
													da += "<option selected='selected'  value='" + json[i].comid + "'>"
															+ json[i].comname
															+ "</option>";
												} else {
													da += "<option value='" + json[i].comid + "'>"
															+ json[i].comname
															+ "</option>";
												}

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
											var da = "";
											var k = '<s:property value="%{model.cpayfrom}" />';
											for ( var i = 0; i < json.length; i++) {
												if (json[i].fid == k) {
													da += "<option selected='selected' value='" + json[i].fid + "'>"
															+ json[i].ftype
															+ "</option>";
												} else {
													da += "<option value='" + json[i].fid + "'>"
															+ json[i].ftype
															+ "</option>";
												}

											}
											document.getElementById("fundtype").innerHTML = da;

										}
									});
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
					var ccount = $("#ccount").val();
					if (json[values - 1].fcount < ccount) {
						alert("合同总额大于资金总额");
					}
				}
			});
		}
	</script>
</body>

</html>
