/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalbum;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author milel
 */
public class ViewPhotoController implements Initializable {

    /**
     * Initializes the controller class.
     */
  @FXML
    private Pane MenuSection;

    @FXML
    private Button albumDefault;

    @FXML
    private Button addAlbum;

    @FXML
    private Pane backgroundViewer;

    @FXML
    private Button close;

    @FXML
    private Button leftP;

    @FXML
    private Button rightP;

    @FXML
    private ImageView bin;

    @FXML
    void closeViewer(ActionEvent event) {

    }

    @FXML
    void createAlbum(ActionEvent event) {

    }

    @FXML
    void deletePhoto(MouseEvent event) {

    }

    @FXML
    void goToLeft(ActionEvent event) {

    }

    @FXML
    void goToRight(ActionEvent event) {

    }

    @FXML
    void showPhotos(ActionEvent event) {

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
