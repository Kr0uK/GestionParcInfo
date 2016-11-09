package application.objets; /***********************************************************************
 * Module:  application.beans.Site.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Site
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/** @pdOid 97ae18c2-e8e8-4d7c-8da4-3322509a9136 */
public class Site {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   /** @pdOid ff7364da-5b1a-4604-90b8-6e8839be31e9 */
   private int id;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un libellé valide")
   /** @pdOid c224e4a6-80ac-455c-b557-7dfa608d3f37 */
   private String libelle;

   @NotNull
   /** @pdOid 4cd9614e-d702-444c-9e07-7dcf8af70d31 */
   private String adresse;

   @NotNull
   @Pattern(regexp = "[0-9]{5}", message = "Veuillez entrer un code postal valide")
   /** @pdOid a254f799-4887-41f9-982d-8d65b743ff40 */
   private String cp;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer une ville valide")
   /** @pdOid 8bfb47c5-ef02-4b63-a50e-3ea84c9d02d9 */
   private String ville;
   
   /** @pdRoleInfo migr=no name=application.beans.Batiment assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Batiment> batiment;


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


   public String getAdresse() {
      return adresse;
   }

   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   public String getCp() {
      return cp;
   }

   public void setCp(String cp) {
      this.cp = cp;
   }

   public String getVille() {
      return ville;
   }

   public void setVille(String ville) {
      this.ville = ville;
   }

   public Site() {
   }

   public Site(int id, String libelle, String adresse, String cp, String ville, Collection<Batiment> batiment) {
      this.id = id;
      this.libelle = libelle;
      this.adresse = adresse;
      this.cp = cp;
      this.ville = ville;
      this.batiment = batiment;
   }

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Batiment> getBatiment() {
      if (batiment == null)
         batiment = new java.util.HashSet<Batiment>();
      return batiment;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBatiment() {
      if (batiment == null)
         batiment = new java.util.HashSet<Batiment>();
      return batiment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBatiment */
   public void setBatiment(java.util.Collection<Batiment> newBatiment) {
      removeAllBatiment();
      for (java.util.Iterator iter = newBatiment.iterator(); iter.hasNext();)
         addBatiment((Batiment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBatiment */
   public void addBatiment(Batiment newBatiment) {
      if (newBatiment == null)
         return;
      if (this.batiment == null)
         this.batiment = new java.util.HashSet<Batiment>();
      if (!this.batiment.contains(newBatiment))
         this.batiment.add(newBatiment);
   }
   
   /** @pdGenerated default remove
     * @param oldBatiment */
   public void removeBatiment(Batiment oldBatiment) {
      if (oldBatiment == null)
         return;
      if (this.batiment != null)
         if (this.batiment.contains(oldBatiment))
            this.batiment.remove(oldBatiment);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBatiment() {
      if (batiment != null)
         batiment.clear();
   }

}