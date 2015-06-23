create table EMPLOYEE (
    USER_ID int not null,
    JOB varchar(100) not null,
    UNIQUE (USER_ID),
    FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);