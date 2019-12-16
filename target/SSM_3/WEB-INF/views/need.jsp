<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/10
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<!--
精华帖页面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>需求帖显示</title>
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
<div class="containers">
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
                <%--                        <a href="#"><img src="${APP_PATH}/statics/images/default.jpeg" width="50" height="50"></a>--%>
                <a href="#"><p>交友论坛</p></a>
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
                <div class="info">
                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation"><a href="#">个人主页</a></li>
                        <li role="presentation"><a href="#edit-publish">发帖</a></li>
                        <li role="presentation"><a href="${APP_PATH}/main/notPerfect?sectionId=${section.sId}">加精</a></li>
                        <li role="presentation"><a href="${APP_PATH}/main/notTop?sectionId=${section.sId}">置顶</a></li>
                        <li role="presentation"><a href="${APP_PATH}/index1.jsp">返回主页</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--右部的主页内容栏-->
    <div class="right-main">
        <div class="container">
            <!--导航区-->
            <div class="row">
                <div class="col-md-12">
                    <div class="introduce">
                        <div class="titleShow"><h1>${section.sSectionname}</h1></div>
                        <div class="introduceShow">
                            <p>${section.sDescription}</p>
                        </div>
                        <div class="countInfo">
                            <p>总帖数：<span>${section.mainNums}</span> 总回复数：<span>${section.followNums}</span></p>
                        </div>
                    </div>
                    <div class="nav">
                        <!--显示选择看帖子还是精华帖-->
                        <div class="selects">
                            <div class="row">
                                <ul class="nav nav-tabs">
                                    <li role="presentation"><a href="${APP_PATH}/section/thesection?sectionId=${section.sId}">帖子</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/section/perfects?sectionId=${section.sId}">精华帖</a></li>
                                    <li role="presentation" class="active"><a href="${APP_PATH}/section/needs?sectionId=${section.sId}">需求帖</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/section/hots?sectionId=${section.sId}">热门帖</a></li>
                                    <li role="presentation"><a href="${APP_PATH}/section/news?sectionId=${section.sId}">最新帖</a></li>
                                    <li role="presentation"><a href="#">其他</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--内容区-->
            <div class="row">
                <div class="col-md-12">
                    <!--展示帖子或者精华帖-->
                    <div class="allMains">
                        <div class="row">
                            <div class="col-md-12"><!--存放所有的帖子-->
                                <table class="table table-hover" id="mains_table">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>标题</th>
                                        <th>发帖人</th>
                                        <th>发帖时间</th>
                                        <th>回复数</th>
                                        <th>最后发表</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--显示分页信息-->
            <div class="row">
                <!--分页文字信息-->
                <div class="col-md-6" id="page_info_area">

                </div>
                <!--分页条-->
                <div class="col-md-6" id="page_nav_area">

                </div>
            </div>

        </div>
    </div>
</div>

<script>
    //1.页面加载完成后，直接发送一个ajax请求，拿到分页信息
    $(function(){
        to_page(1);//首次加载页面时显示第一页
    });
    //跳转到页面
    function to_page(pn){
        var data={
            "pn":pn,
            "sectionId":${section.sId}
        };
        $.ajax({
            url:"${APP_PATH}/main/findNeedsInSection",
            data:data,
            type:"get",
            success:function (result) {
                //console.log(result);
                //1.解析并且显示员工数据
                build_mains_table(result);
                //2.解析并且显示分页信息
                build_page_info(result);
                //3.分页条的显示
                build_page_nav(result);
            }
        });
    }
    //table结构
    function build_mains_table(result) {
        //清空table表
        $("table tbody").empty();
        var emps=result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            var mainIdTd=$("<td></td>").append(item.mMainid);
            var mainTitleTd=$("<td></td>").append(item.mTitle);
            var mainnerHeadPic=$("<div></div>").append("<img src='"+item.user.uHeadpic+"'alt='头像' class=\"img-circle\" width=45px height=45px>");
            var mainnerNickname=$("<div></div>").append(item.user.uNickname);
            var userNickname=$("<td></td>").append(mainnerHeadPic).append(mainnerNickname);//主帖的发布者

            var date=formatDate(item.mMaindate);
            var hourandminute=formatDateHourAndMinute(item.mMaindate);

            var mainDate=$("<td></td>").append(date+" "+hourandminute);

            var follows=$("<td></td>").append(getJsonLength(item.follows));

            var latestdate=formatDate(item.latestTime);
            var latesthourandminute=formatDateHourAndMinute(item.latestTime);

            var latestuser=$("<div></div>").append(item.latestPublish.uNickname);
            var latesttime=$("<div></div>").append(latestdate+" "+latesthourandminute);
            //最新发表
            var latest=$("<td></td>").append(latestuser).append(latesttime);
            var link=$("<a href='${APP_PATH}/main/theMain?mainId="+item.mMainid+"' target='_blank' class='link'></a>");
            mainTitleTd.append(link);
            //append方法执行完返回的还是原来的元素
            $("<tr></tr>")
                .append(mainIdTd)
                .append(mainTitleTd)
                .append(userNickname)
                .append(mainDate)
                .append(follows)
                .append(latest)
                .appendTo("#mains_table tbody");
        });
    }
    //解析显示分页信息
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，" +
            "总共"+result.extend.pageInfo.pages+"页，" +
            "总共"+result.extend.pageInfo.total+"条记录");
        totalRecord=result.extend.pageInfo.total;
        currentPage=result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要去下一页
    function build_page_nav(result){
        $("#page_nav_area").empty();
        var ul=$("<ul><ul>").addClass("pagination");
        var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }
        var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.extend.pageInfo.hasNextPage==false){
            lastPageLi.addClass("disabled");
            nextPageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });
        }

        //添加首页和前一页的提示
        ul.append(firstPageLi).append(prePageLi);

        //遍历给ul中添加页码
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi=$("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum==item){
                numLi.addClass("active");//高亮显示
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加末页和下一页的提示
        ul.append(nextPageLi).append(lastPageLi);
        //把ul添加到nav中
        var navEle=$("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
</script>
</body>
</html>

