package org.openjfx.projectpt3;
public class Faculty {
	private static int facultyCount = 0;
	private int facultyID;
	public String name;
	private String email;
	public String buildingName;
	public int officeNum;
	private String phoneNum;
	public Department department;
	public String position;

	public Faculty(String name, String email, String buildingName, int officeNum, String phoneNum,
			Department department, String position) {
		this.facultyID = facultyCount;
		this.name = name;
		this.email = email;
		this.buildingName = buildingName;
		this.officeNum = officeNum;
		this.phoneNum = phoneNum;
		this.department = department;
		this.position = position;
		facultyCount++;
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
        
        @Override
	public String toString(){
		return name;
	}
}
