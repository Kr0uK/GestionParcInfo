package application.wrappers;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 02/11/2016.
 */
public class XMLTools {

    /**

     * Serialisation d'un objet dans un fichier

     * @param object objet a serialiser

     */

    public static <T> void encodeToFile(ArrayList<T> object, String fileName) throws IOException {

        // ouverture de l'encodeur vers le fichier

        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));

        try {

            // serialisation de l'objet

            encoder.writeObject(object);

            encoder.flush();

        } finally {

            // fermeture de l'encodeur

            encoder.close();

        }

    }

    public static <T> void encodeToFile(T object, String fileName) throws IOException {

        // ouverture de l'encodeur vers le fichier

        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));

        try {

            // serialisation de l'objet

            encoder.writeObject(object);

            encoder.flush();

        } finally {

            // fermeture de l'encodeur

            encoder.close();

        }

    }

}
