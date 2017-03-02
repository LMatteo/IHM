package enseigne.component;

import enseigne.component.magasin.Magasin;
import javafx.scene.Node;

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

    public static Node storeToNode(Magasin m){
       return null;

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
}
