
package privateschool;

import java.util.Objects;


public class Trainer {
       
    private String firstName;
    private String lastName;
    private String subject;
    private int trainerID;
//------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------  

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }



    public Trainer(String firstName, String lastName, String subject, int trainerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.trainerID = trainerID;
    }

    
    
    
    /*
    Getter and Setters
    
    */   
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTrainerID() {
        return trainerID;
    }

    
       public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }
    
//------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------ 

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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

   

    
    @Override
    public String toString() {
        return "TrainerID=" + trainerID + "firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject ;
    }

   




}
