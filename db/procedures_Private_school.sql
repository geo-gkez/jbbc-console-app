
-- DELIMITER %%
-- CREATE PROCEDURE DUMMY_COURSE_STUDENT(NUM INT)
-- BEGIN
-- 	DECLARE i INT DEFAULT 0;
--     DECLARE cou INT DEFAULT 1;
--     DECLARE stu INT DEFAULT 1;
--   
--   	CTS_LOOP: LOOP
-- 	
--  		SET cou = (SELECT course_id FROM courses ORDER BY RAND() LIMIT 1);
--  		SET stu = (SELECT student_id FROM students ORDER BY RAND() LIMIT 1);
--         IF ((SELECT COUNT(*) FROM course_student WHERE course_student.course_id = cou AND course_student.student_id = stu) = 0) THEN
-- 			INSERT INTO course_student VALUES (NULL, cou, stu);	
-- 		END IF;
--         SET i = i + 1;
-- 		IF i = NUM THEN
-- 			LEAVE CTS_LOOP;
-- 		END IF;
--     END LOOP CTS_LOOP;
-- END %%
-- DELIMITER ;

-- CALL DUMMY_COURSE_STUDENT(30);

-- -- call RepeatDemo;

-- DELIMITER $$
-- CREATE PROCEDURE DUMMY_COURSE_ass(NUM INT)
-- BEGIN
-- 	DECLARE i INT DEFAULT 0;
--     DECLARE cou INT DEFAULT 1;
--     DECLARE stu INT DEFAULT 1;
--   
--   	CTS_LOOP: LOOP
-- 	
--  		SET cou = (SELECT course_id FROM courses ORDER BY RAND() LIMIT 1);
--  		SET stu = (SELECT assignment_id FROM assignments ORDER BY RAND() LIMIT 1);
--         IF ((SELECT COUNT(*) FROM course_assignment WHERE course_assignment.course_id = cou AND course_assignment.assignment_id = stu) = 0) THEN
-- 			INSERT INTO course_assignment VALUES (NULL, cou, stu);	
-- 		END IF;
--         SET i = i + 1;
-- 		IF i = NUM THEN
-- 			LEAVE CTS_LOOP;
-- 		END IF;
--     END LOOP CTS_LOOP;
-- END $$
-- DELIMITER ;

-- call DUMMY_COURSE_ass(30);
