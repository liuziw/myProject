<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - Bootstrap Table</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="${basePath}/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${basePath}/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${basePath}/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${basePath}/static/css/animate.css" rel="stylesheet">
    <link href="${basePath}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${basePath}/static/css/common/table.css" rel="stylesheet">
    <script src="${basePath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <%@include file="../../common/sweet.jspf"%>
    <script  type="text/javascript">
        function add() {
            window.location.href = "add";
        }
        function del(id) {
            sweetconfirm("您确定要删除这条信息吗","删除后将无法恢复，请谨慎操作！",function () {
                window.location.href = "delete?id="+id;
            })
        }

        $(function () {
            if ('${message}' != "" && '${message}' != 'null') {
                sweetalert('${message}','success');
            }
        })
    </script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins" id='tables'>
        <div class="ibox-title">
            <h5>档案管理</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="table_basic.html#">选项1</a>
                    </li>
                    <li><a href="table_basic.html#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <form id="myForm" action="list" method="post">

                <div class="clear-fix">
                    <div>
                        <button type="button" class="btn btn-success m-left"  onclick="add()">新增角色</button>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table table-bordered text-center">
                        <thead>
                        <tr>
                            <th></th>
                            <th>ID</th>
                            <th>角色</th>
                            <th>描述</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${dataList.list}" var="item">
                            <tr>
                            <td>
                                <input type="checkbox" checked class="i-checks" name="input[]">
                            </td>
                            <td>${item.id}</td>
                            <td>${item.role}</td>
                            <td>${item.description}</td>
                                <c:if test="${'true' eq item.available}">
                                    <td>可用</td>
                                </c:if>
                                <c:if test="${'false' eq item.available}">
                                    <td>禁用</td>
                                </c:if>
                            <td><shiro:hasPermission name="sys:role:update">
                                <a href="edit?id=${item.id}">修改</a><i class="fa fa-pencil text-navy"></i>
                            </shiro:hasPermission>
                                <shiro:hasPermission name="sys:role:delete">
                                    <a onclick="del(${item.id})">删除</a><i class="fa fa-close  text-danger"></i>
                                </shiro:hasPermission>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../../common/pager.jspf"%>
            </form>
        </div>

    </div>
</div>
<!-- End Panel Other -->
</div>


</body>

</html>
