package mips;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

class InstructionPanel extends JPanel {

    private JComboBox oprationCb;
    private JComboBox rsCb;
    private JComboBox rtCb;
    private JComboBox rdCb;
    private JTextField rsTf;
    private JLabel note ;
  
//    public static int x = 20;
    public static int y = 0;

    public InstructionPanel() {
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
                        check = "IFormate";
                    }
                }
                for (int i = 0; i < Constants.RFormat.length; i++) {
                    if (s.equals(Constants.RFormat[i])) {
                        check = "RFormate";
                    }
                }
                for (int i = 0; i < Constants.JFormat.length; i++) {
                    if (s.equals(Constants.JFormat[i])) {
                        check = "JFormate";
                    }
                }

                switch (check) {
                    case "IFormate":
                        if (s.equals("lw") || s.endsWith("sw")){
                        removeAll();
                        add(oprationCb);
                        add(rsCb);
                        add(rtCb);
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

public class MainWindow extends JFrame {

    private JTextField rsTf;
    private JPanel pnl;
    private InstructionPanel ip ;
    private JButton addbtn;
    private JButton runbtn;
    private JScrollPane sp;
    private final String[] reg = {"$s0", "$s1"};
    private int stat = 0;

    public MainWindow() {
        this.setTitle("Mips");
        this.setBounds(300, 50, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        inti();
        this.setVisible(true);
        
    }

    public void inti() {
        
        Container c = this.getContentPane();
        
//        pnl = new JPanel();
//        pnl.setBounds(10, 50, 765, 500);
//        pnl.setLayout(null);
        
        sp = new JScrollPane();
        sp.setBounds(10, 50, 765, 500);
        sp.setLayout(null);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        sp.add(pnl);
        c.add(sp);
        
        addbtn = new JButton("Add operation");
        addbtn.setBounds (40, 10, 200, 30);
        c.add(addbtn);
        
        addbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                InstructionPanel.y += 50;
                ip = new InstructionPanel();
                ip.setBounds(20, InstructionPanel.y, 700, 50);
                sp.add(ip);
                ip.setVisible(true);
            }
        });
        
        Timer t = new Timer(30,new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
            c.repaint();
            sp.repaint();
            
            }});
                
          t.start();      
                
        runbtn = new JButton("Run");
        runbtn.setBounds (400, 10, 200, 30);
        c.add(runbtn);
        
        runbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               
            }
        });
        
//        ip = new InstructionPanel();
//        ip.setBounds(20, 40, 700, 50);
//        c.add(ip);
        
    }
    
//    public void newCodeLine(){
//        
//        InstructionPanel.y += 60;
//        ip = new InstructionPanel();
//        ip.setBounds(20, InstructionPanel.y, 700, 50);
//        c.add(ip);
//    }
}
