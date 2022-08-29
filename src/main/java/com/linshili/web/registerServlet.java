package com.linshili.web;

import com.linshili.pojo.User;
import com.linshili.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取用户输入的验证码
        String checkCodegen = request.getParameter("checkCode");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Boolean register = service.register(user);
        //注册前检测验证码正确与否
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");

        if(!checkCode.equalsIgnoreCase(checkCodegen)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        if (register==true){
            request.setAttribute("register_msg","注册成功");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            request.setAttribute("register_msg","用户名存在,注册失败");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
