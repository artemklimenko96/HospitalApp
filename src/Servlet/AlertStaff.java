package Servlet;


import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class AlertStaff implements Serializable {
	
	public String firstName;
	public String lastName;
    public String desc;
    private ArrayList<String> users;
    private Date time;

    public AlertStaff() {
        this(null, null, null);
    }
    //constructor for client
    public AlertStaff(String firstName, String lastName, String desc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.desc = desc;
    }
    //constructor for server


    public AlertStaff(String firstName, String lastName, String desc, ArrayList<String> users) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.desc = desc;
        this.users = users;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String firstNameProperty() {
        return firstName;
    }
    
    public String getLastName() {
		return lastName;
	}
    public void setActiveUsers(ArrayList<String> users) {
        this.users = users;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String lastNameProperty() {
        return lastName;
    }
    
    public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
        this.desc = desc;
    }

    public String descProperty() {
        return desc;
    }
    public String getDate(){
        Time tm = new Time(this.time.getTime());
        return tm.toString();
    }
   

}
