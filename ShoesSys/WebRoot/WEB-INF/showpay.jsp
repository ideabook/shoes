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

<meta charset="utf-8">
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
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">付款流水</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row" style="margin-bottom: 20px">
			<div class="col-lg-12">

				<span class="pull-right"> <!-- /.row --> <a
					href="${pageContext.request.contextPath }/pay_toadd.action">
						<button class="btn  btn-outline btn-primary">添加付款</button> </a> </span>
			</div>
		</div>
		<form action="pay_findmodel" method="post">
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
					<button class="btn  btn-outline btn-primary">搜索</button>
				</div>
			</div>
		</form>


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="row">
							<s:hidden>
								<s:property value="#d.pid"></s:property>
							</s:hidden>
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th align="center">编号</th>
										<th align="center">合同编号</th>
										<th align="center">合同名称</th>
										<th align="center">付款金额</th>
										<th align="center">付款日期</th>
										<th align="center">银行账号</th>
										<th align="center">经办人</th>
										<th align="center">操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="list" var="d" status="b">

										<tr>
											<td align="center"><s:property value="#b.index+1" />
											<td align="center"><s:property
													value="#d.contractinfo.cno"></s:property>
											</td>
											<td align="center"><s:property
													value="#d.contractinfo.cname"></s:property>
											</td>
											<td align="center"><s:property value="#d.ppay"></s:property>
											</td>
											<td align="center"><s:date name="#d.pdate"
													format="yyyy年MM月dd日" />
											</td>

											<td align="center"><s:property value="#d.pbankno"></s:property>
											</td>

											<td align="center"><s:property value="#d.poperator"></s:property>
											</td>
											<td align="center"><a href="javascript:void(0);"
												onclick="myFunction(<s:property value="#d.pid"></s:property>)"><i
													class="fa fa-times fa-fw"></i> </a>
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
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
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script type="text/javascript">
		function btnChange(values) {
			window.location.href="${pageContext.request.contextPath }/pay_findcid.action?cid="+values;
			
		}
	</script>
	<script>
			function myFunction(id) {
				var x;
				var r = confirm("确定删除吗");
				if (r == true) {
					window.location.href="${pageContext.request.contextPath }/pay_delete.action?pid="+id;
				} else {
					
				}
			}
		</script>

</body>

</html>
