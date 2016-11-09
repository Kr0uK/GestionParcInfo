package application.DAO; /***********************************************************************
 * Module:  application.dao.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOMachine
 ***********************************************************************/

import application.objets.Composant;
import application.objets.Machine;
import application.interfaces.IDAOHandler;


import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMachine implements IDAOHandler {

    @Override
    public <T> boolean ajouter(T objet, String query) {
        JdbcRowSet rowSet = conn.connexion();
        Machine machineAdd = (Machine) objet;
        try {
            rowSet.setCommand(query);
            rowSet.execute();

            rowSet.moveToInsertRow();
            rowSet.updateInt(2, machineAdd.getIdLocal());
            rowSet.updateString(3, machineAdd.getIdUnique());
            rowSet.updateString(4, machineAdd.getIdAfpa());
            rowSet.updateString(5, machineAdd.getDateAchat());
            rowSet.updateInt(6, machineAdd.getDureeGarantie());
            rowSet.updateString(7, machineAdd.getType());
            rowSet.updateString(8, machineAdd.getAdresseIP());
            rowSet.updateBoolean(9, machineAdd.isPret());
            rowSet.updateInt(10, machineAdd.getIdLocal());

            rowSet.insertRow();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.fermer();
        }
    }

    @Override
    public boolean supprimer(String query, String id) {
        JdbcRowSet rowSet = conn.connexion();
        try {
            rowSet.setCommand(query + id);
            rowSet.execute();
            rowSet.first();
            rowSet.deleteRow();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            conn.fermer();
        }
    }

    @Override
    public <T> boolean modifier(T objet, String query, String id) {
        JdbcRowSet rowSet = conn.connexion();
        Machine machineUpdate = (Machine) objet;
        try {
            rowSet.setCommand(query + id);
            rowSet.execute();
            rowSet.first();

            rowSet.updateInt(2, machineUpdate.getIdLocal());
            rowSet.updateString(3, machineUpdate.getIdUnique());
            rowSet.updateString(4, machineUpdate.getIdAfpa());
            rowSet.updateString(5, machineUpdate.getDateAchat());
            rowSet.updateInt(6, machineUpdate.getDureeGarantie());
            rowSet.updateString(7, machineUpdate.getType());
            rowSet.updateString(8, machineUpdate.getAdresseIP());
            rowSet.updateBoolean(9, machineUpdate.isPret());

            rowSet.updateRow();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.fermer();
        }
    }

    @Override
    public <T> T lecture(String query, String id) {
        JdbcRowSet rowSet = conn.connexion();

        T machine = null;

        try {
            rowSet.setCommand(query + id);
            rowSet.execute();
            rowSet.first();

            Machine machineTemp = new Machine(1, 1, "4666", "6664", "2016-11-01", 5, "Tablette", "192.168.255.0", false, 1, new ArrayList<Composant>());

            machineTemp.setId(rowSet.getInt(1));
            machineTemp.setIdLocal(rowSet.getInt(2));
            machineTemp.setIdUnique(rowSet.getString(3));
            machineTemp.setIdAfpa(rowSet.getString(4));
            machineTemp.setDateAchat(rowSet.getString(5));
            machineTemp.setDureeGarantie(rowSet.getInt(6));
            machineTemp.setType(rowSet.getString(7));
            machineTemp.setAdresseIP(rowSet.getString(8));
            machineTemp.setPret(rowSet.getBoolean(9));
            machineTemp.setLocalOrigine(rowSet.getInt(10));

            machine = (T) machineTemp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.fermer();
        return machine;
    }

    @Override
    public <T> List<T> lecture(String query) {
        JdbcRowSet rowSet = conn.connexion();

        List<T> machines = new ArrayList<>();

        try {
            rowSet.setCommand(query);
            rowSet.execute();

            while (rowSet.next()) {
                Machine machine = new Machine(1, 1, "4666", "6664", "2016-11-01", 5, "Tablette", "192.168.255.0", false, 1, new ArrayList<Composant>());
                machine.setId(rowSet.getInt(1));
                machine.setIdLocal(rowSet.getInt(2));
                machine.setIdUnique(rowSet.getString(3));
                machine.setIdAfpa(rowSet.getString(4));
                machine.setDateAchat(rowSet.getString(5));
                machine.setDureeGarantie(rowSet.getInt(6));
                machine.setType(rowSet.getString(7));
                machine.setAdresseIP(rowSet.getString(8));
                machine.setPret(rowSet.getBoolean(9));
                machine.setLocalOrigine(rowSet.getInt(10));
                boolean add = machines.add((T) machine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.fermer();
        return machines;
    }

    @Override
    public <T> boolean verifier(T objet) {
        return false;
    }
}