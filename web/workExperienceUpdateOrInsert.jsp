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
    <h1 class="title">工作经验信息</h1>
    <form action="/code/UpdateOrSaveWorkExperienceServlet" method="post">
        <input type="hidden" name="id" value="${workExperience.id}">

        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">公司名称</label>
            <input type="text" name="companyName" value="${workExperience.companyName}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">岗位名称</label>
            <input type="text" name="jobName" value="${workExperience.jobName}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">开始时间 </label>
            <input type="text" name="startTime" value="${workExperience.startTime}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">结束时间</label>
            <input type="text" name="endTime" value="${workExperience.endTime}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">描述</label>
            <input type="text" name="describes" value="${workExperience.describes}" class="form-control" required  aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label  class="form-label" style="font-size: 20px;">地址 </label>
            <input type="text" name="address" value="${workExperience.address}" class="form-control" required aria-describedby="emailHelp">
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
