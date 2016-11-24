package application.viewer;

import application.MainAppFX;
import application.beans.*;
import application.interfaces.IComposant;
import application.tools.ComposantFactory;
import application.tools.LectureRB;
import application.tools.Sound;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import static application.viewer.ComposantEditDialogController.TypeComposants.*;

/**
 * Created by Boris on 22/11/2016.
 */
public class ComposantEditDialogController<T extends Composant> {

    //TODO
    protected String btnSelected;
    private static ResourceBundle rsc = ResourceBundle.getBundle("application.resources.UIResources");

    /**
     * enum avec les types de composants
     */

    public enum TypeComposants {
        COMPOSANT("Composant autre", "COMPOSANT"),  //0
        PROCESSEUR("Processeur", "PROCESSEUR"),  //1
        RAM("Ram", "RAM"), //2
        DISQUEDUR("Disque Dur", "DISQUE DUR"), //3
        CARTEMERE("Carte mère", "CARTE MERE"), //4
        LOGICIEL("Logiciel", "LOGICIEL"), //5
        OS("Système d'exploitation", "OS"); //6

        private String libelle;
        private String type;

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return libelle;
        }

        TypeComposants(String libelle, String type) {
            this.libelle = libelle;
            this.type = type;
        }

    }

    ComposantFactory composantFactory = new ComposantFactory();

    @FXML
    private TextField txtfld1;
    @FXML
    private TextField txtfld2;
    @FXML
    private TextField txtfld3;
    @FXML
    private TextField txtfld4;
    @FXML
    private TextField txtfld5;
    @FXML
    private TextField txtfld6;
    @FXML
    private TextField txtfld8;
    @FXML
    private TextField txtfld9;

    private Stage dialogStage;
    private T composant;
    private boolean okClic = false;

    @FXML
    ChoiceBox<TypeComposants> listType = new ChoiceBox<>();

    @FXML
    private Label Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8, Label9;

    @FXML
    private Button button1, button2;

    public Sound sound = new Sound();
    public static ResourceBundle player = ResourceBundle.getBundle("application.Config");

    @FXML
    private void initialize() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound("../../res/bitVALID.wav");
            sound.Play();
        }


        // Y'a les noms des types en majuscules en attendant
        listType.getItems().setAll(TypeComposants.values());
        listType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                disable8();
                disable9();
                switch (newValue.intValue()) {
                    case 0:
                        composant.setType(COMPOSANT.type);
                        showCompo(COMPOSANT.type);
                        break;
                    case 1:
                        composant.setType(PROCESSEUR.type);
                        showCompo(PROCESSEUR.type);
                        break;
                    case 2:
                        composant.setType(RAM.type);
                        showCompo(RAM.type);
                        break;
                    case 3:
                        composant.setType(DISQUEDUR.type);
                        showCompo(DISQUEDUR.type);
                        break;
                    case 4:
                        composant.setType(CARTEMERE.type);
                        showCompo(CARTEMERE.type);
                        break;
                    case 5:
                        composant.setType(LOGICIEL.type);
                        showCompo(LOGICIEL.type);
                        break;
                    case 6:
                        composant.setType(OS.type);
                        showCompo(OS.type);
                        break;
                    default:
                        disable8();
                        disable9();
                        break;
                }
            }
        });
    }

    private void showCompo(String type) {

        disable8();
        disable9();
        /**
         * Le cas où l'on clique sur START
         */
        if (this.btnSelected.equals("START")) {

            switch (type) {
                case "PROCESSEUR":
                    enable8();
                    enable9();
                    Label8.setText("Nombre de coeurs");
                    Label9.setText("Fréquence");
                    break;
                case "RAM":
                    enable8();
                    disable9();
                    Label8.setText("Capacité");
                    break;
                case "DISQUE DUR":
                    enable8();
                    enable9();
                    Label8.setText("Type de disque");
                    Label9.setText("Capacité");
                    break;
                case "CARTE MERE":
                    enable8();
                    disable9();
                    Label8.setText("Format");
                    break;
                case "LOGICIEL":
                    enable8();
                    disable9();
                    Label8.setText("Architecture");
                    break;
                case "COMPOSANT":
                    disable8();
                    disable9();
                    break;
                case "OS":
                    enable8();
                    enable9();
                    Label8.setText("Type d'OS");
                    Label9.setText("Architecture");
                    break;
                default:
                    disable8();
                    disable9();
                    break;
            }

            /**
             * Le cas où l'on clique sur SELECT
             */
        } else {
            switch (type) {
                case "PROCESSEUR":
                    enable8();
                    enable9();
                    Label8.setText("Nombre de coeurs");
                    Label9.setText("Fréquence");
                    listType.getSelectionModel().select(TypeComposants.PROCESSEUR);
                    txtfld8.setText("");
                    txtfld9.setText("");
                    break;
                case "RAM":
                    enable8();
                    disable9();
                    Label8.setText("Capacité");
                    break;
                case "DISQUE DUR":
                    enable8();
                    enable9();
                    Label8.setText("Type de disque");
                    Label9.setText("Capacité");
                    break;
                case "CARTE MERE":
                    enable8();
                    disable9();
                    Label8.setText("Format");
                    break;
                case "LOGICIEL":
                    enable8();
                    disable9();
                    Label8.setText("Architecture");
                    break;
                case "COMPOSANT":
                    disable8();
                    disable9();
                    break;
                case "OS":
                    enable8();
                    enable9();
                    Label8.setText("Type d'OS");
                    Label9.setText("Architecture");
                    break;
                default:
                    disable8();
                    disable9();
                    break;
            }
        }

    }

    private void disable8() {
        Label8.setText("");
        Label8.setDisable(true);
        txtfld8.setDisable(true);
        Label8.setVisible(false);
        txtfld8.setVisible(false);
    }

    private void disable9() {
        Label9.setText("");
        Label9.setDisable(true);
        txtfld9.setDisable(true);
        Label9.setVisible(false);
        txtfld9.setVisible(false);
    }

    private void enable8() {
        Label8.setDisable(false);
        txtfld8.setDisable(false);
        Label8.setVisible(true);
        txtfld8.setVisible(true);
    }

    private void enable9() {
        Label9.setDisable(false);
        txtfld9.setDisable(false);
        Label9.setVisible(true);
        txtfld9.setVisible(true);
    }

    // STAGE
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    // DEFINIR TEXTE DES TEXTFIELDS
    public void setComposant(T composant) {
        this.composant = composant;
        System.out.println("Celui qui rentre dans la méthode : " + composant.getClass());
        System.out.println("Celui déjà dans la classe " + this.composant.getClass());

        // CONFIGURATION DES BOUTTONS
        button1.setFont(MainAppFX.f);
        button2.setFont(MainAppFX.f);
        // CONFIGURATION DES LABELS
        Label1.setFont(MainAppFX.f);
        Label2.setFont(MainAppFX.f);
        Label3.setFont(MainAppFX.f);
        Label4.setFont(MainAppFX.f);
        Label5.setFont(MainAppFX.f);
        Label6.setFont(MainAppFX.f);
        Label7.setFont(MainAppFX.f);
        txtfld1.setFont(MainAppFX.f);
        txtfld2.setFont(MainAppFX.f);
        txtfld3.setFont(MainAppFX.f);
        txtfld4.setFont(MainAppFX.f);
        txtfld5.setFont(MainAppFX.f);
        txtfld6.setFont(MainAppFX.f);
        txtfld8.setFont(MainAppFX.f);
        txtfld9.setFont(MainAppFX.f);

        // CONFIGURATION DES TEXTFIELD


        /**
         * On utilise la factory pour renvoyer un composant du bon type
         */

        this.btnSelected = ComposantController.btnSelected;

        /**
         * Si SELECT est cliqué
         */
        if (ComposantController.btnSelected == "SELECT") {
            txtfld1.setText(String.valueOf(composant.getId()));
            txtfld2.setText(String.valueOf(composant.getId()));
            txtfld3.setText(composant.getReference());
            txtfld4.setText(composant.getConstructeur());
            txtfld5.setText(composant.getDetails());
            txtfld6.setText(String.valueOf(composant.getIdMachine()));
            if (composant instanceof CarteMere) {
                CarteMere carteMere = (CarteMere) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_cm_format"));
                txtfld8.setText((carteMere.getFormat()));
                disable9();
            } else if (composant instanceof Ram) {
                Ram ram = (Ram) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                txtfld8.setText(String.valueOf((ram.getCapaciteGo())));
                disable9();
            } else if (composant instanceof DisqueDur) {
                DisqueDur disqueDur = (DisqueDur) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_dd_format"));
                txtfld8.setText(disqueDur.getFormat());
                Label9.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                txtfld9.setText(String.valueOf((disqueDur.getStockageGo())));
            } else if (composant instanceof Logiciel) {
                Logiciel logiciel = (Logiciel) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                txtfld8.setText(String.valueOf(logiciel.getArchitecture()));
                disable9();
            } else if (composant instanceof Processeur) {
                Processeur processeur = (Processeur) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_coeurs"));
                txtfld8.setText(String.valueOf(processeur.getCoeurs()));
                Label9.setText(LectureRB.lireRB("UIResources", "lab_frequence"));
                txtfld9.setText(String.valueOf(processeur.getFrequence()));
            } else if (composant instanceof SystemeExploitation) {
                SystemeExploitation systemeExploitation = (SystemeExploitation) composant;
                Label8.setText(LectureRB.lireRB("UIResources", "lab_type"));
                txtfld8.setText(systemeExploitation.getFormat());
                Label9.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                txtfld9.setText(String.valueOf(systemeExploitation.getArchitecture()));
            } else {
                // Remplissage des labels avec les données Composant de l'item selectionné dans le tableview
                // Les champs de l'objet Composant
                disable8();
                disable9();
            }
            /**
             * Si START est cliqué
             */
        } else {
            txtfld1.setText("");
            txtfld2.setText("");
            txtfld3.setText("");
            txtfld4.setText("");
            txtfld5.setText("");
            txtfld6.setText("");
            if (composant instanceof CarteMere) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_cm_format"));
                txtfld8.setText("");
                disable9();
            } else if (composant instanceof Ram) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                txtfld8.setText("");
                disable9();
            } else if (composant instanceof DisqueDur) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_dd_format"));
                txtfld8.setText("");
                Label9.setText(LectureRB.lireRB("UIResources", "lab_capacite"));
                txtfld9.setText("");
            } else if (composant instanceof Logiciel) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                txtfld8.setText("");
                disable9();
            } else if (composant instanceof Processeur) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_coeurs"));
                txtfld8.setText("");
                Label9.setText(LectureRB.lireRB("UIResources", "lab_frequence"));
                txtfld9.setText("");
            } else if (composant instanceof SystemeExploitation) {
                Label8.setText(LectureRB.lireRB("UIResources", "lab_type"));
                txtfld8.setText("");
                Label9.setText(LectureRB.lireRB("UIResources", "lab_architecture"));
                txtfld9.setText("");
            } else {
                // Remplissage des labels avec les données Composant de l'item selectionné dans le tableview
                // Les champs de l'objet Composant
                disable8();
                disable9();
            }

        }
    }


    // BOUTON OK : MainAppFX

    public boolean isOkClic() {
        return okClic;
    }

    // ANNULATION ENVOI
    @FXML
    private void handleCancel() {
        if (player.getString("sound").equals("ON")) {
            sound = new Sound("../../res/bitCANCEL.wav");
            sound.Play();
        }
        dialogStage.close();
    }

    // VALIDATION ENVOI
    @FXML
    private void handleOk() {
        // Verification avant stockage
        if (isInputValid()) {
            // Remplissage des labels avec les données Composant de l'item selectionné dans le tableview
            // Les champs de l'objet Composant
            composant.setId(Integer.parseInt(txtfld1.getText()));
            composant.setLibelle(txtfld2.getText());
            composant.setReference(txtfld3.getText());
            composant.setConstructeur(txtfld4.getText());
            composant.setDetails(txtfld5.getText());
            composant.setIdMachine(Integer.parseInt(txtfld6.getText()));
            if (composant instanceof CarteMere) {
                composant.setType(CARTEMERE.type);
                ((CarteMere) composant).setFormat(txtfld8.getText());
            } else if (composant instanceof Ram) {
                composant.setType(RAM.type);
                ((Ram) composant).setCapaciteGo(Integer.parseInt(txtfld8.getText()));
            } else if (composant instanceof DisqueDur) {
                composant.setType(DISQUEDUR.type);
                ((DisqueDur) composant).setFormat(txtfld8.getText());
                ((DisqueDur) composant).setStockageGo(Integer.parseInt(txtfld9.getText()));
            } else if (composant instanceof Logiciel) {
                composant.setType(LOGICIEL.type);
                ((Logiciel) composant).setArchitecture(Integer.parseInt(txtfld8.getText()));
            } else if (composant instanceof Processeur) {
                composant.setType(PROCESSEUR.type);
                ((Processeur) composant).setCoeurs(Integer.parseInt(txtfld8.getText()));
                ((Processeur) composant).setFrequence(Integer.parseInt(txtfld9.getText()));
            } else if (composant instanceof SystemeExploitation) {
                composant.setType(OS.type);
                ((SystemeExploitation) composant).setFormat(txtfld8.getText());
                ((SystemeExploitation) composant).setArchitecture(Integer.parseInt(txtfld9.getText()));
            }
        }

        okClic = true;
        dialogStage.close();


    }


    // VERIFICATION

    private boolean isInputValid() {
        String errorMessage = "";
        if (txtfld1.getText() == null || txtfld1.getText().length() == 0) {
            errorMessage += Label1.getText().toUpperCase().toString() + " nécéssaire !\n";
        }

        if (txtfld2.getText() == null || txtfld2.getText().length() == 0) {
            errorMessage += Label2.getText().toUpperCase().toString() + " nécéssaire !\n";
        }

        if (txtfld3.getText() == null || txtfld3.getText().length() == 0) {
            errorMessage += Label3.getText().toUpperCase().toString() + " nécéssaire !\n";
        }

        if (txtfld4.getText() == null || txtfld4.getText().length() == 0) {
            errorMessage += Label4.getText().toUpperCase().toString() + " nécéssaire !\n";
        }

        if (txtfld5.getText() == null || txtfld5.getText().length() == 0) {
            errorMessage += Label5.getText().toUpperCase().toString() + " nécéssaire !\n";
        }

        if (txtfld6.getText() == null || txtfld6.getText().length() == 0) {
            errorMessage += Label6.getText().toUpperCase().toString() + " nécéssaire !\n";
        }


        // Affichage d'un message d'erreur si la taille de la chaine est superieur a 0
        if (errorMessage.length() == 0) {
            if (player.getString("sound").equals("ON")) {
                sound = new Sound("../../res/bitSTART.wav");
                sound.Play();
            }
            return true;
        } else {
            if (player.getString("sound").equals("ON")) {
                sound = new Sound("../../res/bitCANCEL.wav");
                sound.Play();
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs manquants ou incorrects");
            alert.setHeaderText("Veuillez remplir correctement les champs...");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


}


