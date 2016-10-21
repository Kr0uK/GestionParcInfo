package objets; /***********************************************************************
 * Module:  objets.Role.java
 * Author:  admin
 * Purpose: Defines the Class objets.Role
 ***********************************************************************/

import java.util.*;

/** @pdOid 9deeaa81-12e9-4c1e-9088-4cc779421093 */
public class Role {
   /** @pdOid 39976556-5d14-4041-a2ef-ff726af7aa40 */
   private int id;
   /** @pdOid 97bd4c44-aebc-4147-a4de-79909b9d4212 */
   private String libelle;

   public Role(int id, String libelle) {
      this.id = id;
      this.libelle = libelle;
   }

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
}