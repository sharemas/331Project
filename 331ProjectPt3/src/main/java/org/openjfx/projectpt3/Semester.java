package org.openjfx.projectpt3;
public class Semester {
	public String period;
	public int year;

	public Semester(String period, int year) {
		this.period = period;
		this.year = year;
	}
        
        @Override
        public String toString() {
            String semester = "";
            semester += period + " " + year;
            return semester; 
        }
}
