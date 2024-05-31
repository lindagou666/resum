<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Period" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<%--    <link href="../css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">
    <style>

        .title {
            text-align: center;
            width: 80%;
            margin: 0 auto;
            margin-bottom: 40px;
        }

        .updateform {
            width: 40%;
            margin: 40px auto 0;
            background-color: rgb(255, 255, 255);
            /* background-image: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%); */
            padding: 20px 40px;
            border-radius: 10px;
            /* 添加圆角边框 */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            /* 添加阴影 */
        }

        .buttonlr {
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
<div>
    <jsp:include page="header.jsp"></jsp:include>
</div>
<div class="updateform">
    <h1 class="title">技能信息</h1>
    <form action="/code/UpdateOrSaveSkillServlet" method="post">
        <input type="hidden" name="id" value="${skill.id}">

        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">技能名称</label>
            <input type="text" name="name" value="${skill.name}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">熟练度</label>
            <select class="form-select" name="proficiency" aria-label="Default select example" required>
                <option value="${skill.proficiency}">请选择熟练度</option>
                <option value="s10">10%</option>
                <option value="s20">20%</option>
                <option value="s30">30%</option>
                <option value="s40">40%</option>
                <option value="s50">50%</option>
                <option value="s60">60%</option>
                <option value="s70">70%</option>
                <option value="s80">80%</option>
                <option value="s90">90%</option>
                <option value="s100">100%</option>
            </select>
<%--            <input type="text" name="proficiency" value="${skill.proficiency}" placeholder="可选  " class="form-control" required aria-describedby="emailHelp">--%>
        </div>



        <div class="buttonlr">
            <button type="submit" class="btn btn-primary">确认提交</button>
        </div>
    </form>
</div>
<script src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>




</body>
<script>


</script>
</html>
