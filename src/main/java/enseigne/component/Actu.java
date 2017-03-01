package enseigne.component;

/**
 * Created by Josué on 01/03/2017.
 */
public class Actu {

    private String titreFr;
    private String titreEn;
    private String contentFr;
    private String contentEn;
    private String image;

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

    public void write(){
        //toudou
    }
}
