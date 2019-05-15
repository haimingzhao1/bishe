<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑读者信息《 ${readerInfo.stuName}》</title>
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
<nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="admin_main">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allbooks">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="book_add">增加图书</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        读者管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allreaders">全部读者</a></li>
                        <li class="divider"></li>
                        <li><a href="reader_add">增加读者</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        借还管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="lendlist">借还日志</a></li>
                    </ul>
                </li>
                <li >
                    <a href="admin_repasswd" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.adminName}，已登录</a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑读者信息《 ${readerInfo.stuName}》</h3>
        </div>
        <div class="panel-body">
            <form action="reader_edit_do/${readerInfo.id}" method="post" id="readeredit" >
                <input type="hidden" name="_method" value="put">
                <div class="input-group">
                    <span  class="input-group-addon">学生学号</span>
                    <input readonly="readonly" type="text" class="form-control" name="stuNum" id="stuNum" value="${readerInfo.stuNumber}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${readerInfo.stuName}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">性别</span>
                    <select name="sex" id="sex">
                        <option value="${readerInfo.gender}">${readerInfo.gender==1?'男':'女'}</option>
                        <option value = 0>女</option>
                        <option value = 1>男</option>
                    </select>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone"  value="${readerInfo.stuPhone}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">所属系</span>
                    <select name="discipline" id="discipline">
                        <option value="${readerInfo.discipline.id}">${readerInfo.discipline.disciplineName}</option>
                        <c:forEach items="${disciplines}" var="discipline">
                            <option value = "${discipline.id}">${discipline.disciplineName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">是否VIP</span>
                    <select name="vip" id="vip">
                        <option value="${readerInfo.isVip}">${readerInfo.isVip==1?'是':'否'}</option>
                        <option value = 0>否</option>
                        <option value = 1>是</option>
                    </select>
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#readeredit").submit(function () {
                        if($("#name").val()==''||$("#phone").val()==''){
                            alert("请填入完整读者信息！");
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
