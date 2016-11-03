package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.Processeur.java
 * Author:  admin
 * Purpose: Defines the Class application.DAO.objets.Processeur
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/** @pdOid 5d6517c4-b800-475d-9f03-aa10f3fba23c */
public class Processeur extends Composant {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer une valeur valide")
   /** @pdOid 2cb68de5-5db8-47fd-b718-6acc624ad2fa */
   private int coeurs;

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer une valeur valide en MHz")
   /** @pdOid 33d84ff6-d1f8-435c-a9a8-34644e839e9e */
   private int frequence;

   public int getCoeurs() {
      return coeurs;
   }

   public void setCoeurs(int coeurs) {
      this.coeurs = coeurs;
   }

   public int getFrequence() {
      return frequence;
   }

   public void setFrequence(int frequence) {
      this.frequence = frequence;
   }

   public Processeur() {
      super();
   }

   public Processeur(int coeurs, int frequence) {
      super();
      this.coeurs = coeurs;
      this.frequence = frequence;
   }
}