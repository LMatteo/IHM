package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.photo.Photo;

import java.io.IOException;
import java.util.List;

public class PhotoFilter {

    List<Photo> photos;

    public PhotoFilter() throws IOException {
        photos = ReadConst.getPhotoFromJson();

    }

    public List<Photo> toDisplay(){
        return photos;
    }
}
