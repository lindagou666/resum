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
    </style>

</head>

<body>
<div>
    <jsp:include page="header.jsp"></jsp:include>
</div>
<div  style="padding-left: 50px">
    <div class="loginform">
        <c:if test="${!empty success }">
            <div class="alert alert-success">${success }</div>
        </c:if>
        <c:if test="${!empty failMsg }">
            <div class="alert alert-success">${failMsg }</div>
        </c:if>
        <h1 class="title">个人基本信息</h1>
        <%--  个人信息 --%>
        <form action="/code/UserUpdateServlet" method="post"  style="width: 80%;margin: 0  auto">
            <input type="hidden" name="id" class="form-control" value="${userByUsername.id}"  aria-describedby="emailHelp">
            <div  style="width:800px;display: flex">
                <div style="flex: 1">
                    <div class="mb-3" >
                        <label for="username" class="form-label" style="font-size: 20px;">用户名</label>
                        <input type="text" name="username" class="form-control" value="${userByUsername.username}" required id="username" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3" >
                        <label for="password" class="form-label" style="font-size: 20px;">密码</label>
                        <input type="password" name="password"  value="${userByUsername.password}" required class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label" style="font-size: 20px;">姓名</label>
                        <input type="text" name="name" class="form-control" value="${userByUsername.name}" required id="name" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" style="font-size: 20px;">性别</label>
                        <div class="form-check">
                            <input type="radio" id="male" name="sex" value="男" class="form-check-input" required aria-describedby="emailHelp"
                                   <c:if test="${userByUsername.sex == '男'}">checked</c:if>>
                            <label for="male" class="form-check-label">男</label>
                        </div>
                        <div class="form-check">
                            <input type="radio" id="female" name="sex" value="女" class="form-check-input" required aria-describedby="emailHelp"
                                   <c:if test="${userByUsername.sex == '女'}">checked</c:if>>
                            <label for="female" class="form-check-label">女</label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label" style="font-size: 20px;">联系电话</label>
                        <input type="text" name="phone"  value="${userByUsername.phone}" required class="form-control" id="phone">
                    </div>
                </div>
                <div style="flex: 1;m-left: 50px;">
                    <div class="mb-3">
                        <label for="schoolName" class="form-label" style="font-size: 20px;">学校名称</label>
                        <input type="text" name="schoolName"  value="${userByUsername.schoolName}" required class="form-control" id="schoolName">
                    </div>
                    <div class="mb-3">
                        <label for="jobName" class="form-label" style="font-size: 20px;">职位名称</label>
                        <input type="text" name="jobName"  value="${userByUsername.jobName}" required class="form-control" id="jobName">
                    </div>
                    <div class="mb-3">
                        <label for="education" class="form-label" style="font-size: 20px;">学历</label>
                        <input type="text" name="education"  value="${userByUsername.education}" required class="form-control" id="education">
                    </div>
                    <div class="mb-3">
                        <label for="age" class="form-label" style="font-size: 20px;">年龄</label>
                        <input type="text" name="age"  value="${userByUsername.age}" required class="form-control" id="age">
                    </div>
                    <div class="mb-3">
                        <label for="hobby" class="form-label" style="font-size: 20px;">爱好</label>
                        <input type="text" name="hobby"  value="${userByUsername.hobby}" required class="form-control" id="hobby">
                    </div>
                    <div class="buttonlr" >
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </div>


        </form>
    </div>
    <%--  专业技能 --%>
    <h1 class="title">专业技能</h1>

    <div class="contain" style="padding: 0px 150px">
        <div style="margin-top:40px">
            <div  style="display: flex">
                <button type="button" class="btn"><a href="/code/skillUpdateOrInsert.jsp">新增技能信息</a></button>
            </div>

            <table class="table  table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">技能名称</th>
                    <th scope="col">熟练度</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${skills}" var="skill" >
                    <tr >
                        <td scope="row" >${skill.id}</td>
                        <td>${skill.name}</td>
                        <td>${skill.proficiency}</td>
                        <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                            <button type="button" class="btn btn-outline-dark"><a href="/code/SelectSkillByIdServlet?id=${skill.id}">修改</a></button>
                            <button type="button" class="btn btn-outline-dark" onclick="skillConfirmDelete(${skill.id})">删除</button>
                        </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>

    <%--  工作经历 --%>
    <h1 class="title">工作经历</h1>

    <div class="contain" style="padding: 0px 150px">
        <div style="margin-top:40px">
            <div  style="display: flex">
                <button type="button" class="btn"><a href="/code/workExperienceUpdateOrInsert.jsp">新增工作经历</a></button>
            </div>

            <table class="table  table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">公司名称 </th>
                    <th scope="col">工作名称</th>
                    <th scope="col">开始时间 </th>
                    <th scope="col">结束时间 </th>
                    <th scope="col">描述</th>
                    <th scope="col">地址</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${workExperiences}" var="workExperience" >
                    <tr >
                        <td scope="row" >${workExperience.id}</td>
                        <td>${workExperience.companyName}</td>
                        <td>${workExperience.jobName}</td>
                        <td>${workExperience.startTime}</td>
                        <td>${workExperience.endTime}</td>
                        <td>${workExperience.describes}</td>
                        <td>${workExperience.address}</td>
                        <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                            <button type="button" class="btn btn-outline-dark"><a href="/code/SelectWorkExperienceByIdServlet?id=${workExperience.id}">修改</a></button>
                            <button type="button" class="btn btn-outline-dark" onclick="workExperienceConfirmDelete(${workExperience.id})">删除</button>
                        </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>

    <%--  荣誉 --%>
    <h1 class="title">荣誉</h1>

    <div class="contain" style="padding: 0px 150px">
        <div style="margin-top:40px">
            <div  style="display: flex">
                <button type="button" class="btn"><a href="/code/honorUpdateOrInsert.jsp">新增荣誉</a></button>
            </div>

            <table class="table  table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">荣誉名称 </th>
                    <th scope="col">时间 </th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${honors}" var="honor" >
                    <tr >
                        <td scope="row" >${honor.id}</td>
                        <td>${honor.honor}</td>
                        <td>${honor.time}</td>
                        <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                            <button type="button" class="btn btn-outline-dark"><a href="/code/SelectHonorByIdServlet?id=${honor.id}">修改</a></button>
                            <button type="button" class="btn btn-outline-dark" onclick="honorConfirmDelete(${honor.id})">删除</button>
                        </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>

    <%--  项目经历 --%>
    <h1 class="title">项目经历</h1>

    <div class="contain" style="padding: 0px 150px">
        <div style="margin-top:40px">
            <div  style="display: flex">
                <button type="button" class="btn"><a href="/code/projectExperienceUpdateOrInsert.jsp">新增项目经历</a></button>
            </div>

            <table class="table  table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">项目名称 </th>
                    <th scope="col">描述 </th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projectExperiences}" var="projectExperience" >
                    <tr >
                        <td scope="row" >${projectExperience.id}</td>
                        <td>${projectExperience.projectName}</td>
                        <td>${projectExperience.describes}</td>
                        <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                            <button type="button" class="btn btn-outline-dark"><a href="/code/SelectProjectExperienceByIdServlet?id=${projectExperience.id}">修改</a></button>
                            <button type="button" class="btn btn-outline-dark" onclick="projectExperienceConfirmDelete(${projectExperience.id})">删除</button>
                        </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>

    <%--  同事评价信息 --%>
    <h1 class="title">同事评价</h1>

    <div class="contain" style="padding: 0px 150px">
        <div style="margin-top:40px">
            <div  style="display: flex">
                <button type="button" class="btn"><a href="/code/colleagueEvaluationUpdateOrInsert.jsp">新增同事评价</a></button>
            </div>

            <table class="table  table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">公司名称 </th>
                    <th scope="col">同事</th>
                    <th scope="col">描述 </th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${colleagueEvaluations}" var="colleagueEvaluation" >
                    <tr >
                        <td scope="row" >${colleagueEvaluation.id}</td>
                        <td>${colleagueEvaluation.companyName}</td>
                        <td>${colleagueEvaluation.leader}</td>
                        <td>${colleagueEvaluation.describe}</td>
                        <td><div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                            <button type="button" class="btn btn-outline-dark"><a href="/code/SelectColleagueEvaluationByIdServlet?id=${colleagueEvaluation.id}">修改</a></button>
                            <button type="button" class="btn btn-outline-dark" onclick="colleagueEvaluationConfirmDelete(${colleagueEvaluation.id})">删除</button>
                        </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>
</div>

<script src="js/bootstrap.bundle.min.js"></script>



</body>
<script>
    function skillConfirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "/code/DeleteSkillServlet?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }

    function colleagueEvaluationConfirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "/code/DeleteColleagueEvaluationServlet?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }
    function honorConfirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "/code/DeleteHonorServlet?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }
    function projectExperienceConfirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "/code/DeleteProjectExperienceServlet?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }
    function workExperienceConfirmDelete(id) {
        var result = confirm("确定要删除吗？");
        if (result) {
            // 如果用户点击确定，执行删除操作
            window.location.href = "/code/DeleteWorkExperienceServlet?id=" + id;
        } else {
            // 如果用户点击取消，取消操作
            return;
        }
    }
</script>

</html>
