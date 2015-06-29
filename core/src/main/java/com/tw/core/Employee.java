package com.tw.core;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-23.
 */
@Entity
@Table(name = "EMPLOYEE")
@Inheritance
@DiscriminatorColumn(name = "JOB")
public class Employee {
    @Id
    @Column(name = "USER_ID")
    private long userId;

    @OneToOne//lazy or eager
    @JoinColumn(name = "USER_ID")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
