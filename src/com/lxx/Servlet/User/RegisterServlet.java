package com.lxx.Servlet.User;

import com.lxx.Bean.User;
import com.lxx.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String hobby = request.getParameter("hobby");
        String code = request.getParameter("code");
        String code1 = (String) request.getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(code1)){
            request.setAttribute("failMsg","验证码错误！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setAge(Integer.valueOf(age));
        user.setPassword(password);
        user.setPhone(phone);
        user.setHobby(hobby);

        User user1 = userDao.getUserByUsername(username);
        if (user1!=null){
            request.setAttribute("failMsg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        userDao.addUser(user);
        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
