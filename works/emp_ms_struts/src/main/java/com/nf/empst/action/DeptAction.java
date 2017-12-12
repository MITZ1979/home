package com.nf.empst.action;

import com.nf.empst.dao.DeptDAO;
import com.nf.empst.dao.impl.DeptDAOImpl;
import com.nf.empst.entity.Department;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

public class DeptAction extends ActionSupport implements ModelDriven<Department>, RequestAware {

    private DeptDAO deptDAO = new DeptDAOImpl();
    private Department department = new Department();
    private Map<String, Object> request;

    public String deptinfo() throws Exception {
        request.put("dept", deptDAO.getById(department.getDeptno()));
        return "success";
    }


    @Override
    public Department getModel() {
        return department;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}
