/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalbum;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
    
    
    @FXML
    private GridPane gridPhotosOrg;

    @FXML
    private Pane MenuSection;

    @FXML
    private Button albumDefault;

    @FXML
    private Button addAlbum;

    @FXML
    private ComboBox comboxF;

    @FXML
    private TextField inputFilter;

    @FXML
    private Button applyB;

    @FXML
    private Button editB;

    @FXML
    private Label labelPlace;

    @FXML
    private Label LabelDate;

    @FXML
    private Label LabelDet;

    @FXML
    private Label LabelPeople;

    @FXML
    private Button addImageB;

    @FXML
    void Selection(ActionEvent event) {

    }

    @FXML
    void addImage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CargaImagenForm.fxml"));
        stage = new Stage();
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void applyFilter(ActionEvent event) {

    }

    @FXML
    void createAlbum(ActionEvent event) {

    }

    @FXML
    void editPhotoInfo(ActionEvent event) {

    }

    @FXML
    void showPhotos(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<String> filter_options = FXCollections.observableArrayList(
                "Place","Date","Date & Place"
        );
        
        comboxF.setItems(filter_options);
    }    
    
}
