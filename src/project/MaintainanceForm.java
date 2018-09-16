/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import project.Editors.AuditoryEditor;
import project.Editors.ColorBlindEditor;
import project.Editors.VisualBailyEditor;
import project.Editors.VisualSnellenEditor;
import project.Pickers.AuditoryPicker;
import project.Pickers.ColorBlindPicker;
import project.Pickers.VisualBailyPicker;
import project.Pickers.VisualSnellenPicker;
import project.Tests.AuditoryTestForm;

/**
 *
 * @author edison
 */


public class MaintainanceForm extends javax.swing.JFrame {

    /**
     * Creates new form MaintainanceForm
     */
    private Connection cn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private ColorBlindPicker cBP = new ColorBlindPicker();
    private VisualSnellenPicker vSP = new VisualSnellenPicker();
    private VisualBailyPicker vBP = new VisualBailyPicker();
    private AuditoryPicker aP = new AuditoryPicker();
    private ColorBlindEditor cBE;
    private VisualSnellenEditor vSE;
    private VisualBailyEditor vBE;
    private AuditoryEditor aE;
    
    
    public void userPrimary(){
       
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
//            String getCurrentUserData = "Select * from cvarst.RegisteredDoctors where id= '" +  User.getUserID() + "'";
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement();
//            rs = st.executeQuery(getCurrentUserData);
//            while(rs.next()){
//                doctorField.setText(rs.getString("Doctor"));
//                clinicNameField.setText(rs.getString("Clinic_Name"));
//                stationField.setText(rs.getString("Station_Area"));
//                areaIDField.setText(rs.getString("Station_ID"));
//                balanceLabel.setText(rs.getString("balance"));
//                prcNoField.setText(rs.getString("PRC_Number")); 
//                ptrNoField.setText(rs.getString("PTR_Number"));
//            }

        }
        catch(Exception e){
                e.printStackTrace();}
    }
    public MaintainanceForm() {
        initComponents();
        setSize(875, 551);
        setResizable(false);
        this.setBackground(new Color(23,23,23,100));
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//        jLabel5.setBackground(new Color(23,23,23,100));
        userPrimary();
        JTable[] tables = {colorBlindTable, visualSnellenTable, visualBailyLoviTable, auditoryTestTable};
        
        for(int i = 0; i < tables.length; i++){
        
        tables[i].setRowHeight(150);
        tables[i].setShowGrid(true);
        tables[i].setGridColor(new Color(30, 30, 30, 100));
        tables[i].getTableHeader().setDefaultRenderer(new HeaderColor());
        tables[i].setBackground(new Color(255,255,255));
        tables[i].setSelectionBackground(new Color(23, 23,23, 30));
        tables[i].setSelectionForeground(Color.BLACK);
        tables[i].setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        
        }
        
        visualSnellenTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        visualBailyLoviTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        colorBlindTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        colorBlindTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        colorBlindTable.getColumnModel().getColumn(2).setMinWidth(300);
        colorBlindTable.setRowHeight(150);
        
        auditoryTestTable.setRowHeight(40);
      
      
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        colorBlindTable.setDefaultRenderer(String.class, centerRenderer);
        colorBlindTable.setDefaultRenderer(Integer.class, centerRenderer);
       
        JTableHeader colorBlindTableHeader = colorBlindTable.getTableHeader();
        colorBlindTableHeader.setDefaultRenderer(new CustomHeader(colorBlindTable));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        String getData = "Select * from cvarst.AuditoryTest";
           try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement();
            rs = st.executeQuery(getData);
            auditoryTestTable.setModel(DbUtils.resultSetToTableModel(rs));
            auditoryTestTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            

        }
           catch(Exception e){
           e.printStackTrace();}
           
           finally{
              
           
            try {
                rs.close();
               
            } catch (SQLException ex) {
                Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
            }
          
           }
           
           
           
           String query = "Select Doctor from cvarst.RegisteredDoctors";
           try{
               ResultSet rs = st.executeQuery(query);
               while(rs.next()){     
               doctorsList.addItem(rs.getString("Doctor"));
               }
           
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cvarst?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        colorblindTestQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM ColorblindTest c");
        colorblindTestList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : colorblindTestQuery.getResultList();
        colorblindTestQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM ColorblindTest c");
        colorblindTestList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : colorblindTestQuery1.getResultList();
        visualAcuityTestQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM VisualAcuityTest v");
        visualAcuityTestList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : visualAcuityTestQuery.getResultList();
        visualAcuityBailyTestQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM VisualAcuityBailyTest v");
        visualAcuityBailyTestList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : visualAcuityBailyTestQuery.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        stationIDField = new javax.swing.JTextField();
        clinicNameField = new javax.swing.JTextField();
        ptrNoField = new javax.swing.JTextField();
        prcNoField = new javax.swing.JTextField();
        areaField = new javax.swing.JTextField();
        doctorsList = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();
        reload = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tab2 = new javax.swing.JPanel();
        colorBlindScrollPane = new javax.swing.JScrollPane();
        colorBlindTable = new javax.swing.JTable();
        tab3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visualSnellenTable = new javax.swing.JTable();
        tab4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        visualBailyLoviTable = new javax.swing.JTable();
        tab5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        auditoryTestTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        addButton = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jTabbedPane1.setFont(new java.awt.Font("Umpush", 0, 13)); // NOI18N

        tab1.setBackground(java.awt.Color.white);
        tab1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tab1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab1ComponentShown(evt);
            }
        });
        tab1.setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("Doctor");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setText("Station ID");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setText("Clinic Name");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.gray);
        jLabel9.setText("PRC No");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.gray);
        jLabel10.setText("PTR No");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.gray);
        jLabel11.setText("Area");

        stationIDField.setFont(new java.awt.Font("Umpush", 0, 16)); // NOI18N

        clinicNameField.setFont(new java.awt.Font("Umpush", 0, 16)); // NOI18N

        ptrNoField.setFont(new java.awt.Font("Umpush", 0, 16)); // NOI18N

        prcNoField.setFont(new java.awt.Font("Umpush", 0, 16)); // NOI18N

        areaField.setFont(new java.awt.Font("Umpush", 0, 16)); // NOI18N

        doctorsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clinicNameField)
                    .addComponent(stationIDField)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorsList, 0, 416, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ptrNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prcNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ptrNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clinicNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prcNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stationIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areaField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tab1.add(jPanel6);
        jPanel6.setBounds(10, 10, 810, 230);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(java.awt.Color.lightGray);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.gray);
        jLabel12.setText("Available Balance");

        balanceLabel.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        balanceLabel.setForeground(java.awt.Color.gray);
        balanceLabel.setText("23");

        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/restart_button.png"))); // NOI18N
        reload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reloadMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reloadMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reloadMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reloadMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reloadMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reload)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tab1.add(jPanel7);
        jPanel7.setBounds(10, 330, 290, 90);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setForeground(java.awt.Color.lightGray);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.gray);
        jLabel14.setText("Colorblind Test");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.gray);
        jLabel15.setText("Webcam Location");

        jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        jComboBox2.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, 129, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1.add(jPanel8);
        jPanel8.setBounds(10, 250, 290, 70);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button.png"))); // NOI18N
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveButtonMouseEntered(evt);
            }
        });
        tab1.add(saveButton);
        saveButton.setBounds(650, 380, 150, 30);

        jButton1.setText("🔄");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tab1.add(jButton1);
        jButton1.setBounds(300, 330, 40, 90);

        jTabbedPane1.addTab("Doctor Details", tab1);

        tab2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab2ComponentShown(evt);
            }
        });
        tab2.setLayout(null);

        colorBlindTable.setBorder(null);
        colorBlindTable.setGridColor(java.awt.Color.white);
        colorBlindTable.setSelectionForeground(java.awt.Color.black);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, colorblindTestList1, colorBlindTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${image}"));
        columnBinding.setColumnName("Image");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${answer}"));
        columnBinding.setColumnName("Answer");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        colorBlindTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorBlindTableMouseClicked(evt);
            }
        });
        colorBlindTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                colorBlindTableComponentShown(evt);
            }
        });
        colorBlindScrollPane.setViewportView(colorBlindTable);

        tab2.add(colorBlindScrollPane);
        colorBlindScrollPane.setBounds(0, 0, 830, 440);

        jTabbedPane1.addTab("Colorblind Test", tab2);

        tab3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab3ComponentShown(evt);
            }
        });
        tab3.setLayout(null);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, visualAcuityTestList, visualSnellenTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${image}"));
        columnBinding.setColumnName("Image");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${question}"));
        columnBinding.setColumnName("Question");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${answer}"));
        columnBinding.setColumnName("Answer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vision}"));
        columnBinding.setColumnName("Vision");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(visualSnellenTable);

        tab3.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 830, 440);

        jTabbedPane1.addTab("Visual Acuity Test (Snellen)", tab3);

        tab4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab4ComponentShown(evt);
            }
        });
        tab4.setLayout(null);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, visualAcuityBailyTestList, visualBailyLoviTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${image}"));
        columnBinding.setColumnName("Image");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${question}"));
        columnBinding.setColumnName("Question");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${answer}"));
        columnBinding.setColumnName("Answer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vision}"));
        columnBinding.setColumnName("Vision");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(visualBailyLoviTable);

        tab4.add(jScrollPane2);
        jScrollPane2.setBounds(0, 2, 830, 430);

        jTabbedPane1.addTab("Visual Acuity Test (Bar Chart)", tab4);

        tab5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab5ComponentShown(evt);
            }
        });
        tab5.setLayout(null);

        auditoryTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(auditoryTestTable);

        tab5.add(jScrollPane3);
        jScrollPane3.setBounds(-4, 4, 840, 430);

        jTabbedPane1.addTab("Auditory Test", tab5);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(40, 70, 840, 480);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/title.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 30, 160, 33);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/delete_icon.png"))); // NOI18N
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(10, 170, 30, 40);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/back_icon.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(10, 30, 30, 40);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/add_icon.png"))); // NOI18N
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(10, 90, 30, 40);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/edit_icon.png"))); // NOI18N
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
        });
        getContentPane().add(editButton);
        editButton.setBounds(10, 130, 30, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MinimizeButton.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(832, 0, 50, 20);

        jLabel1.setBackground(new java.awt.Color(3, 72, 83));
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 20);

        jLabel6.setBackground(new java.awt.Color(21, 21, 21));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 40, 560);

        jLabel5.setBackground(new java.awt.Color(23, 23, 23));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 20, 840, 50);

        bindingGroup.bind();

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

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        // TODO add your handling code here:
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/add_icon.png")));
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        // TODO add your handling code here:
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/add_icon.png")));
    }//GEN-LAST:event_addButtonMouseExited

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/edit_icon.png")));
    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/edit_icon.png")));
    }//GEN-LAST:event_editButtonMouseExited

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        // TODO add your handling code here:
       deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/delete_icon.png")));
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        // TODO add your handling code here:
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/delete_icon.png")));
    }//GEN-LAST:event_deleteButtonMouseExited

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        // TODO add your handling code here:
        if(addButton.isEnabled()){
        if(tab2.isShowing()){
            cBP.setVisible(true);
        }
        else if(tab3.isShowing()){
            vSP.setVisible(true);
        }
        else if(tab4.isShowing()){
            vBP.setVisible(true);
        }
        else if(tab5.isShowing()){
            aP.setVisible(true);
            
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Add not applicable.");
        }
        
        
            
        
    }//GEN-LAST:event_addButtonMouseClicked

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        // TODO add your handling code here:
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/add_icon.png")));
    }//GEN-LAST:event_addButtonMousePressed

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        // TODO add your handling code here:
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/add_icon.png")));
    }//GEN-LAST:event_addButtonMouseReleased

    private void editButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMousePressed
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/edit_icon.png")));
    }//GEN-LAST:event_editButtonMousePressed

    private void editButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseReleased
        // TODO add your handling code here:
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/edit_icon.png")));
    }//GEN-LAST:event_editButtonMouseReleased

    private void deleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMousePressed
        // TODO add your handling code here:
          deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/delete_icon.png")));
    }//GEN-LAST:event_deleteButtonMousePressed

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        // TODO add your handling code here:
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/delete_icon.png")));
    }//GEN-LAST:event_deleteButtonMouseReleased

    private void colorBlindTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorBlindTableMouseClicked
       System.out.println(colorBlindTable.getModel().getValueAt(colorBlindTable.getSelectedRow(), colorBlindTable.getSelectedColumn()).toString());
              
       
    }//GEN-LAST:event_colorBlindTableMouseClicked

    private void colorBlindTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_colorBlindTableComponentShown
        // TODO add your handling code here:
   
