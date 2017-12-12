package com.nf.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MY_COMPUTER")
public class Computer {

    @Id
    @GeneratedValue(generator = "myc_seq")
    @SequenceGenerator(name = "myc_seq", sequenceName = "seq_mycomputer", allocationSize = 1)
    private long id;

    private String name;

    private Float price;

    @Version
    private long version;

    private Date created;
    private Date updated;


    public Computer() {
    }

    public Computer(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @PostLoad
    void postLoad() {
        System.out.println("哈哈哈哈哈哈哈哈哈@!");
    }

    @PrePersist // 在执行保存操作之前，会执行的函数, CallBack
    void prePersist() {
        // this.created = new Date();
        // this.updated = new Date();
        this.name = String.format("[ %s_%.2f ]", this.name, this.price);
        this.created = this.updated = new Date();
    }

    @PreUpdate
    void persuiibainjimmingzzi() {
        this.updated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
