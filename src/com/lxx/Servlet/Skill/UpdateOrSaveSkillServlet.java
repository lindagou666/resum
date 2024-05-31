package com.lxx.Servlet.Skill;

import com.lxx.Bean.Skill;
import com.lxx.Bean.User;
import com.lxx.dao.SkillDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrSaveSkillServlet")
public class UpdateOrSaveSkillServlet extends HttpServlet {
    private SkillDaoImpl skillDao = new SkillDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String proficiency = request.getParameter("proficiency");
        User user = (User) request.getSession().getAttribute("person");


//        创建对象
        Skill skill = new Skill();
        skill.setName(name);
        skill.setUId(user.getId());
        skill.setProficiency(proficiency);
//        如果id为null
        if (id.equals("")){
            skillDao.addSkill(skill);
            request.setAttribute("success","操作成功");
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);

            return;
        }

//        如果id不为null
        skill.setId(Integer.valueOf(id));

        // 调用service 完成修改
        skillDao.updateSkill(skill);


        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
