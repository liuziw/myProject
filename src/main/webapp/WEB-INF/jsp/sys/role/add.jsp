<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="">
      <meta name="description" content="">
     -->
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${basePath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link href="css/font-awesome.css" rel="stylesheet"> -->
    <!-- <link href="css/plugins/iCheck/custom.css" rel="stylesheet"> -->
    <link href="${basePath}/static/css/animate.css" rel="stylesheet">
    <link href="${basePath}/static/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/static/css/demo.css" type="text/css"/>
    <link rel="stylesheet" href="${basePath}/static/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
    <link rel="stylesheet" href="${basePath}/static/css/system/breadcrumb/breadcrumb.css" type="text/css"/>
    <link rel="stylesheet" href="${basePath}/static/css/system/user/user.css"/>
    <link href="${basePath}/static/css/common/table.css" rel="stylesheet">
    <style>
        .container-btn{
            margin-top:-22px;
            height:50px;
            background: #f6f8f8;
            line-height:50px;
            border:1px solid #e7eaec;
            border-top:none;
            border-bottom-left-radius:5px;
            border-bottom-right-radius:5px;
        }
        .btm-top{
            margin-top:10px;
        }
        #search-item{
            width:100%;
        }
        .item-label{
            width:20%;
        }
       .item-select{
            width:78%;
            padding-bottom:2px;
        }
        #m-btm{
            margin-bottom:30px;
            margin-top:30px;
        }
        .search-content{
            margin:10px auto 20px;
        }
        .mg-t-26{
            margin-top: 26px;
        }
        .clear-fix{
            overflow: hidden;
        }
        .m-left{
            margin-left:24px;
        }

    </style>
</head>
<body>
<div class="wrapper-content">
    <div class="col-sm-12 breadcrumb-title">
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
        </ol>
    </div>
    <div class="row">
        <div class="col-sm-12 " >
            <form id="myForm" action="list" method="post">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户权限管理</h5>
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

                <div class="row m-btm">
                    <div class="form-inline col-md-4 col-sm-4 col-lg-4 ">
                        <div class="form-group search-item">
                            <label class='text-center item-label'>角色名</label>
                            <input name="role.role" class="form-control item-select" placeholder="请输入角色名" />
                        </div>
                    </div>
                </div>
                <div class="row" id="m-btm">
                    <div class="form-inline col-md-4 col-sm-4 col-lg-4 ">
                        <div class="form-group" id='search-item'>
                            <label class='text-center item-label'>描述</label>
                            <textarea name="role.description" class="form-control item-select" rows="3" placeholder="请描述"></textarea>
                        </div>
                    </div>
                </div>

                </div>
                <div class="ibox-content">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
            <div class="container-btn col-sm-12">
                <p>
                    <button class="btm-top btn btn-danger col-sm-1" id='clear_check' >清空</button>
                    <button class="btm-top btn btn-info col-sm-1 col-md-offset-1" id='select_all'>全选</button>
                    <input id="moduleIdList" type="hidden" name="moduleIdList">
                    <button class="btm-top btn btn-success col-sm-1 col-md-offset-1" id='btn'>保存</button>
                </p>
            </div>
            </form>
        </div>
    </div>

</div>


<script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="${basePath}/static/js/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/ztree/jquery.ztree.excheck.js"></script>
<script type='text/javascript'>
    $(function(){
        var zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            view: {
                selectedMulti: false,
                showIcon:false
            },
            check: {
                enable: true,
                chkboxType: { "Y": "ps", "N": "ps" }
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
                beforeCheck: beforeCheck,
                onCheck: onCheck
            }
        };


        var code, log, className = "dark";
        function beforeCheck(treeId, treeNode) {
            className = (className === "dark" ? "":"dark");
            showLog("[ "+getTime()+" beforeCheck ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
            return (treeNode.doCheck !== false);
        }
        function onCheck(e, treeId, treeNode) {
            // showLog("[ "+getTime()+" onCheck ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name );
            console.log(treeNode);
        }
        function showLog(str) {
            // if (!log) log = $("#log");
            // 	log.append("<li class='"+className+"'>"+str+"</li>");
            // if(log.children("li").length > 6) {
            // 	log.get(0).removeChild(log.children("li")[0]);
            // }
        }
        function getTime() {
            var now= new Date(),
                h=now.getHours(),
                m=now.getMinutes(),
                s=now.getSeconds(),
                ms=now.getMilliseconds();
            return (h+":"+m+":"+s+ " " +ms);
        }

        function checkNode(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                type = e.data.type,
                nodes = zTree.getSelectedNodes();
            if (type.indexOf("All")<0 && nodes.length == 0) {
                alert("Please select one node at first...");
            }

            if (type == "checkAllTrue") {
                zTree.checkAllNodes(true);
            } else if (type == "checkAllFalse") {
                zTree.checkAllNodes(false);
            } else {
                var callbackFlag = $("#callbackTrigger").attr("checked");
                for (var i=0, l=nodes.length; i<l; i++) {
                    if (type == "checkTrue") {
                        zTree.checkNode(nodes[i], true, false, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode(nodes[i], false, false, callbackFlag);
                    } else if (type == "toggle") {
                        zTree.checkNode(nodes[i], null, false, callbackFlag);
                    }else if (type == "checkTruePS") {
                        zTree.checkNode(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode(nodes[i], false, true, callbackFlag);
                    } else if (type == "togglePS") {
                        zTree.checkNode(nodes[i], null, true, callbackFlag);
                    }
                }
            }
        }

        function setAutoTrigger(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.setting.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting.check.autoCheckTrigger ? "true" : "false");
        }
        function init(zNodes){
            zTreeObj=$.fn.zTree.init($("#treeDemo"), setting, zNodes);
            $("#checkTrue").bind("click", {type:"checkTrue"}, checkNode);
            $("#checkFalse").bind("click", {type:"checkFalse"}, checkNode);
            $("#toggle").bind("click", {type:"toggle"}, checkNode);
            $("#checkTruePS").bind("click", {type:"checkTruePS"}, checkNode);
            $("#checkFalsePS").bind("click", {type:"checkFalsePS"}, checkNode);
            $("#togglePS").bind("click", {type:"togglePS"}, checkNode);
            $("#checkAllTrue").bind("click", {type:"checkAllTrue"}, checkNode);
            $("#checkAllFalse").bind("click", {type:"checkAllFalse"}, checkNode);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger);
        }

        $.ajax({
            url:'modules',
            type:'post',
            dataType:'json',
            success:function(result){
                let dataArr = [];
                let obj = {open:true};
                $.each(result,function(index,item){
                    if(item.id==1){
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
        $('#btn').click(function(){
            var nodes = zTreeObj.getNodesByFilter(filter);
            var subArr = [];
            debugger;
            $.each(nodes,function(index,item){
                subArr.push(item.id);
            })
            $("#moduleIdList").attr("value",subArr);
            $("#myForm").attr("action","save");
            $("#myForm")[0].submit();
            console.log(subArr);
        })
        $('#clear_check').click(function(){
            zTreeObj.checkAllNodes(false);
            return false;
        })
        $('#select_all').click(function(){
            zTreeObj.checkAllNodes(true);
            return false;
        })
        function filter(node) {
            // console.log(node);
            return (node.checked ==true);
        }
    })
</script>
</body>
</html>

