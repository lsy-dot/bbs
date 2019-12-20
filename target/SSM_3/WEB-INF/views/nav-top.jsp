<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/17
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${APP_PATH}/index1.jsp">网站首页</a></li>

                <c:if test="${userid==section.sBanzhuid}">
                    <li><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
                    <li><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
                </c:if>
                    <c:if test="${userid==null}">
                        <li><a href="${APP_PATH}/jumpToLogin/login">登录</a></li>
                        <li><a href="#">注册</a></li>
                    </c:if>
                    <c:if test="${userid!=null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            ${userid}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人信息</a></li>
                            <li><a href="#">修改密码</a></li>
                            <li><a href="#">修改头像</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${APP_PATH}/user/userExit">退出登录</a></li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
