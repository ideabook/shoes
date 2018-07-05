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
				<h3 class="page-header">合同详情</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<s:form role="form" action="contractinfo_edit" method="post">
							<!-- 第一行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label>编号:</label>

									</div>
									<div class="col-lg-8">
										<s:label value="%{model.cno}"></s:label>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同名称:</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.cname}"></s:label>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同总额:</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.ccount}"></s:label>
										元
									</div>
								</div>




							</div>

							<!-- 第二行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">甲方：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.ca}"></s:label>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">乙方：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label"
											value="%{model.companyinfo.comname}"></s:label>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同类型：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.contype.cttype}"></s:label>
									</div>
								</div>


							</div>
							<!-- 第三行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">签订时间：</label>

									</div>
									<div class="col-lg-8">
										<label class="control-label"><s:date
												name="%{model.ctime}" format="yyyy年MM月dd日" /> </label>

									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">开工时间：</label>

									</div>
									<div class="col-lg-8">
										<label class="control-label"><s:date
												name="%{model.cworktime}" format="yyyy年MM月dd日" /> </label>

									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">截止时间：</label>

									</div>
									<div class="col-lg-8">
										<label class="control-label"><s:date
												name="%{model.cfinishtime}" format="yyyy年MM月dd日" /> </label>

									</div>
								</div>
							</div>
							<!-- 第四行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">合同来源：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.confrom.cffrom}"></s:label>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">资金来源：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.fundtype.ftype}"></s:label>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">经办人：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.coperator}"></s:label>
									</div>
								</div>


							</div>
							<!-- 第五行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">所属科室：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.csuboffice}"></s:label>
									</div>
								</div>

								<div class="col-lg-4">
									<div class="col-lg-4">
										<label class="control-label">经办人：</label>

									</div>
									<div class="col-lg-8">
										<s:label class="control-label" value="%{model.coperator}"></s:label>
									</div>
								</div>


							</div>
							<!-- 第六行 -->
							<div class="row" style="margin-top:30px; margin-bottom:10px">
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
							<!-- 第二行 -->
							<!--  <div class="row" style="margin-top:20px; ">


								<div class="col-lg-4">
									<div class="col-lg-5">
										<label class="control-label">二维码查看：</label>

									</div>
									<div class="col-lg-7">
										<img alt=""
											src="${pageContext.request.contextPath}/getQRcode.action?content=合同编号：<s:property value="%{model.cno}"></s:property>；合同名称：<s:property value="%{model.cno}"/>">
									</div>
								</div>


							</div>
							-->

							<!-- 第二行 -->
							<div class="row" style="margin-top:20px; margin-bottom:10px">



							</div>
							<!-- /.table-responsive -->
						</s:form>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>



		<div class="row" style="margin-top:20px; ">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">实际付款记录</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="row">
							<div class="row" style="margin-left: 10; margin-bottom: 10;">
								<label>付款总额为：<s:property value="paycount"></s:property>元</label>
							</div>
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
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">合同付款进度</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="row">

							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th align="center">编号</th>
										<th align="center">付款项目</th>
										<th align="center">付款比例</th>
										<th align="center">付款金额</th>
										<th align="center">付款日期</th>
										<th align="center">操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="paymodes" var="d" status="b">

										<tr>
											<td align="center"><s:property value="#b.index+1" />
											<td align="center"><s:property value="#d.pmtype"></s:property>
											</td>
											<td align="center"><s:property value="#d.pmpercent"></s:property>
											</td>
											<td align="center"><s:property value="#d.pmcount"></s:property>
											</td>
											<td align="center"><s:date name="#d.pmdate"
													format="yyyy年MM月dd日" />
											</td>

											<td align="center"><a href="javascript:void(0);"
												onclick="myFunction2(<s:property value="#d.pmid"></s:property>)"><i
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

		<!-- 上传附件 -->
		<div class="row" style="margin-top:20px; ">
			<div class="col-lg-12">

				<span class="pull-right"> <!-- /.row --> <a
					href="${pageContext.request.contextPath }/file_toadd.action?cid=<s:property value="%{model.cid}"></s:property>">
						<button class="btn  btn-outline btn-primary">添加附件</button> </a> </span>
			</div>
		</div>

		<div class="row" style="margin-top:20px; ">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">附件记录</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th align="center">编号</th>
										<th align="center">文件名</th>
										<th align="center">文件类型</th>
										<th align="center">上传时间</th>
										<th align="center">下载</th>
										<th align="center">操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="filelist" var="d" status="b">

										<tr>
											<td align="center"><s:property value="#b.index+1" />
											<td align="center"><s:property value="#d.filename"></s:property>
											</td>
											<td align="center"><s:property value="#d.filetype"></s:property>
											</td>
											<td align="center"><s:date name="#d.fileuptime"
													format="yyyy年MM月dd日" /></td>

											<td align="center"><a
												href="${ pageContext.request.contextPath}/<s:property
													value="#d.filepath"></s:property>">
													<i class="fa fa-download fa-fw"></i> </a>
											</td>
											<td align="center"><a href="javascript:void(0);"
												onclick="myFunction3(<s:property value="#d.fid"></s:property>)"><i
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
					window.location.href="${pageContext.request.contextPath }/pay_delete.action?pid="+id;
				} else {
					
				}
			}
		</script>
	<script>
			function myFunction2(id) {
				var x;
				var r = confirm("确定删除吗");
				if (r == true) {
					window.location.href="${pageContext.request.contextPath }/paymode_delete.action?pmid="+id;
				} else {
					
				}
			}
		</script>
	<script>
			function myFunction3(id) {
				var x;
				var r = confirm("确定删除吗");
				if (r == true) {
					window.location.href="${pageContext.request.contextPath }/file_delete.action?pmid="+id;
				} else {
					
				}
			}
		</script>
</body>

</html>
