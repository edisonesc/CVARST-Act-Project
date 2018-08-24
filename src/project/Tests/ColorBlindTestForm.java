/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Tests;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import project.HomeForm;
import project.Pickers.ColorBlindPicker;

/**
 *
 * @author edison
 */
public class ColorBlindTestForm extends javax.swing.JFrame {

    /**
     * Creates new form BlindTestForm
     */
    ArrayList<Integer> randomUniqueNumbers ;
    private Connection cn;
    private Statement st;
    private PreparedStatement ps;
    
    private int totalPoints = 0;
    private ArrayList colorBlindTestQuestion = new ArrayList(), answersList = new ArrayList(), pictureList = new ArrayList();;
    private String input = "";
    private HashMap<Object, Object> testForList;
    String colorBlindImageResDuplicate[];
    int currentItemFinished = 0;
    public ColorBlindTestForm() {
        initComponents();
        setSize(875, 551);
        setResizable(false);
        testForList= new HashMap<Object, Object>();
        colorBlindTestQuestion = new ArrayList();
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBackground(new Color(23, 23,23 ,150));
        inputField.setOpaque(true);
        nextButtonHighlighted.setVisible(false);
        nextButtonPressed.setVisible(false);
        jLabel1.setBackground(new Color(23, 23,23));
        JButton inputButtons[] = {inputOne, inputTwo, inputThree, inputFour, inputFive,inputSix,
        inputSeven, inputEight, inputNine, inputZero, inputClear   };

        try{

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement(); 

           String getCount = "select * from cvarst.ColorblindTest";
           int count = 0;
            ResultSet resultSet = st.executeQuery(getCount);
            while(resultSet.next()){
             
                     ImageIcon icon = new ImageIcon((byte[]) resultSet.getBytes("Picture"));
//                    Image img = icon.getImage();
//                    BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//                    Graphics g = bi.createGraphics();
//                    g.drawImage(img, 0, 0, questionImage.getWidth(), questionImage.getHeight(), null);
//                    ImageIcon result = new ImageIcon(bi);
                    
                       pictureList.add(icon);
                        answersList.add(resultSet.getString("Answer"));
            }
        }
  
        catch(Exception e){
            e.printStackTrace();
        }

        for (int i= 0; i < answersList.size(); i++){
            testForList.put(pictureList.get(i), answersList.get(i));
             System.out.println(String.valueOf(pictureList.get(i) + " | " + answersList.get(i)));
        }

        Collections.shuffle(pictureList);
        for (int i=0; i < inputButtons.length; i++){
            inputButtons[i].setOpaque(false);
            inputButtons[i].setContentAreaFilled(false);
            inputButtons[i].setBorderPainted(true);
        }
        questionImage.setIcon((ImageIcon) pictureList.get(0));
        questionImage.setVerticalAlignment(SwingConstants.CENTER);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nextButtonPressed = new javax.swing.JLabel();
        nextButtonHighlighted = new javax.swing.JLabel();
        nextButton = new javax.swing.JLabel();
        inputField = new javax.swing.JTextField();
        inputTwo = new javax.swing.JButton();
        inputThree = new javax.swing.JButton();
        inputFour = new javax.swing.JButton();
        inputFive = new javax.swing.JButton();
        inputSix = new javax.swing.JButton();
        inputSeven = new javax.swing.JButton();
        inputEight = new javax.swing.JButton();
        inputNine = new javax.swing.JButton();
        inputClear = new javax.swing.JButton();
        inputOne = new javax.swing.JButton();
        inputZero = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        questionImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        nextButtonPressed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/nextButtonPressed.png"))); // NOI18N
        nextButtonPressed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextButtonPressedMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonPressedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonPressedMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonPressedMouseEntered(evt);
            }
        });
        nextButtonPressed.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                nextButtonPressedComponentShown(evt);
            }
        });
        getContentPane().add(nextButtonPressed);
        nextButtonPressed.setBounds(650, 490, 190, 29);

        nextButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/nextButtonHighlighted.png"))); // NOI18N
        nextButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nextButtonHighlightedMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonHighlightedMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonHighlightedMouseEntered(evt);
            }
        });
        getContentPane().add(nextButtonHighlighted);
        nextButtonHighlighted.setBounds(650, 490, 190, 29);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nextButton.png"))); // NOI18N
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
        });
        getContentPane().add(nextButton);
        nextButton.setBounds(650, 490, 190, 29);

        inputField.setBackground(new java.awt.Color(14, 102, 138));
        inputField.setFont(new java.awt.Font("URW Gothic L", 0, 17)); // NOI18N
        inputField.setForeground(new java.awt.Color(255, 255, 255));
        inputField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputField.setFocusable(false);
        getContentPane().add(inputField);
        inputField.setBounds(500, 110, 210, 50);

        inputTwo.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputTwo.setForeground(java.awt.Color.white);
        inputTwo.setText("2");
        inputTwo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTwoActionPerformed(evt);
            }
        });
        getContentPane().add(inputTwo);
        inputTwo.setBounds(570, 170, 70, 40);

        inputThree.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputThree.setForeground(java.awt.Color.white);
        inputThree.setText("3");
        inputThree.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputThreeActionPerformed(evt);
            }
        });
        getContentPane().add(inputThree);
        inputThree.setBounds(640, 170, 70, 40);

        inputFour.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputFour.setForeground(java.awt.Color.white);
        inputFour.setText("4");
        inputFour.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFourActionPerformed(evt);
            }
        });
        getContentPane().add(inputFour);
        inputFour.setBounds(500, 210, 70, 40);

        inputFive.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputFive.setForeground(java.awt.Color.white);
        inputFive.setText("5");
        inputFive.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFiveActionPerformed(evt);
            }
        });
        getContentPane().add(inputFive);
        inputFive.setBounds(570, 210, 70, 40);

        inputSix.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputSix.setForeground(java.awt.Color.white);
        inputSix.setText("6");
        inputSix.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSixActionPerformed(evt);
            }
        });
        getContentPane().add(inputSix);
        inputSix.setBounds(640, 210, 70, 40);

        inputSeven.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputSeven.setForeground(java.awt.Color.white);
        inputSeven.setText("7");
        inputSeven.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSevenActionPerformed(evt);
            }
        });
        getContentPane().add(inputSeven);
        inputSeven.setBounds(500, 250, 70, 40);

        inputEight.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputEight.setForeground(java.awt.Color.white);
        inputEight.setText("8");
        inputEight.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEightActionPerformed(evt);
            }
        });
        getContentPane().add(inputEight);
        inputEight.setBounds(570, 250, 70, 40);

        inputNine.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputNine.setForeground(java.awt.Color.white);
        inputNine.setText("9");
        inputNine.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNineActionPerformed(evt);
            }
        });
        getContentPane().add(inputNine);
        inputNine.setBounds(640, 250, 70, 40);

        inputClear.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputClear.setForeground(java.awt.Color.white);
        inputClear.setText("Clear");
        inputClear.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputClearActionPerformed(evt);
            }
        });
        getContentPane().add(inputClear);
        inputClear.setBounds(500, 330, 210, 40);

        inputOne.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputOne.setForeground(java.awt.Color.white);
        inputOne.setText("1");
        inputOne.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOneActionPerformed(evt);
            }
        });
        getContentPane().add(inputOne);
        inputOne.setBounds(500, 170, 70, 40);

        inputZero.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        inputZero.setForeground(java.awt.Color.white);
        inputZero.setText("0");
        inputZero.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inputZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputZeroActionPerformed(evt);
            }
        });
        getContentPane().add(inputZero);
        inputZero.setBounds(500, 290, 210, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 70, 230, 33);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/title.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 30, 170, 30);

        questionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BlindTest/1.jpg"))); // NOI18N
        getContentPane().add(questionImage);
        questionImage.setBounds(28, 120, 320, 310);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MinimizeButton.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(831, 0, 50, 20);

        jLabel2.setBackground(new java.awt.Color(3, 72, 83));
        jLabel2.setOpaque(true);
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 880, 20);

        jLabel6.setBackground(new java.awt.Color(17, 107, 121));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 370, 550);

        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 20, 510, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        // TODO add your handling code here:

        Point p = evt.getLocationOnScreen();
        this.setLocation(p);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setState(HomeForm.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void inputTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTwoActionPerformed
        // TODO add your handling code here:
        input += "2";
        inputField.setText(input);
    }//GEN-LAST:event_inputTwoActionPerformed

    private void inputOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOneActionPerformed
        // TODO add your handling code here:
        input += "1";
        inputField.setText(input);
    }//GEN-LAST:event_inputOneActionPerformed

    private void inputThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputThreeActionPerformed
        // TODO add your handling code here:
        input += "3";
        inputField.setText(input);
    }//GEN-LAST:event_inputThreeActionPerformed

    private void inputClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputClearActionPerformed
        // TODO add your handling code here:
        
        try{
            input = inputField.getText().toString().substring(0, input.length() - 1);
             inputField.setText(input);}
        catch(StringIndexOutOfBoundsException e){
        
            System.out.println("No more inputs to clear.");
        }
    }//GEN-LAST:event_inputClearActionPerformed

    private void inputFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFourActionPerformed
        // TODO add your handling code here:
         input += "4";
        inputField.setText(input);
    }//GEN-LAST:event_inputFourActionPerformed

    private void inputFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFiveActionPerformed
        // TODO add5your handling code here:
         input += "5";
        inputField.setText(input);
    }//GEN-LAST:event_inputFiveActionPerformed

    private void inputSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSixActionPerformed
        // TODO add your handling code here:
         input += "6";
        inputField.setText(input);
    }//GEN-LAST:event_inputSixActionPerformed

    private void inputSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSevenActionPerformed
        // TODO add your handling code here:
         input += "7";
        inputField.setText(input);
    }//GEN-LAST:event_inputSevenActionPerformed

    private void inputEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEightActionPerformed
        // TODO add your handling code here:
         input += "8";
        inputField.setText(input);
    }//GEN-LAST:event_inputEightActionPerformed

    private void inputNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNineActionPerformed
        // TODO add your handling code here:
         input += "9";
        inputField.setText(input);
    }//GEN-LAST:event_inputNineActionPerformed

    private void inputZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputZeroActionPerformed
        // TODO add your handling code here:
         input += "0";
        inputField.setText(input);
    }//GEN-LAST:event_inputZeroActionPerformed

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseEntered
        // TODO add your handling code here:
        nextButton.setVisible(false);
        nextButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_nextButtonMouseEntered

    private void nextButtonHighlightedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonHighlightedMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nextButtonHighlightedMouseEntered

    private void nextButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonHighlightedMouseExited
        // TODO add your handling code here:
        nextButtonHighlighted.setVisible(false);
        nextButton.setVisible(true);
    }//GEN-LAST:event_nextButtonHighlightedMouseExited

    private void nextButtonPressedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPressedMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonPressedMouseExited

    private void nextButtonPressedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPressedMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonPressedMouseEntered

    private void nextButtonHighlightedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonHighlightedMousePressed
        // TODO add your handling code here:
        nextButtonHighlighted.setVisible(false);
        nextButtonPressed.setVisible(true);
    }//GEN-LAST:event_nextButtonHighlightedMousePressed

    private void nextButtonPressedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPressedMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nextButtonPressedMouseReleased

    private void nextButtonPressedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonPressedMouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_nextButtonPressedMouseClicked

    private void nextButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonHighlightedMouseClicked
        // TODO add your handling code here:
        String currentQuestion, userAnswer, field;
        field = inputField.getText().toString();
        if(field.equals("")){
        JOptionPane.showMessageDialog(null, "Input required.");
        
        }
        else{
//        if(currentItemFinished < colorBlindImageResDuplicate.length){-
//        String currentQuestion = questionImage.getIcon().toString().substring(questionImage.getIcon().toString().indexOf("/Images")); -
//        int inputAnswer = Integer.valueOf(field);-
//        if(inputAnswer == test.get(currentQuestion)){-
//             totalPoints++;
//             input = "";
//             inputField.setText(input);
//        }
//        else{
//              input = "";
//             inputField.setText(input);
//        }
//        questionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//         colorBlindImageResDuplicate[currentItemFinished]
//        )));
//        
//        System.out.println(colorBlindImageResDuplicate[currentItemFinished] + " " + currentItemFinished + "/"+ String.valueOf(colorBlindImageResDuplicate.length));
//        currentItemFinished++;
//        }
//        else{
//             int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Finished. Score:"+ totalPoints +"/17 Proceed with the Acuity Test?", "Done", JOptionPane.YES_NO_OPTION);
//                if(confirmExitDialog == 0){
//                    AuditoryTestForm atf = new AuditoryTestForm();
//                    this.dispose();
//                    atf.setVisible(true);
//                }
//        }

     if(currentItemFinished < answersList.size()){
                  currentQuestion  = testForList.get(questionImage.getIcon()).toString();
                  userAnswer = inputField.getText().toString();
            if(userAnswer.equals(currentQuestion)){
                totalPoints++;
                    }
                input = "";
                inputField.setText(input);
                questionImage.setIcon((ImageIcon) pictureList.get(currentItemFinished));
                currentItemFinished++;
                System.out.println(String.valueOf(currentItemFinished) + " | " + String.valueOf(totalPoints));   
            }
             else{
                int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Finished. Score:"+ totalPoints + " / " + answersList.size() + " Proceed with the Acuity Test?", "Done", JOptionPane.YES_NO_OPTION);
                if(confirmExitDialog == 0){
                  AuditoryTestForm atf = new AuditoryTestForm();
                  this.dispose();
                  atf.setVisible(true);
                }
            }
        }
          
    }//GEN-LAST:event_nextButtonHighlightedMouseClicked

    private void nextButtonPressedComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_nextButtonPressedComponentShown
        // TODO add your handling code here:
         nextButtonPressed.setVisible(false);
        nextButton.setVisible(true);
    }//GEN-LAST:event_nextButtonPressedComponentShown

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nextButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ColorBlindTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorBlindTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorBlindTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorBlindTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorBlindTestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inputClear;
    private javax.swing.JButton inputEight;
    private javax.swing.JTextField inputField;
    private javax.swing.JButton inputFive;
    private javax.swing.JButton inputFour;
    private javax.swing.JButton inputNine;
    private javax.swing.JButton inputOne;
    private javax.swing.JButton inputSeven;
    private javax.swing.JButton inputSix;
    private javax.swing.JButton inputThree;
    private javax.swing.JButton inputTwo;
    private javax.swing.JButton inputZero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nextButton;
    private javax.swing.JLabel nextButtonHighlighted;
    private javax.swing.JLabel nextButtonPressed;
    private javax.swing.JLabel questionImage;
    // End of variables declaration//GEN-END:variables
}
