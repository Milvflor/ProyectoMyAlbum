/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalbum;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author milel
 */
public class CargaImagenFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField inputPATH;

    @FXML
    private Button browserB;

    @FXML
    private TextField dateLabel;

    @FXML
    private TextField placeLabel;

    @FXML
    private TextField peopleLabel;

    @FXML
    private TextField detailsLabel;

    @FXML
    private Button uploadB;
    
    @FXML
    private AnchorPane anchorFX;

    @FXML
    void browserImg(ActionEvent event) {
           final FileChooser fileChooser = new FileChooser();
//           final DirectoryChooser dirChooser = new DirectoryChooser();
           Stage stage = (Stage)anchorFX.getScene().getWindow();
           File file = fileChooser.showOpenDialog(stage);
           if(file != null){
               inputPATH.setText(file.getAbsolutePath());
               uploadB.setDisable(false);
           }
    }

    @FXML
    void uploadImg(ActionEvent event) {

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
