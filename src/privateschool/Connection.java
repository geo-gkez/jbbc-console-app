/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

/**
 *
 * @author georg
 */
public class Connection {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String DB_URL = "jdbc:mysql://localhost/private_school?serverTimezone=UTC";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "0000";
    
 private   List<Course> courses=new ArrayList();
  private  List<Assignment> assignments=new ArrayList();

    public Connection() {
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM private_school.students; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();

                Double tutionFees = resultSet.getDouble("tutionFees");

                // Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth, double tutionFees)
                Student student = new Student(studentID, firstName, lastName, dateOfBirth, tutionFees);
                students.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return students;
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM private_school.trainers; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int trainerID = resultSet.getInt("trainer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String subject = resultSet.getString("subject");

                // Trainer(String firstName, String lastName, String subject, int trainerID)
                Trainer trainer = new Trainer(firstName, lastName, subject, trainerID);
                trainers.add(trainer);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return trainers;
    }

    public List<Assignment> getAllAssignments() {
        List<Assignment> assigns = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM private_school.assignments; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int assignmentID = resultSet.getInt("assignment_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                java.sql.Date sub_date = resultSet.getDate("sub_date");
                LocalDate subDate = sub_date.toLocalDate();

                int MaxTotalMark = resultSet.getInt("total_mark");
                int MaxOralMark = resultSet.getInt("oral_mark");

                // Assignment(int assignmentID, String title, String description, LocalDate subDateTime,  int MaxTotalMark, int MaxOralMark)
                Assignment assignment = new Assignment(assignmentID, title, description, subDate, MaxTotalMark, MaxOralMark);
                assigns.add(assignment);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return assigns;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM private_school.courses; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int courseID = resultSet.getInt("course_id");
                String title = resultSet.getString("title");
                String steam = resultSet.getString("steam");
                String type = resultSet.getString("type");

                java.sql.Date start_date = resultSet.getDate("start_date");
                LocalDate stDate = start_date.toLocalDate();

                java.sql.Date end_date = resultSet.getDate("end_date");
                LocalDate enDate = end_date.toLocalDate();

                Double cost = resultSet.getDouble("cost");

                // Course(int courseID, String title, String stream, String type, LocalDate startDate, LocalDate endDate, double cost)
                Course course = new Course(courseID, title, steam, type, stDate, enDate, cost);
                courses.add(course);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return courses;
    }

    public List<Student> getAllStudentsPerCourse(int courseID){
        
         List<Student> studentsPerCourse = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " select s.student_id, s.firstName , s.lastName, s.dateOfBirth, s.tutionFees " +
" from course_student as cs, students as s " +
" where cs.course_id= ? and cs.student_id=s.student_id " +
" group by s.student_id;";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseID);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                int studentID = resultSet.getInt("student_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();

                Double tutionFees = resultSet.getDouble("tutionFees");
     //--------------------------------------------------------------------------------------------------------------           
     //--------------------------------------------------------------------------------------------------------------           
   
// Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth, double tutionFees)
                Student student = new Student(studentID, firstName, lastName, dateOfBirth, tutionFees);
                studentsPerCourse.add(student);
              
          
                
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentsPerCourse;
    
    
    }
    
    
    
 public List<Trainer> getAllTrainersPerCourse(int courseID){
        
         List<Trainer> trainersPerCourse = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "select t.trainer_id, t.first_name,t.last_name,t.subject " +
" from course_trainer as ct, trainers as t " +
" where ct.course_id= ? and ct.trainer_id=t.trainer_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseID);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
               int trainerID = resultSet.getInt("trainer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String subject = resultSet.getString("subject");

                // Trainer(String firstName, String lastName, String subject, int trainerID)
                Trainer trainer = new Trainer(firstName, lastName, subject, trainerID);
                trainersPerCourse.add(trainer);
              
          
                
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return trainersPerCourse;
    
    
    }
       
    
  public List<Assignment> getAllAssignmentsPerCourse(int courseID){
        
         List<Assignment> assignmentPerCourse = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "select a.assignment_id,a.title, a.description, a.sub_date,a.total_mark,a.oral_mark  " +
" from course_assignment as ca,assignments as a " +
" where ca.course_id=? and ca.assignment_id=a.assignment_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseID);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
   int assignmentID = resultSet.getInt("assignment_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                java.sql.Date sub_date = resultSet.getDate("sub_date");
                LocalDate subDate = sub_date.toLocalDate();

                int MaxTotalMark = resultSet.getInt("total_mark");
                int MaxOralMark = resultSet.getInt("oral_mark");

                // Assignment(int assignmentID, String title, String description, LocalDate subDateTime,  int MaxTotalMark, int MaxOralMark)
                Assignment assignment = new Assignment(assignmentID, title, description, subDate, MaxTotalMark, MaxOralMark);
                assignmentPerCourse.add(assignment);
          
                
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return assignmentPerCourse;
    
    
    }
      
   
  
  
  public  void allAssignmentsPerCoursePerStudent(int studentID){
        
 
                                          

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "select  a.assignment_id,  a.title,a.description,a.sub_date,a.oral_mark,a.total_mark,sa.students_oral_mark,sa.students_total_mark " +
" ,c.course_id, c.title,c.steam, c.type ,c.start_date,c.end_date,c.cost,  s.student_id,s.firstName,s.lastName,s.dateOfBirth,s.tutionFees " +
" from course_assignment as ca,courses as c,assignments as a,students s,student_assignment as sa " +
" where ca.course_id=c.course_id  " +
" and ca.assignment_id=a.assignment_id " +
" and sa.assignment_id=a.assignment_id " +
" and sa.student_id= ? " +
" and s.student_id= ? "
                    + " order by c.course_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentID);
            preparedStatement.setInt(2, studentID);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
   int assignmentID = resultSet.getInt("assignment_id");
                String titleA = resultSet.getString("title");
                String description = resultSet.getString("description");

                java.sql.Date sub_date = resultSet.getDate("sub_date");
                LocalDate subDate = sub_date.toLocalDate();

                int MaxTotalMark = resultSet.getInt("total_mark");
                int MaxOralMark = resultSet.getInt("oral_mark");
              
         int courseID = resultSet.getInt("course_id");
                String titleC = resultSet.getString("title");
                String steam = resultSet.getString("steam");
                String type = resultSet.getString("type");

                java.sql.Date start_date = resultSet.getDate("start_date");
                LocalDate stDate = start_date.toLocalDate();

                java.sql.Date end_date = resultSet.getDate("end_date");
                LocalDate enDate = end_date.toLocalDate();

                Double cost = resultSet.getDouble("cost");
                
                     Integer studentsOralMark=(Integer) resultSet.getObject("students_oral_mark");
                     Integer studentsTotalMark=(Integer) resultSet.getObject("students_total_mark");

                     
 //Assignment(int assignmentID, String title, String description, LocalDate subDateTime, int MaxTotalMark, int MaxOralMark, int studentsOral, int studentsTotal)    
Assignment assignment = new Assignment(courseID,assignmentID,titleA,description,subDate,MaxTotalMark,MaxOralMark,studentsOralMark,studentsTotalMark);    
                     Course course = new Course(courseID,titleC,steam,type,stDate,enDate,cost);
                
                     assignments.add(assignment);
                     
               
                     int counter3=0;
                     
                     if(courses.isEmpty()){  courses.add(course);  }
                     
                  else { 
                         
                         for(Course c: courses){
                     
                           
                            
                     if(c.getCourseID()==course.getCourseID()){
                         counter3++;
                        
                     break;
                     }
               
                     }
               
                   if(counter3==0){      
                     courses.add(course);
                             
                   }
                   
                     }

                   
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

       
 
    
    }
  
  
 public Map<Student, Integer> studentWithManyCourses() {
     
        Map<Student, Integer> students = new HashMap<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                        Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "select count(cs.course_id), s.firstName,s.lastName,s.student_id,s.dateOfBirth,s.tutionFees " +
" from course_student as cs,courses as c,students as s " +
" where c.course_id=cs.course_id and s.student_id=cs.student_id " +
" group by cs.student_id " +
" having count(cs.course_id)>1 " +
" order by student_id; ";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int count=resultSet.getInt("count(cs.course_id)");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();

                Double tutionFees = resultSet.getDouble("tutionFees");

                // Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth, double tutionFees)
                Student student = new Student(studentID, firstName, lastName, dateOfBirth, tutionFees);
                
                students.put(student, count);
                
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return students;
    }
 
 
 public List<Student> getStudentsPerAssignmentWithNull(int assignmentId){
 
   List<Student> studentPerAss = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT  s.student_id,s.firstName,s.lastName,s.dateOfBirth,st.students_oral_mark,st.students_total_mark  " +
" FROM student_assignment as st , students as s " +
" where assignment_id=? and st.student_id=s.student_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignmentId);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
  
                int student_Id=resultSet.getInt("student_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();
          
                     Integer studentsOralMark=(Integer) resultSet.getObject("students_oral_mark");
                     Integer studentsTotalMark=(Integer) resultSet.getObject("students_total_mark");

                     if(studentsOralMark==null || studentsTotalMark==null){
                     
                     
                     
                
                // Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth)
                Student student = new Student( student_Id,firstName, lastName, dateOfBirth);
                studentPerAss.add(student);
                     }
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentPerAss;
 
 }

 
 
 
 
 public List<Student> getStudentsPerAssignmentWithNoNull(int assignmentId){
 
   List<Student> studentPerAss = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT  s.firstName,s.lastName,s.dateOfBirth,st.students_oral_mark,st.students_total_mark  " +
" FROM student_assignment as st , students as s " +
" where assignment_id=? and st.student_id=s.student_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignmentId);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
  
             
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();
          
                     Integer studentsOralMark=(Integer) resultSet.getObject("students_oral_mark");
                     Integer studentsTotalMark=(Integer) resultSet.getObject("students_total_mark");

                     if(studentsOralMark!=null && studentsTotalMark!=null){
                     
                     
                     
                
                // Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth)
                Student student = new Student( firstName, lastName, dateOfBirth);
                studentPerAss.add(student);
                     }
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentPerAss;
 
 }

 
 
 public Map<Student, String> getStudentsPerAssignment(int assignmentId){
 
//   Map<Student> studentPerAss = new ArrayList<>();
    Map<Student, String> studentPerAss = new HashMap<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT  s.firstName,s.lastName,s.dateOfBirth,st.students_oral_mark,st.students_total_mark  " +
" FROM student_assignment as st , students as s " +
" where assignment_id=? and st.student_id=s.student_id; ";

           preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignmentId);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
  
             
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();
          
                     Integer studentsOralMark=(Integer) resultSet.getObject("students_oral_mark");
                     Integer studentsTotalMark=(Integer) resultSet.getObject("students_total_mark");

                     String or;
                     String to ;
                  if(studentsOralMark==null){       or="null";          } 
                  else{ or = studentsOralMark.toString();}
                  
                  if(studentsTotalMark==null){  to="null";}
                  else{
                   to  = studentsTotalMark.toString();
                  }
                     String mark=  " Oral: " + or + " Total: " +to;
                     
                
                // Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth)
                Student student = new Student( firstName, lastName, dateOfBirth);
                studentPerAss.put(student, mark);
                     
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentPerAss;
 
 }

 
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
 
 public int insertStudent(String firstName, String lastName,LocalDate dateOfBirth) {
        int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO students (firstName,lastName,dateOfBirth) VALUES( ? , ? ,  ? ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

                
                java.sql.Date dateIn = Date.valueOf(dateOfBirth);
                
                
            preparedStatement.setDate(3, dateIn);

            
                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }

 
 public int insertTrainer(String first_name, String last_name,String subject) {
        int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO trainers (first_name,last_name,subject) VALUES( ? , ? ,  ? ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, subject);

                
               rowsAffected = preparedStatement.executeUpdate();
                
         
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }

 
 public int insertAssignment(String title, String description,LocalDate sub_date,int MaxTotal,int MaxOral) {
        int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO assignments (title,description,sub_date,oral_mark,total_mark) VALUES( ? , ? ,  ?, ? , ? ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);

                
                java.sql.Date dateIn = Date.valueOf(sub_date);
                
                
            preparedStatement.setDate(3, dateIn);
            
            preparedStatement.setInt(4,MaxOral);
            preparedStatement.setInt(5,MaxTotal);
            
                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }

 
 
 public int insertAssignToCourse(int assigId,int courseId){
 
            int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO course_assignment (course_id, assignment_id) VALUES (?, ?); ";

            preparedStatement = connection.prepareStatement(query);

            
            preparedStatement.setInt(1,courseId);
            preparedStatement.setInt(2,assigId);
            
               
            
            rowsAffected = preparedStatement.executeUpdate();
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
 
 
 
 
 }
 
 
 
 public int insertCourse(String title,String stream,String type,LocalDate startDate,LocalDate endDate,double cost) {
        int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO courses (title,steam,type,start_date,end_date,cost) VALUES( ? , ? ,  ?, ? , ? ,? ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, stream);
            preparedStatement.setString(3, type);

                
                java.sql.Date dateIn1 = Date.valueOf(startDate);
                
                
            preparedStatement.setDate(4, dateIn1);

            
                       java.sql.Date dateIn2 = Date.valueOf(endDate);
                
                
            preparedStatement.setDate(5, dateIn2);
            
            preparedStatement.setDouble(6,cost);
                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }

 public int insertStudentToCourse(int courseId,int studentId){
  int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO course_student(course_id,student_id) VALUES( ? , ?  ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);

                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
 }
 
 public int insertTrainerToCourse(int courseId,int trainerId){
 
 
  int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO course_trainer(course_id,trainer_id) VALUES( ? , ?  ); ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, trainerId);

                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
 
 
 
 
 
 
 
 
 }
 
 public int insertMarksToStudents(int studentId,int assignmentId, Integer stOralMark,Integer stTotalMark ){
 
 
  int rowsAffected = 0;

         java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " UPDATE student_assignment SET students_oral_mark=  ? ,students_total_mark= ? "
                    + " WHERE student_assignment.student_id= ? and student_assignment.assignment_id= ? ; ";
            

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(3, studentId);
            preparedStatement.setInt(4, assignmentId);
            
            if(stOralMark==null){
            preparedStatement.setNull(1, Types.NULL);
            }
            else{
            preparedStatement.setInt(1, stOralMark);
            }
            
            if(stTotalMark==null){
              preparedStatement.setNull(2, Types.NULL);
            }
            else{
              preparedStatement.setInt(2, stTotalMark);
            }
          
            
                
            
            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
 
 
 
 }
 
 
 public List<Student> studentBetweenDate(LocalDate min,LocalDate max){
 
        List<Student> studentsPerCourse = new ArrayList<>();

        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " select s.student_id, s.firstName,s.LastName,s.dateOfBirth,s.tutionFees " +
" from student_assignment as sa,students as s,assignments as a " +
" where  sa.student_id=s.student_id and sa.assignment_id=a.assignment_id " +
" and (sub_date between ? and ?) " +
" group by s.student_id; ";

           preparedStatement = connection.prepareStatement(query);
          
              java.sql.Date dateIn1 = Date.valueOf(min);
          preparedStatement.setDate(1, dateIn1);
            
               java.sql.Date dateIn2 = Date.valueOf(max);
          preparedStatement.setDate(2, dateIn2);
            
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                int studentID = resultSet.getInt("student_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                java.sql.Date date_Of_Birth = resultSet.getDate("dateOfBirth");
                LocalDate dateOfBirth = date_Of_Birth.toLocalDate();

                Double tutionFees = resultSet.getDouble("tutionFees");
     //--------------------------------------------------------------------------------------------------------------           
     //--------------------------------------------------------------------------------------------------------------           
   
// Student(int studentID, String firstName, String lastName, LocalDate dateOfBirth, double tutionFees)
                Student student = new Student(studentID, firstName, lastName, dateOfBirth, tutionFees);
                studentsPerCourse.add(student);
              
          
                
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentsPerCourse;
    
     
 
 
 }
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
  //------------------------------------------------------------------------------------------------------------------------------------------
    public List<Course> getCourses() {
        return courses;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
      
  
  
}
