package com.tw.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-29.
 */
@Entity
@DiscriminatorValue("Coach")
public class Coach extends Employee{

    @OneToMany(mappedBy = "privateCoach", cascade = CascadeType.ALL)//delete the many side should be careful.
    private Set<Customer> privateCustomers = new HashSet<Customer>();

    @OneToMany(mappedBy = "coach",orphanRemoval = true)
    private Set<Course> courses = new HashSet<Course>();

    public Set<Customer> getPrivateCustomers() {
        return privateCustomers;
    }

    public void setPrivateCustomers(Set<Customer> privateCustomers) {
        this.privateCustomers = privateCustomers;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
