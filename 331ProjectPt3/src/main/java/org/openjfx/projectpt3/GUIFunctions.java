package org.openjfx.projectpt3;

import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class GUIFunctions {
       
       


public static void enroll() {
        // Create a new stage and layout for the window
        Stage enrollmentStage = new Stage();
        enrollmentStage.setTitle("Student Enrollment");
        VBox layout = new VBox(10); 
        layout.setPadding(new Insets(10));

        // Labels and drop downs for selecting semester, course, and student
        Label semesterLabel = new Label("Select Semester:");
        ComboBox<Semester> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<Course> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.courseList));
        
        Label studentLabel = new Label("Select Student:");
        ComboBox<Student> studentComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.StudentList));

        // Button to submit the enrollment
        Button submitButton = new Button("Submit Enrollment");
        // Add java funcitonality 

        // Add components to the layout
        layout.getChildren().addAll(
            semesterLabel,
            semesterComboBox,
            courseLabel,
            courseComboBox,
            studentLabel,
            studentComboBox,
            submitButton
        );
        
      submitButton.setOnAction(event->{
      Semester semester = semesterComboBox.getValue();
      Course course = courseComboBox.getValue();
      Student student = studentComboBox.getValue();
      Main.EnrollmentList.add(new Enrollment(semester,course,student));
      
         enrollmentStage.close();
        });
           
        // Set the scene and display it
        Scene scene = new Scene(layout, 300, 250);
        enrollmentStage.setScene(scene);
        enrollmentStage.show();
    }
    
      public static void schedule() {
        // Create a new stage and layout
        Stage scheduleStage = new Stage();
        scheduleStage.setTitle("Course Scheduling");
        VBox layout = new VBox(10); 
        layout.setPadding(new Insets(10)); 

        // Labels and drop downs for selecting semester, course, and faculty
        // Chang to use our app's array lists
        Label semesterLabel = new Label("Select Semester:");
        ComboBox<Semester> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<Course> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.courseList));
        
        Label facultyLabel = new Label("Select Faculty:");
        ComboBox<Faculty> facultyComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.FacultyList));

        // Button to submit the schedule
        Button submitButton = new Button("Submit Schedule");

        // Add java functionality 
        
        // Add components to the layout
        layout.getChildren().addAll(
            semesterLabel,
            semesterComboBox,
            courseLabel,
            courseComboBox,
            facultyLabel,
            facultyComboBox,
            submitButton
        );

        // Set up the scene and stage and show it
               
        submitButton.setOnAction(event ->{
         Semester semester = semesterComboBox.getValue();
         Course course = courseComboBox.getValue();
         Faculty faculty = facultyComboBox.getValue();
         
         Main.ScheduleList.add(new Schedule(semester,course,faculty));
         
         scheduleStage.close();
        });
        
        Scene scene = new Scene(layout, 300, 250); 
        scheduleStage.setScene(scene);
        scheduleStage.show();
    }
      
        public static void report() {
        // Create a new stage and layout
        Stage reportStage = new Stage();
        reportStage.setTitle("Reports");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Label and ComboBox for report type
        Label reportTypeLabel = new Label("Select Report Type:");
        ComboBox<String> reportTypeComboBox = new ComboBox<>(
            FXCollections.observableArrayList(
                "All courses a faculty member is teaching in a semester",
                "All courses a student is taking in a semester",
                "All students in a single course in a semester"
            )
        );

        // Text area to display the generated report
        TextArea reportTextArea = new TextArea();
        reportTextArea.setEditable(false);
        reportTextArea.setWrapText(true);

        // More fields for dynamic components 
        VBox additionalFields = new VBox(10);
        additionalFields.setPadding(new Insets(10));

        // Button to generate the report
        Button generateButton = new Button("Generate Report");

        // Populate additional fields based on the selected report type
        reportTypeComboBox.setOnAction(event -> {
            additionalFields.getChildren().clear();

            switch (reportTypeComboBox.getValue()) {
                case "All courses a faculty member is teaching in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Faculty:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.FacultyList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList))
                    );
                    break;
                case "All courses a student is taking in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Student:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.StudentList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList))
                    );
                    break;
                case "All students in a single course in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Course:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.courseList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList))
                    );
                    break;
            }
        });

        // Event handler to generate the report on button click
        generateButton.setOnAction(event -> {
            // Placeholder variable for the report string
            String reportString = ""; 

            switch (reportTypeComboBox.getValue()) {
                case "All courses a faculty member is teaching in a semester":
                    Faculty selectedFaculty = ((ComboBox<Faculty>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = Main.FacultyCourses(selectedSemester, selectedFaculty);
                    break;
                case "All courses a student is taking in a semester":
                    Student selectedStudent = ((ComboBox<Student>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester2 = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = Main.CourseSemester(selectedSemester2, selectedStudent);
                    break;
                case "All students in a single course in a semester":
                    Course selectedCourse = ((ComboBox<Course>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester3 = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = Main.StudentCourse(selectedCourse, selectedSemester3);
                    break;
            }

            reportTextArea.setText(reportString); 
        });

        layout.getChildren().addAll(reportTypeComboBox, additionalFields, generateButton, reportTextArea);

        Scene scene = new Scene(layout, 400, 300);
        reportStage.setScene(scene);
        reportStage.show();
    }
    
}
