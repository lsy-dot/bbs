<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/21
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
    pageContext.setAttribute("uid",request.getParameter("uid"));
%>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${APP_PATH}/statics/bootstrapValidator/dist/css/bootstrapValidator.css"/>
    <link href="${APP_PATH}/statics/css/main.css" rel="stylesheet">
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/statics/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
    <style>
        .mid{
            position: absolute;
            left: 35%;
            bottom: 20%;
        }
    </style>
</head>
<body onload="initAjax()">
<div class="mid">
    <img id="headpic"  class='img-circle' alt="Member">
    <h3>Sophia</h3>
    <div id="info"><span>关于TA</span></div>
    <div id="email"><span>邮箱</span></div>
    <div id="age"><span>年龄</span></div>
    <div id="worklocation"><span>工作地点</span></div>
    <div id="workproperty"><span>身份</span></div>
    <div id="point"><span>积分</span></div>
</div>

</body>
</html>
<script>
    function initAjax(){
        $.ajax({
            url:"${APP_PATH}/user/getUserById?userid=${uid}",
            type:"post",
            success(result){
                // {"user":{"uId":1,"uUserid":"rose","uPassword":"123456",
                // "uNickname":"昵称32a251","uSex":"男","uName":"真实名字：32a251","
                // uEmail":"32a251@qq.com","uIntro":"开朗","uHeadpic":"/bbs/statics
                // /images/default.jpeg","uAge":"22","uWorkplace":"江西"
                // ,"uWorkproperty":"学生","uIssectioner":0,"uPoints":15,"
                // mainPostNums":null}}
                var data=JSON.parse(result);
                var obj=data["user"];
                var uHeadpic=obj["uHeadpic"];
                var uIntro=obj["uIntro"];
                var uEmail=obj["uEmail"];
                var uAge=obj["uAge"];
                var uWorkplace=obj["uWorkplace"];
                var uWorkproperty=obj["uWorkproperty"];
                var uPoints=obj["uPoints"];
                $("#headpic").attr("src",uHeadpic);
                $("#info").append($("<span><span>").text(uIntro));
                $("#email").append($("<span><span>").text(uEmail));
                $("#age").append($("<span><span>").text(uAge));
                $("#worklocation").append($("<span><span>").text(uWorkplace));
                $("#workproperty").append($("<span><span>").text(uWorkproperty));
                $("#point").append($("<span><span>").text(uPoints));
            }
        })
    }

</script>