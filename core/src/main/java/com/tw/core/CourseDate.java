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
    private long courseId;
    private Date courseDate;

    @Id
    @Column(name ="ID")
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "COURSE_ID")
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Column(name = "COURSE_DATE")
    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }
}
