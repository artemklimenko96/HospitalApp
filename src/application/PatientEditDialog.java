package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientEditDialog {
	
	@FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField roomField;
    @FXML
    private TextField problemField;
   
    private Stage dialogStage;
    private Patient patient;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        if (patient.genderProperty().equals(true)){
            genderField.setText("male");
        }else{genderField.setText("female");}

        ageField.setText(Integer.toString(patient.getAge()));
        String formattedDate = patient.getBirthday().toString();
		birthdayField.setText(formattedDate);
		String status;
		if (patient.statusProperty().equals(true)) status = "Inpatient";
		else status = "Outpatient";
		statusField.setText(status);
		String room;
		if (patient.getRoom() != 0) room = patient.roomProperty().getValue().toString();
		else room = "none";
		roomField.setText(room);
        problemField.setText(patient.getProblem());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            patient.setFirstName(firstNameField.getText());
            patient.setLastName(lastNameField.getText());
            if(genderField.getText().equals("male")){
            patient.setGender(true);
            }else{patient.setGender(false);}
            patient.setAge(Integer.parseInt(ageField.getText()));
          /*  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthday = LocalDate.parse(birthdayField.getText(),formatter);*/
            patient.setBirthday(birthdayField.getText());
            Boolean status;
            if (statusField.getText().equals("Inpatient")) status = true;
            else status = false;
            patient.setStatus(status);
            patient.setRoom(Integer.parseInt(roomField.getText()));
            patient.setProblem(problemField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    //wip: miss validation for additionnal info
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (genderField.getText() == null || genderField.getText().length() == 0) {
            errorMessage += "No valid gender!\n"; 
        }

        if (ageField.getText() == null || ageField.getText().length() == 0) {
            errorMessage += "No valid age!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid age (must be an integer)!\n"; 
            }
        }

        if (problemField.getText() == null || problemField.getText().length() == 0) {
            errorMessage += "No valid problem!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
