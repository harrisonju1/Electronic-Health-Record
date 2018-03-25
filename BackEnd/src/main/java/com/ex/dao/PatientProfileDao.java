package com.ex.dao;

import com.ex.beans.Doctor;
import com.ex.beans.PatientInfo;
import com.ex.beans.PatientProfile;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

public class PatientProfileDao {
    public PatientInfo create(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("firstname: "+ profile.getFirst_name());
        System.out.println("lastname " + profile.getLast_name());
        Integer id = (Integer) session.save(profile);
        System.out.println(profile.getFirst_name());
        PatientInfo info = new PatientInfo();
        info.setPatient_id(id);
        transaction.commit();
        System.out.println("patientinfo is being sent back: " +info);
        session.close();
        return info;
    }

    public PatientProfile update(PatientProfile profile){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("inside the update dao: " + profile);
        session.update(profile);
        transaction.commit();

        session.close();
        return profile;
    }

    public PatientProfile findOneByPatientId(int patientId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, patientId);

        session.close();
        return profile;
    }

//    public PatientProfile findBySSN(int ssn){
//        Session session = HibernateUtils.getSessionFactory().openSession();
//
//        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, ssn);
//
//        session.close();
//        return profile;
//
//    }
    public PatientProfile findOneByUserId(int userId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, userId);

        session.close();
        return profile;
    }

    public PatientProfile findOneByDoctorId(Doctor doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();

        PatientProfile profile = (PatientProfile) session.get(PatientProfile.class, doctor.getDoctor_id());

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
