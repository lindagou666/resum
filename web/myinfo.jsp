<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login</title>
    <!--BEGIN HEAD LINK STYLE-->
    <!--BASE STYLE CSS-->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <!--PRODUCTION PHOTO CSS-->
    <link rel="stylesheet" href="css/productionPhoto.css" type="text/css" media="screen"/>
    <!--PRINT CSS-->
    <link rel="stylesheet" href="css/print.css" type="text/css" media="print"/>
    <!--END HEAD LINK STYLE-->

    <!--BEGIN HEAD TITLE-->
    <title>个人简历-ZHIHUA·WEI</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
    </style>

</head>

<body>
<div>
    <jsp:include page="header.jsp"></jsp:include>
</div>
<div id="wrapper">

    <!--INTRODUCE NAME-->
    <h2 class="sectionHead">  ${userByUsername.name}</h2>
    <div class="userinfo" style="background-color: #efebeb;width: 600px;;height: 200px;padding-left: 50px;padding-top: 40px;">
        <div style="margin: 20px">
            <span style="margin-right: 20px">姓名：     ${userByUsername.name}</span>
            <span style="margin-right: 20px">年龄：     ${userByUsername.age}</span>
            <span style="margin-right: 20px">性别：     ${userByUsername.sex}</span>
        </div>
        <div style="margin: 20px">
            <span style="margin-right: 20px">求职意向：     ${userByUsername.jobName}</span>
            <span style="margin-right: 20px">学历：     ${userByUsername.education}</span>
            <span style="margin-right: 20px">毕业院校：     ${userByUsername.schoolName}</span>
        </div>
        <div style="margin: 20px">
            <span style="margin-right: 20px">手机号：    ${userByUsername.phone} </span>
            <span style="margin-right: 20px">爱好：    ${userByUsername.hobby}</span>

        </div>
    </div>
    <!--END BASE INFORMATION-->

    <div class="clear"></div>

    <!--SKILLS TITLE-->
    <h2 id="tools" class="sectionHead">技能</h2>
    <!--SKILLS-->
    <ul id="skills">
        <c:forEach items="${skills}" var="skill" >
        <li  class="${skill.proficiency}"><span>${skill.name}</span></li>
        </c:forEach>

    </ul>
    <!--END SKILLS-->

    <div class="clear"></div>

    <!--EXPERIENCE TITLE-->
    <h2 id="clock" class="sectionHead">工作经验</h2>
    <!--EXPERIENCE-->
    <ul id="jobs">
        <c:forEach items="${workExperiences}" var="workExperience" >
        <li>
            <div class="details">
                <h3>${workExperience.companyName}</h3>
                <h4>${workExperience.jobName} - ${workExperience.address}</h4>
                <h5>${workExperience.startTime} - ${workExperience.endTime}</h5>
            </div>
            <p>${workExperience.describes}</p>
        </li>
        </c:forEach>
    </ul>
    <!--END EXPERIENCE-->

    <div class="clear"></div>

    <!--HONORS / AWARDS TITLE-->
    <h2 id="ribbon" class="sectionHead">荣誉 &amp; 奖励</h2>

    <!--HONORS / AWARDS-->
    <ul id="honorsAwards">
        <c:forEach items="${honors}" var="honor" >
            <li>${honor.honor} - ${honor.time}</li>
        </c:forEach>

    </ul>
    <!--END HONORS / AWARDS-->

    <div class="clear"></div>

    <!--AS SEEN ON TITLE-->
    <h2 id="eye" class="sectionHead">项目经验</h2>
    <!--PROJECT-->
    <ul id="project">
        <c:forEach items="${projectExperiences}" var="projectExperience" >
            <li>
                <div class="details">
                    <h3>${projectExperience.projectName}</h3>
                </div>
                <p>${projectExperience.describes}</p>
            </li>
        </c:forEach>

    </ul>
    <!--END PROJECT-->

    <div class="clear"></div>

    <!--RECOMMENDATIONS TITLE-->
    <h2 id="chat" class="sectionHead">同事评语</h2>
    <!--RECOMMENDATIONS-->
    <ul id="recommends">
        <c:forEach items="${colleagueEvaluations}" var="colleagueEvaluation" >
            <li><h3>${colleagueEvaluation.companyName}</h3></li>
            <li>
                <div class="details">
                    <h3>领导：${colleagueEvaluation.leader}</h3>
                </div>
                <p>${colleagueEvaluation.describe}</p>
            </li>
        </c:forEach>
    </ul>
    <!--END RECOMMENDATIONS-->

    <div class="clear"></div>


</div>

<script src="js/jquery.js"></script>
<!--PROJECT PHOTO JS-->
<script src="js/projectPhoto.js"></script>
<!--BACK POSITION JS-->
<script src="js/backPosition.js"></script>
<!--CUSTOM JS-->
<script src="js/custom.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>



</body>


</html>
<script>
    function makeEditable(editableElementId) {
        //event.preventDefault();
        var element = document.getElementById(editableElementId);
        element.contentEditable = true;
        // 设置焦点
        window.getSelection().selectAllChildren(element);
    }

    function makeNonEditable(editableElementId) {
        //preventDefault();
        var element = document.getElementById(editableElementId);
        element.contentEditable = false;
        console.log(element.textContent) // 内容
        var save_text = element.textContent
        // 通过jquery ajax post 发送数据
        $.ajax({
            url: 'http://localhost:8080/resume/test', // 要发送的url地址，这里只是示例，需要替换为实际的url
            type: 'post', // 数据发送方式
            dataType:'text',
            data: {
                'save_text': save_text
            }, // 要发送的数据，这里只是示例，需要替换为实际的数据
            success: function (data){
                console.log(data)
            }
        })
    }
</script>
