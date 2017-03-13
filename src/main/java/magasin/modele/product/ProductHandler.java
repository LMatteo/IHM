package magasin.modele.product;

import org.json.JSONObject;

/**
 * @author Zaki
 */
public interface ProductHandler {
    void assign(Product prod, JSONObject json);
    void put(Product prod, JSONObject json);
    String get(Product prod);
}