package GUI;

import GUI.AddPatient;
import w1870506.Consultation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Base64;

public class ConsultationTable {

    // declaring swing components
    private JFrame cTFrame;
    private JPanel cTPanel;
    private JTable cTTable;
    private DefaultTableModel cTModel;

    //assign the returned arraylist of consultation to new arraylist
    private static ArrayList<Consultation> CONSULT_TABLE = AddPatient.getConsultList();

    /**
     * constructor for consultation table
     * */
    public ConsultationTable() {

        //frame
        cTFrame = new JFrame("Consultation Table");
        cTFrame.setSize(500, 500);
        cTPanel = new JPanel();

        //table model for the table
        cTModel = new DefaultTableModel();
        cTModel.addColumn("Patient ID");
        cTModel.addColumn("Patient's First Name");
        cTModel.addColumn("Patient's Surname");
        cTModel.addColumn("Consultation Time");
        cTModel.addColumn("Doctor's Name");
        cTModel.addColumn("Doctor's License No");
        cTModel.addColumn("Cost");
        cTModel.addColumn("Notes");
        cTTable = new JTable(cTModel);
        cTTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(cTTable);
        scrollPane.setSize(500, 500);
        cTTable.setFillsViewportHeight(true);

        //creating and inserting data to the table
        DefaultTableModel model = (DefaultTableModel) cTTable.getModel();
        Object[] rowData = new Object[8];
        for (Consultation consul : CONSULT_TABLE) {
            rowData[0] = consul.getPatient().getPatientId();
            rowData[1] = consul.getPatient().getName();
            rowData[2] = consul.getPatient().getSurname();
            rowData[3] = consul.getConsultTime();
            rowData[4] = consul.getConsultDoc().getSurname();
            rowData[5] = consul.getConsultDoc().getMedicalLicenseNo();
            rowData[6] = consul.getCost();
            rowData[7] = decryption(consul.getNotes());
            model.addRow(rowData);
        }


        //customizing panel and frame
        cTPanel.setLayout(new BorderLayout());
        cTPanel.add(scrollPane);

        cTFrame.add(cTPanel);
        cTFrame.pack();
        cTFrame.setVisible(true);
    }

    //decryption method decrypt encryption data
    // Reference : https://stackoverflow.com/questions/13109588/encoding-as-base64-in-java
    public String decryption(String encryptedString){
        byte[] encodedBytes = encryptedString.getBytes();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        return new String(decodedBytes);
    }
}


