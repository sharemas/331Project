package org.openjfx.projectpt3;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIFunctions {
    
    public static void enroll() {
        Stage enrollmentStage = new Stage();
        enrollmentStage.setTitle("Student Enrollment");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label semesterLabel = new Label("Select Semester:");
        ComboBox<Semester> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.SemesterList));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<Course> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.courseList));
        
        Label studentLabel = new Label("Select Student:");
        ComboBox<Student> studentComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.StudentList));

        Button submitButton = new Button("Submit Enrollment");
        submitButton.setOnAction(event -> {
            Semester semester = semesterComboBox.getValue();
            Course course = courseComboBox.getValue();
            Student student = studentComboBox.getValue();
            
            if (semester != null && course != null && student != null) {
                ReportFunctions.EnrollmentList.add(new Enrollment(semester, course, student));
                
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Enrollment Successful");
                successAlert.setHeaderText("Student Enrollment Completed");
                successAlert.setContentText(String.format(
                    "Student %s has been enrolled in %s during %s %d.",
                    student.name, course.courseName, semester.period, semester.year
                ));
                
                successAlert.showAndWait();
                enrollmentStage.close();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setTitle("Enrollment Failed");
                errorAlert.setHeaderText("Incomplete Selection");
                errorAlert.setContentText("Please ensure all selections are made.");
                errorAlert.showAndWait();
            }
        });

        layout.getChildren().addAll(
            semesterLabel, semesterComboBox,
            courseLabel, courseComboBox,
            studentLabel, studentComboBox,
            submitButton
        );

        Scene scene = new Scene(layout, 300, 250);
        enrollmentStage.setScene(scene);
        enrollmentStage.show();
    }
    
    public static void schedule() {
        Stage scheduleStage = new Stage();
        scheduleStage.setTitle("Course Scheduling");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10)); 

        Label semesterLabel = new Label("Select Semester:");
        ComboBox<Semester> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.SemesterList));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<Course> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.courseList));
        
        Label facultyLabel = new Label("Select Faculty:");
        ComboBox<Faculty> facultyComboBox = new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.FacultyList));

        Button submitButton = new Button("Submit Schedule");
        submitButton.setOnAction(event -> {
            Semester semester = semesterComboBox.getValue();
            Course course = courseComboBox.getValue();
            Faculty faculty = facultyComboBox.getValue();
            
            if (semester != null && course != null && faculty != null) {
                ReportFunctions.ScheduleList.add(new Schedule(semester, course, faculty));
                
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Schedule Successful");
                successAlert.setHeaderText("Course Scheduling Completed");
                successAlert.setContentText(String.format(
                    "Course %s has been scheduled with %s for %s %d.",
                    course.courseName, faculty.name, semester.period, semester.year
                ));
                
                successAlert.showAndWait();
                scheduleStage.close();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setTitle("Schedule Failed");
                errorAlert.setHeaderText("Incomplete Selection");
                errorAlert.setContentText("Please ensure all selections are made.");
                errorAlert.showAndWait();
            }
        });

        layout.getChildren().addAll(
            semesterLabel, semesterComboBox,
            courseLabel, courseComboBox,
            facultyLabel, facultyComboBox,
            submitButton
        );

        Scene scene = new Scene(layout, 300, 250); 
        scheduleStage.setScene(scene);
        scheduleStage.show();
    }

    public static void report() {
        Stage reportStage = new Stage();
        reportStage.setTitle("Reports");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label reportTypeLabel = new Label("Select Report Type:");
        ComboBox<String> reportTypeComboBox = new ComboBox<>(
            FXCollections.observableArrayList(
                "All courses a faculty member is teaching in a semester",
                "All courses a student is taking in a semester",
                "All students in a single course in a semester"
            )
        );

        TextArea reportTextArea = new TextArea();
        reportTextArea.setEditable(false);
        reportTextArea.setWrapText(true);

        VBox additionalFields = new VBox(10);
        additionalFields.setPadding(new Insets(10));

        Button generateButton = new Button("Generate Report");
        reportTypeComboBox.setOnAction(event -> {
            additionalFields.getChildren().clear();

            switch (reportTypeComboBox.getValue()) {
                case "All courses a faculty member is teaching in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Faculty:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.FacultyList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.SemesterList))
                    );
                    break;
                case "All courses a student is taking in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Student:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.StudentList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.SemesterList))
                    );
                    break;
                case "All students in a single course in a semester":
                    additionalFields.getChildren().addAll(
                        new Label("Select Course:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.courseList)),
                        new Label("Select Semester:"),
                        new ComboBox<>(FXCollections.observableArrayList(ReportFunctions.SemesterList))
                    );
                    break;
            }
        });

        generateButton.setOnAction(event -> {
            String reportString = ""; 

            switch (reportTypeComboBox.getValue()) {
                case "All courses a faculty member is teaching in a semester":
                    Faculty selectedFaculty = ((ComboBox<Faculty>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = ReportFunctions.FacultyCourses(selectedSemester, selectedFaculty);
                    break;
                case "All courses a student is taking in a semester":
                    Student selectedStudent = ((ComboBox<Student>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester2 = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = ReportFunctions.CourseSemester(selectedSemester2, selectedStudent);
                    break;
                case "All students in a single course in a semester":
                    Course selectedCourse = ((ComboBox<Course>) additionalFields.getChildren().get(1)).getValue();
                    Semester selectedSemester3 = ((ComboBox<Semester>) additionalFields.getChildren().get(3)).getValue();
                    reportString = ReportFunctions.StudentCourse(selectedCourse, selectedSemester3);
                    break;
            }

            reportTextArea.setText(reportString);

        });

        layout.getChildren().addAll(
            reportTypeLabel, reportTypeComboBox,
            additionalFields, generateButton, reportTextArea
        );

        Scene scene = new Scene(layout, 400, 300);
        reportStage.setScene(scene);
        reportStage.show();
    }
}
