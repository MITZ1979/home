package edu.nf.hiberdemo.entity;


import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long personid;

    private String name;
    private String sex;

    public long getPersonid() {
        return personid;
    }

    public void setPersonid(long personid) {
        this.personid = personid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personid=" + personid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
