package org.openjfx.projectpt3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
     * Masha Share, Noah Kurtz, Tam Dang
     * Date: 4/05/2024
     * The purpose of the program is to allow for the creation of Sudents,
     * Faculty,Course, Semesters
     * and departments, as well as generating reports based on the
     * schedule/enrollements.
     * The program also allows for the assigning of courses to students and faculty.
     */

    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Faculty> FacultyList = new ArrayList<>();
    public static ArrayList<Semester> SemesterList = new ArrayList<>();
    public static ArrayList<Schedule> ScheduleList = new ArrayList<>();
     public static ArrayList<Enrollment> EnrollmentList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
      
}

   public static String FacultyCourses(Semester semester, Faculty faculty){
        	String gen = "";
        	for (int i = 0; i < ScheduleList.size(); i++){
        		
        		if (faculty == ScheduleList.get(i).faculty && semester == ScheduleList.get(i).semester){
        			gen += "\n" + String.format("%-10s%15s", ScheduleList.get(i).course.prefix, ScheduleList.get(i).course.courseName);
        		}
        }
        return gen;
        }
    
    //Design course which is taught in this semester, takes an input for semester
    //searches through schedule for courses and genrates string report based on the semester object that was found
    public static String CourseSemester(Semester semester, Student student){
        	String gen = "";     

        		for(int i = 0; i < EnrollmentList.size(); i++){
        			if(semester == EnrollmentList.get(i).semester && student ==  EnrollmentList.get(i).student){
        				gen += "\n" + String.format("%-10s%15s", ScheduleList.get(i).course.prefix,EnrollmentList.get(i).course.courseName);
        			}	
        		}
        return gen;
        }
    
    public static String StudentCourse(Course course, Semester semester){
    String gen = "";     
        	int count = 0;

        		for(int i = 0; i < EnrollmentList.size(); i++){
        			if(semester == EnrollmentList.get(i).semester && course ==  EnrollmentList.get(i).course){
        				count ++;
        				gen += "\n" + String.format("%-10s%30s", EnrollmentList.get(i).student.GetEmail(),EnrollmentList.get(i).student.name);
        			}	
        		}
        return gen;
    }
    
   
    
}
    
