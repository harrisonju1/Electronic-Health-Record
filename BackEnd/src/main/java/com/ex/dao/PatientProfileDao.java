package com.ex.dao;

import com.ex.beans.Doctor;
import com.ex.beans.PatientProfile;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.List;

public class PatientProfileDao {
    public PatientProfile create(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(profile);
        profile.setPatient(id);
        transaction.commit();

        session.close();
        return profile;
    }

    public PatientProfile update(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(profile);
        transaction.commit();

        session.close();
        return profile;
    }

    public PatientProfile findOneByPatientId(PatientProfile patient){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, patient);

        session.close();
        return profile;
    }

    public PatientProfile findOneByUserId(int userId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, userId);

        session.close();
        return profile;
    }

    public PatientProfile findOneByDoctorId(Doctor doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, doctor.getDoctorsId());

        session.close();
        return profile;
    }

    public List<PatientProfile> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<PatientProfile> profiles = session.createCriteria(PatientProfile.class).list();

        session.close();
        return profiles;
    }

    public void delete(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(profile);
        session.flush();
        session.close();
    }


}
