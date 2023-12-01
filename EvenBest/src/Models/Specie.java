/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author mathericc
 */
public class Specie {
    float logBeta;
    ArrayList<Float> stoichiometrics;

    public Specie(float logBeta, ArrayList<Float> stoichiometrics) {
        this.logBeta = logBeta;
        this.stoichiometrics = stoichiometrics;
    }
    
    @Override public String toString() {
        String stoichValues= "(";
        
        for (Float value: this.stoichiometrics){
            stoichValues += String.valueOf(value) + ", ";
        }
        stoichValues += ")";
        
        return "" + this.logBeta + " - " + stoichValues;
    }

    public float getLogBeta() {
        return logBeta;
    }

    public void setLogBeta(float logBeta) {
        this.logBeta = logBeta;
    }

    public ArrayList<Float> getStoichiometrics() {
        return stoichiometrics;
    }

    public void setStoichiometrics(ArrayList<Float> stoichiometrics) {
        this.stoichiometrics = stoichiometrics;
    }
    
    public void addSToichiomentric(Float value){
        this.stoichiometrics.add(value);
    }
    
    

    
    
    
    
    
}
