package application.DAO; /***********************************************************************
 * Module:  application.DAO.DAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.DAOConnection
 ***********************************************************************/

import application.DAO.interfaces.IDAOConnection;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @pdOid e1f67259-29a6-4ad8-8312-7ca59c54385f
 */
public class DAOConnection implements IDAOConnection {

    Connection conn = null;

    @Override
    public Connection connexion() {

        try {

            DbUtils.loadDriver(DRIVER);
            conn = DriverManager.getConnection(ADRESSE, USER, MDP);

            return conn;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
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