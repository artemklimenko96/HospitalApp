package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane doctorLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("TestApp");
		initLogin();
	}
	
	public void initLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            Scene scene = new Scene(login);
            primaryStage.setScene(scene);
            primaryStage.show();
            // Give the controller access to the main app.
            Login controller = loader.getController();
            controller.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDoctorLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/DoctorLayout.fxml"));
            doctorLayout = (BorderPane) loader.load();
            Scene scene = new Scene(doctorLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            DoctorLayout controller = loader.getController();
            controller.setMain(this);
            //showPatientsList();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showPatientsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/PatientsList.fxml"));
	        AnchorPane patientsList = (AnchorPane) loader.load();
	        doctorLayout.setCenter(patientsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAlertsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AlertsList.fxml"));
	        AnchorPane alertsList = (AnchorPane) loader.load();
	        doctorLayout.setCenter(alertsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAllPatientsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AllPatientsList.fxml"));
	        AnchorPane patientsList = (AnchorPane) loader.load();
	        doctorLayout.setCenter(patientsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAlertsStaff() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AlertsStaff.fxml"));
	        AnchorPane alertsList = (AnchorPane) loader.load();
	        doctorLayout.setCenter(alertsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
