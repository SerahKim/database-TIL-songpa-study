GRANT ALL PRIVILEGES ON schooldb.* TO 'teamproblem'@'%';

CREATE DATABASE schooldb;

USE schooldb;

CREATE TABLE TBL_STUDENT (
                             STUDENT_ID INT AUTO_INCREMENT,
                             NAME VARCHAR(50) NOT NULL,
                             AGE INT,
                             MAJOR VARCHAR(100),
                             PRIMARY KEY(STUDENT_ID)
);

CREATE TABLE TBL_COURSE (
                            COURSE_ID INT AUTO_INCREMENT,
                            TITLE VARCHAR(100) NOT NULL,
                            INSTRUCTOR VARCHAR(50),
                            CREDIT INT,
                            PRIMARY KEY(COURSE_ID)
);

CREATE TABLE TBL_ENROLLMENT (
                                ENROLL_ID INT AUTO_INCREMENT,
                                STUDENT_ID INT,
                                COURSE_ID INT,
                                ENROLL_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY(ENROLL_ID),
                                FOREIGN KEY(STUDENT_ID) REFERENCES TBL_STUDENT(STUDENT_ID),
                                FOREIGN KEY(COURSE_ID) REFERENCES TBL_COURSE(COURSE_ID)
);