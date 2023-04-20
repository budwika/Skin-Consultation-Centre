package w1870506;

import java.time.LocalDateTime;

public class Consultation {
    private LocalDateTime consultTime; //declaring variables
    private double cost;
    private Doctor consultDoc;
    private Patient patient;
    protected String notes;

   public Consultation(){ //default constructor
   }

   public Consultation(LocalDateTime consultTime, double cost, Doctor consultDoc, Patient patient,String notes){ //constructor for object creation
       this.consultTime = consultTime;
       this.cost = cost;
       this.consultDoc = consultDoc;
       this.patient = patient;
       this.notes = notes;
   }

   //getter for consult time
    public LocalDateTime getConsultTime() {
        return consultTime;
    }

    //setter for consult time
    public void setConsultTime(LocalDateTime consultTime) {
        this.consultTime = consultTime;
    }

    //getter for cost
    public double getCost() {
        return cost;
    }

    //setter for cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    //getter for doc object
    public Doctor getConsultDoc() {
        return consultDoc;
    }

    //setter for doctor object
    public void setConsultDoc(Doctor consultDoc) {
        this.consultDoc = consultDoc;
    }

    //getter for patient object
    public Patient getPatient() {
        return patient;
    }

    //setter for patient object
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //getter for notes
    public String getNotes() {
        return notes;
    }

    //setter for notes
    public void setNotes(String notes) {
        this.notes = notes;
    }
}


