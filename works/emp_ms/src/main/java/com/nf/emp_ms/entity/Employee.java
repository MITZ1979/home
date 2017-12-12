package com.nf.emp_ms.entity;

import oracle.jdbc.proxy.annotation.Pre;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emp")
@NamedQuery(name = "gongzidayu", query = "from Employee where salary >= :sal")
@NamedNativeQuery(name = "gongzidayunative", query = "select ename, sal from emp where sal >= :sal")
public class Employee {

    @Id
    @GeneratedValue(generator = "bbb")
    @SequenceGenerator(name = "bbb", sequenceName = "seq_emp", allocationSize = 1)
    private long empno;

    @Column(name = "ename", length = 10)
    private String name;

    private String job;

    @Column(name = "sal")
    private float salary;

    @Column(name = "comm")
    private Float commission;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deptno")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mgr")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> xiaodis;


    @ManyToMany(mappedBy = "workers")
    private List<Project> projects = new ArrayList<>();


    public Employee() {
    }

    public Employee(String name, String job, float salary, Float commission, Date hireDate, Department department) {
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.commission = commission;
        this.hireDate = hireDate;
        this.department = department;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Float getCommission() {
        if(commission == null)
            return Float.valueOf(0);
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getXiaodis() {
        return xiaodis;
    }

    public void setXiaodis(List<Employee> xiaodis) {
        this.xiaodis = xiaodis;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
