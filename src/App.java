import java.util.ArrayList;
import java.util.List;

public class App {
	
	 public List<Department> departmentList;
	 public List<Course> courseList;

	public App() {
	        departmentList = new ArrayList<>();
	        courseList = new ArrayList<>();
	    }
	
	
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
