package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {
	
		@FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Button submitButton;
	  
	    @FXML
	    private Label statuslbl;
	    
	    private Main main;
	    
	    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
	        System.out.println("submit");
	        System.out.println(username.getText() + "/" + password.getText());
	        //temporary validation
	        if(username.getText().equals("a") && password.getText().equals("a")) {
	        	System.out.println("Login as Doctor");
	        	Main.setUserClass(true);
	        	Main.setCurrentUserName(username.getText());
	        	main.initMainLayout();
	        	//main.initUserInfo();
	        	main.initDoctorControls();
	        }
	        
	        if(username.getText().equals("b") && password.getText().equals("b")) {
	        	System.out.println("Login as Staff");
	        	Main.setUserClass(false);
	        	Main.setCurrentUserName(username.getText());
	        	main.initMainLayout();
	        	//main.initUserInfo();
	        	main.initStaffControls();
	        }
	        
	        else {
	        	
	        	statuslbl.setText("Login failed");
	        }
	    }	
    
	    public void setMain(Main main) {
	        this.main = main;
	    }

}
