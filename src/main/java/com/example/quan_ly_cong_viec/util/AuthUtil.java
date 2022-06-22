package com.example.quan_ly_cong_viec.util;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.model.NguoiDung;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthUtil {
    public NguoiDung getNguoiDungFromCookie(HttpServletRequest request) {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = null;
        int idNguoiDung = 0;
        String token = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("idNguoiDung".equals(cookie.getName())) {
                    idNguoiDung = Integer.parseInt(cookie.getValue());
                }
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
            if (nguoiDungDAO.isTokenValid(idNguoiDung, token)) {
                nguoiDung = nguoiDungDAO.getNguoiDung(idNguoiDung);
            }
        }
        return nguoiDung;
    }

    public String getRole(HttpServletRequest request) {
        NguoiDung nguoiDung = null;
        String role = "None";

        nguoiDung = getNguoiDungFromCookie(request);
        if (nguoiDung != null) {
            role = nguoiDung.getPhanQuyen().getTenPhanQuyen();
        }
        return role;
    }
}
