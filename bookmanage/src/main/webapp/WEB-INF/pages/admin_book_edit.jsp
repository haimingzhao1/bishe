<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑《 ${bookDomain.bookName}》</title>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《 ${bookDomain.bookName}》</h3>
        </div>
        <div class="panel-body">
            <form action="book_edit_do?id=${bookDomain.id}" method="post" id="addbook" >

                <div class="input-group">
                    <span  class="input-group-addon">图书编号</span>
                    <input type="text" class="form-control" name="bookNum" id="bookNum" value="${bookDomain.bookNumber}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">书名</span>
                    <input type="text" class="form-control" name="bookname" id="bookname" value="${bookDomain.bookName}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="bookauther" id="bookauther"  value="${bookDomain.bookAuthor}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="press" id="press"  value="${bookDomain.bookPress}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版日期</span>
                    <input type="text" class="form-control" name="createtime" id="createtime"  value="${bookDomain.bookCreatetime}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">简介</span>
                    <input type="text" class="form-control" name="summary" id="summary" value="${bookDomain.bookSummary}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">备注</span>
                    <input type="text" class="form-control" name="remark"  id="remark" value="${bookDomain.bookRemark}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">库存</span>
                    <input type="text"<c:if test="${stock.stock==-1}">readonly="readonly"</c:if> class="form-control" name="stock"  id="stock" value="${stock.stock==-1?'电子书':stock.stock}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">分类</span>
                    <select name="sort" id="sort">
                        <option value="${bookDomain.sort.id}">${bookDomain.sort.sortName}</option>
                        <c:forEach items="${sorts}" var="alog">
                            <option value = "${alog.id}">${alog.sortName}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        var st = $("#stock").val();
                        var reg=/^\d+$/;
                        if($("#bookNum").val()==''||$("#bookname").val()==''||$("#bookauther").val()==''||$("#press").val()==''||$("#createtime").val()==''||$("#summary").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }if(!st.includes('电子书')){
                            if(reg.test(st)==false){
                                alert("库存只能为数字！")
                                return mySubmit(false);
                            }
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
