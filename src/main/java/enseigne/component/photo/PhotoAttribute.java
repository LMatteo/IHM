package enseigne.component.photo;

import org.json.JSONObject;

public enum PhotoAttribute implements PhotoHandler{
    titreFr{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setTitreFr(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getTitreFr());
        }
    },
    titreEn{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setTitreEn(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getTitreEn());
        }
    },
    category{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setCategory(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getCategory());
        }
    },
    photo{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setPhoto(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getPhoto());
        }
    },
    descriptionFr{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setDescriptionFr(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getDescriptionFr());
        }
    },
    descriptionEn{
        @Override
        public void assign(Photo pho, JSONObject json){
            pho.setDescriptionEn(json.getString(toString()));
        }
        @Override
        public void put(Photo pho, JSONObject json){
            json.put(toString(),pho.getDescriptionEn());
        }
    }


}
