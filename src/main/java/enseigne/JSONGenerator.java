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
        p.setCategory("artiste");
        p.setTitreFr("K2A 2-7-0");
        p.setPhoto("data/enseigne/images/kaaris.jpg");
        p.setDescriptionFr("Toujours plus haut");

        p.write();
    }

}
