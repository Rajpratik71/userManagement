package com.tw.core;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by chenbojian on 15-6-26.
 */

@Entity
@Table(name = "COURSE")
public class Course {
    private long id;
    private long coachId;
    private String courseName;
    private Set<Date> courseDate;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "COACH_ID")
    public long getCoachId() {
        return coachId;
    }

    public void setCoachId(long coachId) {
        this.coachId = coachId;
    }

    @Column(name = "COURSE_NAME")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @OneToMany
    @JoinTable(
            name = "COURSE_DATE",
            joinColumns = @JoinColumn(name = "COURSE_ID")
    )
    @Column(name = "COURSE_DATE")
    public Set<Date> getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Set<Date> courseDate) {
        this.courseDate = courseDate;
    }
}
