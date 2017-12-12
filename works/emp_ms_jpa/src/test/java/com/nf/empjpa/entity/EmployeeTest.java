package com.nf.empjpa.entity;

import com.nf.empjpa.JPATest;
import org.junit.Test;

import java.util.List;

public class EmployeeTest extends JPATest {

    @Test
    public void testQuery() {
        String jpql = "from Employee where salary > :sal";
        List<Employee> employees = em.createQuery(jpql, Employee.class)
                .setParameter("sal", 3000F)
                .getResultList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}