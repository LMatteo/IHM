package magasin.modele.json;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Meriveri on 14/03/2017.
 */
public abstract class JsonParser {

    private JSONObject file;

    public JsonParser(File file) throws IOException {
        this.file = new JSONObject(new String(Files.readAllBytes(file.toPath())));
    }

    public String getStringValue(String prop)
    {
        return file.getString(prop);
    }

    public int getIntValue(String prop)
    {
        return file.getInt(prop);
    }


}
