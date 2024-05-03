package com.noahkurtz.databasep4;

import java.util.ArrayList;

public class Department {
    public String departmentName;
    public ArrayList<Faculty> FacultyList;
    public int departmentID;
    private static int Count = 0;

    public Department(String departmentName) {

        this.departmentName = departmentName;
        this.FacultyList = new ArrayList<>();
        this.departmentID = Count + 1;
        Count++;
    }
    
    @Override
    public String toString() {
        return departmentName; // for drop down
    }

}
