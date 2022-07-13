/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author milel
 */
public class DeleteView {
    
    private VBox root;
    private Scene scene;
    private Stage stage;
    
    Button deleteButton = new Button("eliminar");
    Boolean Estado = false;

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    public void deleteMenu(Double X,Double Y){
        
        root = new VBox();
        scene = new Scene(root);
        stage = new Stage();
        stage.setResizable(false);
        stage.setX(X);
        stage.setY(Y);
        
        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle("-fx-background-color: #94618e;-fx-text-fill: #f8eee7"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle("-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;"));
        deleteButton.setPrefWidth(90);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(deleteButton);
        
        deleteButton.setOnMouseClicked(value -> { stage.close(); this.setEstado(true);});

        stage.setWidth(90);
        stage.setHeight(30);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}
