package com.noahkurtz.databasep4;

public class Semester {
	public String period;
	public int year;
        public int semesterID;
        private static int Count = 0;

	public Semester(String period, int year) {
		this.period = period;
		this.year = year;
                this.semesterID = Count + 1;
                Count++;
                
	}
        
        @Override
        public String toString() {
            String semester = "";
            semester += period + " " + year;
            return semester; 
        }
}
