<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页设计</title>
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <!--上方的导航栏-->
    <div class="top-navigate">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div><h5>BBS论坛</h5></div>
                </div>
            </div>
        </div>
    </div>
    <!--左部的个人信息栏-->
    <div class="left-info">
        <div class="container">
            <div class="row">
                <h4>欢迎使用此bbs论坛</h4>
            </div>
            <div class="row">
                <button class="btn btn-primary" id="emp_add_modal_btn">登录</button>
                <button class="btn btn-danger" id="emp_delete_all">注册</button>
            </div>
        </div>
    </div>
    <!--右部的主页内容栏-->
    <div class="right-main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>所有版块</h3>
                    <section class="sections">
                        <div class="wrapper">
                            <div class="title two-line">
                                <p><a href="${APP_PATH}/section/thesecion?sectionId=1">板块一</a></p>
                            </div>
                            <ul>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                            </ul>
                        </div>
                    </section>
                    <section class="sections">
                        <div class="wrapper">
                            <div class="title two-line">
                                <p><a href="#">板块二</a></p>
                            </div>
                            <ul>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                            </ul>
                        </div>
                    </section>
                    <section class="sections">
                        <div class="wrapper">
                            <div class="title two-line">
                                <p><a href="#">板块三</a></p>
                            </div>
                            <ul>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                            </ul>
                        </div>
                    </section>
                    <section class="sections">
                        <div class="wrapper">
                            <div class="title two-line">
                                <p><a href="#">板块四</a></p>
                            </div>
                            <ul>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                                <li><a href="#">帖子一</a></li>
                            </ul>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
<script>

</script>
</body>
</html>
