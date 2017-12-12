package com.nf.test;

import com.nf.entity.Computer;
import org.junit.Test;

import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class ComputeTest extends BaseTest {

    @Test public void testFirst() {
        Computer lenovo = new Computer("联想", 4444F);
        Computer dell = new Computer("戴尔", 3555F);

        em.persist(lenovo);
        em.persist(dell);
    }

    @Test public void testFirst2() {
        Computer lx = em.find(Computer.class, 5L);
        lx.setPrice(4448F);
        em.merge(lx);
    }

    @Test public void testQuery () {
        em.createQuery("from Computer").getResultList();
    }
}
