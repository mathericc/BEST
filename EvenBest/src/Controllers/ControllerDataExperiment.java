/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;


import Models.Experiment;
import Models.Point;
import Models.Specie;
import Views.ExperimentData;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.sound.midi.Soundbank;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author mathericc
 */
public class ControllerDataExperiment {
    Experiment experiment;
    JButton JBListLog;
    JButton JBSaaveComponent;
    JButton JButton1;
    JButton JButton2;
    JList<String> jListComponent;
    JList<String> jListSpecies;
    JList<String> jListPoints;
    JTextField jTComponentName;
    JTextField jTIS;
    JTextField jTLBETA;
    JTextField jTComponentQuantity;
    JTextField jTPH;
    JTextField jTRCC;
    JTextField jTVB;
    public ControllerDataExperiment(Experiment experiment, JButton JBListLog, JButton JBSaaveComponent, JButton JButton1, JButton JButton2, JList<String> jListComponent, JList<String> jListSpecies, JList<String> jListPoints, JTextField jTComponentName, JTextField jTIS, JTextField jTLBETA, JTextField jTMMC, JTextField jTPH, JTextField jTRCC, JTextField jTVB) {
        this.experiment = experiment;
        this.JBListLog = JBListLog;
        this.JBSaaveComponent = JBSaaveComponent;
        this.JButton1 = JButton1;
        this.JButton2 = JButton2;
        this.jListComponent = jListComponent;
        this.jListSpecies = jListSpecies;
        this.jListPoints = jListPoints;
        this.jTComponentName = jTComponentName;
        this.jTIS = jTIS;
        this.jTLBETA = jTLBETA;
        this.jTComponentQuantity = jTMMC;
        this.jTPH = jTPH;
        this.jTRCC = jTRCC;
        this.jTVB = jTVB;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public JButton getJBListLog() {
        return JBListLog;
    }

    public void setJBListLog(JButton JBListLog) {
        this.JBListLog = JBListLog;
    }

    public JButton getJBSaaveComponent() {
        return JBSaaveComponent;
    }

    public void setJBSaaveComponent(JButton JBSaaveComponent) {
        this.JBSaaveComponent = JBSaaveComponent;
    }

    public JButton getJButton1() {
        return JButton1;
    }

    public void setJButton1(JButton JButton1) {
        this.JButton1 = JButton1;
    }

    public JButton getJButton2() {
        return JButton2;
    }

    public void setJButton2(JButton JButton2) {
        this.JButton2 = JButton2;
    }

    public JList<String> getjListComponent() {
        return jListComponent;
    }

    public void setjListComponent(JList<String> jListComponent) {
        this.jListComponent = jListComponent;
    }

    public JList<String> getjListSpecies() {
        return jListSpecies;
    }

    public void setjListSpecies(JList<String> jListSpecies) {
        this.jListSpecies = jListSpecies;
    }

    public JList<String> getjListPoints() {
        return jListPoints;
    }

    public void setjListPoints(JList<String> jListPoints) {
        this.jListPoints = jListPoints;
    }

    public JTextField getjTComponentName() {
        return jTComponentName;
    }

    public void setjTComponentName(JTextField jTComponentName) {
        this.jTComponentName = jTComponentName;
    }

    public JTextField getjTIS() {
        return jTIS;
    }

    public void setjTIS(JTextField jTIS) {
        this.jTIS = jTIS;
    }

    public JTextField getjTLBETA() {
        return jTLBETA;
    }

    public void setjTLBETA(JTextField jTLBETA) {
        this.jTLBETA = jTLBETA;
    }

    public JTextField getjTMMC() {
        return jTComponentQuantity;
    }

    public void setjTMMC(JTextField jTMMC) {
        this.jTComponentQuantity = jTMMC;
    }

    public JTextField getjTPH() {
        return jTPH;
    }

    public void setjTPH(JTextField jTPH) {
        this.jTPH = jTPH;
    }

    public JTextField getjTRCC() {
        return jTRCC;
    }

    public void setjTRCC(JTextField jTRCC) {
        this.jTRCC = jTRCC;
    }

    public JTextField getjTVB() {
        return jTVB;
    }

    public void setjTVB(JTextField jTVB) {
        this.jTVB = jTVB;
    }
    
    //Limpa todos os textFields de um Panel
    public void cleanInput(Container container){
        for (Component component : container.getComponents()){
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
    }
    
    //TODO Validar os inputs
    
    public void updateList(JList list, ArrayList data){
        DefaultListModel model = new DefaultListModel();
        for (var itr : data){
           String item =  itr.toString();
           model.addElement(item);
        }
        list.setModel(model);
    }
    
    public void addComponent(){
        Models.Component component;
        String name = jTComponentName.getText();
        float quantity = Float.parseFloat(jTComponentQuantity.getText());
        
        component = new Models.Component(name, quantity);
        
        this.experiment.addComponent(component);
        updateList(jListComponent, this.experiment.getComponents());
    }
    
    public void addSpecie(){
        Specie specie;
        float logBeta = Float.parseFloat(jTLBETA.getText());
        String stoich = jTIS.getText();
        
        ArrayList<Float> stoichometrics = new ArrayList<>();
        String[] list = stoich.split(",");
        for (String value : list){
            stoichometrics.add(Float.parseFloat(value));
        }
        
        specie = new Specie(logBeta, stoichometrics);
        this.experiment.addSpecie(specie);
        updateList(jListSpecies, this.experiment.getSpecies());
    }
    
    public void addPoint(){
        Point point;
        float volumeBase = Float.parseFloat(jTVB.getText());
        float ph = Float.parseFloat(jTPH.getText());
        
        point = new Point(volumeBase, ph);
        
        this.experiment.addPoint(point);
        updateList(jListPoints, this.experiment.getPoints());
        
    }
    
    
    public void addGuessValues(){
        String[] list = jTRCC.getText().split(",");
        for (String value : list){
            this.experiment.addConcentrationGuess(Float.parseFloat(value));
        }
        System.out.println(this.experiment.toString());
    }
    
    
    public boolean validateComponent(){
        return true;
    }
    
    
    public <T> T MapFromListToArray(JList list, ArrayList<T> objectList){
        int selectedIndex = list.getSelectedIndex();
        var selectedObject = objectList.get(selectedIndex);
        return selectedObject;
    }
    
   
    
    public void loadComponendData(){
        Models.Component selectedComponent = MapFromListToArray(jListComponent, this.experiment.getComponents());
        this.jTComponentName.setText(selectedComponent.getName());
        this.jTComponentQuantity.setText("" +selectedComponent.getQuantity());
        
    }
    
    public void deleteComponent(){
        int selectedIndex = this.jListComponent.getSelectedIndex();
        this.experiment.getComponents().remove(selectedIndex);
        this.updateList(jListComponent, this.experiment.getComponents());
    }
    
     public void loadSpecieData(){
        Specie selectedSpecie = MapFromListToArray(jListSpecies, this.experiment.getSpecies());
        this.jTLBETA.setText(""+ selectedSpecie.getLogBeta());
        this.jTIS.setText("" +selectedSpecie.getStoichiometrics());
        
    }
    
    public void deleteSpecie(){
        int selectedIndex = this.jListSpecies.getSelectedIndex();
        this.experiment.getSpecies().remove(selectedIndex);
        this.updateList(jListSpecies, this.experiment.getSpecies());
    }
    
     public void loadPointsData(){
        Point selectedPoint = MapFromListToArray(jListPoints, this.experiment.getPoints());
        this.jTVB.setText("" + selectedPoint.getVolumeBase());
        this.jTPH.setText("" + selectedPoint.getPh());
        
    }
    
    public void deletePoint(){
        int selectedIndex = this.jListPoints.getSelectedIndex();
        this.experiment.getPoints().remove(selectedIndex);
        this.updateList(jListPoints, this.experiment.getPoints());
    }

    public void goToExperiments(JDesktopPane desktopPane) {
        desktopPane.removeAll();
        desktopPane.updateUI();
        Dimension resolucao = desktopPane.getSize(); // Captura resoluçao do container
        Views.ExperimentPanel t = new Views.ExperimentPanel();
        t.setSize(resolucao);
        t.setLocation(0, 0);
        desktopPane.add(t);
        t.setVisible(true);
    }
    
       
    
}
