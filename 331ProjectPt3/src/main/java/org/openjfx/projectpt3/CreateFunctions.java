package org.openjfx.projectpt3;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CreateFunctions {
    
    public static void createStudent() {
        // Create a new stage and format it
        Stage createStudentStage = new Stage();
        createStudentStage.setTitle("Create Student");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Prompt user to input details to create a student
        Label nameLabel = new Label("Enter Student's Name:");
        TextField nameField = new TextField();

        Label ssnLabel = new Label("Enter Student's SSN:");
        TextField ssnField = new TextField();

        Label addressLabel = new Label("Enter Address:");
        TextField addressField = new TextField();

        Label emailLabel = new Label("Enter Email:");
        TextField emailField = new TextField();

        Label gpaLabel = new Label("Enter GPA:");
        TextField gpaField = new TextField();

        Label emergencyContactLabelLine = new Label("---------------------------------------------------------------");
        Label emergencyContactLabel = new Label("Emergency Contact Info");

        Label contactNameLabel = new Label("Enter Contact Name:");
        TextField contactNameField = new TextField();

        Label contactPhoneLabel = new Label("Enter Contact Phone:");
        TextField contactPhoneField = new TextField();

        Label contactAddressLabel = new Label("Enter Contact Address:");
        TextField contactAddressField = new TextField();

        // Create a button to create the student
        Button createButton = new Button("Create Student");
        createButton.setOnAction(event -> {
            // Initial validations
            boolean valid = true;
            int ssn = 0;
            double gpa = 0;

            try {
                ssn = Integer.parseInt(ssnField.getText());
            } catch (Exception e) {
                ssnField.setTooltip(new Tooltip("Please input a valid SSN"));
                valid = false;
            }

            try {
                gpa = Double.parseDouble(gpaField.getText());
            } catch (Exception e) {
                gpaField.setTooltip(new Tooltip("Please input a valid GPA"));
                valid = false;
            }

            // Get user inputs
            String name = nameField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String contactName = contactNameField.getText();
            String contactPhone = contactPhoneField.getText();
            String contactAddress = contactAddressField.getText();

            // Additional validations
            if (name.isEmpty()) {
                nameField.setTooltip(new Tooltip("Please enter a valid name"));
                valid = false;
            }

            if (address.isEmpty()) {
                addressField.setTooltip(new Tooltip("Please enter a valid address"));
                valid = false;
            }

            if (email.isEmpty()) {
                emailField.setTooltip(new Tooltip("Please enter a valid email"));
                valid = false;
            }

            if (contactName.isEmpty()) {
                contactNameField.setTooltip(new Tooltip("Please enter a valid contact name"));
                valid = false;
            }

            if (contactPhone.isEmpty()) {
                contactPhoneField.setTooltip(new Tooltip("Please enter a valid contact phone number"));
                valid = false;
            }

            if (contactAddress.isEmpty()) {
                contactAddressField.setTooltip(new Tooltip("Please enter a valid contact address"));
                valid = false;
            }

            if (valid) {
                // Add the new student to the list
                ReportFunctions.StudentList.add(new Student(name, ssn, address, email, gpa, contactName, contactPhone, contactAddress));

                // Show success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student Created");
                alert.setContentText("Student " + name + " has been successfully created.");

                alert.showAndWait(); // Show the success message

                createStudentStage.close(); // Close the form
            }
        });

        // Add all the components to the stage
        layout.getChildren().addAll(
            nameLabel,
            nameField,
            ssnLabel,
            ssnField,
            addressLabel,
            addressField,
            emailLabel,
            emailField,
            gpaLabel,
            gpaField,
            emergencyContactLabelLine,
            emergencyContactLabel,
            contactNameLabel,
            contactNameField,
            contactPhoneLabel,
            contactPhoneField,
            contactAddressLabel,
            contactAddressField,
            createButton
        );

        // Set the scene and display it
        Scene scene = new Scene(layout, 400, 630);
        createStudentStage.setScene(scene);
        createStudentStage.show();
    }

    
     public static void  createCourse() {
        // Create a new stage and format it
        Stage createCourseStage = new Stage();
        createCourseStage.setTitle("Create New Course");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        

        // Prompt user to input details to create a course
        Label prefixLabel = new Label("Course Prefix:");
        TextField prefixField = new TextField();
      

        Label courseNumberLabel = new Label("Course Number:");
        TextField courseNumberField = new TextField();
        

        Label courseNameLabel = new Label("Course Name:");
        TextField courseNameField = new TextField();
      

        Label daysPerWeekLabel = new Label("Days per Week:");
        TextField daysPerWeekField = new TextField();
 
        Label startTimeLabel = new Label("Start Time:");
        TextField startTimeField = new TextField();
 

        Label endTimeLabel = new Label("End Time:");
        TextField endTimeField = new TextField();
    
        Label creditsLabel = new Label("Credits:");
        TextField creditsField = new TextField();


        // Create buttons for actions
        Button createButton = new Button("Create Course");
        
        // Get the user input values and store in variables for later use
         createButton.setOnAction(event -> {
            String name = courseNameField.getText();
            String prefix = prefixField.getText();
            int num = Integer.parseInt(courseNumberField.getText());
            int daysWeek = Integer.parseInt(daysPerWeekField.getText());
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            int numCredits = Integer.parseInt(creditsField.getText());
            ReportFunctions.courseList.add(new Course(prefix,num,name,daysWeek,startTime,endTime,numCredits));
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Course Created");
                alert.setContentText("Course " + prefix + name + " has been successfully created.");

                alert.showAndWait(); 
            createCourseStage.close();
});
            // more java here 
            
        // Add all components to the stage
        layout.getChildren().addAll(
            prefixLabel,
            prefixField,
            courseNumberLabel,
            courseNumberField,
            courseNameLabel,
            courseNameField,
            daysPerWeekLabel,
            daysPerWeekField,
            startTimeLabel,
            startTimeField,
            endTimeLabel,
            endTimeField,
            creditsLabel,
            creditsField,            
            createButton
        );
        

        // Set up the scene and display it
        Scene scene = new Scene(layout, 400, 510);
        createCourseStage.setScene(scene);
        createCourseStage.show();
    }

     public static void  createFaculty() {

         // Create a new stage and format it
        Stage createFacultyStage = new Stage();
        createFacultyStage.setTitle("Create Faculty");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));


        // Prompt user for details to create faculty member 
        Label facultyNameLabel = new Label("Enter Faculty Member's Name:");
        TextField facultyNameField = new TextField();

        Label facultyDeptLabel = new Label("Select Department:");

