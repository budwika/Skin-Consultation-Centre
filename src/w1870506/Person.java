package w1870506;
import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable { //using serializable for storing object data in a text file
    //declaring the variables
    private String name;
    private String surname;
    private LocalDate dob;
    private String mobNo;


    //default constructor for person class
    public Person(){
    }


    //parameterized constructor for person class
    public Person(String name, String surname, LocalDate dob, String mobNo){
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobNo = mobNo;
    }

    //getter for name
    public String getName() {
        return name;
    }

    //setter for name
    public void setName(String name) {
        this.name = name;
    }

    //getter for surname
    public String getSurname() {
        return surname;
    }

    //setter for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //getter for dob
    public LocalDate getDob() {
        return dob;
    }

    //setter for dob
    public void setDate(LocalDate date) {
        this.dob = date;
    }

    //getter for mob number
    public String getMobNo() {
        return mobNo;
    }

    //setter for mob no
    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}



