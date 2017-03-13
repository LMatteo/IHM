package centre.model.json.writer;

import centre.model.Tag;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Json writer to save store data.
 *
 * @author Guillaume Andre
 */
public class StoreWriter extends JsonWriter {

    /**
     * Creates a new store writer that will save a json  file with the requested filename.
     *
     * @param filename - the requested file name
     * @throws IOException - if failing to create the writer
     */
    public StoreWriter(String filename) throws IOException {
        super("data/centre/stores/" + filename + ".json");
    }

    /**
     * Adds the tags for this store.
     *
     * @param tags - the tags of the future store
     */
    public void addTags(List<Tag> tags) {
        JSONArray array = new JSONArray();
        for (Tag tag : tags) {
            JSONObject json = new JSONObject();
            json.put("french", tag.getFrench());
            json.put("english", tag.getEnglish());
            array.put(json);
        }
        json.put("categories", array);
    }

}
