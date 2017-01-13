package application.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {
	
	private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty gender;
    private final IntegerProperty age;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty problem;
    private final BooleanProperty status;
    private final IntegerProperty room;
    private final IntegerProperty vitalSignId;
	
    /**
     * Default constructor.
     */
    public Patient() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Patient(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.gender = new SimpleStringProperty("man");
        this.age = new SimpleIntegerProperty(30);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1987, 12, 14));
        this.problem = new SimpleStringProperty("bla bla bla");
        this.status = new SimpleBooleanProperty(true);
        this.room = new SimpleIntegerProperty(42);
        this.vitalSignId = new SimpleIntegerProperty(1);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

	public String getGender() {
		return gender.get();
	}
	
	public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }
    
    public Integer getAge() {
		return age.get();
	}
	
	public void setAge(Integer age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }
    
    public LocalDate getBirthday() {
		return birthday.get();
	}
	
	public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
    
    public String getProblem() {
        return problem.get();
    }

    public void setProblem(String problem) {
        this.problem.set(problem);
    }

    public StringProperty problemProperty() {
        return problem;
    }
    
    public Boolean getStatus() {
        return status.get();
    }

    public void setStatus(Boolean status) {
        this.status.set(status);
    }

    public BooleanProperty statusProperty() {
        return status;
    }
    
    public Integer getRoom() {
		return room.get();
	}
	
	public void setRoom(Integer room) {
        this.room.set(room);
    }

    public IntegerProperty roomProperty() {
        return room;
    }
    
    public Integer getVitalSignId() {
		return vitalSignId.get();
	}
	
	public void setVitalSignId(Integer vitalSignId) {
        this.vitalSignId.set(vitalSignId);
    }

    public IntegerProperty vitalSignIdProperty() {
        return vitalSignId;
    }
    
}
