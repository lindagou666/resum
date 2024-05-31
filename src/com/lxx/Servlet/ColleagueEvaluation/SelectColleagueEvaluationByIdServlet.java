package com.lxx.Servlet.ColleagueEvaluation;

import com.lxx.Bean.ColleagueEvaluation;
import com.lxx.dao.ColleagueEvaluationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectColleagueEvaluationByIdServlet")
public class SelectColleagueEvaluationByIdServlet extends HttpServlet {
    private ColleagueEvaluationDaoImpl colleagueEvaluationDao = new ColleagueEvaluationDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        ColleagueEvaluation colleagueEvaluation = colleagueEvaluationDao.getEvaluationById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("colleagueEvaluation", colleagueEvaluation);

        request.getRequestDispatcher("colleagueEvaluationUpdateOrInsert.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
