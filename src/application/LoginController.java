package application;

import application.Connections.LoginConn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {
	Connection connect = application.connectionManager.getConnection();
	PreparedStatement pst = null;
	ResultSet rst = null;
	String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
	boolean type = false;
	int docId = 0;
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
			try{
				pst = connect.prepareStatement(sql);
				pst.setString(1, username.getText());
				pst.setString(2, password.getText());
				rst = pst.executeQuery();
				//


			if(rst.next()){
				docId = rst.getInt(1);
				type = rst.getBoolean(4);
				if(type){
				System.out.println("Login as Doctor");
				Main.setUserClass(true);
				Main.setCurrentUserName(username.getText());
				main.initMainLayout();
				main.initDoctorControls();
				}else {
					System.out.println("Login as Staff");
					Main.setUserClass(false);
					Main.setCurrentUserName(username.getText());
					main.initMainLayout();
					//main.initUserInfo();
					main.initStaffControls();
				}

			}
			else {

				statuslbl.setText("Login failed");
			}
			}catch (SQLException e){e.printStackTrace();}
	        //temporary validation

	       /* if(username.getText().equals("b") && password.getText().equals("b")) {
	        	System.out.println("Login as Staff");
	        	Main.setUserClass(false);
	        	Main.setCurrentUserName(username.getText());
	        	main.initMainLayout();
	        	//main.initUserInfo();
	        	main.initStaffControls();
	        }*/
	        

	    }	
    
	    public void setMain(Main main) {
	        this.main = main;
	    }

}
