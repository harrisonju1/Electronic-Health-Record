package com.ex.dao;

import com.ex.beans.PatientProfile;
import com.ex.beans.Visit;
import com.ex.beans.VisitInfo;
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

    public List<Visit> findByPatientId(PatientProfile patient_info){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Visit> visits = (List<Visit>) session.createCriteria(Visit.class)
                .add(Restrictions.eq("patient", patient_info)).list();
        session.close();
        return visits;
    }

    public Visit findByVisitId(int visit_id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Visit visit = (Visit) session.get(Visit.class, visit_id);

        session.close();
        return visit;
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
