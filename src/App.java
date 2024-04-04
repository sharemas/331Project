import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
    
    public static ArrayList<Department> departmentList;
    public static ArrayList<Course> courseList;
    public static ArrayList<Student> StudentList;
    public static ArrayList<Faculty> FacultyList;
	
    public static void main(String[] args) throws Exception {
    	   Scanner scanner = new Scanner(System.in);
           
           
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
                       
                       createCourse(prefix, courseNum, courseName, daysWeek, startTime, endTime, numCredits);
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
                       
                       createFaculty(facultyName, facultyEmail, buildingName, officeNum, phoneNumber, new Department(department), position);
                       System.out.println("Faculty created successully!");
                       break;
                       
           
               }
           }
       }
       
        	   
           
    
    
    public static void createFaculty(String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
    	Faculty newFaculty = new Faculty(name, email, buildingName, officeNum,  phoneNum,  department,  position);
    	department.FacultyList.add(newFaculty);
    }
    
    public static void createCourse(String prefix, int number, String courseName, int daysWeek,String startTime,String endTime, int numCredits) {
    	Course newCourse = new Course(prefix, number, courseName, daysWeek, startTime, endTime, numCredits);
    	courseList.add(newCourse);
    }
    
    public static void creatSemester(String DepartmentName){
    Department newDepartment = new Department(DepartmentName);
    departmentList.add(newDepartment);
    }
    
    public static String ShowStudents(){
        String gen = "";
        for(int i = 0; i < StudentList.size(); i ++){
            gen += "\n" + i+1 + ": " + StudentList.get(i).name;
        }
        return gen;
    }
    
     public static String ShowFaculty(){
        String gen = "";
        for(int i = 0; i < FacultyList.size(); i ++){
            gen += "\n" + i+1 + ": " + FacultyList.get(i).name;
        }
        return gen;
    }
     
      public static String ShowCourses(){
        String gen = "";
        for(int i = 0; i < courseList.size(); i ++){
            gen += "\n" + i+1 + ": " + courseList.get(i).courseName;
        }
        return gen;
    }
    
      public static void EditFaculty(int Faculty){
        String Options = "\nChoose Option:\n1.Name:\n2.Phone Number:\n3.Email:\n4.Building Name:\n5.Office Number:\n6.Position Title:";
        System.out.print("Select Student to edit:\n" + ShowFaculty() + Options);
        
        for(int i = 0; i < FacultyList.size(); i ++){
           if(i == Faculty-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           int Selection = sc.nextInt();
           
           if(Selection == 1){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           FacultyList.get(Faculty-1).name = input;
           break;
           }
           
           if(Selection == 2){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           FacultyList.get(Faculty-1).setPhoneNum(input);
           break;
           }
           
           if(Selection == 3){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           FacultyList.get(Faculty-1).setEmail(input);
           break;
           }
           
           if(Selection == 4){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           FacultyList.get(Faculty-1).buildingName = input;
           break;
           }
           
           if(Selection == 5){
           Scanner Input = new Scanner(System.in);
           int input = Integer.parseInt(Input.nextLine());
           FacultyList.get(Faculty-1).officeNum = input;
           break;
           }
           
           if(Selection == 6){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           FacultyList.get(Faculty-1).position = input;
           break;
           }
           }
        }
      }
      
      public static void EditCourse(int Course){
        String Options = "\nChoose Option:\n1.Name:\n2.Start Time:\n3.End Time:\n4.Days per week:\n5.Credits:";
        System.out.print("Select Student to edit:\n" + ShowCourses() + Options);
        
        for(int i = 0; i < courseList.size(); i ++){
           if(i == Course-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           int Selection = sc.nextInt();
           
           if(Selection == 1){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           courseList.get(Course-1).courseName = input;
           break;
           }
           
           if(Selection == 2){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           courseList.get(Course-1).startTime = input;
           break;
           }
            
           if(Selection == 3){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           courseList.get(Course-1).endTime = input;
           break;
           }
             
           if(Selection == 4){
           Scanner Input = new Scanner(System.in);
           int input = Integer.parseInt(Input.nextLine());
           courseList.get(Course-1).daysWeek = input;
           break;
           }
              
           if(Selection == 5){
           Scanner Input = new Scanner(System.in);
           int input = Integer.parseInt(Input.nextLine());
           courseList.get(Course-1).numCredits = input;
           break;
           }
           }
        }
      }
    
    
     public static void EditStudents(int Student){
        String Options = "\nChoose Option:\n1.Name:\n2.Address:\n3.Email:\n4.GPA:\n5.Contact Name:\n6.Contact Address:\n7.Contact Phone:";
        System.out.print("Select Student to edit:\n" + ShowStudents() + Options);
        
        for(int i = 0; i < StudentList.size(); i ++){
           if(i == Student-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           int Selection = sc.nextInt();
           
           if(Selection == 1){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).name = input;
           break;
           }
           
           if(Selection == 2){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).SetAddress(input);
           break;
           }
           
            if(Selection == 3){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).SetEmail(input);
           break;
           }
            
           if(Selection == 4){
           Scanner Input = new Scanner(System.in);
           double input = Double.parseDouble(Input.nextLine());
           StudentList.get(Student-1).GPA = input;
           break;
           }
           
           if(Selection == 5){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).contactName = input;
           break;
           }
           
            if(Selection == 6){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).SetContactAddress(input);
           break;
           }
            
           if(Selection == 7){
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           StudentList.get(Student-1).SetContactPhone(input);
           break;
           }
           }
        }
    }
    
    
 
}
