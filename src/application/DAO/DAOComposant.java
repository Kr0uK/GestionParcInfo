package application.DAO;

import application.beans.Composant;
import application.beans.Machine;
import application.interfaces.IDAOHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by RENAUD on 08/11/2016.
 */
public class DAOComposant implements IDAOHandler {
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

        QueryRunner run = new QueryRunner();
        ResultSetHandler<List<Composant>> beanListHandler = new BeanListHandler<>(Composant.class);
        try {
            //List<Composant> composants = run.query(conn.connexion(),query, beanListHandler, id);

            List<T> tList = null;
            //tList = (List<T>) composants;

            return tList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            conn.fermer();
        }
    }
}
