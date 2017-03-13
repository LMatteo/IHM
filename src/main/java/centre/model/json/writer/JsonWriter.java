package centre.model.json.writer;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * General abstract class to save json.
 *
 * @author Guillaume André
 */
public abstract class JsonWriter {

    protected JSONObject json;
    private String filename;

    /**
     * Creates a new JsonObject.
     *
     * @param filename - the path the json will be written to
     */
    public JsonWriter(String filename) {
        json = new JSONObject();
        this.filename = filename;
    }

    /**
     * Adds a property to save in the json data.
     *
     * @param key   - the key of the property
     * @param value - the value of the property
     */
    public void addProperty(String key, String value) {
        json.put(key, value);
    }

    /**
     * Adds an integer property to save in the json data.
     *
     * @param key   - the key of the property
     * @param value - the value of the property
     */
    public void addInt(String key, int value) {
        json.put(key, value);
    }

    /**
     * Writes the jsonobject to the data folder.
     *
     * @throws IOException - if failing to save the file
     */
    public void save() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
        bw.write(json.toString());
        bw.close();
    }

}
