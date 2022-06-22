package com.example.quan_ly_cong_viec.controller.congviec;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.ThongTinDuAnDAO;
import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
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

@WebServlet(urlPatterns = {"/tasks/create"})
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        ThongTinDuAn thongTinDuAn = new ThongTinDuAn();
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        thongTinDuAn.setDuAn(duAnDAO.getDuAn(Integer.parseInt(request.getParameter("idDuAn"))));
        thongTinDuAn.setNguoiDung(nguoiDungDAO.getNguoiDung(Integer.parseInt(request.getParameter("idNguoiDung"))));
        thongTinDuAn.setCongViec(request.getParameter("congViec"));
        thongTinDuAn.setTienDo(new BigDecimal(request.getParameter("tienDo")));
        thongTinDuAnDAO.creatThongTinDuAn(thongTinDuAn);
        //response.sendRedirect(request.getContextPath() + "/tasks");

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + request.getParameter("idDuAn"));
                break;
            case "Leader":
                response.sendRedirect(request.getContextPath() + "/projects/show?id=" + request.getParameter("idDuAn"));
                break;
        }
    }
}
