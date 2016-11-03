package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

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

import application.DAO.objets.*;
import application.viewer.OverviewController;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @author Neo_Ryu
 */
public class MainAppFX extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Machine> Data = FXCollections.observableArrayList();


    public MainAppFX() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                // TODO : JEU D'ESSAI / R�cup�ration des donn�es SGBD pour affichage
                Data.add(new Machine("1", "666 1337", "localhost", "01/01/2000", "0", "192.168.1.1", "root"));
                Data.add(new Machine("2", "404 4444", "lacolhost", "21/12/2012", "0", "10.0.0.1", "root"));
                //Data.add(new Machine("1","localhost", "localhost", null, "0", "127.0.0.1", "root", null));
            }
        });

    }

    public ObservableList<Machine> getData() {
        System.out.println("getData");
        return Data;
    }


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hola, Holy Hole !");
        initRootLayout();
        showOverview();
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

    public void showOverview() {
        try {

            System.out.println("showOverview");

            // charger l'apercu (overview) fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppFX.class.getResource("viewer/Overview.fxml"));
            AnchorPane overview = (AnchorPane) loader.load();

            // charger cet apercu au centre du layout racine
            rootLayout.setCenter(overview);

            // ajouts des donn�es dans le tableview controller
            OverviewController controller = loader.getController();
            controller.setMainAppFX(this);

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
        try {
            trucDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        launch(args);
    }

    public static void trucDB() throws SQLException {
        Connection conn = null;

        final String url = "jdbc:mysql://192.168.1.3:3306/holaholyhole";

        final String driver = "com.mysql.jdbc.Driver";

        final String usr = "holaholyhole";

        final String pwd = "holaholyhole";

        try {

            DbUtils.loadDriver(driver);

            conn = DriverManager.getConnection(url, usr, pwd);


            ResultSetHandler<List<Machine>> resultSetHandler = new BeanListHandler<>(Machine.class);


            QueryRunner run = new QueryRunner();

            System.out.println("la");
            List<Machine> machines = run.query(conn, "SELECT * FROM MACHINE", resultSetHandler);
            System.out.println("avant le for");
            for (Machine machine : machines) {
                System.out.println("mergyez");
                System.out.println(machine.getAdresseIP() + " | " + machine.getIdAfpa());

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            conn.close();

        }
    }
}
