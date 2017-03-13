package magasin.modele;

import magasin.modele.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Zaki
 */
public class ProductFilter {
    private ObservableList<Product> display;
    private Product selected;

    public ProductFilter() throws IOException {
        File folder = new File("/data/magasin/product/");
        List<File> files = Arrays.asList();
        List<Product> products = new ArrayList<>();
        for(File file : files){
            Product prod = new Product(file.toString());
            products.add(prod);
        }
        display = FXCollections.observableList(products);
    }

    public Product selected(){
        return selected;
    }

    public ObservableList<Product> toDisplay(){
        return display;
    }

    public void delete(){
        selected.delete();
        display.remove(selected);
    }

    public void delete(Product pro){
        if(display.contains(pro)) {
            pro.delete();
            display.remove(pro);
        }
    }

    public void add(Product pro) throws IOException{
        display.add(pro);
        pro.write();

    }

    public void onClick(Product pro){
        selected =  pro;
    }


    public void addToDisplay(Product pro){
        if(!display.contains(pro)){
            display.add(pro);
        }
    }
}


