package application.DAO; /***********************************************************************
 * Module:  application.DAO.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.DAOMachine
 ***********************************************************************/

import application.DAO.interfaces.IDAOHandler;
import application.DAO.objets.Machine;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.Connection;
import java.sql.SQLException;

/** @pdOid 8850f737-a717-44d5-85cf-4dc95e6871c5 */
public class DAOMachine implements IDAOHandler {


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
    public <T>T lecture() {


        QueryRunner run = new QueryRunner();

        ResultSetHandler<T> resMachine = new BeanHandler<T>((Class<T>) Machine.class);
        T machine = null;
        try {

            machine = run.query(conn.connexion(),"SELECT * FROM MACHINE WHERE id = ?", resMachine, 3);
            return machine;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}