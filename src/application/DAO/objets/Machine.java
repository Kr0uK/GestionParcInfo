package application.DAO.objets;
/***********************************************************************
 * Module:  application.DAO.objets.Machine.java
 * Author:  FREDERIC
 * Purpose: Defines the Class application.DAO.objets.Machine
 ***********************************************************************/

import java.util.Collection;
import java.util.Date;

// IMPORT DES PROPERTIES :
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/*	PROPERTIES :
 *	Avec JavaFX il est courant d'utiliser les Properties pour tous les champs de votre classe.
 *	Une Property (propri�t�) nous permet, par exemple, d'�tre automatiquement averti lorsque la
 *	variable id ou toute autre variable a �t� modifi�e. 
 *	Ceci nous aide � maintenir la view synchronis�e avec les donn�es. 
 */

/**
 * @pdOid 29bd1de5-32fa-4bc5-ac7b-a0c0ed192d80
 */

public class Machine {

    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
    /** @pdOid 40555939-bba9-4d75-86cd-8625d6989102 */
    private final StringProperty id;
    @NotNull
    @Pattern(regexp = "^[0-9]{3}\\s[0-9]{4}$", message = "Veuillez entrer un identifiant valide")
    /** @pdOid e9a0a83d-ce7a-4cb7-9837-15df7bb2623b */
    private final StringProperty idAfpa;
    @NotNull
    @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un identifiant valide")
    /** @pdOid 607c1715-5c6c-47fa-886c-54b17c15e2db */
    private final StringProperty idUnique;

    @NotNull
    /** @pdOid 772da07e-d119-4af1-9b90-e46745521d0d */
    private final ObjectProperty<java.util.Date> dateAchat;

    /**
     * @pdOid c5643e4c-f69a-4635-b4ae-6b6f9f45273f
     */
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer une durée valide")
    private final StringProperty dureeGarantie;
    @NotNull
    @Pattern(regexp = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", message = "Veuillez entrer une adresse IP valide")
    /** @pdOid 1b8c0308-3320-4538-ae91-5b266e4b9908 */
    private final StringProperty adresseIP;
    @NotNull
    @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer une valeur valide")
    /** @pdOid 10b0d178-156a-4d1d-a648-d9afeb4c708f */
    private final StringProperty type;

    /**
     * @pdRoleInfo migr=no name=application.DAO.objets.Composant assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation
     */
    private java.util.Collection<Composant> composant;


    // ID
    public String getId() {
        return id.get();
    }

    public int getIntId() {
        return Integer.parseInt(getId());
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setId(int id) {
        this.id.set(String.valueOf(id));
    }

    public StringProperty idProperty() {
        return id;
    }


    // IDAFPA
    public String getIdAfpa() {
        return idAfpa.get();
    }

    public void setIdAfpa(String idAfpa) {
        this.idAfpa.set(idAfpa);
    }

    public StringProperty idAfpaProperty() {
        return idAfpa;
    }

    //IDUNIQUE
    public String getIdUnique() {
        return idUnique.get();
    }

    public void setIdUnique(String idUnique) {
        this.idUnique.set(idUnique);
    }

    public StringProperty idUniqueProperty() {
        return idUnique;
    }

    // DATEACHAT
    public Date getDateAchat() {
        return dateAchat.get();
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat.set(dateAchat);
    }

    public ObjectProperty<java.util.Date> dateAchatProperty() {
        return dateAchat;
    }

    // DUREEGARANTIE
    public String getDureeGarantie() {
        return dureeGarantie.get();
    }

    public int getIntDureeGarantie() {
        return Integer.parseInt(getId());
    }

    public void setDureeGarantie(String dureeGarantie) {
        this.dureeGarantie.set(dureeGarantie);
    }

    public void setDureeGarantie(int duree) {
        this.id.set(String.valueOf(duree));
    }

    public StringProperty dureeGarantieProperty() {
        return dureeGarantie;
    }


    // ADRESSEIP
    public String getAdresseIP() {
        return adresseIP.get();
    }

    public void setAdresseIP(String adresseIP) {
        this.adresseIP.set(adresseIP);
    }

    public StringProperty adresseIPProperty() {
        return adresseIP;
    }

    // TYPE
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }


    // MACHINE
   /*
   public Machine(int id, String idAfpa, String adresseIP) {
		  // CONVERSION EN TYPE D'OBJETS OBSERVABLES
	      this.id = new SimpleIntegerProperty(id);
	      this.idAfpa = new SimpleStringProperty(idAfpa);
	      this.adresseIP = new SimpleStringProperty(adresseIP);
   }
   */


    public Machine(String id, String idAfpa, String idUnique, Date dateAchat, String dureeGarantie, String adresseIP, String type, Collection<Composant> composant) {
        // CONVERSION EN TYPE D'OBJETS OBSERVABLES
        this.id = new SimpleStringProperty(id);
        this.idAfpa = new SimpleStringProperty(idAfpa);
        this.idUnique = new SimpleStringProperty(idUnique);
        this.dateAchat = new SimpleObjectProperty<java.util.Date>(dateAchat);
        this.dureeGarantie = new SimpleStringProperty(dureeGarantie);
        this.adresseIP = new SimpleStringProperty(adresseIP);
        this.type = new SimpleStringProperty(type);
        this.composant = composant;
    }


    // COMPOSANTS

    /**
     * @return *  @pdGenerated default getter
     */
    public java.util.Collection<Composant> getComposant() {
        if (composant == null)
            composant = new java.util.HashSet<Composant>();
        return composant;

    }

    /**
     * @return *  @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorComposant() {
        if (composant == null)
            composant = new java.util.HashSet<Composant>();
        return composant.iterator();
    }

    /**
     * @param newComposant
     * @pdGenerated default setter
     */
    public void setComposant(java.util.Collection<Composant> newComposant) {
        removeAllComposant();
        for (java.util.Iterator iter = newComposant.iterator(); iter.hasNext(); )
            addComposant((Composant) iter.next());
    }

    /**
     * @param newComposant
     * @pdGenerated default add
     */
    public void addComposant(Composant newComposant) {
        if (newComposant == null)
            return;
        if (this.composant == null)
            this.composant = new java.util.HashSet<Composant>();
        if (!this.composant.contains(newComposant))
            this.composant.add(newComposant);
    }

    /**
     * @param oldComposant
     * @pdGenerated default remove
     */
    public void removeComposant(Composant oldComposant) {
        if (oldComposant == null)
            return;
        if (this.composant != null)
            if (this.composant.contains(oldComposant))
                this.composant.remove(oldComposant);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllComposant() {
        if (composant != null)
            composant.clear();
    }


    // GARANTIE

    /**
     * @return *  @pdOid c048567c-b284-4a21-af5d-7e4f990bf0fe
     */
    public boolean estSousGarantie() {
        // TODO: implement
        return false;
    }
    // TODO : ?

    /**
     * @return *  @pdOid ed539b07-b49c-4883-8b95-773e5a3a6699
     */
    public boolean ipDispo() {
        // TODO: implement
        return false;
    }

}