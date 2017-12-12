package com.nf.empjpa.dao;

import com.nf.empjpa.entity.Department;
import com.nf.empjpa.util.EMUtil;

import javax.persistence.EntityManager;

public class DeptDAO extends BaseDAO<Department> {
    public Department getById(long deptno) {
        EntityManager em = EMUtil.getEntityManager();
        Department department = em.find(Department.class, deptno);
        department.getEmployees().size();
        em.close();
        return department;
    }

}
