/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathericc
 */
public class Experiment {
    String name;
    Date date;
    
    float initialVolume;
    float baseConcentration;
    float StrongAcidQuantity;
    float phCorrection;
    
    
    ArrayList<Component> components;
    ArrayList<Float> concentrationGuess;
    ArrayList<Specie> species;
    ArrayList<Point> points;

    public Experiment(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getInitialVolume() {
        return initialVolume;
    }

    public void setInitialVolume(float initialVolume) {
        this.initialVolume = initialVolume;
    }

    public float getBaseConcentration() {
        return baseConcentration;
    }

    public void setBaseConcentration(float baseConcentration) {
        this.baseConcentration = baseConcentration;
    }

    public float getStrongAcidQuantity() {
        return StrongAcidQuantity;
    }

    public void setStrongAcidQuantity(float StrongAcidQuantity) {
        this.StrongAcidQuantity = StrongAcidQuantity;
    }

    public float getPhCorrection() {
        return phCorrection;
    }

    public void setPhCorrection(float phCorrection) {
        this.phCorrection = phCorrection;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Float> getConcentrationGuess() {
        return concentrationGuess;
    }

    public void setConcentrationGuess(ArrayList<Float> concentrationGuess) {
        this.concentrationGuess = concentrationGuess;
    }

    public ArrayList<Specie> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Specie> species) {
        this.species = species;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    
    
    
    
    
    
}
