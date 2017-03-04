package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagFilter {
    List<Magasin> mags;

    public MagFilter() throws IOException {
        mags = ReadConst.getStoreFromJson();

    }

    public List<Magasin> toDisplay(){
        return mags;
    }

    public void delete(Magasin m){
        m.delete();
        mags.remove(m);
    }

    public void add(Magasin m) throws IOException{
        mags.add(m);
        m.write();
    }
}
