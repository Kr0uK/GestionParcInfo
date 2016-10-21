package objets; /***********************************************************************
 * Module:  objets.Ram.java
 * Author:  admin
 * Purpose: Defines the Class objets.Ram
 ***********************************************************************/

/** @pdOid d1b87622-3842-492a-8422-31b2a7f8be38 */
public class Ram extends Composant {
   /** @pdOid f1470625-2b39-40fb-a985-f4e4543dc105 */
   private int quantite;

   public int getQuantite() {
      return quantite;
   }

   public void setQuantite(int quantite) {
      this.quantite = quantite;
   }

   public Ram(int id, String reference, String constructeur, String libelle, String details) {
      super(id, reference, constructeur, libelle, details);
   }
}