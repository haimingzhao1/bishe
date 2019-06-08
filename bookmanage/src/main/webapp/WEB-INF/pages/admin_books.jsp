<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部图书信息</title>
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
                        还书管理
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
                <li><a href="leavelist">留言</a></li>
                <li><a href="#">${admin.adminName}，已登录</a></li>
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>


<div style="padding: 70px 550px 10px">
    <form   method="post" action="querybooksbyname" class="form-inline"  id="searchform">
        <div class="input-group">
           <input type="text" placeholder="输入图书名" class="form-control" id="search" name="searchWord" class="form-control">
            <span class="input-group-btn">
                            <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        function mySubmit(flag){
            return flag;
        }
        $("#searchform").submit(function () {
            var val=$("#search").val();
            if(val==''){
                alert("请输入关键字");
                return mySubmit(false);
            }
        })
    </script>
</div>
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
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部图书
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>出版日期</th>
                <th>库存</th>
                <th>出借</th>
                <th>归还</th>
                <th>详情</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookStocks}" var="book">
            <tr>
                <td><c:out value="${book.bookNumber}"></c:out></td>
                <td><c:out value="${book.bookName}"></c:out></td>
                <td><c:out value="${book.bookAuthor}"></c:out></td>
                <td><c:out value="${book.bookPress}"></c:out></td>
                <td><c:out value="${book.bookCreatetime}"></c:out></td>
                <td><c:out value="${book.stock.stock==-1?'电子书':book.stock.stock}"></c:out></td>
                <td><a href="lendbook?bookId=<c:out value="${book.id}"></c:out>"><button type="button" class="btn btn-primary btn-xs" <c:if test="${book.stock.stock<=0}">disabled="disabled" </c:if>>借阅</button></a></td>
                <td><a href="queryborrow?searchWord=<c:out value="${book.bookNumber}"></c:out>"><button type="button" class="btn btn-primary btn-xs" <c:if test="${book.stock.stock==-1}">disabled="disabled" </c:if>>归还</button></a></td>
                <td><a href="bookdetail?bookId=<c:out value="${book.id}"></c:out>&booksort=<c:out value="${book.sortId}"></c:out>"><button type="button" class="btn btn-success btn-xs">详情</button></a></td>
                <td><a href="updatebook?bookId=<c:out value="${book.id}"></c:out>"><button type="button" class="btn btn-info btn-xs">编辑</button></a></td>
                <td><a href="deletebook?bookId=<c:out value="${book.id}"></c:out>"><button type="button" class="btn btn-danger btn-xs">删除</button></a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%--<script type="text/javascript">--%>
<%--    var lend = ${boo}--%>
<%--</script>--%>
</body>
</html>
