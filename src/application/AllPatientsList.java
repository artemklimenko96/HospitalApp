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

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    @FXML private Label bloodPressure;
    @FXML private Label breathRate;
    @FXML private Label pulse;
    @FXML private Label bodyTemp;


    private ObservableList<Patient> patientData = FXCollections.observableArrayList();
	
	public ObservableList<Patient> getPatientData() {
        return patientData;
    }
    public ArrayList<Patient> getAllPatients() throws ClassNotFoundException, SQLException {
        Connection conn = application.connectionManager.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From patient";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Patient> patientList = new ArrayList<>();
        while (rst.next()) {
            Patient patient = new Patient(rst.getInt("id"), rst.getString("firstName"), rst.getString("lastName"), rst.getBoolean("gender"), rst.getInt("age"), rst.getString("birthday"), rst.getString("problem"), rst.getBoolean("status"), rst.getInt("room"),rst.getInt("assignedDoctor"), rst.getInt("vitalSignId"), rst.getInt("bloodPressure"), rst.getInt("breathRate"), rst.getInt("pulse"), rst.getInt("bodyTemp"));
            patientList.add(patient);
            // patientData.add(patient);
            System.out.println(patient.getFirstName());
        }
        return patientList;
    }
    @FXML
    private void initialize() {
    	System.out.println("init AllPatientsList");
    	// Add some sample data
        //patientData.add(new Patient("Jean", "Pierre",true,20, LocalDate.now(), "str", true, 5, 5,8,8,8,8,8 ));
        try {
            ArrayList<Patient> patient = getAllPatients();
            for (Patient p:patient) {
                    patientData.add(p);
            }


        }catch (Exception e){e.printStackTrace();}
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
            if(patient.genderProperty().equals(true)){
                genderLabel.setText("male");
            }else {genderLabel.setText("female");}
            ageLabel.setText(String.valueOf(patient.getAge()));
            birthdayLabel.setText(patient.getBirthday());

            if (patient.statusProperty().equals(true)){
                statusLabel.setText("Inpatient");
            } else {statusLabel.setText("Outpatient");}


            if (!patient.roomProperty().equals(null)) {
                roomLabel.setText(String.valueOf(patient.getRoom()));
            }else {roomLabel.setText("N/A");}
            bloodPressure.setText(String.valueOf(patient.getBloodPressure()));
            breathRate.setText(String.valueOf(patient.getBreathRate()));
            pulse.setText(String.valueOf(patient.getPulse()));
            bodyTemp.setText(String.valueOf(patient.getBodyTemp()));

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
    public boolean showPatientAddDialog(Patient patient) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PatientsList.class.getResource("view/PatientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Person");
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
       PatientEditDialog.addUp = false;
       Patient tempPatient = new Patient(144, "name", "family name", true,1,"birthday","problem",true,0,0,0,0,0,0,0);

       boolean okClicked = showPatientAddDialog(tempPatient);
       if (okClicked) {
           this.getPatientData().add(tempPatient);
       }
   }
    
    @FXML
    private void handleEditPatient() {
        PatientEditDialog.addUp = true;
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
