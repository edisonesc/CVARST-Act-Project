/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author edison
 */




public class HomeForm extends javax.swing.JFrame {

    /**
     * Creates new form HomeForm
     */
    int day, month, year;
    int second, minute, hour;
    public HomeForm() {
        initComponents();
        setSize(875, 551);
        setResizable(false);
        startButtonHighlighted.setVisible(false);
        clearanceButtonHighlighted.setVisible(false);
        registrationButtonHighlighted.setVisible(false);
        maintainanceButtonHighlighted.setVisible(false);
        logoffButtonHighlighted.setVisible(false);
        exitButtonHighlighted.setVisible(false);
        
        nameText.setHorizontalAlignment(SwingConstants.CENTER);
        
        
       
       
       Thread clock = new Thread(){
           public void run(){
           for(;;){
            
        Calendar cal = Calendar.getInstance();
        GregorianCalendar gc = new GregorianCalendar();
        day = gc.get(Calendar.DAY_OF_MONTH);
        month = gc.get(Calendar.MONTH);
        year = gc.get(Calendar.YEAR);
        second = gc.get(Calendar.SECOND);
        minute = gc.get(Calendar.MINUTE);
        hour = gc.get(Calendar.HOUR);
   
        currDate.setText(new SimpleDateFormat("MMM").format(cal.getTime()) + " " + day + ", " + year);
        currTime.setText(hour + ":" + minute + ":" + second + " "  + new SimpleDateFormat("a").format(cal.getTime()));
               try {
                   sleep(1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           }
       
       };
       
       clock.start();
       
     
  
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        balanceText1 = new javax.swing.JLabel();
        residencyText = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currTime = new javax.swing.JLabel();
        currDate = new javax.swing.JLabel();
        registrationButtonHighlighted = new javax.swing.JLabel();
        exitButtonHighlighted = new javax.swing.JLabel();
        logoffButtonHighlighted = new javax.swing.JLabel();
        maintainanceButtonHighlighted = new javax.swing.JLabel();
        startButtonHighlighted = new javax.swing.JLabel();
        clearanceButtonHighlighted = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        logoffButton = new javax.swing.JLabel();
        maintainanceButton = new javax.swing.JLabel();
        registrationButton = new javax.swing.JLabel();
        clearanceButton = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.darkGray);
        setForeground(java.awt.Color.black);
        setUndecorated(true);
        getContentPane().setLayout(null);

        balanceText1.setForeground(java.awt.Color.white);
        balanceText1.setText("97");
        getContentPane().add(balanceText1);
        balanceText1.setBounds(30, 466, 110, 13);

        residencyText.setForeground(java.awt.Color.white);
        residencyText.setText("Bagong Clinic");
        getContentPane().add(residencyText);
        residencyText.setBounds(30, 483, 110, 17);

        nameText.setFont(new java.awt.Font("Ubuntu Light", 0, 17)); // NOI18N
        nameText.setForeground(java.awt.Color.white);
        nameText.setText("Dr. Shaw Fred");
        getContentPane().add(nameText);
        nameText.setBounds(10, 170, 170, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MinimizeButton.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(830, 0, 50, 20);

        currTime.setForeground(java.awt.Color.white);
        currTime.setText("7:35:29 pm");
        getContentPane().add(currTime);
        currTime.setBounds(30, 520, 110, 18);

        currDate.setForeground(java.awt.Color.white);
        currDate.setText("Aug 10, 2018");
        getContentPane().add(currDate);
        currDate.setBounds(30, 500, 110, 18);

        registrationButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/registrationButton.png"))); // NOI18N
        registrationButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrationButtonHighlightedMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrationButtonHighlightedMouseEntered(evt);
            }
        });
        getContentPane().add(registrationButtonHighlighted);
        registrationButtonHighlighted.setBounds(660, 100, 174, 170);

        exitButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/exitButton.png"))); // NOI18N
        exitButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonHighlightedMouseExited(evt);
            }
        });
        getContentPane().add(exitButtonHighlighted);
        exitButtonHighlighted.setBounds(660, 300, 174, 170);

        logoffButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/logoffButton.png"))); // NOI18N
        logoffButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoffButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoffButtonHighlightedMouseExited(evt);
            }
        });
        getContentPane().add(logoffButtonHighlighted);
        logoffButtonHighlighted.setBounds(450, 300, 174, 170);

        maintainanceButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/maintenanceButton.png"))); // NOI18N
        maintainanceButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintainanceButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maintainanceButtonHighlightedMouseExited(evt);
            }
        });
        getContentPane().add(maintainanceButtonHighlighted);
        maintainanceButtonHighlighted.setBounds(240, 300, 174, 170);

        startButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/startButton.png"))); // NOI18N
        startButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButtonHighlightedMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButtonHighlightedMouseEntered(evt);
            }
        });
        getContentPane().add(startButtonHighlighted);
        startButtonHighlighted.setBounds(240, 100, 174, 170);

        clearanceButtonHighlighted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/clearanceButton.png"))); // NOI18N
        clearanceButtonHighlighted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearanceButtonHighlightedMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearanceButtonHighlightedMouseExited(evt);
            }
        });
        getContentPane().add(clearanceButtonHighlighted);
        clearanceButtonHighlighted.setBounds(450, 100, 174, 170);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exitButton.png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(660, 300, 174, 170);

        logoffButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logOffButton.png"))); // NOI18N
        logoffButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoffButtonMouseEntered(evt);
            }
        });
        getContentPane().add(logoffButton);
        logoffButton.setBounds(450, 300, 174, 170);

        maintainanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maintenanceButton.png"))); // NOI18N
        maintainanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maintainanceButtonMouseEntered(evt);
            }
        });
        getContentPane().add(maintainanceButton);
        maintainanceButton.setBounds(240, 300, 174, 170);

        registrationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrationButton.png"))); // NOI18N
        registrationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrationButtonMouseEntered(evt);
            }
        });
        getContentPane().add(registrationButton);
        registrationButton.setBounds(660, 100, 174, 170);

        clearanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clearanceButton.png"))); // NOI18N
        clearanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearanceButtonMouseEntered(evt);
            }
        });
        getContentPane().add(clearanceButton);
        clearanceButton.setBounds(450, 100, 174, 170);

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/startButton.png"))); // NOI18N
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButtonMouseEntered(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(240, 100, 174, 170);

        jLabel1.setBackground(new java.awt.Color(3, 72, 83));
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background-mark2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 20, 880, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonHighlightedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonHighlightedMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_startButtonHighlightedMouseEntered

    private void startButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseEntered
        // TODO add your handling code here:
                startButton.setVisible(false);
        startButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_startButtonMouseEntered

    private void startButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseExited
        // TODO add your handling code here:
             
    }//GEN-LAST:event_startButtonMouseExited

    private void startButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonHighlightedMouseExited
        // TODO add your handling code here:
           startButtonHighlighted.setVisible(false);
        startButton.setVisible(true);
    }//GEN-LAST:event_startButtonHighlightedMouseExited

    private void clearanceButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearanceButtonMouseEntered
        // TODO add your handling code here:
                clearanceButton.setVisible(false);
        clearanceButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_clearanceButtonMouseEntered

    private void clearanceButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearanceButtonHighlightedMouseExited
        // TODO add your handling code here:
            clearanceButtonHighlighted.setVisible(false);
        clearanceButton.setVisible(true);
    }//GEN-LAST:event_clearanceButtonHighlightedMouseExited

    private void registrationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseEntered
        // TODO add your handling code here:
        registrationButton.setVisible(false);
        registrationButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_registrationButtonMouseEntered

    private void registrationButtonHighlightedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonHighlightedMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registrationButtonHighlightedMouseEntered

    private void registrationButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonHighlightedMouseExited
        // TODO add your handling code here:
                registrationButtonHighlighted.setVisible(false);
        registrationButton.setVisible(true);
    }//GEN-LAST:event_registrationButtonHighlightedMouseExited

    private void maintainanceButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintainanceButtonMouseEntered
        // TODO add your handling code here:
        maintainanceButton.setVisible(false);
        maintainanceButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_maintainanceButtonMouseEntered

    private void maintainanceButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintainanceButtonHighlightedMouseExited
        // TODO add your handling code here:
        maintainanceButtonHighlighted.setVisible(false);
        maintainanceButton.setVisible(true);
    }//GEN-LAST:event_maintainanceButtonHighlightedMouseExited

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
        exitButton.setVisible(false);
        exitButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonHighlightedMouseExited
        // TODO add your handling code here:
        exitButtonHighlighted.setVisible(false);
        exitButton.setVisible(true);
    }//GEN-LAST:event_exitButtonHighlightedMouseExited

    private void logoffButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffButtonMouseEntered
        // TODO add your handling code here:
        logoffButton.setVisible(false);
        logoffButtonHighlighted.setVisible(true);
    }//GEN-LAST:event_logoffButtonMouseEntered

    private void logoffButtonHighlightedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffButtonHighlightedMouseExited
        // TODO add your handling code here:
         logoffButtonHighlighted.setVisible(false);
        logoffButton.setVisible(true);
    }//GEN-LAST:event_logoffButtonHighlightedMouseExited

    private void exitButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonHighlightedMouseClicked
        // TODO add your handling code here:
