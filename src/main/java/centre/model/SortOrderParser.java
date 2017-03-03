package centre.model;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Json parser to load a sorting order.
 *
 * @author Guillaume André
 */
public class SortOrderParser {

    private JSONObject json;

    /**
     * Creates a new sorting order parser with the file containing the order data.
     *
     * @param file - the file containing the order data
     * @throws IOException - if failing to read the file
     */
    public SortOrderParser(File file) throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(file.toPath())));
    }

    /**
     * Gets a property of the sorting order.
     *
     * @param key - the name of the property
     * @return the property contained within the order file
     */
    public String getProperty(String key) {
        return json.getString(key);
    }

    /**
     * Gets the list of categories (=tags) of this sorting order.
     *
     * @return a list of categories for this sorting order
     */
    public List<Tag> getCategories() {
        List<Tag> result = new ArrayList<>();
        for (Object o : json.getJSONArray("categories")) {
            JSONObject jsonTag = (JSONObject) o;
            result.add(new Tag(jsonTag.getString("french"), jsonTag.getString("english")));
        }
        return result;
    }

}
