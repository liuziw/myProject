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

    var xAxisData = [];
    var data1 = [];
    var data2 = [];
    for (var i = 0; i < 100; i++) {
        xAxisData.push('类目' + i);
        data1.push((Math.sin(i / 5) * (i / 5 -10) + i / 6) * 5);
        data2.push((Math.cos(i / 5) * (i / 5 -10) + i / 6) * 5);
    }

    option = {
        title: {
            text: '柱状图动画延迟'
        },
        legend: {
            data: ['bar', 'bar2'],
            align: 'left'
        },
        toolbox: {
             y: 'bottom',
            feature: {
                magicType: {
                    type: ['stack', 'tiled']
                },
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                },
                myTool2: {
                    show: true,
                    title: '自定义扩展方法',
                    icon: 'image://http://echarts.baidu.com/images/favicon.png',
                    onclick: function (){
                        alert('myToolHandler2')
                    }
                }
            }
        },
        tooltip: {},
        xAxis: {
            data: xAxisData,
            silent: false,
            splitLine: {
                show: false
            }
        },
        yAxis: {
        },
        series: [{
            name: 'bar',
            type: 'bar',
            data: data1,
            animationDelay: function (idx) {
                return idx * 10;
            }
        }, {
            name: 'bar2',
            type: 'bar',
            data: data2,
            animationDelay: function (idx) {
                return idx * 10 + 100;
            }
        }],
        animationEasing: 'elasticOut',
        animationDelayUpdate: function (idx) {
            return idx * 5;
        }
    };
    myChart.setOption(option);

</script>

<%@include file="../../common/sweet.jspf"%>


</body>
</html>



