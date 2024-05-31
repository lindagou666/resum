package com.lxx.Servlet.User;

import com.lxx.Bean.User;
import com.lxx.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RecoverServlet")
public class RecoverServlet extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String code1 = (String) request.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(code1)){
            request.setAttribute("failMsg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        User user = userDao.getUserByUsername(username);
        if (user==null) {
            request.setAttribute("failMsg","用户不存在！");
            request.getRequestDispatcher("/recover.jsp").forward(request,response);
            return;
        }
        if (!phone.equalsIgnoreCase(user.getPhone())) {
            request.setAttribute("failMsg","手机号不正确！");
            request.getRequestDispatcher("/recover.jsp").forward(request,response);
            return;
        }
//          修改成功
        user.setPassword(password);
        userDao.updateUser(user);
        request.setAttribute("success","修改成功 ！");
        request.getRequestDispatcher("/recover.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