// temporary departments, change to those created by the user
// if not we can have them just type in the department

        // Drop down menu for user to choose existing departments 
        ComboBox<Department> facultyDeptComboBox = new ComboBox<>(
            FXCollections.observableArrayList(ReportFunctions.departmentList)
        );

        Label facultyEmailLabel = new Label("Enter Email:");
        TextField facultyEmailField = new TextField();


        Label buildingNameLabel = new Label("Enter Building Name:");
        TextField buildingNameField = new TextField();

        Label officeNumberLabel = new Label("Enter Office Number:");
        TextField officeNumberField = new TextField();

        Label phoneNumberLabel = new Label("Enter Phone Number:");
        TextField phoneNumberField = new TextField();

        Label positionLabel = new Label("Enter Position:");
        TextField positionField = new TextField();

        // Button to create the faculty member
        // With event listener to read user input and store it in respective
        // Variables for later use
        Button createButton = new Button("Create Faculty");
        createButton.setOnAction(event -> {
            // Fetch data from the fields
            String facultyName = facultyNameField.getText();
            Department facultyDept = facultyDeptComboBox.getValue(); 
            String facultyEmail = facultyEmailField.getText();

            String buildingName = buildingNameField.getText();
            String officeNumber = officeNumberField.getText();
            String phoneNumber = phoneNumberField.getText();
            String position = positionField.getText();
             ReportFunctions.FacultyList.add(new Faculty(facultyName,facultyEmail,buildingName,
           Integer.parseInt(officeNumber),phoneNumber,facultyDept,position));
           // Add java
           
           // Show success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Faculty Member Created");
                alert.setContentText("Faculty member " + facultyName + " has been successfully created.");

                alert.showAndWait(); 
 
           
           
            createFacultyStage.close(); 
        });

        // Add all components to stage
        layout.getChildren().addAll(
            facultyNameLabel,
            facultyNameField,
            facultyEmailLabel,
            facultyEmailField,
            buildingNameLabel,
            buildingNameField,
            officeNumberLabel,
            officeNumberField,
            phoneNumberLabel,
            phoneNumberField,
            facultyDeptLabel,
            facultyDeptComboBox,  
            positionLabel,
            positionField,
            createButton
        );
        
        

        // Set up the scene and display
        Scene scene = new Scene(layout, 400, 500);  
        createFacultyStage.setScene(scene);
        createFacultyStage.show();
    }
     
      public static void createDepartment() {
        // Create a new stage and format it
        Stage createDepartmentStage = new Stage();
        createDepartmentStage.setTitle("Create Department");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Prompt user to enter a department name
        Label departmentNameLabel = new Label("Enter Department Name:");
        TextField departmentNameField = new TextField();

        // Create button for action
        // Add event listener to store the user input for department name for later use
        Button createButton = new Button("Create Department");
        
        createButton.setOnAction(event -> {
            // Gather department name from the text field
            String departmentName = departmentNameField.getText();
            ReportFunctions.departmentList.add(new Department(departmentName));
          //put java here 
          
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Department Created");
                alert.setContentText("Department " + departmentName + " has been successfully created.");

                alert.showAndWait(); 

            createDepartmentStage.close();
        });

        // Add components to the stage
        layout.getChildren().addAll(
            departmentNameLabel,
            departmentNameField,
            createButton
        );

        // Set up the scene and stage and display it
        Scene scene = new Scene(layout, 400, 110); 
        createDepartmentStage.setScene(scene);
        createDepartmentStage.show(); 
    }
      
       
      
       public static void createSemester() {
        // Create a new stage and format it
        Stage createSemesterStage = new Stage();
        createSemesterStage.setTitle("Create Semester");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Prompt user for values to make a semester
        Label periodLabel = new Label("Enter Semester Period:");
        TextField periodField = new TextField();

        Label yearLabel = new Label("Enter Year:");
        TextField yearField = new TextField();

        // Create button for action with event listener that stores the user input
        // in variables for future use
        Button createButton = new Button("Create Semester");

        createButton.setOnAction(event -> { 
            String period = periodField.getText();
            int year = Integer.parseInt(yearField.getText());

            // Java here
            ReportFunctions.SemesterList.add(new Semester(period,year));
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Semester Created");
                alert.setContentText("Semester " + period + year + " has been successfully created.");

                alert.showAndWait(); 
            createSemesterStage.close(); 
        });

        // Add all components to the scene
        layout.getChildren().addAll(
            periodLabel,
            periodField,
            yearLabel,
            yearField,
            createButton
        );

        // Set up the scene and stage and display it
        Scene scene = new Scene(layout, 400, 180); 
        createSemesterStage.setScene(scene);
        createSemesterStage.show(); 
    }

}
