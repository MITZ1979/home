package com.nf.test;


import com.nf.entity.Mobile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainTest {

    @Test
    public void testFirstForJPA () {
//        SessionFactory;  => EntityManagerFactory
//        Session;         => EntityManager
//        Transaction;
//        OP;
//        Close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_DEMO");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();


        transaction.begin();

        Mobile vivo = new Mobile("VIVO", 2000F);
        Mobile oppo = new Mobile("OPPO", 3100F);
        Mobile hw = new Mobile("华为", 1000F);
        Mobile xiaomi = new Mobile("小米", 2005F);
        Mobile chuizi = new Mobile("锤子", 4000F);

        em.persist(vivo);
        em.persist(oppo);
        em.persist(hw);
        em.persist(xiaomi);
        em.persist(chuizi);

        transaction.commit();

        em.close();
        emf.close();
    }
}
