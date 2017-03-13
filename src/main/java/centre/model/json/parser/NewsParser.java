package centre.model.json.parser;

import java.io.File;
import java.io.IOException;

/**
 * A parser used to read the JSON files used to store store data.
 */
public class NewsParser extends JsonParser {

    /**
     * Initializes this news parser. Reads the content of the json file,
     * and converts it to a JsonObject.
     *
     * @param input - the json file containing the store data
     * @throws IOException - if failing to read the file
     */
    public NewsParser(File input) throws IOException {
        super(input);
    }

    /**
     * Returns the date of the news in the feed.
     *
     * @return the date of this news
     */
    public long getDate() {
        return json.getLong("date");
    }

    /**
     * Returns whether this position is horizontal or not.
     *
     * @return true if horizontal, false otherwise
     */
    public boolean horizontal() {
        return json.getBoolean("horizontal");
    }

}
