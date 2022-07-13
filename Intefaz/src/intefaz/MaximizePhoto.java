/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import Clases.Album;
import Clases.MisAlbunes;
import Clases.Photo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author milel
 */
public class MaximizePhoto {

    private BorderPane root;
    private Scene scene;
    private Stage stage;
    private ImageView imageView;
    Button left = null;
    Button right = null;
    Photo foto_currency = null;

    public void MaximizePhotoView(Photo foto, Album a) {

        root = new BorderPane();
        scene = new Scene(root, 600, 600);
        stage = new Stage();
        stage.setTitle(foto.getNombre());

        imageView = new ImageView();
        Image p = new Image(getClass().getClassLoader().getResourceAsStream(foto.getPATH().replace("/src", "")));
        imageView.setImage(p);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        root.setStyle("-fx-background-color: #f8eee7;");

        left = new Button();
        left.setPrefHeight(40);
        left.setPrefWidth(60);
        left.setStyle("-fx-background-color: #49274A; -fx-shape: \"M150 0 L75 200 L225 200 Z\";");
        left.setRotate(270);

        right = new Button();
        right.setPrefHeight(40);
        right.setPrefWidth(60);
        right.setStyle("-fx-background-color: #49274A; -fx-shape: \"M150 0 L75 200 L225 200 Z\";");
        right.setRotate(90);

        BorderPane.setAlignment(left, Pos.CENTER);
        BorderPane.setAlignment(right, Pos.CENTER);
        BorderPane.setAlignment(imageView, Pos.CENTER);

        root.setLeft(left);
        root.setCenter(imageView);
        root.setRight(right);

        foto_currency = foto;
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Photo p_x = a.getPhotos().getNext(foto_currency);
                Image imagep_x = new Image(getClass().getClassLoader().getResourceAsStream(p_x.getPATH().replace("/src", "")));
                imageView.setImage(imagep_x);
                setCurrencyPhoto(p_x);
            }
        });

        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Photo p_x = a.getPhotos().getPrevious(foto_currency);
                Image imagep_x = new Image(getClass().getClassLoader().getResourceAsStream(p_x.getPATH().replace("/src", "")));
                imageView.setImage(imagep_x);
                setCurrencyPhoto(p_x);
            }
        });
        
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();

    }

    public void setCurrencyPhoto(Photo new_photo) {
        stage.setTitle(new_photo.getNombre());
        foto_currency = new_photo;
    }

}
