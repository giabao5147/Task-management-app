package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/employees/new"})
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
        AuthUtil authUtil = new AuthUtil();

        List<PhanQuyen> danhSachPhanQuyen = phanQuyenDAO.getDanhSachPhanQuyen();
        request.setAttribute("danhSachPhanQuyen", danhSachPhanQuyen);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                request.getRequestDispatcher( "../admin/views/employee/new.jsp").forward(request, response);
                break;
        }

    }
}
