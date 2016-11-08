package application.DAO; /***********************************************************************
 * Module:  application.dao.DAOBatiment.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOBatiment
 ***********************************************************************/

import application.interfaces.IDAOHandler;

import java.util.List;

/** @pdOid 5deba7bc-222a-4be2-aa5d-20689d4fd332 */
public class DAOBatiment implements IDAOHandler {
    @Override
    public boolean ajouter() {
        return false;
    }

    @Override
    public boolean supprimer() {
        return false;
    }

    @Override
    public boolean modifier() {
        return false;
    }

    @Override
    public <T> List<T> lecture(T objet, String query, int id) {
        return null;
    }
}