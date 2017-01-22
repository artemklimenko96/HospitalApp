package application;

import java.text.DecimalFormat;
import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private static Stage mainStage;
	private static BorderPane mainLayout;


	static boolean userClass;
	static String currentUserName;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login");
		initLogin();
	}
	
	public void initLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/LoginView.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            Scene scene = new Scene(login);
    		scene.getStylesheets().add(getClass().getResource("theme/loginTheme.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("HI");
            LoginController controller = loader.getController();
            controller.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public void initMainLayout() {
		try {
			primaryStage.close();
			mainStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
            mainLayout = (BorderPane) loader.load();
            Scene scene = new Scene(mainLayout);
    		Main.mainStage.setTitle("HospitalApp");
    		
    		if(userClass == true) {
    			scene.getStylesheets().add(getClass().getResource("theme/doctorTheme.css").toExternalForm());
    		}
    		
    		else {
    			scene.getStylesheets().add(getClass().getResource("theme/staffTheme.css").toExternalForm());
    		}
    		
    		mainStage.setScene(scene);
    		mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDoctorControls() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/DoctorLayout.fxml"));
	        AnchorPane doctorControls = (AnchorPane) loader.load();
	        mainLayout.setLeft(doctorControls);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initStaffControls() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/StaffLayout.fxml"));
	        AnchorPane staffControls = (AnchorPane) loader.load();
	        mainLayout.setLeft(staffControls);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void showPatientsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/PatientsList.fxml"));
	        AnchorPane patientsList = (AnchorPane) loader.load();
	        mainLayout.setCenter(patientsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void showAlertsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AlertsList.fxml"));
	        AnchorPane alertsList = (AnchorPane) loader.load();
	        mainLayout.setCenter(alertsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAllPatientsList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AllPatientsList.fxml"));
	        AnchorPane patientsList = (AnchorPane) loader.load();
	        mainLayout.setCenter(patientsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAlertsStaff() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/AlertsStaff.fxml"));
	        AnchorPane alertsList = (AnchorPane) loader.load();
	        mainLayout.setCenter(alertsList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showRoomList() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/RoomListView.fxml"));
	        AnchorPane roomList = (AnchorPane) loader.load();
	        mainLayout.setCenter(roomList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public  static String getLocalTime() {

			DecimalFormat mFormat = new DecimalFormat("00");
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			//System.out.println(mFormat.format(Double.valueOf(hour))+":"+mFormat.format(Double.valueOf(minute))+":"+mFormat.format(Double.valueOf(second)));
			return mFormat.format(Double.valueOf(hour))+":"+mFormat.format(Double.valueOf(minute))+":"+mFormat.format(Double.valueOf(second));
	   }
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		Main.mainStage = mainStage;
	}
	
    public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public static String getCurrentUserName() {
		return currentUserName;
	}

	public static void setCurrentUserName(String currentUserName) {
		Main.currentUserName = currentUserName;
	}
	
	public static boolean isUserClass() {
		return userClass;
	}

	public static void setUserClass(boolean userClass) {
		Main.userClass = userClass;
	}	
}