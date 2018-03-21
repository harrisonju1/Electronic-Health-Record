package com.ex.dao;

import com.ex.beans.PatientProfile;
import com.ex.beans.Prescriptions;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PrescriptionsDao {
    public Prescriptions create(Prescriptions prescription){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(prescription);
        prescription.setPrescriptionId(id);
        transaction.commit();

        session.close();
        return prescription;
    }

    public Prescriptions update(Prescriptions prescription){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(prescription);
        transaction.commit();

        session.close();
        return prescription;
    }

    public List<Prescriptions> findByPrescriptionsId(int prescriptionId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Prescriptions> prescription = (List<Prescriptions>) session.createCriteria(Prescriptions.class).add(Restrictions.eq("prescription_id", prescriptionId)).list();

        session.close();
        return prescription;
    }

    public List<Prescriptions> findByPatient(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Prescriptions> prescription = (List<Prescriptions>) session.createCriteria(Prescriptions.class).add(Restrictions.eq("patient", profile)).list();

        session.close();
        return prescription;
    }

    public List<Prescriptions> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Prescriptions> prescriptions = session.createCriteria(Prescriptions.class).list();

        session.close();
        return prescriptions;
    }

    public void delete(Prescriptions prescription){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(prescription);
        session.flush();
        session.close();
    }
}
