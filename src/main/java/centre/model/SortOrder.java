package centre.model;

import java.io.*;
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
    private List<String> categories;

    /**
     * Initializes this sort order according to a specifically formatted file.
     * The file first line corresponds to the name of the sorting order.
     * Each of the following lines represents a category of the sorting order.
     *
     * @param input - the file containing the sorting order data
     * @throws IOException - if failing to read the file
     */
    public SortOrder(File input) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        name = br.readLine();
        categories = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            categories.add(line);
        }
        br.close();
    }

    /**
     * Creates a new sorting order with a given name and no categories.
     *
     * @param name - the name of the sorting order
     */
    public SortOrder(String name) {
        this.name = name;
        categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCategories() {
        return categories;
    }

    /**
     * Saves this sorting order to the save folder
     *
     * @throws IOException - if failing to write the file
     */
    public void save() throws IOException {
        String filename = "data/centre/sort/" + name + ".txt";
        Files.deleteIfExists(Paths.get(filename));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
        bw.write(name + "\n");
        for (String category : categories) {
            bw.write(category + "\n");
        }
        bw.close();
    }

    /**
     * Adds a category to this sorting order.
     *
     * @param category - the category to add to the sorting order
     */
    public void addCategory(String category) {
        categories.add(category);
    }

}
