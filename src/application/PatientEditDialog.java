package application;

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
        genderField.setText(patient.getGender());
        ageField.setText(Integer.toString(patient.getAge()));
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
            patient.setGender(genderField.getText());
            patient.setAge(Integer.parseInt(ageField.getText()));
            patient.setProblem(problemField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
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
