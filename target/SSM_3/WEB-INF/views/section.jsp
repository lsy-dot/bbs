<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 浩瀚
  Date: 2019/12/9
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<!--
    这里是具体的哪一个版面
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<html>
<head>
    <title>所有版块显示</title>
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
                <a href="${APP_PATH}/index1.jsp">返回主页</a>
            </div>
        </div>
    </div>
    <!--右部的主页内容栏-->
    <div class="right-main">
        <div class="container">
            <!--导航区-->
            <div class="row">
                <div class="col-md-12">
                    <div class="nav">
                        <div class="titleShow"><h1>${section.sSectionname}的所有主贴显示</h1></div>
                        <!--显示选择看帖子还是精华帖-->
                        <div class="selects">
                            <div class="row">
                                <div class="col-sm-6"><a href="${APP_PATH}/section/thesection?sectionId=${section.sId}">帖子</a></div>
                                <div class="col-sm-6"><a href="${APP_PATH}/section/perfects?sectionId=${section.sId}">精华帖</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--内容区-->
            <div class="row">
                <div class="col-md-10">
                        <!--展示帖子或者精华帖-->
                        <div class="allMains">
                            <div class="row">
                                <div class="col-md-12"><!--存放所有的帖子-->
                                    <table class="table table-hover">
                                        <tr>
                                            <th>序号</th>
                                            <th>标题</th>
                                            <th>内容</th>
                                            <th>发帖人</th>
                                            <th>发帖时间</th>
                                        </tr>
                                        <c:forEach items="${mainlist}" var="mainPost">
                                            <tr>
                                                <c:if test="${mainPost.mIsontop==1}">
                                                    <th>置顶</th>
                                                </c:if>
                                                <c:if test="${mainPost.mIsontop==0}">
                                                    <th>${mainPost.mMainid}</th>
                                                </c:if>
                                                <th>${mainPost.mTitle}</th>
                                                <th>${mainPost.mContent}</th>
                                                <th>${mainPost.user.uNickname}</th>
                                                <th>${mainPost.mMaindate}</th>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                <!--展示发帖按钮-->
                <div class="col-md-2">
                    <div>
                        <a href="#edit-publish">发帖</a>
                    </div>
                </div>
            </div>
            <!--编辑区-->
            <div class="row">
                <!--此区域进行发帖操作-->
                <a name="edit-publish"></a>
                <div class="edit-publish" >
                    <div class="row">
                        <p>发帖编辑区</p>
                    </div>
                    <div class="row">
                        <div class="title">
                            <input type="text" name="title" id="P-title" style="width:800px;height:50px" placeholder="请填写标题"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="navi">
                            <div class="row">
                                <!--提交图片-->
                                <input type="file" name="pic" id="pic" value="" accept="image/*" style="display:none">
                                <div class="col-sm-4"><a href="#" class="import">图片</a></div>
                                <div class="col-sm-4">表情</div>
                                <div class="col-sm-4">视频</div>
                            </div>
                        </div>
                        <div class="content" contenteditable="true" id="content">

                        </div>
                        <div class="sub">
                            <button class="btn btn-primary" id="publish_btn">发帖</button>
                        </div>
                        <div class="showContent">

                        </div>
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
        $.ajax({
            url:"${APP_PATH}/section/thesection",
            data:"sectionId=${section.sId}",
            type:"get",
            success:function (result) {

            }
        });
    }
    $('.import').click(function(){
        $("#pic").trigger('click');
    });
    // 当表单文件有变化时执行提交动作
    $('[name="pic"]').change(function(){
        if($(this).val()){
            $('.import').addClass('disabled');//图片链接禁用
            //$(this).parent().submit();
            var formData = new FormData();
            formData.append("picture", $("#pic")[0].files[0]);
            //alert("file");
            $.ajax({
                url:"${APP_PATH}/upload/picture",
                type:"POST",
                data:formData,
                contentType:false,
                processData:false,//这个很有必要，不然不行
                dataType:"json",
                mimeType:"multipart/form-data",
                success:function (result) {
                    if(result.code===100){
                        var contents=$("#content").html();
                        // var paths="/bbs/statics/images/"+result.extend.filename;
                        var paths="${APP_PATH}/statics/images/"+result.extend.filename;
                        contents+="<div><img src=\""+paths+"\" width=200 height=200><div>";
                        $(".content").html(contents);
                    }else{
                        alert("failed");
                    }
                }
            });
        }
    });
    /*
        提交主贴的内容
     */
    $("#publish_btn").click(function () {
        var data={
            "mMainerid":1,//${sessionScope.userId}设置一个默认的发帖人
            "mSectionid":${section.sId},
            "mTitle":$("#P-title").val(),
            "mContent":$("#content").html(),
            "mPoint":0
        };
        alert(data);
        $.ajax({
            url:"${APP_PATH}/main/publish",
            type:"post",
            data:data,//一个json封装的数据
            //dataType: "json",//返回的数据格式为json
            success:function (result) {
                if(result.code==100){
                    $(".showContent").html(result.extend.content);
                    to_page(1);//跳转到第一页数据处
                }
            }
        });
    });
</script>
</body>
</html>
