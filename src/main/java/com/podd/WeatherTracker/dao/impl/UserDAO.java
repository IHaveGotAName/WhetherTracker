package com.podd.WeatherTracker.dao.impl;

import com.podd.WeatherTracker.dao.BaseDAO;
import com.podd.WeatherTracker.dao.api.CrudDAO;
import com.podd.WeatherTracker.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class UserDAO extends BaseDAO implements CrudDAO<User> {
    private static UserDAO userDAO = null;
    public static UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }
    @Override
    public User findById(int id) {
        User user;
        Session session = getActiveSession();
        user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        System.out.println(user);
        return user;
    }


    @Override
    public List<User> findAll() {
        Session session = null;
        List user = new ArrayList<User>();
        try {
            session = getActiveSession();
            user = session.createCriteria(User.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public void create(User user) {
        Session session = getActiveSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Override
    public void update(User user) {
        Session session = getActiveSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(User user) {
        Session session = getActiveSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public User findByLoginPassword(String login, String password) {
        User user;
        Session session = getActiveSession();
        user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
        System.out.println(user);
        return user;
    }

    public boolean checkLoginToEquals(String login) {
        User user;
        Session session = getActiveSession();
        user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        System.out.println(user);
        if (user != null) {
            return true;
        } else {
            return false;
        }

    }
}

