package com.tw.core;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chenbojian on 15-6-26.
 */
@Entity
@Table(name = "COURSE_DATE")
public class CourseDate {
    private long id;
    private Date date;
    private Course course;

    @Id
    @Column(name ="ID")
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "COURSE_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
