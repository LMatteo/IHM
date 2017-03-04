package centre.model;

import java.io.IOException;
import java.util.List;

/**
 * A set of informations, meant to be displayed in the info screen.
 *
 * @author Guillaume André
 */
public class Informations {

    public static String MAP_PATH = "/data/centre/images/map/map.png";
    private List<String> french;
    private List<String> english;
    /**
     * Loads the informational text from the data folder.
     *
     * @throws IOException - if failing to read the file
     */
    public Informations() throws IOException {
        InfoParser parser = new InfoParser();
        french = parser.getFrench();
        english = parser.getEnglish();
    }

    public static String getMapPath() {
        return MAP_PATH;
    }

    public List<String> getFrench() {
        return french;
    }

    public List<String> getEnglish() {
        return english;
    }

}
