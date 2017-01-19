package application.model;

import application.connectionManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlertRoom {
	
	private final IntegerProperty roomNbr;
    private final StringProperty desc;
    
    public AlertRoom() {
        this(null, null);
    }
    
    public AlertRoom(Integer roomNbr, String desc) {
        this.roomNbr = new SimpleIntegerProperty(roomNbr);
        this.desc = new SimpleStringProperty(desc);
    }
    
    public Integer getRoomNbr() {
		return roomNbr.get();
	}
	
	public void setRoomNbr(Integer roomNbr) {
        this.roomNbr.set(roomNbr);
    }

    public IntegerProperty roomNbrProperty() {
        return roomNbr;
    }
    
    public String getDesc() {
		return desc.get();
	}
	
	public void setDesc(String desc) {
        this.desc.set(desc);
    }

    public StringProperty descProperty() {
        return desc;
    }
    public static ArrayList<AlertRoom> getAlertList() throws SQLException{
        ArrayList<AlertRoom> alertList = new ArrayList<>();
        Connection conn = connectionManager.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From alerts";
        ResultSet rst;
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            AlertRoom alert = new AlertRoom(rst.getInt("roomNr"), rst.getString("info"));
            alertList.add(alert);
        }
        return alertList;
    }
}
