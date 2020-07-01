
INSERT INTO `trainers` VALUES (1,'NIKOS','SYMVONIS','COMPUTER_SCIENCE'),
 (2,'OURSOULA','ABSHIRE','ALGEBRA'),
 (3,'KOSTAS','KOUTSOPOULOS','DATA_SCIENCE'),
 (4,'NATASSA','SKILES','COMPUTATIONAL_THINKING '),
 (5,'TEAGAN','DOOLEY','JAVA_PROGRAMMING'),
 (6,'CYNTHIA','FADEL','STATISTICS'),
(7,'ETHELYN','THOMPSON','COMPUTER_SCIENCE'),
 (8,'LELAH','HIRTHE','PYTHON_PROGRAMMING'),
(9,'WILLIS','HAAG','BLOCKCHAIN'),
 (10,'ROSE','SPINKA','WED_DEVELOPER');



 INSERT INTO `students`
  VALUES (1,'CLEVELAND','STANTON','1972-10-30',0)
 ,(2,'WILFORD','HINTZ','1986-12-05',0)
 ,(3,'SALMA','RUNOLFSSON','1974-10-13',0)
  ,(4,'SID','ROWE','1981-07-30',0)
  ,(5,'CORDIE','QUITZON','1995-11-18',0)
  ,(6,'KYLEE','KUPHAL','1992-11-23',0),
  (7,'NED','VON','2001-12-22',0),
 (8,'DANNY','MURPHY','1985-01-31',0),
 (9,'ELENORA','THOMPSON','1985-02-18',0)
  ,(10,'DARIEN','KLEIN','1981-10-20',0),
  (11,'DEDRIC','STOLTENBERG','1992-08-22',0)
  ,(12,'ALAN','ROGAHN','1990-04-06',0),
  (13,'ADRIAN','FUNK','1978-06-13',0)
 ,(14,'ANGIE','TILLMAN','1982-04-16',0.00)
  ,(15,'CORNELL','GERHOLD','1992-08-09',0),
 (16,'RESSIE','WOLFF','1978-11-14',0.00)
  ,(17,'WELLINGTON','ZULAUF','1981-04-28',0)
  ,(18,'CASSIE','WISOKY','1971-07-09',0.00),
  (19,'JOANNE','WARD','1986-06-17',0)
  ,(20,'RHIANNA','MURPHY','1984-05-05',0)
  ,(21,'CONSTANCE','CONNELLY','1982-02-06',0),
 (22,'MIREILLE','PRICE','1975-08-25',0),
  (23,'TARA','HERMAN','1973-05-09',0),
  (24,'ROXANNE','MARQUARDT','1984-05-04',0),
  (25,'ROCKY','CARTWRIGHT','1998-10-08',0)
  ,(26,'MADELINE','SMITH','2001-10-27',0),
  (27,'LAURENCE','COLLIER','1979-04-30',0),
  (28,'ELYSE','MOORE','1978-01-20',0),
  (29,'LAURA','HAMMES','1979-08-13',0),
  (30,'KALEIGH','JOHNSON','1991-01-25',0),
  (31,'MICHEL','O\'HARA','1971-01-12',0),
  (32,'MOSSIE','MANN','1993-05-31',0),
  (33,'EZEKIEL','RYAN','1978-09-01',0),
  (34,'ENA','FEENEY','1981-06-04',0),
  (35,'BROOKE','MOEN','1977-09-25',0),
 (36,'MARC','GOODWIN','1997-07-25',0),
 (37,'EINAR','KREIGER','1975-07-06',0),
  (38,'WILLOW','HARVEY','1989-10-07',0)
 ,(39,'NELLA','DARE','1996-05-28',0),
 (40,'TAMARA','NITZSCHE','1999-02-15',0)
 ,(41,'MIKI','KOLOKITHAS','1990-01-01',0)
  ,(45,'GEORGE','ZARA','1990-05-24',0);


 INSERT INTO `courses` VALUES (1,'PYTHON_BASIC','PROGRAMMING','Full-time','2020-01-08','2021-05-07',0.00),
 (2,'ALGEBRA','MATHS','Full-time','2020-02-15','2020-08-08',200.00),
 (3,'DATA_BASE','PROGRAMMING','part-time','2020-10-15','2021-01-08',300.00),
 (4,'STATISTICS','MATHS','part-time','2020-11-25','2021-05-10',350.00),
 (22,'PHYSICS1','GENERAL','Part-time','2020-05-03','2021-05-04',1500.00);

 INSERT INTO `assignments` VALUES (1,'PYTHON_APP','CREATE_A_CONSOLE_APP','2020-08-03',20,100)
 ,(2,'JAVA_APP','CREATE_A_APP','2020-05-01',20,60),(3,'JAVA','CALCULATOR','2020-10-01',5,40),
 (4,'DATA','DATABASE_SCHEMA','2020-11-30',10,50),(5,'ALGEBRA','TABLES','2020-03-10',20,100),
 (9,'STATISTICS','LOG_MODEL','2021-01-04',100,250),(10,'MYSQL','CREATE_A_BASE','2020-10-19',50,100),
 (11,'PHYSICS','EXERCISES','2021-04-20',20,100);




 INSERT INTO course_trainer VALUES(null,1,1),(null,1,5),(null,1,3),(null,1,7),(null,1,9);
 INSERT INTO course_trainer VALUES (null,2,1),(null,2,6),(null,2,7),(null,2,8),(null,2,10);
INSERT INTO course_trainer VALUES	 (null,3,2);								
   INSERT INTO course_trainer VALUES (null,4,3),(null,4,4),(null,4,7);                          
 INSERT INTO course_trainer VALUES  (null,22,6),(null,22,4),(null,22,9);
                              
 INSERT INTO course_assignment(course_id,assignment_id) VALUES(1,1),(1,4);
  INSERT INTO course_assignment(course_id,assignment_id) VALUES(2,5),(2,4);
    INSERT INTO course_assignment(course_id,assignment_id) VALUES(3,4),(3,5),(3,11);
    INSERT INTO course_assignment(course_id,assignment_id) VALUES(4,9),(4,11);
    INSERT INTO course_assignment(course_id,assignment_id) VALUES(22,3),(22,11),(22,1);
    

call DUMMY_COURSE_STUDENT(100);

insert into student_assignment (student_id,assignment_id)
select cs.student_id, ca.assignment_id
from course_student as cs,course_assignment as ca
where cs.course_id=ca.course_id
group by student_id,assignment_id;
      

