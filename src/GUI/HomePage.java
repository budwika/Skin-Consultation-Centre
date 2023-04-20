package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {

    //declaring swing elements variables
    JFrame hFrame;
    JPanel h1Panel;
    JPanel h2Panel;
    JLabel hLabel;
    JButton doctorTableButt;
    JButton consultDoctorButt;
    JButton editConsultButt;

    /**
     * constructor for homepage of the gui
     * */
    public HomePage() {
        //frame
        hFrame = new JFrame("Skin Consultation Centre");
        hFrame.setSize(900, 500);
        hFrame.setLayout(null);

        //header panel
        h1Panel = new JPanel();
        h1Panel.setBounds(0,0,900,100);
        h1Panel.setBackground(Color.GRAY);
        h1Panel.setLayout(new GridLayout(1,1));
        hFrame.add(h1Panel);

        //content panel
        h2Panel = new JPanel();
        h2Panel.setBounds(0, 100, 900, 400);
        h2Panel.setBackground(Color.WHITE);
        h2Panel.setLayout(null);
        hFrame.add(h2Panel);

        //header label
        hLabel = new JLabel("Skin Consultation Centre", SwingConstants.CENTER);
        hLabel.setSize(900,80);
        hLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        h1Panel.add(hLabel);

        //doctor table button
        doctorTableButt = new JButton("Doctor Table");
        doctorTableButt.setBounds(100,100, 200,150);
        doctorTableButt.setFont(new Font("Serif", Font.PLAIN, 20));
        doctorTableButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorTable();}
        });
        h2Panel.add(doctorTableButt);


        //consultation booking button
        consultDoctorButt = new JButton("Consult a Doctor");
        consultDoctorButt.setBounds(350,100, 200,150);
        consultDoctorButt.setFont(new Font("Serif", Font.PLAIN, 20));
        consultDoctorButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatient();}
        });
        h2Panel.add(consultDoctorButt);


        //consultation table button
        editConsultButt = new JButton("Show Consultations");
        editConsultButt.setBounds(600, 100, 200, 150);
        editConsultButt.setFont(new Font("Serif", Font.PLAIN, 20));
        editConsultButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultationTable();}
        });
        h2Panel.add(editConsultButt);


        //customizing the frame
        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hFrame.setAutoRequestFocus(false);
        hFrame.setVisible(true);
    }
}
