<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${readercard.stuName}的主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand " href="reader_main"><p class="text-primary">我的图书馆</p></a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="reader_querybook" >
                        图书查询
                    </a>
                </li>
                <li >
                    <a href="reader_booksort" >
                        全部图书
                    </a>
                </li>
                <li class="active">
                    <a href="reader_info" >
                        个人信息
                    </a>
                </li>
                <li >
                    <a href="mylend" >
                        我的借还
                    </a>
                </li>
                <li >
                    <a href="reader_repasswd" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="reader_info"><span class="glyphicon glyphicon-user"></span>&nbsp;${readercard.stuName}，已登录</a></li>
                <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-xs-5 col-md-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                信息修改
            </h3>
        </div>
        <div class="panel-body">
            <form action="reader_edit_do_r" method="post" id="edit" >

                <div class="input-group">
                    <span  class="input-group-addon">学号</span>
                    <input type="text" readonly="readonly" class="form-control" name="stuNumber" id="stuNumber" value="${readercard.stuNumber}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${readercard.stuName}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">性别</span>&nbsp;&nbsp;
                    <input type="radio" value=1 name="sex" checked="checked">男
                    <input type="radio" value=0 name="sex" >女
                </div>
                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone"  value="${readercard.stuPhone}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">所在系</span>
                    <input type="text" readonly = "readonly" class="form-control" name="disciplice" id="disciplice"  value="${discipline.disciplineName}" >
                </div>
                <br/>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#edit").submit(function () {
                        if($("#name").val()==''||$("#phone").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>
</div>


</body>
</html>
