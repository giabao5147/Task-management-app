package com.example.quan_ly_cong_viec.dao;

import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
import com.example.quan_ly_cong_viec.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ThongTinDuAnDAO {
    public void creatThongTinDuAn(ThongTinDuAn thongTinDuAn) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(thongTinDuAn);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public ThongTinDuAn getThongTinDuAn(DuAn duAn, NguoiDung nguoiDung) {
        ThongTinDuAn thongTinDuAn = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        thongTinDuAn = session.get(ThongTinDuAn.class, new ThongTinDuAn(duAn, nguoiDung));
        session.close();
        return thongTinDuAn;
    }

    public List<ThongTinDuAn> getDanhSachThongTinDuAnNhanVien(int id) {
        List<ThongTinDuAn> thongTinDuAnList = null;

        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("FROM ThongTinDuAn t WHERE t.nguoiDung.id = :id");
        query.setParameter("id", id);
        thongTinDuAnList = query.getResultList();
        session.close();
        return thongTinDuAnList;

    }


    public void updateThongTinDuAn(ThongTinDuAn thongTinDuAn) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(thongTinDuAn);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void deleteThongTinDuAn(DuAn duAn, NguoiDung nguoiDung) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ThongTinDuAn thongTinDuAn = session.get(ThongTinDuAn.class, new ThongTinDuAn(duAn, nguoiDung));
            if (thongTinDuAn != null) {
                session.delete(thongTinDuAn);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

}
