package application.beans; /***********************************************************************
 * Module:  application.beans.DisqueDur.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.DisqueDur
 ***********************************************************************/

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @pdOid 33f611c4-528e-4aeb-9bf5-98798acda2b6
 */
public class DisqueDur extends Composant {

    @NotNull
    @Pattern(regexp = "(SSD|HDD|FSH)", message = "Veuillez entrer une valeur valide.")
    /** @pdOid 8ba508f1-8ef2-4f1f-bd7f-c9b6d1c7aad7 */
    private String format;

    @NotNull
    @Min(1)
    /** @pdOid e2c22951-6756-4457-8441-d7eaec8d0e5a */
    private int stockageGo;

    public String getType() {
        return format;
    }

    public void setType(String type) {
        this.format = type;
    }

    public int getStockageGo() {
        return stockageGo;
    }

    public void setStockageGo(int stockageGo) {
        this.stockageGo = stockageGo;
    }

    public DisqueDur() {

    }


    public DisqueDur(int id, String reference, String constructeur, String libelle, String details,int idMachine, String format, int stockageGo) {
        super(id, reference, constructeur, libelle, details, idMachine);
        this.format = format;
        this.stockageGo = stockageGo;
    }
}