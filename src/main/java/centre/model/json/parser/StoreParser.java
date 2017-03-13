package centre.model.json.parser;

import centre.model.Tag;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A parser used to read the JSON files used to store store data.
 */
public class StoreParser extends JsonParser {

    /**
     * Initializes this store parser. Reads the content of the json file,
     * and converts it to a JsonObject.
     *
     * @param input - the json file containing the store data
     * @throws IOException - if failing to read the file
     */
    public StoreParser(File input) throws IOException {
        super(input);
    }

    /**
     * Returns a list of all the categories of this store.
     *
     * @return the list of the categories of this store
     */
    public List<Tag> getCategories() {
        List<Tag> result = new ArrayList<>();
        for (Object category : json.getJSONArray("categories")) {
            JSONObject tag = (JSONObject) category;
            result.add(new Tag(tag.getString("french"), tag.getString("english")));
        }
        return result;
    }

}
