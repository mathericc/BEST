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
    int id;
    String name;
    Date date;
    
    float initialVolume;
    float baseConcentration;
    float StrongAcidQuantity;
    float phCorrection;
    
    public static int Id = 0;
    public static ArrayList<Experiment> listOfExperiments = new ArrayList<>();
    
    ArrayList<Component> components = new ArrayList<>();
    ArrayList<Float> concentrationGuess = new ArrayList<>();
    ArrayList<Specie> species = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();

    public Experiment(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override public String toString(){
        String ex = "";
            
        ex += this.name + "\n";
        
        for (Component component : this.components){
            ex += component.name +" " + component.quantity + "\n"; 
        }
        ex += "\n";
        
        ex += "" + this.initialVolume + " " + this.baseConcentration + " " + this.StrongAcidQuantity + " " + this.phCorrection + "\n"; 
       
       
        
        for (int i = 0; i < this.species.size(); i++){
              ex += "" + this.species.get(i).toString() + "\n";
        }
        
        ex += "\n";
        
        ex += "" + this.points.get(0).toString() + " " + this.getConcentrationGuess().toString() + "\n";
        
        for (int i = 1; i < this.points.size(); i++){
              ex += "" + this.points.get(i).toString() + "\n";
        }
        
        
        return ex;
        
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
    
    public int getId() {
        return id;
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
    
    public void addComponent(Component component){
        this.components.add(component);
    }

    public ArrayList<Float> getConcentrationGuess() {
        return concentrationGuess;
    }

    public void setConcentrationGuess(ArrayList<Float> concentrationGuess) {
        this.concentrationGuess = concentrationGuess;
    }
    
    public void addConcentrationGuess(Float value){
        this.concentrationGuess.add(value);
    }

    public ArrayList<Specie> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Specie> species) {
        this.species = species;
    }
    
    public void addSpecie(Specie specie){
        this.species.add(specie);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    public void addPoint(Point point){
        this.points.add(point);
    }
    
    
    
    
    
    
    
}
