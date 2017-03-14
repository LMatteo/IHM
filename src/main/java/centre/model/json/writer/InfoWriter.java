package centre.model.json.writer;

import org.json.JSONObject;

import java.util.List;

/**
 * Json writer class for the informational text.
 *
 * @author Guillaume André
 */
public class InfoWriter extends JsonWriter {

    /**
     * Creates a new jsonObject containing the information screen data
     *
     * @param french  - the lines of the french text
     * @param english - the lines of the english text
     */
    public InfoWriter(List<String> french, List<String> english) {
        super("data/centre/info/info.json");
        json = new JSONObject();
        for (int i = 1; i <= 4; i++) {
            json.put("lineFrench" + i, french.get(i - 1));
            json.put("lineEnglish" + i, english.get(i - 1));
        }
    }

}
