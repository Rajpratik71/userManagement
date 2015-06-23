package com.tw.core;

import javax.persistence.*;

/**
 * Created by chenbojian on 15-6-23.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private long userId;

    @Column(name = "JOB")
    private String job;

    public long getUserId(){
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
