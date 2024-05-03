package com.noahkurtz.databasep4;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import oracle.jdbc.*;
import java.util.*;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import java.sql.*;
import java.util.Scanner;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import oracle.jdbc.pool.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class App extends Application {

public static OracleDataSource oDS;
public static Connection jsqlConn;
public static PreparedStatement jsqlStmt;
public static ResultSet jsqlResults;
public static Scanner keyboardIn = new Scanner(System.in);

public static void runDBQuery(String query, char queryType)
{
// queryType - Using the C.R.U.D. acronym
// 'r' - SELECT
// 'c', 'u', or 'd' - UPDATE, INSERT, DELETE
try
{
String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
String user = "javauser";
String pass = "javapass";
oDS = new OracleDataSource();
oDS.setURL(URL);
jsqlConn = oDS.getConnection(user, pass);
jsqlStmt = jsqlConn.prepareStatement(
query,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
if (queryType == 'r')
jsqlResults = jsqlStmt.executeQuery();
else
jsqlStmt.executeUpdate();
}
catch (SQLException sqlex)
{
System.out.println(sqlex.toString());
}
} // End of runDBQuery() method

    @Override
    public void start(Stage primaryStage) throws SQLException {
        primaryStage.setTitle("JMU University Management System");

        // Create a GridPane layout and format it
        GridPane gridLayout = new GridPane();
        gridLayout.setPadding(new Insets(15));
        gridLayout.setHgap(50);
        gridLayout.setVgap(20); 
        gridLayout.setAlignment(Pos.TOP_CENTER); 

        // Set a label at the top as the title
        // Set the font to 17pt, bold it, set to span 3 columns and center on the screen
        Label title = new Label("JMU University Management System");
        title.setStyle("-fx-font-size: 17pt; -fx-font-weight: bold;");
        gridLayout.add(title, 0, 0, 3, 1); 
        GridPane.setHalignment(title, HPos.CENTER);

        // Create buttns
        Button createStudentButton = new Button("Create Student");
        Button createCourseButton = new Button("Create Course");
        Button createFacultyButton = new Button("Create Faculty");
        Button createDepartmentButton = new Button("Create Department");
        Button createSemesterButton = new Button("Create Semester");

        // Editing buttons
        Button editStudentButton = new Button("Edit Student");
        Button editCourseButton = new Button("Edit Course");
        Button editFacultyButton = new Button("Edit Faculty");

        Button enrollButton = new Button("Enroll");
        Button scheduleButton = new Button("Schedule");

        Button reportButton = new Button("Print Reports");

        // Add buttons to the first column
        gridLayout.add(createStudentButton, 0, 1); 
        gridLayout.add(createCourseButton, 0, 2);
        gridLayout.add(createFacultyButton, 0, 3);
        gridLayout.add(createDepartmentButton, 0, 4);
        gridLayout.add(createSemesterButton, 0, 5);

        // Add buttons to the second column and align right
        gridLayout.add(enrollButton, 2, 1);
        GridPane.setHalignment(enrollButton, HPos.RIGHT); 
        gridLayout.add(scheduleButton, 2, 2);
        GridPane.setHalignment(scheduleButton, HPos.RIGHT); 
        gridLayout.add(editStudentButton, 2, 3);
        GridPane.setHalignment(editStudentButton, HPos.RIGHT);
        gridLayout.add(editCourseButton, 2, 4);
        GridPane.setHalignment(editCourseButton, HPos.RIGHT);
        gridLayout.add(editFacultyButton, 2, 5);
        GridPane.setHalignment(editFacultyButton, HPos.RIGHT);

        gridLayout.add(reportButton, 0, 6, 3, 1); // Spanning three columns
        GridPane.setHalignment(reportButton, HPos.CENTER);

        // Attach event listeners to each button
        createStudentButton.setOnAction(event -> CreateFunctions.createStudent());
        createCourseButton.setOnAction(event -> CreateFunctions.createCourse());
        createFacultyButton.setOnAction(event -> CreateFunctions.createFaculty());
        createDepartmentButton.setOnAction(event -> CreateFunctions.createDepartment());
        createSemesterButton.setOnAction(event -> CreateFunctions.createSemester());
        
        editStudentButton.setOnAction(event -> EditFunctions.editStudent());
        editCourseButton.setOnAction(event -> EditFunctions.editCourse());
        editFacultyButton.setOnAction(event -> EditFunctions.editFaculty());
        
        enrollButton.setOnAction(event -> GUIFunctions.enroll());
        scheduleButton.setOnAction(event -> GUIFunctions.schedule());
        
        reportButton.setOnAction(event -> GUIFunctions.report());
       
        // update lists using the database
        ReportFunctions.updateDepartments();
        ReportFunctions.updateCourseList();
        ReportFunctions.updateStudentList();
        ReportFunctions.updateFacultyList();
        ReportFunctions.updateSemesterList();
        ReportFunctions.updateEnrollmentList();
        ReportFunctions.updateScheduleList();
        
        // Create the scene and set it on the stage
        Scene scene = new Scene(gridLayout, 450, 400); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
