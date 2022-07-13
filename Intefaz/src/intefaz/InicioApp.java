/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import Clases.Album;
import Clases.MisAlbunes;
import Clases.OutputObjects;
import Clases.Photo;
import Clases.SerializableOutputStream;
import Clases.Utilities;
import TDAs.ArrayList;
import TDAs.LinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author milel
 */
public class InicioApp extends Application {

    MisAlbunes Albumes = new MisAlbunes();
    Album photosCurrent = null;
    Photo photoActive = null;

    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(this.root);
    private Stage stage = new Stage();

    VBox AlbumSectionV = new VBox();
    Button AddAlbumB;
    Button addImageButton;
    Button albumActive = null;
    ComboBox comboBox = new ComboBox();
    TextField inputSearch;
    MisAlbunes filtered = null;
    TilePane grid = null;

    Label nombreIn = null;
    Label placeIn = null;
    Label peopleIn = null;
    Label detallesIn = null;
    Label dateIn = null;

    AlbumCreateView alb = new AlbumCreateView();
    SerializableOutputStream o = new SerializableOutputStream();
    AddImageView imgView = new AddImageView();
    OutputObjects oop = new OutputObjects();
    MaximizePhoto maxVista = new MaximizePhoto();
    DeleteView deleteMenu = new DeleteView();

