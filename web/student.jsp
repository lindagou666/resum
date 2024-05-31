<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">
    <style>
        .btn a{
            color: black;
            text-decoration: none;
        }
        .btn{
            background-color: #e1e3e7;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<div>
    <jsp:include page="header.jsp"></jsp:include>
</div>
<div class="contain" style="padding: 20px 150px">
    <div style="height: 550px;">
        <div  style="display: flex">
            <button type="button" class="btn "><a href="/code/studentUpdateOrInsert.jsp">新增学生信息</a></button>
        </div>
    <c:if test="${!empty success }">
        <div class="alert alert-success">${success }</div>
    </c:if>
    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger" >${failMsg }</div>
    </c:if>
        <form action="/code/SelectStudentByNumberServlet" method="post" style="display: flex;align-items: center;height: 50px;width: 80%;margin-bottom: 10px">
            <input type="text" name="number" value="${number}" style="flex: 5;outline: none;" placeholder="学号">
            <button  type="submit" style="flex: 1;background-color: #d9dee7;border: none" >搜索</button>
        </form>
        <table class="table  table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">学号</th>
                <th scope="col">姓名</th>
                <th scope="col">年龄</th>
                <th scope="col">性别</th>
                <th scope="col">专业</th>
                <th scope="col">学院</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student" >
                <tr >
                    <td scope="row" >${student.id}</td>
                    <td>${student.number}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.sex}</td>
                    <td>${student.major}</td>
                    <td>${student.academy}</td>
                    <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                        <button type="button" class="btn btn-outline-dark"><a href="/code/SelectByIdServlet?id=${student.id}">修改</a></button>
                        <button type="button" class="btn btn-outline-dark" onclick="confirmDelete(${student.id})">删除</button>
                    </div>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

</div>
<script src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>




</body>
<script>
        function confirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
        // 如果用户点击确定，执行删除操作
        window.location.href = "/code/DeleteStudentServlet?id=" + id;
    } else {
        // 如果用户点击取消，取消操作
        return;
    }
    }

</script>
</html>
