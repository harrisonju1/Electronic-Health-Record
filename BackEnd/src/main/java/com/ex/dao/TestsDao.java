package com.ex.dao;

import com.ex.beans.PatientProfile;
import com.ex.beans.Tests;
import com.ex.beans.Visit;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TestsDao {
    public Tests create(Tests test){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(test);
        test.setTestId(id);
        transaction.commit();

        session.close();
        return test;
    }

    public Tests update(Tests test){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(test);
        transaction.commit();

        session.close();
        return test;
    }

    public List<Tests> findByTestId(int testId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Tests> tests = (List<Tests>) session.createCriteria(Tests.class).add(Restrictions.eq("test_id", testId)).list();

        session.close();
        return tests;
    }

    public List<Tests> findByPatient(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Tests> tests = (List<Tests>) session.createCriteria(Tests.class).add(Restrictions.eq("patient", profile)).list();

        session.close();
        return tests;
    }

    public List<Tests> findByVisit(Visit visit){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Tests> tests = (List<Tests>) session.createCriteria(Tests.class).
                add(Restrictions.eq("visit", visit)).list();

        session.close();
        return tests;
    }

    public List<Tests> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Tests> tests = session.createCriteria(Tests.class).list();

        session.close();
        return tests;
    }

    public void delete(Tests test){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(test);
        session.flush();
        session.close();
    }
}
