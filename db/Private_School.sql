-- create database Private_School;
-- use Private_School;


-- CREATE TABLE Courses
-- (
--  course_id  int NOT NULL AUTO_INCREMENT ,
--  title      varchar(50) NOT NULL ,
--  steam      varchar(50) NOT NULL ,
--  type       varchar(50) NOT NULL ,
--  start_date date NOT NULL ,
--  end_date   date NOT NULL ,
--  cost       decimal(8,2)  NOT NULL default 0 ,

-- PRIMARY KEY (course_id)
-- );



-- CREATE TABLE Students (
--     student_id INT NOT NULL AUTO_INCREMENT,
--     firstName VARCHAR(50) NOT NULL,
--     lastName VARCHAR(50) NOT NULL,
--     dateOfBirth DATE NOT NULL,
--     tutionFees decimal(9,2) NOT NULL DEFAULT 0, 
-- 	PRIMARY KEY(STUDENT_ID)    
-- );
-- ALTER TABLE Students
-- MODIFY COLUMN tutionFees decimal(9,2); 



-- CREATE TABLE Trainers
-- (
--  trainer_id int NOT NULL AUTO_INCREMENT ,
--  first_name varchar(50) NOT NULL ,
--  last_name  varchar(50) NOT NULL ,
--  subject    varchar(50) NOT NULL ,

-- PRIMARY KEY (trainer_id)
-- );



-- CREATE TABLE assignments
-- (
--  assignment_id int NOT NULL AUTO_INCREMENT ,
--  title        varchar(50) NOT NULL ,
--  description  varchar(100) NOT NULL ,
--  sub_date     date NOT NULL,
--  oral_mark    int DEFAULT NULL,
--  total_mark   int DEFAULT NULL,

-- PRIMARY KEY (assignment_id)
-- );



-- CREATE TABLE course_assignment
-- (
--  id           int NOT NULL AUTO_INCREMENT ,
--  course_id    int NOT NULL ,
--  assignment_id int NOT NULL ,

-- PRIMARY KEY (id),
-- UNIQUE (course_id,assignment_id),
-- FOREIGN KEY (course_id)    REFERENCES courses (course_id),
-- FOREIGN KEY (assignment_id) REFERENCES assignments (assignment_id)
-- );


-- CREATE TABLE course_student
-- (
--  id         int NOT NULL AUTO_INCREMENT ,
--  course_id  int NOT NULL ,
--  student_id int NOT NULL ,

-- PRIMARY KEY (id),
-- UNIQUE(course_id,student_id),
-- FOREIGN KEY (course_id) REFERENCES courses (course_id),
-- FOREIGN KEY (student_id) REFERENCES students (student_id)
-- );


-- CREATE TABLE course_trainer
-- (

--  id         int NOT NULL AUTO_INCREMENT ,
--  course_id  int NOT NULL ,
--  trainer_id int NOT NULL ,

-- PRIMARY KEY (id),
-- UNIQUE(course_id,trainer_id),
-- FOREIGN KEY (course_id) REFERENCES courses (course_id),
-- FOREIGN KEY (trainer_id) REFERENCES trainers (trainer_id)
-- );



-- CREATE TABLE student_assignment
-- (
--  id                  int NOT NULL AUTO_INCREMENT ,
--  student_id          int NOT NULL ,
--  assignment_id        int NOT NULL ,
--  students_oral_mark  int DEFAULT NULL,
--  students_total_mark int DEFAULT NULL,

-- PRIMARY KEY (id),
-- UNIQUE(student_id,assignment_id),
-- FOREIGN KEY  (student_id) REFERENCES students (student_id),
-- FOREIGN KEY  (assignment_id) REFERENCES assignments (assignment_id)
-- );


