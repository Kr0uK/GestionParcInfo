package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.Logiciel.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.objets.Logiciel
 ***********************************************************************/


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @pdOid 1d702f3f-4f03-44d8-9fc1-4809d7fafb5c
 */
public class Logiciel extends Composant {

    @NotNull
    @Pattern(regexp = "(32|64)", message = "Veuillez entrer une architecture valide (32 ou 64 bits).")
    /** @pdOid 9fec35af-ac55-4a9b-8175-50947eb7a6e8 */
    private int architecture;

    public int getArchitecture() {
        return architecture;
    }

    public void setArchitecture(int architecture) {
        this.architecture = architecture;
    }

    public Logiciel(int architecture) {
        super();
        this.architecture = architecture;
    }

    public Logiciel(int id, String reference, String constructeur, String libelle, String details, int architecture) {
        super(id, reference, constructeur, libelle, details);
        this.architecture = architecture;
    }
}