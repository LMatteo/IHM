package enseigne.modele.modele;

import enseigne.modele.ReadConst;
import enseigne.modele.magasin.MagAttribute;
import enseigne.modele.magasin.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagFilter {
    private List<Magasin> mags;
    private ObservableList<Magasin> display;
    private String filter;
    private Magasin selected;

    public MagFilter() throws IOException {
        mags = FXCollections.observableList(ReadConst.getStoreFromJson());
        display = FXCollections.observableList(ReadConst.getStoreFromJson());
    }

    public Magasin selected(){
        return selected;
    }

    public ObservableList<Magasin> toDisplay(){
        return display;
    }

    public void delete(){
        selected.delete();
        display.remove(selected);
        mags.remove(selected);
    }

    public void delete(Magasin m){
        if(display.contains(m)) {
            m.delete();
            display.remove(m);
            mags.remove(selected);
        }
    }

    public void add(Magasin m) throws IOException{
        display.add(m);
        mags.add(m);
        m.write();

    }

    public void onClick(Magasin m){
        selected =  m;
    }

    public void setFilter(String filter){
        this.filter = filter;
    }

    public boolean isReadyToFilter(){
        return filter != null;
    }

    public void filter(){
        if(!isReadyToFilter()) return;
        List<Magasin> toDisp = new ArrayList<>();
        Pattern p = Pattern.compile(filter+".*");
        for(Magasin magasin : mags){
            for(MagAttribute selectedAttribute : MagAttribute.values()) {
                if(selectedAttribute.get(magasin)!=null) {
                    Matcher m = p.matcher(selectedAttribute.get(magasin));
                    if (m.matches()){
                        toDisp.add(magasin);
                        break;
                    }
                }
            }
        }
        display.clear();
        display.addAll(toDisp);
        toDisp.clear();
    }

    public void addToDisplay(Magasin magasin){
        if(!display.contains(magasin)){
            display.add(magasin);
        }
    }
}
