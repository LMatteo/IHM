package centre;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * A parser used to read the JSON files used to store store data.
 */
public class StoreParser {

    private JSONObject json;

    /**
     * Initializes this store parser. Reads the content of the json file,
     * and converts it to a JsonObject.
     *
     * @param input - the json file containing the store data
     * @throws IOException - if failing to read the file
     */
    public StoreParser(File input) throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(input.toPath())));
    }

    /**
     * Returns the store data associated to the requested key.
     *
     * @param key - the key of the store data to retrieve
     * @return the data corresponding to this key
     */
    public String getProperty(String key) {
        return json.getString(key);
    }

    /**
     * Returns a list of all the categories of this store.
     *
     * @return the list of the categories of this store
     */
    public List<String> getCategories() {
        List<String> result = new ArrayList<>();
        for (Object category : json.getJSONArray("categories")) {
            result.add(category.toString());
        }
        return result;
    }

    /**
     * Returns the id of this store on the map of the mall.
     *
     * @return the map id of this store
     */
    public int getMapID() {
        return json.getInt("mapId");
    }

}
