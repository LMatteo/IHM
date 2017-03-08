package centre.model.json.parser;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Json parser class used to read the text to load in the info screen.
 *
 * @author Guillaume André
 */
public class InfoParser {

    public static String INFO_PATH = "data/centre/info/info.json";

    private JSONObject json;

    /**
     * Reads the file containing the inforamtion text and converts it to json.
     *
     * @throws IOException - if failing to read the file
     */
    public InfoParser() throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(Paths.get(INFO_PATH))));
    }

    /**
     * Returns a list containing all of the lines of the french version of the information text.
     *
     * @return a list of String corresponding to the french info text
     */
    public List<String> getFrench() {
        return getList("lineFrench");
    }

    /**
     * Returns a list containing all of the lines of the requested version of the text.
     *
     * @param key - "lineFrench" for french version, "lineEnglish" for english version
     * @return a list of String corresponding to the requested info text
     */
    private List<String> getList(String key) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            result.add(json.getString(key + i));
        }
        return result;
    }

    /**
     * Returns a list containing all of the lines of the english version of the information text.
     *
     * @return a list of String corresponding to the english info text
     */
    public List<String> getEnglish() {
        return getList("lineEnglish");
    }

}
