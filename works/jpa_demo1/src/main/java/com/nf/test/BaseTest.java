package com.nf.test;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseTest {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    @Before
    public void first() {
        emf = Persistence.createEntityManagerFactory("JPA_DEMO");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void last() {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
