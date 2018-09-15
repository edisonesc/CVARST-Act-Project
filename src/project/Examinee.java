/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author edison
 */
public class Examinee {
    private static int examineeID,
            colorblindTotalPoints,
            colorblindExamineePoints,
            auditoryTotalPoints,
            auditoryExamineePoints,
            visualBailyLovieTotalPoints,
            visualBailyLovieExamineePoints,
            visualSnellenTotalPoints,
            visualSnellenExamineePoints
            ;
    public static int getExamineeID() {
        return examineeID;
    }
    public static int getColorBlindTotalPoints(){
        return colorblindTotalPoints;
    }
    public static int getColorBlindExamineePoints(){
        return colorblindExamineePoints;
    }
    public static int getAuditoryTotalPoints(){
        return auditoryTotalPoints;
    }
    public static int getAuditoryExamineePoints(){
        return auditoryExamineePoints;
    }
    public static int getVisualSnellenExamineePoints(){
        return visualSnellenExamineePoints;
    }
    public static int getVisualSnellenTotalPoints(){
        return visualSnellenTotalPoints;
    }
    public static int getVisualBailyTotalPoints(){
    
        return visualBailyLovieTotalPoints;
    }
    public static int getVisualBailyExamineePoints(){
        return visualBailyLovieExamineePoints;
    }
    
    
    
    public void setUserID(int id){
        this.examineeID = id;
    }
    public  void setColorblindTotalPoints( int points){
        this.colorblindTotalPoints = points;
    }
    public  void setColorblindExamineePoints(int points){
        this.colorblindExamineePoints = points;
    }
    public void setAuditoryTotalPoints(int points){
        this.auditoryTotalPoints = points;
    }
    
    public void setAuditoryExamineePoints(int points){
        this.auditoryExamineePoints = points;
    }
    public void setVisualSnellenExamineePoints(int points){
        this.visualSnellenExamineePoints = points;
    }
    public void setVisualSnellenTotalPoints(int points){
        this.visualSnellenTotalPoints = points;
    }
    public void setVisualBailyExamineePoints(int points){
        this.visualBailyLovieExamineePoints = points;
    }
    public void setVisualBailyTotalPoints(int points){
        this.visualBailyLovieTotalPoints = points;
    
    }
    
    
}
