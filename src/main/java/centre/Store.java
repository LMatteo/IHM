package centre;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * A store of the mall.
 * Stores the store name, logo filename, as well as other information related to current
 * promotions and its associated magasin and enseigne.
 */
public class Store {

    private String name;
    private String logoName;
    private String enseigneId;
    private String magasinId;
    private List<String> categories;
    private String location;
    private String promotion;
    private int mapId;

    /**
     * Initializes this store data.
     *
     * @param file - the file containing the data of the store
     * @throws IOException - if failing to read the file
     */
    public Store(File file) throws IOException {
        StoreParser sp = new StoreParser(file);
        name = sp.getProperty("name");
        logoName = sp.getProperty("logoName");
        enseigneId = sp.getProperty("enseigneId");
        magasinId = sp.getProperty("magasinId");
        categories = sp.getCategories();
        location = sp.getProperty("location");
        promotion = sp.getProperty("promotionText");
        mapId = sp.getMapID();
    }

    /**
     * Checks if this store belongs to the given category.
     * Returns true if the category was found among this store categories, and false
     * otherwise.
     *
     * @param name - the name of the category to check
     * @return true if the store belongs to this category, false otherwise
     */
    public boolean matchesCategory(String name) {
        for (String category : categories) {
            if (name.equals(category)) {
                return true;
            }
        }
        return false;
    }

    public String getLogoName() {
        return logoName;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPromotion() {
        return promotion;
    }

    public int getMapId() {
        return mapId;
    }


}
