package magasin.modele.BoutiqueInformation;

import magasin.modele.BoutiqueInformation.BoutiqueInformation;
import magasin.modele.BoutiqueInformation.BoutiqueInformationHandler;
import org.json.JSONObject;

/**
 * @author Zaki
 */
public enum BoutiqueInformationAttribute implements BoutiqueInformationHandler {

    openTime {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setOpenTime(json.getString("openTime"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("openTime", info.getOpenTime());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getOpenTime();
        }
    },

    closeTime {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setCloseTime(json.getString("closeTime"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("closeTime", info.getCloseTime());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getCloseTime();
        }
    },

    descrFr {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setDescrFr(json.getString("descrFr"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("descrFr", info.getDescrFr());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getDescrFr();
        }
    },

    descrEng {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setDescrEng(json.getString("descEng"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("descEng", info.getDescrEng());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getDescrEng();
        }
    },

    pathPic1 {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setPathPic1(json.getString("pathPic1"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("pathPic1", info.getPathPic1());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getPathPic1();
        }
    },

    pathPic2 {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setPathPic2(json.getString("pathPic2"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("pathPic2", info.getPathPic2());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getPathPic2();
        }
    },

    pathPic3 {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setPathPic3(json.getString("pathPic3"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("pathPic3", info.getPathPic2());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getPathPic3();
        }
    },

    pathPic4 {
        @Override
        public void assign(BoutiqueInformation info, JSONObject json) {
            info.setPathPic4(json.getString("pathPic4"));
        }

        @Override
        public void put(BoutiqueInformation info, JSONObject json) {
            json.put("pathPic4", info.getPathPic4());
        }

        @Override
        public String get(BoutiqueInformation info) {
            return info.getPathPic4();
        }
    },
}