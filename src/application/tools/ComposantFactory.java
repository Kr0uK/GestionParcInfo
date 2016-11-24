package application.tools;

import application.beans.*;
import application.interfaces.IComposant;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Boris on 15/11/2016.
 */
public class ComposantFactory {

    /**
     * On génère les composants à partir d'un ResultSet
     * @param rs
     * @return
     */

    public IComposant getComposant(ResultSet rs) {
        try {
            //On récupère le type stocké dans la BDD
            String typeComposant = rs.getString(7);
            // S'il est vide, on renvoie null
            if (typeComposant == null){
                return null;
            }
                // On gère chaque cas spécifique
            if (typeComposant.equalsIgnoreCase("RAM")) {
                return new Ram(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getInt(8));
            } else if (typeComposant.equalsIgnoreCase("CARTE MERE")) {
                return new CarteMere(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getString(6));
            } else if (typeComposant.equalsIgnoreCase("DISQUE DUR")) {
                return new DisqueDur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getString(6), rs.getInt(8));
            } else if (typeComposant.equalsIgnoreCase("PROCESSEUR")) {
                return new Processeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getInt(10), rs.getInt(11));
            } else if (typeComposant.equalsIgnoreCase("LOGICIEL")) {
                return new Logiciel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getInt(9));
            } else if (typeComposant.equalsIgnoreCase("OS")) {
                return new SystemeExploitation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7), rs.getString(6), rs.getInt(9));
            } else {
                //S'il n'est pas correspondant à l'un des autres objets, on fait un Composant nature
                return new Composant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(12),rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * On ca générer un composant à partir d'un type fourni en String
     * @param typeComposant
     * @return
     */
    public IComposant getComposant(String typeComposant) {
        try {
            // S'il est vide, on renvoie null
            if (typeComposant == null){
                return null;
            }
            // On gère chaque cas spécifique
            if (typeComposant.equalsIgnoreCase("RAM")) {
                return new Ram();
            } else if (typeComposant.equalsIgnoreCase("CARTE MERE")) {
                return new CarteMere();
            } else if (typeComposant.equalsIgnoreCase("DISQUE DUR")) {
                return new DisqueDur();
            } else if (typeComposant.equalsIgnoreCase("PROCESSEUR")) {
                return new Processeur();
            } else if (typeComposant.equalsIgnoreCase("LOGICIEL")) {
                return new Logiciel();
            } else if (typeComposant.equalsIgnoreCase("OS")) {
                return new SystemeExploitation();
            } else {
                //S'il n'est pas correspondant à l'un des autres objets, on fait un Composant nature
                return new Composant();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
