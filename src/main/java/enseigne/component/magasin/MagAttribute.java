package enseigne.component.magasin;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum MagAttribute implements MagHandler {
    infoFr{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setInfoFr(json.getString("infoFr"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("infoFr",mag.getInfoFr());
        }
    },
    nbEmpl{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setNbEmpl(json.getInt("nbEmpl"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("nbEmpl",mag.getNbEmpl());
        }
    },
    web{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setWeb(json.getString("web"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("web",mag.getWeb());
        }
    },
    ChiffreAffaire{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setChiffreAffaire(json.getInt("ChiffreAffaire"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("ChiffreAffaire",mag.getChiffreAffaire());
        }
    },
    photo{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setPhoto(json.getString("photo"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("photo",mag.getPhoto());
        }
    },
    centre{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setCentre(json.getString("centre"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("centre",mag.getCentre());
        }
    },
    pointe{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            json = json.getJSONObject("pointe");
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<25;i++){
                if(json.has(Integer.toString(i))){
                    map.put(i,json.getInt(Integer.toString(i)));
                }
            }
            mag.setPointe(map);
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("pointe",mag.getPointe());
        }
    },
    adresse{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setAddr(json.getString("adresse"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("adresse",mag.getAddr());
        }
    },
    rendu{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setRendu(json.getInt("rendu"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("rendu",mag.getRendu());
        }
    },
    infoEn{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setInfoEn(json.getString("infoEn"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("infoEn",mag.getInfoEn());
        }
    },
    maintenance{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setMaint(json.getInt("maintenance"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("maintenance",mag.getMaint());
        }
    },
    age{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            json = json.getJSONObject("age");
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<25;i++){
                if(json.has(Integer.toString(i))){
                    map.put(i,json.getInt(Integer.toString(i)));
                }
            }
            mag.setAge(map);
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("age",mag.getAge());
        }
    },
    ville{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setVille(json.getString("ville"));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put("ville",mag.getVille());
        }
    },
    codePostal{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setCodePostal(json.getString(this.toString()));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put(this.toString(),mag.getCodePostal());
        }
    },
    telephone{
        @Override
        public void assign(Magasin mag, JSONObject json) {
            mag.setTelephone(json.getString(this.toString()));
        }
        @Override
        public void put(Magasin mag, JSONObject json){
            json.put(this.toString(),mag.getTelephone());
        }
    }
}
