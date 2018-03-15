package com.ex.dao;

import com.ex.beans.Treatments;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TreatmentsDao {
    public Treatments create(Treatments treatment){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(treatment);
        treatment.setTreatmentId(id);
        transaction.commit();

        session.close();
        return treatment;
    }

    public Treatments update(Treatments treatment){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(treatment);
        transaction.commit();

        session.close();
        return treatment;
    }

    public List<Treatments> findByTreatmentId(int treatmentId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Treatments> treatments = (List<Treatments>) session.createCriteria(Treatments.class).add(Restrictions.eq("treatment_id", treatmentId)).list();

        session.close();
        return treatments;
    }

    public List<Treatments> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Treatments> treatments = session.createCriteria(Treatments.class).list();

        session.close();
        return treatments;
    }

    public void delete(Treatments treatment){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(treatment);
        session.flush();
        session.close();
    }
}
