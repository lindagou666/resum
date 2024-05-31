package com.lxx.Servlet.Honor;

import com.lxx.Bean.Honor;
import com.lxx.Bean.User;
import com.lxx.dao.HonorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrSaveHonorServlet")
public class UpdateOrSaveHonorServlet extends HttpServlet {
    private HonorDaoImpl honorDao = new HonorDaoImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");


        String id = request.getParameter("id");
        String honor = request.getParameter("honor");
        String time = request.getParameter("time");
        User user = (User) request.getSession().getAttribute("person");

//        创建对象
        Honor honor1 = new Honor();
        honor1.setHonor(honor);
        honor1.setUid(user.getId());
        honor1.setTime(time);
//        如果id为null
        if (id.equals("")){
            honorDao.addHonor(honor1);
            request.setAttribute("success","操作成功");
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);
            return;
        }

//        如果id不为null
        honor1.setId(Integer.valueOf(id));

        // 调用service 完成修改
        honorDao.updateHonor(honor1);


        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
