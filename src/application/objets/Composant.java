package application.objets; /***********************************************************************
 * Module:  application.beans.Composant.java
 * Author:  admin
 * Purpose: Defines the Class application.beans.Composant
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/** @pdOid 3fe5ebfb-9410-4c66-a182-336ae567dfdf */
public class Composant {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   /** @pdOid 8cf34e34-498b-42a9-962b-273ef436681a */
   private int id;

   @NotNull
   /** @pdOid 26b94fdb-833d-4ea4-9b44-6f079bf737d5 */
   private String reference;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un constructeur valide")
   /** @pdOid 9123d616-2086-4cb6-b345-4eb144ec0899 */
   private String constructeur;

   @NotNull
   /** @pdOid 6f27cd51-2014-4b04-b910-a6c562a77208 */
   private String libelle;

   @NotNull
   /** @pdOid aa778ffc-2127-47f3-ae51-83f20dc41e47 */
   private String details;

   private int idMachine;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

   public String getConstructeur() {
      return constructeur;
   }

   public void setConstructeur(String constructeur) {
      this.constructeur = constructeur;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public int getIdMachine() {
      return idMachine;
   }

   public void setIdMachine(int idMachine) {
      this.idMachine = idMachine;
   }

   public Composant() {
   }

   public Composant(int id, String reference, String constructeur, String libelle, String details, int idMachine) {
      this.id = id;
      this.reference = reference;
      this.constructeur = constructeur;
      this.libelle = libelle;
      this.details = details;
      this.idMachine = idMachine;
   }
}