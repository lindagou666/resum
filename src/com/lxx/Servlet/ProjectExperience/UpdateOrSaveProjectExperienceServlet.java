package com.lxx.Servlet.ProjectExperience;

import com.lxx.Bean.ProjectExperience;
import com.lxx.Bean.User;
import com.lxx.dao.ProjectExperienceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrSaveProjectExperienceServlet")
public class UpdateOrSaveProjectExperienceServlet extends HttpServlet {
    private ProjectExperienceDaoImpl projectExperienceDao = new ProjectExperienceDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");


        String id = request.getParameter("id");
        String projectName = request.getParameter("projectName");
        String describes = request.getParameter("describes");
        User user = (User) request.getSession().getAttribute("person");

//        创建对象
        ProjectExperience projectExperience = new ProjectExperience();
        projectExperience.setProjectName(projectName);
        projectExperience.setDescribes(describes);
        projectExperience.setUid(user.getId());
//        如果id为null
        if (id.equals("")){
            projectExperienceDao.addProjectExperience(projectExperience);
            request.setAttribute("success","操作成功");
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);

            return;
        }

//        如果id不为null
        projectExperience.setId(Integer.valueOf(id));

        // 调用service 完成修改
        projectExperienceDao.updateProjectExperience(projectExperience);


        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
