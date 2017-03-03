package centre.transition;

import centre.model.Store;
import centre.model.StoreList;

import java.io.IOException;

/**
 * Transition used to delete the selected store.
 *
 * @author Guillaume Andre
 */
public class DeleteTransition implements Transition {

    /**
     * Deletes the selected store files and unloads it from the list.
     *
     * @param selectedStore - the selected store
     * @param loadedStores  - the list of loaded stores
     * @throws IOException - if failing to delete the files
     */
    @Override
    public void doTransition(Store selectedStore, StoreList loadedStores) throws IOException {
        selectedStore.delete();
        loadedStores.remove(selectedStore);
    }

}
