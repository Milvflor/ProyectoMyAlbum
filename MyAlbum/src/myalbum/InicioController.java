/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalbum;

import Clases.Album;
import Clases.MisAlbunes;
import Clases.Persona;
import Clases.Photo;
import Clases.Utilities;
import TDAs.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author milel
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Stage stage;
    private Scene scene;
    
    @FXML private Pane MenuSection;
    @FXML private Button addAlbumButtom;
    @FXML private VBox AlbumSection;
    @FXML private ComboBox comboxF;
    @FXML private TextField inputFilter;
    @FXML private Button applyB;
    @FXML private Button editB;
    @FXML private Label labelPlace;
    @FXML private Label LabelDate;
    @FXML private Label LabelDet;
    @FXML private Label LabelPeople;
    @FXML private ScrollPane scroller;
    @FXML private GridPane gridPhotosOrg;
    @FXML private Button addImageB;
    @FXML private Label nombre_album;
    
    

    @FXML
    void Selection(ActionEvent event) {

    }

    @FXML
    void addImageAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CargaImagenForm.fxml"));
        stage = new Stage();
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }
    

    public void setAlbumSection(Album alb){
        AlbumSection.getChildren().add(new Button(alb.getNombre_Album()));
        System.out.println("xuxa");
    }
    
    

    @FXML
    void applyFilter(ActionEvent event) {

    }
    
    void InicioView(ActionEvent event) throws IOException{
        Parent calendarScreen = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Scene loginScreen = new Scene(calendarScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScreen);
        window.show();
    }
    
    

    @FXML
    void addAlbumAction(ActionEvent event) throws IOException, Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("AddAlbum.fxml"));
//        stage = new Stage();
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
//        stage.show();
        
    }

    @FXML
    void editPhotoInfo(ActionEvent event) {

    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        //Opciones de filtrado
        ObservableList<String> filter_options = FXCollections.observableArrayList(
                "Place","Date","Date & Place"
        );
        comboxF.setItems(filter_options);
    }    
    
  
    
}
