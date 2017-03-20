package com.podd.WeatherTracker.dao;


import com.podd.WeatherTracker.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class BaseDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected Session getActiveSession() {
        Session session = sessionFactory.openSession();
        return session;
    }
}
