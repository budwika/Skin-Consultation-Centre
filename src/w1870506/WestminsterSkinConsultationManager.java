package w1870506;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;


public class WestminsterSkinConsultationManager implements SkinConsultationManager { //implementing skin consultation interface
    //arraylist contains the details of doctors
    private static ArrayList<Doctor> DOC_LIST = new ArrayList<>();
    //maximum number of doctors can include in the system
    final int maxDocs = 10;


     //integer input validation method
    public int intInput(String text){
        String input;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(text);
            input = sc.next();
            try {
                Integer.parseInt(input);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error - Enter an Integer Value");
            }
        }
        return Integer.parseInt(input);
    }


    //string input validation method
    public String strInput(String text){
        String input;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(text);
            input = sc.nextLine();
            if (input.isEmpty()){
                System.out.println("This input can't be empty.");
            }
            else{
                break;
            }
        }
        return input;
    }


    //local date validation method
    public LocalDate localDateInput(String text){
        String input;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(text);
            System.out.println("Enter dates in this format 'yyyy-mm-dd'");
            input = sc.nextLine();
            try{
                LocalDate.parse(input);
                break;
            }
            catch (DateTimeException e){
                System.out.println("Enter the date in correct format.");
            }
        }
        return LocalDate.parse(input);
    }


    /**
     * method to add doctors into the system
     * */
    @Override
    public void addDoctor() {
        System.out.println("\n Add a Doctor");
        if (DOC_LIST.size() < maxDocs){
            System.out.println("Enter Doctor's Detail");
            String docName = strInput("Enter Doctor's Name");
            String docSurname = strInput("Enter Doctor's Surname");
            LocalDate dob = localDateInput("Enter Doctor's Date of birth");
            String docMobNo = strInput("Enter Doctor's Mobile No");
            String docLic = strInput("Enter Doctor's License No");
            String docSpec = strInput("Enter Doctor's Specialization");

            Doctor newDoctor = new Doctor(docName, docSurname, dob, docMobNo, docLic, docSpec);
            DOC_LIST.add(newDoctor);
            System.out.println("Doctor added to the system successfully.");
        }
        else{
            System.out.println("Maximum No of Doctors already Exceeded.");
        }
    }

    /**
     * method to remove a doctor from the system
     * */
    @Override
    public void deleteDoctor(){
        int index=-1;
        System.out.println("\nDelete Doctor");

        String docLicNo = strInput("\n Enter Doctor's License No to Delete").toUpperCase();
        for(Doctor doc : DOC_LIST){
            if (doc.getMedicalLicenseNo().toUpperCase().equals(docLicNo)){
                DOC_LIST.remove(doc);
                System.out.println("Doctor "+doc.getSurname()+" with medical License No"+ doc.getMedicalLicenseNo() +"is removed from the Doctor's list.");
                System.out.println("Remaining number of Doctors in the system is "+DOC_LIST.size());
                index = 1;
                break;
            }
        }
        if (index == -1){
            System.out.println("Doctor with this License Number doesn't Exist.");
        }
    }

    /**
     * method to print the doctors list in the system
     * */
    @Override
    public void printDocList(){
        System.out.println("Doctor Details Table");
        ArrayList<Doctor> TEMP_DOC_LIST = new ArrayList<>(DOC_LIST);

        TEMP_DOC_LIST.sort(Comparator.comparing(Doctor::getSurname, String.CASE_INSENSITIVE_ORDER));

        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Doctor's Name", "Surname", "Date of Birth", "Mobile Number", "License Number",
                "Specialization");
        System.out.println("");

        for(Doctor doc : TEMP_DOC_LIST){
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", doc.getName(), doc.getSurname(), doc.getDob(), doc.getMobNo(),
                    doc.getMedicalLicenseNo(), doc.getSpecialisation());
            System.out.println("");
        }
    }

    /**
     * method to save doctors arraylist to a text file
     *  */
    @Override
    public void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/w1870506/DoctorInfo.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(DOC_LIST);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * method to load saved data from saved text file
     * */
    @Override
    public void  loadFile () {
        try{
            FileInputStream fileInputStream = new FileInputStream("src/w1870506/DoctorInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ArrayList<Doctor> loadDoc = (ArrayList<Doctor>) objectInputStream.readObject();
                objectInputStream.close();
                DOC_LIST = loadDoc;
                }

        catch (Exception e){
            System.out.println();
        }
    }


    //getter for doctors array list
    public static ArrayList<Doctor> getDocList() {
        return DOC_LIST;
    }
}
