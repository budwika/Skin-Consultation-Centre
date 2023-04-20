package w1870506;

import GUI.HomePage;


public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager wSkinCManager = new WestminsterSkinConsultationManager();//creating object to use methods in the class
        wSkinCManager.loadFile();//loading the saved data when program runs


        menu://menu for the option selection
        while (true){
            System.out.println("Skin Consultation Centre");
            System.out.println("");
            System.out.println("Enter 1 - Add Doctor");
            System.out.println("Enter 2 - Delete a Doctor");
            System.out.println("Enter 3 - Print Doctor List");
            System.out.println("Enter 4 - Save to File");
            System.out.println("Enter 5 - Open the GUI");
            System.out.println("Enter 6 - Exit the Program");


            switch (wSkinCManager.intInput("Enter the option :")){ //taking the menu option from the user
                case 1:
                    wSkinCManager.addDoctor(); // add doctor to system
                    break;
                case 2:
                    wSkinCManager.deleteDoctor(); //delete doctor from the system
                    break;
                case 3:
                    wSkinCManager.printDocList(); //print list of doctors in the console
                    break;
                case 4:
                    wSkinCManager.saveToFile(); //save doctor's data in to a text file
                    System.out.println("Saved data to text file.");
                    break;
                case 5:
                    new HomePage(); //open GUI
                    break;
                case 6:
                    System.out.println("Program Exit"); //exit the program
                    break menu;
                default:
                    System.out.println("Input correct option"); //showing default message in a wrong option

            }

        }
    }
}
