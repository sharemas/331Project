import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	 public List<Department> departmentList;
	 public List<Course> courseList;

	public App() {
		  	
	        departmentList = new ArrayList<>();
	        courseList = new ArrayList<>();
	    }
	
	
    public static void main(String[] args) throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   App app = new App();
           
           
           boolean exit = false;
           
           while (!exit) {
        	   System.out.println("University Management System");
               System.out.println("\nChoose an option");
               System.out.println("1 - Create Student");
               System.out.println("2 - Create Course");
               System.out.println("3 - Create Faculty");
               System.out.println("4 - Create Department");
               System.out.println("5 - Show Faculty by Department");
               System.out.println("6 - Show Departments");
               System.out.println("7 - Assign Course to Faculty");
               System.out.println("8 - Print Student Enrollement by Course or Sem");
               System.out.println("9 - Print All Student Enrollement");
               System.out.println("10 - Delete Course");
               System.out.println("11 - Delete Faculty");
               System.out.println("0 - Exit");
               System.out.print("Enter your choice: ");
               
               int choice = scanner.nextInt();
               scanner.nextLine();
               
               switch (choice) {
                   case 1: 
                       System.out.println("Enter student's name: ");
                       String name = scanner.nextLine();
                       
                       System.out.println("Enter student's SSN: ");
                       int SSN = scanner.nextInt();
                       
                       System.out.println("Enter student's address: ");
                       String address = scanner.nextLine();
                       
                       System.out.println("Enter student's email: ");
                       String email = scanner.nextLine();
                       
                       System.out.println("Enter student's GPA: ");
                       double GPA = scanner.nextDouble();
                       
                       System.out.println("Enter student's contact name: ");
                       String contactName = scanner.nextLine();
                       
                       System.out.println("Enter student's contact number: ");
                       String contactNumber = scanner.nextLine();
                       
                       System.out.println("Enter student's contact address: ");
                       String contactAddress = scanner.nextLine();
                       
                      // app.createStudent(name, SSN, address, email, GPA, contactName, contactNumber, contactAddress);
                       System.out.println("Student created successfully!");
                       break;
                   
                   case 2: 
                       System.out.println("Enter course prefix: ");
                       String prefix = scanner.nextLine();
                       
                       System.out.println("Enter course number: ");
                       int courseNum = scanner.nextInt();
                       
                       System.out.println("Enter course name: ");
                       String courseName = scanner.nextLine();
                       
                       System.out.println("Enter numbers of days per week: ");
                       int daysWeek = scanner.nextInt();
                       
                       System.out.println("Enter start time: ");
                       String startTime = scanner.nextLine();
                       
                       System.out.println("Enter end time: ");
                       String endTime = scanner.nextLine();
                       
                       System.out.println("Enter numbers of credits: ");
                       int numCredits = scanner.nextInt();
                       
                       app.createCourse(prefix, courseNum, courseName, daysWeek, startTime, endTime, numCredits);
                       System.out.println("Course created successfully!");
                       break;
                       
                   case 3: 
                       System.out.println("Enter faculty name: ");
                       String facultyName = scanner.nextLine();
                       
                       System.out.println("Enter faculty email: ");
                       String facultyEmail = scanner.nextLine();
                       
                       System.out.println("Enter building name: ");
                       String buildingName = scanner.nextLine();
                       
                       System.out.println("Enter office number: ");
                       int officeNum = scanner.nextInt();
                       
                       System.out.println("Enter faculty phone number: ");
                       String phoneNumber = scanner.nextLine();
                       
                       System.out.println("Enter faculty department: ");
                       String department = scanner.nextLine();
                       
                       System.out.println("Enter faculty position: ");
                       String position = scanner.nextLine();
                       
                       app.createFaculty(facultyName, facultyEmail, buildingName, officeNum, phoneNumber, new Department(department), position);
                       System.out.println("Faculty created successully!");
                       break;
                       
           
               }
           }
       }
       
        	   
           
    
    
    public void createFaculty(String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
    	Faculty newFaculty = new Faculty(name, email, buildingName, officeNum,  phoneNum,  department,  position);
    	department.FacultyList.add(newFaculty);
    }
    
    public void createCourse(String prefix, int number, String courseName, int daysWeek,String startTime,String endTime, int numCredits) {
    	Course newCourse = new Course(prefix, number, courseName, daysWeek, startTime, endTime, numCredits);
    	courseList.add(newCourse);
    }
    
    
    
    
    
    
 
}
