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
<!-- 百度地图 -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}
.baidu-maps label {
  max-width: none;
}
</style>

<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=5tqDkxHV9fOsoypxMSiSLtNVZ6sfBdY1"></script>
<!-- 百度地图 -->
<title>智能鞋管理系统</title>

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
				<h3 class="page-header">用户轨迹</h3>

			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

		<form action="pay_findmodel" method="post">
			<div class="row">
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


		<div class="row" style="height: 500px">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-heading">&nbsp;</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div id="allmap" class  ="baidu-maps"></div>
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
			var map = new BMap.Map('allmap');
			map.enableScrollWheelZoom();
			
			/**采集到的GPS点**/
			var PointArr = [{"x":119.2240823605,"y":34.6087242838},
							{"x":119.2279018261,"y":34.6091570002},
							
							{"x":119.2287767991,"y":34.6125214889}];
			var p = Math.ceil(PointArr.length / 2);
			map.centerAndZoom(new BMap.Point(PointArr[p].x, PointArr[p].y), 13);
			var driving;
			for(var i in PointArr){
				if(i == 0 ){
					addMarker(new BMap.Point(PointArr[i].x, PointArr[i].y),"起点");
					continue;
				}
				addMarker(new BMap.Point(PointArr[i].x, PointArr[i].y),"")
				driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: false}, 
		        onMarkersSet:function(routes) {
		            map.removeOverlay(routes[0].marker); //删除API自带起点
		            map.removeOverlay(routes[1].marker); //删除API自带终点
		        }});
		        driving.search(new BMap.Point(PointArr[i-1].x, PointArr[i-1].y), 
						new BMap.Point(PointArr[i].x, PointArr[i].y));
		        if(i == PointArr.length -1){
					addMarker(new BMap.Point(PointArr[i].x, PointArr[i].y),"终点");
		        }
			}
			/**
			 * 标记
			 * @param {Object} point
			 */
			function addMarker(point,name){
				var marker = new BMap.Marker(point);
				var label = new BMap.Label(name, {
					offset : new BMap.Size(20, -10)
				});
				marker.setLabel(label);
				map.addOverlay(marker);
			}
		</script>

</body>

</html>
