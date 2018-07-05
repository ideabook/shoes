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
								<i class="fa fa-credit-card fa-5x"></i>
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
								<i class="fa  fa-bell-o fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">13</div>
								<div>代办事项</div>
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
				快速查找： <a
					href="${pageContext.request.contextPath }/contractinfo_findbyyear.action?year=2015">
					<button class="btn btn-outline btn-primary" data-toggle="modal"
						data-target="#myModal">2015年合同</button> </a> <a
					href="${pageContext.request.contextPath }/contractinfo_findbyyear.action?year=2016">
					<button class="btn btn-outline btn-primary" data-toggle="modal"
						data-target="#myModal">2016年合同</button> </a> 
						<a href="${pageContext.request.contextPath }/contractinfo_findbyyear.action?year=2017">
					<button class="btn btn-outline btn-primary" data-toggle="modal"
						data-target="#myModal">2017年合同</button> </a>
						<a href="${pageContext.request.contextPath }/contractinfo_findbyyear.action?year=2018">
					<button class="btn btn-outline btn-primary" data-toggle="modal"
						data-target="#myModal">2018年合同</button> </a>
						 <span class="pull-right">
					<!-- /.row --> <a
					href="${pageContext.request.contextPath }/contractinfo_toadd.action">
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#myModal">添加合同</button> </a> </span>
			</div>
		<!--  	<div class="row" >
			<div class="col-lg-8">
										<img alt=""
											src="getQRcode.action?content=http://210.28.44.42:8080/Contract/contractinfo_findAll.action">
									</div>
			</div>
			-->
			<div class="col-lg-12"></div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row" style="margin-top: 20px">
			<div class="row">
				<div id="content" class="col-lg-12">
					<s:iterator value="list" var="d" status="b">
						<div class="col-lg-4">
							<div id="panel" class="panel panel-info">
								<div class="panel-heading">
									<s:property value="#b.index+1" />
									:
									<s:property value="#d.cno" />
									:
									<s:property value="#d.cname" />
								</div>
								<div class="panel-body">

									<label>公司名称：<s:property value="#d.companyinfo.comname" />
									</label><br> <label>合同总额：<s:property value="#d.ccount" />
									</label> <label>&nbsp;&nbsp;&nbsp;&nbsp;已付款：<s:property
											value="#d.cpaid" /> </label> <br> <label>签订时间：<s:date
											name="#d.ctime" format="yyyy年MM月dd日" /> </label><br> <label>截止时间：<s:date
											name="#d.cfinishtime" format="yyyy年MM月dd日" /> </label> <br> <label>经费来源：<s:property
											value="#d.fundtype.ftype" />
									</label><br> <label>合同来源：<s:property
											value="#d.confrom.cffrom" />
									</label> <br> <label>合同类型：<s:property
											value="#d.contype.cttype" />
									</label>

								</div>
								<div style="height: 2">
									<div id="divtest"></div>
									<s:if test="#d.constatue==1">
										<div
											style="float:left; height: 2; width:20%; text-align:center; background:#FF8C69;">

										</div>

									</s:if>
									<s:elseif test="#d.constatue==2">
										<div
											style="float:left; height: 2; width:20%; text-align:center; background:#FF8C69;">

										</div>
										<div
											style=" float:left; height: 2; width:20%; background:#87CEEB;">

										</div>

									</s:elseif>
									<s:elseif test="#d.constatue==3">
										<div
											style="float:left; height: 2; width:20%; text-align:center; background:#FF8C69;">

										</div>
										<div
											style=" float:left; height: 2; width:20%; background:#87CEEB;">

										</div>
										<div
											style=" float:left; height: 2; width:20%; background:#00688B;">

										</div>

									</s:elseif>
								</div>
								<div class="panel-footer">

									<a
										href="${pageContext.request.contextPath }/contractinfo_edit.action?cid=<s:property value="#d.cid"></s:property>"><i
										class="fa fa-edit fa-fw"></i>编辑 </a>&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="javascript:void(0);"
										onclick="myFunction(<s:property value="#d.cid"></s:property>)"><i
										class="fa fa-times fa-fw"></i>删除</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="${pageContext.request.contextPath }/contractinfo_find.action?cid=<s:property value="#d.cid"></s:property>"><i
										class="fa fa-arrow-right  fa-fw"></i>查看 </a>

								</div>
							</div>
						</div>



					</s:iterator>
				</div>


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
		<script
			src="${ pageContext.request.contextPath}/dist/js/sb-admin-2.js"></script>
		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>
		<script>
			$(document).ready(function() {
				//div1=document.getElementById("divtest");
				//div1.style.backgroundColor="#458B00";
				//div1.style.height="5px";
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
						document.getElementById("demo").innerHTML = "0";
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
						document.getElementById("pay").innerHTML = "0";
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
						document.getElementById("paid").innerHTML = "0";
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
					window.location.href="${pageContext.request.contextPath }/contractinfo_delete.action?cid="+id;
				} else {
					
				}
			}
		</script>
</body>

</html>
