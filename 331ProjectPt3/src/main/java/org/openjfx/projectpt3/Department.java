package org.openjfx.projectpt3;
import java.util.ArrayList;

public class Department {
    public String departmentName;
    public ArrayList<Faculty> FacultyList;

    public Department(String departmentName) {

        this.departmentName = departmentName;
        this.FacultyList = new ArrayList<>();
    }
       public String toString() {
        String department = "";
        department += departmentName;
        return department; // for drop don
    }

}
