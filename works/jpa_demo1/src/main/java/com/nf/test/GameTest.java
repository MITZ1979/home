package com.nf.test;

import com.nf.entity.Game;
import org.junit.Test;

public class GameTest extends BaseTest {

    @Test public void testFirst() {
        Game cj = new Game("吃鸡", 98F);
        Game lol = new Game("lol", 1F);

        em.persist(cj);
        em.persist(lol);
    }
}
