/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalbum;
import Clases.Album;
import Clases.Manage;
import Clases.MisAlbunes;
import TDAs.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author milel
 */
public class AddAlbumController implements Initializable{

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;
    
    
    
    @FXML
    private TextField name_album;

    @FXML
    private TextArea decription_album;

    @FXML
    private Button crear_album;

    @FXML
    void crearAlbum_button(ActionEvent event) throws Exception {
        
        if(name_album.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ingrese nombre para el album.");
            alert.show();
            
        }else{
            
            Album alb_n = new Album(name_album.getText());
            alb_n.setDescription(decription_album.getText());
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            Parent root = (Parent) loader.load();
            
            InicioController inicioController = loader.getController();
            inicioController.setAlbumSection(alb_n);
   
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
        }  
    }
    
    void AddAlbumView(ActionEvent event) throws IOException{
    
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
