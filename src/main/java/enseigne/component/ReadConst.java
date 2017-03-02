package enseigne.component;

import enseigne.component.magasin.Magasin;
import javafx.scene.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public static Node storeToNode(Magasin m){
       return null;

    }
}
