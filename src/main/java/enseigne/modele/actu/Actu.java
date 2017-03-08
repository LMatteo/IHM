package enseigne.modele.actu;

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
public class Actu  extends Deletable{

    private String titreFr;
    private String titreEn;
    private String contentFr;
    private String contentEn;
    private String image;
    private boolean bigSize;

    public Actu(){
        super.setPath(ReadConst.actuPath);
    }

    public Actu(String path) throws IOException{
        super.setPath(ReadConst.actuPath);
        JSONObject json = new JSONObject(ReadConst.fileToString(path));
        for(ActuHandler handler : ActuAttribute.values()){
            if(json.has(handler.toString())){
                handler.assign(this,json);
            }
        }
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public void setContentFr(String contentFr) {
        this.contentFr = contentFr;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitreEn(String titreEn) {
        this.titreEn = titreEn;
    }

    public void setTitreFr(String titreFr) {
        this.titreFr = titreFr;
        super.setName(titreFr);
    }

    public String getContentEn() {
        return contentEn;
    }

    public String getContentFr() {
        return contentFr;
    }

    public String getImage() {
        return image;
    }

    public String getTitreEn() {
        return titreEn;
    }

    public String getTitreFr() {
        return titreFr;
    }

    public void setBigSize(boolean bigSize) {
        this.bigSize = bigSize;
    }

    public boolean isBigSize(){
        return bigSize;
    }

    public void write() throws IOException{
        BufferedWriter bf = new BufferedWriter(
                new FileWriter(
                        new File(ReadConst.actuPath+ titreFr + ".json")));
        JSONObject obj = new JSONObject();
        for(ActuHandler handler : ActuAttribute.values()){
            handler.put(this,obj);
        }
        bf.write(obj.toString());
        bf.close();
    }
}
