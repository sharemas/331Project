package org.openjfx.projectpt3;
import java.util.List;

public class Enrollment {
	public Semester semester;
	public Course course;
        public Student student;
	public Enrollment(Semester semester, Course course, Student student) {
		this.semester = semester;
		this.course = course;
                this.student = student;
	}

}
