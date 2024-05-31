package com.lxx.Servlet.Skill;

import com.lxx.Bean.Skill;
import com.lxx.dao.SkillDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectSkillByIdServlet")
public class SelectSkillByIdServlet extends HttpServlet {
    private SkillDaoImpl skillDao = new SkillDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        Skill skill = skillDao.getSkillById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("skill", skill);

        request.getRequestDispatcher("skillUpdateOrInsert.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
