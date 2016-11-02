package application.objets; /***********************************************************************
 * Module:  application.objets.Salle.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Salle
 ***********************************************************************/

import java.util.Collection;

/** @pdOid 03b2ad1a-8313-4e6a-a79b-deca79847e9d */
public class Salle {
   /** @pdOid ac352b46-d631-470d-aebd-4a93f4aad5c0 */
   private int id;
   /** @pdOid f06e9882-c6c0-46ec-851b-f6cd37b14c81 */
   private String numero;
   
   /** @pdRoleInfo migr=no name=application.objets.Machine assc=association2 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Machine> machine;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNumero() {
      return numero;
   }

   public void setNumero(String numero) {
      this.numero = numero;
   }

   public Salle(int id, String numero, Collection<Machine> machine) {

      this.id = id;
      this.numero = numero;
      this.machine = machine;
   }

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Machine> getMachine() {
      if (machine == null)
         machine = new java.util.HashSet<Machine>();
      return machine;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMachine() {
      if (machine == null)
         machine = new java.util.HashSet<Machine>();
      return machine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMachine */
   public void setMachine(java.util.Collection<Machine> newMachine) {
      removeAllMachine();
      for (java.util.Iterator iter = newMachine.iterator(); iter.hasNext();)
         addMachine((Machine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMachine */
   public void addMachine(Machine newMachine) {
      if (newMachine == null)
         return;
      if (this.machine == null)
         this.machine = new java.util.HashSet<Machine>();
      if (!this.machine.contains(newMachine))
         this.machine.add(newMachine);
   }
   
   /** @pdGenerated default remove
     * @param oldMachine */
   public void removeMachine(Machine oldMachine) {
      if (oldMachine == null)
         return;
      if (this.machine != null)
         if (this.machine.contains(oldMachine))
            this.machine.remove(oldMachine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMachine() {
      if (machine != null)
         machine.clear();
   }

}