package com.ex.dao;

import com.ex.beans.PatientProfile;
import com.ex.beans.Visit;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class VisitDao {
    public Visit create(Visit visits){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(visits);
        visits.setVisitId(id);
        transaction.commit();

        session.close();
        return visits;
    }

    public Visit update(Visit visits){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(visits);
        transaction.commit();

        session.close();
        return visits;
    }

    public List<Visit> findByPatientId(PatientProfile patient){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Visit> allergies = (List<Visit>) session.createCriteria(Visit.class).add(Restrictions.eq("patient_id", patient)).list();

        session.close();
        return allergies;
    }

    public List<Visit> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Visit> visits = session.createCriteria(Visit.class).list();

        session.close();
        return visits;
    }

    public void delete(Visit visits){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(visits);
        session.flush();
        session.close();
    }

}
