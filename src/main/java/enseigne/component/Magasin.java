package enseigne.component;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Magasin {

    private String photo;
    private String addr;
    private String web;
    private String centre;
    private String info;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
                        new File("data/enseigne/stores/" + web + ".json")));
        JSONObject obj = new JSONObject();
        obj.put("photo",photo);
        obj.put("addresse",addr);
        obj.put("web",web);
        obj.put("centre",centre);
        obj.put("info",info);
        obj.put("chiffreAffaire", chiffreAffaire);
        obj.put("rendu",rendu);
        obj.put("nbEmpl",nbEmpl);
        obj.put("maintenance",maint);
        obj.put("poite",pointe);
        obj.put("age",age);
        bf.write(obj.toString());
        bf.close();

    }
}
