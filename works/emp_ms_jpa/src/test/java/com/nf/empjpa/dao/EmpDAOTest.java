package com.nf.empjpa.dao;

import com.nf.empjpa.entity.Employee;
import org.junit.Test;

import java.util.List;


public class EmpDAOTest {
    @Test
    public void queryByEname() throws Exception {
        List<Employee> employees = new EmpDAO().queryByEname("鸣");
        assert employees.size() == 1;
        assert employees.get(0).getName().equals("鸣人");

        assert new EmpDAO().queryByEname("smi").size() == 1;
    }

    @Test
    public void criteriaByConditions() throws Exception {
        EmpDAO empDAO = new EmpDAO();
        assert empDAO.criteriaByConditions("鸣", null, null).get(0).getName().equals("鸣人");
        assert empDAO.criteriaByConditions("smI", null, null).get(0).getName().equals("SMITH");
        assert empDAO.criteriaByConditions("", "1000", "1400").size() == 3;
    }
}