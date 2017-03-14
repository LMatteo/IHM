package magasin.admin;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import magasin.modele.product.Product;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Zaki
 */
public class OrderControl {

    @FXML TextField name;
    @FXML TextField type;
    @FXML TextField ref;
    @FXML TextField price;
    @FXML TextField promotion;
    @FXML TextArea descriptionFr;
    @FXML CheckBox newProduct;
    @FXML CheckBox exhibit;
    @FXML Button addProduct;
    @FXML Button addPicture;
    @FXML ImageView imagePreview;


    private AdminLayoutControl adminLayoutControl;
    private String imagePath;
    private Product product;

    @FXML
    public void initialize(){
        product = new Product();
    }

    public void setAdminLayoutControl(AdminLayoutControl adminLayoutControl) {
        this.adminLayoutControl = adminLayoutControl;
    }

    @FXML
    void goToNewOrder(MouseEvent event) throws IOException {
        adminLayoutControl.goToNewOrder(null);
    }

    @FXML
    void addProduct(MouseEvent event) throws IOException{
        product.setName(name.getText());
        product.setRef(ref.getText());
        product.setType(type.getText());
        product.setDescription(descriptionFr.getText());
        if(imagePath != null) {
            File image = new File(imagePath);
            product.setPhoto("data/magasin/images/" + image.getName());
        }
        product.write();
    }

    @FXML
    void browsePicture(MouseEvent event) throws FileNotFoundException{
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ouvrir une image");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Photo Files", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagePreview.setImage(image);
            File out = new File("data/magasin/images/"+ file.getName());
            try {
                FileUtils.copyFile(file,out);
                imagePath = out.getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
