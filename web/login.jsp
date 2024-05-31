<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
        .title {
            text-align: center;
            width: 80%;
            margin: 0 auto;
            margin-bottom: 40px;
        }

        .loginform {
            width: 40%;
            margin: 100px auto 0;
            background-color: rgb(255, 255, 255);
            /* background-image: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%); */
            padding: 20px 40px;
            border-radius: 10px;
            /* 添加圆角边框 */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            /* 添加阴影 */
        }

        .buttonlr {
            display: flex;
            margin-top: 40px;
        }

        .buttonlr button {
            width: 100px;
            margin-right: 328px;
        }

        .buttonlr a {
            width: 100px;
        }
        body{
            /* 设置背景 */
            background-image: url(./css/微信图片_20240531131610.jpg);
            /* 平铺 */
            background-repeat: no-repeat;
            /* 按照屏幕大小计算尺寸 */
            background-size: cover;
            /* fixed */
            background-attachment: fixed;
        }

    </style>

</head>

<body  >
<div class="loginform">

    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger">${failMsg }</div>
    </c:if>
    <c:if test="${!empty success }">
        <div class="alert alert-success">${success }</div>
    </c:if>
    <h1 class="title">系统登录</h1>
    <form action="/code/LoginServlet" method="post">
        <div class="mb-3">
            <label for="username" class="form-label" style="font-size: 20px;">用户名</label>
            <input type="text" name="username" value="${cookie.username.value}" class="form-control" required id="username" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label" style="font-size: 20px;">密码</label>
            <input type="password" name="password" value="${cookie.password.value}"  class="form-control" id="password">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label" style="font-size: 20px;">验证码</label>
            <input type="password" name="code"  required class="form-control" id="code">
            <img id="img" src="/code/checkCodeServlet"  onclick="refreshCode()" alt="">
        </div>
        <label for="rememberMe">记住我:</label>
        <input type="checkbox" id="rememberMe"  value="true" name="rememberMe"><br><br>
        <div class="buttonlr" >
            <button type="submit" class="btn btn-primary">登录</button>
            <a href="recover.jsp" class="btn btn-primary">找回密码</a>
            <a href="register.jsp" class="btn btn-primary">注册</a>
        </div>

    </form>
</div>

<script src="js/bootstrap.bundle.min.js"></script>



</body>
<script>
    <%--//刷新验证码，即重新发送请求--%>
    function refreshCode(){
        document.getElementById("img").src="/code/checkCodeServlet?time="+new Date().getTime();
    }
</script>

</html>
