package com.example.quan_ly_cong_viec.controller.duan;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/projects/update"})
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();
        DuAn duAn = null;

        duAn = duAnDAO.getDuAn(Integer.parseInt(request.getParameter("id")));
        duAn.setTenDuAn(request.getParameter("tenDuAn"));
        duAn.setLeader(nguoiDungDAO.getNguoiDung(Integer.parseInt(request.getParameter("idLeader"))));
        duAn.setTrangThai(request.getParameter("trangThai"));
        duAn.setTienDo(new BigDecimal(request.getParameter("tienDo")));
        try {
            duAn.setNgayBatDau(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngayBatDau")));
            duAn.setNgayKetThuc(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngayKetThuc")));
        } catch (ParseException e) {
            duAn.setNgayBatDau(duAnDAO.getDuAn(Integer.parseInt(request.getParameter("id"))).getNgayBatDau());
            duAn.setNgayKetThuc(duAnDAO.getDuAn(Integer.parseInt(request.getParameter("id"))).getNgayKetThuc());
        }
        duAnDAO.updateDuAn(duAn);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/projects");
                break;
            case "Leader":
                response.sendRedirect(request.getContextPath() + "/projects");
                break;
        }
    }
}
