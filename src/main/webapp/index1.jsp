<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主页设计</title>
    <meta charset="UTF-8">
    <%
        //这个的路径是以斜线开始的，不以斜线结束
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/statics/js/jquery-1.10.2.js"></script>
    <!--引入样式-->
    <link href="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script src="${APP_PATH}/statics/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/statics/js/common.js"></script>
</head>
<body>

    <!--上方的导航栏-->
    <div class="top-navigate">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <!--左部的个人信息栏-->
    <div class="left-info">
        <div class="logo">
            <div class="col-md-12">
                <a href="#"><img src="${APP_PATH}/statics/images/default.jpeg" width="50" height="50"></a>
            </div>
        </div>
        <div class="info">
            <div class="haslogin" style="display: none">
                <!--显示登陆时候的显示-->
            </div>
            <div class="notlogin">
                <form>
                    <div class="wrapperLogin">
                        <input type="email" class="form-control" placeholder="账号" style="width:140px">
                    </div>
                    <div class="wrapperLogin">
                        <input type="password" class="form-control" placeholder="密码" style="width:140px">
                    </div>
                    <div class="wrapperLogin">
                        <button class="btn btn-success">登录</button>
                        <button class="btn btn-warning">注册</button>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <!--右部的主页内容栏-->
    <div class="right-main">
        <div class="container">
            <div class="row" id="sections">

            </div>
        </div>
    </div>
<script>
    //页面首次加载
    $(function () {
        $.ajax({
            url:"${APP_PATH}/section/findAll",
            type:"GET",
            success:function(result){
                var sectionlist=result.extend.sectionslist;
                $.each(sectionlist,function (index,item) {//所有的版块
                    //alert(item.sSectionname);//测试是否成功
                    var sectionA=$("<a></a>").append(item.sSectionname);
                    sectionA.attr("href","${APP_PATH}/section/thesection?sectionId="+(index+1));
                    var pS=$("<p></p>").append(sectionA);
                    var divTitle=$("<div></div>").addClass("sectionTitle").append(pS);
                    var divWrapper=$("<div></div>").addClass("wrapper").append(divTitle);
                    var introduce=$("<div></div>").addClass("sectionIntroduce").append("<p>"+item.sDescription+"</p>")
                    var ul=$("<ul></ul>");
                    var num=0;
                    $.each(item.someMain,function (index1,item1) {//该板块将显示在主页的的最多四个精华帖
                        //alert(item1.mContent);
                        var mainA=$("<a href='${APP_PATH}/main/theMain?mainId="+item1.mMainid+"' target='_blank'></a>").append(item1.mTitle);
                        var liMain=$("<li></li>").append(mainA);
                        ul.append(liMain);
                        num++;
                    });
                    divWrapper.append(introduce);
                    divWrapper.append(ul);
                    $("<div class='col-md-6 clearfix sections'></div>")//section
                        .append(divWrapper)
                        .appendTo("#sections");
                });
            }
        });
    });
</script>
</body>
</html>
