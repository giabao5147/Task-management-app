package com.example.quan_ly_cong_viec.dao;

import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DuAnDAO {
    public void creatDuAn(DuAn duAn) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(duAn);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public DuAn getDuAn(int id) {
        DuAn duAn = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        duAn = session.get(DuAn.class, id);
        session.close();
        return duAn;
    }

    public List<DuAn> getDanhSachDuAN() {
        List<DuAn> duAnList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM DuAn ");
        duAnList = query.getResultList();
        session.close();
        return duAnList;

    }

    public List<DuAn> getDanhSachDuAnLeader(int idLeader) {
        List<DuAn> duAnList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM DuAn d WHERE d.leader.id = :idLeader");
        query.setParameter("idLeader", idLeader);
        duAnList = query.getResultList();
        session.close();
        return duAnList;
    }

    public void updateDuAn(DuAn duAn) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(duAn);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void deleteDuAn(int id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            DuAn duAn = session.get(DuAn.class, id);
            if (duAn != null) {
                session.delete(duAn);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
