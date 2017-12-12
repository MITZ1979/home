package com.nf.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@MappedSuperclass
public class BaseEntity {

    @Id @GeneratedValue
    protected long id;

    @Version
    protected long version;

    @Temporal(TemporalType.DATE)
    protected Date created;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated;

    @PrePersist void prePersist() {
        this.created = this.updated = Calendar.getInstance().getTime();
    }

    @PreUpdate void preUpdate () {
        this.updated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
