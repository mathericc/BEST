/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author mathericc
 */
public class Point {
    float volumeBase; //in ml
    float ph;

    public Point(float volumeBase, float ph) {
        this.volumeBase = volumeBase;
        this.ph = ph;
    }
    
    @Override public String toString(){
        return "" + this.volumeBase + " - " + this.ph;
    }
    
    

    public float getVolumeBase() {
        return volumeBase;
    }

    public void setVolumeBase(float volumeBase) {
        this.volumeBase = volumeBase;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }
    
    
    
}
