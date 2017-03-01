package enseigne.component.magasin;

import org.json.JSONObject;

public interface MagHandler {
    void assign(Magasin mag, JSONObject json);
    void put(Magasin mag, JSONObject json);
}
