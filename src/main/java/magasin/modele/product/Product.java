package magasin.modele.product;

import magasin.modele.Deletable;
import org.json.JSONObject;

import java.io.*;

public class Product extends Deletable {

    private String name;
    private String ref;
    private String description;
    private String type;
    private String photo;

    private Boolean freshProduct;
    private Boolean exhibit;

    private String price;
    private String promotion;


    public Product() {
        super.setPath("/data/magasin/product/");
    }

    public Product(String path) throws IOException {
        super.setPath("/data/magasin/product/");
        BufferedReader read = new BufferedReader(new FileReader(new File(path + name + ".json")));
        StringBuilder res = new StringBuilder();
        String line = "";
        while ((line = read.readLine()) != null) {
            res.append(line);
        }
        read.close();
        JSONObject json = new JSONObject(res.toString());
        for (ProductHandler handler : ProductAttribute.values()) {
            if (json.has(handler.toString())) {
                handler.assign(this, json);
            }
        }
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public String getPromotion() { return promotion; }

    public void setPromotion(String promotion) { this.promotion = promotion; }

    public void write() throws IOException {
        BufferedWriter bf = new BufferedWriter(
                new FileWriter(new File("data/magasin/product/" + name + ".json")));
        JSONObject obj = new JSONObject();
        for (ProductHandler handler : ProductAttribute.values()) {
            handler.put(this, obj);
        }
        bf.write(obj.toString());
        bf.close();
    }


}