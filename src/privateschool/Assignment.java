
package privateschool;

import java.time.LocalDate;
import java.util.Objects;




public class Assignment {
    
  private int  assignmentID;
  private String  title;
  private String  description;
  private LocalDate  subDateTime;

 // private int  MaxWrittenMark;
   private int  MaxTotalMark;
   private int  MaxOralMark;

   private Integer studentsOral;
   private Integer studentsTotal;
   
   private int courseID;
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------

      
//      String pattern = "dd/MM/yyyy";
//   SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------   

    public Assignment(String title, String description, LocalDate subDateTime, int MaxTotalMark, int MaxOralMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.MaxTotalMark = MaxTotalMark;
        this.MaxOralMark = MaxOralMark;
    }

   
   
   
   
   
    public Assignment( int assignmentID, String title, String description, LocalDate subDateTime,  int MaxTotalMark, int MaxOralMark) {
     
        this.assignmentID = assignmentID;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
       // this.MaxWrittenMark = MaxWrittenMark;
        this.MaxTotalMark = MaxTotalMark;
        this.MaxOralMark = MaxOralMark;
    }

    public Assignment(int courseID,int assignmentID, String title, String description, LocalDate subDateTime, int MaxTotalMark, int MaxOralMark, Integer studentsOral, Integer studentsTotal) {
          this.courseID=courseID;
        this.assignmentID = assignmentID;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.MaxTotalMark = MaxTotalMark;
        this.MaxOralMark = MaxOralMark;
        this.studentsOral = studentsOral;
        this.studentsTotal = studentsTotal;
    }

    
    
 //---------------------------------------------------------------------------
//---------------------------------------------------------------------------   

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }


    public int getMaxTotalMark() {
        return MaxTotalMark;
    }

    public void setMaxTotalMark(int MaxTotalMark) {
        this.MaxTotalMark = MaxTotalMark;
    }

    public int getMaxOralMark() {
        return MaxOralMark;
    }

    public void setMaxOralMark(int MaxOralMark) {
        this.MaxOralMark = MaxOralMark;
    }

    public Integer getStudentsOral() {
        return studentsOral;
    }

    public void setStudentsOral(Integer studentsOral) {
        this.studentsOral = studentsOral;
    }

    public Integer getStudentsTotal() {
        return studentsTotal;
    }

    public void setStudentsTotal(Integer studentsTotal) {
        this.studentsTotal = studentsTotal;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    
    
    
    
    
  //---------------------------------------------------------------------------
//---------------------------------------------------------------------------       

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assignment other = (Assignment) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subDateTime, other.subDateTime)) {
            return false;
        }
        return true;
    }

   

  
     
     
     
 
}
