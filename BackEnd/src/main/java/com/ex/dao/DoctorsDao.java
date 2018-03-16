package com.ex.dao;

import com.ex.beans.Doctor;
import com.ex.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DoctorsDao {
    public Doctor create(Doctor doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = (Integer) session.save(doctor);
        doctor.setDoctorsId(id);
        transaction.commit();

        session.close();
        return doctor;
    }

    public Doctor update(Doctor doctors){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(doctors);
        transaction.commit();

        session.close();
        return doctors;
    }

    public List<Doctor> findByDoctorId(Doctor doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Doctor> doctors = (List<Doctor>) session.createCriteria(Doctor.class).add(Restrictions.eq("doctor_id", doctor)).list();

        session.close();
        return doctors;
    }

    public List<Doctor> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        List<Doctor> doctors = session.createCriteria(Doctor.class).list();

        session.close();
        return doctors;
    }

    public void delete(Doctor doctor){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.delete(doctor);
        session.flush();
        session.close();
    }

}
