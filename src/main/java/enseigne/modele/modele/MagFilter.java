package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagFilter {
    ObservableList<Magasin> mags;
    Magasin selected;

    public MagFilter() throws IOException {
        mags = FXCollections.observableList(ReadConst.getStoreFromJson());

    }

    public Magasin selected(){
        return selected;
    }

    public ObservableList<Magasin> toDisplay(){
        return mags;
    }

    public void delete(){
        selected.delete();
        mags.remove(selected);
    }

    public void add(Magasin m) throws IOException{
        mags.add(m);
        m.write();

    }

    public void onClick(Magasin m){
        selected =  m;
    }
}
