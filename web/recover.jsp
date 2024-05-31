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
    </style>

</head>

<body>
<div class="loginform">

    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger">${failMsg }</div>
    </c:if>
    <c:if test="${!empty success }">
        <div class="alert alert-success">${success }</div>
    </c:if>
    <h1 class="title">找回密码</h1>
    <form action="/code/RecoverServlet" method="post">
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">用户名</label>
            <input type="text" name="username"  class="form-control" required aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">手机号</label>
            <input type="text" name="phone"  class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label" style="font-size: 20px;">修改密码</label>
            <input type="password" name="password"  required class="form-control" id="password">
        </div>
        <div class="mb-3">
            <label class="form-label" style="font-size: 20px;">确认修改密码</label>
            <input type="password" name="password1"  required class="form-control" >
        </div>
        <div class="mb-3">
            <label for="password" class="form-label" style="font-size: 20px;">验证码</label>
            <input type="password" name="code"  required class="form-control" id="code">
            <img id="img" src="/code/checkCodeServlet"  onclick="refreshCode()" alt="">
        </div>
        <div class="buttonlr" >
            <button type="submit" id="recoverButton" class="btn btn-primary">确认提交</button>
            <a href="login.jsp" class="btn btn-primary">登陆</a>
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
    document.getElementById('recoverButton').addEventListener('click', function(event) {
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('password1').value;

        if (password !== confirmPassword) {
            event.preventDefault(); // 阻止表单提交
            alert('密码和确认密码不一致，请重新输入。');
        }
    });
</script>

</html>
