package centre.model;


import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewsWriter {
    private BufferedWriter bw;
    private JSONObject json;

    /**
     * Creates a new news writer
     *
     * @param filename - the requested file name
     * @throws IOException - if failing to create the writer
     */
    public NewsWriter(String filename) {
        try {
            bw = new BufferedWriter(new FileWriter(new File("data/centre/news/" + filename + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = new JSONObject();
    }


    public void addProperty(String key, String value) {
        json.put(key, value);
    }

    public void addDate(long value) {
        json.put("date", value);
    }

    public void addPosition(int value) {
        json.put("position", value);
    }

    public void addHorizontal(boolean value) {
        json.put("horizontal", value);
    }

    /**
     * Writes the news data.
     */
    public void write() {
        try {
            bw.write(json.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
