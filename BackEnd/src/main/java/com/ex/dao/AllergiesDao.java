package com.ex.dao;

import com.ex.beans.Allergies;
import com.ex.util.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AllergiesDao {
    public Allergies create(Allergies allergy){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(allergy);
        allergy.setAllergyId(id);
        transaction.commit();

        session.close();
        return allergy;
    }

    public Allergies update(Allergies allergy){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(allergy);
        transaction.commit();

        session.close();
        return allergy;
    }

    public List<Allergies> findByPatientId(int patientId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Allergies> allergies = (List<Allergies>) session.createCriteria(Allergies.class).add(Restrictions.eq("patient_id", patientId)).list();

        session.close();
        return allergies;
    }

    public List<Allergies> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Allergies> allergies = session.createCriteria(Allergies.class).list();

        session.close();
        return allergies;
    }

    public void delete(Allergies allergy){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(allergy);
        session.flush();
        session.close();
    }
}
