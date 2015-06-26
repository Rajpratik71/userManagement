package com.tw.core;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-23.
 */
@Entity
@Table(name = "EMPLOYEE")
@Cacheable
public class Employee {
    @Id
    @Column(name = "USER_ID")
//    @GeneratedValue
    private long userId;

    @Column(name = "JOB")
    private String job;

    @OneToOne//lazy or eager
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "privateCoach",cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "PRIVATE_COACH",
//            joinColumns = @JoinColumn(name = "COACH_ID"),
//            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
//    )
    private Set<Customer> privateCustomers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Set<Customer> getPrivateCustomers() {
        return privateCustomers;
    }

    public void setPrivateCustomers(Set<Customer> privateCustomers) {
        this.privateCustomers = privateCustomers;
    }
}
