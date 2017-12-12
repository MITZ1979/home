package com.nf.empjpa;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest {
    protected EntityManagerFactory emf;
    protected EntityManager em;

    @Before
    public void first() {
        emf = Persistence.createEntityManagerFactory("Test_Environment");
        em = emf.createEntityManager();
    }

    @After
    public void last() {
        em.close();
        emf.close();
    }
}
