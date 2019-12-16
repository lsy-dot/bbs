<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2019/12/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //这个的路径是以斜线开始的，不以斜线结束
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <script src="${APP_PATH}/statics/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        let localEditor;
        function ckEditors(id) {
            localEditor = CKEDITOR.replace(id, {toolbar: 'Basic'});

        }
        function show() {
            localEditor.document.getBody().getHtml()
        }
    </script>
</head>
<body onload="ckEditors('description')">
<textarea class="form-control" id="description"
           name="description" style="color: #8a8a8a;"></textarea>
<button type="button" class="btn btn-success" onclick="show()">跟帖</button>

</body>
</html>