//        JOptionPane.showConfirmDialog(null, "Do you want to exit?", JOptionPane.YES_NO_OPTION);
       int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
       if(confirmExitDialog == 0){
           System.exit(0);
       }
      
    }//GEN-LAST:event_exitButtonHighlightedMouseClicked

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
        
         Point p = evt.getLocationOnScreen();
        this.setLocation(p);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setState(HomeForm.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void logoffButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffButtonHighlightedMouseClicked
        // TODO add your handling code here:
       int confirmExitDialog = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
       if(confirmExitDialog == 0){
          LoginForm lf = new LoginForm();
          this.dispose();
          lf.setVisible(true);
       }
    }//GEN-LAST:event_logoffButtonHighlightedMouseClicked

    private void registrationButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonHighlightedMouseClicked
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_registrationButtonHighlightedMouseClicked

    private void clearanceButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearanceButtonHighlightedMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_clearanceButtonHighlightedMouseClicked

    private void maintainanceButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintainanceButtonHighlightedMouseClicked
        // TODO add your handling code here:
        MaintainanceForm mf = new MaintainanceForm();
        
        this.setVisible(false);
        mf.setVisible(true);
    }//GEN-LAST:event_maintainanceButtonHighlightedMouseClicked

    private void startButtonHighlightedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonHighlightedMouseClicked
       // TODO add your handling code here:
         RegistrationForm rf = new RegistrationForm();
        this.setVisible(false);
        rf.setVisible(true);
    }//GEN-LAST:event_startButtonHighlightedMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceText1;
    private javax.swing.JLabel clearanceButton;
    private javax.swing.JLabel clearanceButtonHighlighted;
    private javax.swing.JLabel currDate;
    private javax.swing.JLabel currTime;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel exitButtonHighlighted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logoffButton;
    private javax.swing.JLabel logoffButtonHighlighted;
    private javax.swing.JLabel maintainanceButton;
    private javax.swing.JLabel maintainanceButtonHighlighted;
    private javax.swing.JLabel nameText;
    private javax.swing.JLabel registrationButton;
    private javax.swing.JLabel registrationButtonHighlighted;
    private javax.swing.JLabel residencyText;
    private javax.swing.JLabel startButton;
    private javax.swing.JLabel startButtonHighlighted;
    // End of variables declaration//GEN-END:variables
}




