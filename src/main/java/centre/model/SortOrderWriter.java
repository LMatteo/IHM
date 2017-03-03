package centre.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Json writer to save sorting order data.
 *
 * @author Guillaume André
 */
public class SortOrderWriter {

    private String name;
    private JSONObject json;
    private JSONArray categories;

    /**
     * Creates a new writer for a sorting order with the given names.
     *
     * @param name        - the french name of the order
     * @param englishName - the english name of the order
     */
    public SortOrderWriter(String name, String englishName) {
        this.name = name;
        json = new JSONObject();
        json.put("name", name);
        json.put("englishName", englishName);
        categories = new JSONArray();
        json.put("categories", categories);
    }

    /**
     * Adds a new category to the sorting order.
     *
     * @param category - the category to add
     */
    public void addCategory(Tag category) {
        JSONObject tag = new JSONObject();
        tag.put("french", category.getFrench());
        tag.put("english", category.getEnglish());
        categories.put(tag);
    }

    /**
     * Saves the new sorting order to the data folder.
     *
     * @throws IOException - if failing to write the file
     */
    public void save() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/centre/sort/" + name + ".json")));
        bw.write(json.toString());
        bw.close();
    }

}
