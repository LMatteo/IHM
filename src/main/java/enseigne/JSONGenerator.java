package enseigne;

import enseigne.modele.photo.Photo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by Josué on 15/03/2017.
 */
public class JSONGenerator {

    @Test
    public void photo() throws IOException {
        Photo p = new Photo();
        p.setCategory("musique");
        p.setTitreFr("Dance 2014");
        p.setPhoto("data/enseigne/images/music2.jpg");
        p.setDescriptionFr("Le best pour le booty shake");

        p.write();
    }

}
