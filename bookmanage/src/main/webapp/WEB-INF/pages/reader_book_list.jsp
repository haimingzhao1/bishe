<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部图书</title>
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
                <li >
                    <a href="reader_querybook" >
                        图书查询
                    </a>
                </li>
                <li class="active">
                    <a href="reader_booksort" >
                        全部图书
                    </a>
                </li>
                <li>
                    <a href="reader_info" >
                        个人信息
                    </a>
                </li>
                <li>
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

<div class="panel panel-default" style="width: 90%;margin-left: 5%;margin-top: 5%">
    <div style="width: 100px;margin-left: 100px">
        <a href="leavemsg"><button type="button" class="btn btn-primary btn-block" >留言</button></a>
    </div>
    <div class="panel-heading">
        <h3 class="panel-title">
            ${sortid.sortName}
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>图书编号</th>
                <th>图书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>出版日期</th>
                <th>查看详情</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookList}" var="alog">
                <tr>
                    <td><c:out value="${alog.bookNumber}"></c:out></td>
                    <td><c:out value="${alog.bookName}"></c:out></td>
                    <td><c:out value="${alog.bookAuthor}"></c:out></td>
                    <td><c:out value="${alog.bookPress}"></c:out></td>
                    <td><c:out value="${alog.bookCreatetime}"></c:out></td>
                    <td><a href="readerbookdetail?bookId=${alog.id}">点击查看</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
