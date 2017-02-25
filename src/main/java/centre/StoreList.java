package centre;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A list of loaded stores, with a few extra methods to retrieve a store
 * with one of its characteristics.
 *
 * @author Guillaume Andre
 */
public class StoreList {

    private final static int MAX_SUGGESTIONS = 5;

    private List<Store> loadedStores;

    /**
     * Initializes store data from the data resource folder.
     *
     * @throws IOException        - if failing to load one of the files
     * @throws URISyntaxException - if failing to find one of the folders
     */
    public StoreList() throws IOException, URISyntaxException {
        File[] storeFolder = new File(getClass().getClassLoader().getResource("data/centre/stores/").toURI()).listFiles();
        if (storeFolder == null) {
            System.out.println("Could not find store data.");
            return;
        }
        loadedStores = new ArrayList<>();
        for (File file : storeFolder) {
            loadedStores.add(new Store(file));
        }
    }

    public List<Store> getList() {
        return loadedStores;
    }

    /**
     * Returns all stores whose name starts with the requested prefix.
     *
     * @param prefix - the prefix to filter stores with
     * @return a list of all loaded store whose name start with the specified prefix
     */
    public List<Store> getStoreStartingWith(String prefix) {
        List<Store> result = new ArrayList<>();
        for (Store store : loadedStores) {
            if (store.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
                result.add(store);
            }
            if (result.size() == MAX_SUGGESTIONS) {
                break;
            }
        }
        return result;
    }

    /**
     * Checks if a given name for a store is already taken by an existing store or not.
     * Returns true if the name is taken false otherwise.
     *
     * @param name - the name to check
     * @return true if the name is taken by another store, false otherwise
     */
    public boolean isTaken(String name) {
        for (Store store : loadedStores) {
            if (store.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given map id is already taken by another store.
     * Returns true if already taken, false otherwise.
     *
     * @param id - the map id to search
     * @return true if this map id is taken, false if available
     */
    public boolean isIdTaken(int id) {
        for (Store store : loadedStores) {
            if (store.getMapId() == id) {
                return true;
            }
        }
        return false;
    }


    /**
     * Filters this list of stores, keeping only the stores matching a given category.
     *
     * @param category - the name of the category to filter with
     * @return a filtered list of stores according to the given category
     */
    public List<Store> findMatchingStores(String category) {
        List<Store> result = new ArrayList<>();
        for (Store store : loadedStores) {
            if (store.matchesCategory(category)) {
                result.add(store);
            }
        }
        return result;
    }

    /**
     * Searches for a store matching the requested map id.
     * Returns an optional of it if found, or an empty optional otherwise
     *
     * @param id - the requested map id
     * @return an optional of the store matching this id if found, or an empty optional otherwise
     */
    public Optional<Store> getStoreWithId(int id) {
        for (Store store : loadedStores) {
            if (store.getMapId() == id) {
                return Optional.of(store);
            }
        }
        return Optional.empty();
    }

    /**
     * Convenience method equivalent to .getList().add(store)
     *
     * @param store - the store to add to the list
     */
    public void add(Store store) {
        loadedStores.add(store);
    }

    /**
     * Convenience method equivalent to .getList().remove(store).
     *
     * @param store - the store to remove fom the list
     */
    public void remove(Store store) {
        loadedStores.remove(store);
    }


}
