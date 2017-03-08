package enseigne.modele.actu;


import org.json.JSONObject;

public interface ActuHandler {
    void assign(Actu actu, JSONObject json);
    void put(Actu actu, JSONObject json);
}
