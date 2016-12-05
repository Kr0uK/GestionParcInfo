package application.viewer;

import application.dao.DAOMachine;
import application.tools.LectureRB;
import application.tools.Verif;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

import application.MainAppFX;
import application.beans.Machine;
import application.tools.Sound;

/**
 * @author Neo_Ryu
 */
public class MachineEditDialogController {

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
	private TextField txtfld7;

	private Stage dialogStage;
	private Machine machine;
	private boolean okClic = false;

	@FXML
	private Label Label1, Label2, Label3, Label4, Label5, Label6, Label7;

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
	}

	// STAGE
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// DEFINIR TEXTE DES TEXTFIELDS
	public void setMachine(Machine machine) {
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

		// CONFIGURATION DES TEXTFIELD
		this.machine = machine;
		if (MachineController.btnSelected == "SELECT")
			txtfld1.setText(String.valueOf(machine.getId()));
		txtfld1.setFont(MainAppFX.f);
		txtfld2.setText(machine.getIdAfpa());
		txtfld2.setFont(MainAppFX.f);
		txtfld3.setText(machine.getIdUnique());
		txtfld3.setFont(MainAppFX.f);
		txtfld4.setText(machine.getDateAchat());
		txtfld4.setFont(MainAppFX.f);
		if (MachineController.btnSelected == "SELECT")
			txtfld5.setText(String.valueOf(machine.getDureeGarantie()));
		txtfld5.setFont(MainAppFX.f);
		txtfld6.setText(machine.getAdresseIP());
		txtfld6.setFont(MainAppFX.f);
		txtfld7.setText(machine.getType());
		txtfld7.setFont(MainAppFX.f);
	}

	// BOUTON OK : MainAppFX
	public boolean isOkClic() {
		return okClic;
	}

	// VALIDATION ENVOI
	@FXML
	private void handleOk() {
		machine.setId(Integer.parseInt(txtfld1.getText()));
		machine.setIdAfpa(txtfld2.getText());
		machine.setIdUnique(txtfld3.getText());
		machine.setDateAchat(txtfld4.getText());
		machine.setDureeGarantie(Integer.parseInt(txtfld5.getText()));
		machine.setAdresseIP(txtfld6.getText());
		machine.setType(txtfld7.getText());
		// Verification avant stockage
		if (isInputValid()) {

			okClic = true;
			dialogStage.close();
		}
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

	// VERIFICATION
	private boolean isInputValid() {
		Alert alert = new Alert(AlertType.ERROR);
		// Affichage d'un message d'erreur si la taille de la chaine est superieur a 0
		if (Verif.verifier(machine, alert) && machine.ipDispo(alert)) {
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
			alert.initOwner(dialogStage);
			alert.setTitle("Champs manquants ou incorrects");
			alert.setHeaderText("Veuillez remplir correctement les champs...");
			alert.showAndWait();
			return false;
		}
	}
}
