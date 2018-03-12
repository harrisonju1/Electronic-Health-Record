package com.ex.dao;

import com.ex.beans.User;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao {

    public User create(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(user);
        user.setId(id);
        transaction.commit();

        session.close();
        return user;
    }
    public User update(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);
        transaction.commit();

        session.close();
        return user;
    }
    public User findOne(int userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        User user = (User) session.get(User.class, userId);

        session.close();
        return user;
    }
    public User findOne(String username) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();

        session.close();
        return user;
    }
    public List<User> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<User> users = session.createCriteria(User.class).list();

        session.close();
        return users;
    }
    public void delete(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(user);
        session.flush();
        session.close();
    }
}
