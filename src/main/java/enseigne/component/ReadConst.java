package enseigne.component;

import enseigne.component.magasin.Magasin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadConst {
    public static final String storePath = "data/enseigne/stores/";
    public static final String actuPath = "data/enseigne/actu/";
    public static  final String imagePath = "data/enseigne/images";
    public static final String photoPath = "data/enseigne/photo";


    public static String  fileToString(String path) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(new File(path)));
        StringBuilder res = new StringBuilder();
        String line ="";
        while((line = read.readLine()) != null ){
            res.append(line);
        }
        read.close();
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

    /**
     * @return a magasin with the center commercial corresponding with the parameter
     * (the center commercial is unique for each magasin)
     */
    public static Magasin getStoreByCenter(String center){
        List<Magasin> mags = new ArrayList<>();
        try{
            mags = getStoresJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Magasin m : mags){
            if(m.getCentre().equals(center)){
                return m;
            }
        }
        return null;
    }


}
