package centre.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * A way of sorting the stores.
 * Stores the name of this sorting as well the categories composing it.
 */
public class SortOrder {

    private String name;
    private String englishName;
    private List<Tag> categories;

    /**
     * Initializes this sort order according to a specifically formatted file.
     * The file first line corresponds to the name of the sorting order.
     * Each of the following lines represents a category of the sorting order.
     *
     * @param input - the file containing the sorting order data
     * @throws IOException - if failing to read the file
     */
    public SortOrder(File input) throws IOException {
        SortOrderParser sp = new SortOrderParser(input);
        name = sp.getProperty("name");
        englishName = sp.getProperty("englishName");
        categories = sp.getCategories();
    }

    /**
     * Creates a new sorting order with a given name and no categories.
     *
     * @param name        - the name of the sorting order
     * @param englishName - the english version of the name of the sorting order
     */
    public SortOrder(String name, String englishName) {
        this.name = name;
        this.englishName = englishName;
        categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Tag> getCategories() {
        return categories;
    }


    /**
     * Adds a category to this sorting order.
     * Does not check for duplicates.
     *
     * @param category - the category to add to the sorting order
     */
    public void addCategory(Tag category) {
        categories.add(category);
    }

    public void removeCategory(Tag category) {
        categories.remove(category);
    }

    /**
     * Saves this sorting order to the save folder.
     *
     * @throws IOException - if failing to write the file
     */
    public void save() throws IOException {
        Files.deleteIfExists(Paths.get("/data/centre/sort/" + name + ".json"));
        SortOrderWriter sw = new SortOrderWriter(name, englishName);
        for (Tag tag : categories) {
            sw.addCategory(tag);
        }
        sw.save();
    }

    /**
     * Deletes the data of this sorting order.
     *
     * @throws IOException - if failing to delete the sorting order data
     */
    public void delete() throws IOException {
        Files.delete(Paths.get("data/centre/sort/" + name + ".json"));
    }

}
