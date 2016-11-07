package application.DAO; /***********************************************************************
 * Module:  application.DAO.DAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.DAOConnection
 ***********************************************************************/

import application.DAO.interfaces.IDAOConnection;
import application.DAO.objets.Machine;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @pdOid e1f67259-29a6-4ad8-8312-7ca59c54385f
 */
public class DAOConnection implements IDAOConnection {

    Connection conn = null;

    @Override
    public boolean connexion() {

        try {

            DbUtils.loadDriver(DRIVER);
            conn = DriverManager.getConnection(ADRESSE, USER, MDP);

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    @Override
    public boolean fermer() {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}