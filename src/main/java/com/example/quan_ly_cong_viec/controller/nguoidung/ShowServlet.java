package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employees/show"})
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("nguoiDung", nguoiDungDAO.getNguoiDung(id));

        String role = authUtil.getRole(request);
        switch (role) {
            case "Leader":
                request.getRequestDispatcher("../leader/views/employee/show.jsp").forward(request, response);
                break;
            case "Member":
                request.getRequestDispatcher("../member/views/employee/show.jsp").forward(request, response);
                break;
        }
    }

}
