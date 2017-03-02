package enseigne.component;

import enseigne.component.magasin.Magasin;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadConst {
    public static final String storePath = "data/enseigne/stores/";
    public static final String actuPath = "data/enseigne/actu/";
    public static  final String imagePath = "data/enseigne/images";


    public static String  fileToString(String path) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(new File(path)));
        StringBuilder res = new StringBuilder();
        String line ="";
        while((line = read.readLine()) != null ){
            res.append(line);
        }
        return res.toString();
    }

    public static List<Magasin> getStoresJson() throws IOException{
        File folder = new File(storePath);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.toString();
                String[] arr = name.split("\\.");
                String ext = "";
                if(arr.length>0) {
                    ext = arr[arr.length - 1];
                }
                if(ext.equals("json")){
                    return true;
                }
                return false;
            }
        };
        List<File> files = Arrays.asList(folder.listFiles(filter));
        List<Magasin> magasins = new ArrayList<>();
        for(File file : files){
            magasins.add(new Magasin(file.toString()));
        }
        return magasins;

    }

    public static Node storeToNode(Magasin m){
        HBox hbox1 = new HBox();
        ImageView p = new ImageView();
        if(m.getPhoto() != null) {
            p.setImage(new Image(new File(m.getPhoto()).toURI().toString()));
            p.setFitWidth(200);
            p.setFitHeight(200);
        }
        VBox vbox2 = new VBox();
        Label label1 = new Label(m.getVille()+", au centre commercial "+m.getCentre());
        Label label2 = new Label(m.getInfoFr());
        Label label3 = new Label("Téléphone : "+m.getTelephone());
        Label label4 = new Label("Site web : "+m.getWeb());
        Label label5 = new Label("Adresse : "+m.getAddr()+"\n"+m.getCodePostal()+" "+m.getVille());
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
