package com.ex.dao;

import com.ex.beans.User;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao {

    //we're creating and closing a session for each dao command
    //session.save saves(creates) user in the database
    //once user is initialized in SQL, he gets a UserID which is set for internal use
    //close session and return user
    //we return user because we want the user object with userID value
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
    //We currently have 2 get by one which is userId and username so far
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

    //returns a list of all users
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
