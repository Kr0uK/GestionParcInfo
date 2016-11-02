package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.DisqueDur.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.objets.DisqueDur
 ***********************************************************************/

import javax.validation.constraints.NotNull;

/** @pdOid 33f611c4-528e-4aeb-9bf5-98798acda2b6 */
public class DisqueDur extends Composant {

   @NotNull
   /** @pdOid 8ba508f1-8ef2-4f1f-bd7f-c9b6d1c7aad7 */
   private String type;

   @NotNull
   /** @pdOid e2c22951-6756-4457-8441-d7eaec8d0e5a */
   private int stockageGo;

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getStockageGo() {
      return stockageGo;
   }

   public void setStockageGo(int stockageGo) {
      this.stockageGo = stockageGo;
   }

   public DisqueDur() {
      super();
   }

   public DisqueDur(String type, int stockageGo) {
      super();
      this.type = type;
      this.stockageGo = stockageGo;
   }

   public DisqueDur(int id, String reference, String constructeur, String libelle, String details, String type, int stockageGo) {
      super(id, reference, constructeur, libelle, details);
      this.type = type;
      this.stockageGo = stockageGo;
   }
}