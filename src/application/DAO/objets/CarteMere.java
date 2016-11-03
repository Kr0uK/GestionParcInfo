package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.CarteMere.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.objets.CarteMere
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/** @pdOid c4da89b7-f727-476c-b028-3b0bd309f63b */
public class CarteMere extends Composant {

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un format de carte mère valide")
   /** @pdOid e0d3ef73-1616-4bfb-84d1-b0d5fc28444e */
   private String format;

   public String getFormat() {
      return format;
   }

   public void setFormat(String format) {

      this.format = format;
   }

   public CarteMere() {
      super();
   }

   public CarteMere(String format) {
      super();
      this.format = format;
   }

   public CarteMere(int id, String reference, String constructeur, String libelle, String details, String format) {
      super(id, reference, constructeur, libelle, details);
      this.format = format;
   }
}