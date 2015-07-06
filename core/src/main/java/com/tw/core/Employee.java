package com.tw.core;


import javax.persistence.*;

/**
 * Created by chenbojian on 15-6-23.
 */
@Entity
@Table(name = "EMPLOYEE")
@Inheritance
@DiscriminatorColumn(name = "JOB", discriminatorType = DiscriminatorType.STRING)
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "JOB", insertable = false, updatable = false)
    private String job;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
