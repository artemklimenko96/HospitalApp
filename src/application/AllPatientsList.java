package application;

import application.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllPatientsList {
    Connection connect = application.connectionManager.getConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
	
	@FXML private TextField filterField;
	@FXML private TableView<Patient> patientTable;
    @FXML private TableColumn<Patient, String> firstNameColumn;
    @FXML private TableColumn<Patient, String> lastNameColumn;
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label genderLabel;
    @FXML private Label ageLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label statusLabel;
    @FXML private Label roomLabel;
    @FXML private Label problemLabel;

    private ObservableList<Patient> patientData = FXCollections.observableArrayList();
	
	public ObservableList<Patient> getPatientData() {
        return patientData;
    }

    @FXML
    private void initialize() {
    	System.out.println("init AllPatientsList");
    	// Add some sample data
    	patientData.add(new Patient("Jean", "Pierre"));
        patientData.add(new Patient("Leopoldo", "Zuniga"));
        patientData.add(new Patient("Werner", "Herzog"));
        patientData.add(new Patient("Christopher", "Nkunku"));
        patientData.add(new Patient("Adrien", "Rabiot"));
        patientData.add(new Patient("Lorenzo", "Callegari"));
        // Add observable list data to the table
        patientTable.setItems(this.getPatientData());
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        //Clear person details.
        showPatientDetails(null);
        //Listen for selection changes and show the person details when changed.
        patientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPatientDetails(newValue));
     // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Patient> filteredData = new FilteredList<>(patientData, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                /*if (person.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else*/ if (person.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Patient> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(patientTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        patientTable.setItems(sortedData);
    }
    
    private void showPatientDetails(Patient patient) {
    	if(patient != null) {
    		firstNameLabel.setText(patient.getFirstName());
    		lastNameLabel.setText(patient.getLastName());
    		genderLabel.setText(patient.getGender());
    		ageLabel.setText(String.valueOf(patient.getAge()));
    		String formattedDate = patient.getBirthday().toString();
    		birthdayLabel.setText(formattedDate);
    		String status;
    		if (patient.getStatus()) status = "Inpatient";
    		else status = "Outpatient";
    		statusLabel.setText(status);
    		String room;
    		if (patient.getRoom() != null) room = patient.getRoom().toString();
    		else room = "none";
    		roomLabel.setText(room);
    		problemLabel.setText(patient.getProblem());
    	} else {
    		firstNameLabel.setText("");
    		lastNameLabel.setText("");
    		genderLabel.setText("");
    		ageLabel.setText("");
    		birthdayLabel.setText("");
    		statusLabel.setText("");
    		roomLabel.setText("");
    		problemLabel.setText("");
    	}
    }
    
    public boolean showPatientEditDialog(Patient patient) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PatientsList.class.getResource("view/PatientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PatientEditDialog controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPatient(patient);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleNewPatient() {
        Patient tempPatient = new Patient();
        boolean okClicked = showPatientEditDialog(tempPatient);
        if (okClicked) {
            this.getPatientData().add(tempPatient);
        }
    }
    
    @FXML
    private void handleEditPatient() {
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            boolean okClicked = showPatientEditDialog(selectedPatient);
            if (okClicked) {
                showPatientDetails(selectedPatient);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

}
