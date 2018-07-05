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
<script
		src="${ pageContext.request.contextPath}/js/d3.layout.cloud.js"></script><script
		src="${ pageContext.request.contextPath}/js/d3.mini.js"></script>
</head>

<body>
	<div id="page-wrapper">
		<div id="row">
			<canvas ></canvas>
		</div>
	</div>
	<script src="node.js" ></script>


 <script type="text/javascript">
    var fill = d3.scale.category20();
    //输出20种类别的颜色 ---颜色比例尺

    //word cloud layout  词云布局，d3布局中为词云设立的单独的一种布局方式
    //d3.layout.cloud() 构造一个词云的布局实例
    //on(type,listener) 注册特定的listener来接收布局中特定类型的event。
    //目前只有 word和end这两种event是被支持的。
    //word这种event在该布局完成对每一个word的布局时被调度。
    //end这种活动在改布局完成对所有的words的布局时被调度。
    //注册的listener通过两个参数被调度：
    //被成功布局的单词数组
    //以[{x0,y0},{x1,y1}]形式为界限，代表words范围    a bounds object of the form [{x0, y0}, {x1, y1}] representing the extent of the placed objects.
    //
   
    //start 布局算法   初始化单词数组上的各种参数，并且从最大的单词开始布局单词，
    //从矩形区域的中间开始，每一个单词在布局时都要检测是否与先前已经布局好的单词位置冲突。
    //一旦检测到冲突，该算法会沿着螺旋线重新布局该单词。
    //如果一个单词不能在沿着螺旋线的任何地方被布局，该单词最终将不会显示在词云图上，该问题可能在后续版本中被解决。

    //stop() 停止布局算法

    // timeInterval([time])   布局时通过setInterval来避免浏览器的event loop被锁住。
   
    //words([words array].map(function(d)(return{text:d;size:某一个数值}))
    //为words数组中的每一个word分配一个字体大小
   
    d3.layout.cloud().size([300, 300]) //size([x,y])  词云显示的大小
    //map 返回新的object数组
        .words([".NET", "Silverlight", "jQuery", "CSS3", "HTML5", "JavaScript", "SQL","C#"].map(function(d) {
            return {"text": d, "size": 10 + Math.random() * 50};
        }))
        //~~的作用是单纯的去掉小数部分，不论正负都不会改变整数部分
        //这里的作用是产生0 1
        .rotate(function() { return ~~(Math.random() * 2) * 90; })
        .font("Impact")
        .fontSize(function(d) { return d.size; })
        .on("end", draw)//结束时运行draw函数
        .start();


    //append()使用函数在指定元素的结尾添加内容
    //transform:translate(x,y)  定义2d旋转，即平移，向右平移x,向下平移y
    function draw(words) {
        d3.select("body").append("svg")
            .attr("width", 600)
            .attr("height", 400)
            .attr("style","border:1px solid red")
            .append("g")
            .attr("transform", "translate(150,150)")
            .selectAll("text")
            .data(words)
            .enter().append("text")
            .style("border","1px solid blue")
            .style("font-size", function(d) { return d.size + "px"; })
            .style("font-family", "Impact")
            .style("fill", function(d, i) { return fill(i); })//fill 在前面15行定义为颜色集
            .attr("text-anchor", "middle")
            .attr("transform", function(d) {
                return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
            })
            .text(function(d) { return d.text; });


    }
    
</script>
</body>

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

</html>
