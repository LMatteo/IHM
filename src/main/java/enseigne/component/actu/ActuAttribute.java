package enseigne.component.actu;

import org.json.JSONObject;

public enum  ActuAttribute implements ActuHandler{
    titreFr{
        @Override
        public void assign(Actu actu, JSONObject json){
            actu.setTitreFr(json.getString("titreFr"));
        }
        @Override
        public void put(Actu actu, JSONObject json){
            json.put("titreFr",actu.getTitreFr());
        }
    },
    titreEn{
        @Override
        public void assign(Actu actu, JSONObject json){
            actu.setTitreEn(json.getString("titreEn"));
        }
        @Override
        public void put(Actu actu, JSONObject json){
            json.put("titreEn",actu.getTitreEn());
        }
    },
    contentFr{
        @Override
        public void assign(Actu actu, JSONObject json){
            actu.setContentFr(json.getString("contentFr"));
        }
        @Override
        public void put(Actu actu, JSONObject json){
            json.put("contentFr",actu.getContentFr());
        }
    },
    contentEn{
        @Override
        public void assign(Actu actu, JSONObject json){
            actu.setContentEn(json.getString("contentEn"));
        }
        @Override
        public void put(Actu actu, JSONObject json){
            json.put("contentEn",actu.getContentEn());
        }
    },
    image{
        @Override
        public void assign(Actu actu, JSONObject json){
            actu.setImage(json.getString("image"));
        }
        @Override
        public void put(Actu actu, JSONObject json){
            json.put("image",actu.getImage());
        }
    }
}
