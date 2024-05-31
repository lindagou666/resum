package com.lxx.filter;

import com.lxx.Bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    private static List<String> allowedPages = new ArrayList<>();
    static {
        allowedPages.add("/code/login.jsp");
        allowedPages.add("/code/register.jsp");
        allowedPages.add("/code/recover.jsp");
        allowedPages.add("/code/myinfo.jsp");
        allowedPages.add("/code/checkCodeServlet");
        allowedPages.add("/code/SelectAllInfoServlet");
        allowedPages.add("/code/LoginServlet");
        allowedPages.add("/code/RecoverServlet");
        allowedPages.add("/code/RegisterServlet");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作，如果需要的话
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 设置请求编码为UTF-8
        req.setCharacterEncoding("UTF-8");

        // 设置响应编码为UTF-8
        res.setContentType("text/html;charset=UTF-8");
        String requestURI = req.getRequestURI();
        // 获取session和当前请求的URL
        User user = (User) req.getSession().getAttribute("person");
        if (requestURI.contains("/css") || requestURI.contains("/js")) {
            // 如果请求的是CSS或JS资源，直接放行
            chain.doFilter(request, response);
        } else {
            if  (user==null &&!allowedPages.contains(requestURI)){
                // 将用户重定向到登录页面，并设置提示信息
                res.sendRedirect(req.getContextPath() + "/login.jsp?failMsg=\"非法请求，请重新登录\"");
                return;
            }
        }
        // 如果用户已登录或访问的是允许的页面，放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 销毁操作，如果需要的话
    }
}
