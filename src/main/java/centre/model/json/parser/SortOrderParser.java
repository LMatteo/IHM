package centre.model.json.parser;

import centre.model.Tag;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Json parser to load a sorting order.
 *
 * @author Guillaume André
 */
public class SortOrderParser extends JsonParser {

    /**
     * Creates a new sorting order parser with the file containing the order data.
     *
     * @param file - the file containing the order data
     * @throws IOException - if failing to read the file
     */
    public SortOrderParser(File file) throws IOException {
        super(file);
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