    @Override
    public void start(Stage primaryStage) throws Exception {

        o.createFile();
        o.readContains();
        o.cargarAlbumesData(Albumes);
        stage.setMinHeight(500);
        stage.setMinWidth(600);
        stage.centerOnScreen();
        root.setPadding(new Insets(5));
        stage.setTitle("Gallery");

        BorderPane AlbumSection = new BorderPane();

        VBox MenuSection = new VBox();
        MenuSection.setPadding(new Insets(10));
        MenuSection.setAlignment(Pos.TOP_CENTER);
        MenuSection.setSpacing(15);

        Label search = new Label("Buscar");

        comboBox.getItems().add("Lugar");
        comboBox.getItems().add("Fecha");
        comboBox.getItems().add("Lugar y Fecha");
        comboBox.getItems().add("Persona(s)");
        comboBox.getItems().add("Lugar y Persona(s)");

        inputSearch = new TextField();
        inputSearch.setPromptText("yyyy-MM-dd;Guayaquil;Quito,yyyy-MM-dd");

        Button apply = new Button("Aplicar");

        Label infoLabel = new Label("Información");
        infoLabel.setPadding(new Insets(60, 0, 0, 0));
        GridPane gridInfo = new GridPane();

        Label nombreL = new Label("Nombre: ");
        nombreIn = new Label("");
        nombreL.setPrefWidth(50);
        nombreL.setAlignment(Pos.TOP_LEFT);
        nombreIn.setPadding(new Insets(8));
        nombreIn.setWrapText(true);
        nombreIn.setTextAlignment(TextAlignment.JUSTIFY);
        nombreIn.setMaxWidth(200);

        Label placeL = new Label("Lugar: ");
        placeIn = new Label("");
        placeL.setPrefWidth(50);
        placeL.setAlignment(Pos.TOP_LEFT);
        placeIn.setPadding(new Insets(8));
        placeIn.setWrapText(true);
        placeIn.setTextAlignment(TextAlignment.JUSTIFY);
        placeIn.setMaxWidth(200);

        Label dateL = new Label("Fecha: ");
        dateIn = new Label("");
        dateL.setPrefWidth(50);
        dateL.setAlignment(Pos.TOP_LEFT);
        dateIn.setPadding(new Insets(8));
        dateIn.setWrapText(true);
        dateIn.setTextAlignment(TextAlignment.JUSTIFY);
        dateIn.setMaxWidth(200);

        Label peopleL = new Label("Personas: ");
        peopleIn = new Label("");
        peopleL.setPrefWidth(70);
        peopleL.setAlignment(Pos.TOP_LEFT);
        peopleIn.setPadding(new Insets(8));
        peopleIn.setWrapText(true);
        peopleIn.setTextAlignment(TextAlignment.JUSTIFY);
        peopleIn.setMaxWidth(200);

        Label detallesL = new Label("Detalles: ");
        detallesIn = new Label("");
        detallesL.setPrefWidth(50);
        detallesL.setAlignment(Pos.TOP_LEFT);
        detallesIn.setPadding(new Insets(8));
        detallesIn.setWrapText(true);
        detallesIn.setTextAlignment(TextAlignment.JUSTIFY);
        detallesIn.setMaxWidth(200);

        gridInfo.add(nombreL, 0, 0);
        gridInfo.add(placeL, 0, 1);
        gridInfo.add(dateL, 0, 2);
        gridInfo.add(peopleL, 0, 3);
        gridInfo.add(detallesL, 0, 4);

        gridInfo.add(nombreIn, 1, 0);
        gridInfo.add(placeIn, 1, 1);
        gridInfo.add(dateIn, 1, 2);
        gridInfo.add(peopleIn, 1, 3);
        gridInfo.add(detallesIn, 1, 4);

        gridInfo.setPadding(new Insets(5));
//        gridInfo.setGridLinesVisible(true);

        MenuSection.getChildren().addAll(search, comboBox, inputSearch, apply, infoLabel, gridInfo);

        BorderPane ImageSection = new BorderPane();

        root.setRight(MenuSection);
        root.setLeft(AlbumSection);
        root.setCenter(ImageSection);

        AlbumSection.setPrefSize(180, 500);
        MenuSection.setPrefSize(280, 500);
        ImageSection.setPrefSize(510, 500);

        AlbumSection.setStyle("-fx-background-color: #f8eee7;");
        MenuSection.setStyle("-fx-background-color: #f8eee7;");

        AddAlbumB = new Button("+");
        Button refreshButton = new Button(Character.toString((char) 8635));
        AlbumSectionV.setPrefWidth(150);
        AlbumSectionV.setSpacing(5);
        addButtonVBox(AlbumSectionV);
        AlbumSection.setLeft(AlbumSectionV);
        AlbumSection.setTop(AddAlbumB);
        AlbumSection.setBottom(refreshButton);
        BorderPane.setAlignment(AddAlbumB, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(refreshButton, Pos.CENTER_RIGHT);

        addImageButton = new Button("Agregar imagen");
        addImageButton.setDisable(true);

        grid = new TilePane();
        grid.setPadding(new Insets(10));
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setStyle("-fx-background-color: #f4decb;");

        ImageSection.setCenter(grid);
        ImageSection.setBottom(addImageButton);
        BorderPane.setAlignment(addImageButton, Pos.CENTER);

        AddAlbumB.setOnAction((ActionEvent e) -> {
            alb.AlbumCreateView();
        });

        refreshButton.setOnAction((ActionEvent e) -> {
            try {
                addAlbum();
            } catch (IOException ex) {
                Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (alb.getState()) {
                oop.createAlbumOutput(alb.getAlbumNombre());
                AlbumSectionV.getChildren().clear();

                for (int i = 0; i < Albumes.size(); i++) {
                    Album a;
                    try {
                        a = Albumes.get(i);
                        System.out.println(a.getNombre_Album());
                        Button n = new Button(a.getNombre_Album());
                        n.setOnAction(value -> {
                            try {
                                addAvailable(n);
                            } catch (Exception ex) {
                                Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Inside ->" + n.getText());
                        });
//                        n.setStyle("-fx-background-color: #94618e;-fx-text-fill: #f8eee7");
                        n.setPrefWidth(150);
                        AlbumSectionV.getChildren().add(n);
                    } catch (Exception ex) {
                        Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                alb.setState();
            }
        });

        addImageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                imgView.clearText();
                imgView.AddImageView();
            }
        });

        apply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Method: apply");
                if (albumActive != null && comboBox.getValue() != null) {
                    try {
                        filtered = getPhotosFiltered(albumActive.getText(), comboBox.getValue().toString(), inputSearch.getText());
                    } catch (Exception ex) {
                        Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showPhotosImageView(true);
                    photosCurrent = filtered.getAlbum(0);
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    void addAvailable(Button n) throws Exception {
        this.albumActive = n;
        System.out.println(this.albumActive.getText() + " -> Activo");
        inputSearch.setText("");
        
        
        //Si hay fotos por anadir.
        if (imgView.getState()) {
            
            Album a = Albumes.getAlbum(this.albumActive.getText());
            
            Photo photo_to_add = imgView.getLastPhoto();
            
            System.out.println(a.getPATH()+" | "+ photo_to_add.getPATH()+" | "+photo_to_add.getNombre());
            //Agregar foto a la carpeta
            oop.addPhotoOutput(a.getPATH(), photo_to_add.getPATH(), photo_to_add.getNombre());
            
            //Actualizar path de la foto
            photo_to_add.setPATH(a.getPATH() + "/" + photo_to_add.getNombre());
            a.addPhoto(photo_to_add);
            
            photoActive = photo_to_add;
            
            //Actulizar Album Var
            Albumes.replaceAlbum(Albumes.getAlbum(this.albumActive.getText()), a);
            
            //Confirmar foto agregada.
            imgView.setState();
            
            //Actualizar registro
            o.updateFile(Albumes);
            
            Albumes.showAlbunes();
        } else {
            System.out.println("[+] Actualizaciones realizadas.");
        }
        
        if(deleteMenu.getEstado()){
            Album a = Albumes.getAlbum(this.albumActive.getText());
            
            //Eliminar foto de carpeta
            oop.deletePhotoOutput(photoActive.getPATH());
            
            //Eliminar foto de Album Var
            a.deletePhoto(photoActive);
            try {
                Albumes.replaceAlbum(Albumes.getAlbum(this.albumActive.getText()), a);
                deleteMenu.setEstado(false);
                
                //Eliminar foto de registro
                o.updateFile(Albumes);
                
            } catch (Exception ex) {
                Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        photosCurrent = Albumes.getAlbum(this.albumActive.getText());
        showPhotosImageView(false);

        photosCurrent.showPhotos();
        this.addImageButton.setDisable(false);
    }

    /*
    Actualizacion de this.Albumes 
    Albumes.getAlbum(albumName) -> Obtiene el Album objetivo a través del nombre.
    imgView.getState()          -> Revisa si existe una foto por agregar.
    replaceAlbum()              -> Actualiza el album con la nueva foto.
     */
    void updateMisAlbumes(String albumName) throws Exception {

        if (imgView.getState()) {
            
//            imgView.setState();
        } else {
            System.out.println("Album actualizado. Method: InicioApp.updateMisAlbumes");
        }

    }

    void showPhotosImageView(Boolean filteredApply) {

        if (albumActive != null) {

            System.out.println("********************************\n"
                    + "**** Fotos de " + albumActive.getText() + " ****\n"
                    + "*******************************");

            Album album_tmp;
            Album alb_ = Albumes.getAlbum(albumActive.getText());

            if ((filteredApply && !inputSearch.getText().equals(""))) {
                album_tmp = filtered.getAlbum(0);
                album_tmp.showPhotos();
            } else {
                album_tmp = alb_;
            }

            this.grid.getChildren().clear();
            if (album_tmp.getPhotos() != null) {
                for (int i = 0; i < album_tmp.getPhotos().size(); i++) {
                    VBox vb = new VBox();
                    Photo p = album_tmp.getPhotos().get(i);
                    ImageView myImageView_x = new ImageView();
                    myImageView_x.setFitHeight(90);
                    myImageView_x.setFitWidth(90);

                    myImageView_x.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                                if (mouseEvent.getClickCount() == 2) {
                                    System.out.println("Double clicked");
                                    maxVista.MaximizePhotoView(p, photosCurrent);
                                }

                                if (mouseEvent.getClickCount() == 1) {
                                    try {
                                        getInfoPhoto(p);
                                    } catch (Exception ex) {
                                        Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                            if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                                System.out.println("Click derecho");
                                deleteMenu.deleteMenu(mouseEvent.getScreenX(),mouseEvent.getScreenY());
                                photoActive = p;
                            }
                        }
                    });

                    Image img_x = new Image(getClass().getClassLoader().getResourceAsStream(p.getPATH().replace("/src", "")));
                    myImageView_x.setImage(img_x);

                    Label p_label = new Label(p.getNombre());
                    p_label.setPrefWidth(90);
                    p_label.setAlignment(Pos.CENTER);

                    vb.getChildren().addAll(myImageView_x, p_label);

                    this.grid.getChildren().add(vb);
                }
            }
        } else {
            Utilities.alert("Seleccione un album.");
            System.out.println("[!] Method: InicioApp.showPhotosImageView.");
        }

    }

    void addAlbum() throws IOException {

        if (alb.getState()) {
            Album a = new Album(alb.nameTextField.getText());
            a.setDescription(alb.descArea.getText());
            Albumes.addAlbum(a);
            o.writeAlbum(a);

        } else {
            System.out.println("Album ya fue anadido.");
        }

    }

    void addButtonVBox(VBox v) throws Exception {
        for (int i = 0; i < Albumes.size(); i++) {
            Album a = Albumes.get(i);
            Button n = new Button(a.getNombre_Album());
            n.setOnAction(value -> {
                try {
                    addAvailable(n);
                } catch (Exception ex) {
                    Logger.getLogger(InicioApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            n.setOnMouseEntered(e -> n.setStyle("-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;"));
            n.setOnMouseExited(e -> n.setStyle("-fx-background-color: #94618e;-fx-text-fill: #f8eee7"));
            n.setStyle("-fx-background-color: #94618e;-fx-text-fill: #f8eee7");
            n.setPrefWidth(150);
            v.getChildren().add(n);
        }
    }

    public MisAlbunes getPhotosFiltered(String AlbumnameString, String criterio, String valor) throws Exception {

        MisAlbunes l = null;
        if (AlbumnameString == null || criterio == null || valor == null) {
            return null;
        }

        Album obj = Albumes.getAlbum(AlbumnameString);

        if (!inputSearch.getText().equals("")) {
            if (criterio.compareTo("Lugar") == 0) {
                l = obj.filterXLugar(valor);
            } else if (criterio.compareTo("Fecha") == 0) {
                l = obj.filterXFecha(valor);
            } else if (criterio.compareTo("Lugar y Fecha") == 0) {
                l = obj.filterXFechaLugar(valor);
            } else if(criterio.compareTo("Persona(s)")==0){
                l = obj.filterXPersona(valor);
            } else if(criterio.compareTo("Lugar y Persona(s)")==0){
                l = obj.filterXPersonaLugar(valor);
            } 
            else {
                System.out.println("Filtro no seleccionado.");
            }
        } else {
            System.out.println("Ingrese Fecha o Lugar para realizar la búsqueda.");
        }

        return l;
    }

    private void getInfoPhoto(Photo ptmp) throws Exception {
        this.nombreIn.setText(ptmp.getNombre());
        this.detallesIn.setText(ptmp.getDescription());
        String f = (ptmp.getFecha() == null) ? "" : ptmp.getFecha().toString();
        this.dateIn.setText(f);
        this.placeIn.setText(ptmp.getLugar());
        this.peopleIn.setText(Utilities.PersonasString(ptmp.getPersonas()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
