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
				<h3 class="page-header">合同来源</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row" style="margin-bottom: 20px" >
			<div class="col-lg-12">

				<span class="pull-right"> <!-- /.row --> <a
					href="${pageContext.request.contextPath }/confrom_toadd.action">
						<button class="btn  btn-outline btn-primary">添加合同来源</button> </a> </span>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="row">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th align="center">序号</th>
										<th align="center">合同类型</th>
										<th align="center">备注</th>
										<th align="center">编辑</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="list" var="d" status="b">

										<tr id="tr">
											<!--  <td><s:checkbox name="ids" width="30dp" value="false" fieldValue="%{#d.cid}"></s:checkbox></td>-->
											<td align="center"><s:property value="#b.index+1" />
											</td>
											<td align="center"><s:property value="#d.cffrom"></s:property>
											</td>
											<td align="center"><s:property value="#d.cfmore"></s:property>
											</td>
											<td align="center"><a
												href="${pageContext.request.contextPath }/confrom_edit.action?cfid=<s:property value="#d.cfid"></s:property>"><i
													class="fa fa-edit fa-fw"></i> </a> &nbsp;&nbsp;&nbsp;&nbsp; <a
												href="javascript:void(0);"
												onclick="myFunction(<s:property value="#d.cfid"></s:property>)"><i
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
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
	<script>
			function myFunction(id) {
				var x;
				var r = confirm("确定删除吗");
				if (r == true) {
					window.location.href="${pageContext.request.contextPath }/confrom_delete.action?cfid="+id;
				} else {
					
				}
			}
		</script>

</body>

</html>
