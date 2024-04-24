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
        ComboBox<String> studentSelection = new ComboBox<>(
            FXCollections.observableArrayList(Main.StudentNames())
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
                String student = studentSelection.getValue();

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
                        inputField.setText(""); //student.getName());
                        break;
                    case "SSN":
                        inputField.setText(String.valueOf("")); //student.getSsn()));
                        break;
                    case "Address":
                        inputField.setText(""); //student.getAddress());
                        break;
                    case "Email":
                        inputField.setText(""); //student.getEmail());
                        break;
                    case "GPA":
                        inputField.setText(String.valueOf("")); //student.getGpa()));
                        break;
                    case "Emergency Contact Name":
                        inputField.setText(""); 
                        break;
                    case "Emergency Contact Phone":
                        inputField.setText("");
                        break;
                    case  "Emergency Contact Address":
                        inputField.setText("");
                        break;
                        
                }

                    // Create a save button with an action listener to store the user input
                    // Switch statement used to determine which attribute is being altered 
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction(event2 -> {
                        // Save the new value to the selected part
                        switch (selection) {
                            case "Name":
                                // student.setName(inputField.getText());
                                break;
                            case "SSN":
                                // student.setSsn(Integer.parseInt(inputField.getText()));
                                break;
                            case "Address":
                                // student.setAddress(inputField.getText());
                                break;
                            case "Email":
                                // student.setEmail(inputField.getText());
                                break;
                            case "GPA":
                                // student.setGpa(Double.parseDouble(inputField.getText()));
                                break;
                            case "Emergency Contact Name":
                                break;
                            case "Emergency Contact Phone":
                                break;
                            case "Emergency Contact Address":
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
        ComboBox<String> courseSelection = new ComboBox<>(
            FXCollections.observableArrayList(courseNames)
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
                String selectedCourseName = courseSelection.getValue();
                String selectedAttribute = editSelection.getValue();

                // Make sure user selects something from both drop down menus
                if (selectedCourseName != null && selectedAttribute != null) {
                   // Create a small pop up window for editing attribute and format it
                    Stage editPartStage = new Stage();
                    editPartStage.setTitle("Edit " + selectedAttribute);
                    VBox layout2 = new VBox(10);
                    layout2.setPadding(new Insets(10));

                    TextField inputField = new TextField();

                    // Based on the selected attribute, display in the textfield the current text in the attribute
                    switch (selectedAttribute) {
                        case "Prefix":
                            inputField.setText(""); // set with current course prefix
                            break;
                        case "Number":
                            inputField.setText(""); // set with current course number
                            break;
                        case "Course Name":
                            inputField.setText(""); // set with current course name
                            break;
                        case "Days per Week":
                            inputField.setText(""); // set with current days per week
                            break;
                        case "Start Time":
                            inputField.setText(""); // set with current start time
                            break;
                        case "End Time":
                            inputField.setText(""); // set with current end time
                            break;
                        case "Number of Credits":
                            inputField.setText(""); // set with current num credits
                            break;
                    }

                    // Create a save button that saved the new value to the selected attribute
                    Button saveButton = new Button("Save");
                    saveButton.setOnAction(event2 -> {
                        switch (selectedAttribute) {
                            case "Prefix":
                                // Update course prefix
                                break;
                            case "Number":
                                // Update course number
                                break;
                            case "Course Name":
                                // Update course name
                                break;
                            case "Days per Week":
                                // Update days per week
                                break;
                            case "Start Time":
                                // Update start time
                                break;
                            case "End Time":
                                // Update end time
                                break;
                            case "Number of Credits":
                                // Update number of credits
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
                                inputField.setText("");
                                break;
                            case "Email":
                                inputField.setText("");
                                break;
                            case "Building Name":
                                inputField.setText("");
                                break;
                            case "Office Number":
                                inputField.setText("");
                                break;
                            case "Phone Number":
                                inputField.setText("");
                                break;
                            case "Position":
                                inputField.setText("");
                                break;
                        }

                        // Create save button with action listener to update the selected attribute
                        Button saveButton = new Button("Save");
                        saveButton.setOnAction(event2 -> {
                            // Code to update the selected attribute
                            switch (selectedAttribute) {
                                case "Name":
                                    // Code to update the faculty name
                                    break;
                                case "Email":
                                    // Code to update the faculty email
                                    break;
                                case "Building Name":
                                    // Code to update the faculty building name
                                    break;
                                case "Office Number":
                                    // Code to update the faculty office number
                                    break;
                                case "Phone Number":
                                    // Code to update the faculty phone number
                                    break;
                                case "Position":
                                    // Code to update the faculty position
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
    

