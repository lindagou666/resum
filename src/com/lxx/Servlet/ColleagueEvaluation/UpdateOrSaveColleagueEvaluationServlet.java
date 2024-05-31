package com.lxx.Servlet.ColleagueEvaluation;

import com.lxx.Bean.ColleagueEvaluation;
import com.lxx.Bean.User;
import com.lxx.dao.ColleagueEvaluationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrSaveColleagueEvaluationServlet")
public class UpdateOrSaveColleagueEvaluationServlet extends HttpServlet {
    private ColleagueEvaluationDaoImpl colleagueEvaluationDao = new ColleagueEvaluationDaoImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        request.getParameter("id");
        String id = request.getParameter("id");
        String companyName = request.getParameter("companyName");
        String describe = request.getParameter("describe");
        String leader = request.getParameter("leader");
        User user = (User) request.getSession().getAttribute("person");
//        创建对象
        ColleagueEvaluation colleagueEvaluation = new ColleagueEvaluation();
        colleagueEvaluation.setCompanyName(companyName);
        colleagueEvaluation.setLeader(leader);
        colleagueEvaluation.setDescribe(describe);
        colleagueEvaluation.setUid(user.getId());
//        如果id为null
        if (id.equals("")){
//            新增学生
            colleagueEvaluationDao.addEvaluation(colleagueEvaluation);
            request.setAttribute("success","操作成功");
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/SelectUpdateAllInfoServlet").forward(request,response);
            return;
        }

//        如果id不为null
        colleagueEvaluation.setId(Integer.valueOf(id));

        // 调用service 完成修改
        colleagueEvaluationDao.updateEvaluation(colleagueEvaluation);


        request.setAttribute("success","操作成功");
        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/SelectAllStudentServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
