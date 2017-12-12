package com.nf.empjpa.dao;

import com.nf.empjpa.entity.Department;
import org.junit.Test;

public class BaseDAOTest {
    @Test
    public void countAll() throws Exception {
        DeptDAO deptDAO = new DeptDAO();
        System.out.println(deptDAO.countAll());

        EmpDAO empDAO = new EmpDAO();
        System.out.println(empDAO.countAll());
    }

    @Test
    public void listAll() {
        DeptDAO deptDAO = new DeptDAO();
        for (Department department : deptDAO.getAll()) {
            System.out.println(department);
        }
    }

}