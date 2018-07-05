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
				<h3 class="page-header">整体概况</h3>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-suitcase fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div id="demo" class="huge"></div>
								<div>合同总数</div>
							</div>
						</div>
					</div>
					<a href="contractinfo_findAll2.action">
						<div class="panel-footer">
							<span class="pull-left">详情</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i> </span>
							<div class="clearfix"></div>
						</div> </a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-green">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-rmb fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right ">
								<div class="huge2" id="pay" style=" margin-top:10px;">124</div>
								<div style="float:right; margin-top:12px; margin-right:7px">合同总额</div>
							</div>

						</div>
					</div>
					<a href="pay_findAll.action">
						<div class="panel-footer">
							<span class="pull-left">详情</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i> </span>
							<div class="clearfix"></div>
						</div> </a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-shopping-cart fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div id="paid" class="huge2" style=" margin-top:10px;">124</div>
								<div style="float:right; margin-top:12px; margin-right:7px">已付款</div>
							</div>
						</div>
					</div>
					<a href="pay_findAll.action">
						<div class="panel-footer">
							<span class="pull-left">详情</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i> </span>
							<div class="clearfix"></div>
						</div> </a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-red">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-bar-chart-o fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">13</div>
								<div>最近一月新增合同</div>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer">
							<span class="pull-left">详情</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i> </span>
							<div class="clearfix"></div>
						</div> </a>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">详情</h3>

				<span class="pull-right"> <!-- /.row --> <a
					href="${pageContext.request.contextPath }/contractinfo_toadd2.action">
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#myModal">添加合同</button> </a> </span>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<form action="contractinfo_findmodel" method="post">
			<div class="row" style="margin-top: 20px">

				<div class="col-lg-4">
					<div class="col-lg-4">
						<label class="control-label">编号</label>

					</div>
					<div class="col-lg-8">
						<input type="text" class="form-control" name="cno"
							placeholder="请输入编号">
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
					<div class="col-lg-4">
						<label class="control-label">名称</label>

					</div>
					<div class="col-lg-8">
						<input type="text" class="form-control" name="cb"
							placeholder="请输入名称">
					</div>
				</div>

				<div class="col-lg-8">
					<button class="btn  btn-outline btn-primary" type="submit">搜索</button>
				</div>
			</div>
		</form>
		<div class="row" style="margin-top: 20px">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
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
									<th align="center">编辑</th>
									<th align="center">查看</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="list" var="d" status="b">

									<tr id="tr">
										<!--  <td><s:checkbox name="ids" width="30dp" value="false" fieldValue="%{#d.cid}"></s:checkbox></td>-->
										<td align="center"><s:property value="#b.index+1" />
										</td>
										<td align="center"><s:property value="#d.cno"></s:property>
										</td>
										<td align="center"><s:property value="#d.cname"></s:property>
										</td>
										<td align="center"><s:property value="#d.ca"></s:property>
										</td>
										<td align="center"><s:property value="#d.cb"></s:property>
										</td>
										<td align="center"><s:property value="#d.ccount"></s:property>
										</td>
										<td align="center"><s:property value="#d.cpaid"></s:property>
										</td>
										<td align="center"><s:property value="#d.cunpaid"></s:property>
										</td>

										<td align="center"><a
											href="${pageContext.request.contextPath }/contractinfo_edit2.action?cid=<s:property value="#d.cid"></s:property>"><i
												class="fa fa-edit fa-fw"></i> </a> &nbsp;&nbsp;&nbsp; <a
											href="javascript:void(0);"
											onclick="myFunction(<s:property value="#d.cid"></s:property>)"><i
												class="fa fa-times fa-fw"></i> </a>
										</td>
										<td align="center"><a
											href="${pageContext.request.contextPath }/contractinfo_find.action?cid=<s:property value="#d.cid"></s:property>">查看详情<i
												class="fa fa-arrow-right fa-fw"></i> </a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
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
		$(document).ready(function() {
			$.ajax({
				url : "contractinfo_counttotal.action", //后台处理程序  
				type : "get", //数据发送方式  
				async : false,
				dataType : "text", //接受数据格式             
				error : function() {
					document.getElementById("demo").innerHTML ="0";
				},

				success : function(data) {
					document.getElementById("demo").innerHTML = data;

				}
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$.ajax({
				url : "contractinfo_paycounttotal.action", //后台处理程序  
				type : "post", //数据发送方式  
				async : false,
				dataType : "text", //接受数据格式             
				error : function() {
					document.getElementById("pay").innerHTML ="0";
				},

				success : function(data) {
					document.getElementById("pay").innerHTML = data;

				}
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$.ajax({
				url : "contractinfo_paidcounttotal.action", //后台处理程序  
				type : "get", //数据发送方式  
				async : false,
				dataType : "text", //接受数据格式             
				error : function() {
					document.getElementById("paid").innerHTML ="0"; 	
				},

				success : function(data) {
					document.getElementById("paid").innerHTML = data;

				}
			});
		});
	</script>

	<script>
			function myFunction(id) {
				var x;
				var r = confirm("确定删除吗");
				if (r == true) {
					window.location.href="${pageContext.request.contextPath }/contractinfo_delete2.action?cid="+id;
				} else {
					
				}
			}
		</script>



</body>

</html>
