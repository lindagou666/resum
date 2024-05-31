package com.lxx.Servlet.ProjectExperience;

import com.lxx.Bean.ProjectExperience;
import com.lxx.dao.ProjectExperienceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectProjectExperienceByIdServlet")
public class SelectProjectExperienceByIdServlet extends HttpServlet {
    private ProjectExperienceDaoImpl projectExperienceDao = new ProjectExperienceDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        ProjectExperience projectExperience = projectExperienceDao.getProjectExperienceById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("projectExperience", projectExperience);

        // 转发到结果显示的 JSP 页面
        request.getRequestDispatcher("projectExperienceUpdateOrInsert.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
