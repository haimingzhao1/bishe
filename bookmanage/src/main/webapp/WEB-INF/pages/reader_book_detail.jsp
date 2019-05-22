<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>《 ${detail.bookName}》</title>
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
                <li class="active">
                    <a href="reader_querybook" >
                        图书查询
                    </a>
                </li>
                <li >
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
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="reader_info"><span class="glyphicon glyphicon-user"></span>&nbsp;${readercard.stuName}，已登录</a></li>
                <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《 ${detail.bookName}》</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="15%">书名</th>
                    <td>${detail.bookName}</td>
                </tr>
                <tr>
                    <th>作者</th>
                    <td>${detail.bookAuthor}</td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td>${detail.bookPress}</td>
                </tr>
                <tr>
                    <th>图书编号</th>
                    <td>${detail.bookNumber}</td>
                </tr>
                <tr>
                    <th>简介</th>
                    <td>${detail.bookSummary==''?'暂无简介哦~~':detail.bookSummary}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td>${detail.bookRemark==''?'暂无备注哦~~':detail.bookRemark}</td>
                </tr>
                <tr>
                    <th>出版日期</th>
                    <td>${detail.bookCreatetime}</td>
                </tr>
                <tr>
                    <th>分类</th>
                    <td>${detail.sort.sortName}</td>
                </tr>
                <tr>
                    <th>状态</th>
                    <c:if test="${detail_stock.stock>0}">
                        <td>在馆,&nbsp;剩余&nbsp;${detail_stock.stock}&nbsp;本</td>
                    </c:if>
                    <c:if test="${detail_stock.stock==0}">
                        <td>库存不足</td>
                    </c:if>
                    <c:if test="${detail_stock.stock==-1}">
                        <td><a id="readBook" href="#">预览电子书</a> / <a class="loadbook" href="loadbook">下载电子书</a>
                        <form action="" method="post">
                            <input type="hidden" name="userid" value="${readercard.id}">
                            <input type="hidden" name="filename" value="${detail.ebook}">
                        </form> </td>
                    </c:if>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="panel-body">
        <span id="bookContent"></span>
        <br/><br/><br/>
        <span id="bookAlert"></span>
    </div>

</div>
<script type="text/javascript">

    $(function(){

        $(".loadbook").click(function(){

            var href = $(this).attr("href");

            $("form").attr("action", href).submit();

            return false;

        });

    })

    $(function(){

        $("#readBook").click(function(){
            // alert("chakan");

            // var href = $(this).attr("href");

            // $("form").attr("action", href).submit();

            $.ajax({
                url:"/readBook",
                data:{
                    bookId:${detail.id}
                },
                dataType:"json",
                success:function (data) {
                    // alert("21");
                    if(data.status == "0"){
                        alert("本书id有误");
                    }else if(data.status == "1"){
                        alert("本书暂不支持预览。。。");
                    }else if(data.status == "2"){
                        var bookContent = data.bookContent;

                        // alert(bookContent);
                        $("#bookContent").text(bookContent);
                        $("#bookAlert").text("欲知后事如何，请下载！");
                    }
                }
            });

        });

    })

</script>
</body>
</html>
