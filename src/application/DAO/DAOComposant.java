package application.DAO;

import application.objets.Composant;
import application.objets.Machine;
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
    public <T> boolean ajouter(T objet, String query) {
        return false;
    }

    @Override
    public boolean supprimer(String query, String id) {
        return false;
    }

    @Override
    public <T> boolean modifier(T objet, String query, String id) {
        return false;
    }

    @Override
    public <T> T lecture(String query, String id) {
        return null;
    }



    @Override
    public <T> List<T> lecture(String query) {
        return null;
    }

    @Override
    public <T> boolean verifier(T objet) {
        return false;
    }


}
