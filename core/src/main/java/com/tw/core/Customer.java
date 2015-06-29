package com.tw.core;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-24.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)//owner
    @JoinTable(
            name = "PRIVATE_COACH",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COACH_ID")
    )
    private Coach privateCoach;

    @ManyToMany
    @JoinTable(
            name = "CUSTOMER_SELECT_COURSE",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private Set<Course> courses;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Coach getPrivateCoach() {
        return privateCoach;
    }

    public void setPrivateCoach(Coach privateCoach) {
        this.privateCoach = privateCoach;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
