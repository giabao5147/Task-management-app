package com.example.quan_ly_cong_viec.filter;

import com.example.quan_ly_cong_viec.dao.NguoiDungDAO;
import com.example.quan_ly_cong_viec.util.AuthUtil;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        AuthUtil authUtil = new AuthUtil();

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (authUtil.getNguoiDungFromCookie(servletRequest) != null) {
            chain.doFilter(request, response);
        }
        else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}
