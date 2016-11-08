package application.DAO.objets; /***********************************************************************
 * Module:  application.DAO.objets.Batiment.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.objets.Batiment
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/** @pdOid 083aa14e-4ca0-4718-b4c2-fd6b665c604a */
public class Batiment {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   /** @pdOid 0b8ebf22-7006-47b4-a3d8-afa3a1fe07da */
   private int id;

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   /** @pdOid 0b8ebf22-7006-47b4-a3d8-afa3a1fe07da */
   private int numero;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getNumero() {
      return numero;
   }

   public void setNumero(int numero) {
      this.numero = numero;
   }

   public Batiment() {
   }

   public Batiment(int id, int numero, Collection<Salle> salle) {
      this.id = id;
      this.numero = numero;
      this.salle = salle;
   }

   @NotNull
   /** @pdRoleInfo migr=no name=application.DAO.objets.Salle assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Salle> salle;
   
   
   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Salle> getSalle() {
      if (salle == null)
         salle = new java.util.HashSet<Salle>();
      return salle;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSalle() {
      if (salle == null)
         salle = new java.util.HashSet<Salle>();
      return salle.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSalle */
   public void setSalle(java.util.Collection<Salle> newSalle) {
      removeAllSalle();
      for (java.util.Iterator iter = newSalle.iterator(); iter.hasNext();)
         addSalle((Salle)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSalle */
   public void addSalle(Salle newSalle) {
      if (newSalle == null)
         return;
      if (this.salle == null)
         this.salle = new java.util.HashSet<Salle>();
      if (!this.salle.contains(newSalle))
         this.salle.add(newSalle);
   }
   
   /** @pdGenerated default remove
     * @param oldSalle */
   public void removeSalle(Salle oldSalle) {
      if (oldSalle == null)
         return;
      if (this.salle != null)
         if (this.salle.contains(oldSalle))
            this.salle.remove(oldSalle);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSalle() {
      if (salle != null)
         salle.clear();
   }

}