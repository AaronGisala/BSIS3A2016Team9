package System;

import ConnectionTest.SQLConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.text.MessageFormat;
import java.util.logging.Logger;
import javax.swing.*;

public class Manage extends javax.swing.JFrame {

    Connection con;
   Statement stmt=null;
   PreparedStatement pr=null;
   ResultSet rs=null;
   SQLConnection cc;
    public Manage() {
        initComponents();
        cc=new SQLConnection();
        getFillTable();
    }
    
    public void getClearAll()
    {
        try {
                txtserial.setText("");
                txtassetno.setText("");
                txtsapno.setText("");
                txtdesc.setText("");
                txtdate.setText("");
                txtvalue.setText("");
                txtbrand.setText("");
                txtmodel.setText("");
                txtlocation.setText("");
                txtteam.setText("");
                txtassign.setText("");
                txtstatus.setText("");
                txtwarranty.setText("");
                txtsearch.setText("");
                
        } catch (Exception e) {
        }
    } 
    public void getFillTable()
    {
      //  String sql="SELECT serial_no,asset_type,asset_no,sap_no,description,aqc_date,aqc_value,brand,model,location,team,assignee,status,warranty from it_assets";
         String sql="SELECT * from it_assets";
        try {
            con=(Connection) cc.getConnection();
            pr=(PreparedStatement) con.prepareStatement(sql);
            rs=pr.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public void getSaved()
    {
        String sql="INSERT INTO it_assets(serial_no,asset_type,asset_no,sap_no,description,aqc_date,aqc_value,brand,model,location,team,assignee,status,warranty) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
                con=(Connection) cc.getConnection();
                pr=(PreparedStatement) con.prepareStatement(sql);
                String serial_no=txtserial.getText();
                String asset_type=combotype.getSelectedItem().toString();
                String asset_no=txtassetno.getText();
                String sap_no=txtsapno.getText();
                String description=txtdesc.getText();
                String aqc_date=txtdate.getText();
                String aqc_value=txtvalue.getText();
                String brand=txtbrand.getText();
                String model=txtmodel.getText();
                String location=txtlocation.getText();
                String team=txtteam.getText();
                String assignee=txtassign.getText();
                String status=txtstatus.getText();
                String warranty=txtwarranty.getText();
                
                pr.setString(1, serial_no);
                pr.setString(2, asset_type);
                pr.setString(3, asset_no);
                pr.setString(4, sap_no);
                pr.setString(5, description);
                pr.setString(6, aqc_date);
                pr.setString(7, aqc_value);
                pr.setString(8, brand);
                pr.setString(9, model);
                pr.setString(10, location);
                pr.setString(11, team);
                pr.setString(12, assignee);
                pr.setString(13, status);
                pr.setString(14, warranty);
                
                
                int result=pr.executeUpdate();
                JOptionPane.showMessageDialog(null,"Records Sourcefully Saved","Saved Message!",JOptionPane.INFORMATION_MESSAGE);               
                getClearAll();
            } catch (Exception e) 
            {
                
            }
    }
 public void getSearch() {
     try{
         con=(Connection) cc.getConnection();
        Statement stmt = (Statement) con.createStatement();
        String query = "SELECT  * FROM it_assets WHERE serial_no LIKE  '%" + txtsearch.getText() + "%' OR assignee LIKE  '%" + txtsearch.getText() + "%'";
      rs = pr.executeQuery(query);
      jTable1.setModel(DbUtils.resultSetToTableModel(rs)); 

    con.close();
   

}
     catch (Exception e) { 
        JOptionPane.showMessageDialog(null,"Got an exception!");
        System.err.println(e.getMessage()); 
    } 
     
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtserial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtassetno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combotype = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsapno = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtvalue = new javax.swing.JTextField();
        txtbrand = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtlocation = new javax.swing.JTextField();
        txtteam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        txtwarranty = new javax.swing.JTextField();
        txtassign = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BPO Inventory");

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Serial no.", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtserial.setToolTipText("Input Serial no. of the Item (ie. PBTYK9)");
        txtserial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtserialActionPerformed(evt);
            }
        });

        jLabel1.setText("Serial no:");

        txtassetno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassetnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Asset Type:");

        combotype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tangible Assets", "Intangible Assets", "Current Assets", "Fixed Assets" }));

        jLabel3.setText("Asset no:");

        jLabel4.setText("Sap no:");

        jLabel5.setText("Description:");

        jLabel6.setText("Date Acquired:");

        txtsapno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsapnoActionPerformed(evt);
            }
        });

        txtdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescActionPerformed(evt);
            }
        });

        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });

        jLabel7.setText("Acquired Value:");

        jLabel8.setText("Brand:");

        jLabel9.setText("Model:");

        jLabel10.setText("Location:");

        jLabel11.setText("Cost Center:");

        jLabel12.setText("Asignee:");

        txtteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteamActionPerformed(evt);
            }
        });

        jLabel13.setText("Asset Status:");

        jLabel14.setText("Asset Warranty:");

        txtsearch.setForeground(new java.awt.Color(153, 153, 153));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });

        jButton3.setText("Search");

        jLabel15.setText("Note:");

        noteArea.setColumns(20);
        noteArea.setRows(5);
        jScrollPane2.setViewportView(noteArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtserial, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(combotype, 0, 1, Short.MAX_VALUE)
                    .addComponent(txtassetno))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsapno, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtdesc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtvalue)
                    .addComponent(txtbrand)
                    .addComponent(txtmodel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtassign)
                    .addComponent(txtlocation)
                    .addComponent(txtteam, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsearch)
                            .addComponent(txtwarranty))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtserial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(txtsapno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtlocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(combotype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtteam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtwarranty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtassetno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtassign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtserialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtserialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtserialActionPerformed

    private void txtassetnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassetnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassetnoActionPerformed

    private void txtsapnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsapnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsapnoActionPerformed

    private void txtdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void txtteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtteamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (txtserial.getText() == null || txtserial.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Serial Number", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtserial.requestFocus();
                    return;
                }

                if (txtassetno.getText() == null || txtassetno.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter Asset Number", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtassetno.requestFocus();
                    return;
                }
                if (txtsapno.getText() == null || txtsapno.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, " Enter SAP Number", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtsapno.requestFocus();
                    return;
                }
                if (txtdesc.getText() == null || txtdesc.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, " Enter Description ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtdesc.requestFocus();
                    return;
                }

                if (txtdate.getText() == null || txtdate.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter Acquisition Date ie. 7/24/2017", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtdate.requestFocus();
                    return;
                }
                if(txtvalue.getText()==null || txtvalue.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter the Acquisition Value ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtvalue.requestFocus();
                    return;
                }
                if(txtbrand.getText()==null || txtbrand.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the Brand of the item", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtbrand.requestFocus();
                    return;
                }
                if(txtmodel.getText()==null || txtmodel.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter The Model", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtmodel.requestFocus();
                    return;
                }
                if(txtlocation.getText()==null || txtlocation.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter its Location", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtlocation.requestFocus();
                    return;
                }
                if(txtteam.getText()==null || txtteam.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Cost Center", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtteam.requestFocus();
                    return;
                }if(txtassign.getText()==null || txtassign.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Whos is the Assignee", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtassign.requestFocus();
                    return;
                }
                if(txtstatus.getText()==null || txtstatus.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, " Please Enter The Status of The Item", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtstatus.requestFocus();
                    return;
                }
                if(txtwarranty.getText()==null || txtwarranty.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, " Please Enter The Time Span of The Warranty", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtwarranty.requestFocus();
                    return;
                }                
        try {
            getSaved();
            getFillTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
    try 
    {
    getSearch();
    } catch (Exception e)
    {    
    }      
    }//GEN-LAST:event_txtsearchKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        try 
    {
        getFillTable();
        getClearAll();
        
    } catch (Exception e)
    {    }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String sql="UPDATE it_assets set serial_no=?,asset_type=?,asset_no=?,sap_no=?,description=?,aqc_date=?,aqc_value=?,brand=?,model=?,location=?,team=?,assignee=?,status=?,warranty=?";
        
        try {
            con=(Connection) cc.getConnection();
            pr=(PreparedStatement) con.prepareStatement(sql);
            
              pr.setString(1, txtserial.getText());
                pr.setString(2, combotype.getSelectedItem().toString());
                pr.setString(3, txtassetno.getText());
                pr.setString(4, txtsapno.getText());
                pr.setString(5, txtdesc.getText());
                pr.setString(6, txtdate.getText());
                pr.setString(7, txtvalue.getText());
                pr.setString(8, txtbrand.getText());
                pr.setString(9, txtmodel.getText());
                pr.setString(10, txtlocation.getText());
                pr.setString(11, txtteam.getText());
                pr.setString(12, txtassign.getText());
                pr.setString(13, txtstatus.getText());
                pr.setString(14, txtwarranty.getText());
                pr.setString(15, noteArea.getText());
                pr.executeUpdate();
                JOptionPane.showMessageDialog(null,"Records Sourcefully Updated","Updated Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       try {
            int row=jTable1.getSelectedRow();
            txtserial.setText(jTable1.getModel().getValueAt(row,0).toString());
            //combotype.setText(jTable1.getModel().getValueAt(row,1).toString());
            txtassetno.setText(jTable1.getModel().getValueAt(row, 2).toString());
            txtsapno.setText(jTable1.getModel().getValueAt(row, 3).toString());
            txtdesc.setText(jTable1.getModel().getValueAt(row, 4).toString());
            txtdate.setText(jTable1.getModel().getValueAt(row, 5).toString());
            txtvalue.setText(jTable1.getModel().getValueAt(row, 6).toString());
            txtbrand.setText(jTable1.getModel().getValueAt(row, 7).toString());
            txtmodel.setText(jTable1.getModel().getValueAt(row, 8).toString());
            txtlocation.setText(jTable1.getModel().getValueAt(row, 9).toString());
            txtteam.setText(jTable1.getModel().getValueAt(row, 10).toString());
            txtassign.setText(jTable1.getModel().getValueAt(row, 11).toString());
            txtstatus.setText(jTable1.getModel().getValueAt(row, 12).toString());
            txtwarranty.setText(jTable1.getModel().getValueAt(row, 13).toString());
            noteArea.setText(jTable1.getModel().getValueAt(row, 14).toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         MessageFormat header = new MessageFormat("Inventory Report");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
    try {
        jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    } catch (java.awt.print.PrinterAbortException e) {
    } catch (PrinterException ex) {
        
    }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combotype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JTextField txtassetno;
    private javax.swing.JTextField txtassign;
    private javax.swing.JTextField txtbrand;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtlocation;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtsapno;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtserial;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txtteam;
    private javax.swing.JTextField txtvalue;
    private javax.swing.JTextField txtwarranty;
    // End of variables declaration//GEN-END:variables
}
