public class Faculty{
	private int facultyID;
	public String name;
	private String email;
	public String buildingName;
	public int officeNum;
	private String phoneNum;
	public Department department;
	public String position;
	
	
	public Faculty(int facultyID, String name, String email, String buildingName, int officeNum, String phoneNum, Department department, String position) {
		this.facultyID = facultyID;
		this.name = name;
		this.email = email;
		this.buildingName = buildingName;
		this.officeNum = officeNum;
		this.phoneNum = phoneNum;
		this.department = department;
		this.position = position;
	}
	
	public void setFaculty(int facultyID) {
		this.facultyID = facultyID;
	}
	
	public int getFaultyID() {
		return facultyID;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
}