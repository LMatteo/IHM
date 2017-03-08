package centre.model.json.writer;

/**
 * Writer class for the news Json.
 */
public class NewsWriter extends JsonWriter {

    /**
     * Creates a new news writer
     *
     * @param filename - the requested file name
     */
    public NewsWriter(String filename) {
        super("data/centre/news/" + filename + ".json");
    }

    /**
     * Adds the date of this news.
     *
     * @param value - the date of the news
     */
    public void addDate(long value) {
        json.put("date", value);
    }

    /**
     * Specifies whether this news should be displayed horizontally or vertically.
     *
     * @param value - true if horizontal, false otherwise
     */
    public void addHorizontal(boolean value) {
        json.put("horizontal", value);
    }

}
