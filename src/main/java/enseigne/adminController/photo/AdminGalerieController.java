package enseigne.adminController.photo;

import enseigne.ToNode;
import enseigne.modele.PhotoFilter;
import enseigne.modele.photo.Photo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.*;

public class AdminGalerieController {

    @FXML
    private ComboBox<String> categoriesBox;


    @FXML
    private TextField searchField;

    @FXML
    private VBox displayPane;

    private List<Photo> allPhotos;
    private Set<String> categories ;
    String defaultCategory;

    @FXML
    public void initialize() throws IOException {
        allPhotos = getPhotoList();
        categories = new HashSet<>();
        categoriesBox.setPromptText("Filtrer...");
        defaultCategory = "Toutes les catégories";
        categoriesBox.getItems().add(defaultCategory);
        displayPhotos(allPhotos);
        displayCategories(allPhotos);

    }

    public void displayPhotos(List<Photo> list) throws IOException {
        displayPane.getChildren().clear();
        for(int i=0;i<list.size();i+=3){
            HBox hbox = new HBox();
            hbox.getChildren().add(ToNode.photos(list.get(i)));
            if((i+1)<list.size()){
                hbox.getChildren().add(ToNode.photos(list.get(i+1)));
            }
            if((i+2)<list.size()){
                hbox.getChildren().add(ToNode.photos(list.get(i+2)));
            }
            displayPane.getChildren().add(hbox);
        }
    }

    public List<Photo> getPhotoList() throws IOException {
        return(new PhotoFilter().toDisplay());
    }

    public void displayCategories(List<Photo> list){
        for(Photo p : list){
            categories.add(p.getCategory());
        }
        categoriesBox.getItems().addAll(new ArrayList<String>(categories));
    }

    @FXML
    void categorySelected(ActionEvent event) throws IOException {
        List<Photo> photosFiltered = new ArrayList<>();
        String selected = categoriesBox.getSelectionModel().getSelectedItem();
        if(Objects.equals(selected, defaultCategory)){
            photosFiltered = allPhotos;
        } else {
            for (Photo p : allPhotos) {
                if (p.getCategory().equals(selected)) {
                    photosFiltered.add(p);
                }
            }
        }
        displayPhotos(photosFiltered);
    }


    @FXML
    void searchButton(ActionEvent event) throws IOException {
        String request = searchField.getText();
        List<Photo> toDisplay = new ArrayList<>();
        for(Photo p : allPhotos){
            if(p.getTitreFr().contains(request) ||
                    p.getDescriptionFr().contains(request)){
                toDisplay.add(p);
            }
        }
        displayPhotos(toDisplay);
    }


}
