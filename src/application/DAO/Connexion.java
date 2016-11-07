package application.DAO;

import application.DAO.objets.DisqueDur;
import application.DAO.objets.Machine;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RENAUD on 04/11/2016.
 */
public class Connexion {
    public static void connectionDB(String url, String driver, String user, String psw) throws SQLException {
        Connection conn = null;
        try {
            DbUtils.loadDriver(driver);
            conn = DriverManager.getConnection(url,user,psw);

            QueryRunner run = new QueryRunner();

            /*ResultSetHandler<Machine> resMachine = new BeanHandler<>(Machine.class);
            Machine machine = run.query(conn, "SELECT * FROM MACHINE WHERE id = ?", resMachine, 3);
            System.out.println(machine.getAdresseIP());*/

            ResultSetHandler<List<Machine>> resultSetHandler = new BeanListHandler<>(Machine.class);
            List<Machine> stagiaires = run.query(conn, "SELECT * FROM MACHINE", resultSetHandler);
            for (Machine stagiaire : stagiaires){
                System.out.println(stagiaire.getAdresseIP() + " | " + stagiaire.getIdAfpa());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
    }
}

