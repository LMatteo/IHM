package centre.transition;

import centre.model.Store;
import centre.model.StoreList;

import java.io.IOException;

/**
 * Transition interface to exit out of the store selector screen.
 */
public interface Transition {

    /**
     * Pass the selected store to the relevant screen before exiting it.
     *
     * @param selectedStore - the selected store
     * @param loadedStores  - the list of loaded stores
     * @throws IOException - if failing to transition properly
     */
    void doTransition(Store selectedStore, StoreList loadedStores) throws IOException;

}
