package mips;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

class InstractionPanel extends JPanel {

    private JComboBox oprationCb;
    private JComboBox rsCb;
    private JComboBox rtCb;
    private JComboBox rdCb;
    private JTextField rsTf;
    private JLabel note ;

    public InstractionPanel() {
        this.setLayout(null);
        oprationCb = new JComboBox(Constants.oprations);
        oprationCb.setBounds(20, 20, 100, 30);
        add(oprationCb);
        
        rsCb = new JComboBox (Constants.reg);
        rsCb.setBounds(150, 20, 100, 30);
        rtCb = new JComboBox (Constants.reg);
        rtCb.setBounds(300, 20, 100, 30);
        rdCb= new JComboBox (Constants.reg);
        rdCb.setBounds(450, 20, 100, 30);
        rsTf = new JTextField();
        rsTf.setBounds(600, 20, 100, 30);
        
        oprationCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) oprationCb.getSelectedItem();
                String check = "";
                for (int i = 0; i < Constants.IFormat.length; i++) {
                    if (s.equals(Constants.IFormat[i])) {
                        check = "Ifoemat";
                    }
                }
                for (int i = 0; i < Constants.RFormat.length; i++) {
                    if (s.equals(Constants.RFormat[i])) {
                        check = "RFormate";
                    }
                }
                for (int i = 0; i < Constants.JFormat.length; i++) {
                    if (s.equals(Constants.JFormat[i])) {
                        check = "Ifoemat";
                    }
                }

                switch (check) {
                    case "Ifoemat":
                        if (s.equals("lw") || s.endsWith("sw")){
                        removeAll();
                        add(oprationCb);
                        add(rsCb);
                        add(rtCb);
                        add(rdCb);
                        add(rsTf);
                        }else {
                        removeAll();
                        add(oprationCb);
                        add(rsCb);
                        add(rtCb);
                        add(rsTf);
                        }
                            
                        break;
                    case "RFormate":
                        removeAll();
                        add(oprationCb);
                        add(rsCb);
                        add(rtCb);
                        add(rdCb);
                        break;
                    case "JFormate":
                        removeAll();
                        add(oprationCb);
                        add(rsTf);
                        break;

                }
            }
        });
    }

}

public class TheFrame extends JFrame {

    private JTextField rsTf;
    private JPanel panel;
    private InstractionPanel ip ;
    private JButton addbtn;
    private final String[] reg = {"$s0", "$s1"};
    private int stat = 0;

    public TheFrame() {
        this.setTitle("Mips");
        this.setBounds(300, 50, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        inti();
        this.setVisible(true);
    }

    public void inti() {
        Container c = this.getContentPane();
        ip = new InstractionPanel();
        ip.setBounds(20,20, 700, 50);
        c.add(ip);
    }

}
