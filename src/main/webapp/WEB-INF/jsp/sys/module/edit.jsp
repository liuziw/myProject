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
    <link rel="stylesheet" href="${basePath}/static/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
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
        .edit-user{
            margin-top: -1px;
        }
        #edit-user{
            border: none!important;
            margin:0;
            margin-top: 1px;
            border-left:1px solid #e7eaec!important;
            margin-left: -16px;
            -webkit-box-shadow:none;
            box-shadow: none;
        }
        #show-per{
            border-right:1px solid #e7eaec;
        }
        .mg-t-4{
            margin-top: 4px;
        }
        .mg-t-20{
            margin-top: 20px;
        }
        #border-none{
            border:none!important;
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
                    </div>
                </div>
                <div class="ibox-content col-sm-4 pull-left" id='show-per'>
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
                <div class="col-sm-8 edit-user pull-left" >
                    <div class="ibox float-e-margins" id='edit-user'>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <form role="form" id = "dataForm" method="post" action="del">
                                        <div class="form-group ">
                                            <div class="row">
                                                <label class="text-center col-sm-2 control-label mg-t-4">父级</label>
                                                <div class="col-sm-5">
                                                    <select class="form-control m-b" name="module.pId">
                                                        <option value="0" selected>根目录</option>
                                                        <c:forEach items="${list}" var="item">
                                                            <option value="${item.id}" level="${item.level}">${fn:substring("　　　　",0,item.level-1)}▶${item.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label class='mg-t-4 col-sm-2 text-center' >名称</label>
                                                <div class='col-sm-5'>
                                                    <input type="hidden" name="module.id" />
                                                    <input class='form-control m-b' name="module.name" type="text" placeholder="" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group">
                                                    <label class="col-sm-2 text-center control-label">类型</label>
                                                    <div class="radio i-checks">
                                                        <label>
                                                            <input type="radio" checked=""  value="menu" name="module.type"> <i></i> 菜单
                                                        </label>
                                                        <label>
                                                            <input type="radio"  value="button" name="module.type"> <i></i> 按钮
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label class='mg-t-4 col-sm-2 text-center' >URL</label>
                                                <div class='col-sm-5'>
                                                    <input class='form-control m-b' name="module.url" type="text" placeholder="" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label class='mg-t-4 col-sm-2 text-center' >权限标识</label>
                                                <div class='col-sm-5'>
                                                    <input class='form-control m-b' name="module.permission" type="text" placeholder="" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label class='mg-t-4 col-sm-2 text-center' >排序</label>
                                                <div class='col-sm-5'>
                                                    <input class='form-control m-b' name="module.sort" type="text" placeholder="" class="form-control"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <label class="col-sm-2 text-center control-label">状态</label>
                                                <div class="radio i-checks">
                                                    <label>
                                                        <input type="radio" checked="" value="1" name="module.available"> <i></i> 启用
                                                    </label>
                                                    <label>
                                                        <input type="radio"  value="0" name="module.available"> <i></i> 禁用
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="container-btn col-sm-7">
                                        <p class="col-sm-6 col-sm-offset-4">
                                            <button class="btm-top btn btn-success " id='addsub' type="submit">添加</button>
                                            <button class="btm-top btn btn-info  col-md-offset-1" id='updatesub' type="submit">更新</button>
                                            <button class="addname btm-top btn btn-danger col-md-offset-1" id='delsub' type="submit">删除</button>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
 <script src="${basePath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/ztree/jquery.ztree.excheck.js"></script>
<script src="${basePath}/static/js/plugins/iCheck/icheck.min.js"></script>
<script type='text/javascript'>
    $(function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
        var zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            view: {
                selectedMulti: false,
                showIcon:false
            },
            data: {
                simpleData: {
                    enable: true
                },
                key:{
                    url:'sss'
                }
            },
            callback: {
                //beforeCheck: beforeCheck,
                onClick:onClick
            }
        };

        function onClick(e, treeId, treeNode) {
            $('input[name="module.id"]').val(treeNode.id);
            $('input[name="module.name"]').val(treeNode.name);
            if(treeNode.pId!=null){
                $("select[name='module.pId']").val(treeNode.pId);
            }else{
                $("select[name='module.pId']").val(0);
            }

            //$("input[name='module.type']").parent().removeClass('checked');
            $("input[name='module.type'][value='"+treeNode.type+"']").parent().addClass('checked').trigger('click');

            $('input[name="module.url"]').val(treeNode.url);
            $('input[name="module.permission"]').val(treeNode.permission);
            $('input[name="module.sort"]').val(treeNode.sort);


           // $("input[name='module.available']").parent().removeClass('checked');
            let available = 1;
            if(!treeNode.available){
                available = 0;
            }
            $("input[name='module.available'][value='"+available+"']").parent().addClass('checked').trigger('click');

        }

        function init(zNodes){
            zTreeObj=$.fn.zTree.init($("#treeDemo"), setting, zNodes);
        }

        $.ajax({
            url:'show',
            type:'get',
            dataType:'json',
            success:function(result){
                let dataArr = [];
                let obj = {open:true};
                $.each(result,function(index,item){
                    if(item.pId==0){
                        dataArr.push(Object.assign({},item,obj));
                    }else{
                        dataArr.push(item);
                    }

                });
                 init(dataArr);
            },
            error:function(err){
                console.log(err)
            }
        })
        if ('${message}' != "" && '${message}' != 'null') {
            sweetalert('${message}','success');
        }

    })



    $('#delsub').click(function(){
        if( $('input[name="module.id"]').val()==""){
            sweetalert("请先选择要删除的信息");
        }else{
            sweetconfirm("您确定要删除这条信息吗","删除后将无法恢复，请谨慎操作！",function () {
                $("#dataForm")[0].action = "delete";
                $("#dataForm")[0].submit();
            });
        }
    })

    $('#updatesub').click(function(){
        $("#dataForm").attr("action","update");
        $("#dataForm")[0].submit();
    })

    $('#addsub').click(function(){
        $("#dataForm").attr("action","save");
        $("#dataForm")[0].submit();
    })

</script>

<%@include file="../../common/sweet.jspf"%>


</body>
</html>



