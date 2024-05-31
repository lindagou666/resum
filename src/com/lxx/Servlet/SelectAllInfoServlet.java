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

@WebServlet("/SelectAllInfoServlet")
public class SelectAllInfoServlet extends HttpServlet {
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
        User userByUsername = (User) request.getSession().getAttribute("person");
        if (userByUsername == null) {
            String username;
            if (userByUsername ==null){
                username= (String) request.getSession().getAttribute("username");
            }else{
                username = userByUsername.getUsername();
            }
            userByUsername= userDao.getUserByUsername(username);
        }


        List<ColleagueEvaluation> colleagueEvaluations = colleagueEvaluationDao.getAllEvaluationsByUid(userByUsername.getId());
        List<Honor> honors = honorDao.getAllHonorsByUid(userByUsername.getId());
        List<ProjectExperience> projectExperiences = projectExperienceDao.getAllProjectExperiencesByUid(userByUsername.getId());
        List<Skill> skills = skillDao.getSkillsByUid(userByUsername.getId());
        List<WorkExperience> workExperiences = workExperienceDao.getWorkExperiencesByUid(userByUsername.getId());



        // 将结果存储到 request 对象中
        request.setAttribute("colleagueEvaluations", colleagueEvaluations);
        request.setAttribute("honors", honors);
        request.setAttribute("projectExperiences", projectExperiences);
        request.setAttribute("skills", skills);
        request.setAttribute("workExperiences", workExperiences);
        request.setAttribute("userByUsername", userByUsername);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("myinfo.jsp").forward(request, response);
    }


}
