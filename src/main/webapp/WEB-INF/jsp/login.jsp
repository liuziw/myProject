<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${basePath}/static/css/public/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/static/css/public/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${basePath}/static/css/public/animate.css" rel="stylesheet">
    <link href="${basePath}/static/css/system/style.css" rel="stylesheet">
    <link href="${basePath}/static/css/system/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <!--<meta http-equiv="refresh" content="0;ie.html" />-->
    <![endif]-->
    <!--     <script>
            if (window.top !== window.self) {
                window.top.location = window.location;
            }
        </script> -->

</head>

<body class="signin">
<div class="cloud1" style='left:500px'></div>
<div class="cloud2"></div>
<div class="loginbody"></div>
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <span class="system_title">管理平台</span>
            <form method="post" action="">
                <input type="text" name="username" value="" class="form-control uname" placeholder="用户名" />
                <input type="password" name="password" value="" class="form-control pword m-b" placeholder="密码" />
                <!-- <a href="">忘记密码了？</a> -->
                <button class="btn  btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy;
        </div>
    </div>
</div>
<script type="text/javascript" src='${basePath}/static/js/public/jquery.min.js'></script>
<script type="text/javascript" src='${basePath}/static/js/system/login.js'></script>
</body>

</html>

































