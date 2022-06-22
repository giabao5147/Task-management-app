package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/employees"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NguoiDung> nguoiDungList;
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                nguoiDungList = nguoiDungDAO.getDanhSachNguoiDung();
                request.setAttribute("danhSachNguoiDung", nguoiDungList);
                request.getRequestDispatcher("admin/views/employee/index.jsp").forward(request, response);
                break;
            case "Leader":
                nguoiDungList = nguoiDungDAO.getDanhSachMember();
                request.setAttribute("danhSachNguoiDung", nguoiDungList);
                request.getRequestDispatcher("leader/views/employee/index.jsp").forward(request, response);
                break;
        }
    }

}
