package w1870506;

import java.time.LocalDate;

public class Doctor extends Person { //inherit the doctor class from the person class

    //declaring variables in doctor class
    private String medicalLicenseNo;
    private String specialisation;


    //default constructor for doctor class
    public Doctor() {
    }


    //parameterized constructor for the doctor class
    public Doctor(String name, String surname, LocalDate dob, String mobNo, String medicalLicenseNo, String specialisation){
        super(name, surname, dob, mobNo);
        this.medicalLicenseNo = medicalLicenseNo;
        this.specialisation = specialisation;
    }


    //getter for medical license number
    public String getMedicalLicenseNo() {
        return medicalLicenseNo;
    }

    //setter for medical license number
    public void setMedicalLicenseNo(String medicalLicenseNo) {
        this.medicalLicenseNo = medicalLicenseNo;
    }

    //getter for specialisation
    public String getSpecialisation() {
        return specialisation;
    }

    //setter for specialisation
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
