public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    
    public void createFaculty(String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
    	Faculty newFaculty = new Faculty(name, email, buildingName, officeNum,  phoneNum,  department,  position);
    	department.FacultyList.add(newFaculty);
    }
    
    
    
 
}
