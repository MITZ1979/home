package edu.nf.hiberdemo.dao;

import edu.nf.hiberdemo.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class PersonDAO {

    public void insertNormal(Person person) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/orcl",
                "vip", "vip");

        String sql = "insert into person values (seq_person.nextval, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "张三");
            ps.setString(2, "男");
            ps.execute();
        }

        connection.close();

    }


    public SessionFactory openSessionFactory () {

        return new Configuration().configure().buildSessionFactory();

    }


    public void insert(Person person) {
        // 1、 创建 sessionFactory
        SessionFactory sessionFactory = openSessionFactory();

        // 2. 取得一个连接
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 3. 保持 person 数据库
        session.save(person);
        transaction.commit();

        // 4. 释放资源
        session.close();
        sessionFactory.close();

    }

    public Person getById(long id) {
        SessionFactory sessionFactory = openSessionFactory();
        Session session = sessionFactory.openSession();

        Person p = session.get(Person.class, id);

        session.close();
        sessionFactory.close();

        return p;
    }

    public List<Person> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List from_person = session.createQuery("from Person").list();

        session.close();
        sessionFactory.close();

        return from_person;
    }

    public static void main(String[] args) {
        System.out.println(new PersonDAO().getAll());
    }


}
