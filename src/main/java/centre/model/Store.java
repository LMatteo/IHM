package centre.model;

import centre.model.json.parser.StoreParser;
import centre.model.json.writer.StoreWriter;

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
    private List<Tag> categories;
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
        mapId = sp.getInt("mapId");
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
    public Store(String name, String logoName, String enseigneId, String magasinId, List<Tag> categories,
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

    public List<Tag> getCategories() {
        return categories;
    }

    /**
     * Checks if this store belongs to the given category.
     * Returns true if the category was found among this store tags, or false otherwise.
     *
     * @param tag - the category to check
     * @return true if the store belongs to this category, false otherwise
     */
    public boolean matchesCategory(Tag tag) {
        for (Tag category : categories) {
            if (tag.getFrench().equals(category.getFrench())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves this store data in a new file in the data folder.
     * Does not save the logo picture of the store.
     *
     * @throws IOException - if failing to save the store file
     */
    public void save() throws IOException {
        StoreWriter sw = new StoreWriter(name);
        sw.addInt("mapId", mapId);
        sw.addTags(categories);
        sw.addProperty("name", name);
        sw.addProperty("logoName", logoName);
        sw.addProperty("enseigneId", enseigneId);
        sw.addProperty("magasinId", magasinId);
        sw.addProperty("location", location);
        sw.addProperty("promotionText", promotion);
        sw.addProperty("promotionEnglish", promotionEnglish);
        sw.addProperty("locationEnglish", locationEnglish);
        sw.save();
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

    /**
     * Adds a new category to this store.
     * Does not add the category if another category using the same french word is
     * already present.
     *
     * @param newCategory - the new category of the store
     */
    public void addCategory(Tag newCategory) {
        for (Tag tag : categories) {
            if (newCategory.getFrench().equals(tag.getFrench())) {
                return;
            }
        }
        categories.add(newCategory);
    }

    /**
     * Removes a category from this store.
     * The category will be removed even if the english translation of the given tag
     * does not match the original category.
     *
     * @param category - the category to remove
     */
    public void removeCategory(Tag category) {
        categories.removeIf(tag -> tag.getFrench().equals(category.getFrench()));
    }

}
