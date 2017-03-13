package centre.model;

import centre.model.json.parser.InfoParser;
import centre.model.json.writer.InfoWriter;

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

    /**
     * Creates new Informations with the given lines of informational text.
     *
     * @param french  - the french lines of the informational text
     * @param english - the english lines of the informational text
     */
    public Informations(List<String> french, List<String> english) {
        this.french = french;
        this.english = english;
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

    /**
     * Writs the content of the information text to the data folder.
     *
     * @throws IOException - if failing to save the file
     */
    public void save() throws IOException {
        InfoWriter iw = new InfoWriter(french, english);
        iw.save();
    }

}
