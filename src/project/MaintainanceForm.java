/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

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
    
    public MaintainanceForm() {
        initComponents();
        setSize(875, 551);
        setResizable(false);
      
        jLabel4.setBackground(new Color(23, 23,23));
        colorBlindTable.setRowHeight(70);
        colorBlindTable.setShowGrid(true);
        colorBlindTable.setGridColor(new Color(30, 30, 30, 100));
        colorBlindTable.getTableHeader().setDefaultRenderer(new HeaderColor());
        colorBlindTable.setBackground(new Color(255,255,255));
        colorBlindTable.setSelectionBackground(new Color(23, 23,23, 30));
        colorBlindTable.setSelectionForeground(Color.BLACK);
        doctorDetailsTextHighlight.setVisible(false);
        colorblindTextHighlight.setVisible(false);
        visualAcuityBarChartTextHighlight.setVisible(false);
        visualAcuityTextHighlight.setVisible(false);
        colorBlindTable.setRowHeight(200);
        DefaultTableCellRenderer centerRederer = new DefaultTableCellRenderer();
        centerRederer.setHorizontalAlignment(JLabel.CENTER);
        colorBlindTable.setDefaultRenderer(String.class, centerRederer);
        String getData = "Select * from cvarst.ColorblindTest";
           try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement();
            rs = st.executeQuery(getData);
//            colorBlindTable.setModel(DbUtils.resultSetToTableModel(rs));      
//            ImageIcon image = (ImageIcon) colorBlindTable.getValueAt(0, 0);
//            Image imagetest = image.getImage();
//            ImageIcon image3 = new ImageIcon(imagetest);   
//                while(rs.next()){
//                
//                System.out.print(rs.getObject("Picture").getClass());
//                }
//            colorBlindTable.setValueAt((ImageIcon)new ImageIcon(getClass().getResource("/Images/Maintenance/delete_icon.png")), 0, 0);
//            JOptionPane.showMessageDialog(null, "connected.");

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
        jLabel2 = new javax.swing.JLabel();
        colorBlindScrollPane = new javax.swing.JScrollPane();
        colorBlindTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JLabel();
        addButton = new javax.swing.JLabel();
        editButton = new javax.swing.JLabel();
        visualAcuityBarChartText = new javax.swing.JLabel();
        visualAcuitySnellenText = new javax.swing.JLabel();
        colorblindText = new javax.swing.JLabel();
        doctorDetailsText = new javax.swing.JLabel();
        visualAcuityTextHighlight = new javax.swing.JLabel();
        colorblindTextHighlight = new javax.swing.JLabel();
        doctorDetailsTextHighlight = new javax.swing.JLabel();
        visualAcuityBarChartTextHighlight = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/title.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 30, 160, 33);

        colorBlindTable.setBorder(null);
        colorBlindTable.setGridColor(java.awt.Color.white);
        colorBlindTable.setSelectionForeground(java.awt.Color.black);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, colorblindTestList, colorBlindTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${image}"));
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
        colorBlindScrollPane.setViewportView(colorBlindTable);

        getContentPane().add(colorBlindScrollPane);
        colorBlindScrollPane.setBounds(38, 99, 837, 460);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/delete_icon.png"))); // NOI18N
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(8, 130, 30, 40);

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
        addButton.setBounds(8, 50, 30, 40);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maintenance/edit_icon.png"))); // NOI18N
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editButtonMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
        });
        getContentPane().add(editButton);
        editButton.setBounds(8, 90, 30, 40);

        visualAcuityBarChartText.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        visualAcuityBarChartText.setForeground(java.awt.Color.white);
        visualAcuityBarChartText.setText("Visual Acuity Test (Bar Chart)");
        visualAcuityBarChartText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visualAcuityBarChartTextMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualAcuityBarChartTextMouseEntered(evt);
            }
        });
        getContentPane().add(visualAcuityBarChartText);
        visualAcuityBarChartText.setBounds(690, 70, 163, 30);

        visualAcuitySnellenText.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        visualAcuitySnellenText.setForeground(java.awt.Color.white);
        visualAcuitySnellenText.setText("Visual Acuity Test (Snellen)");
        visualAcuitySnellenText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visualAcuitySnellenTextMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualAcuitySnellenTextMouseEntered(evt);
            }
        });
        getContentPane().add(visualAcuitySnellenText);
        visualAcuitySnellenText.setBounds(490, 70, 160, 30);

        colorblindText.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        colorblindText.setForeground(java.awt.Color.white);
        colorblindText.setText("Color Blind Test");
        colorblindText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorblindTextMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorblindTextMouseEntered(evt);
            }
        });
        getContentPane().add(colorblindText);
        colorblindText.setBounds(310, 70, 100, 30);

        doctorDetailsText.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        doctorDetailsText.setForeground(java.awt.Color.white);
        doctorDetailsText.setText("Doctor Details");
        doctorDetailsText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                doctorDetailsTextMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorDetailsTextMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorDetailsTextMouseEntered(evt);
            }
        });
        getContentPane().add(doctorDetailsText);
        doctorDetailsText.setBounds(100, 70, 90, 30);

        visualAcuityTextHighlight.setOpaque(true);
        getContentPane().add(visualAcuityTextHighlight);
        visualAcuityTextHighlight.setBounds(460, 70, 210, 30);

        colorblindTextHighlight.setOpaque(true);
        getContentPane().add(colorblindTextHighlight);
        colorblindTextHighlight.setBounds(250, 70, 210, 30);

        doctorDetailsTextHighlight.setOpaque(true);
        getContentPane().add(doctorDetailsTextHighlight);
        doctorDetailsTextHighlight.setBounds(40, 70, 210, 30);

        visualAcuityBarChartTextHighlight.setOpaque(true);
        getContentPane().add(visualAcuityBarChartTextHighlight);
        visualAcuityBarChartTextHighlight.setBounds(670, 70, 200, 30);

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

        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 70, 850, 480);

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

    private void doctorDetailsTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorDetailsTextMouseEntered
        // TODO add your handling code here:
        doctorDetailsText.setForeground(Color.BLACK);
        doctorDetailsTextHighlight.setBackground(Color.WHITE);
        doctorDetailsTextHighlight.setVisible(true);
    }//GEN-LAST:event_doctorDetailsTextMouseEntered

    private void doctorDetailsTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorDetailsTextMouseExited
        // TODO add your handling code here:
                doctorDetailsText.setForeground(Color.WHITE);
                doctorDetailsTextHighlight.setBackground(Color.BLACK);
        doctorDetailsTextHighlight.setVisible(false);
    }//GEN-LAST:event_doctorDetailsTextMouseExited

    private void doctorDetailsTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorDetailsTextMousePressed
        // TODO add your handling code here:
           doctorDetailsText.setForeground(Color.BLACK);
        doctorDetailsTextHighlight.setVisible(true);
    }//GEN-LAST:event_doctorDetailsTextMousePressed

    private void colorblindTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorblindTextMouseEntered
        // TODO add your handling code here:
        colorblindText.setForeground(Color.BLACK);
        colorblindTextHighlight.setBackground(Color.WHITE);
        colorblindTextHighlight.setVisible(true);
    }//GEN-LAST:event_colorblindTextMouseEntered

    private void colorblindTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorblindTextMouseExited
        // TODO add your handling code here:
           colorblindText.setForeground(Color.WHITE);
        colorblindTextHighlight.setBackground(Color.BLACK);
        colorblindTextHighlight.setVisible(false);
    }//GEN-LAST:event_colorblindTextMouseExited

    private void visualAcuitySnellenTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualAcuitySnellenTextMouseEntered
        // TODO add your handling code here:
              visualAcuitySnellenText.setForeground(Color.BLACK);
        visualAcuityTextHighlight.setBackground(Color.WHITE);
        visualAcuityTextHighlight.setVisible(true);
    }//GEN-LAST:event_visualAcuitySnellenTextMouseEntered

    private void visualAcuitySnellenTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualAcuitySnellenTextMouseExited
        // TODO add your handling code here:
              visualAcuitySnellenText.setForeground(Color.WHITE);
        visualAcuityTextHighlight.setBackground(Color.BLACK);
        visualAcuityTextHighlight.setVisible(false);
    }//GEN-LAST:event_visualAcuitySnellenTextMouseExited

    private void visualAcuityBarChartTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualAcuityBarChartTextMouseEntered
        // TODO add your handling code here:
                 visualAcuityBarChartText.setForeground(Color.BLACK);
        visualAcuityBarChartTextHighlight.setBackground(Color.WHITE);
        visualAcuityBarChartTextHighlight.setVisible(true);
    }//GEN-LAST:event_visualAcuityBarChartTextMouseEntered

    private void visualAcuityBarChartTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualAcuityBarChartTextMouseExited
        // TODO add your handling code here:
               visualAcuityBarChartText.setForeground(Color.WHITE);
        visualAcuityBarChartTextHighlight.setBackground(Color.BLACK);
        visualAcuityBarChartTextHighlight.setVisible(false);
    }//GEN-LAST:event_visualAcuityBarChartTextMouseExited

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
    private javax.swing.JScrollPane colorBlindScrollPane;
    private javax.swing.JTable colorBlindTable;
    private java.util.List<project.ColorblindTest> colorblindTestList;
    private javax.persistence.Query colorblindTestQuery;
    private javax.swing.JLabel colorblindText;
    private javax.swing.JLabel colorblindTextHighlight;
    private javax.swing.JLabel deleteButton;
    private javax.swing.JLabel doctorDetailsText;
    private javax.swing.JLabel doctorDetailsTextHighlight;
    private javax.swing.JLabel editButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel visualAcuityBarChartText;
    private javax.swing.JLabel visualAcuityBarChartTextHighlight;
    private javax.swing.JLabel visualAcuitySnellenText;
    private javax.swing.JLabel visualAcuityTextHighlight;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
