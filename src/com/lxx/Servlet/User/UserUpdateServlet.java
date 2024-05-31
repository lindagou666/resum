package com.lxx.Servlet.User;

import com.lxx.Bean.User;
import com.lxx.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String hobby = request.getParameter("hobby");
        String sex = request.getParameter("sex");
        String jobName = request.getParameter("jobName");
        String education = request.getParameter("education");
        String schoolName = request.getParameter("schoolName");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setAge(Integer.valueOf(age));
        user.setPassword(password);
        user.setPhone(phone);
        user.setHobby(hobby);
        user.setName(name);
        user.setEducation(education);
        user.setSex(sex);
        user.setJobName(jobName);
        user.setSchoolName(schoolName);

        // 调用service 完成修改
        userDao.updateUser(user);
        request.getSession().setAttribute("person",user);
        request.setAttribute("userByUsername", user);

        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
