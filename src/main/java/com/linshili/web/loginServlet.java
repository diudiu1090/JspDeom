package com.linshili.web;

import com.linshili.pojo.User;
import com.linshili.service.BrandService;
import com.linshili.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框
        String remember = request.getParameter("remember");

        User user = service.login(username, password);
        if (user != null) {
            if("1".equals(remember)){
                Cookie usernames = new Cookie("username",username);//这两行才是cookie.String.value中的String
                Cookie passwords = new Cookie("password",password);
                usernames.setMaxAge(604800);
                passwords.setMaxAge(604800);

                response.addCookie(usernames);
                response.addCookie(passwords);

            }
            String contextPath = request.getContextPath();
            //登录成功，重定向跳转页面因为重定向所以数据不共享所以要把数据存储到Cookie或者Session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(contextPath + "/SelectAllServlet");
        } else {
            //登陆失败
            request.setAttribute("login_msg","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
