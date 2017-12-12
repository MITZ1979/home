package com.nf.xxx.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Base {
    @Id @GeneratedValue private long id;

    private String name;

    @Version
    private long version;

    @Column(nullable = false, insertable = false)
    private Date created;

    @Column(nullable = false, insertable = false)
    private Date updated;

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

    @PrePersist
    void createAt() {
        this.created = this.updated = new Date();
    }

    @PreUpdate
    void updateAt() {
        this.updated = new Date();
    }
}
