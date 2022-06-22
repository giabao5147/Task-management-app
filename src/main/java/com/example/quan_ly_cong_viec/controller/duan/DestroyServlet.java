package com.example.quan_ly_cong_viec.controller.duan;

import com.example.quan_ly_cong_viec.dao.DuAnDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/projects/destroy"})
public class DestroyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DuAnDAO duAnDAO = new DuAnDAO();
        AuthUtil authUtil = new AuthUtil();

        int id = Integer.parseInt(request.getParameter("id"));
        duAnDAO.deleteDuAn(id);

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
