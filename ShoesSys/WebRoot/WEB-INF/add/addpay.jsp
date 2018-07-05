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
<link href="http://cdn.bootcss.com/prettify/r224/prettify.css"
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
				<h3 class="page-header">付款</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">


					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<form role="form" action="pay_add.action" method="post">
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-8">
									<div class="col-lg-4">
										<label class="control-label">合同编号</label>
									</div>
									<div class="col-lg-8">

										<select class="form-control" id="pay" name="pay"
											onchange='btnChange(this[selectedIndex].value);'>


										</select>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">付款金额</label>

									</div>
									<div class="col-lg-8">
										<input type="number" class="form-control" id="ppayid" name="ppay"
											placeholder="请输入付款金额">
									</div>
								</div>
							</div>
							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">付款比例</label>

									</div>
									<div class="col-lg-8">
										<input type="text" class="form-control" name="paypercent"
											id="paypercent" placeholder="请输入付款比例">
									</div>
								</div>

							</div>

							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">付款日期</label>

									</div>
									<div class="col-lg-8">
										<div class=" input-append date form_datetime">
											<input class="form-control" size="16" type="text"
												name="pdate" value="" readonly> <span class="add-on"><i
												class="icon-remove"></i> </span> <span class="add-on"><i
												class="icon-calendar"></i> </span>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">银行卡号</label>

									</div>
									<div class="col-lg-8">
										<input type="text" class="form-control" name="pbankno"
											id="bankno" placeholder="请输入银行卡号">
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">经办人</label>

									</div>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="test1" name="poperator"
											placeholder="请输入经办人">
									</div>
								</div>
							</div>



							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">

								<div class="col-lg-12">
									<center>
										<!-- /.row -->
										<button type="submit" class="btn btn-primary">添加付款记录</button>
									
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
	<script
		src="${ pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>

	<script
		src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	<!-- DataTables JavaScript -->

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
		$(document).ready(
				function() {
					$.ajax({
						url : "contractinfo_toJson.action", //后台处理程序  
						type : "post", //数据发送方式  
						async : false,
						dataType : "json", //接受数据格式             
						error : function() {
							alert("服务器没有返回数据，可能服务器忙，请重试");
						},

						success : function(data) {
							var json = eval(data.contract);
							var da = "<option value='-1'>=请选择=</option>";
							for ( var i = 0; i < json.length; i++) {
								da += "<option value='" + json[i].cid + "'>"
										+ json[i].cno + "---" + json[i].cname
										+ "</option>";

							}
							document.getElementById("pay").innerHTML = da;

						}
					});
				});
	</script>
	
	<script type="text/javascript">
		function btnChange(values) {
		
			$.ajax({
				url : "contractinfo_toJson.action", //后台处理程序  
				type : "post", //数据发送方式  
				async : false,
				dataType : "json", //接受数据格式             
				error : function() {
				},
				success : function(data) {
					var json = eval(data.contract);
					var cb = "";
					var ca="";
					for ( var i = 0; i < json.length; i++) {
						if (values == json[i].cid) {
							cb = json[i].cb;
							function btnChange2(cb) {
								ca = cb + "33";
								alert("--"+ca);
								return ca;
							}
						}
				
					}
					
					
				}
			});
		}
	</script>
</body>

</html>
