package enseigne.component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class Deletable {
    private String path;
    private String name;
    public void delete(){
        File toDel = new File(path+name+".json");
        try {
            Files.delete(toDel.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setPath(String path) {
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }
}
