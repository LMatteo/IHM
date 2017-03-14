package magasin.modele.BoutiqueInformation;



import magasin.modele.Deletable;
import org.json.JSONObject;

import java.io.*;

/**
 * @author Zaki
 */
public class BoutiqueInformation extends Deletable {

    private String openTime;
    private String closeTime;
    private String descrFr;
    private String descrEng;
    private String pathPic1;
    private String pathPic2;
    private String pathPic3;
    private String pathPic4;
    private String phoneNumber;

    public BoutiqueInformation() {
        super.setPath("/data/magasin/info/");
    }

    public BoutiqueInformation(String path) throws IOException {
        super.setPath(File.separator +"data" + File.separator + "magasin" + File.separator + "product/");
        BufferedReader read = new BufferedReader(new FileReader(new File(path)));
        StringBuilder res = new StringBuilder();
        String line = "";
        while((line = read.readLine()) != null ){
            res.append(line);
        }
        read.close();
        JSONObject json = new JSONObject(res.toString());
        for(BoutiqueInformationHandler handler : BoutiqueInformationAttribute.values()){
            if(json.has(handler.toString())){
                handler.assign(this,json);
            }
        }
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) { this.openTime = openTime; }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getDescrFr() {
        return descrFr;
    }

    public void setDescrFr(String descrFr) {
        this.descrFr = descrFr;
    }

    public String getDescrEng() {
        return descrEng;
    }

    public void setDescrEng(String descrEng) {
        this.descrEng = descrEng;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPathPic1() {
        return pathPic1;
    }

    public void setPathPic1(String pathPic1) {
        this.pathPic1 = pathPic1;
    }

    public String getPathPic2() {
        return pathPic2;
    }

    public void setPathPic2(String pathPic2) {
        this.pathPic2 = pathPic2;
    }

    public String getPathPic3() {
        return pathPic3;
    }

    public void setPathPic3(String pathPic3) {
        this.pathPic3 = pathPic3;
    }

    public String getPathPic4() {
        return pathPic4;
    }

    public void setPathPic4(String pathPic4) {
        this.pathPic4 = pathPic4;
    }

    public void write() throws IOException{
        BufferedWriter bf = new BufferedWriter(
                new FileWriter(new File("data/magasin/info/info.json")));
        JSONObject obj = new JSONObject();
        for(BoutiqueInformationHandler handler : BoutiqueInformationAttribute.values()){
            handler.put(this, obj);
        }
        bf.write(obj.toString());
        bf.close();
    }



}
