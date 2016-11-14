package application.viewer;

import application.MainAppFX;
import application.beans.Machine;
import application.beans.Composant;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
*
* @author Neo_Ryu
*/
public class MachineController {

		// R�f�rence pour le tableview et les colonnes
		@FXML
		private TableView<Machine> tableFX;
		@FXML
		private TableColumn<Machine, String> colone;
		@FXML
		private TableColumn<Machine, String> coltwo;

		// R�f�rence pour les labels
		@FXML
		private Label label1;
		@FXML
		private Label label2;
		@FXML
		private Label label3;
		@FXML
		private Label label4;
		@FXML
		private Label label5;
		@FXML
		private Label label6;
		@FXML
		private Label label7;

		// R�f�rence � l'application principale
		public MainAppFX mainAppFX;

		@FXML
		private Button START, SELECT, CANCEL;
		@FXML
		public static Button ENTER;
		public static String btnSelected = "";	// Permet de determiner le boutton selectionner pour switchcase
		@FXML
		private ButtonBar btnBar;
		@FXML
		private Label labDet, Label1, Label2, Label3, Label4, Label5, Label6, Label7;


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appel�e apr�s le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// Initialise la tableFX avec deux colonnes
		 colone.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		 coltwo.setCellValueFactory(cellData -> cellData.getValue().adresseIPProperty());

		// Nettoyage des details
		 showDetails(null);

