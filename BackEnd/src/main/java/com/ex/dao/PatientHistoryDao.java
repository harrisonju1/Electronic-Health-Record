package com.ex.dao;

import com.ex.beans.PatientHistory;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import java.util.List;

public class PatientHistoryDao {
    public PatientHistory create(PatientHistory history){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(history);
        history.setPatientId(id);
        transaction.commit();

        session.close();
        return history;
    }

    public PatientHistory update(PatientHistory history){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(history);
        transaction.commit();

        session.close();
        return history;
    }

    public PatientHistory findOneByPatientId(int patientId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientHistory history = (PatientHistory) session.get(PatientHistory.class, patientId);

        session.close();
        return history;
    }

    public PatientHistory findOneByDoctorId(int doctorId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientHistory history = (PatientHistory) session.get(PatientHistory.class, doctorId);

        session.close();
        return history;
    }

    public PatientHistory findOneByHistoryId(int historyId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientHistory history = (PatientHistory) session.get(PatientHistory.class, historyId);

        session.close();
        return history;
    }

    public List<PatientHistory> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<PatientHistory> profiles = session.createCriteria(PatientHistory.class).list();

        session.close();
        return profiles;
    }

    public void delete(PatientHistory history){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(history);
        session.flush();
        session.close();
    }
}
