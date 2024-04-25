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

public class EditFunctions {
    
    public static void editStudent() {
        // Create the stage and format it
        Stage createStudentStage = new Stage();
        createStudentStage.setTitle("Edit Student");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        //Dropdown list of existing students to select one
        ComboBox<Student> studentSelection = new ComboBox<>(
            FXCollections.observableArrayList(Main.StudentList)   // changed to Student object here 
        );

        // Dropdown list to select a specific attribute to edit
        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList(
                "Name", "SSN", "Address", "Email", "GPA", "Emergency Contact Name", 
                "Emergency Contact Phone", "Emergency Contact Address"
            )
        );

        // Edit button with action handler to display another pop up
        // Based on the user selection, the pop up will prompt the user to edit the selected attribute
        Button editButton = new Button("Edit");

        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Retrieve the selected student and part to edit
                String selection = editSelection.getValue();
                Student student = studentSelection.getValue();
                
               // int studentID = student.GetStudentID();
     
                // Make sure that user selected something in both drop down menus
                if (student != null && selection != null) {
                    // Open a new window and format it
                    Stage editPartStage = new Stage();
                    editPartStage.setTitle("Edit " + selection);
                    VBox layout2 = new VBox(10);
                    layout2.setPadding(new Insets(10));
                    // text field for user input
                    TextField inputField = new TextField();
                
                // show the existing text to the user so that they know what they had before
                // in that attribute
                switch (selection) {
                    case "Name":
                        inputField.setText(student.name); 
                        break;
                    case "SSN":
                        inputField.setText(String.valueOf(student.GetSSN())); //student.getSsn()));
                        break;
                    case "Address":
                        inputField.setText(student.GetAddress()); //student.getAddress());
                        break;
                    case "Email":
                        inputField.setText(student.GetEmail()); //student.getEmail());
                        break;
                    case "GPA":
                        inputField.setText(String.valueOf(student.GPA)); //student.getGpa()));
                        break;
                    case "Emergency Contact Name":
                        inputField.setText(student.contactName); 
                        break;
                    case "Emergency Contact Phone":
                        inputField.setText(student.GetContactPhone());
                        break;
                    case  "Emergency Contact Address":
                        inputField.setText(student.GetContactAddress());
                        break;
                        
                }

                    // Create a save button with an action listener to store the user input
                    // Switch statement used to determine which attribute is being altered 
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction(event2 -> {
                        // Save the new value to the selected part
                        switch (selection) {
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
                                student.GPA = (Double.parseDouble(inputField.getText()));
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

                        editPartStage.close(); 
                    });

                    // Add all components to the small editing window
                    layout2.getChildren().addAll(
                        new Label("Edit " + selection + ":"),
                        inputField,
                        saveButton
                    );

                    // Set the small editing window scene and display it
                    Scene scene = new Scene(layout2, 200, 100); 
                    editPartStage.setScene(scene);
                    editPartStage.show();
                }
            }
        });

        // Add all the components to the scene
        layout.getChildren().addAll(
            new Label("Select Student:"),
            studentSelection,
            new Label("Select Student Attribute to Edit:"),
            editSelection,
            editButton
        );

        // Create the scene and stage and display it
        Scene scene = new Scene(layout, 300, 200); 
        createStudentStage.setScene(scene);
        createStudentStage.show();
    
    }

    public static void editCourse(){
        // Create a new stage and format it
        Stage createCourseStage = new Stage();
        createCourseStage.setTitle("Edit Course");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        
          // Example course names list; replace with real data later
        List<String> courseNames = Arrays.asList(Main.CourseNames());
        
         // Dropdown selectiono for selecting a course by name
        ComboBox<Course> courseSelection = new ComboBox<>(
            FXCollections.observableArrayList(Main.courseList)
        );

        // Dropdown selection for selecting which course attribute to edit
        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList(
                "Prefix", "Number", "Course Name", "Days per Week", "Start Time", "End Time", "Number of Credits"
            )
        );
        
        // Create an edit button with an action handler that stores the selected course and course attribute to edit
 
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Course course = courseSelection.getValue();
                String selectedAttribute = editSelection.getValue();

                // Make sure user selects something from both drop down menus
                if (course != null && selectedAttribute != null) {
                   // Create a small pop up window for editing attribute and format it
                    Stage editPartStage = new Stage();
                    editPartStage.setTitle("Edit " + selectedAttribute);
                    VBox layout2 = new VBox(10);
                    layout2.setPadding(new Insets(10));

                    TextField inputField = new TextField();

                    // Based on the selected attribute, display in the textfield the current text in the attribute
                    switch (selectedAttribute) {
                        case "Prefix":
                            inputField.setText(course.prefix); // set with current course prefix
                            break;
                        case "Number":
                            inputField.setText(String.valueOf(course.number)); // set with current course number
                            break;
                        case "Course Name":
                            inputField.setText(course.courseName); // set with current course name
                            break;
                        case "Days per Week":
                            inputField.setText(String.valueOf(course.daysWeek)); // set with current days per week
                            break;
                        case "Start Time":
                            inputField.setText(course.startTime); // set with current start time
                            break;
                        case "End Time":
                            inputField.setText(course.endTime); // set with current end time
                            break;
                        case "Number of Credits":
                            inputField.setText(String.valueOf(course.numCredits)); // set with current num credits
                            break;
                    }

                    // Create a save button that saved the new value to the selected attribute
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

                        editPartStage.close(); 
                    });

                    // Add all elements to the smaller editing window
                    layout2.getChildren().addAll(
                        new Label("Edit " + selectedAttribute + ":"),
                        inputField,
                        saveButton
                    );

                    // Set the scene for the smaller editing window and display it
                    Scene scene = new Scene(layout2, 300, 150);
                    editPartStage.setScene(scene);
                    editPartStage.show();
                }
            }
        });

        // Add all components to the bigger editing course window
        layout.getChildren().addAll(
            new Label("Select Course:"),
            courseSelection,
            new Label("Select Course Attribute to Edit:"),
            editSelection,
            editButton
        );

        // Set the scene and stage and display it
        Scene scene = new Scene(layout, 300, 200); 
        createCourseStage.setScene(scene);
        createCourseStage.show();
    
        
    }
    
  
    
   
    
    public static void editFaculty(){
         // Create a new stage and format it
        Stage createFacultyStage = new Stage();
        createFacultyStage.setTitle("Edit Faculty");
        VBox layout =  new VBox(10);
        layout.setPadding(new Insets(10));
       
        // Example list of faculty names; replace with real data later
       
        //Drop down menu to select existing faculty member
        ComboBox<String> facultySelection = new ComboBox<>(
            FXCollections.observableArrayList(Main.FacultyNames())
             
        );

        // Drop down menu to select which attribute to edit
        ComboBox<String> editSelection = new ComboBox<>(
            FXCollections.observableArrayList( "Name", "Email", "Building Name", "Office Number", "Phone Number", 
                "Department", "Position")
        );

        // Create a new edit button with a event listener that stores user faculty and attribute selection
        Button editButton = new Button("Edit");
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedFacultyName = facultySelection.getValue();
                String selectedAttribute = editSelection.getValue();

                // Make sure user actually chooses something in both drop down menues
                if (selectedFacultyName != null && selectedAttribute != null) {
                    // Create a smaller editing pop up window
                    Stage editPartStage = new Stage();
                    editPartStage.setTitle("Edit " + selectedAttribute);
                    VBox layout2 = new VBox(10);
                    layout2.setPadding(new Insets(10));

                    // If editing the department is the selected attribute, display a drop down menu of existing departments
                    // for user to choose from
                    if ("Department".equals(selectedAttribute)) {
                        // TEMPORARY DEPARTMENTS REPLACE WITH USER MADE
                        
                        ComboBox<String> departmentComboBox = new ComboBox<>(
                            FXCollections.observableArrayList(Main.DepNames())
                        );
                        // Add the components to the smaller editing window
                        layout2.getChildren().addAll(
                            new Label("Select New Department:"),
                            departmentComboBox
                        );
                        // Create a save button with action listener to save the new department value
                        Button saveButton = new Button("Save");
                        saveButton.setOnAction(event2 -> {
                            String newDepartment = departmentComboBox.getValue();
                            // Code to update the department in the faculty object
                            editPartStage.close(); 
                        });
                        // Add the save button to the small editing window
                        layout2.getChildren().add(saveButton);
                        
                    } else {
                        // If selected attribute is not department,
                        // display the current attribute value to the user
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

                        // Create save button with action listener to update the selected attribute
                        Button saveButton = new Button("Save");
                        saveButton.setOnAction(event2 -> {
                            // Code to update the selected attribute
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

                            editPartStage.close();
                        });

                        // Add components to small editing window
                        layout2.getChildren().addAll(
                            new Label("Edit " + selectedAttribute + ":"),
                            inputField,
                            saveButton
                        );
                    }

                    // Set the scene and stage and display small editing window
                    Scene scene = new Scene(layout2, 300, 150);
                    editPartStage.setScene(scene);
                    editPartStage.show();
                }
            }
        });

        // Add all components to faculty editing window
        layout.getChildren().addAll(
            new Label("Select Faculty Member:"),
            facultySelection,
            new Label("Select Faculty Attribute to Edit:"),
            editSelection,
            editButton
        );

        // Set the scene and stage and display
        Scene scene = new Scene(layout, 300, 200); 
        createFacultyStage.setScene(scene);
        createFacultyStage.show();
    }
}
    
