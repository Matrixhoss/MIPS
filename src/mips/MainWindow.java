package mips;

import java.util.LinkedList;

public class MainWindow extends javax.swing.JFrame {

    public String Ins;
    public LinkedList<String> ss = new LinkedList<String>();

    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(740, 500));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "add", "addi", "sub", "lw", "sw", "sll", "and", "or", "nor", "beq", "bne", "j", "jal", "jr", "slt", "slti", "sltu", "sltui" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$gp", "$sp", "$fp", "$ra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$0", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$0", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList4);

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jButton1.setText("Run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Instruction");

        jLabel2.setText("Register rd");

        jLabel3.setText("Register rs");

        jLabel4.setText("Register rt");

        jButton2.setText("Add instruction");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setText("Initial address");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7" }));

        jLabel5.setText("Registers Initial value");

        jTextField3.setText("Value");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setText("Final instruction");

        jTextField5.setEditable(false);
        jTextField5.setText("Final Result");

        jButton3.setText("Add value");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jLabel6.setText("Label");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setText("JumpLabel");

        jLabel8.setText("IFormatConstant");

        jMenu1.setText("File");

        jMenuItem3.setText("Print all registers values");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Clear $s registers values");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField4)
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(47, 47, 47)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(jTextField7))
                                    .addComponent(jLabel8))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jScrollPane4)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int reg = jComboBox1.getSelectedIndex();
        switch (reg) {
            case 0:
                Registers.$s0 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s0: " + Registers.$s0);
                jTextArea1.append("$s0 were set to " + Registers.$s0 + "\n");
                break;
            case 1:
                Registers.$s1 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s1: " + Registers.$s1);
                jTextArea1.append("$s1 were set to " + Registers.$s1 + "\n");
                break;
            case 2:
                Registers.$s2 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s2: " + Registers.$s2);
                jTextArea1.append("$s2 were set to " + Registers.$s2 + "\n");
                break;
            case 3:
                Registers.$s3 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s3: " + Registers.$s3);
                jTextArea1.append("$s3 were set to " + Registers.$s3 + "\n");
                break;
            case 4:
                Registers.$s4 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s4: " + Registers.$s4);
                jTextArea1.append("$s4 were set to " + Registers.$s4 + "\n");
                break;
            case 5:
                Registers.$s5 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s5: " + Registers.$s5);
                jTextArea1.append("$s5 were set to " + Registers.$s5 + "\n");
                break;
            case 6:
                Registers.$s6 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s6: " + Registers.$s6);
                jTextArea1.append("$s6 were set to " + Registers.$s6 + "\n");
                break;
            case 7:
                Registers.$s7 = Integer.parseInt(jTextField3.getText());
                System.out.println("$s7: " + Registers.$s7);
                jTextArea1.append("$s7 were set to " + Registers.$s7 + "\n");
                break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Registers.$s0 = 0;
        Registers.$s1 = 0;
        Registers.$s2 = 0;
        Registers.$s3 = 0;
        Registers.$s4 = 0;
        Registers.$s5 = 0;
        Registers.$s6 = 0;
        Registers.$s7 = 0;
        jTextArea1.append("All $s registers were reset to 0\n");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (jTextField3.getText().equals("Value")) {
            jTextField3.setText("");
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if (jTextField1.getText().equals("Constant")) {
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if (jTextField2.getText().equals("Initial address")) {
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jTextArea1.append("$0: " + Registers.$0 + "\n");
        jTextArea1.append("$at: " + Registers.$at + "\n");
        jTextArea1.append("$v0: " + Registers.$v0 + "\n");
        jTextArea1.append("$v1: " + Registers.$v1 + "\n");
        jTextArea1.append("$a0: " + Registers.$a0 + "\n");
        jTextArea1.append("$a1: " + Registers.$a1 + "\n");
        jTextArea1.append("$a2: " + Registers.$a2 + "\n");
        jTextArea1.append("$a3: " + Registers.$a3 + "\n");

        jTextArea1.append("$t0: " + Registers.$t0 + "\n");
        jTextArea1.append("$t1: " + Registers.$t1 + "\n");
        jTextArea1.append("$t2: " + Registers.$t2 + "\n");
        jTextArea1.append("$t3: " + Registers.$t3 + "\n");
        jTextArea1.append("$t4: " + Registers.$t4 + "\n");
        jTextArea1.append("$t5: " + Registers.$t5 + "\n");
        jTextArea1.append("$t6: " + Registers.$t6 + "\n");
        jTextArea1.append("$t7: " + Registers.$t7 + "\n");

        jTextArea1.append("$s0: " + Registers.$s0 + "\n");
        jTextArea1.append("$s1: " + Registers.$s1 + "\n");
        jTextArea1.append("$s2: " + Registers.$s2 + "\n");
        jTextArea1.append("$s3: " + Registers.$s3 + "\n");
        jTextArea1.append("$s4: " + Registers.$s4 + "\n");
        jTextArea1.append("$s5: " + Registers.$s5 + "\n");
        jTextArea1.append("$s6: " + Registers.$s6 + "\n");
        jTextArea1.append("$s7: " + Registers.$s7 + "\n");

        jTextArea1.append("t8: " + Registers.$t8 + "\n");
        jTextArea1.append("t9: " + Registers.$t9 + "\n");
        jTextArea1.append("$k0: " + Registers.$k0 + "\n");
        jTextArea1.append("$k1: " + Registers.$k1 + "\n");
        jTextArea1.append("$gp: " + Registers.$gp + "\n");
        jTextArea1.append("$sp: " + Registers.$sp + "\n");
        jTextArea1.append("$fp: " + Registers.$fp + "\n");
        jTextArea1.append("$ra: " + Registers.$ra + "\n");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String operation = jList1.getSelectedValue();
        String rd = jList2.getSelectedValue();;
        String rs = jList3.getSelectedValue();;
        String rt = jList4.getSelectedValue();;
        String constant = jTextField1.getText();
        String label = jTextField6.getText();
        String jumplabel = jTextField7.getText();

        for (int i = 0; i < Constants.RFormat.length; i++) {
            if (jList1.getSelectedValue().equals(Constants.RFormat[i])) {
                if (jTextField6.getText().isEmpty()) {
                    Ins = (operation + " " + rd + "," + rs + "," + rt + "");
                } else {
                    Ins = (label + ":" + operation + " " + rd + "," + rs + "," + rt + "");
                    
                }
            }
        }
        for (int i = 0; i < Constants.JFormat.length; i++) {
            if (jList1.getSelectedValue().equals(Constants.JFormat[i])) {
                if (jTextField6.getText().isEmpty()) {
                    Ins = (operation + " " + jumplabel + "");
                } else {
                    Ins = (label + ":" + operation + " " + jumplabel + "");
                 
                }
            }
        }

        for (int i = 0; i < Constants.IFormat.length; i++) {
            if (jList1.getSelectedValue().equals(Constants.IFormat[i])) {
                if (jList1.getSelectedValue().equals("lw") || jList1.getSelectedValue().equals("sw")) {
                    if (jTextField6.getText().isEmpty()) {
                        Ins = (operation + " " + rd + "," + constant + "(" + rs + ")");
                    } else {
                        Ins = (label+":"+operation + " " + rd + "," + constant + "(" + rs + ")");
                    }
                }
                else if(jList1.getSelectedValue().equals("beq") || jList1.getSelectedValue().equals("bnq")){
            }  if (jTextField6.getText().isEmpty()) {
                Ins = (operation + " " + rd + "," + rs + "," + jumplabel+ "");
            } else {
                Ins = (label +":"+operation + " " + rd + "," + rs + "," + jumplabel+ "");
            }}

        }
        jTextField1.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField4.setText(Ins);
        System.out.println(Ins);
        ss.add(Ins);
        //System.out.println(Ins);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
