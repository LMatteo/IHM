package centre.model;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Json writer class for the informational text.
 *
 * @author Guillaume André
 */
public class InfoWriter {

    private JSONObject json;

    /**
     * Creates a new jsonObject containing the information screen data
     *
     * @param french  - the lines of the french text
     * @param english - the lines of the english text
     */
    public InfoWriter(List<String> french, List<String> english) {
        json = new JSONObject();
        for (int i = 1; i <= 4; i++) {
            json.put("lineFrench" + i, french.get(i - 1));
            json.put("lineEnglish" + i, english.get(i - 1));
        }
    }

    /**
     * Writes the json object to the data folder.
     *
     * @throws IOException - if failing to write the file
     */
    public void write() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data/centre/info/info.json")));
        bw.write(json.toString());
        bw.close();
    }

}
