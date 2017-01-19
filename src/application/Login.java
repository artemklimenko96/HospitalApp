package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
		Connection connect = connectionManager.getConnection();
		PreparedStatement pst = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM personnel WHERE username = ? AND password = ?";
	
		@FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Button submitButton;
	    
	 // Reference to the main application.
	    private Main main;
	    
	    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
			try{
				pst = connect.prepareStatement(sql);
				pst.setString(1, username.getText());
				pst.setString(2, password.getText());
				rst = pst.executeQuery();
				if(rst.next()){
					main.initDoctorLayout();
				}
				else{
					System.out.println("Wrooooooooong!");
					username.setText("Wrooooong");
				}

			}
			catch (Exception e){}

	    }	
	    
	    public void setMain(Main main) {
	        this.main = main;
	    }

}
