package com.example.quan_ly_cong_viec.controller.authentication;

import com.example.quan_ly_cong_viec.dao.DangNhapDAO;
import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthUtil authUtil = new AuthUtil();
        NguoiDung nguoiDung = null;

        nguoiDung = authUtil.getNguoiDungFromCookie(request);
        if (nguoiDung != null) {
            String role = nguoiDung.getPhanQuyen().getTenPhanQuyen();
            switch (role) {
                case "Admin":
                    response.sendRedirect(request.getContextPath() + "/employees");
                    break;
                case "Leader":
                    response.sendRedirect(request.getContextPath() + "/projects");
                    break;
                case "Member":
                    response.sendRedirect(request.getContextPath() + "/tasks?id=" + authUtil.getNguoiDungFromCookie(request).getId());
                    break;
            }
        }
        else {
            request.getRequestDispatcher("login/views/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        NguoiDung nguoiDung = null;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        nguoiDung = dangNhapDAO.checkLogin(email, password);
        if (nguoiDung != null) {
            String newToken = createToken();
            Cookie idNguoiDung = new Cookie("idNguoiDung", String.valueOf(nguoiDung.getId()));
            Cookie token = new Cookie("token", newToken);
            idNguoiDung.setMaxAge(60*60);
            token.setMaxAge(60*60);
            response.addCookie(idNguoiDung);
            response.addCookie(token);

            nguoiDung.setToken(newToken);
            nguoiDungDAO.updateNguoiDung(nguoiDung);

            switch (nguoiDung.getPhanQuyen().getTenPhanQuyen()) {
                case "Admin":
                    response.sendRedirect(request.getContextPath() + "/employees");
                    break;
                case "Leader":
                    response.sendRedirect(request.getContextPath() + "/projects");
                    break;
                case "Member":
                    response.sendRedirect(request.getContextPath() + "/tasks?id=" + nguoiDung.getId());
                    break;
            }
        }
        else {
            doGet(request, response);
        }
    }

    private String createToken() {
        int length = 10;
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder();

        String alphaNumeric = upperAlphabet + numbers;
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

}
