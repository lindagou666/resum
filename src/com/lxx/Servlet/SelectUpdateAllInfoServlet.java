package com.lxx.Servlet;

import com.lxx.Bean.*;
import com.lxx.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectUpdateAllInfoServlet")
public class SelectUpdateAllInfoServlet extends HttpServlet {
    private ColleagueEvaluationDaoImpl colleagueEvaluationDao = new ColleagueEvaluationDaoImpl();
    private HonorDaoImpl honorDao = new HonorDaoImpl();
    private ProjectExperienceDaoImpl projectExperienceDao = new ProjectExperienceDaoImpl();
    private SkillDaoImpl skillDao = new SkillDaoImpl();
    private UserDaoImpl userDao = new UserDaoImpl();
    private WorkExperienceDaoImpl workExperienceDao = new WorkExperienceDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("person");

        List<ColleagueEvaluation> colleagueEvaluations = colleagueEvaluationDao.getAllEvaluationsByUid(user.getId());
        List<Honor> honors = honorDao.getAllHonorsByUid(user.getId());
        List<ProjectExperience> projectExperiences = projectExperienceDao.getAllProjectExperiencesByUid(user.getId());
        List<Skill> skills = skillDao.getSkillsByUid(user.getId());
        List<WorkExperience> workExperiences = workExperienceDao.getWorkExperiencesByUid(user.getId());
        User userByUsername = userDao.getUserByUsername(user.getUsername());

        // 将结果存储到 request 对象中
        request.setAttribute("colleagueEvaluations", colleagueEvaluations);
        request.setAttribute("honors", honors);
        request.setAttribute("projectExperiences", projectExperiences);
        request.setAttribute("skills", skills);
        request.setAttribute("workExperiences", workExperiences);
        request.setAttribute("userByUsername", userByUsername);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("updateMyinfo.jsp").forward(request, response);
    }


}
