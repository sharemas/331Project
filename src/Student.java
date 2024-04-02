
package com.noahkurtz.cis331project;

import java.util.ArrayList;


public class Student {
   public String name;
   private int SSN;
   private int studentID;
   private String address;
   private String email;
   public double GPA;
   public String contactName;
   private String contactPhoneNumber;
   private String contactAddress;
   public ArrayList<Enrollement> StudentEnrollments = new ArrayList<>();
   
  public Student(String name, int SSN,int studentID,String address,String email, double GPA,
         String contactName, String contactPhoneNumber, String contactAddress){
 
         this.name = name;
         this.SSN = SSN;
         this.studentID = studentID;
         this.address = address;
         this.email = email;
         this.GPA = GPA;
         this.contactName = contactName;
         this.contactPhoneNumber = contactPhoneNumber;
         this.contactAddress = contactAddress;
         
  }
   
    public int GetSSN(){
    return this.SSN;
    }
    
    public int GetStudentID(){
    return this.studentID;
    }
    
    public String GetEmail(){
    return this.email;
    }
    public void SetEmail(String email){
    this.email = email;
    }
    
    public String GetAddress(){
    return this.address;
    }
    
    public void SetAddress(String address){
    this.address = address;
    }
    
    public String GetContactPhone(){
    return this.contactPhoneNumber;
    }
    
    public void SetContactPhone(String contactPhoneNumber){
    this.contactPhoneNumber = contactPhoneNumber;
    }
    
    public String GetContactAddress(){
    return this.contactAddress;
    }
   
    public void SetContactAddress(String contactAddress){
    this.contactAddress = contactAddress;
    }
}