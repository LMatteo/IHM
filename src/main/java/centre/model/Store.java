package centre.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private String locationEnglish;
    private String promotion;
    private String promotionEnglish;
    private int mapId;

    /**
     * Creates a new store with data retrieved from a file.
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
        locationEnglish = sp.getProperty("locationEnglish");
        promotion = sp.getProperty("promotionText");
        promotionEnglish = sp.getProperty("promotionEnglish");
        mapId = sp.getMapID();
    }

    /**
     * Creates a new Store with the requested data.
     *
     * @param name             - the name of the store
     * @param logoName         - the name of the picture of the store's logo in resources
     * @param enseigneId       - the id of the enseigne tied to this store
     * @param magasinId        - the id of the magasin tied to this store
     * @param categories       - the tags of this store
     * @param location         - the description of the location of this store
     * @param promotion        - the promotional text for this store
     * @param promotionEnglish - the english version of the promotional text
     * @param mapId            - the map id of the store
     */
    public Store(String name, String logoName, String enseigneId, String magasinId, List<String> categories,
                 String location, String locationEnglish, String promotion, String promotionEnglish, int mapId) {
        this.name = name;
        this.logoName = logoName;
        this.enseigneId = enseigneId;
        this.magasinId = magasinId;
        this.categories = categories;
        this.location = location;
        this.locationEnglish = locationEnglish;
        this.promotion = promotion;
        this.promotionEnglish = promotionEnglish;
        this.mapId = mapId;
    }

    public String getLogoName() {
        return logoName;
    }

    public String getLocation() {
        return location;
    }

    public String getLocationEnglish() {
        return locationEnglish;
    }

    public String getPromotionEnglish() {
        return promotionEnglish;
    }

    public String getEnseigneId() {
        return enseigneId;
    }

    public String getMagasinId() {
        return magasinId;
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

    public List<String> getCategories() {
        return categories;
    }

    /**
     * Checks if this store belongs to the given category.
     * Returns true if the category was found among this store tags, or false otherwise.
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

    /**
     * Saves this store data in a new file in the data folder.
     *
     * @throws IOException - if failing to write the store file
     */
    public void save() throws IOException {
        StoreWriter sw = new StoreWriter(name);
        sw.addMapId(mapId);
        sw.addTags(categories);
        sw.addProperty("name", name);
        sw.addProperty("logoName", logoName);
        sw.addProperty("enseigneId", enseigneId);
        sw.addProperty("magasinId", magasinId);
        sw.addProperty("location", location);
        sw.addProperty("promotionText", promotion);
        sw.addProperty("promotionEnglish", promotionEnglish);
        sw.addProperty("locationEnglish", locationEnglish);
        sw.write();
    }

    /**
     * Deletes this store data.
     *
     * @throws IOException - if failing to delete the store files
     */
    public void delete() throws IOException {
        Files.delete(Paths.get("data/centre/stores/" + name + ".json"));
        Files.delete(Paths.get("data/centre/images/" + logoName));
    }

}
