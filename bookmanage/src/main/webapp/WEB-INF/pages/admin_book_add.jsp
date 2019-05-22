<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        分类管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allsorts">全部分类</a></li>
                        <li class="divider"></li>
                        <li><a href="sort_add">增加分类</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        专业管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="alldisciplines">全部专业</a></li>
                        <li class="divider"></li>
                        <li><a href="discipline_add">增加专业</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.adminName}，已登录</a></li>
                <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div style="position: relative;top: 10%;width: 80%;margin-left: 10%">
            <form action="book_add_do" method="post" id="addbook" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="bookNum">图书编号</label>
                    <input type="text" class="form-control" name="bookNum" id="bookNum" placeholder="请输入图书编号">
                </div>
                <div class="form-group">
                    <label for="bookname">图书名</label>
                    <input type="text" class="form-control" name="bookname" id="bookname"  placeholder="请输入图书名">
                </div>
                <div class="form-group">
                    <label for="bookauther">作者</label>
                    <input type="text" class="form-control"  name="bookauther" id="bookauther"  placeholder="请输入作者">
                </div>
                <div class="form-group">
                    <label for="bookpress">出版社</label>
                    <input type="text" class="form-control" name="bookpress" id="bookpress"  placeholder="请输入出版社">
                </div>
                <div class="form-group">
                    <label for="bookcreate">出版日期</label>
                    <input type="text" class="form-control" name="bookcreate" id="bookcreate"  placeholder="日期格式1996-03-12">

                </div>
                <div class="form-group">
                    <label for="summary">图书简介</label>
                    <textarea class="form-control" rows="3"  name="summary" id="summary" placeholder="请输入简介"></textarea>
                </div>
                <div class="form-group">
                    <label for="remark">备注</label>
                    <input type="text" class="form-control"  name="remark"  id="remark" placeholder="请输入备注，可不输入">
                </div>
                <div class="form-group">
                    <label for="sort">分类</label>
                    <select id="sort" name="sort">
                        <option value="${bSorts.get(0).id}">${bSorts.get(0).sortName}</option>
                        <c:forEach items="${bSorts}" var="alog">
                            <option value="${alog.id}">${alog.sortName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group" id="kucun">
                    <label for="stock">库存</label>
                    <input type="text" class="form-control" name="stock" id="stock"  value="1" placeholder="请输入库存">
                </div>
                <div class="form-group" id="kucun1">
                    <input type="file" name="file" id="file">
                </div>
                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#bookNum").val()==''||$("#bookname").val()==''||$("#bookauther").val()==''||$("#bookcreate").val()==''||$("#bookpress").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>
<script type="">
    $(function(){
        if($("#sort").val() == 1){
            $("#kucun").css("opacity",0);
            $("#kucun1").css("opacity",1);
        }
    })
    $("#sort").change(function(){
        if($("#sort").val() == 1){
            $("#kucun1").css("opacity",1);
            $("#kucun").css("opacity",0);
        }else if($("#sort").val() != 1){
            $("#kucun1").css("opacity",0);
            $("#kucun").css("opacity",1);
        }



    })


</script>


</body>
</html>
