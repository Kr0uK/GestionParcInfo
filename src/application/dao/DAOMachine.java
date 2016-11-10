package application.dao; /***********************************************************************
 * Module:  application.dao.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOMachine
 ***********************************************************************/

import application.beans.Machine;
import application.interfaces.IDAOHandler;
import application.tools.LectureRB;


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
            rowSet.updateInt(LectureRB.lireRB("champ", "localId"), machineAdd.getIdLocal());
            rowSet.updateString(LectureRB.lireRB("champ", "machineIdUnique"), machineAdd.getIdUnique());
            rowSet.updateString(LectureRB.lireRB("champ", "machineIdAfpa"), machineAdd.getIdAfpa());
            rowSet.updateString(LectureRB.lireRB("champ", "machineDateAchat"), machineAdd.getDateAchat());
            rowSet.updateInt(LectureRB.lireRB("champ", "machineDureeGarantie"), machineAdd.getDureeGarantie());
            rowSet.updateString(LectureRB.lireRB("champ", "machineType"), machineAdd.getType());
            rowSet.updateString(LectureRB.lireRB("champ", "machineAdresseIP"), machineAdd.getAdresseIP());
            rowSet.updateBoolean(LectureRB.lireRB("champ", "machinePret"), machineAdd.isPret());
            rowSet.updateInt(LectureRB.lireRB("champ", "localOrigine"), machineAdd.getIdLocal());

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

            rowSet.updateInt(LectureRB.lireRB("champ", "localId"), machineUpdate.getIdLocal());
            rowSet.updateString(LectureRB.lireRB("champ", "machineIdUnique"), machineUpdate.getIdUnique());
            rowSet.updateString(LectureRB.lireRB("champ", "machineIdAfpa"), machineUpdate.getIdAfpa());
            rowSet.updateString(LectureRB.lireRB("champ", "machineDateAchat"), machineUpdate.getDateAchat());
            rowSet.updateInt(LectureRB.lireRB("champ", "machineDureeGarantie"), machineUpdate.getDureeGarantie());
            rowSet.updateString(LectureRB.lireRB("champ", "machineType"), machineUpdate.getType());
            rowSet.updateString(LectureRB.lireRB("champ", "machineAdresseIP"), machineUpdate.getAdresseIP());
            rowSet.updateBoolean(LectureRB.lireRB("champ", "machinePret"), machineUpdate.isPret());

            rowSet.updateRow();

            return true;
        } catch (Exception e) {
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

            Machine machineTemp = new Machine();
            machineTemp.setId(rowSet.getInt(LectureRB.lireRB("champ", "machineId")));
            machineTemp.setIdLocal(rowSet.getInt(LectureRB.lireRB("champ", "localId")));
            machineTemp.setIdUnique(rowSet.getString(LectureRB.lireRB("champ", "machineIdUnique")));
            machineTemp.setIdAfpa(rowSet.getString(LectureRB.lireRB("champ", "machineIdAfpa")));
            machineTemp.setDateAchat(rowSet.getString(LectureRB.lireRB("champ", "machineDateAchat")));
            machineTemp.setDureeGarantie(rowSet.getInt(LectureRB.lireRB("champ", "machineDureeGarantie")));
            machineTemp.setType(rowSet.getString(LectureRB.lireRB("champ", "machineType")));
            machineTemp.setAdresseIP(rowSet.getString(LectureRB.lireRB("champ", "machineAdresseIP")));
            machineTemp.setPret(rowSet.getBoolean(LectureRB.lireRB("champ", "machinePret")));
            machineTemp.setLocalOrigine(rowSet.getInt(LectureRB.lireRB("champ", "localOrigine")));

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
                Machine machine = new Machine();
                machine.setId(rowSet.getInt(LectureRB.lireRB("champ", "machineId")));
                machine.setIdLocal(rowSet.getInt(LectureRB.lireRB("champ", "localId")));
                machine.setIdUnique(rowSet.getString(LectureRB.lireRB("champ", "machineIdUnique")));
                machine.setIdAfpa(rowSet.getString(LectureRB.lireRB("champ", "machineIdAfpa")));
                machine.setDateAchat(rowSet.getString(LectureRB.lireRB("champ", "machineDateAchat")));
                machine.setDureeGarantie(rowSet.getInt(LectureRB.lireRB("champ", "machineDureeGarantie")));
                machine.setType(rowSet.getString(LectureRB.lireRB("champ", "machineType")));
                machine.setAdresseIP(rowSet.getString(LectureRB.lireRB("champ", "machineAdresseIP")));
                machine.setPret(rowSet.getBoolean(LectureRB.lireRB("champ", "machinePret")));
                machine.setLocalOrigine(rowSet.getInt(LectureRB.lireRB("champ", "localOrigine")));
                machines.add((T) machine);
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