package application.tools;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by RENAUD on 08/11/2016.
 */
public class LectureRB {
    public static String lireRB(String key){
        Locale locale = new Locale("fr", "FR");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application.tools.query", locale);
        return resourceBundle.getString(key);
    }
}
