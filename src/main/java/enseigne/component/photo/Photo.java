package enseigne.component.photo;

import enseigne.component.ReadConst;
import org.json.JSONObject;

import java.io.*;

/**
 * Created by Josué on 01/03/2017.
 */
public class Photo {

    private String titreFr;
    private String titreEn;
    private String category;
    private String photo;
    private String descriptionFr;
    private String descriptionEn;

    public Photo(){

    }

    public Photo(String path) throws IOException{
        JSONObject json = new JSONObject(ReadConst.fileToString(path));
        for(PhotoHandler handler : PhotoAttribute.values()){
            handler.assign(this,json);
        }
    }

    public String getCategory() {
        return category;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getDescriptionFr() {
        return descriptionFr;
    }

    public String getPhoto() {
        return photo;
    }

    public String getTitreFr() {
        return titreFr;
    }
    public String getTitreEn() {
        return titreEn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setTitreFr(String title) {
        this.titreFr = title;
    }
    public void setTitreEn(String title) {
        this.titreEn = title;
    }

    public void write() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(ReadConst.photoPath)
        ));

        JSONObject json = new JSONObject();
        for(PhotoHandler handler : PhotoAttribute.values()){
            handler.put(this,json);
        }

        bw.write(json.toString());
        bw.close();
    }
}
