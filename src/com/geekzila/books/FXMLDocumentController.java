package com.geekzila.books;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
/**
 * 
 * @author Ariv
 *
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textEmail;
    
    @FXML
    private PasswordField textPassword;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    public FXMLDocumentController() {
    	
    }
    
    
    /**
     * 
     * @param event
     * 
     * This will be invoked when user submits the credentials
     */
    public void loginAction(ActionEvent event){
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();
    
        boolean loginStatus = false;
        if(email.equals(password)) {
        	loginStatus = true;
        }
        try{
            if(!loginStatus){
                infoBox("Please enter correct Email and Password", null, "Failed");
            }else{
            	// Once user login is succuessful
                infoBox("Login Successfull",null,"Success" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                /**
                 * Navigate to FXMLMenu where CRUD operation takes place.
                 */
                scene = new Scene(FXMLLoader.load(getClass().getResource("/com/geekzila/books/view/HotelMenu.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}