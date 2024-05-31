package com.lxx.Servlet.Honor;

import com.lxx.Bean.Honor;
import com.lxx.dao.HonorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectHonorByIdServlet")
public class SelectHonorByIdServlet extends HttpServlet {
    private HonorDaoImpl honorDao = new HonorDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收id
        String id = request.getParameter("id");

        Honor honor = honorDao.getHonorById(Integer.parseInt(id));

        // 将结果存储到 request 对象中
        request.setAttribute("honor", honor);

        request.getRequestDispatcher("honorUpdateOrInsert.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
