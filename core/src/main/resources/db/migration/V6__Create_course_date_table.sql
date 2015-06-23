create table COURSE_DATE (
    COURSE_ID int not null,
    COURSE_DATE DATE not null,
    FOREIGN KEY (COURSE_ID) REFERENCES COURSE(ID)
);