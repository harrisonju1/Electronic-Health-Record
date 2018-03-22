package com.ex.dao;

import com.ex.beans.Diagnosis;
import com.ex.beans.PatientProfile;
import com.ex.beans.Visit;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DiagnosisDao {
    public Diagnosis create(Diagnosis diagnosis){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(diagnosis);
        diagnosis.setDiagnosisId(id);
        transaction.commit();

        session.close();
        return diagnosis;
    }

    public Diagnosis update(Diagnosis diagnosis){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(diagnosis);
        transaction.commit();

        session.close();
        return diagnosis;
    }

    public List<Diagnosis> findByDiagnosisId(int diagnosisId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Diagnosis> diagnosis = (List<Diagnosis>) session.createCriteria(Diagnosis.class).add(Restrictions.eq("diagnosis_id", diagnosisId)).list();

        session.close();
        return diagnosis;
    }

    public List<Diagnosis> findByPatient(PatientProfile patient){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Diagnosis> diagnosis = (List<Diagnosis>) session.createCriteria(Diagnosis.class).add(Restrictions.eq("patient", patient)).list();

        session.close();
        return diagnosis;
    }

    public Diagnosis findByVisit(Visit visit){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Diagnosis diagnosis = (Diagnosis) session.createCriteria(Diagnosis.class).add(Restrictions.eq("visit", visit));
        return diagnosis;
    }

    public List<Diagnosis> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Diagnosis> diagnosis = session.createCriteria(Diagnosis.class).list();

        session.close();
        return diagnosis;
    }

    public void delete(Diagnosis diagnosis){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(diagnosis);
        session.flush();
        session.close();
    }
}
