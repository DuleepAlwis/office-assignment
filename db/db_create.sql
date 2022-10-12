CREATE DATABASE StudentMSDB;

USE StudentMSDB;

CREATE TABLE student(
id BIGInt PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255),
email VARCHAR(255),
PASSWORD VARCHAR(255)
);

CREATE TABLE course(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
courseNAME VARCHAR(255),
description VARCHAR(255),
author VARCHAR(255)
);

CREATE TABLE st_course(

id BIGINT PRIMARY KEY AUTO_INCREMENT,
studentId BIGINT,
courseId BIGINT,

CONSTRAINT fk_student FOREIGN KEY (`studentId`) REFERENCES student(`id`),
CONSTRAINT fk_course FOREIGN KEY (`courseId`) REFERENCES course(`id`)
);

CREATE TABLE course_content(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
location VARCHAR(255),
courseId BIGINT,
fileNAME VARCHAR(255),
CONSTRAINT fk_course_content FOREIGN KEY (`courseId`) REFERENCES course(`id`)
);
-----------------------------------------------------------------------------------
#DROP DATABASE studentmsdb
DROP TABLE course_content;
INSERT INTO student(id,NAME,email,password) VALUES(1,'Kamal','kamal@gmail.com'),(2,'Amila','amila@gmail.com'),(3,'Kasun','kasun@gmail.com');
INSERT INTO course(id,courseName,CODE,description) VALUES(1,'Health science','C100',"Course Content"),(2,'Physical science','P001',"Course Content"),
(3,'Home Science','H001',"Course Content");
SELECT * FROM student;
SELECT * FROM course;
SELECT * FROM st_course;
DROP TABLE st_course;

SELECT s.* FROM student s INNER JOIN st_course stc ON s.id = stc.studentId WHERE stc.courseId = 1;
Select c.* from course c inner join st_course stc on c.id=stc.courseId where stc.studentId=1
Select c.* from course c left join st_course stc on c.id=stc.courseId where stc.studentId NOT IN (15);
DELETE FROM course WHERE id = 4
#DROP database studentmsDB; 
ALTER TABLE student ADD CONSTRAINT unique_email UNIQUE(email);

INSERT INTO st_course(id,studentId,courseId) VALUES(1,1,1),(2,2,1),(3,3,3);
INSERT INTO st_course(id,studentId,courseId) VALUES(4,15,1);

ALTER TABLE st_course ADD COLUMN grade VARCHAR(10);
ALTER TABLE student ADD COLUMN admissionNo VARCHAR(255);

UPDATE student SET NAME = 'Kasun3' WHERE id = 3;
Select c.* from course c inner join st_course stc on c.id=stc.courseId where stc.studentId not IN (15)
SELECT * FROM student LIMIT 11,3

#DELETE FROM st_course;


