

import java.util.ArrayList;
import java.util.ArrayList;


public class Student {
   public String name;
   private int SSN;
   private static int Count;
   private int studentID;
   private String address;
   private String email;
   public double GPA;
   public String contactName;
   private String contactPhoneNumber;
   private String contactAddress;
   public ArrayList<Enrollment> StudentEnrollments = new ArrayList<>();
   
  public Student(String name, int SSN,String address,String email, double GPA,
         String contactName, String contactPhoneNumber, String contactAddress){
         studentID = Count;
         this.name = name;
         this.SSN = SSN;
         this.address = address;
         this.email = email;
         this.GPA = GPA;
         this.contactName = contactName;
         this.contactPhoneNumber = contactPhoneNumber;
         this.contactAddress = contactAddress;
         Count ++;
  }
        public void enrollStudent(Semester semester, Course course) {
          course.AddStudent(this, semester);
	}
	
	public void unenrollStudent(Enrollment enrollment) {
            for(int i = 0; i < StudentEnrollments.size(); i++){
            if(StudentEnrollments.get(i) == enrollment){
            enrollment.course.EnrolledStudents.remove(this);
            }
            }
            StudentEnrollments.remove(enrollment);
	}
        
        public String genStudentCourses(String CourseName){
        String gen = "";
        for(int i = 0; i < StudentEnrollments.size(); i++){
        if(StudentEnrollments.get(i).course.courseName.equals(CourseName)){
        gen += (i +1) + ":\t" + StudentEnrollments.get(i).course.courseName;
        }
        }
        return gen;
        }
        
        
  
    public int GetSSN(){
    return this.SSN;
    }
    
    public int GetStudentID(){
    return this.studentID;
    }
    
    public String GetEmail(){
    return this.email;
    }
    public void SetEmail(String email){
    this.email = email;
    }
    
    public String GetAddress(){
    return this.address;
    }
    
    public void SetAddress(String address){
    this.address = address;
    }
    
    public String GetContactPhone(){
    return this.contactPhoneNumber;
    }
    
    public void SetContactPhone(String contactPhoneNumber){
    this.contactPhoneNumber = contactPhoneNumber;
    }
    
    public String GetContactAddress(){
    return this.contactAddress;
    }
   
    public void SetContactAddress(String contactAddress){
    this.contactAddress = contactAddress;
    }
}

