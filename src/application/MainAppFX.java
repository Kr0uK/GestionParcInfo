package application;

import application.DAO.DAOConnection;
import application.DAO.DAOMachine;
import application.interfaces.IDAOHandler;
import application.tools.LectureRB;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import application.objets.*;
import application.viewer.OverviewController;
import application.viewer.MachineController;

/**
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {

    static DAOConnection testco = new DAOConnection();
    static DAOMachine daoMachine = new DAOMachine();
    private Stage primaryStage;
    private BorderPane rootLayout;

    private static ObservableList<Machine> Data = FXCollections.observableArrayList();


    public MainAppFX() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                getDataMachine();
                            }
        });

    }
    public void getDataMachine(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

             List<Machine> liste = daoMachine.lecture(LectureRB.lireRB("lectureMachines"));
                Data.addAll(liste);

            }});
    }

    public ObservableList<Machine> getData() {
        return Data;
    }


    @Override
    public void start(Stage primaryStage) {

        // TITRE + ICONE
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITpark Manager");
        this.primaryStage.getIcons().add(new Image("@../../res/icon.png"));
        initRootLayout();

        // Methode permettant d'appeler le layout d'intro
        //String choixLayout = "viewer/Overview.fxml";
        String choixLayout = "viewer/Machine.fxml";
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
                    MachineController MachineCtrl = loader.getController();
                    MachineCtrl.setMainAppFX(this);
                    break;
                case "viewer/Overview.fxml":
                default:
                    OverviewController OverviewCtrl = loader.getController();
                    OverviewCtrl.setMainAppFX(this);
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
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


    // 30 / 84
}
