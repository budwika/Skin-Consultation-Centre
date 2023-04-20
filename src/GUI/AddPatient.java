package GUI;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import w1870506.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class AddPatient {
    //declaring swing components
    private JFrame aPFrame;
    private JPanel apPanel1,apPanel2;
    private JLabel title, name, surName, dob, mobNo, patientId, costLabel, notes, consultDateTime, docName, noOfHours;
    private JTextField inputName, inputSurName, inputMobNO, inputPatientId, inputNoOfHours, message;
    private JTextArea inputNotes, dataStored;
    private JFormattedTextField inputDob, inputConsultDateTime, inputCost;
    private JButton submit, clear;
    private JComboBox selectDoctor;

    //declaring date time components
    private DateTimePicker consultDateTimePicker;
    private DatePicker dobPicker;

    //initializing the doctor arraylist
    private final ArrayList<Doctor> C_DOC_LIST = WestminsterSkinConsultationManager.getDocList();
    //declaring the consultation arraylist
    private static ArrayList<Consultation> CONSULT_LIST = new ArrayList<Consultation>();
    //set default date time formatter for class
    private final DateTimeFormatter cDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");



    /**
     * create the constructor for AddPatient gui class
     * */
    public AddPatient() {

        //frame
        aPFrame = new JFrame("Consult a Doctor");
        aPFrame.setSize(1280,1000);
        aPFrame.setLayout(null);
        aPFrame.setVisible(true);
        aPFrame.setAutoRequestFocus(false);

        //header panel
        apPanel1 = new JPanel();
        apPanel1.setBounds(0,0,1280,100);
        apPanel1.setBackground(Color.GRAY);
        apPanel1.setLayout(new GridLayout(1,1));
        aPFrame.add(apPanel1);

        //content panel
        apPanel2 = new JPanel();
        apPanel2.setBounds(0, 100, 1280, 800);
        apPanel2.setBackground(Color.WHITE);
        apPanel2.setLayout(null);
        aPFrame.add(apPanel2);

        //header for the form
        title = new JLabel("Input Patient's Details", SwingConstants.CENTER);
        title.setBounds(0, 0, 900, 80);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        apPanel1.add(title);

        //initializing fonts for labels and text fields
        Font fL = new Font("Serif", Font.PLAIN, 25);
        Font fT = new Font("Serif", Font.PLAIN, 20);


        /*--------------------------------------------------------------------*/

        /**
         * creating form using JLabels and JTextFields
         * */
        name = new JLabel("First Name: ");
        name.setBounds(100,50, 200,30);
        name.setFont(fL);
        apPanel2.add(name);


        inputName = new JTextField();
        inputName.setBounds(300,50, 300,30);
        inputName.setFont(fT);
        inputName.setColumns(15);
        apPanel2.add(inputName);


        surName = new JLabel("SurName: ");
        surName.setBounds(100,100, 200,30);
        surName.setFont(fL);
        apPanel2.add(surName);


        inputSurName = new JTextField();
        inputSurName.setBounds(300,100, 300,30);
        inputSurName.setFont(fT);
        inputSurName.setColumns(15);
        apPanel2.add(inputSurName);

        dob = new JLabel("Date of birth: ");
        dob.setBounds(100,150, 200,30);
        dob.setFont(fL);
        apPanel2.add(dob);

        //using date picker to input date of birth
        dobPicker = new DatePicker();
        dobPicker.setBounds(300,150, 300,30);
        dobPicker.setFont(fT);
        apPanel2.add(dobPicker);


        mobNo = new JLabel("Mobile Number: ");
        mobNo.setBounds(100,200, 200,30);
        mobNo.setFont(fL);
        apPanel2.add(mobNo);


        inputMobNO = new JTextField();
        inputMobNO.setBounds(300,200, 300,30);
        inputMobNO.setFont(fT);
        inputMobNO.setColumns(15);
        apPanel2.add(inputMobNO);


        patientId = new JLabel("Patient ID: ");
        patientId.setBounds(100,250, 200,30);
        patientId.setFont(fL);
        apPanel2.add(patientId);


        inputPatientId = new JTextField();
        inputPatientId.setBounds(300,250, 300,30);
        inputPatientId.setFont(fT);
        inputPatientId.setColumns(15);
        apPanel2.add(inputPatientId);


        consultDateTime = new JLabel("Consult DateTime: ");
        consultDateTime.setBounds(100,300, 250,30);
        consultDateTime.setFont(fL);
        apPanel2.add(consultDateTime);


        //using date and time picker to take input of consultation date and time
        consultDateTimePicker = new DateTimePicker();
        consultDateTimePicker.setBounds(300,300, 300,30);
        consultDateTimePicker.setFont(fT);
        apPanel2.add(consultDateTimePicker);


        notes = new JLabel("Notes: ");
        notes.setBounds(100,350, 200,30);
        notes.setFont(fL);
        apPanel2.add(notes);


        inputNotes = new JTextArea();
        inputNotes.setBounds(300,350, 300, 80);
        inputNotes.setBorder(BorderFactory.createLineBorder(Color.black));
        inputNotes.setFont(fT);
        apPanel2.add(inputNotes);


        costLabel = new JLabel("Cost: ");
        costLabel.setBounds(100,450, 200,30);
        costLabel.setFont(fL);
        apPanel2.add(costLabel);

        //formatted text field to input currency
        NumberFormat cF = NumberFormat.getCurrencyInstance(Locale.UK);
        inputCost = new JFormattedTextField(cF);
        inputCost.setValue(25.00);
        inputCost.setBounds(300,450, 300,30);
        inputCost.setFont(fT);
        inputCost.setColumns(15);
        apPanel2.add(inputCost);


        docName = new JLabel("Doctor Surname: ");
        docName.setBounds(100, 500,200,30);
        docName.setFont(fL);
        apPanel2.add(docName);


        //JComboBox to take doctors name from the list
        selectDoctor = new JComboBox(docComboList());
        selectDoctor.setBounds(300,500,300,30);
        selectDoctor.setFont(fL);
        apPanel2.add(selectDoctor);

        noOfHours = new JLabel("No of Hours: ");
        noOfHours.setBounds(100,550, 200,30);
        noOfHours.setFont(fL);
        apPanel2.add(noOfHours);


        inputNoOfHours = new JTextField();
        inputNoOfHours.setBounds(300,550, 300,30);
        inputNoOfHours.setText("1");
        inputNoOfHours.setFont(fT);
        inputNoOfHours.setColumns(15);
        apPanel2.add(inputNoOfHours);


        message = new JTextField();
        message.setBounds(650,100,500,30);
        message.setFont(fL);
        apPanel2.add(message);


        dataStored = new JTextArea();
        dataStored.setBounds(650,200,500,500);
        dataStored.setFont(fT);
        apPanel2.add(dataStored);


        //JButton to submit data input
       submit = new JButton("Submit");
       submit.setBounds(100,600,150,30);
       submit.setFont(fL);
       apPanel2.add(submit);
       submit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                //check if text fields are empty or not
               if (inputName.getText().equals("") || inputSurName.getText().equals("") || inputMobNO.getText().equals("") || inputPatientId.getText().equals("") || inputNotes.getText().equals("") || inputCost.getText().equals("") || consultDateTimePicker.getDateTimeStrict() == null || dobPicker.getDate() == null || inputCost.getText().equals("") || inputNoOfHours.getText().equals("")) {
                   message.setText("Fill out all the columns provided");
                   dataStored.setText("");
               }
               else { //if all text fields are filled take the input from the text fields and datetime picker
                   String nameValue = inputName.getText();
                   String surNameValue = inputSurName.getText();
                   LocalDate dobValue = dobPicker.getDate();
                   String mobNoValue = inputMobNO.getText();
                   String patientIdValue = inputPatientId.getText();
                   LocalDateTime consDateTimeValue = consultDateTimePicker.getDateTimeStrict();
                   String notesValue = inputNotes.getText();
                   String encodedNotesValue = encryption(notesValue);
                   String tempCost = inputCost.getText();
                   double cost = Double.parseDouble(tempCost.replaceAll("[^0-9.]", ""));
                   int comboIndex = selectDoctor.getSelectedIndex();
                   int hoursValue = Integer.parseInt(inputNoOfHours.getText());

                   //taking the doctor object using the index selected in the JCombo box
                   Doctor docObj = C_DOC_LIST.get(comboIndex);


                    //check the availability of the doctor
                   if (!checkAvailability(docObj, consDateTimeValue)) {
                       if (checkPatientFirstTime(patientIdValue)) { //condition apply for the patient had consultations before
                           //create new patient object using the constructor
                           Patient newPatient = new Patient(nameValue, surNameValue, dobValue, mobNoValue, patientIdValue);
                           //create new consultation using the constructor
                           Consultation newConsultation = new Consultation(consDateTimeValue, cost*hoursValue, docObj, newPatient, encodedNotesValue);
                           //add new consultation to the consultation array list
                           CONSULT_LIST.add(newConsultation);
                           message.setText("Consultation Booked");
                           //show data that input by the user
                           dataStored.setText("Patient ID : "+ patientIdValue +
                                   "\nFirst Name : "+ nameValue +
                                   "\nSurname : " + surNameValue +
                                   "\nDate of birth : "+ dobValue +
                                   "\nMobile No : "+mobNoValue+
                                   "\nConsultation times : "+ consDateTimeValue +
                                   "\nCost : \u00A3"+cost*hoursValue+
                                   "\nNotes : " +encodedNotesValue+
                                   "\nDoctor's Name : Dr."+docObj.getSurname());
                       } else { //consultation cost reduction due to first time customers
                           Patient newPatient = new Patient(nameValue, surNameValue, dobValue, mobNoValue, patientIdValue);
                           cost = 15.00;
                           Consultation newConsultation = new Consultation(consDateTimeValue, cost*hoursValue, docObj, newPatient, encodedNotesValue);
                           CONSULT_LIST.add(newConsultation);
                           message.setText("Consultation Booked");
                           dataStored.setText("Patient ID : "+ patientIdValue +
                                   "\nFirst Name : "+ nameValue +
                                   "\nSurname : " + surNameValue +
                                   "\nDate of birth : "+ dobValue +
                                   "\nMobile No : "+mobNoValue+
                                   "\nConsultation times : "+ consDateTimeValue +
                                   "\nFirst time patient discount Added. Cost :  \u00A3"+cost*hoursValue+
                                   "\nNotes : " +encodedNotesValue+
                                   "\nDoctor's Name : Dr."+docObj.getSurname()+
                                   "\n\n");

                       }
                   } else { //random doctor allocation if chose doctor is busy at that time
                       Doctor tempDoc = randomDoctor(docObj, consDateTimeValue);
                       if (checkPatientFirstTime(patientIdValue)) {
                           Patient newPatient = new Patient(nameValue, surNameValue, dobValue, mobNoValue, patientIdValue);
                           Consultation newConsultation = new Consultation(consDateTimeValue, cost*hoursValue, tempDoc, newPatient, encodedNotesValue);
                           CONSULT_LIST.add(newConsultation);
                           message.setText("Consultation Booked");
                           dataStored.setText("Patient ID : "+ patientIdValue +
                                   "\nFirst Name : "+ nameValue +
                                   "\nSurname : " + surNameValue +
                                   "\nDate of birth : "+ dobValue +
                                   "\nMobile No : "+mobNoValue+
                                   "\nConsultation times : "+ consDateTimeValue +
                                   "\nCost :  \u00A3"+cost*hoursValue+
                                   "\nNotes : " +encodedNotesValue+
                                   "\nDr."+docObj.getSurname()+" is busy at this time we allocated you Dr. "+ tempDoc.getSurname());
                       } else {
                           Patient newPatient = new Patient(nameValue, surNameValue, dobValue, mobNoValue, patientIdValue);
                           cost = 15.00;
                           Consultation newConsultation = new Consultation(consDateTimeValue, cost*hoursValue, tempDoc, newPatient, encodedNotesValue);
                           CONSULT_LIST.add(newConsultation);
                           message.setText("Consultation Booked");
                           dataStored.setText("Patient ID : "+ patientIdValue +
                                   "\nFirst Name : "+ nameValue +
                                   "\nSurname : " + surNameValue +
                                   "\nDate of birth : "+ dobValue +
                                   "\nMobile No : "+mobNoValue+
                                   "\nConsultation times : "+ consDateTimeValue +
                                   "\nFirst time patient discount Added. Cost: \u00A3"+cost*hoursValue+
                                   "\nNotes : " +encodedNotesValue+
                                   "\nDr."+docObj.getSurname()+" is busy at this time we allocated you Dr. "+ tempDoc.getSurname()+
                                   "\n\n");
                       }
                   }

               }
           }
       });

       //button to remove a consultation from the list
       clear = new JButton("Remove");
       clear.setBounds(400,600,150,30);
       clear.setFont(fL);
       apPanel2.add(clear);
       clear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String patientIdValue = inputPatientId.getText();
               LocalDateTime consDateTimeValue = consultDateTimePicker.getDateTimeStrict();
               int comboIndex = selectDoctor.getSelectedIndex();

               Doctor obj = C_DOC_LIST.get(comboIndex);

               if(removeConsultation(patientIdValue.toUpperCase(),consDateTimeValue,obj)!=-1){
                   message.setText("Consultation removed from the system.");
               }
               else{
                   message.setText("Consultation unavailable in the system");
                   dataStored.setText("");
               }

           }
       });


    }


    //method to contain surname of the doctor to the JComboBox
    public String[] docComboList() {
        String[] docConsul = new String [10];
        for (int i = 0; i < C_DOC_LIST.size(); i++) {
            docConsul[i] = C_DOC_LIST.get(i).getSurname();
        }
        return(docConsul);
    }


    //method to get doctor object by surname
    public Doctor getDocByName(String docSurName){
        String dSN = docSurName.toUpperCase();
        Doctor doc = null;
        for (Doctor doctor : C_DOC_LIST) {
            if (dSN.equals(doctor.getSurname().toUpperCase())){
                doc = doctor;
            }
            }
            return doc;
    }

    //doctor availability check method
    public boolean checkAvailability(Doctor doctor, LocalDateTime consultTime){
        //String dSN = docSurName.toUpperCase();
        boolean index = false;

        for (Consultation consul : CONSULT_LIST) {
            //String doc = consul.getConsultDoc().getSurname().toUpperCase();
            LocalDateTime time = consul.getConsultTime();
            if (consul.getConsultDoc().getMedicalLicenseNo().equalsIgnoreCase(doctor.getMedicalLicenseNo()) && time.compareTo(consultTime) == 0){
                index = true;
                break;
            }
        }
        return (index);
        }


        //patient first time check method
      public boolean checkPatientFirstTime(String patientID){
        boolean index = false;
        String pId = patientID.toUpperCase();

        for (Consultation consul : CONSULT_LIST){
            if(pId.equals(consul.getPatient().getPatientId().toUpperCase())){
                index = true;
                break;
            }
        }
        return index;
    }


    //random doctor allocation method
    public Doctor randomDoctor(Doctor dObj, LocalDateTime consultDateTime){
        ArrayList<Doctor> TEMP_C_DOC_LIST = new ArrayList<Doctor>();
        TEMP_C_DOC_LIST.addAll(C_DOC_LIST);

        TEMP_C_DOC_LIST.removeIf(doc -> dObj.getMedicalLicenseNo().equalsIgnoreCase(doc.getMedicalLicenseNo()));

        for(Consultation consult : CONSULT_LIST){
            if(consultDateTime.compareTo(consult.getConsultTime()) == 0){
                TEMP_C_DOC_LIST.removeIf(doc -> consult.getConsultDoc().getMedicalLicenseNo().equalsIgnoreCase(doc.getMedicalLicenseNo()));
            }
        }

        int rand = (int) (Math.random()*TEMP_C_DOC_LIST.size()+0);

        return (TEMP_C_DOC_LIST.get(rand));
    }



    //remove consultation method
    public int removeConsultation(String pID, LocalDateTime consultDateTime, Doctor lNo){
        int index=-1;
        int count=0;
        for (Consultation consult : CONSULT_LIST){
            if(pID.equalsIgnoreCase(consult.getPatient().getPatientId()) && consultDateTime.compareTo(consult.getConsultTime())==0 && lNo.getMedicalLicenseNo().equalsIgnoreCase(consult.getConsultDoc().getMedicalLicenseNo()))
            {
                CONSULT_LIST.remove(consult);
                dataStored.setText("Patient ID : "+ consult.getPatient().getPatientId() +
                        "\nFirst Name : "+ consult.getPatient().getName() +
                        "\nSurname : " + consult.getPatient().getSurname() +
                        "\nDate of birth : "+ consult.getPatient().getDob() +
                        "\nMobile No : "+consult.getPatient().getMobNo()+
                        "\nConsultation times : "+ consult.getConsultTime() +
                        "\nCost: \u00A3"+consult.getCost()+
                        "\nNotes : " +consult.getNotes()+
                        "\nDr."+consult.getConsultDoc().getSurname()+
                        "\n\n");
                index = count;
                break;
            }
            count++;
        }
        return index;
    }


    /*
     *encryption method to encrypt personal patient details
     * reference : https://stackoverflow.com/questions/13109588/encoding-as-base64-in-java
     */
    public String encryption(String encryptText){
        byte[] encodedBytes = Base64.getEncoder().encode(encryptText.getBytes());
        return new String(encodedBytes);
    }


    //getter for consultation array list
    public static ArrayList<Consultation> getConsultList() {
        return CONSULT_LIST;
    }
}