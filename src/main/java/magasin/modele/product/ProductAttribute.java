package magasin.modele.product;

import org.json.JSONObject;

/**
 * @author Zaki
 */
public enum ProductAttribute implements ProductHandler{

    nom{
        @Override
        public void assign(Product prod, JSONObject json) {
            prod.setName(json.getString("nom"));
        }
        @Override
        public void put(Product prod, JSONObject json){
            json.put("nom",prod.getName());
        }
        @Override
        public String get(Product prod){return prod.getName();}
    },

    ref{
        @Override
        public void assign(Product prod, JSONObject json) {
            prod.setRef(json.getString("ref"));
        }
        @Override
        public void put(Product prod, JSONObject json){
            json.put("ref",prod.getRef());
        }
        @Override
        public String get(Product prod){return prod.getRef();}
    },

    description{
        @Override
        public void assign(Product prod, JSONObject json) {
            prod.setDescription(json.getString("description"));
        }
        @Override
        public void put(Product prod, JSONObject json){
            json.put("description",prod.getDescription());
        }
        @Override
        public String get(Product prod){return prod.getDescription();}
    },

    type{
        @Override
        public void assign(Product prod, JSONObject json) {
            prod.setType(json.getString("type"));
        }
        @Override
        public void put(Product prod, JSONObject json){
            json.put("type",prod.getType());
        }
        @Override
        public String get(Product prod){return prod.getType();}
    },

    photo{
        @Override
        public void assign(Product prod, JSONObject json) {
            prod.setPhoto(json.getString("photo"));
        }
        @Override
        public void put(Product prod, JSONObject json){
            json.put("photo",prod.getPhoto());
        }
        @Override
        public String get(Product prod){return prod.getPhoto();}
    },
}
