import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
		/*
    Masha Share, Noah Kurtz, Tam Dang
    Date: 4/05/2024
    The purpose of the program is to allow for the creation of Sudents, Faculty,Course, Semesters
    and departments, as well as generating reports based on the schedule/enrollements.
    The program also allows for the assigning of courses to students and faculty.
    */
    
    
    public static ArrayList<Department> departmentList = new ArrayList<>();
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Faculty> FacultyList = new ArrayList<>();
    public static ArrayList<Semester> SemesterList = new ArrayList<>();
    public static ArrayList<Schedule> ScheduleList = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
    	   Scanner scanner = new Scanner(System.in);
    	   // for testing 
    	   createCourse("TEST", 123, "TestCourse",
                   5, "08:00", "10:00", 3);
    	   StudentList.add(new Student("John Doe", 123456789, "123 Main St", "john@example.com",
                   3.8, "Jane Doe", "555-555-5555", "456 Elm St"));
    	   createFaculty("Jane Smith", "jane@example.com", "Smith Hall", 101,
                   "555-123-4567", new Department("department"), "Professor");
    	   createSemester("Period", 2023);
    	  // end testing stuff
           boolean exit = false;
           
           while (!exit) {
        	   System.out.println("==================================================================");
               System.out.printf("%s", "University Management System");
               System.out.printf("%s","\nChoose an option\n");
               
               System.out.printf("%2d%s",1,"-Create Student\n");
               System.out.printf("%2d%s",2,"-Create Course\n");
               System.out.printf("%2d%s",3,"-Create Faculty\n");
               System.out.printf("%2d%s",4,"-Create Department\n");
               System.out.printf("%2d%s",5,"-Create Semester\n");
               
               System.out.printf("%2d%s",6,"-Edit Student\n");
               System.out.printf("%2d%s",7,"-Edit Course\n");
               System.out.printf("%2d%s",8,"-Edit Faculty\n");
               
               System.out.printf("%2d%s",9,"-Assign Faculty to a Course\n");
               System.out.printf("%2d%s",10,"-Enroll Student in a Course\n");
               System.out.printf("%2d%s",11,"-Print Courses in a Semester\n");
               System.out.printf("%2d%s",12,"-Print Courses taught by a Faculty member in a Semester\n");
               
               System.out.printf("%2d%s",13,"-Print a Student's Enrolled Courses in a Semester\n");
               System.out.printf("%2d%s",14,"-Print a Course's Enrolled Students in a Semester\n");
               System.out.printf("%2d%s",15,"-Exit\n");
               System.out.println();
               System.out.printf("%2s","Enter your choice: \n");

               int choice = scanner.nextInt();
               scanner.nextLine();
               
               switch (choice) {
                   case 15:
                	exit = true; 
                	break;
                            

                   case 1: 
                	   System.out.println("==================================================================");
                	   System.out.println("Creating new student");
                	   System.out.println();
                       System.out.print("Enter student's name: ");
                       String name = scanner.nextLine();
                       System.out.println();
                       
                       int SSN = 0; 
                       
                       while (true) {
                           try {
                               System.out.print("Enter student's SSN: ");
                               SSN = scanner.nextInt();
                               scanner.nextLine(); 
                               break;
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer.");
                               scanner.nextLine(); 
                               
                           }
                       }
                       System.out.println();
                       System.out.print("Enter student's address: ");
                       String address = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter student's email: ");
                       String email = scanner.nextLine();
                       System.out.println();
                       
                       double GPA = 0.0;
                       
                       while (true) {
                           try {
                               System.out.print("Enter student's GPA: ");
                               GPA = scanner.nextDouble();
                               scanner.nextLine(); 
                               break; 
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid decimal.");
                               scanner.nextLine(); 
                           }
                       }
                       System.out.println();
                       System.out.print("Enter student's contact name: ");
                       String contactName = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter student's contact number: ");
                       String contactNumber = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter student's contact address: ");
                       String contactAddress = scanner.nextLine();
                       System.out.println();
                       
                       Student student = new Student(name,SSN,address,email,GPA,contactName,contactNumber,contactAddress);
                       StudentList.add(student);
             //          Student studentTest = StudentList.get(StudentList.size() - 1);
              //       System.out.println(studentTest.name + studentTest.GetSSN() + studentTest.GetStudentID() + studentTest.GetEmail() + studentTest.GetAddress() +  studentTest.GPA + studentTest.contactName + studentTest.GetContactPhone() + studentTest.GetContactAddress());
                       System.out.println("Student created successfully!");

                       break;
                   
                   case 2: 
                	   System.out.println("==================================================================");
                	   System.out.println("Creating new course");
                	   System.out.println();
                       System.out.print("Enter course prefix: ");
                       String prefix = scanner.nextLine();
                       System.out.println();
                       
                       int courseNum = 0; 
                       
                       while (true) {
                           try {
                               System.out.print("Enter course number: ");
                               courseNum = scanner.nextInt();
                               scanner.nextLine(); 
                               break;
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for course number.");
                               scanner.nextLine(); 
                           }
                       }
                       
                       System.out.println();
                       System.out.print("Enter course name: ");
                       String courseName = scanner.nextLine();
                       System.out.println();
                       
                       int daysWeek = 0; 
                       
                       while (true) {
                           try {
                               System.out.print("Enter numbers of days per week: ");
                               daysWeek = scanner.nextInt();
                               scanner.nextLine(); 
                               break;
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for number of days per week.");
                               scanner.nextLine();
                       }
                       }
                       System.out.println();
                       
                       System.out.print("Enter start time: ");
                       String startTime = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter end time: ");
                       String endTime = scanner.nextLine();
                       System.out.println();
                       
                       int numCredits = 0; 
                       
                       while (true) {
                           try {
                               System.out.print("Enter number of credits: ");
                               numCredits = scanner.nextInt();
                               scanner.nextLine(); 
                               break; 
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for number of credits.");
                               scanner.nextLine(); 
                           }
                       }

                       
                       createCourse(prefix, courseNum, courseName, daysWeek, startTime, endTime, numCredits);
                       
                 //      Course testCourse = courseList.get(courseList.size() - 1);
                       
              //        System.out.println(testCourse.courseName + testCourse.prefix + testCourse.number + testCourse.daysWeek + testCourse.startTime + testCourse.endTime + testCourse.numCredits);
                       
                       System.out.println("Course created successfully!");
                       AssignFaculty();
                       break;
                       
                   case 3: 
                	   System.out.println("==================================================================");
                	   System.out.println("Creating a new faculty member");
                	   System.out.println();
                       System.out.print("Enter faculty name: ");
                       String facultyName = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter faculty email: ");
                       String facultyEmail = scanner.nextLine();
                       System.out.println();
                       
                       System.out.print("Enter building name: ");
                       String buildingName = scanner.nextLine();
                       System.out.println();
                       
                       int officeNum = 0; 
                       
                       while (true) {
                           try {
                               System.out.print("Enter office number: ");
                               officeNum = scanner.nextInt();
                               scanner.nextLine(); 
                               break; 
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for office number.");
                               scanner.nextLine();
                           }
                       }
                       System.out.println();
                       
                       System.out.print("Enter faculty phone number: ");
                       String phoneNumber = scanner.nextLine();
                       System.out.println();
                       
                       
                       System.out.print("Select a number to enter faculty department: ");
                       
                       System.out.println();
                       
                       Department facultyDepartment = null; 
                      
                       if (departmentList.isEmpty()) {
                    	   System.out.println("No departments found, please create a new one");
                    	   System.out.print("Please enter department name: ");
                    	   String departmentName = scanner.nextLine();
                    	   facultyDepartment = new Department(departmentName);
                    	   departmentList.add(facultyDepartment);
                    	  
                       } else {

                    	   for (int i = 0; i < departmentList.size(); i++) {
                               Department currDepartment = departmentList.get(i);
                               System.out.println((i + 1) + ": " + currDepartment.departmentName);
                           }
                    	   
                    	   int departmentIndex = -1;
                           while (departmentIndex < 0 || departmentIndex >= departmentList.size()) {
                             
                               if (scanner.hasNextInt()) {
                                   departmentIndex = scanner.nextInt() - 1; 
                                   scanner.nextLine(); 
                                   if (departmentIndex < 0 || departmentIndex >= departmentList.size()) {
                                       System.out.println("Invalid department number. Please try again.");
                                   }
                               } else {
                                   System.out.println("Invalid input. Please enter a number.");
                                   scanner.nextLine(); }
                           }

                           facultyDepartment = departmentList.get(departmentIndex);
                       }
                       
                       System.out.println();                     
                       System.out.print("Enter faculty position: ");
                       String position = scanner.nextLine();
                       System.out.println();
   
                       createFaculty(facultyName, facultyEmail, buildingName, officeNum, phoneNumber, facultyDepartment, position);
                       System.out.println("Faculty created successully!");
                       break;
                       
           
                   case 4: 
                	   System.out.println("==================================================================");
                	   System.out.println("Creating a new department");
                	   System.out.println();
                	   System.out.print("Enter a new department name: ");
                	   String departmentName = scanner.next();
                	   createDepartment(departmentName);
                	   System.out.println("Department created successully!");
              //  	   Department testDepartment = departmentList.get(0);
             //   	   System.out.println(testDepartment.departmentName);
                	   break;
                	   
                   case 5:
                	   System.out.println("==================================================================");
                	   System.out.println("Creating a new semester");
                	   System.out.println();
                	   System.out.print("Enter a new semester period: ");
                	   String period = scanner.next();
                	   int year = 0;

                       while (true) {
                           try {
                               year = scanner.nextInt();
                               scanner.nextLine(); 
                               break; 
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for the year.");
                               scanner.nextLine();
                           }
                       }
                	   createSemester(period, year);
                	   System.out.println("Semester created successully!");
                	 //  Semester testSemester = SemesterList.get(0);
                     //  System.out.println(testSemester.period + testSemester.year);
                	   break;

                	   
                   case 6:
                	System.out.println("==================================================================");
                	System.out.println("Editing a student");
                	System.out.println();
                    System.out.println("Select Student to edit: " + ShowStudents());
                    int studentSelection = 0;

                    while (true) {
                        try {
                            studentSelection = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            if (studentSelection < 1 || studentSelection > StudentList.size()) {
                                System.out.println("Please select a student from the list.");
                                continue; 
                            }
                            
                            EditStudents(studentSelection);
                            break; 
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Please enter a valid integer for the student selection.");
                            scanner.nextLine(); 
                        }
                    }
                        
                        break;
                    
                   case 7: 
                	System.out.println("==================================================================");
                	System.out.println("Editing a course");
                	System.out.println();
                	System.out.println("Select Course to edit: " + ShowCourses());
                	   int courseSelection = 0;

                       while (true) {
                           try {
                               courseSelection = scanner.nextInt();
                               scanner.nextLine(); 
                               
                               if (courseSelection < 1 || courseSelection > courseList.size()) {
                                   System.out.println("Please select a course from the list.");
                                   continue; 
                               }
                               
                               EditCourse(courseSelection);
                               break; 
                           } catch (java.util.InputMismatchException e) {
                               System.out.println("Please enter a valid integer for the course selection.");
                               scanner.nextLine(); 
                           }
                       }
                       break;
                   

                   case 8:
                	System.out.println("==================================================================");
                	System.out.println("Editing a faculty member");
                	System.out.println();                	   
                	System.out.println("Select faculty to edit:  " + ShowFaculty());
                	 int facultySelection = 0;

                     while (true) {
                         try {
                             facultySelection = scanner.nextInt();
                             scanner.nextLine();
                             
                             if (facultySelection < 1 || facultySelection > FacultyList.size()) {
                                 System.out.println("Please select a faculty from the list");
                                 continue; 
                             }
                             
                             EditFaculty(facultySelection);
                             break; 
                         } catch (java.util.InputMismatchException e) {
                             System.out.println("Please enter a valid integer for the faculty selection.");
                             scanner.nextLine(); 
                     }    	
                     }
                	break;
	   
                   case 9:
                	System.out.println("==================================================================");
                	System.out.println("Assigning a faculty member to a course");
                	System.out.println(); 
                	AssignFaculty();
                        break;
        			   
        	    case 10:
                        System.out.println("==================================================================");
                        System.out.println("Enrolling a student in a course");
                        EnrollStudent();
                        break; 
                    case 11: 
                        System.out.println(CourseSemester());
                        break;
                    case 12: 
                        System.out.println("==================================================================");
                        System.out.println("Printing course taught by a faculty member");
                        System.out.println(FacultyCourses());
			break;
		     case 13: 
                        System.out.println("Please enter a student: " + ShowStudents());
                        int studentSelectionforCourse = scanner.nextInt();
                        System.out.println("Please enter a semester: " + showSemesters());
                        int semester = scanner.nextInt();
                        showStudentEnrollments(studentSelectionforCourse, semester);
                        break;
                    case 14: 
                        System.out.println("Please enter a course: " + ShowCourses());
                        int courseSelection2 = scanner.nextInt();
                        System.out.println("Please enter a semester: " + showSemesters());
                        int semesterSelection = scanner.nextInt();
                        showCoursesStudents(courseSelection2, semesterSelection);
                        break;
                    
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 14.");
                        break;       
               }
           }
       }
