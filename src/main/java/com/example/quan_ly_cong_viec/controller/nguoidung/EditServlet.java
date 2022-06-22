package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employees/edit"})
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
        AuthUtil authUtil = new AuthUtil();

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("nguoiDung", nguoiDungDAO.getNguoiDung(id));

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                request.setAttribute("danhSachPhanQuyen", phanQuyenDAO.getDanhSachPhanQuyen());
                request.getRequestDispatcher("../admin/views/employee/edit.jsp").forward(request, response);
                break;
            case "Leader":
                request.getRequestDispatcher("../leader/views/employee/edit.jsp").forward(request, response);
                break;
            case "Member":
                request.getRequestDispatcher("../member/views/employee/edit.jsp").forward(request, response);
                break;
        }
    }
}
