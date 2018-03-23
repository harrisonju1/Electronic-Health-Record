package com.ex.dao;

import com.ex.beans.PatientProfile;
import com.ex.beans.Visit;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import com.ex.beans.Symptoms;

import java.util.List;

public class SymptomsDao {
    public Symptoms create(Symptoms symptom){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(symptom);
        symptom.setSymptomId(id);
        transaction.commit();

        session.close();
        return symptom;
    }

    public Symptoms update(Symptoms symptom){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(symptom);
        transaction.commit();

        session.close();
        return symptom;
    }

    public List<Symptoms> findBySymptomId(int symptomId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Symptoms> symptoms = (List<Symptoms>) session.createCriteria(Symptoms.class).add(Restrictions.eq("symptom_id", symptomId)).list();

        session.close();
        return symptoms;
    }

    public List<Symptoms> findByPatient(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Symptoms> symptoms = (List<Symptoms>) session.createCriteria(Symptoms.class)
                .add(Restrictions.eq("patient", profile)).list();

        session.close();
        return symptoms;
    }

    public List<Symptoms> findByVisit(Visit visit){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Symptoms> symptoms = (List<Symptoms>) session.createCriteria(Symptoms.class)
                .add(Restrictions.eq("visit", visit)).list();

        session.close();
        return symptoms;
    }

    public List<Symptoms> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Symptoms> symptoms = session.createCriteria(Symptoms.class).list();

        session.close();
        return symptoms;
    }

    public void delete(Symptoms symptom){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(symptom);
        session.flush();
        session.close();
    }
}
