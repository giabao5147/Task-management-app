package com.example.quan_ly_cong_viec.dao;

import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class NguoiDungDAO {
    public void creatNguoiDung (NguoiDung nguoiDung) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(nguoiDung);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public NguoiDung getNguoiDung(int id) {
        NguoiDung nguoiDung = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        nguoiDung = session.get(NguoiDung.class, id);
        session.close();
        return nguoiDung;
    }

    public List<NguoiDung> getDanhSachNguoiDung() {
        List<NguoiDung> nguoiDungList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM NguoiDung");
        nguoiDungList = query.getResultList();
        session.close();
        return nguoiDungList;

    }

    public List<NguoiDung> getDanhSachLeader() {
        List<NguoiDung> leaderList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM NguoiDung nd WHERE nd.phanQuyen.id = 2");
        leaderList = query.getResultList();
        session.close();
        return leaderList;
    }

    public List<NguoiDung> getDanhSachMember() {
        List<NguoiDung> memberList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM NguoiDung nd WHERE nd.phanQuyen.id = 3");
        memberList = query.getResultList();
        session.close();
        return memberList;
    }


    public void updateNguoiDung(NguoiDung nguoiDung) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(nguoiDung);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void deleteNguoiDung(int id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            NguoiDung nguoiDung = session.get(NguoiDung.class, id);
            if (nguoiDung != null) {
                session.delete(nguoiDung);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public boolean isTokenValid(int idNguoiDung, String token) {

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM NguoiDung n WHERE n.id = :id AND n.token = :token");
        query.setParameter("id", idNguoiDung);
        query.setParameter("token", token);

        List<NguoiDung> result = query.getResultList();
        if (result.size() > 0) {
            return true;
        }
        return false;
    }
}
