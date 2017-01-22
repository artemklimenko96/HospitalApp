package application;

import java.text.DecimalFormat;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MainController {
	
	@FXML Label userLabel;
	@FXML Label timeLabel;
	
	
	@FXML
    private void initialize() {
		
		userLabel.setText(Main.getCurrentUserName());
		
		DecimalFormat mFormat = new DecimalFormat("00");
        Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		timeLabel.setText("Login at: " +mFormat.format(Double.valueOf(hour))+":"+mFormat.format(Double.valueOf(minute))+":"+mFormat.format(Double.valueOf(second)));
	}
	
	@FXML public void logout(ActionEvent e) {
		System.out.println("logout");
		Main.getMainStage().close();
		//main.initLogin();
	}
}