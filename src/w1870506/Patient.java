package w1870506;

import java.time.LocalDate;

public class Patient extends Person{ //extend patient class from person class
    private String patientId; //declaring variables

    //default constructor for patient class
    public Patient(){
    }

    //parameterized constructor for patient class
    public Patient(String name, String surname, LocalDate dob, String mobNo,String patientId){
        super(name, surname, dob, mobNo);
        this.patientId = patientId;
    }

    //getter for patient id
    public String getPatientId() {
        return patientId;
    }

    //setter for patient id
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}

