package com.noahkurtz.databasep4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportFunctions {
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Faculty> FacultyList = new ArrayList<>();
    public static ArrayList<Semester> SemesterList = new ArrayList<>();
    public static ArrayList<Schedule> ScheduleList = new ArrayList<>();
    public static ArrayList<Enrollment> EnrollmentList = new ArrayList<>();


   public static String FacultyCourses(Semester semester, Faculty faculty){
        	String gen = "During " + semester + ", " + faculty + " is teaching: ";
        	for (int i = 0; i < ScheduleList.size(); i++){
        		
        		if (faculty == ScheduleList.get(i).faculty && semester == ScheduleList.get(i).semester){
        			gen += "\n" + String.format("%-10s%40s", ScheduleList.get(i).course.prefix + ScheduleList.get(i).course.number, ScheduleList.get(i).course.courseName);
        		}
        }
        return gen;
        }
    
    //Design course which is taught in this semester, takes an input for semester
    //searches through schedule for courses and genrates string report based on the semester object that was found
    public static String CourseSemester(Semester semester, Student student){
        	String gen = "During " + semester + ", " + student + " is taking: ";     

        		for(int i = 0; i < EnrollmentList.size(); i++){
        			if(semester == EnrollmentList.get(i).semester && student ==  EnrollmentList.get(i).student){
        				gen += "\n" + String.format("%-10s%40s", EnrollmentList.get(i).course.prefix + EnrollmentList.get(i).course.number, EnrollmentList.get(i).course.courseName);
        			}	
        		}
        return gen;
        }
    
    public static String StudentCourse(Course course, Semester semester){
    String gen = "During " + semester + ", " + course + " contains: ";     
        	int count = 0;

        		for(int i = 0; i < EnrollmentList.size(); i++){
        			if(semester == EnrollmentList.get(i).semester && course ==  EnrollmentList.get(i).course){
        				count ++;
        				gen += "\n" + String.format("%-10s%40s", EnrollmentList.get(i).student.GetEmail(),EnrollmentList.get(i).student.name);
        			}	
        		}
        return gen;
    }
    
    
       public static void updateDepartments() throws SQLException {
        String query = "SELECT * FROM DEPARTMENT";  
   
        try {
            App.runDBQuery(query, 'r'); 
        
            departmentList.clear(); 
        
            while (App.jsqlResults.next()) {
                String name = App.jsqlResults.getString(2);  
                departmentList.add(new Department(name)); 
            }
        
        } finally {
      
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close(); 
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close(); 
        }
    }
}
      
           public static void updateCourseList() throws SQLException {
                String query = "SELECT * FROM COURSE";  
                App.runDBQuery(query, 'r');  

                courseList.clear();  

                try {
                    while (App.jsqlResults.next()) {
                    String prefix = App.jsqlResults.getString(2);  
                    int number =  App.jsqlResults.getInt(3); 
                    String courseName =  App.jsqlResults.getString(4);
                    int daysWeek =  App.jsqlResults.getInt(5); 
                    String startTime =  App.jsqlResults.getString(6);  
                    String endTime =  App.jsqlResults.getString(7);  
                    int numCredits =  App.jsqlResults.getInt(8);

            // Add the course object to the list
            courseList.add(new Course(prefix, number, courseName, daysWeek, startTime, endTime, numCredits));
        }
    } finally {
        
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close();
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close();
        }
    }
}

            public static void updateStudentList() throws SQLException {
                String query = "SELECT * FROM STUDENT"; 
                App.runDBQuery(query, 'r');  
                StudentList.clear();  

                try {
                    while (App.jsqlResults.next()) {
                    
                    int ssn = App.jsqlResults.getInt(2);
                    String studentName =  App.jsqlResults.getString(3);
                    String address =  App.jsqlResults.getString(4); 
                    String email =  App.jsqlResults.getString(5); 
                    double gpa =  App.jsqlResults.getDouble(6); 
                    String contactName =  App.jsqlResults.getString(7);
                    String contactPhone =  App.jsqlResults.getString(8); 
                    String contactAddress =  App.jsqlResults.getString(9); 
                    
            // Add the course object to the list
            StudentList.add(new Student(studentName, ssn, address, email, gpa, contactName, contactPhone, contactAddress));
        }
    } finally {
        
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close();
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close();
        }
    }
}
            
             public static void updateFacultyList() throws SQLException {
        String query = "SELECT * FROM FACULTY";

        App.runDBQuery(query, 'r'); 

        FacultyList.clear(); 

        try {
            while (App.jsqlResults.next()) {
                // Extract data from the result set
                String name = App.jsqlResults.getString(2);
                String email = App.jsqlResults.getString(3);
                String buildingName = App.jsqlResults.getString(4);
                int officeNum = App.jsqlResults.getInt(5);
                String phoneNum = App.jsqlResults.getString(6);
                int departmentID = App.jsqlResults.getInt(7);
                String position = App.jsqlResults.getString(8);
                
                Department department = null;
                
                for (Department currDep: departmentList){
                    if (currDep.departmentID == departmentID){
                        department = currDep; 
                    } 
                }

                // Add the Faculty object to the list
                Faculty faculty = new Faculty(name, email, buildingName, officeNum, phoneNum, department, position);
                FacultyList.add(faculty);
            }
        } finally {
            
            if (App.jsqlStmt != null) {
                App.jsqlStmt.close();
            }
            if (App.jsqlConn != null) {
            App.jsqlConn.close();
            }
        }
    }
             
             
              public static void updateSemesterList() throws SQLException {
                String query = "SELECT * FROM Semesters"; 
                App.runDBQuery(query, 'r'); 
                
                SemesterList.clear();  

                try {
                    while (App.jsqlResults.next()) {
                    String period =  App.jsqlResults.getString(2);
                    int year =  App.jsqlResults.getInt(3); 
                  
                    
          
            SemesterList.add(new Semester(period, year));
        }
    } finally {
        
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close();
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close();
        }
    }
} 
              
              
              public static void updateEnrollmentList() throws SQLException {
                String query = "SELECT * FROM ENROLLMENT"; 
                App.runDBQuery(query, 'r');  
                EnrollmentList.clear();  

                try {
                    while (App.jsqlResults.next()) {
                    int courseID =  App.jsqlResults.getInt(1);
                    int studentID =  App.jsqlResults.getInt(2); 
                    int semesterID =  App.jsqlResults.getInt(3); 
              
                    Course course = null;
                    for (Course curr: courseList){
                        if (curr.courseID == courseID){
                            course = curr;
                            
                        }
                    }
                    
                    Student student = null;
                    for (Student curr: StudentList){
                        if (curr.studentID == studentID){  
                            student = curr;
                        }
                    }
                    
                    Semester semester = null;
                    for (Semester curr: SemesterList){
                        if (curr.semesterID == semesterID){
                            semester = curr;
                        }
                    }
                    
            // Add the course object to the list
            EnrollmentList.add(new Enrollment(semester, course , student));
        }
    } finally {
        
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close();
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close();
        }
    }
}
              
                public static void updateScheduleList() throws SQLException {
                String query = "SELECT * FROM SCHEDULE"; 
                App.runDBQuery(query, 'r');  
                ScheduleList.clear();  

                try {
                    while (App.jsqlResults.next()) {
                    int courseID =  App.jsqlResults.getInt(2);
                    int facultyID =  App.jsqlResults.getInt(3); 
                    int semesterID =  App.jsqlResults.getInt(1); 
              
                    Course course = null;
                    for (Course curr: courseList){
                        if (curr.courseID == courseID){
                            course = curr;
                            
                        }
                    }
                    
                    Faculty faculty = null;
                    for (Faculty curr: FacultyList){
                        if (curr.facultyID == facultyID){  
                            faculty = curr;
                        }
                    }
                    
                    Semester semester = null;
                    for (Semester curr: SemesterList){
                        if (curr.semesterID == semesterID){
                            semester = curr;
                        }
                    }
                    
          
            ScheduleList.add(new Schedule(semester, course , faculty));
        }
    } finally {
        
        if (App.jsqlStmt != null) {
            App.jsqlStmt.close();
        }
        if (App.jsqlConn != null) {
            App.jsqlConn.close();
        }
    }
}

}
    

    
   
    

    
