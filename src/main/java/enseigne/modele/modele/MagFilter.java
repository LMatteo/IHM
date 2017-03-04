package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagFilter {
    List<Magasin> mags;
    List<Magasin> selected;

    public MagFilter() throws IOException {
        mags = ReadConst.getStoreFromJson();
        selected = new ArrayList<>();

    }

    public List<Magasin> toDisplay(){
        return mags;
    }

    public void delete(){
        for(Magasin m : selected){
            m.delete();
            mags.remove(m);
        }
    }

    public void add(Magasin m) throws IOException{
        mags.add(m);
        m.write();

    }

    public void onClick(Magasin m){
        if(selected.contains(m)){
            selected.remove(m);
            return;
        }
        selected.add(m);
    }
}
