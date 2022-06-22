package com.example.quan_ly_cong_viec.controller.duan;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/projects/new"})
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                List<NguoiDung> danhSachLeader = nguoiDungDAO.getDanhSachLeader();
                request.setAttribute("danhSachLeader", danhSachLeader);
                request.getRequestDispatcher( "../admin/views/project/new.jsp").forward(request, response);
                break;
            case "Leader":
                request.setAttribute("leader", authUtil.getNguoiDungFromCookie(request));
                request.getRequestDispatcher( "../leader/views/project/new.jsp").forward(request, response);
                break;
        }
    }
}
