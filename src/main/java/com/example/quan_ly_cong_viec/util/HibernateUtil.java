package com.example.quan_ly_cong_viec.util;

import com.example.quan_ly_cong_viec.model.DuAn;
import com.example.quan_ly_cong_viec.model.NguoiDung;
import com.example.quan_ly_cong_viec.model.PhanQuyen;
import com.example.quan_ly_cong_viec.model.ThongTinDuAn;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL,"jdbc:mysql://localhost:3307/crm");
        properties.put(Environment.USER,"root");
        properties.put(Environment.PASS,"admin");
        properties.put(Environment.SHOW_SQL,"true");
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(DuAn.class);
        configuration.addAnnotatedClass(NguoiDung.class);
        configuration.addAnnotatedClass(PhanQuyen.class);
        configuration.addAnnotatedClass(ThongTinDuAn.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        FACTORY = configuration.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
