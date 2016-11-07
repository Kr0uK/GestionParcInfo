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
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    public List<T> lecture() {


        QueryRunner run = new QueryRunner();

        ResultSetHandler<List<T>> resMachine = new BeanListHandler<T>((Class<T>) Machine.class);
        try {

            List<T> machine = run.query(conn.connexion(),"SELECT * FROM MACHINE", resMachine);
            return machine;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}