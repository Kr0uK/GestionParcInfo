package objets; /***********************************************************************
 * Module:  objets.DisqueDur.java
 * Author:  admin
 * Purpose: Defines the Class objets.DisqueDur
 ***********************************************************************/

/** @pdOid 33f611c4-528e-4aeb-9bf5-98798acda2b6 */
public class DisqueDur extends Composant {
   /** @pdOid 8ba508f1-8ef2-4f1f-bd7f-c9b6d1c7aad7 */
   private String type;
   /** @pdOid e2c22951-6756-4457-8441-d7eaec8d0e5a */
   private int stockage;
   /** @pdOid c9414f71-118e-408f-b3b4-59d87a78281b */
   private float format;

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getStockage() {
      return stockage;
   }

   public void setStockage(int stockage) {
      this.stockage = stockage;
   }

   public float getFormat() {
      return format;
   }

   public void setFormat(float format) {
      this.format = format;
   }

   public DisqueDur(int id, String reference, String constructeur, String libelle, String details) {
      super(id, reference, constructeur, libelle, details);
   }
}