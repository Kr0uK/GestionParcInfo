package application.DAO; /***********************************************************************
 * Module:  application.dao.DAOSalle.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOSalle
 ***********************************************************************/

import application.interfaces.IDAOHandler;

import java.util.List;

/** @pdOid 48949297-0e27-4222-ae4f-02358912267c */
public class DAOSalle implements IDAOHandler {
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