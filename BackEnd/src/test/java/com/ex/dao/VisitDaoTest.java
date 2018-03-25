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
        visit.setVisit_date(Date.from(Instant.now()));

        // create test
        visit = visitDao.create(visit);
        Assert.assertNotNull(visit);

        // find by id test
        Visit found = visitDao.findByVisitId(visit.getVisit_id());
        Assert.assertNotNull(found);
        // note: date will be different
        Assert.assertEquals(visit.getVisit_id(), found.getVisit_id());

        // test other methods


        // update test
        // todo change a value

        Visit updated = visitDao.update(visit);
        Visit updatedFound = visitDao.findByVisitId(visit.getVisit_id());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(visit.getVisit_id(), found.getVisit_id());

        // delete test
        visitDao.delete(visit);

        // find all test
        List<Visit> all = visitDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(visit));

    }

}