package com.tw.core;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-26.
 */

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @ManyToMany
    @JoinTable(
            name = "CUSTOMER_SELECT_COURSE",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    private Set<Customer> customers;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseDate> courseDates = new HashSet<CourseDate>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<CourseDate> getCourseDates() {
        return courseDates;
    }

    public void setCourseDates(Set<CourseDate> courseDates) {
        this.courseDates = courseDates;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }


}
