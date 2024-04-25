package org.openjfx.projectpt3;
import java.util.ArrayList;

public class Course {

       public String prefix;
       public int number;
       public String courseName;
       public int daysWeek;
       public String startTime;
       public String endTime;
       public int numCredits;

       public ArrayList<Student> EnrolledStudents = new ArrayList<>();

       public Course(String prefix, int number, String courseName,
                     int daysWeek, String startTime, String endTime, int numCredits) {
              this.prefix = prefix;
              this.number = number;
              this.courseName = courseName;
              this.daysWeek = daysWeek;
              this.startTime = startTime;
              this.endTime = endTime;
              this.numCredits = numCredits;
       }

       public void AddStudent(Student student, Semester semester) {

              EnrolledStudents.add(student);
       }
       
        @Override
        public String toString() {
            String course = "";
            course += prefix + " " + number;
            return course; // for drop don
        }

}
