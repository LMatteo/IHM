package centre.transition;

import centre.admin.sort.EditSortController;
import centre.model.Store;
import centre.model.StoreList;

import java.io.IOException;

/**
 * Transition used to transmit the store data to the sorting order editor screen.
 *
 * @author Guillaume André
 */
public class EditSortTransition implements Transition {

    private EditSortController controller;

    /**
     * Creates a new transition with the controller to send the selected store data to.
     *
     * @param controller - the controller receiving the selected store later
     */
    public EditSortTransition(EditSortController controller) {
        this.controller = controller;
    }

    /**
     * Sends the selected store data to the sorting order editor controller.
     *
     * @param selectedStore - the selected store
     * @param loadedStores  - the list of loaded stores
     * @throws IOException - never in this case
     */
    @Override
    public void doTransition(Store selectedStore, StoreList loadedStores) throws IOException {
        controller.loadNewStore(selectedStore);
    }

}
