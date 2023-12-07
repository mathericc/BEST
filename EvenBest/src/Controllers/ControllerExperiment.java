/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Experiment;
import Views.ExperimentData;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author alunos
 */
public class ControllerExperiment {
    JDesktopPane desktopPane;
    JTextField JTExperiment;
    JTextField jTextFieldV0;
    JTextField jTMMAcid;
    JTextField jTPhCor;
    JTextField jTNOFB;
    JList jListExperiment;
    DefaultListModel m;
    int currId;
    Experiment experiment;

    public ControllerExperiment(JTextField JTExperiment, JTextField jTextFieldV0, JTextField jTMMAcid, JTextField jTPhCor, JTextField jtNOFB, JList jListExperiment, JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        this.JTExperiment = JTExperiment;
        this.jTextFieldV0 = jTextFieldV0;
        this.jTMMAcid = jTMMAcid;
        this.jTPhCor = jTPhCor;
        this.jTNOFB = jtNOFB;
        this.jListExperiment = jListExperiment;
        this.m = new DefaultListModel();
        this.currId = 0;
    }

    public JTextField getJTExperiment() {
        return JTExperiment;
    }

    public void setJTExperiment(JTextField JTExperiment) {
        this.JTExperiment = JTExperiment;
    }

    public JTextField getjTextFieldV0() {
        return jTextFieldV0;
    }

    public void setjTextFieldV0(JTextField jTextFieldV0) {
        this.jTextFieldV0 = jTextFieldV0;
    }

    public JTextField getjTMMAcid() {
        return jTMMAcid;
    }

    public void setjTMMAcid(JTextField jTMMAcid) {
        this.jTMMAcid = jTMMAcid;
    }

    public JTextField getjTPhCor() {
        return jTPhCor;
    }

    public void setjTPhCor(JTextField jTPhCor) {
        this.jTPhCor = jTPhCor;
    }

    public JTextField getJtNOFB() {
        return jTNOFB;
    }

    public void setJtNOFB(JTextField jtNOFB) {
        this.jTNOFB = jtNOFB;
    }
    
    
    public void GoToDataScreen(){
        if(jListExperiment.getSelectedIndex()> -1){
            GoToDataScreenLogic();
        }else{
            JOptionPane.showMessageDialog(null, "Pelamor, selecione um experimento antes de prosseguir!");
        }
    }
    
    public void GoToDataScreenLogic() {
        desktopPane.removeAll();
        desktopPane.updateUI();
        Dimension resolucao = desktopPane.getSize(); // Captura resoluçao do container
        var experiment = Experiment.listOfExperiments.get(jListExperiment.getSelectedIndex());
        ExperimentData t = new ExperimentData(experiment);
        t.setSize(resolucao);
        t.setLocation(0, 0);
        desktopPane.add(t);
        t.setVisible(true);
    }
    
    boolean validateNameInput() {
        return !this.JTExperiment.getText().equals("");
    }

    boolean validatePhInput() {
        float readValue;
        try {
            readValue = Float.parseFloat(this.jTPhCor.getText());
        } catch (Exception e) {
            return false;
        };

        return 14.0 >= readValue && readValue > 0.0;
    }

    boolean validateEverythingElse() {
        try {
            Float.parseFloat(this.jTPhCor.getText());
            Float.parseFloat(this.jTMMAcid.getText());
            Float.parseFloat(this.jTNOFB.getText());
            Float.parseFloat(this.jTextFieldV0.getText());
            
        } catch (Exception e) {
            return false;
        };
        return true;
    }

    public boolean makeExperimenteValidation(){
        if (!this.validateNameInput()) {
            JOptionPane.showMessageDialog(null, "Não deixe nenhum campo vazio!");
            return false;
        }
        if(!validateEverythingElse()){
            JOptionPane.showMessageDialog(null, "Verifique os números!\nTodo número decimal deve conter ser separado por ponto(.)!");
            return false;
        }
        if(!validatePhInput()){
            JOptionPane.showMessageDialog(null, "O PH deve ser um valor válido!");
            return false;
        }
        return true;
    }
    
    
    
    public void createExperiment() {
        if(makeExperimenteValidation()){
           String name = this.JTExperiment.getText();
           float vol = Float.parseFloat(this.jTextFieldV0.getText());
           float acid = Float.parseFloat(this.jTMMAcid.getText());
           float ph = Float.parseFloat(this.jTPhCor.getText());
           float nofb = Float.parseFloat(this.jTNOFB.getText());

           Experiment ex = new Experiment(this.currId, name, new Date());
           ex.setInitialVolume(vol);
           ex.setPhCorrection(ph);
           ex.setBaseConcentration(nofb);
           ex.setStrongAcidQuantity(acid);
           System.out.println(name);

           m.addElement(name+" - "+this.currId);

           this.currId++;
           this.jListExperiment.setModel(m);

           this.experiment = ex;   
           Experiment.listOfExperiments.add(ex);
        }
    }
    
    public void cleanDisplay() {
        this.JTExperiment.setText("");
        this.jTMMAcid.setText("");
        this.jTPhCor.setText("");
        this.jTextFieldV0.setText("");
        this.jTNOFB.setText("");
    }
    
    public void loadDataFromList(){
        int item = this.jListExperiment.getSelectedIndex();
        var selectedExperiment = Experiment.listOfExperiments.get(item);
        this.JTExperiment.setText(selectedExperiment.getName());
        this.jTMMAcid.setText(Float.toString(selectedExperiment.getStrongAcidQuantity()));
        this.jTPhCor.setText(Float.toString(selectedExperiment.getPhCorrection()));
        this.jTextFieldV0.setText(Float.toString(selectedExperiment.getInitialVolume()));
        this.jTNOFB.setText(Float.toString(selectedExperiment.getBaseConcentration()));
        
    }
    public void updateList(JList list, ArrayList data){
        DefaultListModel model = new DefaultListModel();
        for (var itr : data){
           String item =  itr.toString();
           model.addElement(item);
        }
        //this.m = model;
        list.setModel(model);
    }
    
    public void deleteExperiment(){
        int item = this.jListExperiment.getSelectedIndex();
        if(item>-1){
            m.remove(item);
        
            cleanDisplay();
        }else{
            JOptionPane.showMessageDialog(null, "É impossível deletar um objeto sem selecioná-lo antes, anta véia!");
        }
    }
}
