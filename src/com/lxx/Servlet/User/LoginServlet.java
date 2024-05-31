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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
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
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        if (password.equals("")){
            request.getSession().setAttribute("username",username);

            request.getRequestDispatcher("/SelectAllInfoServlet").forward(request,response);
            return;
        }
        if (user.getPassword().equals(password)){
            if (rememberMe != null && rememberMe.equals("true")) {
                Cookie cookieUsername = new Cookie("username", username);
                Cookie cookiePASSWORD = new Cookie("password", password);
                cookieUsername.setMaxAge(60 * 60 * 24 * 7); // 设置Cookie的有效期为7天
                cookiePASSWORD.setMaxAge(60 * 60 * 24 * 7); // 设置Cookie的有效期为7天
                response.addCookie(cookieUsername);
                response.addCookie(cookiePASSWORD);
            }
//            登陆成功
            request.getSession().setAttribute("person",user);
            request.getRequestDispatcher("/SelectAllInfoServlet").forward(request,response);

            return;
        }

        request.setAttribute("failMsg","用户名密码错误！");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
