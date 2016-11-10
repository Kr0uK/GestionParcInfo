package application;

import application.beans.Composant;
import application.beans.Machine;
import application.dao.DAOConnection;
import application.dao.DAOMachine;
import application.tools.LectureRB;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/*
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Collection;
import java.util.Date;
*/


import application.viewer.OverviewController;
import application.viewer.MachineController;
import application.viewer.MachineEditDialogController;

/**
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {


    static DAOMachine daoMachine = new DAOMachine();
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Machine> DataMachine = FXCollections.observableArrayList();
    public static Font f;

    public MainAppFX() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                List<Machine> liste = daoMachine.lecture(LectureRB.lireRB("query", "lectureMachines"));
                DataMachine.addAll(liste);

                // On r�cup�re d'abord les donn�es a partir du SGBD pour permettre l'affichage
             //   getDataMachine();

            }
        });

    }


    // R�cup�ration des donn�es dans une liste d'objets observables de type Machine
    public void getDataMachine() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                List<Machine> liste = daoMachine.lecture(LectureRB.lireRB("query", "lectureMachines"));
                DataMachine.addAll(liste);
            }
        });

    }
    public ObservableList<Machine> getData() {
        return DataMachine;
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            f = Font.loadFont(new FileInputStream(new File("src/application/8BIT.TTF")), 12);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // TITRE + ICONE
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITpark Manager");
        this.primaryStage.getIcons().add(new Image("@../../res/itmp.png"));
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(545);
        primaryStage.setMaxWidth(575);
        initRootLayout();

        // Methode permettant d'appeler le layout d'intro
        String choixLayout = "viewer/Overview.fxml";
        choixLayout = "viewer/Machine.fxml";
        // Le choix de l'affichage des autres layout se fera par le menubar
        showOverview(choixLayout);

    }

    public void initRootLayout() {
        try {
            // Chargement du layout racine à partir du fichier fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewer/RootLayout.fxml"));
            loader.setLocation(MainAppFX.class.getResource("viewer/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            loader.setController(this);


            // Montrer la scene contenant le layout racine
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().addAll(this.getClass().getResource("viewer/theme_RootLayout.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOverview(String choixLayout) {
        try {

            // charger l'apercu (overview) fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource(choixLayout));
            AnchorPane overview = (AnchorPane) loader.load();

            // charger cet apercu au centre du layout racine
            rootLayout.setCenter(overview);

            // ajouts des donn�es dans le tableview controller
            switch (choixLayout) {
                case "viewer/Machine.fxml":
                    MachineController machineCtrl = loader.getController();
                    machineCtrl.setMainAppFX(this);
                    break;
                case "viewer/Overview.fxml":
                default:
                    OverviewController overviewCtrl = loader.getController();
                    overviewCtrl.setMainAppFX(this);
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean showMachineEditDialog(Machine machine) {
        try {
            // Charge le fichier FXML et creation d'un nouveau stage dans une popup
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource("viewer/MachineEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Creation du Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("ITpark Manager Editor");
            dialogStage.getIcons().add(new Image("@../../res/itmp.png"));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Configure l'objet (machine) dans un controlleur
            MachineEditDialogController MachineEDC = loader.getController();
            MachineEDC.setDialogStage(dialogStage);
            MachineEDC.setMachine(machine);

            // Montre la popup tant qu'elle n'est pas ferm�e
            dialogStage.showAndWait();
            return MachineEDC.isOkClic();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    // 47 / 84
}
