/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips;

import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
public class MipsTxtWindow extends JFrame {
    
    JPanel MainPanel ;
    JMenuBar mnuBar ;
    JMenu Run ;
    JMenuItem Item ;
    JTextArea MipsArea ;

    public MipsTxtWindow()  {
        this.setBounds(100, 100, 1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();
        
       MipsArea = new JTextArea();
       c.add(MipsArea);
       String[] lines =MipsArea.getText().split("\\n");
       
       System.out.println(lines[0]);
        
        this.setVisible(true);
    }
    
    
    
    
}
