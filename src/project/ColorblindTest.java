/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

/**
 *
 * @author edison
 */
@Entity
@Table(name = "ColorblindTest", catalog = "cvarst", schema = "")
@NamedQueries({
    @NamedQuery(name = "ColorblindTest.findAll", query = "SELECT c FROM ColorblindTest c")
    , @NamedQuery(name = "ColorblindTest.findById", query = "SELECT c FROM ColorblindTest c WHERE c.id = :id")
//    , @NamedQuery(name = "ColorblindTest.findByQuestion", query = "SELECT c FROM ColorblindTest c WHERE c.question = :question")
    , @NamedQuery(name = "ColorblindTest.findByAnswer", query = "SELECT c FROM ColorblindTest c WHERE c.answer = :answer")
//    , @NamedQuery(name = "ColorblindTest.findByVision", query = "SELECT c FROM ColorblindTest c WHERE c.vision = :vision")


})
public class ColorblindTest implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Picture")
    private byte[] picture;
//    @Basic(optional = false)
//    @Column(name = "Question")
//    private String question;
    @Basic(optional = false)
    @Column(name = "Answer")
    private String answer;
//    @Basic(optional = false)
//    @Column(name = "Vision")
//    private String vision;

    public ColorblindTest() {
    }

    public ColorblindTest(Integer id) {
        this.id = id;
    }

    public ColorblindTest(Integer id, byte[] picture, String question, String answer, String vision) {
        this.id = id;
        this.picture = picture;
//        this.question = question;
        this.answer = answer;
//        this.vision = vision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public byte[] getPicture() {
        return picture;
    }
    
    

    public ImageIcon getImage() throws IOException{

//        
        ImageIcon icon = new ImageIcon(picture);
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 250, 250, null);
        ImageIcon result = new ImageIcon(bi);
        
        return result;
        
    }
    /////////////////////////////////////////
    public ImageIcon getImage(byte[] picture) throws IOException{ ////////////////
        
//        
        ImageIcon icon = new ImageIcon(this.picture);
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 250, 250, null);
        ImageIcon result = new ImageIcon(bi);
        
        return result;
      ///////////////////////////////////  
    }
    
    
    public void setPicture(byte[] picture) {
        byte[] oldPicture = this.picture;
        this.picture = picture;
        changeSupport.firePropertyChange("picture", oldPicture, picture);
    }

//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        String oldQuestion = this.question;
//        this.question = question;
//        changeSupport.firePropertyChange("question", oldQuestion, question);
//    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        String oldAnswer = this.answer;
        this.answer = answer;
        changeSupport.firePropertyChange("answer", oldAnswer, answer);
    }

//    public String getVision() {
//        return vision;
//    }
//
//    public void setVision(String vision) {
//        String oldVision = this.vision;
//        this.vision = vision;
//        changeSupport.firePropertyChange("vision", oldVision, vision);
//    }

    private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorblindTest)) {
            return false;
        }
        ColorblindTest other = (ColorblindTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project.ColorblindTest[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
