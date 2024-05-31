package com.lxx.Servlet.Skill;

import com.lxx.dao.SkillDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSkillServlet")
public class DeleteSkillServlet extends HttpServlet {
    private SkillDaoImpl skillDao = new SkillDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");


        skillDao.deleteSkill(Integer.parseInt(id));

        request.setAttribute("success","操作成功");

        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
