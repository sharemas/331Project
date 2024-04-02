
package com.noahkurtz.cis331project;

import java.util.ArrayList;

public class Department {
    public String departmentName;
    public ArrayList<Faculty> FacultyList = new ArrayList<>();
    
   public Department(String departmentName, ArrayList FacultyList){
    
    this.departmentName = departmentName;
    this.FacultyList = FacultyList;
    }
    
}
