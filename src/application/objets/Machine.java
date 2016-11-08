package application.objets;
/***********************************************************************
 * Module:  application.objets.Machine.java
 * Author:  FREDERIC
 * Purpose: Defines the Class application.objets.Machine
 ***********************************************************************/

//import java.util.Map;

// IMPORT DES PROPERTIES :
import javafx.beans.property.StringProperty;
        import javafx.beans.property.SimpleStringProperty;

        import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/*	PROPERTY :
 *	Avec JavaFX il est courant d'utiliser les Properties pour tous les champs de votre classe.
 *	Une Property (propriété) nous permet, par exemple, d'être automatiquement averti lorsque la
 *	variable id ou toute autre variable a été modifiée.
 *	Ceci nous aide à maintenir la view synchronisée avec les données.
 */

//import javafx.beans.binding.Bindings;
//import javafx.util.StringConverter;


/**
 * @pdOid 29bd1de5-32fa-4bc5-ac7b-a0c0ed192d80
 */
public class Machine {


    private int idLocal;

    //STRING - TODO : types variables a revoir
    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
    private int id;
    @NotNull
    @Pattern(regexp = "^[0-9]{3}\\s[0-9]{4}$", message = "Veuillez entrer un identifiant valide")
    private String idAfpa;
    @NotNull
    @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un identifiant valide")
    private String idUnique;
    @NotNull
    private String dateAchat;
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer une durée valide")
    private String dureeGarantie;
    @NotNull
    @Pattern(regexp = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", message = "Veuillez entrer une adresse IP valide")
    private String adresseIP;
    @NotNull
    @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer une valeur valide")
    private String type;
    private String localOrigine;

    // STRINGPROPERTY
    private StringProperty idSP;

    private StringProperty idAfpaSP;

    private StringProperty idUniqueSP;

    private StringProperty dateAchatSP;

    private StringProperty dureeGarantieSP;

    private StringProperty adresseIPSP;

    private StringProperty typeSP;

    private SimpleStringProperty localOrigineSP;

    // COMPOSANTS - TODO
    /**
     * @pdRoleInfo migr=no name=application.objets.Composant assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation
     */
    private java.util.Collection<Composant> composant;


	   /*
        * GETTERS / SETTERS
	    */

    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // StringProperty
    public String getIdSP() {
        return idSP.get();
    }

    public int getIntIdSP() {
        return getId();
    }

    public void setIdSP(String id) {
        this.idSP.set(id);
    }

    public void setIdSP(int id) {
        this.idSP.set(String.valueOf(id));
    }

    public StringProperty idProperty() {
        return idSP;
    }


    // IDAFPA
    public String getIdAfpa() {
        return idAfpa;
    }

    public void setIdAfpa(String idAfpa) {
        this.idAfpa = idAfpa;
    }

    // StringProperty
    public String getIdAfpaSP() {
        return idAfpaSP.get();
    }

    public void setIdAfpaSP(String idAfpa) {
        this.idAfpaSP.set(idAfpa);
    }

    public StringProperty idAfpaProperty() {
        return idAfpaSP;
    }

    // IDUNIQUE
    public String getIdUnique() {
        return idUnique;
    }

    public void setIdUnique(String idUnique) {
        this.idUnique = idUnique;
    }

    // StringProperty
    public String getIdUniqueSP() {
        return idUniqueSP.get();
    }

    public void setIdUniqueSP(String idUnique) {
        this.idUniqueSP.set(idUnique);
    }

    public StringProperty idUniqueProperty() {
        return idUniqueSP;
    }

    // DATEACHAT
    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    // StringProperty
    public String getDateAchatSP() {
        return dateAchatSP.get();
    }

    public void setDateAchatSP(String dateAchat) {
        this.dateAchatSP.set(dateAchat);
    }

    public StringProperty dateAchatProperty() {
        return dateAchatSP;
    }

    // DUREEGARANTIE
    public String getDureeGarantie() {
        return dureeGarantie;
    }

    public void setDureeGarantie(String dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    // StringProperty
    public String getDureeGarantieSP() {
        return dureeGarantieSP.get();
    }

    public int getIntDureeGarantieSP() {
        return Integer.parseInt(getDureeGarantie());
    }

    public void setDureeGarantieSP(String dureeGarantie) {
        this.dureeGarantieSP.set(dureeGarantie);
    }

    public void setDureeGarantieSP(int duree) {
        this.dureeGarantieSP.set(String.valueOf(duree));
    }

    public StringProperty dureeGarantieProperty() {
        return dureeGarantieSP;
    }

    // ADRESSEIP
    public String getAdresseIP() {
        return adresseIP;
    }

    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    // StringProperty
    public String getAdresseIPSP() {
        return adresseIPSP.get();
    }

    public void setAdresseIPSP(String adresseIP) {
        this.adresseIPSP.set(adresseIP);
    }

    public StringProperty adresseIPProperty() {
        return adresseIPSP;
    }

    // TYPE
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // StringProperty
    public String getTypeSP() {
        return typeSP.get();
    }

    public void setTypeSP(String type) {
        this.typeSP.set(type);
    }

    public StringProperty typeProperty() {
        return typeSP;
    }

    public String getLocalOrigine() {
        return localOrigine;
    }

    public void setLocalOrigine(String localOrigine) {
        this.localOrigine = localOrigine;
    }
    public String getLocalOrigineSP() {
        return localOrigineSP.get();
    }

    public void setLocalOrigineSP(String localOrigine) {
        this.localOrigineSP.set(type);
    }

    public StringProperty localOrigineProperty() {
        return localOrigineSP;
    }

    // Requête d'ajout
    //TODO les autres requetes pour tous les beans :(
    String reqAjout = "INSERT INTO " + Machine.class.getSimpleName().toUpperCase() + " VALUES (" + id + "," + idAfpa + "," + idUnique + "," + dateAchat + "," + dureeGarantie + "," + adresseIP + "," + type + ")";

    /*
     * CONSTRUCTEURS
     */
    public Machine() {
    }

    public Machine(int id, String idAfpa, String idUnique, String dateAchat, String dureeGarantie, String adresseIP, String type, String localOrigine) {
        this.id = id;
        this.idAfpa = idAfpa;
        this.idUnique = idUnique;
        this.dateAchat = dateAchat;
        this.dureeGarantie = dureeGarantie;
        this.adresseIP = adresseIP;
        this.type = type;
        this.localOrigine = localOrigine;

        // CONVERSION EN TYPE D'OBJETS OBSERVABLES
        this.idSP = new SimpleStringProperty("" + id);
        this.idAfpaSP = new SimpleStringProperty(idAfpa);
        this.idUniqueSP = new SimpleStringProperty(idUnique);
        this.dateAchatSP = new SimpleStringProperty(dateAchat);
        this.dureeGarantieSP = new SimpleStringProperty(dureeGarantie);
        this.adresseIPSP = new SimpleStringProperty(adresseIP);
        this.typeSP = new SimpleStringProperty(type);
        this.localOrigineSP = new SimpleStringProperty(localOrigine);
    }
       /*
       public Machine(String id, String idAfpa, String idUnique, Date dateAchat, String dureeGarantie, String adresseIP, String type, Collection<Composant> composant) {
		  // CONVERSION EN TYPE D'OBJETS OBSERVABLES
	      this.id = new SimpleStringProperty(id);
	      this.idAfpa = new SimpleStringProperty(idAfpa);
	      this.idUnique = new SimpleStringProperty(idUnique);
	      this.dateAchat = new SimpleObjectProperty<java.util.Date>(dateAchat);
	      this.dureeGarantie = new SimpleStringProperty(dureeGarantie);
	      this.adresseIP = new SimpleStringProperty(adresseIP);
	      this.type = new SimpleStringProperty(type);
	      // ET DE COMPOSANTS
	      this.composant = composant;
	   }
	   */


	   /*
	    *  COMPOSANTS
	    */

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


    // TODO

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