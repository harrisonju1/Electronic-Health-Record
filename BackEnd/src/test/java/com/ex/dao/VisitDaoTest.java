package com.ex.dao;

import com.ex.beans.Visit;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class VisitDaoTest {

    @Test
    public void maintest() {
        VisitDao visitDao = new VisitDao();

        Visit visit = new Visit();

        // set needed values
//        visit.setVisitDate(Date.from(Instant.now()));

        // create test
        visit = visitDao.create(visit);
        Assert.assertNotNull(visit);

        // find by id test
        Visit found = visitDao.findByVisitId(visit.getVisitId());
        Assert.assertNotNull(found);
        // note: date will be different
        Assert.assertEquals(visit.getVisitId(), found.getVisitId());

        // test other methods


        // update test
        // todo change a value

        Visit updated = visitDao.update(visit);
        Visit updatedFound = visitDao.findByVisitId(visit.getVisitId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(visit.getVisitId(), found.getVisitId());

        // delete test
        visitDao.delete(visit);

        // find all test
        List<Visit> all = visitDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(visit));

    }

}