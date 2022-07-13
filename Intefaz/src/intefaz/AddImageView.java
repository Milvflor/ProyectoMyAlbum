/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import Clases.Photo;
import Clases.Utilities;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author milel
 */
public class AddImageView {
    
    
    private BorderPane root;
    private Scene scene;
    private Stage stage;
    
    TextField dateInput = new TextField();;
    TextField placeInput = new TextField();
    TextField peopleInput = new TextField();
    TextField detInput = new TextField();
    
    Photo photo;
    Boolean state = false;
    TextField inputPATH;
    Button uploadB;
    Button browserB;
    
    public void AddImageView(){
        
        root = new BorderPane();
        scene = new Scene(root,530,270);
        stage = new Stage();
        stage.setTitle("Agregar foto");
        stage.setResizable(false);
        
        inputPATH = new TextField();
        browserB = new Button("Browser");
        inputPATH.setPrefWidth(300);
        
        Label dateLabel = new Label("Fecha: ");
        
        dateLabel.setPadding(new Insets(10,10,10,30));
        dateInput.setPrefWidth(400);
                
        Label placeLabel = new Label("Lugar: ");
        placeLabel.setPadding(new Insets(10,10,10,30));
        placeInput.setPrefWidth(400);
        
        Label peopleLabel = new Label("Personas: ");
        peopleLabel.setPadding(new Insets(10, 10, 10, 30));
        peopleInput.setPrefWidth(400);
        
        Label detailsLabel = new Label("Detalles: ");
        detailsLabel.setPadding(new Insets(10,10,10,30));
        detInput.setPrefWidth(400);
        
        uploadB = new Button("Upload");
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(inputPATH,browserB);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20,0,0,0));
        hbox.setSpacing(10);
        root.setTop(hbox);
        
        BorderPane center = new BorderPane();
        VBox vBoxleft = new VBox();
        VBox vBoxright = new VBox();
        vBoxleft.setAlignment(Pos.CENTER_LEFT);
        vBoxright.setAlignment(Pos.CENTER_LEFT);
        vBoxright.setSpacing(10);
        vBoxleft.getChildren().addAll(dateLabel,placeLabel,peopleLabel,detailsLabel);
        vBoxright.getChildren().addAll(dateInput,placeInput,peopleInput,detInput);
        center.setLeft(vBoxleft);
        center.setRight(vBoxright);
        root.setCenter(center);
        vBoxleft.setPrefWidth(100);
        vBoxright.setPadding(new Insets(0,30,0,0));
        
        root.setBottom(uploadB);
        BorderPane.setAlignment(uploadB, Pos.TOP_CENTER);
        
        browserB.setOnAction((ActionEvent e) -> {
            browserImg();
        });
        
        uploadB.setOnAction((ActionEvent e) -> {
            uploadImg();
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    Photo getLastPhoto(){
        return photo;
    }
    
    public void setState(){
        state = false;
    }
    
    public boolean getState(){
        return state;
    }
    
    void browserImg() {
        final FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage)root.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
            inputPATH.setText(file.getAbsolutePath());
        }
    }
    
    void uploadImg() {
        
        if(!(inputPATH.getText().contains(".png")||inputPATH.getText().contains(".jpg")||inputPATH.getText().contains(".JPG")||inputPATH.getText().contains(".jpeg")||inputPATH.getText().contains(".PNG"))){
            Utilities.alert("Tipo de archivo inválido. Inserte archivo .png o .jpg");
        }else{
            
            photo = new Photo();
            photo.setDescription(detInput.getText());
            photo.setFecha(Utilities.toDate(dateInput.getText()));
            photo.setLugar(placeInput.getText());
            photo.setPersonas(Utilities.toPersons(peopleInput.getText()));
            photo.setPATH(inputPATH.getText());
            System.out.println(photo);
            state = true;
            
            stage.close();
        }
    }
    
    public void clearText(){
        dateInput = new TextField();;
        placeInput = new TextField();
        peopleInput = new TextField();
        detInput = new TextField();
    }
    
}
