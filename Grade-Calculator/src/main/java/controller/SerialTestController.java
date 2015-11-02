/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jayoon
 */
public class SerialTestController implements Initializable {

    @FXML
    private TextField nameField, ageField;
    @FXML
    private Label getNameLabel, getAgeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void serializeAction(ActionEvent event) {
        System.out.println(nameField.getText());
        System.out.println(ageField.getText());
        
        try {
            FileOutputStream fos;
            fos = new FileOutputStream("src/main/resources/persistence/grade.ser");
            //fos = new FileOutputStream("src/main/resources/persistence/grade.ser", true); append the text
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nameField.getText());
            oos.writeObject(ageField.getText());
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in /persistence/grade.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void deserializeAction(ActionEvent event) {
        try {
            FileInputStream fis;
            fis = new FileInputStream("src/main/resources/persistence/grade.ser");
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            getNameLabel.setText((String) ois.readObject());
            getAgeLabel.setText((String) ois.readObject());
            ois.close();
            fis.close();
            System.out.println("Deserialize data from /persistence/grade.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}