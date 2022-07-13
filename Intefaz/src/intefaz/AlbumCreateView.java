/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import Clases.MisAlbunes;
import Clases.Utilities;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author milel
 */
public class AlbumCreateView {
    
        
    private BorderPane root;
    private Scene scene;
    private Stage stage;
    Button crearAlbumButton;
    TextField nameTextField;
    TextArea descArea;
    Boolean state = false;
    
    public void AlbumCreateView(){
        
        root = new BorderPane();
        scene = new Scene(root,400,200);
        stage = new Stage();
        stage.setTitle("Crear nuevo Album");
        stage.setResizable(false);
        stage.centerOnScreen();
        root.setPadding(new Insets(5));
        
        VBox left = new VBox();
        VBox right = new VBox();
        left.setAlignment(Pos.TOP_LEFT);
        right.setAlignment(Pos.CENTER_LEFT);
        left.setPadding(new Insets(0,0,0,30));
        left.setPrefWidth(150);
        right.setPrefWidth(250);
        left.setSpacing(10);
        right.setSpacing(10);
        right.setPadding(new Insets(0,30,0,0));
        
        Label nameAlbumLabel = new Label("Nombre del álbum: ");
        nameTextField = new TextField();
        
        Label descLabel = new Label("Descripción: ");
        descArea = new TextArea();
        
        left.getChildren().addAll(nameAlbumLabel,descLabel);
        right.getChildren().addAll(nameTextField,descArea);
        
        crearAlbumButton = new Button("Crear Album");

        nameAlbumLabel.setPadding(new Insets(20,0,0,0));
        nameTextField.setPrefWidth(160);
        descArea.setPrefSize(160, 90);
        BorderPane.setAlignment(left, Pos.CENTER);
        BorderPane.setAlignment(right, Pos.CENTER);
        BorderPane.setAlignment(crearAlbumButton, Pos.CENTER);
        
        root.setLeft(left);
        root.setRight(right);
        root.setBottom(crearAlbumButton);
        
        stage.setScene(scene);
        stage.show();
        
        crearAlbumButton.setOnAction((event) -> {
            if(nameTextField.getText().equals("")){
                Utilities.alert("Ingrese nombre para el album.");

            }else{
                crearAlbum(event);
            }
        });
    }
    
    public void crearAlbum(ActionEvent event){
        
        state = true;
        stage.close();
        
    }
    
    public void setState(){
        state = false;
    }
    
    public boolean getState(){
        return state;
    }
    
    public String getAlbumNombre(){
        return nameTextField.getText();
    }
    
    
}
