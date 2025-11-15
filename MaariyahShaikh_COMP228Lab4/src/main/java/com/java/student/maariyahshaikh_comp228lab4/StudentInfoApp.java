package com.java.student.maariyahshaikh_comp228lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentInfoApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextField txtName = new TextField();
        TextField txtAddress = new TextField();
        TextField txtCity = new TextField();
        TextField txtProvince = new TextField();
        TextField txtPostal = new TextField();
        TextField txtPhone = new TextField();
        TextField txtEmail = new TextField();

        RadioButton rbCS = new RadioButton("Computer Science");
        RadioButton rbBus = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        rbCS.setToggleGroup(majorGroup);
        rbBus.setToggleGroup(majorGroup);

        ComboBox<String> cboCourses = new ComboBox<>();
        ListView<String> listCourses = new ListView<>();

        rbCS.setOnAction(e -> {
            cboCourses.getItems().setAll(
                    "Intro to Programming",
                    "Data Structures",
                    "Databases",
                    "Operating Systems",
                    "Networks"
            );
            cboCourses.getSelectionModel().clearSelection();
        });

        rbBus.setOnAction(e -> {
            cboCourses.getItems().setAll(
                    "Accounting I",
                    "Marketing",
                    "Economics",
                    "Business Law",
                    "Management"
            );
            cboCourses.getSelectionModel().clearSelection();
        });

        cboCourses.setOnAction(e -> {
            String selected = cboCourses.getValue();
            if (selected != null && !listCourses.getItems().contains(selected)) {
                listCourses.getItems().add(selected);
            }
        });

        CheckBox chkSports = new CheckBox("Sports");
        CheckBox chkVolunteer = new CheckBox("Volunteer Work");
        CheckBox chkMusic = new CheckBox("Music Club");

        TextArea txtOutput = new TextArea();
        txtOutput.setPrefRowCount(10);

        Button btnDisplay = new Button("Display Student Information");

        btnDisplay.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();

            sb.append("STUDENT INFORMATION\n\n");
            sb.append("Name: ").append(txtName.getText()).append("\n");
            sb.append("Address: ").append(txtAddress.getText()).append("\n");
            sb.append("City: ").append(txtCity.getText()).append("\n");
            sb.append("Province: ").append(txtProvince.getText()).append("\n");
            sb.append("Postal Code: ").append(txtPostal.getText()).append("\n");
            sb.append("Phone: ").append(txtPhone.getText()).append("\n");
            sb.append("Email: ").append(txtEmail.getText()).append("\n");

            sb.append("\nMajor: ");
            if (rbCS.isSelected()) sb.append("Computer Science");
            else if (rbBus.isSelected()) sb.append("Business");

            sb.append("\n\nCourses:\n");
            for (String c : listCourses.getItems()) {
                sb.append(" - ").append(c).append("\n");
            }

            sb.append("\nActivities: ");
            if (chkSports.isSelected()) sb.append("Sports ");
            if (chkVolunteer.isSelected()) sb.append("Volunteer ");
            if (chkMusic.isSelected()) sb.append("Music ");

            txtOutput.setText(sb.toString());
        });

        GridPane formGrid = new GridPane();
        formGrid.setPadding(new Insets(10));
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(new Label("Full Name:"), 0, 0);
        formGrid.add(txtName, 1, 0);
        formGrid.add(new Label("Address:"), 0, 1);
        formGrid.add(txtAddress, 1, 1);
        formGrid.add(new Label("City:"), 0, 2);
        formGrid.add(txtCity, 1, 2);
        formGrid.add(new Label("Province:"), 0, 3);
        formGrid.add(txtProvince, 1, 3);
        formGrid.add(new Label("Postal Code:"), 0, 4);
        formGrid.add(txtPostal, 1, 4);
        formGrid.add(new Label("Phone:"), 0, 5);
        formGrid.add(txtPhone, 1, 5);
        formGrid.add(new Label("Email:"), 0, 6);
        formGrid.add(txtEmail, 1, 6);

        FlowPane majorPane = new FlowPane(10, 10, rbCS, rbBus);
        formGrid.add(new Label("Major:"), 0, 7);
        formGrid.add(majorPane, 1, 7);

        VBox courseBox = new VBox(10,
                new Label("Select Course:"),
                cboCourses,
                new Label("Courses Added:"),
                listCourses
        );
        courseBox.setPadding(new Insets(10));

        VBox activitiesBox = new VBox(10,
                new Label("Activities:"),
                chkSports,
                chkVolunteer,
                chkMusic
        );
        activitiesBox.setPadding(new Insets(10));

        VBox bottomBox = new VBox(10, btnDisplay, txtOutput);
        bottomBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setLeft(formGrid);
        root.setCenter(courseBox);
        root.setRight(activitiesBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Student Information System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
