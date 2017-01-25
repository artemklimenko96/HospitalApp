package application;

import application.model.AlertRoom;
import application.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


public class RoomListController {
	
	@FXML private TableView<Patient> roomTable;
	@FXML private TableColumn<Patient, Number> roomColumn; 
    @FXML private TableColumn<Patient, String> firstNameColumn;
    @FXML private TableColumn<Patient, String> lastNameColumn;
    @FXML private TableColumn<Patient, String> lastCheckColumn;
       
	@FXML private TableView<AlertRoom> alertTable;
	@FXML private TableColumn<AlertRoom, Number> alertRoomColumn; 
    @FXML private TableColumn<AlertRoom, String> timeStamp;
    @FXML private TableColumn<AlertRoom, String> sendByColumn;
			
    @FXML private Label firstnamelbl;
    @FXML private Label lastnamelbl;
    @FXML private Label genderlbl;
    @FXML private Label dateOfBirthlbl;
    @FXML private Label doctorlbl;

    @FXML private Label vital1lbl;
    @FXML private Label vital2lbl;
    @FXML private Label vital3lbl;
    @FXML private Label vital4lbl;
    
    @FXML private TextArea descriptionText;
    
    
    private ObservableList<Patient> roomData = FXCollections.observableArrayList();
	
	public ObservableList<Patient> getPatientData() {
        return roomData;
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
    	
	@FXML private void checkedBtn(ActionEvent e) {
		System.out.println("checked");
	}

    @FXML
    private void initialize() {
    	System.out.println("init PatientsList");
        try {
            ArrayList<Patient> patient = getAllPatients();
            for (Patient p:patient) {

                    roomData.add(p);
                System.out.println(p.getAge());
            }


        }catch (Exception e){e.printStackTrace();}
    	// Add some sample data
    	//roomData.add(new Patient("Jean", "Pierre",true,20, LocalDate.now(), "str", true, 5, 5,8,8,8,8,8 ));

        // Add observable list data to the table
    	roomTable.setItems(this.getPatientData());
        // Initialize the person table with the two columns.
    //	roomColumn.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        roomColumn.setCellValueFactory(cellData -> cellData.getValue().roomProperty());
        //Clear person details.
        showRoomDetails(null);
        //Listen for selection changes and show the person details when changed.
        roomTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRoomDetails(newValue));
    }
    
    private void showRoomDetails(Patient patient) {
    	if(patient != null) {
    		firstnamelbl.setText(patient.getFirstName());
    		lastnamelbl.setText(patient.getLastName());
            dateOfBirthlbl.setText(patient.getBirthday());
            genderlbl.setText(String.valueOf(patient.isGender()));
            doctorlbl.setText(String.valueOf(patient.getAssignedDoctor()));
            vital1lbl.setText(String.valueOf(patient.getBloodPressure()));
    		vital2lbl.setText(String.valueOf(patient.getBreathRate()));
            vital3lbl.setText(String.valueOf(patient.getPulse()));
            vital4lbl.setText(String.valueOf(patient.getBodyTemp()));
    	} else {
    		firstnamelbl.setText("");
    		lastnamelbl.setText("");
    		genderlbl.setText("");
    		dateOfBirthlbl.setText("");
    		doctorlbl.setText("");
    	}
    }
    
      
}
