package centre.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Json writer to save store data.
 *
 * @author Guillaume Andre
 */
public class StoreWriter {

    private BufferedWriter bw;
    private JSONObject json;

    /**
     * Creates a new store writer that will save a json  file with the requested filename.
     *
     * @param filename - the requested file name
     * @throws IOException - if failing to create the writer
     */
    public StoreWriter(String filename) throws IOException {
        bw = new BufferedWriter(new FileWriter(new File("data/centre/stores/" + filename + ".json")));
        json = new JSONObject();
    }

    /**
     * Adds a property to write in the store data.
     *
     * @param key   - the key of the property
     * @param value - the value of the property
     */
    public void addProperty(String key, String value) {
        json.put(key, value);
    }

    /**
     * Adds the map id to write in the store data.
     *
     * @param value - the map id of the store
     */
    public void addMapId(int value) {
        json.put("mapId", value);
    }

    /**
     * Adds the tags for this store.
     *
     * @param tags - the tags of the future store
     */
    public void addTags(List<String> tags) {
        JSONArray array = new JSONArray();
        for (String tag : tags) {
            array.put(tag);
        }
        json.put("categories", array);
    }

    /**
     * Writes the store data.
     *
     * @throws IOException - if failing to write the file
     */
    public void write() throws IOException {
        bw.write(json.toString());
        bw.close();
    }

}
