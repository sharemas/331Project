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

    public static void main(String[] args) throws Exception {
      
}

    public static String[] DepNames(){
         String[] Names = new String[departmentList.size()];
         
     for(int i = 0; i < departmentList.size(); i++){
     Names[i] = departmentList.get(i).departmentName;
                }
     return Names;
    }
       
     public static String[] SemesterNames(){
         String[] Names = new String[SemesterList.size()];
         
     for(int i = 0; i < Main.SemesterList.size(); i++){
     Names[i] = SemesterList.get(i).period + " " + SemesterList.get(i).year;
                }
     return Names;
    }
        
            
    public static String[] CourseNames(){
         String[] Names = new String[courseList.size()];
         
     for(int i = 0; i < courseList.size(); i++){
     Names[i] = courseList.get(i).courseName;
                }
     return Names;
    }
    
        public static String[] FacultyNames(){
         String[] Names = new String[FacultyList.size()];
         
     for(int i = 0; i < FacultyList.size(); i++){
     Names[i] = FacultyList.get(i).name;
                }
     return Names;
    }
    
    
    public static String[] StudentNames(){
         String[] Names = new String[StudentList.size()];
         
     for(int i = 0; i < StudentList.size(); i++){
     Names[i] = StudentList.get(i).name;
                }
     return Names;
    }
    

    
}