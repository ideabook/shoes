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
		<div id="row">
			<br> file:
			<s:property value="fileFileName" />


			<s:iterator id="imgUrl" value="dataUrl">
				<br />
				<img src="${imgUrl}" />
			</s:iterator>
		</div>
	</div>
</body>
<script type="text/javascript">
	function addMore() {
		var td = document.getElementById("more");

		var br = document.createElement("br");
		var input = document.createElement("input");
		var button = document.createElement("input");

		input.type = "file";
		input.name = "file";

		button.type = "button";
		button.value = "Remove";

		button.onclick = function() {
			td.removeChild(br);
			td.removeChild(input);
			td.removeChild(button);
		}
		td.appendChild(br);
		td.appendChild(input);
		td.appendChild(button);
	}
</script>


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
<script
	src="${ pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<script src="${ pageContext.request.contextPath}/js/chart.js"></script>
<script src="${ pageContext.request.contextPath}/js/utils.js"></script>
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
	var randomScalingFactor = function() {
		return Math.round(Math.random() * 100);
	};
</script>

</body>

</html>
