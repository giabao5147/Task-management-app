package com.example.quan_ly_cong_viec.controller.congviec;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.ThongTinDuAnDAO;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/tasks/destroy"})
public class DestroyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        int idDuAn = Integer.parseInt(request.getParameter("idDuAn"));
        int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
        thongTinDuAnDAO.deleteThongTinDuAn(duAnDAO.getDuAn(idDuAn), nguoiDungDAO.getNguoiDung(idNhanVien));
        //response.sendRedirect(request.getContextPath() + "/projects");

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + idDuAn);
                break;
            case "Leader":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + idDuAn);
                break;
        }
    }

}
