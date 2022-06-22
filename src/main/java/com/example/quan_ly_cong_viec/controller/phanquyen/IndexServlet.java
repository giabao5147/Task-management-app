package com.example.quan_ly_cong_viec.controller.phanquyen;

import com.example.quan_ly_cong_viec.dao.PhanQuyenDAO;
import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/permission"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhanQuyen> phanQuyenList;
        PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
        AuthUtil authUtil = new AuthUtil();

        phanQuyenList = phanQuyenDAO.getDanhSachPhanQuyen();
        request.setAttribute("danhSachPhanQuyen", phanQuyenList);

        String role = authUtil.getRole(request);
        switch (role) {
            case "Admin":
                request.getRequestDispatcher("admin/views/permission/index.jsp").forward(request, response);
                break;
        }
    }

}
