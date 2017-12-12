package com.nf.test;

import com.nf.entity.Mobile;
import org.junit.Test;

import java.util.List;


public class QueryTest extends BaseTest {

    @Test public void testFind() {
        Mobile mobile = em.find(Mobile.class, 2L);
        System.out.println(mobile);
    }

    @Test public void testQuery() {
        String jpql = "from Mobile where price > :pri";
        List<Mobile> mobiles = em.createQuery(jpql, Mobile.class)
                .setParameter("pri", 2000F)
                .getResultList();

        for (Mobile mobile : mobiles) {
            System.out.println(mobile);
        }
    }
}
