package com.nf.xxx.entity;

import javax.persistence.Entity;

@Entity
public class Girl extends Base {

    private float score;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
