/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Editors;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import project.RegistrationForm;
/**
 *
 * @author edison
 */
public class ColorBlindEditor extends javax.swing.JFrame {

    /**
     * Creates new form ColorBlindEditor
     */
    private File f;
    private byte[] imageChosedToByteArray;
    private JFileChooser chooser = new JFileChooser();
    private int itemID;
    private Connection cn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    public ColorBlindEditor() {
   
    }
    public ColorBlindEditor(int id){
        initComponents();
        setResizable(false);
        setSize(457, 468);
        itemID = id;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement();
            String getData = "Select * from cvarst.ColorblindTest where id = '"+itemID+"'";
            rs = st.executeQuery(getData);
            while(rs.next()){
            
                 ImageIcon icon = new ImageIcon((byte[]) rs.getBytes("Picture"));
                 
                 String answer = rs.getString("Answer");
//                   Image img = icon.getImage();
//                    BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//                    Graphics g = bi.createGraphics();
//                   g.drawImage(img, 0, 0, questionImage.getWidth(), questionImage.getHeight(), null);
//                    ImageIcon result = new ImageIcon(bi);
                    
                    questionImage.setIcon(icon);
                    answerField.setText(answer);
                    attachedFileField.setText(questionImage.getIcon().toString());
            }
        }
        
        catch(Exception e){
            
        
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        questionImage = new javax.swing.JLabel();
        attachedFileField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        answerField = new javax.swing.JTextField();
        attachFileButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Editors/modify_title.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 10, 160, 33);

        jLabel3.setBackground(java.awt.Color.darkGray);
        jLabel3.setOpaque(true);
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 457, 60);

        questionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pickers/NoImageIcon.png"))); // NOI18N
        getContentPane().add(questionImage);
        questionImage.setBounds(100, 80, 260, 230);

        attachedFileField.setEnabled(false);
        getContentPane().add(attachedFileField);
        attachedFileField.setBounds(90, 320, 280, 28);

        jLabel1.setText("Photo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 330, 51, 18);

        jLabel2.setText("Answer");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 370, 57, 18);

        answerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerFieldActionPerformed(evt);
            }
        });
        answerField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                answerFieldKeyTyped(evt);
            }
        });
        getContentPane().add(answerField);
        answerField.setBounds(90, 360, 280, 28);

        attachFileButton.setText("+");
        attachFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachFileButtonActionPerformed(evt);
            }
        });
        getContentPane().add(attachFileButton);
        attachFileButton.setBounds(380, 320, 43, 28);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(280, 420, 142, 28);

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(modifyButton);
        modifyButton.setBounds(30, 420, 92, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        // TODO add your handling code here:
        Point p = evt.getLocationOnScreen();
        this.setLocation(p);

    }//GEN-LAST:event_jLabel3MouseDragged

    private void answerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerFieldActionPerformed

    private void answerFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();

        }
    }//GEN-LAST:event_answerFieldKeyTyped

    private void attachFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachFileButtonActionPerformed
        // TODO add your handling code here:

        chooser.showOpenDialog(null);
        chooser.setDialogTitle("Open Image File");
        f =  chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        attachedFileField.setText(filename);

        ImageIcon image = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(questionImage.getWidth(), questionImage.getHeight(), Image.SCALE_REPLICATE));
        questionImage.setIcon(image);
        try{
            File imageFile = new File(filename);
            FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
            }
            imageChosedToByteArray = bos.toByteArray();

        }
        catch(Exception e){
                e.printStackTrace();
        }
    }//GEN-LAST:event_attachFileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed

     
        String answer = answerField.getText().toString();
        try{

            ps = cn.prepareStatement("");
            st = cn.createStatement();

            try {

                String getCount = "select id from cvarst.ColorblindTest";
                int count = 0;
                ResultSet resultSet = st.executeQuery(getCount);
                while(resultSet.next()){
                    count = resultSet.getInt("id");
                }

                ps = cn.prepareStatement("insert into cvarst.ColorblindTest (id, Picture, Answer) values"
                    + "(?, ?, ?)");

                ps.setInt(1, count + 1);
                ps.setObject(2, imageChosedToByteArray);
                ps.setString(3, answer);
                ps.executeUpdate();
                cn.close();
                ps.close();
                JOptionPane.showMessageDialog(null, "Added de item Successfully");

            } catch (SQLException ex) {
                Logger.getLogger(ColorBlindEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.dispose();

        }
        catch(Exception e){

            e.printStackTrace();
        }


        
    }//GEN-LAST:event_modifyButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ColorBlindEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorBlindEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorBlindEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorBlindEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorBlindEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerField;
    private javax.swing.JButton attachFileButton;
    private javax.swing.JTextField attachedFileField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modifyButton;
    private javax.swing.JLabel questionImage;
    // End of variables declaration//GEN-END:variables
}