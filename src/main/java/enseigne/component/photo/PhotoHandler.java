package enseigne.component.photo;

import enseigne.component.magasin.Magasin;
import org.json.JSONObject;

public interface PhotoHandler {
    void assign(Photo pho, JSONObject json);
    void put(Photo pho, JSONObject json);
}
