package magasin.modele.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Meriveri on 14/03/2017.
 */
public abstract class JsonParser {

    private JSONArray file;

    public JsonParser(File file) throws IOException {
        this.file = new JSONArray(new String(Files.readAllBytes(file.toPath())));
    }

    public String getStringValue(int i)
    {
        return (String) file.get(i);
    }

    public int getIntValue(int i)
    {
        return (int) file.get(i);
    }
}
