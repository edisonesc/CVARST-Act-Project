/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Tests;

import com.sun.media.BasicPlayer;
import com.sun.media.MediaPlayer;
import java.awt.Color;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javazoom.jl.player.Player;
import project.VolumeController.Audio;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author edison
 */
public class AuditoryTestForm extends javax.swing.JFrame {

    /**
     * Creates new form AuditoryTestForm
     */
    long total_length;
    long pause;
    FileInputStream FIS;
    BufferedInputStream BIS;
    Player player;
    File myFile;
    MediaPlayer mp;
    Media me;
    private String currentAudioPlaying;
    private Map<Object, Object> content;
    private Float masterVolume;
    private int currentItemFinished = 0, totalPoints = 0;
    private ArrayList questionAudios = new ArrayList(), questionNames = new ArrayList();
    private Connection cn;
    private PreparedStatement ps;
    private Statement st;
    public AuditoryTestForm() {
        initComponents();
        setSize(875, 551);
        setResizable(false);
        this.setBackground(new Color(23, 23,23 ,150));
        jLabel4.setBackground(new Color(23, 23,23));
        audioName.setHorizontalAlignment(SwingConstants.CENTER);
        content = new HashMap<Object, Object>();
        JButton inputButtons[] = {buttonPlay,buttonStop};
              for (int i=0; i < inputButtons.length; i++){
            inputButtons[i].setOpaque(false);
            inputButtons[i].setContentAreaFilled(false);
            inputButtons[i].setBorderPainted(true);
        }
          hPlay.setVisible(false);
          hStop.setVisible(false);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvarst?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.createStatement();
            String getData = "SELECT * FROM cvarst.AuditoryTest";
            ResultSet rs = st.executeQuery(getData);
            while(rs.next()){
                
                questionAudios.add(rs.getString("AudioPath"));
                questionNames.add(rs.getString("AudioName"));
            }
           
        }
        catch(Exception e){
        e.printStackTrace();
        }
        for (int i = 0; i < questionAudios.size(); i++){
        content.put(questionNames.get(i), questionAudios.get(i));
        System.out.println(String.valueOf(questionNames.get(i)) + " " + questionAudios.get(i));
        }
        System.out.println(questionAudios.get(0) + " | " +  questionNames.get(0));
        audioName.setText(String.valueOf(questionNames.get(0)));
        currentAudioPlaying = String.valueOf(questionAudios.get(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionImage = new javax.swing.JLabel();
        yesButton = new javax.swing.JLabel();
        noButton = new javax.swing.JLabel();
        volume = new javax.swing.JSlider();
        hPlay = new javax.swing.JLabel();
        hStop = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        audioName = new javax.swing.JLabel();
        buttonPlay = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        questionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/headphone.png"))); // NOI18N
        getContentPane().add(questionImage);
        questionImage.setBounds(60, 130, 250, 270);

        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yes_button.png"))); // NOI18N
        yesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                yesButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yesButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yesButtonMouseEntered(evt);
            }
        });
        getContentPane().add(yesButton);
        yesButton.setBounds(410, 500, 190, 30);

        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_button.png"))); // NOI18N
        noButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                noButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                noButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                noButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                noButtonMouseEntered(evt);
            }
        });
        getContentPane().add(noButton);
        noButton.setBounds(660, 500, 190, 30);

        volume.setForeground(java.awt.Color.white);
        volume.setMajorTickSpacing(10);
        volume.setMaximum(99);
        volume.setOrientation(javax.swing.JSlider.VERTICAL);
        volume.setPaintLabels(true);
        volume.setPaintTicks(true);
        volume.setValue(40);
        volume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeStateChanged(evt);
            }
        });
        getContentPane().add(volume);
        volume.setBounds(730, 130, 70, 160);

        hPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/highlighted.png"))); // NOI18N
        getContentPane().add(hPlay);
        hPlay.setBounds(510, 380, 100, 40);

        hStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Secondary_Images/highlighted.png"))); // NOI18N
        getContentPane().add(hStop);
        hStop.setBounds(620, 380, 100, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/questionDisplay.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 70, 230, 33);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/title.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 30, 170, 30);

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

        audioName.setFont(new java.awt.Font("Ubuntu Light", 0, 20)); // NOI18N
        audioName.setForeground(java.awt.Color.white);
        audioName.setText("Audio");
        getContentPane().add(audioName);
        audioName.setBounds(510, 300, 210, 24);

        buttonPlay.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        buttonPlay.setForeground(java.awt.Color.white);
        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/play_button.png"))); // NOI18N
        buttonPlay.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        buttonPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPlayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonPlayMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPlayMouseClicked(evt);
            }
        });
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlay);
        buttonPlay.setBounds(510, 380, 100, 40);

        buttonStop.setFont(new java.awt.Font("Ubuntu Condensed", 0, 15)); // NOI18N
        buttonStop.setForeground(java.awt.Color.white);
        buttonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/stop_button.png"))); // NOI18N
        buttonStop.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        buttonStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonStopMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonStopMouseReleased(evt);
            }
        });
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });
        getContentPane().add(buttonStop);
        buttonStop.setBounds(620, 380, 100, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AuditoryTest/left_ear.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(510, 100, 210, 190);

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Volume");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(740, 100, 70, 20);

        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(370, 20, 510, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        // TODO add your handling code here:

        Point p = evt.getLocationOnScreen();
        this.setLocation(p);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setState(AuditoryTestForm.ICONIFIED);
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        // TODO add your handling code here:
 
//        masterVolume = Float.valueOf("0." + String.valueOf(volume.getValue()));
//        Audio.setMasterOutputVolume();
        InputStream in;
        try{
//            in = new FileInputStream(new File (getClass().getResource("/Audio/6th.mp4.wav").getPath()));
//            
//            AudioStream audioStream = new AudioStream(in);
//            AudioPlayer.player.start(audioStream);
             
            FIS = new FileInputStream(currentAudioPlaying);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            total_length = FIS.available();
            System.out.print(getClass().getResource("/Audio/lostwithoutyou.mp3").getPath() + " | " + currentAudioPlaying);
            new Thread(){
            
                public void run(){
                try{
                    player.play();
                }
                catch(Exception e){
                e.printStackTrace();
                }
                }
            }.start();
      
             buttonPlay.setEnabled(false);
             buttonStop.setEnabled(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_buttonPlayActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        // TODO add your handling code here:
        if(player != null){
        
        player.close();
        buttonPlay.setEnabled(true);
        buttonStop.setEnabled(false);
        
                }
    
    }//GEN-LAST:event_buttonStopActionPerformed

    private void buttonPlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlayMousePressed
        // TODO add your handling code here:
        hPlay.setVisible(true);
    }//GEN-LAST:event_buttonPlayMousePressed

    private void buttonPlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlayMouseReleased
        // TODO add your handling code here:
        hPlay.setVisible(false);
    }//GEN-LAST:event_buttonPlayMouseReleased

    private void buttonStopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStopMousePressed
        // TODO add your handling code here:
          hStop.setVisible(true);
    }//GEN-LAST:event_buttonStopMousePressed

    private void buttonStopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStopMouseReleased
        // TODO add your handling code here:
          hStop.setVisible(false);
    }//GEN-LAST:event_buttonStopMouseReleased

    private void buttonPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPlayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPlayMouseClicked

    private void volumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeStateChanged
        // TODO add your handling code here:
        masterVolume = Float.valueOf("0." + String.valueOf(volume.getValue()));
