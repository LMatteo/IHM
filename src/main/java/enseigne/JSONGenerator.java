package enseigne;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by Josué on 15/03/2017.
 */
public class JSONGenerator {

    @Test
    public void magasin() throws IOException {
        Magasin m = new Magasin();
        m.setAddr("13 rue de la paix");
        m.setPhoto(ReadConst.photoPath+"store1.jpg");
        m.setCodePostal("06746");
        m.setVille("Tours");
        m.setWeb("www.captours-tboth.fr");
        m.setCentre("CapTours");
        m.setInfoFr("Nos employés seront fier de vous accueillir du lundi au vendredi de 9h à 18h.");
        m.setTelephone("0456873554");
        m.write();
    }
}
