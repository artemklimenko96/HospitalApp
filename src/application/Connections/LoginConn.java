package application.Connections;

import application.connectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Artem Klimenko on 23 Jan 2017.
 */
public  class LoginConn {
    Connection connect = connectionManager.getConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
    String username = "";
    String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResultSet setData(){
        try {
            pst = connect.prepareStatement(sql);
            pst.setString(1, this.getUsername());
            pst.setString(2, this.getPassword());
            rst = pst.executeQuery();
            return rst;

        }catch (SQLException e){e.printStackTrace();}
        return rst;

    }

}
