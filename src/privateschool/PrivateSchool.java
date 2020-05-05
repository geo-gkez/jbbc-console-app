package privateschool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrivateSchool {

    public static void main(String[] args) throws ParseException {

        realMenu();

    }

    static Scanner sc = new Scanner(System.in);
    static Connection connection = new Connection();

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    //      System.out.println(formatter.format(dt))

    static void realMenu() {

        System.out.println("WELCOME");
        System.out.println();

        String pr;
        do {
            System.out.println();

            System.out.println("Insert student: 1");
            System.out.println("Insert trainer: 2");
            System.out.println("Insert assignments: 3"); // για το ερώτημα vii. assignments per student per course και iii.assignments 
            System.out.println("Insert course: 4");
            System.out.println("print all courses: 5");
            System.out.println("print all students: 6");
            System.out.println("print all trainers: 7");
            System.out.println("print all assignments: 8");
            System.out.println("Do you want to print all Students per course, press 9");
            System.out.println("Do you want to print all trainers per course, press 10");
            System.out.println("Do you want to print all assignments per course, press 11");
            System.out.println("Do you want to print all assignments per course per student, press 12");
            System.out.println("Students with more than one course, press 13 ");
            System.out.println("Add marks to student's, press 14 ");
            System.out.println("print list of student who should submit assign in specific week, press 15 ");
            System.out.println("Insert student to course, press 16 ");
            System.out.println("Insert trainer to course, press 17 ");            
            System.out.print("\nfor exit, press q or Q: ");

            pr = sc.next().toUpperCase();

            switch (pr) {
                case "1":
                    
                    addNewStudents();
                    
                    break;
                        
                case "2":
                    addNewTrainers();
                    
                    break;
                case "3":
                    addNewAssignment();
                    break;
                case "4":
                    
                    addNewCourse();
                    break;
                case "5":
                    printAllCourses();
                    break;
                case "6":

                    printAllStudents();

                    break;
                case "7":

                    printAllTrainers();

                    break;
                case "8":
                    printAllAssignments();
                    break;
                case "9":
                    
                     List<Course> allCoursesPerSt = connection.getAllCourses();
                    for(Course c:allCoursesPerSt){
                      System.out.println("Course ID: " + c.getCourseID() + ", Title: " + c.getTitle() + ", Stream: " + c.getStream()
                    + ", Type: " + c.getType() + ", start date: " + formatter.format(c.getStartDate())
                    + ", end date: " + formatter.format(c.getEndDate()) + ", Cost: " + c.getCost());
                      
                        System.out.println();
                        
                          printAllStudentsPerCourse(c.getCourseID());
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                    
                  
                    
                    break;
                case "10":

                                         List<Course> allCoursesPerTr = connection.getAllCourses();
                    for(Course c:allCoursesPerTr){
                      System.out.println("Course ID: " + c.getCourseID() + ", Title: " + c.getTitle() + ", Stream: " + c.getStream()
                    + ", Type: " + c.getType() + ", start date: " + formatter.format(c.getStartDate())
                    + ", end date: " + formatter.format(c.getEndDate()) + ", Cost: " + c.getCost());
                      
                        
                        System.out.println();
                        printAllTrainersPerCourse(c.getCourseID());
                        System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                    
                    
                    break;
                case "11":
                    
                        List<Course> allCoursesPerAs = connection.getAllCourses();
                    for(Course c:allCoursesPerAs){
                      System.out.println("Course ID: " + c.getCourseID() + ", Title: " + c.getTitle() + ", Stream: " + c.getStream()
                    + ", Type: " + c.getType() + ", start date: " + formatter.format(c.getStartDate())
                    + ", end date: " + formatter.format(c.getEndDate()) + ", Cost: " + c.getCost());
                      
                        
                        System.out.println();
                        printAllAssignmentsPerCourse(c.getCourseID());
                        System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                    
                    
                    break;
                case "12":
                    
                      List<Student> allStudents = connection.getAllStudents();
                      for(Student st:allStudents){
                      
                           System.out.println("Student ID: " + st.getStudentID() + ", First Name: " + st.getFirstName() + ", Last Name: " + st.getLastName()
                    + ", date of birth: " + formatter.format(st.getDateOfBirth()) + ", tution Fees: " + st.getTutionFees());
                           System.out.println();
                      printAllAssignmentsPerCoursePerStudent(st.getStudentID());
                          System.out.println("---------------------------------------------------------------------------------------");
                      }
                    
                    
                    break;
                case "13":
                    printStudentWithManyCourses();
                    break;
                case "14":
                    
                    giveMarksFirstTime();
                    
                    break;
                case "15":
                    
                    listOfStudentWhoShouldSubmitAssign();
                    break;
                case "16":
                    addStudentToCourse();
                    
                    break;
                case "17" :
                    addTrainerToCourse();
                    break;
                default:
                    break;
            }

        } while (!pr.equals("Q"));

    }

    static void printAllStudents() {

        List<Student> allStudents = connection.getAllStudents();

        for (Student st : allStudents) {

            System.out.println("Student ID: " + st.getStudentID() + ", First Name: " + st.getFirstName() + ", Last Name: " + st.getLastName()
                    + ", date of birth: " + formatter.format(st.getDateOfBirth()) + ", tution Fees: " + st.getTutionFees());

        }

    }

    static void printAllTrainers() {

        List<Trainer> allTrainers = connection.getAllTrainers();

        for (Trainer tr : allTrainers) {

            System.out.println("Trainer ID: " + tr.getTrainerID() + ", First Name: " + tr.getFirstName() + ", Last Name: "
                    + tr.getLastName() + ", subject: " + tr.getSubject());

        }

    }

    static void printAllAssignments() {
        List<Assignment> allAssignments = connection.getAllAssignments();

        for (Assignment as : allAssignments) {

            System.out.println("Assignment ID: " + as.getAssignmentID() + ", Title: " + as.getTitle() + ",  description" + as.getDescription()
                    + ", sub date: " + formatter.format(as.getSubDateTime()) + ", Max oral mark: " + as.getMaxOralMark() + ", Max total mark: " + as.getMaxTotalMark());

        }
    }

    static void printAllCourses() {

        List<Course> allCourses = connection.getAllCourses();

        for (Course c : allCourses) {

            System.out.println("Course ID: " + c.getCourseID() + ", Title: " + c.getTitle() + ", Stream: " + c.getStream()
                    + ", Type: " + c.getType() + ", start date: " + formatter.format(c.getStartDate())
                    + ", end date: " + formatter.format(c.getEndDate()) + ", Cost: " + c.getCost());

        }

    }

    static void printAllStudentsPerCourse(int courseID) {

        List<Student> studentsPerCourse = connection.getAllStudentsPerCourse(courseID);
                int counter=0;
        for (Student st : studentsPerCourse) {

            System.out.println("Student ID: " + st.getStudentID() + ", First Name: " + st.getFirstName() + ", Last Name: " + st.getLastName()
                    + ", date of birth: " + formatter.format(st.getDateOfBirth()) + ", tution Fees: " + st.getTutionFees());
            counter++;
        }
        System.out.println("The course has: "+counter+ " students");
    }

    
    static void printAllTrainersPerCourse(int courseID) {

        List<Trainer> trainersPerCourse = connection.getAllTrainersPerCourse(courseID);
                int counter=0;
        for (Trainer tr : trainersPerCourse) {

           
            System.out.println("Trainer ID: " + tr.getTrainerID() + ", First Name: " + tr.getFirstName() + ", Last Name: "
                    + tr.getLastName() + ", subject: " + tr.getSubject());
            
            counter++;
        }
        
        System.out.println("The course has: "+counter+" trainers");
    }
    
    
    static void printAllAssignmentsPerCourse(int courseID) {

        List<Assignment> assignmentsPerCourse = connection.getAllAssignmentsPerCourse(courseID);
                int counter=0;
        for (Assignment as : assignmentsPerCourse) {

           
             System.out.println("Assignment ID: " + as.getAssignmentID() + ", Title: " + as.getTitle() + ",  description" + as.getDescription()
                    + ", sub date: " + formatter.format(as.getSubDateTime()) + ", Max oral mark: " + as.getMaxOralMark() + ", Max total mark: " + as.getMaxTotalMark());

            counter++;
        }
        
        System.out.println("The course has: "+counter+" assignments");
    }
    
        static void printAllStudentsPerAssignment(int ass_id) {

        List<Assignment> assignmentsPerCourse = connection.getAllAssignmentsPerCourse(ass_id);
                int counter=0;
        for (Assignment as : assignmentsPerCourse) {

           
             System.out.println("Assignment ID: " + as.getAssignmentID() + ", Title: " + as.getTitle() + ",  description" + as.getDescription()
                    + ", sub date: " + formatter.format(as.getSubDateTime()) + ", Max oral mark: " + as.getMaxOralMark() + ", Max total mark: " + as.getMaxTotalMark());

            counter++;
        }
        
        System.out.println("The course has: "+counter+" assignments");
    }
    
    static void printAllAssignmentsPerCoursePerStudent(int studentID){
    
        Connection con=new Connection();
        
con.allAssignmentsPerCoursePerStudent(studentID);
    
    List<Course> courses= con.getCourses();
    List<Assignment> assignments=con.getAssignments();
    
    
    for(Course c: courses){
        
           System.out.println("Course ID: " + c.getCourseID() + ", Title: " + c.getTitle() + ", Stream: " + c.getStream()
                    + ", Type: " + c.getType() + ", start date: " + formatter.format(c.getStartDate())
                    + ", end date: " + formatter.format(c.getEndDate()) + ", Cost: " + c.getCost());
           System.out.println();
    for(Assignment as:assignments){
    
    if(c.getCourseID()==as.getCourseID()){
  
     System.out.println("Assignment ID: " + as.getAssignmentID() + ", Title: " + as.getTitle() + ",  description" + as.getDescription()
                    + ", sub date: " + formatter.format(as.getSubDateTime()) + ", Max oral mark: " + as.getMaxOralMark() 
             + ", Max total mark: " + as.getMaxTotalMark()+", students Oral Mark: "+as.getStudentsOral()+", students total Mark: "+as.getStudentsTotal());  
    }

    
    }
    
    
    System.out.println("--------------------------------------------------------------------------------------------------------------");
    
    
    }
    
    
    
    }
    
    static void printStudentWithManyCourses(){
    
    
                        Map<Student, Integer> students = connection.studentWithManyCourses();

                    students.forEach((st, count) ->
                        
                          System.out.println("Student ID: " + st.getStudentID() + ", First Name: " + st.getFirstName() + ", Last Name: " + st.getLastName()
                    + ", date of birth: " + formatter.format(st.getDateOfBirth()) + ", tution Fees: " + st.getTutionFees()+", He has "+count+" courses")
                            
                            
                    );
    
    
    
    
    
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    static void addNewStudents() {

        String askNew;
        // ArrayList<Student> newInputStudents = new ArrayList<>();
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
        boolean valid;
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Insert new students (number in names will removed) ");

        do {
            System.out.println();
            System.out.print("Insert first name of the student: ");

            String firstName = sc.next().trim().toUpperCase();
            // System.out.println(firstName);
            //System.out.println();
            firstName = vaildLetter(firstName);
            //----------------------------------------------------------------------------------------           
            //----------------------CHECK------------------------------------------------------------------
            //----------------------------------------------------------------------------------------

            while (firstName.isEmpty()) {
                System.out.println("First name is empty, please fill it to continue ");
                System.out.print("\nInsert first name of the student: ");
                firstName = sc.nextLine().trim().toUpperCase();
                firstName = vaildLetter(firstName);
            }
//----------------------------------------------------------------------------------------           
            //----------------------------------------------------------------------------------------

            System.out.print("\nInsert Last name of the student: ");
            String lastName = sc.next().trim().toUpperCase();
            // System.out.println(lastName);
            lastName = vaildLetter(lastName);
//----------------------------------------------------------------------------------------           
//----------------------CHECK------------------------------------------------------------------
            //----------------------------------------------------------------------------------------

            while (lastName.isEmpty()) {
                System.out.println("Last name is empty, please fill it to continue: ");
                System.out.print("\nInsert last name of the student: ");
                lastName = sc.nextLine().trim().toUpperCase();
                lastName = vaildLetter(lastName);
            }
//----------------------------------------------------------------------------------------           
//----------------------------------------------------------------------------------------

            System.out.print("\nInsert the date of birth (format:dd/MM/yyyy):  ");
            String date = sc.next().trim();
            valid = isValidDate(date);
            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            while (valid == false) {

                System.out.println("Invalid date try again!!!, you should type something like 28/12/2004 ");
                System.out.print("\nInsert date of birth again  (format:dd/MM/yyyy): ");
                date = sc.nextLine().trim();
                valid = isValidDate(date);

            }

            //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            LocalDate dateOfBirth = LocalDate.parse(date,formatter);

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
            Student newStudent = new Student(firstName, lastName, dateOfBirth);

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------           
    Connection con=new Connection();
    
  List<Student> students = con.getAllStudents();
    
    for(Student st: students){
    
    if(st.equals(newStudent)){
    
        System.out.println("This student is already on board");
    realMenu(); 
    return;
    }
    
    
    }
            
            
   
    
     int rowsAffected =  con.insertStudent(firstName, lastName, dateOfBirth);

                    if (rowsAffected == 0) {
                        System.out.println("Something went wrong.");
                    } else {
                        System.out.println("Student " + newStudent.getFirstName()+", "+newStudent.getLastName() + " was inserted successfully.");
                    }
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------  
         

            System.out.println();
            System.out.print("\nDo you want to add new student?   (Y/N): ");
            askNew = sc.next().toUpperCase();

        } while (askNew.equals("Y"));

    }

  static  void addNewTrainers()  {

        String askNew;
        String firstName;
        String lastName;
        String subject;

//////////////////////////////////////////////////////////////////        
//////////////////////////////////////////////////////////////////        
        System.out.println("Insert new trainer");

        do {
            System.out.print("\nInsert trainer's first name: ");
            firstName = sc.next().trim().toUpperCase();
            firstName = vaildLetter(firstName);
            //----------------------------------------------------------------------------------------
            //          CHECK
//---------------------------------------------------------------------------------------- 
            while (firstName.isEmpty()) {
                System.out.println("First name is empty, please fill it to continue: ");
                System.out.print("\nInsert first name of the trainer: ");
                firstName = sc.next().trim().toUpperCase();
                firstName = vaildLetter(firstName);
            }
            //----------------------------------------------------------------------------------------           
            //----------------------------------------------------------------------------------------
            System.out.print("\nInsert trainer's last name: ");
            lastName = sc.next().trim().toUpperCase();
            //----------------------------------------------------------------------------------------
            //          CHECK
//---------------------------------------------------------------------------------------- 
            while (lastName.isEmpty()) {
                System.out.println("Last name is empty, please fill it to continue: ");
                System.out.print("\nInsert first name of the trainer: ");
                lastName = sc.next().trim().toUpperCase();
                lastName = vaildLetter(lastName);
            }
//----------------------------------------------------------------------------------------           
//----------------------------------------------------------------------------------------
            System.out.print("\nInsert trainer's subject: ");
            subject = sc.next().trim().toUpperCase();

//----------------------------------------------------------------------------------------           
//----------------------------------------------------------------------------------------
            Trainer newTrainer = new Trainer(firstName, lastName, subject);

//----------------------------------------------------------------------------------------           
//------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------           


            
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------  

 Connection con=new Connection();
    
  List<Trainer> trainers = con.getAllTrainers();
    
    for(Trainer tr: trainers){
    
    if(tr.equals(newTrainer)){
    
        System.out.println("This trainer is already on board");
    realMenu(); 
    return;
    }
    
    
    }
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------  
        
         
          int rowsAffected =   con.insertTrainer(firstName,lastName,subject);

                    if (rowsAffected == 0) {
                        System.out.println("Something went wrong.");
                    } else {
                        System.out.println("Trainer " + newTrainer.getFirstName()+", "+newTrainer.getLastName() + " was inserted successfully.");
                    }
         
         
         

            System.out.print("\nDo you want to add new trainer?(Y/N): ");
            askNew = sc.next().toUpperCase();

        } while (askNew.equals("Y"));

    }

    
  static void addNewAssignment()  {

       
        Course CourseForAddAssignment;

        /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        ADD TO A COURSE
-------------------------------------------------------------------------------------------------------------------------------------------- 
         */
        
        System.out.println();
        System.out.println("Choose where to add the assignment ");
        System.out.println("The courses are: ");
        System.out.println();
        
        printAllCourses();

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("\nChoose the course where you want to add this Assignment by IDcourse: ");

        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild id try again: ");
            String t = sc.next();
        }

        int IDc = sc.nextInt();
        CourseForAddAssignment = null;

        //Connection con = new Connection();
        List<Course> allCourses = connection.getAllCourses();
        
        for (Course co : allCourses) {
            
                if (IDc == co.getCourseID()) {
                CourseForAddAssignment = co;

                break;
            }
            
        }

        if (CourseForAddAssignment == null) {
            System.out.print("\nInvaild id try again: ");
            addNewAssignment();
            return; 
        }

        addNewAssignment2(CourseForAddAssignment);

        System.out.print("\nDo you want to create new Assignment to a course? (Y/something else for no): ");
        String aN = sc.next().toUpperCase();

        if (aN.equals("Y")) {

            addNewAssignment();
            return;

        }

    }

  static void addNewAssignment2(Course CourseForAddAssignment) {
        
         String title;
        String description;
        String subDate;
        LocalDate subDateTime;
        int MaxOralMark;
        int MaxWrittenMark;
        int MaxTotalMark;
        String askNew;
            boolean validst;
        //Course CourseForAddAssignment;
        
        
    
        System.out.println("Create new Assignment: ");

        do {
            System.out.print("\nInsert title of new Assignment: ");
            title = sc.next().trim().toUpperCase();
            System.out.println();
            System.out.print("\nInsert the description for new Assignment: ");
            description = sc.next().trim().toUpperCase();

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------        
            System.out.print("\nInsert Submission date of Assignment (format:dd/MM/yyyy): ");
            subDate = sc.next().trim();
            validst = isValidDate(subDate);

            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input Submission 
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            while (validst == false) {

                System.out.print("Invalid date try again!!!, you should type something like 28/12/2004 ");
                System.out.print("\nInsert date when Submission date of Assignment is  (format:dd/MM/yyyy): ");
                subDate = sc.next().trim();
                validst = isValidDate(subDate);
                    
            }

             subDateTime = LocalDate.parse(subDate,formatter);
            boolean checkIfIsWeekend = checkIfIsWeekend(subDateTime);

            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check IF end Date of course is after start Date
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            while (subDateTime.compareTo(CourseForAddAssignment.getStartDate()) < 0 || checkIfIsWeekend == true) {
                // When Date d1 < Date d2 

                if (subDateTime.compareTo(CourseForAddAssignment.getStartDate()) < 0) {
                    System.out.println("Submission date is before start Date of this course!!!");
                }

                if (checkIfIsWeekend == true) {
                    System.out.println("Submission date must be between Monday and Friday, your input was: " + subDateTime);
                }

                System.out.print("\nInsert a new Submission date: ");
                subDate = sc.next().trim();
                validst = isValidDate(subDate);
                /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input
-------------------------------------------------------------------------------------------------------------------------------------------- 
                 */
                while (validst == false) {

                    System.out.println("Invalid date try again!!!, you should type something like 28/12/2004");
                    System.out.print("\nInsert date when course starts  (format:dd/MM/yyyy):");
                    subDate = sc.next().trim();
                    validst = isValidDate(subDate);

                }

                subDateTime = LocalDate.parse(subDate,formatter);
                checkIfIsWeekend = checkIfIsWeekend(subDateTime);
            }

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
            System.out.println();
            System.out.println("Which is the perfect totalMark score? ");
            System.out.print("\nChoose integer between 2 to 1000?:  ");
            MaxTotalMark = validIntMark(2, 1000);

            System.out.println();
            System.out.print("\n Choose integer between 0 to " + MaxTotalMark + " for the max oral marks: ");
            MaxOralMark = validIntMark(0, MaxTotalMark);
            MaxWrittenMark = MaxTotalMark - MaxOralMark;

            System.out.println("So the written Marks are: " + MaxWrittenMark);
            
        //-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------     
            
                                   
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------     
//(String title, String description, LocalDate subDateTime, int MaxTotalMark, int MaxOralMark)
Assignment newAssignment = new Assignment(title, description, subDateTime,MaxTotalMark, MaxOralMark);
             
            
                             List<Assignment> allAssignments = connection.getAllAssignments();

             for (Assignment as : allAssignments) {
                 
                  if (newAssignment.equals(as)) {
                      
                    System.out.println("You have already the Assignment with  "+ "Title: " + as.getTitle() + ",  description" + as.getDescription()
                    + ", sub date: " + formatter.format(as.getSubDateTime()) );
                        realMenu(); return;
                }
             }
            
            

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------  
          int courseId=CourseForAddAssignment.getCourseID();
           connection.insertAssignment(title, description, subDateTime, MaxTotalMark, MaxOralMark);
          
        List<Assignment> asi=   connection.getAllAssignments();
        
        int maxId=0;
        for(Assignment as: asi){
        
       int ID= as.getAssignmentID();
        if(ID>maxId){
        maxId=ID;
            
        }
   
        }
        
        
        
        connection.insertAssignToCourse(maxId, courseId);
//-------------------------------------------------------------------------------------------------------------------


            System.out.print("\nDo you want to add newAssignment to this course?(Y/N): ");
            askNew = sc.next().toUpperCase();

        } while (askNew.equals("Y"));
    
    
    
    
    
    
    }
    
  
  
  static void addNewCourse()  {

        String askNew;
        //ArrayList<Course> courses = new ArrayList<>();
        String title;
        String stream;
        String type;
        String courseStart;
        String courseEnd;
        LocalDate startDate;
        LocalDate endDate;
        String askCost;

        double cost = 0;
        //-------------------------------------------------------------------------------------------------------------------------------       
        //-------------------------------------------------------------------------------------------------------------------------------
        boolean validst;
        boolean valided;
        //-------------------------------------------------------------------------------------------------------------------------------       
        //-------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Create new Course: ");

        do {
            System.out.print("\nInsert title of new course: ");
            title = sc.next().trim().toUpperCase();
            System.out.println();
            System.out.print("\nInsert the stream of new course: ");
            stream = sc.next().trim().toUpperCase();
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
            System.out.println();
            System.out.println("Insert type of course:");
            System.out.println("Press 1 for Full-Time course");
            System.out.println("Press 2 for Part-Time course");
            System.out.println("Press 3 for typing other type of course: ");
            System.out.print("\nPress 1, 2 or 3: ");

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
            String tP = sc.next();

            switch (tP) {
                case "1":
                    type = "Full-Time";
                    break;
                case "2":
                    type = "Part-time";
                    break;
                case "3":
                    System.out.print("\nInsert  type of course: ");
                    type = sc.next().trim();
                    break;
                default:
                    System.out.println("Go again!!!");
                    addNewCourse();
                    return; 

            }

            //-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------        
            System.out.print("\nInsert start date of course(format:dd/MM/yyyy): ");
            courseStart = sc.next().trim();
            validst = isValidDate(courseStart);

            
            
            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input CouseStart
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            while (validst == false) {

                System.out.print("Invalid date try again!!!, you should type something like 28/12/2004 ");
                System.out.print("\nInsert date when course starts  (format:dd/MM/yyyy): ");
                courseStart = sc.next().trim();
                validst = isValidDate(courseStart);

            }

            // DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                 startDate = LocalDate.parse(courseStart,formatter);
            
            
                           LocalDate minDate=LocalDate.parse("01/01/2010",formatter);
               if(startDate.compareTo(minDate)<0){
                   System.out.println("end date is before 01/01/2010");
                   System.out.println("it imposible to start a course then");
                   realMenu(); return;
               }
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
            System.out.print("\nInsert end date of course (format:dd/MM/yyyy): ");
            courseEnd = sc.next().trim();
            valided = isValidDate(courseEnd);

            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            while (valided == false) {

                System.out.println("Invalid date try again!!!, you should type something like 28/12/2004");
                System.out.print("\nInsert date when course starts  (format:dd/MM/yyyy):");
                courseEnd = sc.next().trim();
                valided = isValidDate(courseEnd);

            }

           
            endDate = LocalDate.parse(courseEnd,formatter);
            /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check IF end Date of course is after start Date
-------------------------------------------------------------------------------------------------------------------------------------------- 
             */
            if (endDate.compareTo(startDate) < 0) {
                // When Date d1 < Date d2 
                System.out.println("endDate is before startDate");
                System.out.print("\nInsert  end date after the start date of the course: ");
                courseEnd = sc.next().trim();
                valided = isValidDate(courseEnd);
                /*-----------------------------------------------------------------------------------------------------------------------------------------                      
                        check date input
-------------------------------------------------------------------------------------------------------------------------------------------- 
                 */
            
                while (valided == false) {

                    System.out.println("Invalid date try again!!!, you should type something like 28/12/2004");
                    System.out.print("\nInsert date when course starts  (format:dd/MM/yyyy):");
                    courseEnd = sc.next().trim();
                    valided = isValidDate(courseEnd);

                }

                // DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                endDate = LocalDate.parse(courseEnd,formatter);
            } else if (endDate.compareTo(startDate) == 0) {

                // When Date d1 = Date d2 
                System.out.println("endDate is equal to startDate!!!");
                System.out.print("\nAre you sure for that? (if yes press Y or y, if not go back by pressing everything else): ");
                String ask=sc.next().toUpperCase();
                if(!ask.equals("Y")){  realMenu(); return;   }
            }
           
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------     
            
                        Course newCourse = new Course(title, stream, type, startDate, endDate);
           
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------     
            //-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------        

  Connection con=new Connection();
    
  List<Course> courses = con.getAllCourses();
    
    for(Course co: courses){
    
    if(co.equals(newCourse)){
    
        System.out.println("This course is already on board");
    realMenu(); 
    return;
    }
    
    
    }
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------       
//-----------------------CHECK COST OF COURSE--------------------------------------------------------------     
//-------------------------------------------------------------------------------------------------------------------       
            System.out.print("\nDo you want to add the cost of this course(Y/N): ");
            askCost = sc.next().toUpperCase();
            if (askCost.equals("Y")) {
                System.out.print("\n add cost in Euro: ");

                while (sc.hasNextDouble() == false) {

                    System.out.print("\nInvaild cost try again");
                    String t = sc.next();
                }
                cost = sc.nextDouble();

            }
            
                 newCourse.setCost(cost);
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------     
                     int rowsAffected =  con.insertCourse(title, stream, type, startDate, endDate,cost);

                    if (rowsAffected == 0) {
                        System.out.println("Something went wrong.");
                    } else {
                        System.out.println(" Title: " + newCourse.getTitle() + ", Stream: " + newCourse.getStream()
                    + ", Type: " + newCourse.getType() + ", start date: " + formatter.format(newCourse.getStartDate())
                    + ", end date: " + formatter.format(newCourse.getEndDate()) + ", Cost: " + cost);
                    }
               

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------  
           

            System.out.print("\nDo you want to add new course?(Y/N): ");
            askNew = sc.next().toUpperCase();

        } while (askNew.equals("Y"));

    }

  
  static void addStudentToCourse(){
     
      List<Course> allCourses = connection.getAllCourses();
      List<Student> allStudents = connection.getAllStudents();
      
      
                    if(allCourses.isEmpty()){ System.out.println(); System.out.println("There isn't courses"); realMenu(); return;  }
                if(allStudents.isEmpty()){ System.out.println(); System.out.println("There isn't students"); realMenu(); return;  }
                System.out.println();
                printAllCourses();
                System.out.println();
                System.out.println("Choose the course in which you want to add students by the id number ");
                //System.out.println("Choose the course in which you want to add students by the title press 2 ");
                // String adC = sc.next();
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------    
                System.out.print("Press  id of the course: ");
//-----------------------------------------------------------------------------------------------------------------------------   
//----------------------------------------------------------------------------------------------------------------------------- 
                int idCourse = idValid2VersionCourse(allCourses);
                
                 Course CourseToAdd=null;
                 
                for(Course c: allCourses){
                
                if(c.getCourseID()==idCourse){     CourseToAdd=c; break;      }
                    
                }
                
               
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------   
                        System.out.println();
                    printAllStudents();
                    System.out.println();
                    
                    if(CourseToAdd==null ){ System.out.println("something going wrong"); realMenu(); return;}
                    
                  //  List<Student> stOfCourse=connection.getAllStudentsPerCourse(CourseToAdd.getCourseID());
                    
                System.out.print("\nadd Students by id: ");
                int idStudent = idValid2VersionStudent(allStudents);
                
                 Student StudentToAdded = null;
                
                for(Student st: allStudents){
                
                    if(st.getStudentID()==idStudent){   StudentToAdded=st; break;  }
                
                }

//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
if( StudentToAdded==null){  System.out.println("something going wrong"); realMenu(); return;  }

                    List<Student> stOfCourse=connection.getAllStudentsPerCourse(CourseToAdd.getCourseID());
                    if(stOfCourse.isEmpty()){           }
                    else{
        for (Student stOC : stOfCourse) {
            if(stOC.getStudentID()==StudentToAdded.getStudentID()){   
                        System.out.println("You already have this student");
                        System.out.println("------------------------------------------------------------------------------");
                        realMenu();
                        return;
            
            }
            
        }
                    }          
                    
                
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------
 
                connection.insertStudentToCourse( CourseToAdd.getCourseID(), StudentToAdded.getStudentID());
                
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------
   
                System.out.println("Add successfull !!!");
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("Course " + CourseToAdd.getTitle() + ", " + CourseToAdd.getStream() + " has now the Students: ");
                System.out.println();
                printAllStudentsPerCourse(CourseToAdd.getCourseID());
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("------------------------------------------------------------------------------");
                System.out.print("I you want  more registers press Y, if not press something else: ");
                String ansd = sc.next().toUpperCase();
                if (ansd.equals("Y")) {
                    realMenu();
                    return;
                }

             
      
      
      
  }
  
  
  static void addTrainerToCourse(){
  
      
      List<Course> allCourses = connection.getAllCourses();
      List<Trainer> allTrainers = connection.getAllTrainers();
      
      
   if(allCourses.isEmpty()){ System.out.println(); System.out.println("There isn't courses"); realMenu(); return;  }
                 if(allTrainers.isEmpty()){ System.out.println(); System.out.println("There isn't trainers"); realMenu(); return;  }
                
                 System.out.println();
                 printAllCourses();
                 System.out.println();
                System.out.println("Choose the course in which you want to add trainers by the id number ");
                //System.out.println("Choose the course in which you want to add students by the title press 2 ");
                // String adC = sc.next();
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------    
                System.out.print("\nPress id of the course: ");
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
                int idCourse = idValid2VersionCourse(allCourses);
                Course CourseToAdd = null;
                
                for(Course c: allCourses){
                
                    if(c.getCourseID()==idCourse){   CourseToAdd=c;   }
                
                }
                
                
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------   
                        System.out.println();
                            printAllTrainers();
                            System.out.println();
                System.out.print("\nadd Trainer by id: ");
                int idTrainer = idValid2VersionTrainer(allTrainers);
                Trainer TrainerToAdded = null;
                
                for(Trainer tr:allTrainers){
                
                if(tr.getTrainerID()==idTrainer){ TrainerToAdded=tr; break;  }
                
                }
                
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------
if(CourseToAdd==null || TrainerToAdded==null){  System.out.println("something going wrong"); realMenu(); return;  }

List<Trainer> trainersOfCourse=connection.getAllTrainersPerCourse(CourseToAdd.getCourseID());

        for (Trainer tOc : trainersOfCourse) {
                 if (TrainerToAdded.getTrainerID()==tOc.getTrainerID() ) {
                        System.out.println("You already have this trainer");
                        System.out.println("------------------------------------------------------------------------------");

                        realMenu();
                        return;
                    }
            
        }
//-----------------------------------------------------------------------------------------------------------------------------   
//-----------------------------------------------------------------------------------------------------------------------------
               connection.insertTrainerToCourse(CourseToAdd.getCourseID(),TrainerToAdded.getTrainerID());

                System.out.println("Add successfull !!!");
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("Course " + CourseToAdd.getTitle() + ", " + CourseToAdd.getStream() + " has now the trainers: ");
                System.out.println();
                printAllTrainersPerCourse(CourseToAdd.getCourseID());
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("------------------------------------------------------------------------------");
                System.out.print("\nI you want  more registers press Y, if not press something else: ");
                String ansd = sc.next().toUpperCase();

                if (ansd.equals("Y")) {
                    realMenu();
                    return;
                }
              
  
  }
  
  
  
  static void giveMarksFirstTime(){
  
  System.out.println("###########################################");
        System.out.println("###########################################");
        
        System.out.println("Do you want to add marks to students? (if yes press Y): ");
        String y = sc.next().toUpperCase();
        
        List<Assignment> allAssignments=connection.getAllAssignments();
        
        if (y.equals("Y")) {



            System.out.println("------------------------------------------------------------------");
            printAllAssignments();
            System.out.println("------------------------------------------------------------------");
            System.out.println("select from assignments by id ");
            int idAssign = idValid2VersionAssignment(allAssignments);
            Assignment tempAssig=null ;
            
            
            for (Assignment ass : allAssignments) {
                
                if(ass.getAssignmentID()==idAssign){tempAssig=ass; break;}
                
            }
            
           if(tempAssig==null){System.out.println("Something is wrong");  realMenu(); return;}
           
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Assignment ID: " + tempAssig.getAssignmentID() + ", Title: " + tempAssig.getTitle() + ",  description" 
                    + tempAssig.getDescription()
                    + ", sub date: " + formatter.format(tempAssig.getSubDateTime()) + ", Max oral mark: " 
                    + tempAssig.getMaxOralMark() + ", Max total mark: " + tempAssig.getMaxTotalMark());

            int OMax = tempAssig.getMaxOralMark();
            int TMax = tempAssig.getMaxTotalMark();
            int TWrit=TMax-OMax;
            System.out.println("-------------------------------------------------------------------------------------");
            
            
            List<Student> studentsNull = connection.getStudentsPerAssignmentWithNull(tempAssig.getAssignmentID());
            
            for (Student S : studentsNull) {

                System.out.println(S);
                
                System.out.println("\nIf you want to not give mark to this student press N or n, else press something else to give marks: ");
                String quest=sc.next();
                if(quest.equals("N") || quest.equals("n")  ){
                    
                    
                    connection.insertMarksToStudents(S.getStudentID(),tempAssig.getAssignmentID(),null,null);
                    
                }
                else{  
                System.out.print("\nINSERT Oral Marks: ");
                          
                Integer oralMark = validIntMark(0, OMax);
                System.out.print("\nINSERT written Marks: ");
                int writtenMark = validIntMark(0, TWrit);
             
                Integer total = writtenMark + oralMark;

                //(int studentId,int assignmentId, int stOralMark,int stTotalMark )
                connection.insertMarksToStudents(S.getStudentID(),tempAssig.getAssignmentID(),oralMark,total);
                
                }
                
                

            }
            
         Map<Student,String> stPerAs= connection.getStudentsPerAssignment(tempAssig.getAssignmentID());
            System.out.println("###########################################");
            System.out.println("###########################################");
            
            
            stPerAs.forEach((st, marks) ->
                        
                          System.out.println("First Name: " + st.getFirstName() + ", Last Name: " + st.getLastName()
                    + ", date of birth: " + formatter.format(st.getDateOfBirth()) +", He has "+marks)
                            
                            
                    );
 

            giveMarksFirstTime();

        }
  
  
  
  }
  
  
  
  
   static void listOfStudentWhoShouldSubmitAssign()  {
        boolean validst;
       LocalDate dateIn;
        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("######################################################");
        System.out.println("######################################################");
        System.out.println();

        System.out.print("\nInsert a date to output a list of students who need to submit assignments on the same calendar week as given date: ");
        String dat = sc.next();
        validst = isValidDate(dat);

        while (validst == false) {

            System.out.print("Invalid date try again!!!, you should type something like 28/12/2004 ");
            System.out.print("\nInsert date when Submission date of Assignment is  (format:dd/MM/yyyy): ");
            dat = sc.next().trim();
            validst = isValidDate(dat);

        }

    
       
  dateIn = LocalDate.parse(dat,formatter);

      
    LocalDate monday = dateIn;
     while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
      monday = monday.minusDays(1);
    }

    
    LocalDate sunday=dateIn;
  while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
      sunday = sunday.plusDays(1);
    }
  
  
  
  List<Student> stBetweenDates=connection.studentBetweenDate(monday,sunday);
  
  if(stBetweenDates.isEmpty()){System.out.println("The isn't assignments for this date");}
  
  for(Student st:stBetweenDates){
      
       System.out.println(st);
  
  }
        System.out.println("Do you want to try for othe date? (Y for yes, anything else to exit): ");
        String re = sc.next().toUpperCase();
        if (re.equals("Y")) {
            listOfStudentWhoShouldSubmitAssign();
            return;
        }

    }

  
  //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
static String vaildLetter(String word) {

        StringBuilder str = new StringBuilder();
//------------------------------------------------------------------------------------------------------------------------            
//------------------------------------------------------------------------------------------------------------------------            
        for (int i = 0; i < word.length(); i++) {

            char letter = word.charAt(i);
            if (Character.isLetter(letter) || Character.isSpaceChar(letter)) {

                str = str.append(letter);

            }
            //----------------------------------------------------------------------------------------------------------------------         
//----------------------------------------------------------------------------------------------------------------------         
        }
        return (str.toString());

    }
    
 static  boolean isValidDate(String date) {

        String pattern = "dd/MM/yyyy";
        DateFormat sdf = new SimpleDateFormat(pattern);
        boolean valid = false;
        sdf.setLenient(valid);

        try {

            sdf.parse(date);

        } catch (ParseException e) {

            return false;
        }

        return true;

    }
  
    static boolean checkIfIsWeekend(LocalDate date){
    
         
        
     DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
    
     
      switch (day) {
         case SATURDAY:
          return true;
         case SUNDAY:
           return true;
         default:
            return false;
    }
      
    }
    
  static  int validIntMark(int min, int max) {

        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild marks try again: ");
            String t = sc.next();
        }

        int num = sc.nextInt();

        while (num < min || num > max) {
            System.out.print("\nInvaild id try again: ");

            if (sc.hasNextInt() == true) {
                num = sc.nextInt();

            } else {
                while (sc.hasNextInt() == false) {
                    System.out.print("\nInvaild id try again: ");
                    sc.next();

                    if (sc.hasNextInt() == true) {
                        num = sc.nextInt();

                        break;
                    }

                }
            }

        }

        return num;

    }
  
  
  static int idValid2VersionCourse(List<Course> list) {
    
         int id;
         boolean test=false;
         
        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild id try again: ");
            String t = sc.next();
        }
        
      id=sc.nextInt();
                for (Course c : list) {
            if(c.getCourseID()==id){  test=true;  break;  }
            
        }
      
         while (test==false) {

             
             
            System.out.print("\nInvaild id try again: ");

            if (sc.hasNextInt() == true) {
                id = sc.nextInt();

            } else {
                while (sc.hasNextInt() == false) {
                    System.out.print("\nInvaild id try again: ");
                    sc.next();

                    if (sc.hasNextInt() == true) {
                        id = sc.nextInt();

                        break;
                    }

                }
            }

                         
              for (Course c : list) {
            if(c.getCourseID()==id){  test=true;  break;  }
            
        }
            
            
        }
     
        return id;

    }

  static int idValid2VersionStudent(List<Student> list) {
    
       
         int id;
         boolean test=false;
         
        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild id try again: ");
            String t = sc.next();
        }
        
      id=sc.nextInt();
                for (Student st : list) {
            if(st.getStudentID()==id){  test=true;  break;  }
            
        }
      
         while (test==false) {

             
             
            System.out.print("\nInvaild id try again: ");

            if (sc.hasNextInt() == true) {
                id = sc.nextInt();

            } else {
                while (sc.hasNextInt() == false) {
                    System.out.print("\nInvaild id try again: ");
                    sc.next();

                    if (sc.hasNextInt() == true) {
                        id = sc.nextInt();

                        break;
                    }

                }
            }

                         
              for (Student st : list) {
            if(st.getStudentID()==id){  test=true;  break;  }
            
        }
            
            
        }
     
        return id;

    }
   
  
    static int idValid2VersionTrainer(List<Trainer> list) {
    
       
         int id;
         boolean test=false;
         
        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild id try again: ");
            String t = sc.next();
        }
        
      id=sc.nextInt();
                for (Trainer tr : list) {
            if(tr.getTrainerID()==id){  test=true;  break;  }
            
        }
      
         while (test==false) {

             
             
            System.out.print("\nInvaild id try again: ");

            if (sc.hasNextInt() == true) {
                id = sc.nextInt();

            } else {
                while (sc.hasNextInt() == false) {
                    System.out.print("\nInvaild id try again: ");
                    sc.next();

                    if (sc.hasNextInt() == true) {
                        id = sc.nextInt();

                        break;
                    }

                }
            }

                         
              for (Trainer tr : list) {
            if(tr.getTrainerID()==id){  test=true;  break;  }
            
        }
            
            
        }
     
        return id;

    }
    
 static  int idValid2VersionAssignment(List<Assignment> list) {
    
      
         int id;
         boolean test=false;
         
        while (sc.hasNextInt() == false) {

            System.out.print("\nInvaild id try again: ");
            String t = sc.next();
        }
        
      id=sc.nextInt();
                for (Assignment as : list) {
            if(as.getAssignmentID()==id){  test=true;  break;  }
            
        }
      
         while (test==false) {

             
             
            System.out.print("\nInvaild id try again: ");

            if (sc.hasNextInt() == true) {
                id = sc.nextInt();

            } else {
                while (sc.hasNextInt() == false) {
                    System.out.print("\nInvaild id try again: ");
                    sc.next();

                    if (sc.hasNextInt() == true) {
                        id = sc.nextInt();

                        break;
                    }

                }
            }

                         
              for (Assignment as : list) {
            if(as.getAssignmentID()==id){  test=true;  break;  }
            
        }
            
            
        }
     
        return id;

    }

      
}
