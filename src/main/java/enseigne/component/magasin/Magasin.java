package enseigne.component.magasin;

import enseigne.component.ReadConst;
import enseigne.component.magasin.MagAttribute;
import enseigne.component.magasin.MagHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Magasin {

    private String photo;
    private String addr;
    private String codePostal;
    private String ville;
    private String web;
    private String centre;
    private String infoFr;
    private String infoEn;
    private String telephone;

    private int chiffreAffaire;
    private int rendu;
    private int nbEmpl;
    private int maint;
    private Map<Integer,Integer> pointe;
    private Map<Integer,Integer> age;

    public Magasin(){
        pointe = new HashMap<>();
        age = new HashMap<>();
    }

    public Magasin(String path) throws IOException{
        JSONObject json = new JSONObject(ReadConst.fileToString(path));
        for(MagHandler handler : MagAttribute.values()){
            if(json.has(handler.toString())){
                handler.assign(this,json);
            }
        }
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getVille() {
            return ville;
        }

    public void setVille(String ville) {
        this.ville = ville;
    }


    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String cp) {
        this.codePostal = cp;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getInfoFr() {
        return infoFr;
    }
    public String getInfoEn() {
        return infoEn;
    }

    public void setInfoFr(String info) {
        this.infoFr = info;
    }
    public void setInfoEn(String info) {
        this.infoEn = info;
    }

    public int getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(int chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getRendu() {
        return rendu;
    }

    public void setRendu(int rendu) {
        this.rendu = rendu;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String tel){
        this.telephone = tel;
    }

    public int getNbEmpl() {
        return nbEmpl;
    }

    public void setNbEmpl(int nbEmpl) {
        this.nbEmpl = nbEmpl;
    }

    public int getMaint() {
        return maint;
    }

    public void setMaint(int maint) {
        this.maint = maint;
    }

    public Map<Integer, Integer> getPointe() {
        return pointe;
    }

    public void setPointe(Map<Integer, Integer> pointe) {
        this.pointe = pointe;
    }

    public Map<Integer, Integer> getAge() {
        return age;
    }

    public void setAge(Map<Integer, Integer> age) {
        this.age = age;
    }

    public void write() throws IOException{

        BufferedWriter bf = new BufferedWriter(
                new FileWriter(
                        new File(ReadConst.storePath + web + ".json")));
        JSONObject obj = new JSONObject();
        for(MagHandler handler : MagAttribute.values()){
            handler.put(this,obj);
        }
        bf.write(obj.toString());
        bf.close();

    }

    public Node toNode(){
        HBox hbox1 = new HBox();
        ImageView p = new ImageView();
        if(getPhoto() != null) {
            p.setImage(new Image(new File(getPhoto()).toURI().toString()));
            p.setFitWidth(200);
            p.setFitHeight(200);
        }
        VBox vbox2 = new VBox();
        Label label1 = new Label(getVille()+", au centre commercial "+getCentre());
        Label label2 = new Label(getInfoFr());
        Label label3 = new Label("Téléphone : "+getTelephone());
        Label label4 = new Label("Site web : "+getWeb());
        Label label5 = new Label("Adresse : "+getAddr()+"\n"+getCodePostal()+" "+getVille());
        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(label3,label4);

        vbox2.getChildren().add(label1);
        vbox2.getChildren().add(label2);
        vbox2.getChildren().add(hbox3);
        vbox2.getChildren().add(label5);


        hbox1.getChildren().add(p);
        hbox1.getChildren().add(vbox2);

        return hbox1;
    }
}
