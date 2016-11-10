package application.beans; /***********************************************************************
 * Module:  application.beans.Ram.java
 * Author:  admin
 * Purpose: Defines the Class application.beans.Ram
 ***********************************************************************/

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @pdOid d1b87622-3842-492a-8422-31b2a7f8be38
 */
public class Ram extends Composant {

    @NotNull
    @Min(1)
    /** @pdOid f1470625-2b39-40fb-a985-f4e4543dc105 */
    private int capaciteGo;

    public int getCapaciteGo() {
        return capaciteGo;
    }

    public void setCapaciteGo(int capaciteGo) {
        this.capaciteGo = capaciteGo;
    }

    public Ram() {
        super();
    }

    public Ram(int id, String reference, String constructeur, String libelle, String details,int idMachine, int capaciteGo) {
        super(id, reference, constructeur, libelle, details, idMachine);
        this.capaciteGo = capaciteGo;
    }
}