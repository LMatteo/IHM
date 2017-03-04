package enseigne.modele.magasin;

import enseigne.modele.Deletable;
import enseigne.modele.ReadConst;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Magasin extends Deletable {

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

    public Magasin() {
        super.setPath(ReadConst.storePath);
        pointe = new HashMap<>();
        age = new HashMap<>();
    }

    public Magasin(String path) throws IOException{
        super.setPath(ReadConst.storePath);
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
        super.setName(web);
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

    @Override
    public boolean equals(Object mag){
        return mag instanceof Magasin &&
                ((Magasin) mag).web.equals(this.web);
    }

    @Override
    public int hashCode(){
        return web.hashCode();
    }
}
