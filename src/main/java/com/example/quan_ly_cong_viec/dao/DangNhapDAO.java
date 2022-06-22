package com.example.quan_ly_cong_viec.dao;

import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.List;

public class DangNhapDAO {
    public NguoiDung checkLogin(String email, String password) {
        NguoiDung nguoiDung = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM NguoiDung n WHERE n.email = :email AND n.matKhau = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<NguoiDung> result = query.getResultList();
        for (NguoiDung nd : result) {
            nguoiDung = nd;
        }
        session.close();
        return nguoiDung;
    }
}
