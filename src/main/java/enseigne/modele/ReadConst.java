package enseigne.modele;

import enseigne.modele.actu.Actu;
import enseigne.modele.magasin.Magasin;
import enseigne.modele.modele.ActuFilter;
import enseigne.modele.photo.Photo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadConst {
    public static final String storePath = "data/enseigne/stores/";
    public static final String actuPath = "data/enseigne/actu/";
    public static  final String imagePath = "data/enseigne/images";
    public static final String photoPath = "data/enseigne/photo";
    public static final FileFilter filter = new FileFilter() {
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

    public static List<Magasin> getStoreFromJson() throws IOException{
        File folder = new File(storePath);
        List<File> files = Arrays.asList(folder.listFiles(filter));
        List<Magasin> magasins = new ArrayList<>();
        for(File file : files){
            magasins.add(new Magasin(file.toString()));
        }
        return magasins;

    }

    public static List<Actu> getActuFromJson() throws IOException{
        File folder = new File(actuPath);
        List<File> files = Arrays.asList(folder.listFiles(filter));
        List<Actu> magasins = new ArrayList<>();
        for(File file : files){
            magasins.add(new Actu(file.toString()));
        }
        return magasins;

    }

    public static List<Photo> getPhotoFromJson() throws IOException{
        File folder = new File(photoPath);
        List<File> files = Arrays.asList(folder.listFiles(filter));
        List<Photo> magasins = new ArrayList<>();
        for(File file : files){
            magasins.add(new Photo(file.toString()));
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
            mags = getStoreFromJson();
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
