<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li>
                    <a href="reader_booksort" >
                        全部图书
                    </a>
                </li>
                <li>
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
                <li >
                    <a href="reader_book_hot" >
                        热门top10
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
    <div style="position: relative;top: 10%">
        <c:if test="${!empty succ}">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                    ${succ}
            </div>
        </c:if>
        <c:if test="${!empty error}">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                    ${error}
            </div>
        </c:if>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                添加留言
            </h3>
        </div>
        <div class="panel-body">
                <form action="leave_msg_do?id=${readercard.id}" method="post" id="addmsg" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="total">标题</label>
                        <input type="text" class="form-control" name="total" id="total" placeholder="请输入标题">
                    </div>
                    <div class="form-group">
                        <label for="content">内容</label>
                        <input type="text" class="form-control" name="content" id="content"  placeholder="输入内容尽量不要超过50字">
                    </div>
                    <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                    <script>
                        function mySubmit(flag){
                            return flag;
                        }
                        $("#addbook").submit(function () {
                            if($("#total").val()==''||$("#content").val()==''){
                                alert("请填入完整信息！");
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
