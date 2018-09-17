/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author edison
 */
public class DoctorInformationForm extends javax.swing.JFrame {

    /**
     * Creates new form DoctorInformationForm
     */
    private Connection cn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String userPrimary;
    public void userPrimary(){
       
//     try{
//          Class.forName("com.mysql.jdbc.Driver"); 
//          String getCurrentUserData = "Select * from cvarst.RegisteredDoctors where id = '" +  User.getUserID() + "'";
//          cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
//          st = cn.createStatement();
//          rs = st.executeQuery(getCurrentUserData);
//          while(rs.next()){
//            stationAreaField.setText(rs.getString("Station_Area"));
//            stationIDField.setText(rs.getString("Station_ID"));
//            doctorField.setText(rs.getString("Doctor"));
//            clinicNameField.setText(rs.getString("Clinic_Name"));
//            firstNameField.setText(rs.getString("Firstname"));
//            middleNameField.setText(rs.getString("Middlename"));
//            lastNameField.setText(rs.getString("Lastname"));
//            prcNoField.setText(String.valueOf(rs.getInt("PRC_Number")));
//            ptrNoField.setText(String.valueOf(rs.getInt("PTR_Number")));
//            usernameField.setText(rs.getString("username"));
//            passwordField.setText(rs.getString("password"));
//            
//          }
//          
//          
//          
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
        
       
    }
    public DoctorInformationForm() {
        initComponents();
        setSize(875, 670);
        setResizable(false);
        userPrimary();
        formTitle.setHorizontalAlignment(SwingConstants.CENTER);
        try{
           cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
           st = cn.createStatement();
            System.out.println("connected.");
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = cn.prepareStatement("select Station_ID, Doctor from cvarst.RegisteredDoctors");
            ResultSet rs = ps.executeQuery();
            doctorTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stationAreaField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        stationIDField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctorTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doctorField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        clinicNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        middleNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        prcNoField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ptrNoField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        passwordVisibility = new javax.swing.JCheckBox();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        saveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        formTitle.setFont(new java.awt.Font("Ubuntu Condensed", 0, 13)); // NOI18N
        formTitle.setForeground(java.awt.Color.white);
        formTitle.setText("Registration");
        getContentPane().add(formTitle);
        formTitle.setBounds(0, 0, 830, 20);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setForeground(java.awt.Color.gray);
        jLabel2.setText("Computer Details");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.gray);
        jLabel6.setText("Station/Area");

        stationAreaField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.gray);
        jLabel16.setText("Station ID");

        stationIDField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stationAreaField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(stationIDField))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stationAreaField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(stationIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(420, 30, 450, 140);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        doctorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"123", "Dr. Livingston"},
                {"424", "Dr. Sherd "},
                {"245", "Dr. Kelvin"},
                {"343", "Dr. Who"},
                {"234", "Dr. Paul"}
            },
            new String [] {
                "Doctors ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(doctorTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 400, 630);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 400, 630);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MinimizeButton.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(830, 0, 50, 20);

        jLabel1.setBackground(new java.awt.Color(3, 72, 83));
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 20);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("Doctor Information");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.gray);
        jLabel5.setText("Doctor");

        doctorField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setText("Clinic Name");

        clinicNameField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        firstNameField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setText("Firstname");

        middleNameField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.gray);
        jLabel9.setText("Middlename");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.gray);
        jLabel10.setText("Lastname");

        lastNameField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        prcNoField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.gray);
        jLabel11.setText("PRC No.");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.gray);
        jLabel12.setText("PTR No.");

        ptrNoField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        usernameField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.gray);
        jLabel13.setText("Username");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.gray);
        jLabel14.setText("Password");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.gray);
        jLabel15.setText("Confirm Password");

        passwordVisibility.setForeground(java.awt.Color.gray);
        passwordVisibility.setText("show password");
        passwordVisibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordVisibilityActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N
        passwordField.setEchoChar('\u2022');

        confirmPasswordField.setFont(new java.awt.Font("Umpush", 0, 14)); // NOI18N
        confirmPasswordField.setEchoChar('\u2022');

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(passwordVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmPasswordField)
                            .addComponent(usernameField)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(prcNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ptrNoField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                            .addComponent(lastNameField)
                            .addComponent(middleNameField)
                            .addComponent(firstNameField)
                            .addComponent(clinicNameField)
                            .addComponent(doctorField)
                            .addComponent(passwordField))))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clinicNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(prcNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ptrNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordVisibility)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(420, 180, 450, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:

        Point p = evt.getLocationOnScreen();
        this.setLocation(p);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setState(HomeForm.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void passwordVisibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordVisibilityActionPerformed
        // TODO add your handling code here:
        if(passwordVisibility.isSelected()){
            System.out.print("showed");
            passwordField.setEchoChar((char)0);
            confirmPasswordField.setEchoChar((char)0);

        }
        else if(!passwordVisibility.isSelected()){
            passwordField.setEchoChar('•');
            confirmPasswordField.setEchoChar('•');
        }
    }//GEN-LAST:event_passwordVisibilityActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
        String stationArea, stationID, doctorName, clinicName, firstName, middleName,lastName,  username, password, confirmpassword;
        int prcNumber, ptrNumber;
        
        
        stationArea = stationAreaField.getText().toString();
        stationID = stationIDField.getText().toString();
        doctorName = doctorField.getText().toString();
        clinicName = clinicNameField.getText().toString();
        firstName = firstNameField.getText().toString();
        middleName = middleNameField.getText().toString();
        lastName = lastNameField.getText().toString();
        prcNumber = Integer.valueOf(prcNoField.getText().toString());
        ptrNumber = Integer.valueOf(ptrNoField.getText().toString());
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        confirmpassword = confirmPasswordField.getText().toString();
        
        if  (password.equals(confirmpassword)) {
        try{
            ps = cn.prepareStatement("insert into cvarst.RegisteredDoctors (Doctor,"
                    + " Clinic_Name, "
                    + "Firstname, Middlename, "
                    + "Lastname, PRC_Number, "
                    + "PTR_Number, "
                    + " username, password, "
                    + "Station_Area, Station_ID, balance) values"
                    + "(?,?,?,?,?,?,?,?,?,?,?, ?)");
            
            ps.setString(1, doctorName);
            ps.setString(2, clinicName);
            ps.setString(3, firstName);
            ps.setString(4, middleNameField.getText().isEmpty() ? null : middleName);
            ps.setString(5, lastName);
            ps.setInt(6, prcNumber);
            ps.setInt(7, ptrNumber);
            ps.setString(8, username);
            ps.setString(9, password);
            ps.setString(10, stationArea);
            ps.setString(11, stationID);
            ps.setInt(12, 10);
            ps.executeUpdate();
            cn.close();
            ps.close();
            
            this.dispose();
            DoctorInformationForm dIF = new DoctorInformationForm();
            dIF.setVisible(true);
            JOptionPane.showMessageDialog(null, "Registered the account Successfully");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password does not match!");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Cancel? All data input will be lost.", "Cancel", JOptionPane.YES_NO_OPTION);
       if(confirmExitDialog == 0){
           HomeForm hf = new HomeForm();
           this.dispose();///
           hf.setVisible(true);
           
       }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorInformationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clinicNameField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField doctorField;
    private javax.swing.JTable doctorTable;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel formTitle;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField middleNameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox passwordVisibility;
    private javax.swing.JTextField prcNoField;
    private javax.swing.JTextField ptrNoField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField stationAreaField;
    private javax.swing.JTextField stationIDField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
