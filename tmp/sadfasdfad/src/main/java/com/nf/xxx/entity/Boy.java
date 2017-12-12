package com.nf.xxx.entity;

import javax.persistence.Entity;

@Entity
public class Boy extends Base {
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
