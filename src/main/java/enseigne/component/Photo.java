package enseigne.component;

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

    public void write(){
        //tout doux
    }
}
