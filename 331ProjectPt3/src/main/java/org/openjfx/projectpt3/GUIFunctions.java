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
        ComboBox<String> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterNames()));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<String> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.CourseNames()));
        
        Label studentLabel = new Label("Select Student:");
        ComboBox<String> studentComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.StudentNames()));

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

        // Set the scene and display it
        Scene scene = new Scene(layout, 300, 200);
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
        ComboBox<String> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterNames()));
        
        Label courseLabel = new Label("Select Course:");
        ComboBox<String> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.CourseNames()));
        
        Label facultyLabel = new Label("Select Faculty:");
        ComboBox<String> facultyComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.FacultyNames()));

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
        Scene scene = new Scene(layout, 300, 200); 
        scheduleStage.setScene(scene);
        scheduleStage.show();
    }
      
      public static void report() {
        // Create a new stage and layout
        Stage reportStage = new Stage();
        reportStage.setTitle("Reports");
        VBox layout = new VBox(10); 
        layout.setPadding(new Insets(10)); 

        // Have a drop down for selecting the report type
        Label reportTypeLabel = new Label("Select Report Type:");
        ComboBox<String> reportTypeComboBox = new ComboBox<>(
            FXCollections.observableArrayList(
                "All courses a faculty member is teaching in a semester",
                "All courses a student is taking in a semester",
                "All students in a single course in a semester"
            )
        );

        // display the generated report
        TextArea reportTextArea = new TextArea();
        // Dont allow user to type in textbook
        reportTextArea.setEditable(false); 
        // Make sure the text wraps and a scrollbar appears when text is too big for the box
        reportTextArea.setWrapText(true);

        // Additional layout for dynamic components
        VBox additionalFields = new VBox(10); 
        additionalFields.setPadding(new Insets(10));

        // Button to generate the report
        Button generateButton = new Button("Generate Report");

        // Event handler to update additional fields based on selected report type
        reportTypeComboBox.setOnAction(event -> {
            String reportType = reportTypeComboBox.getValue();
            additionalFields.getChildren().clear(); // Clear any existing components

            // Display additional drop downs depending on the report that is selected
            // Change all these to hold our app's array lists
            switch (reportType) {
                case "All courses a faculty member is teaching in a semester":
                    Label facultyLabel = new Label("Select Faculty:");
                    ComboBox<String> facultyComboBox = new ComboBox<>(FXCollections.observableArrayList("you can put an arraylist here"));
                    Label semesterLabel = new Label("Select Semester:");
                    ComboBox<String> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList("test test semester"));
                    additionalFields.getChildren().addAll(facultyLabel, facultyComboBox, semesterLabel, semesterComboBox);
                    break;
                case "All courses a student is taking in a semester":
                    Label studentLabel = new Label("Select Student:");
                    ComboBox<String> studentComboBox = new ComboBox<>(FXCollections.observableArrayList("test student"));
                    Label semesterLabel2 = new Label("Select Semester:");
                    ComboBox<String> semesterComboBox2 = new ComboBox<>(FXCollections.observableArrayList("test semester"));
                    additionalFields.getChildren().addAll(studentLabel, studentComboBox, semesterLabel2, semesterComboBox2);
                    break;
                case "All students in a single course in a semester":
                    Label courseLabel = new Label("Select Course:");
                    ComboBox<String> courseComboBox = new ComboBox<>(FXCollections.observableArrayList("test Course"));
                    Label semesterLabel3 = new Label("Select Semester:");
                    ComboBox<String> semesterComboBox3 = new ComboBox<>(FXCollections.observableArrayList("Test Semester"));
                    additionalFields.getChildren().addAll(courseLabel, courseComboBox, semesterLabel3, semesterComboBox3);
                    break;
            }
        });

        // On click, the report will show in the textbox 
        generateButton.setOnAction(event -> {
          
            String generatedReport = "Placeholder report";

            // Display the generated report in the TextArea
            reportTextArea.setText(generatedReport);
        });

        // Add components to the layout
        layout.getChildren().addAll(
            reportTypeLabel,
            reportTypeComboBox,
            additionalFields, 
            generateButton,
            reportTextArea
        );

        // Set up the scene and stage
        Scene scene = new Scene(layout, 400, 400); // Adjusted size to fit content
        reportStage.setScene(scene);
        reportStage.show();
    }
}
