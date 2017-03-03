package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagFilter {
    List<Magasin> mags;

    public MagFilter() throws IOException {
        mags = ReadConst.getStoresJson();

    }

    public List<Magasin> toDisplay(){
        return mags;
    }
}
