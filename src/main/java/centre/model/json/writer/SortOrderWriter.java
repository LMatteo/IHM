package centre.model.json.writer;

import centre.model.Tag;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Json writer to save sorting order data.
 *
 * @author Guillaume André
 */
public class SortOrderWriter extends JsonWriter {

    private JSONArray categories;

    /**
     * Creates a new writer for a sorting order with the given names.
     *
     * @param name        - the french name of the order
     * @param englishName - the english name of the order
     */
    public SortOrderWriter(String name, String englishName) {
        super("data/centre/sort/" + name + ".json");
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

}
