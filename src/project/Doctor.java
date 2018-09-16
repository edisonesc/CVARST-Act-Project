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
public class Doctor {
    private static String doctor;
    private static int doctorID;
    
    public static String getDoctor(){
        return doctor;
    }
    public void setDoctor(String doctor){
    this.doctor = doctor;
    }
    public static int getDoctorID(){
        return doctorID;
    }
    public void setDoctorID(int id){
        this.doctorID = id;
    }
}
