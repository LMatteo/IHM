package magasin.modele.BoutiqueInformation;

import magasin.modele.product.Product;
import org.json.JSONObject;

/**
 * @author Zaki
 */
public interface BoutiqueInformationHandler {

    void assign(BoutiqueInformation boutiqueInformation, JSONObject json);
    void put(BoutiqueInformation boutiqueInformation, JSONObject json);
    String get(BoutiqueInformation boutiqueInformation);
}
