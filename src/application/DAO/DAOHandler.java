package application.DAO;

import application.DAO.interfaces.IDAOHandler;
import application.DAO.objets.Machine;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Boris on 07/11/2016.
 */
public class DAOHandler implements IDAOHandler {

    @Override
    public <T> boolean ajouter(T objet) {
        // TODO logique de vérif
        try {

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public <T> boolean supprimer(T objet) {
        // TODO logique de vérif
        try {

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public <T> boolean modifier(T objet) {
        // TODO logique de vérif
        try {

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public <T> List<T> lecture(T objet) {
        QueryRunner run = new QueryRunner();
        ResultSetHandler<List<T>> resObjet = new BeanListHandler<>((Class<T>) objet.getClass());
        try {
            // TODO : faire que les requetes soient pas en dur
            List<T> resultat = run.query(conn.connexion(), "SELECT * FROM " + objet.getClass().getSimpleName().toUpperCase() + "", resObjet);
            return resultat;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T lecture(T objet, int id) {
        try {

            T resultat;
            return resultat;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
