/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Experiment;
import Views.ExperimentData;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author alunos
 */
public class ControllerExperiment {

    JTextField JTExperiment;
    JTextField jTextFieldV0;
    JTextField jTMMAcid;
    JTextField jTPhCor;
    JTextField jTNOFB;
    public static JList jListExperiment;
    DefaultListModel m;
    int currId;
    Experiment experiment;

    public ControllerExperiment() {
    }

    public ControllerExperiment(JTextField JTExperiment, JTextField jTextFieldV0, JTextField jTMMAcid, JTextField jTPhCor, JTextField jtNOFB, JList jListExperiment) {
        this.JTExperiment = JTExperiment;
        this.jTextFieldV0 = jTextFieldV0;
        this.jTMMAcid = jTMMAcid;
        this.jTPhCor = jTPhCor;
        this.jTNOFB = jtNOFB;
        this.m = new DefaultListModel();
        this.jListExperiment = jListExperiment;
        this.currId = 0;
    }

    public void deserialization() {
        if (Experiment.listOfExperiments.size() > 0) return;
        // Serialization 
        try {
            //Saving of object in a file
            FileInputStream file = new FileInputStream("./experiments");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for serialization of object
            Experiment obj = null;
            while ((obj = (Experiment)in.readObject()) != null) {
            //do something with object  
                Experiment.listOfExperiments.add(obj);
            }
            in.close();
            file.close();

            System.out.println("Object has been deserialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught: " + ex);
        }
           catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public void serialization() {
        // Serialization 
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("./experiments");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            for (int i = 0; i < Experiment.listOfExperiments.size(); i++) {
                out.writeObject(Experiment.listOfExperiments.get(i));
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught: " + ex);
        }
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

    public boolean makeExperimenteValidation() {
        if (!this.validateNameInput()) {
            JOptionPane.showMessageDialog(null, "Não deixe nenhum campo vazio!");
            return false;
        }
        if (!validateEverythingElse()) {
            JOptionPane.showMessageDialog(null, "Verifique os números!\nTodo número decimal deve conter ser separado por ponto(.)!");
            return false;
        }
        if (!validatePhInput()) {
            JOptionPane.showMessageDialog(null, "O PH deve ser um valor válido!");
            return false;
        }
        return true;
    }

    public void loadExpList() {
        this.m = new DefaultListModel();

        int lsize = Experiment.listOfExperiments.size();
        for (int i = 0; i < lsize; i++) {
            Experiment _e = Experiment.listOfExperiments.get(i);
            this.m.addElement(_e.getName() + "  - " + _e.getId());

        }
        if (lsize > 0) {
            this.currId = lsize;
        }

        jListExperiment.setModel(this.m);
    }

    public void createExperiment() {
        if (makeExperimenteValidation()) {
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

            m.addElement(name + " - " + this.currId);

            this.currId++;
            this.jListExperiment.setModel(m);

            this.experiment = ex;
            Experiment.listOfExperiments.add(ex);
            this.serialization();
        }
    }

    public void cleanDisplay() {
        this.JTExperiment.setText("");
        this.jTMMAcid.setText("");
        this.jTPhCor.setText("");
        this.jTextFieldV0.setText("");
        this.jTNOFB.setText("");
    }

    public void loadDataFromList() {
        int item = this.jListExperiment.getSelectedIndex();
        var selectedExperiment = Experiment.listOfExperiments.get(item);
        this.JTExperiment.setText(selectedExperiment.getName());
        this.jTMMAcid.setText(Float.toString(selectedExperiment.getStrongAcidQuantity()));
        this.jTPhCor.setText(Float.toString(selectedExperiment.getPhCorrection()));
        this.jTextFieldV0.setText(Float.toString(selectedExperiment.getInitialVolume()));
        this.jTNOFB.setText(Float.toString(selectedExperiment.getBaseConcentration()));

    }

    public void updateList(JList list, ArrayList data) {
        DefaultListModel model = new DefaultListModel();
        for (var itr : data) {
            String item = itr.toString();
            model.addElement(item);
        }
        //this.m = model;
        list.setModel(model);
    }

    public void deleteExperiment() {
        int item = this.jListExperiment.getSelectedIndex();
        if (item > -1) {
            m.remove(item);

            cleanDisplay();
        } else {
            JOptionPane.showMessageDialog(null, "É impossível deletar um objeto sem selecioná-lo antes, anta véia!");
        }
    }
}
