package enseigne.component;

/**
 * Created by Josué on 01/03/2017.
 */
public class Photo {

    private String title;
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

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void write(){
        //tout doux
    }
}
