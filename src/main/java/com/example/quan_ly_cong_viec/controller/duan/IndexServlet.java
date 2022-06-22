package com.example.quan_ly_cong_viec.controller.duan;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/projects"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DuAn> duAnList;
        DuAnDAO duAnDAO = new DuAnDAO();
        AuthUtil authUtil = new AuthUtil();

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                duAnList = duAnDAO.getDanhSachDuAN();
                request.setAttribute("danhSachDuAn", duAnList);
                request.getRequestDispatcher("admin/views/project/index.jsp").forward(request, response);
                break;
            case "Leader":
                duAnList = duAnDAO.getDanhSachDuAnLeader(authUtil.getNguoiDungFromCookie(request).getId());
                request.setAttribute("danhSachDuAn", duAnList);
                request.getRequestDispatcher("leader/views/project/index.jsp").forward(request, response);
                break;
        }

    }

}
