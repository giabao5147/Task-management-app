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

@WebServlet(urlPatterns = {"/tasks/edit"})
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        ThongTinDuAn thongTinDuAn = null;
        AuthUtil authUtil = new AuthUtil();


        int idDuAn = Integer.parseInt(request.getParameter("idDuAn"));
        int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
        thongTinDuAn = thongTinDuAnDAO.getThongTinDuAn(duAnDAO.getDuAn(idDuAn), nguoiDungDAO.getNguoiDung(idNhanVien));
        request.setAttribute("thongTinDuAn", thongTinDuAn);
        request.setAttribute("tienDo", thongTinDuAn.getTienDo().toString());

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                request.getRequestDispatcher("../admin/views/task/edit.jsp").forward(request, response);
                break;
            case "Leader":
                request.getRequestDispatcher("../leader/views/task/edit.jsp").forward(request, response);
                break;
            case "Member":
                request.getRequestDispatcher("../member/views/task/edit.jsp").forward(request, response);
                break;
        }

    }
}
