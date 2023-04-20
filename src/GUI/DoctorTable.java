package GUI;

import w1870506.Doctor;
import w1870506.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class DoctorTable {
    //declaring swing components
    private JFrame dtFrame;
    private JPanel dtPanel;
    private JTable dtTable;
    private DefaultTableModel model;

    //assign doctor arraylist from WestminsterSkinConsultationManager to new arraylist
    ArrayList<Doctor> DOC_TABLE = WestminsterSkinConsultationManager.getDocList();

    /**
     * Constructor for doctor table
     * */
    public DoctorTable(){

        //frame
        dtFrame = new JFrame("Doctor's Table");
        dtFrame.setSize(500,500);
        dtPanel = new JPanel();

        //construct the table model with columns
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Mobile Number");
        model.addColumn("License No");
        model.addColumn("Specialization");

        //creating the table
        dtTable = new JTable(model);
        dtTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(dtTable);
        scrollPane.setSize(500,500);
        dtTable.setFillsViewportHeight(true);

        //add row data to table
        DefaultTableModel model = (DefaultTableModel) dtTable.getModel();
        Object[] rowData = new Object[5];
        for (Doctor doctor : DOC_TABLE) {
            rowData[0] = doctor.getName();
            rowData[1] = doctor.getSurname();
            rowData[2] = doctor.getMobNo();
            rowData[3] = doctor.getMedicalLicenseNo();
            rowData[4] = doctor.getSpecialisation();
            model.addRow(rowData);
        }

        //panel customizing
        dtPanel.setLayout(new BorderLayout());
        dtPanel.add(scrollPane);

        //frame customizing
        dtFrame.add(dtPanel);
        dtFrame.pack();
        dtFrame.setVisible(true);


    }
}
