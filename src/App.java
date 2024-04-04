import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
    
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Faculty> FacultyList = new ArrayList<>();
    public static ArrayList<Semester> SemesterList = new ArrayList<>();
    public static ArrayList<Schedule> ScheduleList = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
    	   Scanner scanner = new Scanner(System.in);
           
           
           boolean exit = false;
           
           while (!exit) {
        	   System.out.println("\n");
               System.out.println("University Management System");
               System.out.println("\nChoose an option");
               
               System.out.println("1 - Create Student");
               System.out.println("2 - Create Course");
               System.out.println("3 - Create Faculty");
               System.out.println("4 - Create Department");
               System.out.println("5 - Create Semester");
               
               System.out.println("6 - Edit Student");
               System.out.println("7 - Edit Course");
               System.out.println("8 - Edit Faculty");
               
               System.out.println("9 - Assign Faculty to a Course");
               System.out.println("10 - Enroll Student in a Course");
               System.out.println("11 - Print Courses in a Semester");
               System.out.println("12 - Print Courses taught by a Faculty member in a Semester");
               
               System.out.println("13 - Print a Student's Enrolled Courses in a Semester");
               System.out.println("14 - Print a Course's Enrolled Students in a Semester");
               
               
              // System.out.println("5 - Show Faculty by Department");
            //   System.out.println("6 - Show Departments");
               //System.out.println("7 - Assign Course to Faculty");
           //    System.out.println("8 - Print Student Enrollement by Course or Sem");
           //    System.out.println("9 - Print All Student Enrollement");
            //   System.out.println("10 - Delete Course");
            //   System.out.println("11 - Delete Faculty");
            //   System.out.println("0 - Exit");
            //   System.out.print("Enter your choice: ");
               
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
                       
                       Student student = new Student(name,SSN,address,email,GPA,contactName,contactNumber,contactAddress);
                       StudentList.add(student);
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
                       // Method also adds to courseList
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
                       
           
                   case 4: 
                	   System.out.println("Enter a new department name: ");
                	   String departmentName = scanner.next();
                	   createDepartment(departmentName);
                	   break;
                	   
                   case 5:
                	   System.out.println("Enter a new semester period: ");
                	   String period = scanner.next();
                	   System.out.println("Enter a new semester year: ");
                	   int year = scanner.nextInt();
                	   createSemester(period, year);
                	  
                	   break;
                	   
                   case 6:

                       System.out.println("Select Student to edit: " + ShowStudents());
                       int studentSelection = scanner.nextInt(); 
                       EditStudents(studentSelection);
                	   
                	   break;
                	   
                   case 7: 
                	   // Edit Course
                	   
                   case 8:
                	   
                	   System.out.println("Select Faculty to edit:  " + ShowFaculty());
                	   int facultySelection = scanner.nextInt();
                	   EditFaculty(facultySelection);
                	  
                        
                	   
                   case 9:
                	   
                	   // assign faculty to course 
                	   
                			   
        			   break;
        			case 10:
        				
        				// enroll student in a course 
        				break;
        				
        			case 11:
        				// print course in a semester
        				break;
        			case 12:
        				//print courses taught by faculty memeber in a semester
        				break;
        					
        			case 13:
        				//print a student's enrolled courses in a semester  - masha
        				break;
        			case 14:
        				// print a course's enrolled students in a semester  - masha
        				break;
        				
        			case 15:
        				
        				// show all departments
                 	   showDepartments();
                 	   break;
                 	   
        			case 16:
        				
        				// show faculty in each department
        				
        				 System.out.println("Enter department name: ");
                  	   String showDepartmentName = scanner.next();
                  	   for (Department currDepartment: departmentList) {
                  		   if (currDepartment.departmentName.equalsIgnoreCase(showDepartmentName)) {
                  			   ArrayList<Faculty> departmentFaculty = currDepartment.FacultyList;
                  			   for (Faculty currFaculty: departmentFaculty) {
                  				   System.out.println(currFaculty.name);
                  			   }
                  		   }
                  	   }
                  	   
                  	   break;
        			
             	
               }
           }
       }
       
      public static void EnrollStudent(){
     Course course;
     Semester semester;
     
     System.out.print("Select Semester:\n" + showSemesters());
     Scanner SemesterSelect = new Scanner(System.in);
     int SemesterNum = SemesterSelect.nextInt();
     System.out.print("Select student to assign:\n" + ShowStudents());
     Scanner StudentSelect = new Scanner(System.in);
     int StudentNum = StudentSelect.nextInt();
     System.out.print("Select Course to assign to Student:\n" + ShowCourses());
     Scanner CourseSelect = new Scanner(System.in);
     int CourseNum = CourseSelect.nextInt();
     
     course = courseList.get(CourseNum-1);
     semester = SemesterList.get(SemesterNum-1);
     
     StudentList.get(StudentNum-1).enrollStudent(semester, course);
    }  	   
    
    
    public static void AssignFaculty(){



     Course course;
     Faculty faculty;
     Semester semester;
     
     System.out.print("Select Semester:\n" + showSemesters());
     Scanner SemesterSelect = new Scanner(System.in);
     int SemesterNum = SemesterSelect.nextInt();
     System.out.print("Select faculty to assign:\n" + ShowFaculty());
     Scanner FacultySelect = new Scanner(System.in);
     int FacultyNum = FacultySelect.nextInt();
     System.out.print("Select Course to assign to Faculty:\n" + ShowCourses());
     Scanner CourseSelect = new Scanner(System.in);
     int CourseNum = CourseSelect.nextInt();
     
     course = courseList.get(CourseNum-1);
     faculty = FacultyList.get(FacultyNum-1);
     semester = SemesterList.get(SemesterNum-1);
     
     Schedule newSchedule = new Schedule(semester,course,faculty);
     ScheduleList.add(newSchedule);
    }  	   
    public static void createSemester(String period, int year){
    	
    Semester newSemester = new Semester(period, year);
    SemesterList.add(newSemester);
    
    }   

    public static void createFaculty(String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
    	Faculty newFaculty = new Faculty(name, email, buildingName, officeNum,  phoneNum,  department,  position);
    	department.FacultyList.add(newFaculty);
    	FacultyList.add(newFaculty);
    }
    
    public static void createCourse(String prefix, int number, String courseName, int daysWeek,String startTime,String endTime, int numCredits) {
    	Course newCourse = new Course(prefix, number, courseName, daysWeek, startTime, endTime, numCredits);
    	courseList.add(newCourse);
    }
    
    public static void createDepartment(String DepartmentName){
    Department newDepartment = new Department(DepartmentName);
    departmentList.add(newDepartment);
    }
    
    public static String ShowStudents(){
        String gen = "";
        for(int i = 0; i < StudentList.size(); i ++){
            gen += "\n" + (i+1) + ": " + StudentList.get(i).name;
        }
        return gen;
    }
    
     public static String ShowFaculty(){
        String gen = "";
        for(int i = 0; i < FacultyList.size(); i ++){
            gen += "\n" + (i+1) + ": " + FacultyList.get(i).name;
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
      
      public static String showSemesters() {
    	  String gen = "";
    	  for (int i = 0; i < SemesterList.size(); i ++) {
    		  gen += "\n" + i + 1 + ": "+  SemesterList.get(i).period + " " + SemesterList.get(i).year;
    	  }
    	  
    	  return gen;
      }
      
      public static String showDepartments() {
    	  String gen = "";
    	  for (int i = 0; i < departmentList.size(); i ++) {
    		  gen += "\n" + i + 1 + ": "+  departmentList.get(i).departmentName;
    	  }
 
    	  return gen;
    	  
      }
    
      public static void EditFaculty(int Faculty){
    	  String Options = "\nChoose Option:\n1.Name:\n2.Phone Number:\n3.Email:\n4.Building Name:\n5.Office Number:\n6.Position Title:";
        
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

        
        for(int i = 0; i < StudentList.size(); i ++){
           if(i == Student-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           int Selection = sc.nextInt();
           
           if(Selection == 1) {
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
