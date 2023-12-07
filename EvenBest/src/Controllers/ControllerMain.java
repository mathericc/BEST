/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import static Controllers.ControllerExperiment.jListExperiment;
import Models.Experiment;
import Views.ExperimentData;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControllerMain {

    JDesktopPane mainPanel;

    public ControllerMain(JDesktopPane jDesktopPane1) {
        mainPanel = jDesktopPane1;
    }

    public void renderExperiments() {
        mainPanel.removeAll();
        mainPanel.updateUI();
        Dimension resolucao = mainPanel.getSize(); // Captura resoluçao do container
        Views.ExperimentPanel t = new Views.ExperimentPanel(this);
        t.setSize(resolucao);
        t.setLocation(0, 0);
        mainPanel.add(t);
        t.setVisible(true);
    }

    public void renderDataWithTest() {
        if (ControllerExperiment.jListExperiment.getSelectedIndex() > -1) {
            this.renderData();
        } else {
            JOptionPane.showMessageDialog(null, "Pelamor, selecione um experimento antes de prosseguir!");
        }
    }

    public void renderData() {
        mainPanel.removeAll();
        mainPanel.updateUI();
        Dimension resolucao = mainPanel.getSize(); // Captura resoluçao do container
        var experiment = Experiment.listOfExperiments.get(jListExperiment.getSelectedIndex());
        System.out.println(experiment.getName());
        ExperimentData t = new ExperimentData(experiment);
        t.setSize(resolucao);
        t.setLocation(0, 0);
        mainPanel.add(t);
        t.setVisible(true);
    }
}
