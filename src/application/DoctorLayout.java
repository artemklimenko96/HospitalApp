package application;

import javafx.fxml.FXML;

public class DoctorLayout {
	
	private Main main;
	private String currentScreen;
	
	@FXML
    private void initialize() {
		//System.out.println(main);
		//main.showPatientsList();
	}
	
	@FXML
    private void handleBtn1() {
		if(currentScreen.equals("patients")) return;
		this.main.showPatientsList();
		currentScreen = "patients";
    }
	
	@FXML
    private void handleBtn2() {
		if(currentScreen.equals("alertsroom")) return;
       this.main.showAlertsList();
       currentScreen = "alertsroom";
    }
	
	@FXML
    private void handleBtn3() {
		if(currentScreen.equals("allpatients")) return;
       this.main.showAllPatientsList();
       currentScreen = "allpatients";
    }
	
	@FXML
    private void handleBtn4() {
		if(currentScreen.equals("alertsstaff")) return;
       this.main.showAlertsStaff();
       currentScreen = "alertsstaff";
    }
	
	public void setMain(Main main) {
        this.main = main;
        this.main.showPatientsList();
        currentScreen = "patients";
    }

}
