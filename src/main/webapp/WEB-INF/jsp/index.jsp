<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理系统</title>

    <!-- Sweet Alert -->
    <link href="${basePath}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/static/css/public/bootstrap.min.css">
    <link href="${basePath}/static/css/public/font-awesome.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="${basePath}/static/css/public/sidebar-menu.css">
    <style type="text/css">
        html{
            height:100%;
        }
        body{
            height:100%;
        }
        .main-sidebar{
            position: absolute;
            top:51px;
            left: 0;
            height:  calc(100% - 51px);
            width: 230px;
            z-index: 810;
            background-color: #222d32;
            overflow-y:auto;
        }
        .main-sidebar::-webkit-scrollbar {
            border:0;
            display:none;
        }
        .sys_content{
            margin-left: 230px;
            width: calc(100% - 230px);
            overflow: hidden;
            height:100%;
            padding-top:51px;
            box-sizing: border-box;
        }
        iframe{
            border:none;
        }
        .gohome {
            position: fixed;
            top: 63px;
            right: 30px;
            z-index: 100;
        }

        .gohome a {
            height: 38px;
            width: 38px;
            display: block;
            background: #2f4050;
            padding: 9px 8px;
            text-align: center;
            color: #fff;
            border-radius: 50%;
            opacity: .5;
        }

        .gohome a:hover {
            opacity: 1;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">用户名</a></li>
                <li><a href="javascript:void(0)" class='loginout'>注销</a></li>
            </ul>
            <form class="navbar-form navbar-right">
            </form>
        </div>
    </div>
</nav>
<aside class="main-sidebar">
    <section  class="sidebar">
      
    </section>
</aside>
<div class="sys_content">
    <iframe align='top'width="100%"  src="${basePath}/user/list" height='100%' name='dataContent' frameborder="1" seamless scrolling="yes"></iframe>
</div>


<script src="${basePath}/static/js/jquery.min.js"></script>
<script type="text/javascript" src='${basePath}/static/js/public/bootstrap.min.js'></script>
<script src="${basePath}/static/js/system/sidebar-menu.js"></script>
<script src="${basePath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- 自定义js -->
<script src="${basePath}/static/js/content.js"></script>

<!-- Sweet alert -->
<script src="${basePath}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script>
    $(function(){
 	$.ajax({
 		url:'leftJson',
 		type:'post',
 		dataType:'json',
 		crossDomain: true,
     success:function(result){
 	    var $sidebar_menu = $('<ul class="sidebar-menu"></ul>');
 			var firstMenu = '' ;
 			$.each(result,function(index,item){
 				if(item.child.length&&item.child.length>0){
 					var secondMenu = '';
 					$.each(item.child,function(index1,item1){
 						if(item1.child.length&&item1.child.length>0){
 								var thirdMenu = '';
 								$.each(item1.child,function(index2,item2){
 									thirdMenu+='<li><a href="${basePath}'+item2.url+'" target="dataContent"><i class="fa fa-circle-o"></i>'+item2.name+'</a></li>';
 								})
 								secondMenu+='<li><a href="${basePath}'+item1.url+'" target="dataContent"><i class="fa fa-circle-o"></i>'+item1.name+'</a><ul class="treeview-menu">'+thirdMenu+'</ul></li>';
 						}else{
 							secondMenu+='<li><a href="${basePath}'+item1.url+'" target="dataContent"><i class="fa fa-circle-o"></i>'+item1.name+'</a></li>';
 						}
 					})
 						firstMenu+='<li class="treeview"><a href="${basePath}'+item.url+'" target="dataContent"><i class="fa fa-files-o"></i><span>'+item.name+'</span><span class="label label-primary pull-right"></span></a><ul class="treeview-menu">'+secondMenu+'</ul></li>';
 				}else{
 					firstMenu+='<li class="treeview"><a href="${basePath}'+item.url+'" target="dataContent"><i class="fa fa-files-o"></i><span>'+item.name+'</span><span class="label label-primary pull-right"></span></a></li>';
 				}
 			})
 			$sidebar_menu.append(firstMenu);
 			$('.sidebar').append($sidebar_menu);
        $.sidebarMenu('.sidebar-menu');
            },
            error:function(err){
            	console.log(err);
            }
         })

    })
    $('.loginout').click(function () {
        swal({
                title: "您确定要退出么？",
                text: "退出后将重新登录，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "是的，我要退出！",
                cancelButtonText: "让我再考虑一下…",
                closeOnConfirm: false,
                closeOnCancel: false
            },
            function (isConfirm) {
                if (isConfirm) {
                    location.href='logout';
                } else {
                    //swal("已取消", "您取消了退出操作！", "success");
                    swal({
                        title: '已取消',
                        text: '您取消了退出操作！',
                        timer: 1000,
                        //type:"success"
                    })
                }
            });
    });
</script>

</body>
</html>
