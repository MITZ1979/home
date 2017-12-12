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

        // 靡不有初，鲜克有终
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_DEMO");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();


        // 新增
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

        // 更新
        transaction.begin();
        xiaomi.setPrice(1555F);
        em.merge(xiaomi);
        transaction.commit();;

        // 删除
        transaction.begin();
        em.remove(chuizi);
        transaction.commit();


        // at last, 不要忘记释放资源
        em.close();
        emf.close();
    }
}
