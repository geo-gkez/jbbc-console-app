DELIMITER //
CREATE TRIGGER ution after INSERT ON course_student
 FOR EACH ROW 

begin
declare ad INT DEFAULT 0;
set ad = (select cost from courses where new.course_id=courses.course_id);

 UPDATE students SET tutionFees=tutionFees+ad where new.student_id=students.student_id;

 
 
 end
//
DELIMITER ;



DELIMITER //
CREATE TRIGGER student_assignments after INSERT ON course_student
 FOR EACH ROW 

begin
declare x int default 0;

declare ass int default 0;
declare a int default 0;
declare b int default 1;
set x =(select count(assignment_id) from course_assignment where course_id=new.course_id);


 label1: WHILE a<x do
 
	set ass =(select assignments.assignment_id from assignments,course_assignment 
    where assignments.assignment_id=course_assignment.assignment_id and course_assignment.course_id=new.course_id limit a,1 );
    
    insert into student_assignment (student_id,assignment_id) values (new.student_id,ass);
     
    set a=a+1; 
    
  
END WHILE label1;

 end;
//
DELIMITER ;




DELIMITER //
CREATE TRIGGER student_assignments_fr after INSERT ON course_assignment
 FOR EACH ROW 

begin
declare x int default 0;

declare st int default 0;
declare a int default 0;
declare b int default 1;
set x =(select count(student_id) from course_student where course_id=new.course_id);


 label1: WHILE a<x do
 
	set st =(select ct.student_id from course_student as ct
    where ct.course_id=new.course_id limit a,1 );
    
    insert into student_assignment (student_id,assignment_id) values (st,new.assignment_id);
     
    set a=a+1; 
  
END WHILE label1;

 end;
//
DELIMITER ;


