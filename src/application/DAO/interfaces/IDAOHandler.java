package application.DAO.interfaces; /***********************************************************************
 * Module:  application.DAO.interfaces.IDAOHandler.java
 * Author:  RENAUD
 * Purpose: Defines the Interface application.DAO.interfaces.IDAOHandler
 ***********************************************************************/

import application.DAO.DAOConnection;

import java.util.List;

/** @pdOid 4249cbc3-8036-4cc9-95f5-90eab62c23bb */
public interface IDAOHandler {

   DAOConnection conn = new DAOConnection();
   /**
     * @return  *  @pdOid 41e6d4e8-a210-442b-a58a-38f904f76a4a */
   boolean ajouter();
   /**
     * @return  *  @pdOid bf9b1bd6-306d-4c1d-aedd-378ddc37d59f */
   boolean supprimer();
   /**
     * @return  *  @pdOid 4de53753-3fcc-431d-a646-ea419c243124 */
   boolean modifier();
   /**
     * @return  *  @pdOid 11955bc4-da27-46fb-90af-45e7fc487c5e */
   <T> List<T> lecture();

}