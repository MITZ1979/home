package my;

import com.nf.xxx.entity.Boy;
import com.nf.xxx.entity.Girl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BBBTest {

    EntityManagerFactory emf;

    @Before
    public void aaa () {
        emf = Persistence.createEntityManagerFactory("CRM");
    }
    @After
    public void zzz () {
        emf.close();
    }

    @Test
    public void aaskdfj () {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Boy b = new Boy();
        b.setName("tom");
        b.setJob("kanjia");
        em.persist(b);

        Girl g = new Girl();
        g.setName("jerry");
        g.setScore(222.3F);
        em.persist(g);

        em.getTransaction().commit();
    }
}
