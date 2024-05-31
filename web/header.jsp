<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login</title>
    <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">

    <style>

        .nav-item a {
            color: black;
            font-size: 18px;
            margin: 0 30px;
        }
    </style>

</head>

<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <img src="static/img/VCG211365994640.jpg" alt="" height="60px">
            <a class="navbar-brand" href="#" style="margin: 0 420px 0 20px;font-weight: bold">个人简历系统</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="navbar-brand" aria-current="page" href="/code/SelectAllInfoServlet">简历信息</a>
                    </li>
                    <c:if test="${!empty sessionScope.person }">
                        <li class="nav-item">
                            <a class="navbar-brand" href="/code/SelectUpdateAllInfoServlet">简历修改</a>
                        </li>
                        <li class="nav-item">
                            <a class="navbar-brand" href="/code/LogoutServlet">退出系统</a>
                        </li>
                    </c:if>

                </ul>
            </div>
        </div>
    </nav>
</nav>

<script src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>




</body>
<script>
</script>

</html>
