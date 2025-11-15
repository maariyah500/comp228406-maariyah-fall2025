package com.java.student.maariyahshaikh_comp228lab4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashSet;

public class StudentInfoApp extends Application {
    private TextField nameField, addressField, cityField, provinceField, postalCodeField, phoneNumberField, emailField;
    private RadioButton radioButton1, radioButton2;
    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;
    private CheckBox activity1CheckBox, activity2CheckBox;
    private TextArea resultTextArea;
    private ObservableList<String> courses1, courses2;
    private HashSet<String> selectedCourses;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information Application");

        nameField = new TextField();
        addressField = new TextField();
        cityField = new TextField();
        provinceField = new TextField();
        postalCodeField = new TextField();
        phoneNumberField = new TextField();
        emailField = new TextField();

        ToggleGroup majorToggleGroup = new ToggleGroup();
        radioButton1 = new RadioButton("Software Engineering");
        radioButton2 = new RadioButton("Business");
        radioButton1.setToggleGroup(majorToggleGroup);
        radioButton2.setToggleGroup(majorToggleGroup);

        courseComboBox = new ComboBox<>();
        courseListView = new ListView<>();
        selectedCourses = new HashSet<>();
        courses1 = FXCollections.observableArrayList("Databases", "Java", "C#", "Software Systems");
        courses2 = FXCollections.observableArrayList("Business 101", "Marketing Strategies", "Applied Mathematics", "Financial Literacy");

        radioButton1.setOnAction(e -> {
            courseComboBox.setItems(courses1);
            courseComboBox.getSelectionModel().clearSelection();
        });
        radioButton2.setOnAction(e -> {
            courseComboBox.setItems(courses2);
            courseComboBox.getSelectionModel().clearSelection();
        });

        Button addCourseButton = new Button("Add Course");
        addCourseButton.setOnAction(e -> addCourse());

        activity1CheckBox = new CheckBox("Student Council");
        activity2CheckBox = new CheckBox("Volunteer Work");

        resultTextArea = new TextArea();
        resultTextArea.setPrefHeight(150);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> displayStudentInformation());

        GridPane inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setHgap(10);
        inputPane.setVgap(10);

        inputPane.add(new Label("Full Name:"), 0, 0);
        inputPane.add(nameField, 1, 0);

        inputPane.add(new Label("Address:"), 0, 1);
        inputPane.add(addressField, 1, 1);

        inputPane.add(new Label("City:"), 0, 2);
        inputPane.add(cityField, 1, 2);

        inputPane.add(new Label("Province:"), 0, 3);
        inputPane.add(provinceField, 1, 3);

        inputPane.add(new Label("Postal Code:"), 0, 4);
        inputPane.add(postalCodeField, 1, 4);

        inputPane.add(new Label("Phone Number:"), 0, 5);
        inputPane.add(phoneNumberField, 1, 5);

        inputPane.add(new Label("Email:"), 0, 6);
        inputPane.add(emailField, 1, 6);

        VBox majorPane = new VBox(10, radioButton1, radioButton2, courseComboBox, addCourseButton);
        majorPane.setPadding(new Insets(10));

        VBox additionalInfoPane = new VBox(10, activity1CheckBox, activity2CheckBox);
        additionalInfoPane.setPadding(new Insets(10));

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(10));
        mainPane.setTop(inputPane);
        mainPane.setLeft(majorPane);
        mainPane.setRight(additionalInfoPane);
        mainPane.setCenter(courseListView);
        mainPane.setBottom(new VBox(10, submitButton, resultTextArea));

        Scene scene = new Scene(mainPane, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addCourse() {
        String selectedCourse = courseComboBox.getValue();
        if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
            selectedCourses.add(selectedCourse);
            courseListView.getItems().add(selectedCourse);
        }
    }

    private void displayStudentInformation() {
        StringBuilder studentInfo = new StringBuilder();

        studentInfo.append("Name: ").append(nameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append("\n")
                .append("City: ").append(cityField.getText()).append("\n")
                .append("Province: ").append(provinceField.getText()).append("\n")
                .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                .append("Phone Number: ").append(phoneNumberField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n");

        String major = radioButton1.isSelected() ? "Software Engineering" : radioButton2.isSelected() ? "Business" : "Not Selected";
        studentInfo.append("Major: ").append(major).append("\n");

        studentInfo.append("Courses: ").append(courseListView.getItems()).append("\n");

        studentInfo.append("Activities: ");
        if (activity1CheckBox.isSelected()) studentInfo.append("Student Council");
        if (activity2CheckBox.isSelected()) studentInfo.append("Volunteer Work");

        resultTextArea.setText(studentInfo.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}