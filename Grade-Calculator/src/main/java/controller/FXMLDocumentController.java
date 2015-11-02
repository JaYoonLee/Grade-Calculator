/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import main.java.engine.Main;

/**
 *
 * @author Jayoon
 */
public class FXMLDocumentController implements Initializable {
    
    private Stage stage;
    
    @FXML
    private Label label, next;
    @FXML
    private TextField textfield1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText(textfield1.getText());
    }
    
    @FXML
    private void nextScreen(MouseEvent event) throws Exception {
        System.out.println("next!");
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/view/fxml/SerialTest.fxml"));
        
        Scene scene = new Scene(root);
        stage = Main.getStage();
        stage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
