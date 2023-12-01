/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Experiment;
import Views.ExperimentData;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JList;

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
    
    
    public void GoToDataScreen() {
        desktopPane.removeAll();
        desktopPane.updateUI();
        Dimension resolucao = desktopPane.getSize(); // Captura resoluçao do container
        ExperimentData t = new ExperimentData();
        t.setSize(resolucao);
        t.setLocation(0, 0);
        desktopPane.add(t);
        t.setVisible(true);
    }

    void cleanDisplay() {
        this.JTExperiment.setText("");
        this.jTMMAcid.setText("");
        this.jTPhCor.setText("");
        this.jTextFieldV0.setText("");
        this.jTNOFB.setText("");
    }

    boolean validateNameInput() {
        return !this.JTExperiment.equals("");
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
            var readValue = Float.parseFloat(this.jTPhCor.getText());
        } catch (Exception e) {
            return false;
        };
        return true;
    }

    public Experiment createExperiment() {
        try {
            if (this.validateEverythingElse() &&
            this.validateNameInput() &&
            this.validatePhInput()) {
            };
        } catch(Exception e) {
            e.printStackTrace();
        }
        

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
        
    
        m.add(currId,name+" - "+this.currId);
   
        this.currId++;
        this.jListExperiment.setModel(m);
        
        return ex;
    }
}
