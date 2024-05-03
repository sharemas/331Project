package com.noahkurtz.databasep4;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditFunctions {
    
    public static void editStudent() {
        Stage editStudentStage = new Stage();
        editStudentStage.setTitle("Edit Student");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        ComboBox<Student> studentSelection = new ComboBox<>(
            FXCollections.observableArrayList(ReportFunctions.StudentList)
        );

        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList(
                "StudentName", "SSN", "Address", "Email", "GPA", "Emergency Contact Name",
                "Emergency Contact Phone", "Emergency Contact Address"
            )
        );

        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> {
            String selectedAttribute = editSelection.getValue();
            Student student = studentSelection.getValue();

            if (student != null && selectedAttribute != null) {
                Stage editPartStage = new Stage();
                editPartStage.setTitle("Edit " + selectedAttribute);
                VBox layout2 = new VBox(10);
                layout2.setPadding(new Insets(10));
                
                TextField inputField = new TextField();
                switch (selectedAttribute) {
                    case "Name":
                        inputField.setText(student.name);
                        break;
                    case "SSN":
                        inputField.setText(String.valueOf(student.GetSSN()));
                        break;
                    case "Address":
                        inputField.setText(student.GetAddress());
                        break;
                    case "Email":
                        inputField.setText(student.GetEmail());
                        break;
                    case "GPA":
                        inputField.setText(String.valueOf(student.GPA));
                        break;
                    case "Emergency Contact Name":
                        inputField.setText(student.contactName);
                        break;
                    case "Emergency Contact Phone":
                        inputField.setText(student.GetContactPhone());
                        break;
                    case "Emergency Contact Address":
                        inputField.setText(student.GetContactAddress());
                        break;
                }

                Button saveButton = new Button("Save");
                saveButton.setOnAction(event2 -> {
                    switch (selectedAttribute) {
                        case "Name":
                            student.name = inputField.getText();
                            break;
                        case "SSN":
                            student.SetSSN(Integer.parseInt(inputField.getText()));
                            break;
                        case "Address":
                            student.SetAddress(inputField.getText());
                            break;
                        case "Email":
                            student.SetEmail(inputField.getText());
                            break;
                        case "GPA":
                            student.GPA = Double.parseDouble(inputField.getText());
                            break;
                        case "Emergency Contact Name":
                            student.contactName = inputField.getText();
                            break;
                        case "Emergency Contact Phone":
                            student.SetContactPhone(inputField.getText());
                            break;
                        case "Emergency Contact Address":
                            student.SetContactAddress(inputField.getText());
                            break;
                    }
                    
                    String Insert = "Update Student set studentname = " + "'" + student.name + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert, 'u');
                    
                    String Insert2 = "Update Student set address = " + "'" + student.GetAddress() + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert2, 'u');

                    String Insert3 = "Update Student set email  = " + "'" + student.GetEmail() + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert3, 'u');
                    
                    String Insert4 = "Update Student set gpa = " + student.GPA  + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert4, 'u');
                    
                    String Insert5 = "Update Student set contactaddress = " + "'" + student.GetContactAddress() + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert5, 'u');
                    
                    String Insert6 = "Update Student set contactname = " + "'" + student.contactName + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert6, 'u');
                    
                    String Insert7 = "Update Student set contactnumber = " + "'" + student.GetContactPhone() + "'" + " where Student.STUDENTID = " + student.GetStudentID();
                    App.runDBQuery(Insert7, 'u');

                    // Display a success message after saving
                      String successMessage = String.format(
                        "Successfully updated the '%s' attribute for student %s.",
                        selectedAttribute,
                        student.name
                    );

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Successful");
                    alert.setHeaderText("Student Information Updated");
                    alert.setContentText(successMessage);
                    alert.showAndWait();


                    editPartStage.close();
                });

                layout2.getChildren().addAll(
                    new Label("Edit " + selectedAttribute + ":"),
                    inputField,
                    saveButton
                );

                Scene scene = new Scene(layout2, 200, 100);
                editPartStage.setScene(scene);
                editPartStage.show();
            }
        });

        layout.getChildren().addAll(
            new Label("Select Student:"),
            studentSelection,
            new Label("Select Student Attribute to Edit:"),
            editSelection,
            editButton
        );

        Scene scene = new Scene(layout, 300, 200);
        editStudentStage.setScene(scene);
        editStudentStage.show();
    }

    public static void editCourse() {
        Stage editCourseStage = new Stage();
        editCourseStage.setTitle("Edit Course");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        ComboBox<Course> courseSelection = new ComboBox<>(
            FXCollections.observableArrayList(ReportFunctions.courseList)
        );

        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList(
                "Prefix", "Number", "Course Name", "Days per Week", "Start Time", 
                "End Time", "Number of Credits"
            )
        );

        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> {
            Course course = courseSelection.getValue();
            String selectedAttribute = editSelection.getValue();

            if (course != null && selectedAttribute != null) {
                Stage editPartStage = new Stage();
                editPartStage.setTitle("Edit " + selectedAttribute);
                VBox layout2 = new VBox(10);
                layout2.setPadding(new Insets(10));

                TextField inputField = new TextField();
                switch (selectedAttribute) {
                    case "Prefix":
                        inputField.setText(course.prefix);
                        break;
                    case "Number":
                        inputField.setText(String.valueOf(course.number));
                        break;
                    case "Course Name":
                        inputField.setText(course.courseName);
                        break;
                    case "Days per Week":
                        inputField.setText(String.valueOf(course.daysWeek));
                        break;
                    case "Start Time":
                        inputField.setText(course.startTime);
                        break;
                    case "End Time":
                        inputField.setText(course.endTime);
                        break;
                    case "Number of Credits":
                        inputField.setText(String.valueOf(course.numCredits));
                        break;
                }

                Button saveButton = new Button("Save");
                saveButton.setOnAction(event2 -> {
                    switch (selectedAttribute) {
                        case "Prefix":
                            course.prefix = inputField.getText();
                            break;
                        case "Number":
                            course.number = Integer.parseInt(inputField.getText());
                            break;
                        case "Course Name":
                            course.courseName = inputField.getText();
                            break;
                        case "Days per Week":
                            course.daysWeek = Integer.parseInt(inputField.getText());
                            break;
                        case "Start Time":
                            course.startTime = inputField.getText();
                            break;
                        case "End Time":
                            course.endTime = inputField.getText();
                            break;
                        case "Number of Credits":
                            course.numCredits = Integer.parseInt(inputField.getText());
                            break;
                    }
                    
                    String insert = "Update Course set CoursePrefix = " + "'" + course.prefix + "'" + " where CourseID = " + course.courseID;
                    App.runDBQuery(insert, 'u');
                        
                    String insert2 = "Update Course set CourseNumber = " + "'" + course.number + "'" + " where CourseID = " + course.courseID;
                    App.runDBQuery(insert2, 'u');   
                    
                    String insert3 = "Update Course set CourseName = " + "'" + course.courseName + "'" + " where CourseID = " + course.courseID;
                    App.runDBQuery(insert3, 'u');
                    
                    String insert4 = "Update Course set CourseDaysWeek= " + "'" + course.daysWeek + "'" + " where CourseID = " + course.courseID;
                    App.runDBQuery(insert4, 'u');
                    
                     // Display a success message after saving
                      String successMessage = String.format(
                        "Successfully updated the '%s' attribute for %s.",
                        selectedAttribute,
                        course.prefix + course.number
                    );

                    // Show success message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Successful");
                    alert.setHeaderText("Course Information Updated");
                    alert.setContentText(successMessage);
                    alert.showAndWait();

                    editPartStage.close();
                });

                layout2.getChildren().addAll(
                    new Label("Edit " + selectedAttribute + ":"),
                    inputField,
                    saveButton
                );

                Scene scene = new Scene(layout2, 300, 150);
                editPartStage.setScene(scene);
                editPartStage.show();
            }
        });

        layout.getChildren().addAll(
            new Label("Select Course:"),
            courseSelection,
            new Label("Select Course Attribute to Edit:"),
            editSelection,
            editButton
        );

        Scene scene = new Scene(layout, 300, 200); 
        editCourseStage.setScene(scene);
        editCourseStage.show();
    }

    public static void editFaculty() {
        Stage editFacultyStage = new Stage();
        editFacultyStage.setTitle("Edit Faculty");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        ComboBox<Faculty> facultySelection = new ComboBox<>(
            FXCollections.observableArrayList(ReportFunctions.FacultyList)
        );

        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList(
                "Name", "Email", "Building Name", "Office Number", 
                "Phone Number", "Department", "Position"
            )
        );

        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> {
            Faculty faculty = facultySelection.getValue();
            String selectedAttribute = editSelection.getValue();

            if (faculty != null && selectedAttribute != null) {
                Stage editPartStage = new Stage();
                editPartStage.setTitle("Edit " + selectedAttribute);
                VBox layout2 = new VBox(10);
                layout2.setPadding(new Insets(10));

                if ("Department".equals(selectedAttribute)) {
                    ComboBox<Department> departmentComboBox = new ComboBox<>(
                        FXCollections.observableArrayList(ReportFunctions.departmentList)
                    );
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction(event2 -> {
                        faculty.department = departmentComboBox.getValue();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Edit Successful");
                        alert.setHeaderText("Faculty Information Updated");
                        alert.setContentText("Successfully updated.");
                        alert.showAndWait();

                        editPartStage.close(); 
                    });

                    layout2.getChildren().addAll(
                        new Label("Edit " + selectedAttribute + ":"),
                        departmentComboBox,
                        saveButton
                    );
                } else {
                    TextField inputField = new TextField();
                    switch (selectedAttribute) {
                        case "Name":
                            inputField.setText(faculty.name);
                            break;
                        case "Email":
                            inputField.setText(faculty.getEmail());
                            break;
                        case "Building Name":
                            inputField.setText(faculty.buildingName);
                            break;
                        case "Office Number":
                            inputField.setText(String.valueOf(faculty.officeNum));
                            break;
                        case "Phone Number":
                            inputField.setText(faculty.getPhoneNum());
                            break;
                        case "Position":
                            inputField.setText(faculty.position);
                            break;
                    }

                    Button saveButton = new Button("Save");
                    saveButton.setOnAction(event2 -> {
                        switch (selectedAttribute) {
                            case "Name":
                                faculty.name = inputField.getText();
                                break;
                            case "Email":
                                faculty.setEmail(inputField.getText());
                                break;
                            case "Building Name":
                                faculty.buildingName = inputField.getText();
                                break;
                            case "Office Number":
                                faculty.officeNum = Integer.parseInt(inputField.getText());
                                break;
                            case "Phone Number":
                                faculty.setPhoneNum(inputField.getText());
                                break;
                            case "Position":
                                faculty.position = inputField.getText();
                                break;
                        }
                        
                        String Insert = "Update faculty set name = " + "'" + faculty.name + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert, 'u');
                        
                        String Insert2 = "Update faculty set email = " + "'" + faculty.getEmail() + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert2, 'u');
                        
                        String Insert3 = "Update faculty set buildingname = " + "'" + faculty.buildingName + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert3, 'u');
                        
                        String Insert4 = "Update faculty set officenum= " + "'" + faculty.officeNum + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert4, 'u');
                        
                        String Insert5 = "Update faculty set phonenum = " + "'" + faculty.getPhoneNum() + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert5, 'u');
                        
                        String Insert6 = "Update faculty set departmentid = " + "'" + faculty.department.departmentID + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert6, 'u');
                        
                        String Insert7 = "Update faculty set position = " + "'" + faculty.position + "'" + " where Faculty.FACULTYID = " + faculty.facultyID;
                        App.runDBQuery(Insert7, 'u');
                        

                           // Display a success message after saving
                      String successMessage = String.format(
                        "Successfully updated the '%s' attribute for faculty member %s.",
                        selectedAttribute,
                        faculty.name
                    );

                    // Show success message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Successful");
                    alert.setHeaderText("Faculty Information Updated");
                    alert.setContentText(successMessage);
                    alert.showAndWait();

                    editPartStage.close();
                    });

                    layout2.getChildren().addAll(
                        new Label("Edit " + selectedAttribute + ":"),
                        inputField,
                        saveButton
                    );
                }

                Scene scene = new Scene(layout2, 300, 150);
                editPartStage.setScene(scene);
                editPartStage.show();
            }
        });

        layout.getChildren().addAll(
            new Label("Select Faculty Member:"),
            facultySelection,
            new Label("Select Faculty Attribute to Edit:"),
            editSelection,
            editButton
        );

        Scene scene = new Scene(layout, 300, 200); 
        editFacultyStage.setScene(scene);
        editFacultyStage.show();
    }
}
