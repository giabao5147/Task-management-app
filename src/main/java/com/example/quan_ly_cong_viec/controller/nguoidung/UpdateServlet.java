package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employees/update"})
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
        AuthUtil authUtil = new AuthUtil();
        NguoiDung nguoiDung = null;

        nguoiDung = nguoiDungDAO.getNguoiDung(Integer.parseInt(request.getParameter("id")));
        nguoiDung.setHoTen(request.getParameter("hoTen"));
        nguoiDung.setDiaChi(request.getParameter("diaChi"));
        nguoiDung.setSoDienThoai(request.getParameter("soDienThoai"));
        nguoiDung.setEmail(request.getParameter("email"));
        nguoiDung.setMatKhau(request.getParameter("matKhau"));
        nguoiDung.setPhanQuyen(phanQuyenDAO.getPhanQuyen(Integer.parseInt(request.getParameter("phanQuyen"))));
        nguoiDungDAO.updateNguoiDung(nguoiDung);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/employees");
                break;
            case "Leader":
                response.sendRedirect(request.getContextPath() +"/employees/show?id=" + authUtil.getNguoiDungFromCookie(request).getId());
                break;
            case "Member":
                response.sendRedirect(request.getContextPath() +"/employees/show?id=" + authUtil.getNguoiDungFromCookie(request).getId());
        }
    }
}