		 // Ajout d'un listener pour ecouter les changements :
		 // Nous obtenons la selectedItemProperty de la table de machines et lui ajoutons un listener.
		 // Chaque fois que l'utilisateur s�lectionne une machine dans la table, notre expression lambda est ex�cut�e.
		 // Nous prenons la machine nouvellement s�lectionn�e pour la transmettre � la m�thode showDetails(...).
		 tableFX.getSelectionModel().selectedItemProperty().addListener((observable, oldValeur, newValeur) -> showDetails(newValeur));
	}

	// AFFICHAGE DE DETAILS DANS LE GRIDVIEW
	private void showDetails(Machine machine) {
		// CONFIGURATION DES BOUTTONS
		 START.setFont(MainAppFX.f);
		 SELECT.setFont(MainAppFX.f);
		 CANCEL.setFont(MainAppFX.f);

		 // Au premier appui touche sur le tableview, enclenche le changement de style
		 Set<Node> cells = tableFX.lookupAll(".table-cell");
	     cells.forEach( (c) -> {
	        c.setStyle("-fx-font-weight:lighter;-fx-font-style:italic;");
	     });

		 // CONFIGURATION DES LABELS
		 label1.setFont(MainAppFX.f);
		 label2.setFont(MainAppFX.f);
		 label3.setFont(MainAppFX.f);
		 label4.setFont(MainAppFX.f);
		 label5.setFont(MainAppFX.f);
		 label6.setFont(MainAppFX.f);
		 label7.setFont(MainAppFX.f);
		 labDet.setFont(MainAppFX.f);
		 Label1.setFont(MainAppFX.f);
		 Label2.setFont(MainAppFX.f);
		 Label3.setFont(MainAppFX.f);
		 Label4.setFont(MainAppFX.f);
		 Label5.setFont(MainAppFX.f);
		 Label6.setFont(MainAppFX.f);
		 Label7.setFont(MainAppFX.f);

		 // ATTRIBUTION DES DONNEES
		 if (machine != null) {
		 // Remplissage des labels avec les donn�es Machine de l'item selectionn� dans le tableview
			 label1.setText(machine.getIdSP());
			 label2.setText(machine.getIdAfpaSP());
			 label3.setText(machine.getIdUniqueSP());
			 label4.setText(machine.getDateAchatSP());
			 label5.setText(machine.getDureeGarantieSP());
			 label6.setText(machine.getAdresseIPSP());
			 label7.setText(machine.getTypeSP());
		 } else {
		 // Machine est null, on retire tout le texte
			 label1.setText("");
			 label2.setText("");
			 label3.setText("");
			 label4.setText("");
			 label5.setText("");
			 label6.setText("");
			 label7.setText("");
		 }
	}

	 // AJOUTER : Methode appel�e lorsque l'utilisateur clique sur le bouton d'ajout
	 @FXML
	 private void handleSTART() {
		  btnSelected = "START";
		  Machine newMachine = new Machine(0,0,"","","",0,"","",false,1,new ArrayList<Composant>());
		  boolean okClic = mainAppFX.showMachineEditDialog(newMachine);
		  if (okClic) {
			  mainAppFX.getData().add(newMachine);
		  }
	 }

	 //  MODIFIER : Methode appelée lorsque l'utilisateur clique sur le bouton de modification
	 @FXML
	 private void handleSELECT() {
		 btnSelected = "SELECT";
		 Machine selection = tableFX.getSelectionModel().getSelectedItem();
		 if (selection != null) {
			  boolean okClic = mainAppFX.showMachineEditDialog(selection);
			  if (okClic) {
				  showDetails(selection);
			  }
		 } else {
			  // Si rien n'est s�l�ctionn�
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Aucune selection");
			  alert.setHeaderText("Aucune donn�e selectionn�e");
			  alert.setContentText("Selectionnez une ligne dans la table");
			  alert.showAndWait();
		 }
	 }

	 // SUPPRIMER : Methode appel�e lorsque l'utilisateur clique sur le boutton de suppression
	 @FXML
	 private void handleCANCEL() {
		  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
		  if (selectedIndex >= 0) {
			  // Une ligne a été séléctionnée
			  tableFX.getItems().remove(selectedIndex);
		  } else {
			  // Aucune selection à supprimer...
			  Alert alert = new Alert(AlertType.WARNING);
			  alert.initOwner(mainAppFX.getPrimaryStage());
			  alert.setTitle("Erreur 404");
			  alert.setHeaderText("Aucune donnée à supprimer");
			  alert.setContentText("Veuillez selectionner une ligne dans le tableau !");
			  alert.showAndWait();
		  }
	 }



	 // GAMEPAD
	 @FXML
	 private void handleENTER() {
		 // Simule un clic sur l'un des boutons selectionn� sur la droite du PAD
		 if (btnSelected != "") {
			 switch (btnSelected.toUpperCase()) {
			 	case "START" :
			 		handleSTART();
			 		break;
			 	case "SELECT" :
			 		handleSELECT();
			 		break;
			 	case "CANCEL" :
			 		handleCANCEL();
			 		break;
			 	default:
					break;
			 }
		 } else {
			START.requestFocus();
			btnSelected = "START";
		 }
	 }
	 @FXML
	 private void handleUP() {
		 // Permet de se deplacer vers le HAUT du TableView
		 //tableFX.getFocusModel().focusPrevious();
		 Machine focus = tableFX.getSelectionModel().getSelectedItem();
		 tableFX.getSelectionModel().select(Integer.parseInt(String.valueOf(focus.getId()))-1);
	 }
	 @FXML
	 private void handleDOWN() {
		 // Permet de se deplacer vers le BAS du TableView
		 Machine focus = tableFX.getSelectionModel().getSelectedItem();
		 tableFX.getSelectionModel().select(Integer.parseInt(String.valueOf(focus.getId()))+1);
	 }
	 @FXML
	 private void handleLEFT() {
		 // TODO - Permet de se deplacer vers la GAUCHE du ButtonBar
		 switch (btnSelected) {
			 case "START" :
				 CANCEL.requestFocus();
				 btnSelected = "CANCEL";
				 break;
			 case "SELECT" :
				 START.requestFocus();
				 btnSelected = "START";
				 break;
			 case "CANCEL" :
				 SELECT.requestFocus();
				 btnSelected = "SELECT";
				 break;
			 default :
				START.requestFocus();
				btnSelected = "START";
				break;
		 }
	 }
	 @FXML
	 private void handleRIGHT() {
		 // TODO - Permet de se deplacer vers la DROITE du ButtonBar
		 switch (btnSelected) {
			 case "START" :
				 SELECT.requestFocus();
				 btnSelected = "SELECT";
				 break;
			 case "SELECT" :
				 CANCEL.requestFocus();
				 btnSelected = "CANCEL";
				 break;
			 case "CANCEL" :
				 START.requestFocus();
				 btnSelected = "START";
				 break;
			 default :
				START.requestFocus();
				btnSelected = "START";
				break;
		 }
	 }

	 private KeyEvent keyEvent;
	 @FXML
	 private void handlekeyPressed() {
		 // Si la touche ENTREE est appuy�e, on verifie si un bouton
		 // est selectionn� et on lance alors la methode adequate
		 //System.out.println(""+e);
		 //TODO
	 }

	 /**
	 * Appell� par l'application principale pour avoir une r�f�rence de retour sur elle-m�me
	 *
	 * @param mainApp
	 */

	 public void setMainAppFX(MainAppFX mainAppFX) {
		this.mainAppFX = mainAppFX;

		// Ajout de la liste des donn�es observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getData());

		// selection du premier element
		try {
			tableFX.getSelectionModel().select(0);
		} catch (NullPointerException e) {
			//e.printStackTrace();
			Logger.getLogger(MachineController.class.getName()).log(Level.SEVERE, null, e);
		}

	 }
}