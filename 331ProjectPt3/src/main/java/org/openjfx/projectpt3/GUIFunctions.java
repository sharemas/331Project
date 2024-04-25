package org.openjfx.projectpt3;

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
        String reportt = "";
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
                    ComboBox<Faculty> facultyComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.FacultyList));
                    Label semesterLabel = new Label("Select Semester:");
                    ComboBox<Semester> semesterComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList));
                    additionalFields.getChildren().addAll(facultyLabel, facultyComboBox, semesterLabel, semesterComboBox);
                    reportt = Main.FacultyCourses(semesterComboBox.getValue(), facultyComboBox.getValue());
                    break;
                case "All courses a student is taking in a semester":
                    Label studentLabel = new Label("Select Student:");
                    ComboBox<Student> studentComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.StudentList));
                    Label semesterLabel2 = new Label("Select Semester:");
                    ComboBox<Semester> semesterComboBox2 = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList));
                    additionalFields.getChildren().addAll(studentLabel, studentComboBox, semesterLabel2, semesterComboBox2);
                    reportt = Main.CourseSemester(semesterComboBox.getValue(), studentComboBox.getValue());
                    break;
                case "All students in a single course in a semester":
                    Label courseLabel = new Label("Select Course:");
                    ComboBox<Course> courseComboBox = new ComboBox<>(FXCollections.observableArrayList(Main.courseList));
                    Label semesterLabel3 = new Label("Select Semester:");
                    ComboBox<Semester> semesterComboBox3 = new ComboBox<>(FXCollections.observableArrayList(Main.SemesterList));
                    additionalFields.getChildren().addAll(courseLabel, courseComboBox, semesterLabel3, semesterComboBox3);
                    reportt = Main.StudentCourse(courseComboBox.getValue(), semesterComboBox.getValue());
                    break;
            }
        });

        // On click, the report will show in the textbox 
        generateButton.setOnAction(event -> {

            reportTextArea.setText(reportt);
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

