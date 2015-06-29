package com.tw.core;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-26.
 */

@Entity
@Table(name = "COURSE")
public class Course {
    private long id;
    private Set<Customer> customers;
    private String courseName;
    private Set<CourseDate> courseDates = new HashSet<CourseDate>();

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "COURSE_NAME")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    @OneToMany(mappedBy = "course")
    public Set<CourseDate> getCourseDates() {
        return courseDates;
    }

    public void setCourseDates(Set<CourseDate> courseDates) {
        this.courseDates = courseDates;
    }

    @ManyToMany
    @JoinTable(
            name = "CUSTOMER_SELECT_COURSE",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}
