<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<h3 class="page-header">资金详情</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<!-- 第一行 -->
						<div class="row" style="margin-top:30px; margin-bottom:10px">
							<div class="col-lg-4">
								<div class="col-lg-4">
									<label>编号:</label>

								</div>
								<div class="col-lg-8">
									<s:label value="%{model.fno}"></s:label>
								</div>
							</div>

							<div class="col-lg-4">
								<div class="col-lg-4">
									<label class="control-label">资金名称:</label>

								</div>
								<div class="col-lg-8">
									<s:label class="control-label" value="%{model.ftype}"></s:label>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="col-lg-4">
									<label class="control-label">资金总额:</label>

								</div>
								<div class="col-lg-8">
									<s:label class="control-label" value="%{model.fcount}"></s:label>
									元
								</div>
							</div>
						</div>
						<!-- 第一行 -->
						<div class="row" style="margin-top:30px; margin-bottom:10px">
							<div class="col-lg-4">
								<div class="col-lg-4">
									<label>剩余金额:</label>

								</div>
								<div class="col-lg-8">
									<s:label value="%{model.fleft}"></s:label>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="col-lg-4">
									<label class="control-label">起始时间：</label>

								</div>
								<div class="col-lg-8">
									<label class="control-label"><s:date
											name="%{model.fstart}" format="yyyy年MM月dd日" /> </label>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="col-lg-4">
									<label class="control-label">截止时间：</label>

								</div>
								<div class="col-lg-8">
									<label class="control-label"><s:date
											name="%{model.fend}" format="yyyy年MM月dd日" /> </label>
								</div>
							</div>

						</div>

						<!-- 第二行 -->
						<div class="row" style="margin-top:30px; margin-bottom:10px">

							<div class="col-lg-4">
								<div class="col-lg-4">
									<label class="control-label">备注：</label>

								</div>
								<div class="col-lg-8">
									<s:label class="control-label" value="%{model.fmore}"></s:label>
								</div>
							</div>


						</div>







						<!-- 第二行 -->
						<div class="row" style="margin-top:20px; margin-bottom:10px">



						</div>
						<!-- /.table-responsive -->
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">付款记录</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="row">
							<div class="row" style="margin-left: 10; margin-bottom: 10;">
								<label>合同总额为：<s:property value="paycount"></s:property>元</label>
							</div>
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th align="center">序号</th>
										<th align="center">编号</th>
										<th align="center">合同名称</th>
										<th align="center">甲方</th>
										<th align="center">乙方</th>
										<th align="center">合同金额</th>
										<th align="center">已付款</th>
										<th align="center">未付款</th>
										<th align="center">查看</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="list" var="d" status="b">

										<tr id="tr">
											<!--  <td><s:checkbox name="ids" width="30dp" value="false" fieldValue="%{#d.cid}"></s:checkbox></td>-->
											<td align="center"><s:property value="#b.index+1" /></td>
											<td align="center"><s:property value="#d.cno"></s:property>
											</td>
											<td align="center"><s:property value="#d.cname"></s:property>
											</td>
											<td align="center"><s:property value="#d.ca"></s:property>
											</td>
											<td align="center"><s:property
													value="#d.companyinfo.comname"></s:property></td>
											<td align="center"><s:property value="#d.ccount"></s:property>
											</td>
											<td align="center"><s:property value="#d.cpaid"></s:property>
											</td>
											<td align="center"><s:property
													value="#d.ccount-#d.cpaid" /></td>

											<td align="center"><a
												href="${pageContext.request.contextPath }/contractinfo_find.action?cid=<s:property value="#d.cid"></s:property>">查看详情<i
													class="fa fa-arrow-right fa-fw"></i> </a></td>
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
				window.location.href = "${pageContext.request.contextPath }/pay_delete.action?pid="
						+ id;
			} else {

			}
		}
	</script>
</body>

</html>
