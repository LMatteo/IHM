package centre.model.json.parser;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * General abstract class for all json parsers.
 *
 * @author Guillaume André
 */
public abstract class JsonParser {

    protected JSONObject json;

    /**
     * Reads the json file and converts it to json.
     *
     * @param file - the file path of the json to read
     * @throws IOException - if failing to readt the file
     */
    public JsonParser(File file) throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(file.toPath())));
    }

    /**
     * Returns the data associated to the requested key.
     *
     * @param key - the key of the data to retrieve
     * @return the data corresponding to this key
     */
    public String getProperty(String key) {
        return json.getString(key);
    }

    /**
     * Returns the integer associated to a given key.
     *
     * @param key - the key of the integer to retrieve
     * @return the integer corresponding to the key
     */
    public int getInt(String key) {
        return json.getInt(key);
    }

}
