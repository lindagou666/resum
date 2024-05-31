package com.lxx.Servlet.WorkExperience;

import com.lxx.Bean.WorkExperience;
import com.lxx.dao.WorkExperienceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectWorkExperienceByIdServlet")
public class SelectWorkExperienceByIdServlet extends HttpServlet {
    private WorkExperienceDaoImpl workExperienceDao = new WorkExperienceDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        WorkExperience workExperience = workExperienceDao.getWorkExperienceById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("workExperience", workExperience);

        request.getRequestDispatcher("workExperienceUpdateOrInsert.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