//Design for listing course taught by faculty member
    public static String FacultyCourses(){
        	String gen = "";
        	Semester semester;
        	Faculty faculty;
        	int count = 0;
        	Scanner Select = new Scanner(System.in);
        	System.out.println("Select Semester:\n" + showSemesters());
        	int SemesterNum = Select.nextInt();
        	semester = SemesterList.get(SemesterNum-1);
        	System.out.println();
        	
        	System.out.println("Select Faculty:\n" + ShowFaculty());
        	int FacultyNum = Select.nextInt();
        	faculty = FacultyList.get(FacultyNum-1); 
        	
        	System.out.println();
        	System.out.println("Courses taught by " + faculty.name + " in " + semester.period + " " + semester.year);
        	
        	for (int i = 0; i < ScheduleList.size(); i++){
        		
        		if (faculty == ScheduleList.get(i).faculty && semester == ScheduleList.get(i).semester){
        			count ++;
        			gen += "\n" + count + ":" + ScheduleList.get(i).course.courseName;
        		}
        }
        return gen;
        }
    
    //Design course which is taught in this semester
    public static String CourseSemester(){
        	String gen = "";
        	Semester semester;
        	int count = 0;
        	Scanner Select = new Scanner(System.in);
        	System.out.print("Select Semester:\n" + showSemesters());
        	int SemesterNum = Select.nextInt();
        	semester = SemesterList.get(SemesterNum-1);
        		for(int i = 0; i < ScheduleList.size(); i++){
        			if(semester == ScheduleList.get(i).semester){
        				count ++;
        				gen += "\n" + count + ":" + ScheduleList.get(i).course.courseName;
        			}	
        		}
        return gen;
        }
    //Facilitate the enrollement process of a student into a course for a specific semester
    public static void EnrollStudent(){
     Course course;
     Semester semester;
     
     Scanner scanner = new Scanner(System.in);
     
     int semesterNum = 0;
     int courseNum = 0;
     int studentNum = 0;
     
     //for semester 
     while (true) {
         try {
             System.out.println("Select Semester:\n" + showSemesters());
             semesterNum = scanner.nextInt();
             if (semesterNum < 1 || semesterNum > SemesterList.size()) {
                 System.out.println("Please enter a valid semester number.");
                 continue; 
             }
             break; 
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the semester selection.");
             scanner.nextLine(); 
         }
     }
     
     // for student selection
     while (true) {
         try {
             System.out.println("Select a Student to assign:\n" + ShowStudents());
             studentNum = scanner.nextInt();
             if (studentNum < 1 || studentNum > StudentList.size()) {
                 System.out.println("Please enter a valid student number.");
                 continue; 
             }
             break; 
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the student selection.");
             scanner.nextLine(); 
         }
     }
     
     // Select Course
     while (true) {
         try {
             System.out.println("Select Course to assign to Student:\n" + ShowCourses());
             courseNum = scanner.nextInt();
             if (courseNum < 1 || courseNum > courseList.size()) {
                 System.out.println("Please enter a valid course number.");
                 continue; 
             }
             break; 
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the course selection.");
             scanner.nextLine(); 
         }
     }  
     
     
     course = courseList.get(courseNum-1);
     semester = SemesterList.get(semesterNum-1);
     
     StudentList.get(studentNum-1).enrollStudent(semester, course);
    }  	   
    
    //Assigned faculty for the specific course and semester
    public static void AssignFaculty(){


     Course course;
     Faculty faculty;
     Semester semester;
     
     Scanner scanner = new Scanner(System.in);
     
     int semesterNum = 0;
     int facultyNum = 0;
     int courseNum = 0;

     // Select Semester
     while (true) {
         try {
             System.out.println("Select Semester:\n" + showSemesters());
             semesterNum = scanner.nextInt();
             if (semesterNum < 1 || semesterNum > SemesterList.size()) {
                 System.out.println("Please enter a valid semester number.");
                 continue; 
             }
             break; 
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the semester selection.");
             scanner.nextLine(); 
         }
     }

     // Select Faculty
     while (true) {
         try {
             System.out.println("Select faculty to assign:\n" + ShowFaculty());
             facultyNum = scanner.nextInt();
             if (facultyNum < 1 || facultyNum > FacultyList.size()) {
                 System.out.println("Please enter a valid faculty number.");
                 continue; 
             }
             break;
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the faculty selection.");
             scanner.nextLine(); 
         }
     }

     // Select Course
     while (true) {
         try {
             System.out.println("Select Course to assign to Faculty:\n" + ShowCourses());
             courseNum = scanner.nextInt();
             if (courseNum < 1 || courseNum > courseList.size()) {
                 System.out.println("Please enter a valid course number.");
                 continue; 
             }
             break; 
         } catch (java.util.InputMismatchException e) {
             System.out.println("Please enter a valid integer for the course selection.");
             scanner.nextLine(); 
         }
     }  
     
     course = courseList.get(courseNum-1);
     faculty = FacultyList.get(facultyNum-1);
     semester = SemesterList.get(semesterNum-1);
     
     Schedule newSchedule = new Schedule(semester,course,faculty);
     ScheduleList.add(newSchedule);
     System.out.println("Successfully assigned "+  faculty.name + " to teach " + course.prefix + " " + course.number);
 
    }  	   
    //Stored all the semesters in the system
    public static void createSemester(String period, int year){
    	
    Semester newSemester = new Semester(period, year);
    SemesterList.add(newSemester);
    
    }  
    //Creating a new faculty member within the system and associate that faculty to the specific department
    public static void createFaculty(String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
    Faculty newFaculty = new Faculty(name, email, buildingName, officeNum,  phoneNum,  department,  position);
    department.FacultyList.add(newFaculty);
    FacultyList.add(newFaculty);
    }
    
    // Creating new courses and adding that the current course list
    public static void createCourse(String prefix, int number, String courseName, int daysWeek,String startTime,String endTime, int numCredits) {
    	Course newCourse = new Course(prefix, number, courseName, daysWeek, startTime, endTime, numCredits);
    	courseList.add(newCourse);
    }
    //Creating new department and additing that to the current department list
    public static void createDepartment(String DepartmentName){
    Department newDepartment = new Department(DepartmentName);
    departmentList.add(newDepartment);
    }
   //Display the string of students 
    public static String ShowStudents(){
        String gen = "";
        for(int i = 0; i < StudentList.size(); i ++){
            gen += "\n" + (i+1) + ": " + StudentList.get(i).name;
        }
        return gen;
    }
    //Display the string of faculty
     public static String ShowFaculty(){
        String gen = "";
        for(int i = 0; i < FacultyList.size(); i ++){
            gen += "\n" + (i+1) + ": " + FacultyList.get(i).name;
        }
        return gen;
    }
     //Display the string of courses
      public static String ShowCourses(){
        String gen = "";
        for(int i = 0; i < courseList.size(); i ++){
            gen += "\n" + (i+1) + ": " + courseList.get(i).courseName;
        }
        return gen;
    }
    //Display the string for semester  
      public static String showSemesters() {
    	  String gen = "";
    	  for (int i = 0; i < SemesterList.size(); i ++) {
    		  gen += "\n" + (i + 1) + ": "+  SemesterList.get(i).period + " " + SemesterList.get(i).year;
    	  }
    	  
    	  return gen;
      }
     //Display the string for department 
      public static String showDepartments() {
    	  String gen = "";
    	  for (int i = 0; i < departmentList.size(); i ++) {
    		  gen += "\n" + (i + 1) + ": "+  departmentList.get(i).departmentName;
    	  }
 
    	  return gen;
    	  
      }
    //Take the selection and allow user to change the faculty information
      public static void EditFaculty(int Faculty){
    	  String Options = "\nChoose Option:\n1.Name\n2.Phone Number\n3.Email\n4.Building Name\n5.Office Number\n6.Position Title";
        
        for(int i = 0; i < FacultyList.size(); i ++){
           if(i == Faculty-1){
        	   
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           
           int Selection = 0;

           while (true) {
               try {
               
                   Selection = sc.nextInt();
                   if (Selection <= 6 && Selection > 0) {
                       break; 
                   } else {
                       System.out.println("Please enter a valid selection");
                   }
                   
               } catch (java.util.InputMismatchException e) {
                   System.out.println("Please enter a valid number.");
                   sc.nextLine();
               }
           }
           
           if(Selection == 1){
        	   System.out.println();
               System.out.print("Enter a new name: ");
               Scanner Input = new Scanner(System.in);
               String input = Input.nextLine();
               FacultyList.get(Faculty-1).name = input;
               break;
           }
           
           if(Selection == 2){
        	   System.out.println();
               System.out.print("Enter a new phone number: ");
               Scanner Input = new Scanner(System.in);
               String input = Input.nextLine();
               FacultyList.get(Faculty-1).setPhoneNum(input);
               break;
           }
           
           if(Selection == 3){
        	   System.out.println();
               System.out.print("Enter a new email: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   FacultyList.get(Faculty-1).setEmail(input);
        	   break;
           }
           
           if(Selection == 4){
        	   System.out.println();
               System.out.print("Enter a new building name: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   FacultyList.get(Faculty-1).buildingName = input;
        	   break;
           }
           
           if(Selection == 5){
        	   System.out.println();
               System.out.print("Enter a new office number: ");
        	   Scanner Input = new Scanner(System.in);
        	   int input = Integer.parseInt(Input.nextLine());
        	   FacultyList.get(Faculty-1).officeNum = input;
        	   break;
           }
           
           if(Selection == 6){
        	   System.out.println();
               System.out.print("Enter a new position: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   FacultyList.get(Faculty-1).position = input;
        	   break;
           }
           }
        }
      }
      //Take the selection and allow users to edit/change course information
      public static void EditCourse(int Course){
        String Options = "\nChoose Option:\n1.Name\n2.Start Time\n3.End Time\n4.Days per week\n5.Credits";

        
        for(int i = 0; i < courseList.size(); i ++){
           if(i == Course-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           
           int Selection = 0;

           while (true) {
               try {
               
                   Selection = sc.nextInt();
                   if (Selection <= 5 && Selection > 0) {
                       break; 
                   } else {
                       System.out.println("Please enter a valid selection");
                   }
                   
               } catch (java.util.InputMismatchException e) {
                   System.out.println("Please enter a valid number.");
                   sc.nextLine();
               }
           }
           
           if(Selection == 1){
        	   System.out.println();
               System.out.print("Enter a new course name: ");
               Scanner Input = new Scanner(System.in);
               String input = Input.nextLine();
               courseList.get(Course-1).courseName = input;
               break;
           }
           
           if(Selection == 2){
        	   System.out.println();
               System.out.print("Enter a new start time: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   courseList.get(Course-1).startTime = input;
        	   break;
           }
            
           if(Selection == 3){
        	   System.out.println();
               System.out.print("Enter a new end time: ");
               Scanner Input = new Scanner(System.in);
               String input = Input.nextLine();
               courseList.get(Course-1).endTime = input;
               break;
           }
             
           if(Selection == 4){
        	   System.out.println();
               System.out.print("Enter a new days per week ");
        	   Scanner Input = new Scanner(System.in);
        	   int input = Integer.parseInt(Input.nextLine());
        	   courseList.get(Course-1).daysWeek = input;
        	   break;
           }
              
           if(Selection == 5){
        	   System.out.println();
               System.out.print("Enter a new number of credits: ");
        	   Scanner Input = new Scanner(System.in);
        	   int input = Integer.parseInt(Input.nextLine());
        	   courseList.get(Course-1).numCredits = input;
        	   break;
           }
           }
        }
      }
    
    //Take the selection and allow user to edit/change student information
     public static void EditStudents(int Student){
        String Options = "\nChoose Option:\n1.Name\n2.Address\n3.Email\n4.GPA\n5.Contact Name\n6.Contact Address\n7.Contact Phone";

        
        for(int i = 0; i < StudentList.size(); i ++){
           if(i == Student-1){
           System.out.print(Options);
           Scanner sc = new Scanner(System.in);
           
           int Selection = 0;

           while (true) {
               try {
               
                   Selection = sc.nextInt();
                   if (Selection <= 7 && Selection > 0) {
                       break; 
                   } else {
                       System.out.println("Please enter a valid selection");
                   }
                   
               } catch (java.util.InputMismatchException e) {
                   System.out.println("Please enter a valid number.");
                   sc.nextLine();
               }
           }
           
           if(Selection == 1) {
           System.out.println();
           System.out.print("Enter a new name: ");
        	
           Scanner Input = new Scanner(System.in);
           String input = Input.nextLine();
           System.out.println();
           StudentList.get(Student-1).name = input;
           break;
           }
           
           if(Selection == 2){
        	   System.out.println();
        	   System.out.print("Enter a new address: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   StudentList.get(Student-1).SetAddress(input);
        	   break;
           }
           
            if(Selection == 3){
            	System.out.println();
                System.out.print("Enter a new email: ");
                Scanner Input = new Scanner(System.in);
                String input = Input.nextLine();
           		StudentList.get(Student-1).SetEmail(input);
           		break;
           }
            
           if(Selection == 4){
        	   System.out.println();
               System.out.print("Enter a new GPA: ");
        	   Scanner Input = new Scanner(System.in);
        	   double input = Double.parseDouble(Input.nextLine());
        	   StudentList.get(Student-1).GPA = input;
        	   break;
           }
           
           if(Selection == 5){
        	   System.out.println();
               System.out.print("Enter a new contact name: ");
               Scanner Input = new Scanner(System.in);
               String input = Input.nextLine();
               StudentList.get(Student-1).contactName = input;
               break;
           }
           
            if(Selection == 6){
            	System.out.println();
                System.out.print("Enter a new contact address: ");
                Scanner Input = new Scanner(System.in);
                String input = Input.nextLine();
                StudentList.get(Student-1).SetContactAddress(input);
                break;
           }
            
           if(Selection == 7){
        	   System.out.println();
               System.out.print("Enter a new contact phone: ");
        	   Scanner Input = new Scanner(System.in);
        	   String input = Input.nextLine();
        	   StudentList.get(Student-1).SetContactPhone(input);
        	   break;
           	}
           }
        }
    }
     
   
   
    // Show student in the certain semester 
    public static void showStudentEnrollments(int student, int semester) {
    	//Semester semester = semester
    	for (Student currStudent: StudentList) {
    		if (currStudent.GetStudentID() == (student - 1)){
    			ArrayList<Enrollment> studentEnrollments = currStudent.StudentEnrollments;
    			int i = 1;
    			for (Enrollment enrollment : studentEnrollments) {
    			//	if (enrollment.semester = )
    				System.out.println(i+ ": " + enrollment.course.courseName);
    			}
    			
    		}
    	}
    	
    }
    
    //Show student taking the certain course at the certain semester
    public static void showCoursesStudents(int course, int semester) {
    	for (int i = 0; i < courseList.size(); i ++) {
    		if ((course - 1) == i) {
    			ArrayList<Student> courseStudents = courseList.get(course - 1).EnrolledStudents;
    			for (Student currStudent : courseStudents) {
    				System.out.println(currStudent.name);
    			}
    			
    			
    		}
    		
    	}
    }
 
}
