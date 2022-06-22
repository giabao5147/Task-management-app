package com.example.quan_ly_cong_viec.controller.congviec;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.dao.ThongTinDuAnDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/tasks"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThongTinDuAn> thongTinDuAnList;
        ThongTinDuAnDAO thongTinDuAnDAO = new ThongTinDuAnDAO();
        AuthUtil authUtil = new AuthUtil();

        int id = Integer.parseInt(request.getParameter("id"));
        thongTinDuAnList = thongTinDuAnDAO.getDanhSachThongTinDuAnNhanVien(id);
        request.setAttribute("thongTinDuAnNhanVien", thongTinDuAnList);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Member":
                request.getRequestDispatcher("member/views/task/index.jsp").forward(request, response);
                break;
        }
    }

}
