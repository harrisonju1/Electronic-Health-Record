package com.ex.dao;

import org.junit.Test;
import java.util.List;
import com.ex.beans.*;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class PatientHistoryDaoTest {
    @Before
    public void before(){
        final PatientHistoryDao historyDao= new PatientHistoryDao();
        historyDao.findAll().forEach((p)->{
            historyDao.delete(p);
        });
    }


    @Test
    public void create() {
        PatientHistoryDao historyDao = new PatientHistoryDao();
        PatientHistory history = new PatientHistory();
        history = historyDao.create(history);
        PatientHistory result = historyDao.findOneByPatientId(history.getPatientId());
        Assert.assertEquals(history, result);
    }

    @Test
    public void update() {

    }

    @Test
    public void findOneByPatientId() {
    }

    @Test
    public void findOneByDoctorId() {
    }

    @Test
    public void findOneByHistoryId() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }
}