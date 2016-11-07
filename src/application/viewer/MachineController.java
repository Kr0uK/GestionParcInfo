package application.viewer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.sun.media.jfxmedia.logging.Logger;

import application.MainAppFX;
import application.DAO.objets.Machine;

import javafx.fxml.FXMLLoader;

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
		public static MainAppFX mainAppFX;


	/**
	 * Initialises la classe controller. 
	 * Cette methode est automaticament appel�e apr�s le chargement du fichier FXML.
	 */
	 @FXML
	 private void initialize() {
		// Initialise la tableFX avec deux colonnes
		 colone.setCellValueFactory(cellData -> cellData.getValue().idAfpaProperty()); 
		 coltwo.setCellValueFactory(cellData -> cellData.getValue().adresseIPProperty());
		 
		// Nettoyage des details
		 showDetails(null);
		 
		 // Ajout d'un listener pour ecouter les changements :
		 // Nous obtenons la selectedItemProperty de la table de machines et lui ajoutons un listener. 
		 // Chaque fois que l'utilisateur s�lectionne une machine dans la table, notre expression lambda est ex�cut�e.
		 // Nous prenons la machine nouvellement s�lectionn�e pour la transmettre � la m�thode showDetails(...).
		 tableFX.getSelectionModel().selectedItemProperty().addListener((observable, oldValeur, newValeur) -> showDetails(newValeur));
		 // TODO rafraîchir le tableau à l'ajout
	}
	 
	 private void showDetails(Machine machine) {
		 if (machine != null) {
		 // Remplissage des labels avec les donn�es Machine de l'item selectionn� dans le tableview
			 label1.setText(machine.getId());
			 label2.setText(machine.getIdAfpa());
			 label3.setText(machine.getIdUnique());
			 label4.setText(machine.getDateAchat());
			 label5.setText(machine.getDureeGarantie());
			 label6.setText(machine.getAdresseIP());
			 label7.setText(machine.getType());
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
	 
	 // Methode appel�e lorsque l'utilisateur clique sur le boutton de suppression
	 @FXML
	 private void handleDeletePerson() {
	  int selectedIndex = tableFX.getSelectionModel().getSelectedIndex();
	  tableFX.getItems().remove(selectedIndex);
	 }


	 
	 /**
	 * Appell� par l'application principale pour avoir une r�f�rence de retour sur elle-m�me
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX;
		 
		// Affichage des donn�es en mode console : fonctionnel	
		System.out.println(mainAppFX.getData().get(0).getAdresseIP());
		 
		// Ajout de la liste des donn�es observables dans le tableview " tableFX "
		tableFX.setItems(mainAppFX.getData()); //TODO : les donn�es sont dispo, mais l'insertion dans le tableview merde...
		
	 }
	
}