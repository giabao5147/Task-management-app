package com.example.quan_ly_cong_viec.controller.congviec;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.ThongTinDuAnDAO;
import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/tasks/update"})
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        ThongTinDuAn thongTinDuAn = null;
        AuthUtil authUtil = new AuthUtil();

        int idDuAn = Integer.parseInt(request.getParameter("idDuAn"));
        int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
        thongTinDuAn = thongTinDuAnDAO.getThongTinDuAn(duAnDAO.getDuAn(idDuAn), nguoiDungDAO.getNguoiDung(idNhanVien));
        thongTinDuAn.setCongViec(request.getParameter("congViec"));
        thongTinDuAn.setTienDo(new BigDecimal(request.getParameter("tienDo")));
        thongTinDuAnDAO.updateThongTinDuAn(thongTinDuAn);
        //response.sendRedirect(request.getContextPath() + "/tasks");

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + idDuAn);
                break;
            case "Leader":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + request.getParameter("idDuAn"));
                break;
            case "Member":
                response.sendRedirect(request.getContextPath() + "/tasks?id=" + authUtil.getNguoiDungFromCookie(request).getId());
                break;
        }
    }
}