//        masterVolume = Float.valueOf(volume.getValue() / 100);
        Audio.setMasterOutputVolume(masterVolume);
        audioName.setText(String.valueOf(masterVolume));
    }//GEN-LAST:event_volumeStateChanged

    private void yesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseEntered
        // TODO add your handling code here:
          yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yes_button_highlighted.png")));
    }//GEN-LAST:event_yesButtonMouseEntered

    private void yesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseExited
        // TODO add your handling code here:
          yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yes_button.png")));
    }//GEN-LAST:event_yesButtonMouseExited

    private void yesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMousePressed
        // TODO add your handling code here:
        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yes_button.png")));
    }//GEN-LAST:event_yesButtonMousePressed

    private void yesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseReleased
        // TODO add your handling code here:
        yesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yes_button_highlighted.png")));
    }//GEN-LAST:event_yesButtonMouseReleased

    private void noButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseEntered
            noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_button_highlighted.png")));
    }//GEN-LAST:event_noButtonMouseEntered

    private void noButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseExited
        // TODO add your handling code here:
        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_button.png")));
    }//GEN-LAST:event_noButtonMouseExited

    private void noButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMousePressed
        // TODO add your handling code here:
        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_button.png")));
    }//GEN-LAST:event_noButtonMousePressed

    private void noButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseReleased
        // TODO add your handling code here:
        noButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_button_highlighted.png")));
    }//GEN-LAST:event_noButtonMouseReleased

    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseClicked
        // TODO add your handling code here:
     if(currentItemFinished < questionAudios.size()){
            currentAudioPlaying = String.valueOf(questionAudios.get(currentItemFinished));
            audioName.setText(String.valueOf(questionNames.get(currentItemFinished)));
            totalPoints++;
            currentItemFinished++;
    
        }
        else{
            JOptionPane.showMessageDialog(null, "Done. Total Points: " + String.valueOf(totalPoints));
        }
       if(player != null){
        player.close();
        buttonPlay.setEnabled(true);
        buttonStop.setEnabled(false); }
    }//GEN-LAST:event_yesButtonMouseClicked

    private void noButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseClicked
        // TODO add your handling code here:
        if(currentItemFinished < questionAudios.size()){

            
            currentAudioPlaying = String.valueOf(questionAudios.get(currentItemFinished));
            audioName.setText(String.valueOf(questionNames.get(currentItemFinished)));
            currentItemFinished++;
        }
        else{
            JOptionPane.showMessageDialog(null, "Done. Total Points: " + String.valueOf(totalPoints));
        }
        if(player != null){
            player.close();
            buttonPlay.setEnabled(true);
            buttonStop.setEnabled(false);}
    }//GEN-LAST:event_noButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AuditoryTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuditoryTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuditoryTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuditoryTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuditoryTestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel audioName;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonStop;
    private javax.swing.JLabel hPlay;
    private javax.swing.JLabel hStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel noButton;
    private javax.swing.JLabel questionImage;
    private javax.swing.JSlider volume;
    private javax.swing.JLabel yesButton;
    // End of variables declaration//GEN-END:variables
}
