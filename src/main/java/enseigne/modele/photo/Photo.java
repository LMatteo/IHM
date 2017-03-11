package enseigne.modele.photo;

import enseigne.modele.Deletable;
import enseigne.modele.ReadConst;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Josué on 01/03/2017.
 */
public class Photo extends Deletable{

    private String titreFr;
    private String titreEn;
    private String category;
    private String photo;
    private String descriptionFr;
    private String descriptionEn;

    public Photo(){
        super.setPath(ReadConst.photoPath);
    }

    public Photo(String path) throws IOException{
        super.setPath(ReadConst.photoPath);
        JSONObject json = new JSONObject(ReadConst.fileToString(path));
        for(PhotoHandler handler : PhotoAttribute.values()){
            if(json.has(handler.toString())) {
                handler.assign(this, json);
            }
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
        super.setName(title);
    }
    public void setTitreEn(String title) {
        this.titreEn = title;
    }

    public void write() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(ReadConst.photoPath+titreFr+".json")
        ));

        JSONObject json = new JSONObject();
        for(PhotoHandler handler : PhotoAttribute.values()){
            handler.put(this,json);
        }

        bw.write(json.toString());
        bw.close();
    }

}
