package application.viewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import application.MainAppFX;

/**
*
* @author Neo_Ryu
*/
public class OverviewController {
		
		 
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
		 
		 
	}
	 
	 /**
	 * Appell� par l'application principale pour avoir une r�f�rence de retour sur elle-m�me
	 *
	 * @param mainApp
	 */
	 public void setMainAppFX(MainAppFX mainAppFX) {		
		this.mainAppFX = mainAppFX;

		
	 }
	
}