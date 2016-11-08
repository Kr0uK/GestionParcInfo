package application.DAO; /***********************************************************************
 * Module:  application.dao.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOMachine
 ***********************************************************************/

import application.beans.Composant;
import application.beans.Machine;
import application.interfaces.IDAOHandler;
import application.tools.LectureRB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** @pdOid 8850f737-a717-44d5-85cf-4dc95e6871c5 */
public class DAOMachine implements IDAOHandler {

    String test;

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
/*
        QueryRunner run = new QueryRunner();
        ResultSetHandler<List<Machine>> beanListHandler = new BeanListHandler<>(Machine.class);
        DAOComposant daoComposant = new DAOComposant();
        try {
            List<Machine> machines = run.query(conn.connexion(), query, beanListHandler);

            for(Machine machine : machines){

                List<Composant> composants;
                composants = daoComposant.lecture(new Composant(), LectureRB.lireRB("lecturesComposantsM"), machine.getId());
                machine.setComposant(composants);
            }

            List<T> tList;
            tList = (List<T>) machines;

            return tList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            conn.fermer();
        }
*/
        JdbcRowSet rowSet = conn.connexion();

        List<T> machines = new ArrayList<>();

        try {
            rowSet.setCommand(query);
            rowSet.execute();

            while (rowSet.next()){
                Machine machine = new Machine();
                machine.setDateAchat(rowSet.getString(5));
                System.out.println(rowSet.getString(5));
                machines.add((T) machine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return machines;
    }
}