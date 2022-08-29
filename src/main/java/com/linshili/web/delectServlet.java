package com.linshili.web;

import com.linshili.pojo.Brand;
import com.linshili.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delectServlet")
public class delectServlet extends HttpServlet {
    private BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        service.delectById(brand);
        request.getRequestDispatcher("/SelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
