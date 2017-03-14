package magasin.modele.boutiqueInformation;

import org.json.JSONObject;

/**
 * @author Zaki
 */
public interface BoutiqueInformationHandler {

    void assign(BoutiqueInformation boutiqueInformation, JSONObject json);
    void put(BoutiqueInformation boutiqueInformation, JSONObject json);
    String get(BoutiqueInformation boutiqueInformation);
}
