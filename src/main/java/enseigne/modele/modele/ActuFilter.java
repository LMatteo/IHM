package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.actu.Actu;
import enseigne.modele.magasin.Magasin;

import java.io.IOException;
import java.util.List;

public class ActuFilter {
    List<Actu> actus;

    public ActuFilter() throws IOException {
        actus = ReadConst.getActuFromJson();

    }

    public List<Actu> toDisplay(){
        return actus;
    }
}

