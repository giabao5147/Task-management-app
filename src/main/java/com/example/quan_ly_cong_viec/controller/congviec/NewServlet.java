package com.example.quan_ly_cong_viec.controller.congviec;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.ThongTinDuAnDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/tasks/new"})
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        DuAnDAO duAnDAO = new DuAnDAO();
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        AuthUtil authUtil = new AuthUtil();

        int idDuAn = Integer.parseInt(request.getParameter("idDuAn"));
        request.setAttribute("duAn", duAnDAO.getDuAn(idDuAn));
        request.setAttribute("danhSachNhanVien", nguoiDungDAO.getDanhSachMember());

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                request.getRequestDispatcher( "../admin/views/task/new.jsp").forward(request, response);
                break;
            case "Leader":
                request.getRequestDispatcher( "../leader/views/task/new.jsp").forward(request, response);
                break;
        }
    }
}
