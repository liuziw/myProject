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
    <!-- iCheck -->
    <link href="${basePath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <script src="${basePath}/static/js/plugins/iCheck/icheck.min.js"></script>
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
        function exp() {
            window.location.href = "${basePath}/excel/excel";
        }
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            //全选获取数值
            var checkAll = $('#SelectAll');
            var checkboxs = $('input[name=opId]');
            checkAll.on('ifChecked ifUnchecked',function(event){
                if(event.type == 'ifChecked'){
                    checkboxs.iCheck('check');
                }else{
                    checkboxs.iCheck('uncheck');
                }
            });

            checkboxs.on('ifChanged',function(event){
                if(checkboxs.filter(':checked').length == checkboxs.length){
                    checkAll.prop('checked',true);
                }else{
                    checkAll.prop('checked',false);
                }
                checkAll.iCheck('update');
            })


            if ('${message}' != "" && '${message}' != 'null') {
                sweetalert('${message}','success');
            }

        });

    </script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins" id='tables'>
        <div class="ibox-title">
            <h5>用户管理</h5>
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
                <div class="search-content">
                    <div class="row" id="m-btm">

                        <div class="form-inline col-md-4 col-sm-4 col-lg-4 ">
                            <div class="form-group search-item">
                                <label class='text-center item-label'>用户名</label>
                                <input class="form-control item-select" name="user.username"  value="${user.username}" />
                            </div>
                        </div>
                        <div class="form-inline col-md-4 col-sm-4 col-lg-4 ">
                            <div class="form-group search-item">
                                <label class='text-center item-label'>状态</label>
                                <select class="form-control item-select" name="user.status">
                                    <option value="">请选择</option>
                                    <c:forEach items="${stateEnums}" var="items" varStatus="status" >
                                        <option value="${items.value }" <c:if test="${items.value==user.status}">selected</c:if>>${items.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear-fix">
                    <div class="col-md-2 col-sm-2 col-lg-2 col-md-offset-4 col-sm-offset-4 col-lg-offset-4">
                        <button type="submit" class="btn btn-info m-left">查 询</button>
                        <button type="button" class="btn btn-success m-left"  onclick="add()">新 增</button>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table table-bordered text-center">
                        <thead>
                        <tr>
                            <th><input type="checkbox" class="i-checks" id="SelectAll"></th>
                            <th>用户ID</th>
                            <th>用户名</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${dataList.list}" var="item">
                            <tr>
                                <td>
                                    <input type="checkbox" class="i-checks" name="opId" value="${item.id}" id="subcheck">
                                </td>
                                <td>${item.id}</td>
                                <td>${item.username}</td>
                                <td><c:forEach items="${stateEnums}" var="items" varStatus="status" >
                                    <c:if test="${items.value==item.status}">${items.name}</c:if>
                                </c:forEach></td>
                                <td><shiro:hasPermission name="sys:user:update">
                                    <a href="edit?id=${item.id}">修改</a><i class="fa fa-pencil text-navy"></i>
                                </shiro:hasPermission>
                                    <shiro:hasPermission name="sys:user:delete">
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
