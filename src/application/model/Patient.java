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
        private  SimpleIntegerProperty id;
        private  StringProperty firstName;
        private  StringProperty lastName;
        private  SimpleBooleanProperty gender;
        private  SimpleIntegerProperty age;
        private  SimpleStringProperty birthday;
        private  StringProperty problem;
        private  SimpleBooleanProperty status;
        private  SimpleIntegerProperty room;
        private  SimpleIntegerProperty assignedDoctor;
        private  SimpleIntegerProperty vitalSignId;
        private  SimpleIntegerProperty bloodPressure;
        private  SimpleIntegerProperty breathRate;
        private  SimpleIntegerProperty pulse;
        private  SimpleIntegerProperty bodyTemp;

    public Patient(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    /**
         * Default constructor.
         */

    public Patient(){
        // this(0, null,null, null,0, null,null, null,0, 0,0, 0, 0, 0, 0 );
    }

        public Patient(int id, String firstName, String lastName, Boolean gender, int age, String birthday, String problem, Boolean status, int room, int assignedDoctor, int vitalSignId, int bloodPressure, int breathRate, int pulse, int bodyTemp) {
            this.id = new SimpleIntegerProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.gender = new SimpleBooleanProperty(gender);
            this.age = new SimpleIntegerProperty(age);
            this.birthday = new SimpleStringProperty(birthday);
            this.problem = new SimpleStringProperty(problem);
            this.status = new SimpleBooleanProperty(status);
            this.room = new SimpleIntegerProperty(room);
            this.assignedDoctor = new SimpleIntegerProperty(assignedDoctor);
            this.vitalSignId = new SimpleIntegerProperty(vitalSignId);
            this.bloodPressure = new SimpleIntegerProperty(bloodPressure);
            this.breathRate = new SimpleIntegerProperty(breathRate);
            this.pulse = new SimpleIntegerProperty(pulse);
            this.bodyTemp = new SimpleIntegerProperty(bodyTemp);
        }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public boolean isGender() {
        return gender.get();
    }

    public SimpleBooleanProperty genderProperty() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender.set(gender);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getProblem() {
        return problem.get();
    }

    public StringProperty problemProperty() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem.set(problem);
    }


    public boolean isStatus() {
        return status.get();
    }

    public SimpleBooleanProperty statusProperty() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }

    public int getRoom() {
        return room.get();
    }

    public SimpleIntegerProperty roomProperty() {
        return room;
    }

    public void setRoom(int room) {
        this.room.set(room);
    }

    public int getAssignedDoctor() {
        return assignedDoctor.get();
    }

    public SimpleIntegerProperty assignedDoctorProperty() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(int assignedDoctor) {
        this.assignedDoctor.set(assignedDoctor);
    }

    public int getVitalSignId() {
        return vitalSignId.get();
    }

    public SimpleIntegerProperty vitalSignIdProperty() {
        return vitalSignId;
    }

    public void setVitalSignId(int vitalSignId) {
        this.vitalSignId.set(vitalSignId);
    }

    public int getBloodPressure() {
        return bloodPressure.get();
    }

    public SimpleIntegerProperty bloodPressureProperty() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure.set(bloodPressure);
    }

    public int getBreathRate() {
        return breathRate.get();
    }

    public SimpleIntegerProperty breathRateProperty() {
        return breathRate;
    }

    public void setBreathRate(int breathRate) {
        this.breathRate.set(breathRate);
    }

    public int getPulse() {
        return pulse.get();
    }

    public SimpleIntegerProperty pulseProperty() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse.set(pulse);
    }

    public int getBodyTemp() {
        return bodyTemp.get();
    }

    public SimpleIntegerProperty bodyTempProperty() {
        return bodyTemp;
    }

    public void setBodyTemp(int bodyTemp) {
        this.bodyTemp.set(bodyTemp);
    }
}