package centre.model;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * A parser used to read the JSON files used to store store data.
 */
public class NewsParser {

    private JSONObject json;

    /**
     * Initializes this news parser. Reads the content of the json file,
     * and converts it to a JsonObject.
     *
     * @param input - the json file containing the store data
     * @throws IOException - if failing to read the file
     */
    public NewsParser(File input) throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(input.toPath())));
    }

    /**
     * Returns the data associated to the requested key.
     *
     * @param key - the key of the store data to retrieve
     * @return the data corresponding to this key
     */
    public String getProperty(String key) {
        return json.getString(key);
    }

    /**
     * Returns the position of the news in the feed or 0.
     *
     * @return the position of this news
     */
    public int getPosition() {
        return json.getInt("position");
    }

    /**
     * Returns the position of the news in the feed or 0.
     *
     * @return the position of this news
     */
    public long getDate() {
        return json.getLong("date");
    }

    /**
     * Returns the position of the news in the feed or 0.
     *
     * @return the position of this news
     */
    public boolean horizontal() {
        return json.getBoolean("horizontal");
    }

}