System.out.print("SHOWING");
    }//GEN-LAST:event_colorBlindTableComponentShown

    private void backButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonMousePressed

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonMouseReleased

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        HomeForm hf = new HomeForm();
        hf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
         backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/back_icon.png")));
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/highlighted/back_icon.png")));
    }//GEN-LAST:event_backButtonMouseEntered

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_formMouseClicked

          private void update_Table(){
    try{

    String sql = "Select * from cvarst.ColorblindTest";
    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
    ps = cn.prepareStatement(sql);
    rs = ps.executeQuery();
    colorBlindTable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
    }
    finally{
    try{
    
    rs.close();
    ps.close();
    
    }
    catch (Exception e){}
    }
    
    
    try{ps.close();}
    catch(Exception e){}
    }
    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        // TODO add your handling code here:
        
        if(editButton.isEnabled()){
        if(tab2.isShowing()){
            if(colorBlindTable.getSelectedRowCount() != 0){
            
            int id = (int) colorBlindTable.getValueAt(colorBlindTable.getSelectedRow(), 0);
            System.out.println(String.valueOf(id));
            cBE = new ColorBlindEditor(id);
            cBE.setVisible(true);
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select an item to modify.");
            }
                
        }
        else if(tab3.isShowing()){
             if(visualSnellenTable.getSelectedRowCount() != 0){
            
            int id = (int) visualSnellenTable.getValueAt(visualSnellenTable.getSelectedRow(), 0);
            System.out.println(String.valueOf(id));
            vSE = new VisualSnellenEditor(id);
            vSE.setVisible(true);
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select an item to modify.");
            }
        }
        else if(tab4.isShowing()){
        
                if(visualBailyLoviTable.getSelectedRowCount() != 0){
            
            int id = (int) visualBailyLoviTable.getValueAt(visualBailyLoviTable.getSelectedRow(), 0);
            System.out.println(String.valueOf(id));
            vBE = new VisualBailyEditor(id);
            vBE.setVisible(true);
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select an item to modify.");
            }
        
        }
        else if(tab5.isShowing()){
        
                     if(auditoryTestTable.getSelectedRowCount() != 0){
            
            int id = (int) auditoryTestTable.getValueAt(auditoryTestTable.getSelectedRow(), 0);
            System.out.println(String.valueOf(id));
         
            aE = new AuditoryEditor(id);
            aE.setVisible(true);
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select an item to modify.");
            }
        
        }
        
        
        }
        
    }//GEN-LAST:event_editButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
            String deleteItem = null;
        if(deleteButton.isEnabled()){
        if(tab2.isShowing()){
            if(colorBlindTable.getSelectedRowCount() != 0){
                try {
                    int id = (int) colorBlindTable.getValueAt(colorBlindTable.getSelectedRow(), 0);
                    deleteItem = "DELETE FROM cvarst.ColorblindTest WHERE Id = ?";
                    ps = cn.prepareStatement(deleteItem);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    this.dispose();
                    new MaintainanceForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Item deleted.");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
              else{
                JOptionPane.showMessageDialog(null, "Please select an item to delete.");
            }}
         else if(tab3.isShowing()){
                      if(visualSnellenTable.getSelectedRowCount() != 0){
                try {
                    int id = (int) visualSnellenTable.getValueAt(visualSnellenTable.getSelectedRow(), 0);
                    deleteItem = "DELETE FROM cvarst.VisualAcuityTest WHERE Id = ?";
                    ps = cn.prepareStatement(deleteItem);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    this.dispose();
                    new MaintainanceForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Item deleted.");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
              else{
                JOptionPane.showMessageDialog(null, "Please select an item to delete.");
            }
        }
         else if(tab4.isShowing()){
           if(visualBailyLoviTable.getSelectedRowCount() != 0){
                try {
                    int id = (int) visualBailyLoviTable.getValueAt(visualBailyLoviTable.getSelectedRow(), 0);
                    deleteItem = "DELETE FROM cvarst.VisualAcuityBailyTest WHERE Id = ?";
                    ps = cn.prepareStatement(deleteItem);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    this.dispose();
                    new MaintainanceForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Item deleted.");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
              else{
                JOptionPane.showMessageDialog(null, "Please select an item to delete.");
            }
         }
         else if(tab5.isShowing()){
                 if(auditoryTestTable.getSelectedRowCount() != 0){
                try {
                    int id = (int) auditoryTestTable.getValueAt(auditoryTestTable.getSelectedRow(), 0);
                    deleteItem = "DELETE FROM cvarst.AuditoryTest WHERE Id = ?";
                    ps = cn.prepareStatement(deleteItem);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    this.dispose();
                    new MaintainanceForm().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Item deleted.");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
              else{
                JOptionPane.showMessageDialog(null, "Please select an item to delete.");
            }
         
         
         
         }
        
        
          }
     
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void tab1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab1ComponentShown
        // TODO add your handling code here:
        addButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_tab1ComponentShown

    private void tab2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab2ComponentShown
        // TODO add your handling code here:
              addButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_tab2ComponentShown

    private void tab3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab3ComponentShown
        // TODO add your handling code here:
                   addButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_tab3ComponentShown

    private void tab4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab4ComponentShown
        // TODO add your handling code here:
              addButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_tab4ComponentShown

    private void reloadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseEntered
        // TODO add your handling code here:
        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/restart_button_highlighted.png")));
    }//GEN-LAST:event_reloadMouseEntered

    private void reloadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseExited
        // TODO add your handling code here:
        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/restart_button.png")));
    }//GEN-LAST:event_reloadMouseExited

    private void reloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseClicked
        // TODO add your handling code here:
        ReloaderForm reload = new ReloaderForm();
        reload.setVisible(true);
    }//GEN-LAST:event_reloadMouseClicked

    private void reloadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMousePressed
        // TODO add your handling code here:
        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/restart_button.png")));
    }//GEN-LAST:event_reloadMousePressed

    private void reloadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseReleased
        // TODO add your handling code here:
        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/restart_button_highlighted.png")));
    }//GEN-LAST:event_reloadMouseReleased

    private void saveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseEntered
        // TODO add your handling code here:
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button_highlighted.png")));
    }//GEN-LAST:event_saveButtonMouseEntered

    private void saveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseExited
        // TODO add your handling code here:
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button.png")));
    }//GEN-LAST:event_saveButtonMouseExited

    private void saveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMousePressed
        // TODO add your handling code here:
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button.png")));
    }//GEN-LAST:event_saveButtonMousePressed

    private void saveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseReleased
        // TODO add your handling code here:
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button_highlighted.png")));
        
    }//GEN-LAST:event_saveButtonMouseReleased

    private void tab5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab5ComponentShown
       addButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_tab5ComponentShown

    private void refreshInformation(){
    try {
            // TODO add your handling code here:
            String doctor = doctorsList.getSelectedItem().toString();
            Doctor doctorClass = new Doctor();
            doctorClass.setDoctor(doctor);
           
            ps = cn.prepareStatement("Select id, Clinic_Name, prc_number, ptr_number, station_area, station_ID, balance from cvarst.RegisteredDoctors where Doctor = ?");
            ps.setString(1, doctor);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                doctorClass.setDoctorID(rs.getInt("id"));
                balanceLabel.setText(rs.getString("balance"));
                clinicNameField.setText(rs.getString("Clinic_Name"));
                stationIDField.setText(rs.getString("Station_ID"));
                ptrNoField.setText(rs.getString("PTR_Number"));
                prcNoField.setText(rs.getString("PRC_Number"));
                areaField.setText(rs.getString("Station_Area"));   
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doctorsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorsListActionPerformed
        refreshInformation();
            
    }//GEN-LAST:event_doctorsListActionPerformed
    private JDialog showMessage(String s, String title, String type){
    
            JOptionPane jop = new JOptionPane(s, (type.equals("S")) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog(title);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return dialog;
    }
    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
        int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Are you sure you want to change information?", "Exit", JOptionPane.YES_NO_OPTION);
       if(confirmExitDialog == 0){
            try {
                System.out.print("Save trigger");
                // TODO add your handling code here:
                String doctor = doctorsList.getSelectedItem().toString();
                String clinicName = clinicNameField.getText().toString();
                String stationID = stationIDField.getText().toString();
                String area = areaField.getText().toString();
                String prcNo = prcNoField.getText().toString();
                String ptrNo = ptrNoField.getText().toString();
                ps  = cn.prepareStatement("UPDATE cvarst.RegisteredDoctors SET Clinic_Name = ?, PTR_Number = ?, PRC_Number = ?,"
                        + " Station_Area = ?, Station_ID = ? WHERE Doctor = ? ");
                ps.setString(1, clinicName);
                ps.setString(2, ptrNo);
                ps.setString(3, prcNo);
                ps.setString(4, area);
                ps.setString(5, stationID);
                ps.setString(6, doctor);
                ps.executeUpdate();
                
                showMessage("Successfully saved", "Success", "S");
            } catch (SQLException ex) {
                Logger.getLogger(MaintainanceForm.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_saveButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refreshInformation();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MaintainanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintainanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintainanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintainanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintainanceForm().setVisible(true);
            }
        });
    }
    
    static public class HeaderColor extends DefaultTableCellRenderer{
        public HeaderColor(){
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable myTable, Object value, boolean selected, boolean focused,int row, int column){
            super.getTableCellRendererComponent(myTable, value, focused, focused, row, row);
            setBackground(new Color(23, 23,23));
            setForeground(Color.WHITE);
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addButton;
    private javax.swing.JTextField areaField;
    private javax.swing.JTable auditoryTestTable;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField clinicNameField;
    private javax.swing.JScrollPane colorBlindScrollPane;
    private javax.swing.JTable colorBlindTable;
    private java.util.List<project.ColorblindTest> colorblindTestList;
    private java.util.List<project.ColorblindTest> colorblindTestList1;
    private javax.persistence.Query colorblindTestQuery;
    private javax.persistence.Query colorblindTestQuery1;
    private javax.swing.JLabel deleteButton;
    private javax.swing.JComboBox<String> doctorsList;
    private javax.swing.JLabel editButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField prcNoField;
    private javax.swing.JTextField ptrNoField;
    private javax.swing.JLabel reload;
    private javax.swing.JLabel saveButton;
    private javax.swing.JTextField stationIDField;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private java.util.List<project.VisualAcuityBailyTest> visualAcuityBailyTestList;
    private javax.persistence.Query visualAcuityBailyTestQuery;
    private java.util.List<project.VisualAcuityTest> visualAcuityTestList;
    private javax.persistence.Query visualAcuityTestQuery;
    private javax.swing.JTable visualBailyLoviTable;
    private javax.swing.JTable visualSnellenTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
