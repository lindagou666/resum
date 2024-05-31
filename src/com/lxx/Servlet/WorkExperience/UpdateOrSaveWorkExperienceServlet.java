package com.lxx.Servlet.WorkExperience;

import com.lxx.Bean.User;
import com.lxx.Bean.WorkExperience;
import com.lxx.dao.WorkExperienceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrSaveWorkExperienceServlet")
public class UpdateOrSaveWorkExperienceServlet extends HttpServlet {
    private WorkExperienceDaoImpl workExperienceDao = new WorkExperienceDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");


        String id = request.getParameter("id");
        String companyName = request.getParameter("companyName");
        String jobName = request.getParameter("jobName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String describes = request.getParameter("describes");
        String address = request.getParameter("address");
        User user = (User) request.getSession().getAttribute("person");

//        创建对象
        WorkExperience workExperience = new WorkExperience();
        workExperience.setAddress(address);
        workExperience.setDescribes(describes);
        workExperience.setCompanyName(companyName);
        workExperience.setEndTime(endTime);
        workExperience.setStartTime(startTime);
        workExperience.setJobName(jobName);
        workExperience.setUId(user.getId());
//        如果id为null
        if (id.equals("")){
            workExperienceDao.addWorkExperience(workExperience);
            request.setAttribute("success","操作成功");
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);
            return;
        }

//        如果id不为null
        workExperience.setId(Integer.valueOf(id));

        // 调用service 完成修改
        workExperienceDao.updateWorkExperience(workExperience);


        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
