package com.ex.dao;

import com.ex.beans.Doctors;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DoctorsDao {
    public Doctors create(Doctors doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(doctor);
        doctor.setDoctorsId(id);
        transaction.commit();

        session.close();
        return doctor;
    }

    public Doctors update(Doctors doctors){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(doctors);
        transaction.commit();

        session.close();
        return doctors;
    }

    public List<Doctors> findByDoctorId(int doctorId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Doctors> doctors = (List<Doctors>) session.createCriteria(Doctors.class).add(Restrictions.eq("doctor_id", doctorId)).list();

        session.close();
        return doctors;
    }

    public List<Doctors> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Doctors> doctors = session.createCriteria(Doctors.class).list();

        session.close();
        return doctors;
    }

    public void delete(Doctors doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(doctor);
        session.flush();
        session.close();
    }

}
