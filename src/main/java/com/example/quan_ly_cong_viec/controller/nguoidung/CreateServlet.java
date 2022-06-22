package com.example.quan_ly_cong_viec.controller.nguoidung;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employees/create"})
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = new NguoiDung();
        AuthUtil authUtil = new AuthUtil();

        nguoiDung.setHoTen(request.getParameter("hoTen"));
        nguoiDung.setDiaChi(request.getParameter("diaChi"));
        nguoiDung.setSoDienThoai(request.getParameter("soDienThoai"));
        nguoiDung.setEmail(request.getParameter("email"));
        nguoiDung.setMatKhau(request.getParameter("matKhau"));
        nguoiDung.setPhanQuyen(phanQuyenDAO.getPhanQuyen(Integer.parseInt(request.getParameter("phanQuyen"))));
        nguoiDungDAO.creatNguoiDung(nguoiDung);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/employees");
                break;
        }
    }
}
