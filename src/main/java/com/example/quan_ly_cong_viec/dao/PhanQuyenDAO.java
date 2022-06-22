package com.example.quan_ly_cong_viec.dao;

import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PhanQuyenDAO {
    public void creatPhanQuyen (PhanQuyen phanQuyen) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(phanQuyen);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public PhanQuyen getPhanQuyen(int id) {
        PhanQuyen phanQuyen = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        phanQuyen = session.get(PhanQuyen.class, id);
        session.close();
        return phanQuyen;
    }

    public List<PhanQuyen> getDanhSachPhanQuyen() {
        List<PhanQuyen> phanQuyenList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM PhanQuyen ");
        phanQuyenList = query.getResultList();
        session.close();
        return phanQuyenList;
    }


    public void updatePhanQuyen(PhanQuyen phanQuyen) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(phanQuyen);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void deletePhanQuyen(int id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            PhanQuyen phanQuyen = session.get(PhanQuyen.class, id);
            if (phanQuyen != null) {
                session.delete(phanQuyen);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
