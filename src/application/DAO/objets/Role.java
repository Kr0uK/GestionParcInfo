package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.Role.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.objets.Role
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/** @pdOid 9deeaa81-12e9-4c1e-9088-4cc779421093 */
public class Role {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   /** @pdOid 39976556-5d14-4041-a2ef-ff726af7aa40 */
   private int id;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un rôle valide")
   /** @pdOid 97bd4c44-aebc-4147-a4de-79909b9d4212 */
   private String libelle;
   
   /** @pdRoleInfo migr=no name=application.DAO.objets.Utilisateur assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Utilisateur> utilisateur;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public Role() {
   }

   public Role(int id, String libelle, Collection<Utilisateur> utilisateur) {

      this.id = id;
      this.libelle = libelle;
      this.utilisateur = utilisateur;
   }

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Utilisateur> getUtilisateur() {
      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();

      return utilisateur;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIndividu() {
      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();
      return utilisateur.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUtilisateur */
   public void setUtilisateur(java.util.Collection<Utilisateur> newUtilisateur) {
      removeAllIndividu();
      for (java.util.Iterator iter = newUtilisateur.iterator(); iter.hasNext();)
         addIndividu((Utilisateur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUtilisateur */
   public void addIndividu(Utilisateur newUtilisateur) {
      if (newUtilisateur == null)
         return;
      if (this.utilisateur == null)
         this.utilisateur = new java.util.HashSet<Utilisateur>();
      if (!this.utilisateur.contains(newUtilisateur))
      {
         this.utilisateur.add(newUtilisateur);
         newUtilisateur.addRole(this);
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUtilisateur */
   public void removeIndividu(Utilisateur oldUtilisateur) {
      if (oldUtilisateur == null)
         return;
      if (this.utilisateur != null)
         if (this.utilisateur.contains(oldUtilisateur))
         {
            this.utilisateur.remove(oldUtilisateur);
            oldUtilisateur.removeRole(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIndividu() {
      if (utilisateur != null)
      {
         Utilisateur oldUtilisateur;
         for (java.util.Iterator iter = getIteratorIndividu(); iter.hasNext();)
         {
            oldUtilisateur = (Utilisateur)iter.next();
            iter.remove();
            oldUtilisateur.removeRole(this);
         }
      }
   }

}