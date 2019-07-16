<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${basePath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/static/css/animate.css" rel="stylesheet">
    <link href="${basePath}/static/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/static/css/demo.css" type="text/css"/>
    <link rel="stylesheet" href="${basePath}/static/css/system/breadcrumb/breadcrumb.css" type="text/css"/>
    <link href="${basePath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <style>
        .content-wrap{
            padding:0;
            margin-left:15px;
            margin-right:15px;
            border:1px solid #edf1f2;
            border-top-left-radius:5px;
            border-top-right-radius:5px;
            border-top:none;
            width:calc(100%-26px);
            width:-webkit-calc(100% - 26px);
            width:-moz-calc(100% - 26px);
            overflow: hidden;
        }


</style>

</head>
<body>
<div class="wrapper-content">
    <div class="row">
        <div class="content-wrap">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>资源管理</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                        <div id="main" style="width: 600px;height:400px;"></div>
                    </div>
                </div>

        </div>
    </div>

</div>


<script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
 <script src="${basePath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/plugins/echarts/echarts.min.js"></script>
<script type='text/javascript'>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        tooltip: {},
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                roseType: 'angle',
                data:[
                    {value:235, name:'视频广告'},
                    {value:274, name:'联盟广告'},
                    {value:310, name:'邮件营销'},
                    {value:335, name:'直接访问'},
                    {value:400, name:'搜索引擎'}
                ],
                itemStyle: {
                    normal: {
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

</script>

<%@include file="../../common/sweet.jspf"%>


</body>
</html>



