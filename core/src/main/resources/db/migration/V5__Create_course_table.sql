create table COURSE (
    ID int not null AUTO_INCREMENT,
    COACH_ID int not null,
    COURSE_NAME varchar(100) not null,
    PRIMARY KEY (ID),
    FOREIGN KEY (COACH_ID) REFERENCES EMPLOYEE(USER_ID)
);