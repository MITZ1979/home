package com.nf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mobile {

    @Id @GeneratedValue
    private long mid;

    @Column(nullable = false)
    private String name;

    private Float price;

    public Mobile() {
    }

    public Mobile(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
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

    @Override
    public String toString() {
        return "Mobile{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
